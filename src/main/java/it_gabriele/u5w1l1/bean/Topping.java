package it_gabriele.u5w1l1.bean;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
public class Topping extends Prodotto {
    private boolean glutenfree;
    @ManyToMany
    @JoinTable(name = "topping_pizza",
            joinColumns = @JoinColumn(name = "topping_id"),
            inverseJoinColumns = @JoinColumn(name = "pizza_id"))
    private List<Pizza> pizze;
    }
