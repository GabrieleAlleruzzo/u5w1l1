package it_gabriele.u5w1l1.bean;

import it_gabriele.u5w1l1.Enumeration.StatoTavolo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Tavolo {
    private int numero;
    private int numeroMaxCoperti;
    private StatoTavolo statoTavolo;
    private double costoCoperto;
}