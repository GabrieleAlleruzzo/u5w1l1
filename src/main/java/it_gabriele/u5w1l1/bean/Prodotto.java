package it_gabriele.u5w1l1.bean;

import it_gabriele.u5w1l1.Enumeration.TipoDrink;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

// crea tutti i metodi di cui abbaimo bisogno
@Data
// crea il costruttore vuoto (no arguments)
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Prodotto {

    @Id
    @GeneratedValue
    private int id;

    private String nome;
    private double prezzo;
    private int calorie;

    public void setTipoDrink(TipoDrink tipoDrink) {
    }

    public void setGlutenFree(boolean b) {
    }
}
