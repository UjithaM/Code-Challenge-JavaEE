package software.ujithamigara.codechallengejavaee.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    private String itemId;
    private String description;
    private double unitPrice;
    private int qty;

    @OneToMany (mappedBy = "item", cascade = CascadeType.ALL)
    private List<OrderItem> orders;
}
