package it_gabriele.u5w1l1.bean;

import it_gabriele.u5w1l1.Enumeration.TipoDrink;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(callSuper = true) //chiama il toString super quando stampi questa classe
@Entity
public class Drink extends Prodotto{
    private TipoDrink drink;

}
