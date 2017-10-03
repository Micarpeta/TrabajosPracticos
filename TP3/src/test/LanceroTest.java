package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import infanteria.Arquero;
import infanteria.Caballero;
import infanteria.Capa;
import infanteria.Escudo;
import infanteria.Lancero;
import infanteria.Paquete;
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
	 * Puntos de daño = 8
	 * Recibir ataque = -3 - ataque del enemigo
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
	@Test
	public void queAtaqueCon25() { /** Se testea que un lancero ataque con 25 a otra unidad*/
		Unidad objetivo = new Caballero();
		Assert.assertEquals(200,objetivo.getSalud());
		lancero.atacar(objetivo, 2);
		Assert.assertEquals(175,objetivo.getSalud());
	}
	
	
	/** ATAQUE CON PUÑAL */ 
	@Test
	public void queAtaqueCon28() { /** Se testea que ataque con 28 a otra unidad */
		Unidad objetivo = new Soldado();
		Assert.assertEquals(200,objetivo.getSalud());
		lancero = new Puñal(lancero);
		lancero.atacar(objetivo, 3);
		Assert.assertEquals(172,objetivo.getSalud());
	}
	
	/** ATAQUE CON CAPA */
	
	@Test
	public void queNoReduzcaAtaque() {/** Se testea que la capa no tenga efecto */
		Unidad objetivo = new Soldado();
		Assert.assertEquals(200,objetivo.getSalud());
		lancero = new Capa(lancero);
		lancero.atacar(objetivo, 3);
		Assert.assertEquals(175,objetivo.getSalud());
	}
	
	/** ATAQUE CON ESCUDO */ 
	
	@Test
	public void quePierda10DeSalud() { /** Se testea que solo reciba el 40% del ataque */
		Unidad enemigo = new Lancero();
		Assert.assertEquals(150, lancero.getSalud());
		lancero = new Escudo(lancero);
		enemigo.atacar(lancero, 2);
		Assert.assertEquals(140, lancero.getSalud());
		
		
	}
	
	/** DISTANCIA */ 
	
	@Test
	public void queNoAtaque() /** Se testea que en una distancia menor a la mínima no ataque */
	{
		Unidad objetivo = new Soldado();
		Assert.assertEquals(200,objetivo.getSalud());
		lancero.atacar(objetivo, 0);
		Assert.assertEquals(200,objetivo.getSalud());
	}
	
	public void queNoAtaque2() { /** Se testea que en una distancia mayor a la máxima no ataque */
		Unidad objetivo = new Soldado();
		Assert.assertEquals(200,objetivo.getSalud());
		lancero.atacar(objetivo, 7);
		Assert.assertEquals(200,objetivo.getSalud());
	}
}
