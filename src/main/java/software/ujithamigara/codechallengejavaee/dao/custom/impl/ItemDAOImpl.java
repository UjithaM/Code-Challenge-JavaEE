package software.ujithamigara.codechallengejavaee.dao.custom.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.ujithamigara.codechallengejavaee.dao.custom.ItemDAO;
import software.ujithamigara.codechallengejavaee.entity.Item;
import software.ujithamigara.codechallengejavaee.util.HibernateUtil;

import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    private static final String GET_ALL_ITEM_DATA = "FROM Item";
    private final SessionFactory sessionFactory;
    final static Logger logger = LoggerFactory.getLogger(ItemDAOImpl.class);
    public ItemDAOImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
    @Override
    public List<Item> getAll() throws Exception {
        try (Session session = sessionFactory.openSession()) {
            List<Item> items = session.createQuery(GET_ALL_ITEM_DATA, Item.class).list();
            logger.info("All items retrieved successfully !");
            return items;
        } catch (Exception e) {
            logger.error("Error in getAll in ItemDAOImpl class");
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean save(Item item) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(item);
            transaction.commit();
            logger.info("Item saved successfully !");
            return true;
        } catch (Exception e) {
            logger.error("Error occurred while saving item !");
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Item item) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(item);
            transaction.commit();
            logger.info("Item updated successfully !");
            return true;
        } catch (Exception e) {
            logger.error("Error occurred while updating item !");
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
                logger.info("Item deleted successfully !");
                return true;
            } else {
                logger.error("Item not found !");
                return false;
            }
        } catch (Exception e) {
            logger.error("Error occurred while deleting item !");
            throw new RuntimeException(e);
        }
    }

    @Override
    public Item get(String id) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            Item item = session.get(Item.class, id);
            logger.info("Item retrieved successfully !");
            return item;
        } catch (Exception e) {
            logger.error("Error occurred while getting item !");
            throw new RuntimeException(e);
        }
    }
}
