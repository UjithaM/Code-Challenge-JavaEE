package software.ujithamigara.codechallengejavaee.dao.custom.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import software.ujithamigara.codechallengejavaee.dao.custom.CustomerDAO;
import software.ujithamigara.codechallengejavaee.entity.Customer;

import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    private static final String GET_ALL_CUSTOMER = "FROM Customer";
    private final SessionFactory sessionFactory;
    public CustomerDAOImpl() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    @Override
    public List<Customer> getAll() throws Exception {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery(GET_ALL_CUSTOMER, Customer.class).list();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean save(Customer customer) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(customer);
            transaction.commit();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Customer customer) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(customer);
            transaction.commit();
            return true;
        } catch (Exception e) {
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
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer get(String id) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Customer.class, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
