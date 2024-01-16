package software.ujithamigara.codechallengejavaee.bo.custom.Impl;


import software.ujithamigara.codechallengejavaee.DTO.OrderDTO;
import software.ujithamigara.codechallengejavaee.bo.custom.OrderBO;
import software.ujithamigara.codechallengejavaee.dao.DAOFactory;
import software.ujithamigara.codechallengejavaee.dao.custom.OrderDAO;
import software.ujithamigara.codechallengejavaee.entity.Orders;
import software.ujithamigara.codechallengejavaee.util.Convert;

import java.util.ArrayList;
import java.util.List;

public class OrderBOImpl implements OrderBO {
    OrderDAO orderDao = (OrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER);

    @Override
    public List<OrderDTO> getAllOrders() throws Exception {
        List<Orders> ordersList =orderDao.getAll();
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for (Orders orders : ordersList) {
            orderDTOList.add(Convert.ordersEntityToDto(orders));
        }
        return orderDTOList;
    }

    @Override
    public boolean saveOrder(OrderDTO dto) throws Exception {
        return orderDao.save(Convert.ordersDTOToOder(dto));
    }

    @Override
    public boolean deleteOrder(String orderId) throws Exception {
        return orderDao.delete(orderId);
    }

    @Override
    public boolean updateOrder(OrderDTO dto) throws Exception {
        return orderDao.update(Convert.ordersDTOToOder(dto));
    }

    @Override
    public OrderDTO getOrder(String orderId) throws Exception {
        return Convert.ordersEntityToDto(orderDao.get(orderId));
    }
}
