package software.ujithamigara.codechallengejavaee.bo.custom.Impl;


import software.ujithamigara.codechallengejavaee.DTO.CustomerDTO;
import software.ujithamigara.codechallengejavaee.bo.custom.CustomerBO;

import java.util.List;


public class CustomerBOImpl implements CustomerBO {


    @Override
    public List<CustomerDTO> getAllCustomers() throws Exception {
        return null;
    }

    @Override
    public boolean saveCustomer(CustomerDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean deleteCustomer(String id) throws Exception {
        return false;
    }
}
