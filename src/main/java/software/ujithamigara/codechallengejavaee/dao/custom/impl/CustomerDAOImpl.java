package software.ujithamigara.codechallengejavaee.dao.custom.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.ujithamigara.codechallengejavaee.dao.custom.CustomerDAO;
import software.ujithamigara.codechallengejavaee.entity.Customer;
import software.ujithamigara.codechallengejavaee.util.HibernateUtil;

import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    private static final String GET_ALL_CUSTOMER = "FROM Customer";
    private final SessionFactory sessionFactory;
    final static Logger logger = LoggerFactory.getLogger(ItemDAOImpl.class);
    public CustomerDAOImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public List<Customer> getAll() throws Exception {
        try (Session session = sessionFactory.openSession()) {
            List<Customer> customers = session.createQuery(GET_ALL_CUSTOMER, Customer.class).list();
            logger.info("All customers retrieved successfully !");
            return customers;
        } catch (Exception e) {
            logger.error("Error in getAll in CustomerDAOImpl class");
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean save(Customer customer) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(customer);
            transaction.commit();
            logger.info("Customer Data Saved Successfully !");
            return true;
        } catch (Exception e) {
            logger.error("Error occurred while saving customer !");
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Customer customer) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(customer);
            transaction.commit();
            logger.info("Customer Data Updated Successfully !");
            return true;
        } catch (Exception e) {
            logger.error("Error occurred while updating customer !");
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(String id) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            if (customer != null) {
                session.remove(customer);
                transaction.commit();
                logger.info("Customer Data Deleted Successfully !");
                return true;
            } else {
                logger.error("Customer Data Not Found !");
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer get(String id) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            Customer customer = session.get(Customer.class, id);
            logger.info("Customer Data Retrieved Successfully !");
            return customer;
        } catch (Exception e) {
            logger.error("Error occurred while retrieving customer !");
            throw new RuntimeException(e);
        }
    }


}
