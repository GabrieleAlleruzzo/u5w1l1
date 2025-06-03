package it_gabriele.u5w1l1;

import it_gabriele.u5w1l1.bean.Drink;
import it_gabriele.u5w1l1.bean.Topping;
import it_gabriele.u5w1l1.configuration.AppConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component //permette a spring di gestire interamente la classe
@Order(1) //nel caso di più runner indico che questo è il primo 
 class Runner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        //dobbiamo richiamare il contesto da cui prendere gli oggetti quindi useremo
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class); //nelle tonde la classe che configura i beans

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
    }
    }

