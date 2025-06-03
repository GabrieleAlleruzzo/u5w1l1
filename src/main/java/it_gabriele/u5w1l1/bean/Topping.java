package it_gabriele.u5w1l1.bean;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class Topping extends Prodotto {
    private boolean glutenfree;
    }
