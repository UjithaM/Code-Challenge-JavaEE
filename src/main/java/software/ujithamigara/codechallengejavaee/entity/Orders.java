package software.ujithamigara.codechallengejavaee.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @Id
    private String orderId;
    private String date;
    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    private Customer customer;
    private Double netTotal;
    private Integer discount;
    private Double cash;
    private Double subTotal;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "orders", cascade = CascadeType.ALL) @Fetch(FetchMode.JOIN)
    @JsonManagedReference
    private List<OrderItem> orderItems;
}
