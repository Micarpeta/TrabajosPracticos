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

public class CaballeroTest {

	private Unidad caballero;
	
	/**
	 * Test caballero ataca a otras unidades
	 * 
	 * CABALLERO:
	 * Salud = 200
	 * Puntos de daño = 50
	 * Distancia para atacar = entre 1 y 2 si el caballo no está rebelde
	 * 
	 * El caballo se pone rebelde luego de 3 ataques, y vuelve a la normalidad bebiendo agua
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
	public void inicializarCaballero() {
		caballero = new Caballero();
	}

	/** ATAQUE SIN ITEMS */
	/** Se testea que un caballero ataque con 50 a otra unidad*/
	@Test
	public void queAtaqueCon50() { 
		Unidad objetivo = new Caballero();
		Assert.assertEquals(200,objetivo.getSalud());
		caballero.atacar(objetivo, 2);
		Assert.assertEquals(150,objetivo.getSalud());
	}
	
	/** ATAQUE CON PUÑAL */
	/** Se testea que ataque con 53 a otra unidad */
	@Test
	public void queAtaqueCon53() { 
		Unidad objetivo = new Soldado();
		Assert.assertEquals(200,objetivo.getSalud());
		caballero = new Puñal(caballero);
		caballero.atacar(objetivo, 1);
		Assert.assertEquals(147,objetivo.getSalud());
	}
	
	/** ATAQUE CON CAPA */
	/** Se testea que la capa no tenga efecto */
	@Test
	public void queNoReduzcaAtaque() {
		Unidad objetivo = new Soldado();
		Assert.assertEquals(200,objetivo.getSalud());
		caballero = new Capa(caballero);
		caballero.atacar(objetivo, 2);
		Assert.assertEquals(150,objetivo.getSalud());
	}
	
	/** ATAQUE CON ESCUDO */ 
	/** Se testea que solo reciba el 40% del ataque */
	@Test
	public void quePierda10DeSalud() { 
		Unidad enemigo = new Lancero();
		Assert.assertEquals(200, caballero.getSalud());
		caballero = new Escudo(caballero);
		enemigo.atacar(caballero, 2);
		Assert.assertEquals(190, caballero.getSalud());
		
		
	}
	
	/** DISTANCIA */ 
	/** Se testea que en una distancia menor a la mínima no ataque */
	@Test
	public void queNoAtaque() {
		Unidad objetivo = new Soldado();
		Assert.assertEquals(200,objetivo.getSalud());
		caballero.atacar(objetivo, 0);
		Assert.assertEquals(200,objetivo.getSalud());
	}
	
	/** Se testea que en una distancia mayor a la máxima no ataque */
	@Test
	public void queNoAtaque2() { 
		Unidad objetivo = new Soldado();
		Assert.assertEquals(200,objetivo.getSalud());
		caballero.atacar(objetivo, 3);
		Assert.assertEquals(200,objetivo.getSalud());
	}
	
	/** CABALLO REBELDE */
	/** Se testea que luego de 3 ataques el caballo se ponga rebelde, y no pueda atacar */
	@Test
	public void queNoAtaqueConCaballoRebelde() { 
		Caballero cab= new Caballero();
		Unidad obj = new Soldado();
		for(int i =0; i<3;i++)
			obj.atacar(cab, 1);
		Assert.assertEquals(170,cab.getSalud());
		cab.atacar(obj, 1);
		Assert.assertEquals(200,obj.getSalud());
	}

	/** Se testea que luego de estar el caballo rebelde, tomando agua pueda volver a atacar */
	@Test
	public void queTomeAguaYAtaque() { 
		Unidad obj = new Soldado();
		Caballero cab= new Caballero();
		for(int i =0; i<3;i++)
			obj.atacar(cab, 1);
		Assert.assertEquals(170,cab.getSalud());
		cab.atacar(obj, 1);
		Assert.assertEquals(200,obj.getSalud());
		cab.beberAgua();
		cab.atacar(obj, 2);
		Assert.assertEquals(150,obj.getSalud());
	}

}
