package it_gabriele.u5w1l1.configuration;

import it_gabriele.u5w1l1.Enumeration.StatoTavolo;
import it_gabriele.u5w1l1.Enumeration.TipoDrink;
import it_gabriele.u5w1l1.bean.Drink;
import it_gabriele.u5w1l1.bean.Pizza;
import it_gabriele.u5w1l1.bean.Tavolo;
import it_gabriele.u5w1l1.bean.Topping;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Configuration
@PropertySource("application.properties")
public class AppConfig {

    //nei Bean possiamo creare un oggetto
    //permette di salvare l'oggetto in Spring
    @Bean(name="water")
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
    @Bean("cocaCola")
    public Drink getCocaCola(){
        Drink cocaCola = new Drink();
        cocaCola.setNome("coca cola");
        cocaCola.setCalorie(400);
        cocaCola.setPrezzo(2);
        cocaCola.setTipoDrink(TipoDrink.ANALCOLICO);
        return cocaCola;
    }
    @Bean("prosciuttoCotto")
    public Topping getProsciuttoCotto(){
        Topping prosciuttoCotto = new Topping();
        prosciuttoCotto.setNome("prosciutto cotto");
        prosciuttoCotto.setGlutenFree(true);
        prosciuttoCotto.setCalorie(200);
        prosciuttoCotto.setPrezzo(2);
        return prosciuttoCotto;
    }

    @Bean("margherita")
    public Pizza getMargherita(){
        Pizza margherita = new Pizza();
        margherita.setNome("margherita");
        margherita.setCalorie(500);
        margherita.setPrezzo(5);
        margherita.setToppings(List.of(getMozzarella(), getTomato()));
        return margherita;
    }
    @Bean("primavera")
    public Pizza getPrimavera(){
        Pizza primavera = new Pizza();
        primavera.setNome("primavera");
        primavera.setPrezzo(6);
        primavera.setCalorie(600);
        primavera.setToppings(List.of(getMozzarella(),getTomato(),getProsciuttoCotto()));
        return primavera;
    }

    @Bean("t1")
    public Tavolo getTavolo1(@Value("${tavolo1.coperto}") double costoCoperto){
        Tavolo t1 = new Tavolo();
        t1.setCostoCoperto(costoCoperto);
        t1.setStatoTavolo(StatoTavolo.LIBERO);
        t1.setNumero(1);
        t1.setNumeroMaxCoperti(6);
        return t1;
    }
    @Bean("t2")
    public Tavolo getTavolo2(@Value("${tavolo2.coperto}") double costoCoperto){
        Tavolo t2 = new Tavolo();
        t2.setNumero(2);
        t2.setNumeroMaxCoperti(4);
        t2.setStatoTavolo(StatoTavolo.LIBERO);
        t2.setCostoCoperto(costoCoperto);
        return t2;
    }
}