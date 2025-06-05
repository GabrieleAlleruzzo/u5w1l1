package it_gabriele.u5w1l1.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
//@Component
@Entity

public class Pizza extends Prodotto{
    //@Autowired
    @ManyToMany(mappedBy = "pizze")
    private List<Topping> toppings;

   /* @Autowired(required = false)
    public Pizza(List<Topping> toppings) {
        this.toppings = toppings;
    }
    @Autowired(required = false)
    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    } */
}
