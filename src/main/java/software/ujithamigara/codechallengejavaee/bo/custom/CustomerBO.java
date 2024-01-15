package software.ujithamigara.codechallengejavaee.bo.custom;


import software.ujithamigara.codechallengejavaee.DTO.CustomerDTO;
import software.ujithamigara.codechallengejavaee.bo.SuperBO;

import java.util.List;

public interface CustomerBO extends SuperBO {
    List<CustomerDTO> getAllCustomers() throws Exception;
    boolean saveCustomer(CustomerDTO dto) throws Exception;
    boolean updateCustomer(CustomerDTO dto) throws Exception;
    boolean deleteCustomer(String id) throws Exception;
    CustomerDTO getCustomer(String id) throws Exception;
}
