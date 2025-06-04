package it_gabriele.u5w1l1;

import it_gabriele.u5w1l1.bean.Drink;
import it_gabriele.u5w1l1.bean.Menu;
import it_gabriele.u5w1l1.bean.Pizza;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class U5w1l1ApplicationTests {
	private static AnnotationConfigApplicationContext ctx;

	@BeforeAll //Avvia un ambiente Spring completo, come se fosse l'app vera
	public static void creaContesto() { // è una classe che crea un contesto Spring a partire da una configurazione basata su annotazioni
		ctx = new AnnotationConfigApplicationContext(U5w1l1Application.class);
	}

	@BeforeEach
	public void PrimaDelTest(){
		System.out.println("Start test");
	}



	@Test
	public void verificaNumeroPizze() {
	Menu menu = ctx.getBean(Menu.class);

	long countPizze= menu.getProdotti().stream().filter(prodotto -> prodotto instanceof Pizza).count();
		Assertions.assertAll(
				()->Assertions.assertEquals(2, countPizze));
	}
	@Test
	public void verificaNumeroDrink() {
		Menu menu = ctx.getBean(Menu.class);

		long countDrink= menu.getProdotti().stream().filter(prodotto -> prodotto instanceof Drink).count();
		Assertions.assertAll(
				()->Assertions.assertEquals(2, countDrink));
	}

	@ParameterizedTest
	@ValueSource(strings = {"tomato", "prosciutto", "salame"})
	public void verificaBeanEsistenti(String topping){

		Menu menu = ctx.getBean(Menu.class);
		boolean exist = menu.getProdotti().stream().anyMatch(prodotto -> prodotto.getNome().equalsIgnoreCase(topping));
		Assertions.assertTrue(exist);
	}

	@AfterEach
	public void DopoIlTest(){
		System.out.println("fine test");
	}

	@AfterAll
	public static void chiudiContesto(){
		ctx.close();
	}

}
