package software.ujithamigara.codechallengejavaee.dao.custom.impl;

import software.ujithamigara.codechallengejavaee.dao.custom.CustomerDAO;
import software.ujithamigara.codechallengejavaee.entity.Customer;

import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public List<Customer> getAll() throws Exception {
        return null;
    }

    @Override
    public boolean save(Customer customer) throws Exception {
        return false;
    }

    @Override
    public boolean update(Customer customer) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }
}
