package software.ujithamigara.codechallengejavaee.bo.custom;

import software.ujithamigara.codechallengejavaee.DTO.OrderDTO;
import software.ujithamigara.codechallengejavaee.bo.SuperBO;

import java.util.List;
import java.util.stream.Stream;

public interface OrderBO extends SuperBO {
    List<OrderDTO> getAllOrders() throws Exception;
    boolean saveOrder(OrderDTO dto) throws Exception;
    boolean deleteOrder(String orderId) throws Exception;
    boolean updateOrder(OrderDTO dto) throws Exception;
    OrderDTO getOrder(String orderId) throws Exception;
}
