package software.ujithamigara.codechallengejavaee.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.ujithamigara.codechallengejavaee.entity.OrderItem;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private String orderId;
    private String date;
    private String customerId;
    private Double netTotal;
    private Integer discount;
    private Double cash;
    private Double subTotal;
    private List<OrderItem> orderItems;
}
