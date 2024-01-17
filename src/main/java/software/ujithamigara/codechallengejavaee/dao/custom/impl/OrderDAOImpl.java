package software.ujithamigara.codechallengejavaee.dao.custom.impl;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.ujithamigara.codechallengejavaee.dao.custom.OrderDAO;
import software.ujithamigara.codechallengejavaee.entity.OrderItem;
import software.ujithamigara.codechallengejavaee.entity.Orders;
import software.ujithamigara.codechallengejavaee.util.HibernateUtil;

import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    private static final String GET_ALL_ORDER_DATA = "FROM Orders";
    private final SessionFactory sessionFactory;
    final static Logger logger = LoggerFactory.getLogger(ItemDAOImpl.class);
    public OrderDAOImpl() {

        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
    @Override
    public List<Orders> getAll() throws Exception {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();

            List<Orders> orders = session.createQuery(GET_ALL_ORDER_DATA, Orders.class).list();
            System.out.println(orders.size());

            for (Orders order : orders) {
                Hibernate.initialize(order.getOrderItems());
            }

            tx.commit();
            logger.info("All orders retrieved successfully !");
            return orders;
        } catch (Exception e) {
            logger.error("Error in getAll in OrderDAOImpl class");
            throw new RuntimeException("Error retrieving orders", e);
        }
    }



    @Override
    public boolean save(Orders orders) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            try {

                session.persist(orders);

                for (OrderItem orderItem : orders.getOrderItems()) {
                    orderItem.setOrders(orders);
                    session.persist(orderItem);
                }

                transaction.commit();
                logger.info("Order saved successfully !");
                return true;
            } catch (Exception e) {
                logger.error("Error occurred while saving order !");
                transaction.rollback();
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Orders orders) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Orders existingOrder = session.get(Orders.class, orders.getOrderId());

            if (existingOrder == null) {
                throw new IllegalArgumentException("Order with id " + orders.getOrderId() + " not found");
            }

            existingOrder.setDate(orders.getDate());
            existingOrder.setCustomer(orders.getCustomer());
            existingOrder.setNetTotal(orders.getNetTotal());
            existingOrder.setDiscount(orders.getDiscount());
            existingOrder.setCash(orders.getCash());
            existingOrder.setSubTotal(orders.getSubTotal());

            for (OrderItem updatedOrderItem : orders.getOrderItems()) {
                updatedOrderItem.setOrders(existingOrder);
                session.merge(updatedOrderItem);
            }

            existingOrder.getOrderItems().clear();

            existingOrder.getOrderItems().addAll(orders.getOrderItems());

            session.merge(existingOrder);

            transaction.commit();
            logger.info("Order updated successfully !");
            return true;
        } catch (Exception e) {
            logger.error("Error occurred while updating order !");
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(String id) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Orders orders = session.get(Orders.class, id);
            if (orders != null) {
                session.remove(orders);
                transaction.commit();
                logger.info("Order deleted successfully !");
                return true;
            } else {
                logger.error("Order not found !");
                return false;
            }
        } catch (Exception e) {
            logger.error("Error occurred while deleting order !");
            throw new RuntimeException(e);
        }
    }

    @Override
    public Orders get(String id) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            Orders orders = session.get(Orders.class, id);
            Hibernate.initialize(orders.getOrderItems());
            logger.info("Order retrieved successfully !");
            return orders;
        } catch (Exception e) {
            logger.error("Error occurred while getting order !");
            throw new RuntimeException(e);
        }
    }
}
