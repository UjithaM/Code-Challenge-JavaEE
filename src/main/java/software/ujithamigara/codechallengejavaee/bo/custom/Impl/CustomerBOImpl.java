package software.ujithamigara.codechallengejavaee.bo.custom.Impl;


import software.ujithamigara.codechallengejavaee.DTO.CustomerDTO;
import software.ujithamigara.codechallengejavaee.bo.custom.CustomerBO;
import software.ujithamigara.codechallengejavaee.dao.DAOFactory;
import software.ujithamigara.codechallengejavaee.dao.custom.CustomerDAO;
import software.ujithamigara.codechallengejavaee.entity.Customer;
import software.ujithamigara.codechallengejavaee.util.Convert;

import java.util.ArrayList;
import java.util.List;


public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    @Override
    public List<CustomerDTO> getAllCustomers() throws Exception {
        List<Customer> customers =customerDAO.getAll();
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for (Customer customer : customers) {
            customerDTOS.add(Convert.customerEntityToDto(customer));
        }
        return customerDTOS;
    }

    @Override
    public boolean saveCustomer(CustomerDTO dto) throws Exception {
        return customerDAO.save(Convert.customerDTOToEntity(dto, null));
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws Exception {
        return customerDAO.update(Convert.customerDTOToEntity(dto, null));
    }

    @Override
    public boolean deleteCustomer(String id) throws Exception {
        return customerDAO.delete(id);
    }

    @Override
    public CustomerDTO getCustomer(String id) throws Exception {
        return Convert.customerEntityToDto(customerDAO.get(id));
    }
}
