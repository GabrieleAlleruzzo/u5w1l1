package it_gabriele.u5w1l1;

import it_gabriele.u5w1l1.Enumeration.StatoOrdine;
import it_gabriele.u5w1l1.bean.*;
import it_gabriele.u5w1l1.configuration.AppConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;

@Component //permette a spring di gestire interamente la classe
@Order(1) //nel caso di più runner indico che questo è il primo 
 class Runner implements CommandLineRunner {
        @Override
        public void run(String... args) throws Exception {
            //serve per accedere al contesto di Spring
            AnnotationConfigApplicationContext ctx =
                    new AnnotationConfigApplicationContext(U5w1l1Application.class);
            //abbiamo recuperato dal contesto di Spring un oggetto di tipo Drink
            Menu menu = ctx.getBean(Menu.class);
            menu.stampaMenu();

            Ordine o1 = new Ordine();
            o1.setNumOrdine(1);
            o1.setNumCoperti(4);
            o1.setOraOrdine(LocalTime.of(21,0,0));
            o1.setStatoOrdine(StatoOrdine.IN_CORSO);
            o1.setTavolo(ctx.getBean("t1", Tavolo.class));
            o1.setProdotti(List.of(ctx.getBean("water", Drink.class),
                    ctx.getBean("cocaCola", Drink.class),
                    ctx.getBean("margherita", Pizza.class),
                    ctx.getBean("primavera", Pizza.class),
                    ctx.getBean("primavera", Pizza.class)));

            System.out.println(o1);

            System.out.println(o1.totaleOrdine());

        /*
        //cambia contenuto tonde in classe contenente il main perché abbiamo aggiunto component e auto gnerate a delle classi
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5w1l1Application.class); //nelle tonde la classe che configura i beans

        //adesso chiamiamo gli oggetti
        Drink water = ctx.getBean(Drink.class);

        //chiedo la stampa di un singolo oggetto di una singola classe
        System.out.println(water);

        //se non scrivo @Primary in un metodo oggetto apaprtenente alla classe avrò un errore quando scrivo
        Topping t1 = ctx.getBean(Topping.class);

        //dopo avere dato un name al bean posso usare il nome per scegliere quale stampare
        Topping t2 =ctx.getBean("tomato", Topping.class);
        System.out.println(t1);
        System.out.println(t2);

        Pizza pizza1 = ctx.getBean(Pizza.class);
        System.out.println(pizza1); */
    }
    }

