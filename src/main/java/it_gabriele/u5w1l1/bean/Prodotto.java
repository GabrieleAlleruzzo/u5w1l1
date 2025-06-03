package it_gabriele.u5w1l1.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

// crea tutti i metodi di cui abbaimo bisogno
@Data
// crea il costruttore vuoto (no arguments)
@NoArgsConstructor
public abstract class Prodotto {
    private String nome;
    private double prezzo;
    private int calorie;
}
