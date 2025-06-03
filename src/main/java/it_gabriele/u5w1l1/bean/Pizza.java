package it_gabriele.u5w1l1.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class Pizza extends Prodotto{
    private List<Topping> toppings;
}
