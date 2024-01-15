package software.ujithamigara.codechallengejavaee.dao.custom.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import software.ujithamigara.codechallengejavaee.dao.custom.ItemDAO;
import software.ujithamigara.codechallengejavaee.entity.Item;
import software.ujithamigara.codechallengejavaee.util.HibernateUtil;

import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    private static final String GET_ALL_ITEM_DATA = "FROM Item";
    private final SessionFactory sessionFactory;
    public ItemDAOImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
    @Override
    public List<Item> getAll() throws Exception {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery(GET_ALL_ITEM_DATA, Item.class).list();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean save(Item item) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(item);
            transaction.commit();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Item item) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(item);
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
            Item item = session.get(Item.class, id);
            if (item != null) {
                session.remove(item);
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
    public Item get(String id) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Item.class, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
