package software.ujithamigara.codechallengejavaee.dao.custom.impl;

import software.ujithamigara.codechallengejavaee.dao.custom.OrderDAO;
import software.ujithamigara.codechallengejavaee.entity.Orders;

import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public List<Orders> getAll() throws Exception {
        return null;
    }

    @Override
    public boolean save(Orders orders) throws Exception {
        return false;
    }

    @Override
    public boolean update(Orders orders) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public Orders get(String id) throws Exception {
        return new Orders();
    }
}
