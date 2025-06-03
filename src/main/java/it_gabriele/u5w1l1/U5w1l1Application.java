package it_gabriele.u5w1l1;

import it_gabriele.u5w1l1.bean.Drink;
import it_gabriele.u5w1l1.bean.Topping;
import it_gabriele.u5w1l1.configuration.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class U5w1l1Application {

	public static void main(String[] args) {
		//non cancellare mai sta roba
		SpringApplication.run(U5w1l1Application.class, args); //non toccare
	/*
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
		System.out.println(t2);*/
	}

}
