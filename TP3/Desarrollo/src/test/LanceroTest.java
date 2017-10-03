package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import infanteria.Caballero;
import infanteria.Capa;
import infanteria.Escudo;
import infanteria.Lancero;
import infanteria.Puñal;
import infanteria.Soldado;
import infanteria.Unidad;

public class LanceroTest {
	private Unidad lancero;
	/**
	 * Test lancero ataca a otras unidades
	 * 
	 * LANCERO:
	 * Salud = 150
	 * Puntos de daño = 25
	 * Distancia para atacar = entre 1 y 3
	 * 
	 * ADICIÓN DE ITEMS:
	 * 
	 * PUÑAL:
	 * Puntos de daño = +3
	 * Recibir ataque = ataque del enemigo +3
	 * 
	 * CAPA:
	 * No tiene efecto sobre esta unidad. 
	 * 
	 * ESCUDO:
	 * Recibir ataque = Recibirá solo el 40% del ataque del oponente
	 * 
	 */
	
	@Before
	public void inicializarLancero() {
		lancero = new Lancero();
	}

	/** ATAQUE SIN ITEMS */
	 /** Se testea que un lancero ataque con 25 a otra unidad*/
	@Test
	public void queAtaqueCon25() {
		Unidad objetivo = new Caballero();
		Assert.assertEquals(200,objetivo.getSalud());
		lancero.atacar(objetivo, 2);
		Assert.assertEquals(175,objetivo.getSalud());
	}
	
	
	/** ATAQUE CON PUÑAL */ 
	/** Se testea que ataque con 28 a otra unidad */
	@Test
	public void queAtaqueCon28() {
		Unidad objetivo = new Soldado();
		Assert.assertEquals(200,objetivo.getSalud());
		lancero = new Puñal(lancero);
		lancero.atacar(objetivo, 3);
		Assert.assertEquals(172,objetivo.getSalud());
	}
	
	/** ATAQUE CON CAPA */
	/** Se testea que la capa no tenga efecto */
	@Test
	public void queNoReduzcaAtaque() {
		Unidad objetivo = new Soldado();
		Assert.assertEquals(200,objetivo.getSalud());
		lancero = new Capa(lancero);
		lancero.atacar(objetivo, 3);
		Assert.assertEquals(175,objetivo.getSalud());
	}
	
	/** ATAQUE CON ESCUDO */ 
	/** Se testea que solo reciba el 40% del ataque */
	@Test
	public void quePierda10DeSalud() { 
		Unidad enemigo = new Lancero();
		Assert.assertEquals(150, lancero.getSalud());
		lancero = new Escudo(lancero);
		enemigo.atacar(lancero, 2);
		Assert.assertEquals(140, lancero.getSalud());	
	}
	
	/** DISTANCIA */ 
	/** Se testea que en una distancia menor a la mínima no ataque */
	@Test
	public void queNoAtaque() 
	{
		Unidad objetivo = new Soldado();
		Assert.assertEquals(200,objetivo.getSalud());
		lancero.atacar(objetivo, 0);
		Assert.assertEquals(200,objetivo.getSalud());
	}
	
	/** Se testea que en una distancia mayor a la máxima no ataque */
	@Test
	public void queNoAtaque2() { 
		Unidad objetivo = new Soldado();
		Assert.assertEquals(200,objetivo.getSalud());
		lancero.atacar(objetivo, 7);
		Assert.assertEquals(200,objetivo.getSalud());
	}
}
