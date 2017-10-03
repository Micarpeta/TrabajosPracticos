package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import infanteria.Arquero;
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
	public void inicializarCaballero() {
		caballero = new Caballero();
	}

	/** ATAQUE SIN ITEMS */
	@Test
	public void queAtaqueCon50() { /** Se testea que un caballero ataque con 50 a otra unidad*/
		Unidad objetivo = new Caballero();
		Assert.assertEquals(200,objetivo.getSalud());
		caballero.atacar(objetivo, 2);
		Assert.assertEquals(150,objetivo.getSalud());
	}
	
	/** ATAQUE CON PUÑAL */ 
	@Test
	public void queAtaqueCon53() { /** Se testea que ataque con 53 a otra unidad */
		Unidad objetivo = new Soldado();
		Assert.assertEquals(200,objetivo.getSalud());
		caballero = new Puñal(caballero);
		caballero.atacar(objetivo, 1);
		Assert.assertEquals(147,objetivo.getSalud());
	}
	
	/** ATAQUE CON CAPA */
	
	@Test
	public void queNoReduzcaAtaque() {/** Se testea que la capa no tenga efecto */
		Unidad objetivo = new Soldado();
		Assert.assertEquals(200,objetivo.getSalud());
		caballero = new Capa(caballero);
		caballero.atacar(objetivo, 2);
		Assert.assertEquals(150,objetivo.getSalud());
	}
	
	/** ATAQUE CON ESCUDO */ 
	
	@Test
	public void quePierda10DeSalud() { /** Se testea que solo reciba el 40% del ataque */
		Unidad enemigo = new Lancero();
		Assert.assertEquals(200, caballero.getSalud());
		caballero = new Escudo(caballero);
		enemigo.atacar(caballero, 2);
		Assert.assertEquals(190, caballero.getSalud());
		
		
	}
	
	/** DISTANCIA */ 
	
	@Test
	public void queNoAtaque() /** Se testea que en una distancia menor a la mínima no ataque */
	{
		Unidad objetivo = new Soldado();
		Assert.assertEquals(200,objetivo.getSalud());
		caballero.atacar(objetivo, 0);
		Assert.assertEquals(200,objetivo.getSalud());
	}
	
	public void queNoAtaque2() { /** Se testea que en una distancia mayor a la máxima no ataque */
		Unidad objetivo = new Soldado();
		Assert.assertEquals(200,objetivo.getSalud());
		caballero.atacar(objetivo, 3);
		Assert.assertEquals(200,objetivo.getSalud());
	}
	
	/** CABALLO REBELDE */
	@Test
	public void queNoAtaqueConCaballoRebelde() { /** Se testea que luego de 3 ataques el caballo se ponga rebelde, y no pueda atacar */
		Caballero cab= new Caballero();
		Unidad obj = new Soldado();
		for(int i =0; i<3;i++)
			obj.atacar(cab, 1);
		Assert.assertEquals(170,cab.getSalud());
		cab.atacar(obj, 1);
		Assert.assertEquals(200,obj.getSalud());
	}

	@Test
	public void queTomeAguaYAtaque() { /** Se testea que luego de estar el caballo rebelde, tomando agua pueda volver a atacar */
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
