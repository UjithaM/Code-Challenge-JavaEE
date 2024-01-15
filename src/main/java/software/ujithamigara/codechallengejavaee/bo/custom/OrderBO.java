package software.ujithamigara.codechallengejavaee.bo.custom;

import software.ujithamigara.codechallengejavaee.DTO.OrderDTO;
import software.ujithamigara.codechallengejavaee.bo.SuperBO;

import java.util.List;

public interface OrderBO extends SuperBO {
    List<OrderDTO> getAllOrders() throws Exception;
    boolean saveOrder(OrderDTO dto) throws Exception;
}
