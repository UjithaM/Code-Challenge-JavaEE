package software.ujithamigara.codechallengejavaee.util;



import software.ujithamigara.codechallengejavaee.DTO.CustomerDTO;
import software.ujithamigara.codechallengejavaee.DTO.ItemDTO;
import software.ujithamigara.codechallengejavaee.DTO.OrderDTO;
import software.ujithamigara.codechallengejavaee.entity.Customer;
import software.ujithamigara.codechallengejavaee.entity.Item;
import software.ujithamigara.codechallengejavaee.entity.OrderItem;
import software.ujithamigara.codechallengejavaee.entity.Orders;

import java.util.ArrayList;
import java.util.List;

public class Convert {

    public static Customer customerDTOToEntity(CustomerDTO dto, List<Orders> orderItems){
        return new Customer(dto.getCustomerId(), dto.getFullName(), dto.getAddress(), orderItems);
    }
    public static CustomerDTO customerEntityToDto(Customer customer){
        return new CustomerDTO(customer.getCustomerId(), customer.getFullName(), customer.getAddress());
    }


    public static Item itemDTOToEntity(ItemDTO dto, List<OrderItem> orderItems){
        return new Item(dto.getItemId(), dto.getDescription(), dto.getUnitPrice(), dto.getQty(), orderItems);
    }
    public static ItemDTO itemEntityToDto(Item item){
        return new ItemDTO(item.getItemId(), item.getDescription(), item.getUnitPrice(), item.getQty());
    }


    public static Orders ordersDTOToOder(OrderDTO dto){
        Customer customer = new Customer();
        customer.setCustomerId(dto.getCustomerId());
        return new Orders(dto.getOrderId(), dto.getDate(), customer, dto.getNetTotal(), dto.getDiscount(), dto.getCash(), dto.getSubTotal(), dto.getOrderItems());
    }
    public static OrderDTO ordersEntityToDto(Orders orders){
        return new OrderDTO(orders.getOrderId(), orders.getDate(), orders.getCustomer().getCustomerId(), orders.getNetTotal(), orders.getDiscount(), orders.getCash(), orders.getSubTotal(), orders.getOrderItems());
    }
}
