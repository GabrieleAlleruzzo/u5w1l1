package it_gabriele.u5w1l1.configuration;

import it_gabriele.u5w1l1.Enumeration.TipoDrink;
import it_gabriele.u5w1l1.bean.Drink;
import it_gabriele.u5w1l1.bean.Topping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

    //nei Bean possiamo creare un oggetto
    //permette di salvare l'oggetto in Spring
    @Bean
    public Drink getWater () {
        Drink water = new Drink();
        water.setDrink(TipoDrink.ANALCOLICO);
        water.setCalorie(0);
        water.setPrezzo(1);
        water.setNome("Water");
        return water;
    }
    @Bean(name="tomato")
    public Topping getTomato () {
        Topping tomato = new Topping();
        tomato.setCalorie(10);
        tomato.setPrezzo(1);
        tomato.setNome("Tomato");
        tomato.setGlutenfree(false);
        return tomato;
    }
    @Bean(name="mozzarella")
    @Primary // se ho due oggetti creati dalla stessa classe verra stamapto in console solo questo (al posto di un errore chilometrico)
    public Topping getMozzarella () {
        Topping mozzarella = new Topping();
        mozzarella.setCalorie(20);
        mozzarella.setPrezzo(2);
        mozzarella.setNome("Mozzarella");
        mozzarella.setGlutenfree(false);
        return mozzarella;
    }
}