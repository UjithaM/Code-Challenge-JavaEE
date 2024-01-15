package software.ujithamigara.codechallengejavaee.bo.custom.Impl;


import software.ujithamigara.codechallengejavaee.DTO.OrderDTO;
import software.ujithamigara.codechallengejavaee.bo.custom.OrderBO;

import java.util.List;

public class OrderBOImpl implements OrderBO {

    @Override
    public List<OrderDTO> getAllOrders() throws Exception {
        return null;
    }

    @Override
    public boolean saveOrder(OrderDTO dto) throws Exception {
        return false;
    }
}
