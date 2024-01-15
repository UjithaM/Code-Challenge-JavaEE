package software.ujithamigara.codechallengejavaee.dao.custom.impl;

import software.ujithamigara.codechallengejavaee.dao.custom.ItemDAO;
import software.ujithamigara.codechallengejavaee.entity.Item;

import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public List<Item> getAll() throws Exception {
        return null;
    }

    @Override
    public boolean save(Item item) throws Exception {
        return false;
    }

    @Override
    public boolean update(Item item) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }
}
