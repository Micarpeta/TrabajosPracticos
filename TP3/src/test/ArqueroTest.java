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

public class ArqueroTest {
	
	private Unidad arquero;
	/**
	 * Test arquero ataca a otras unidades
	 * 
	 * ARQUERO:
	 * Salud = 50
	 * Flechas = 20
	 * Puntos de daño = 5
	 * Distancia para atacar = entre 2 y 5
	 * 
	 * Cargarán flechas en su carcaj con paquetes de 6.
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
	public void inicializarArquero() {
		arquero = new Arquero();
	}

	/** ATAQUE SIN ITEMS */
	@Test
	public void queAtaqueCon5() { /** Se testea que un arquero ataque con 5 a otra unidad*/
		Unidad objetivo = new Caballero();
		Assert.assertEquals(200,objetivo.getSalud());
		arquero.atacar(objetivo, 2);
		Assert.assertEquals(195,objetivo.getSalud());
	}
	
	/** ATAQUE CON PUÑAL */ 
	@Test
	public void queAtaqueCon8() { /** Se testea que ataque con 8 a otra unidad */
		Unidad objetivo = new Soldado();
		Assert.assertEquals(200,objetivo.getSalud());
		arquero = new Puñal(arquero);
		arquero.atacar(objetivo, 3);
		Assert.assertEquals(192,objetivo.getSalud());
	}
	
	/** ATAQUE CON CAPA */
	
	@Test
	public void queNoReduzcaAtaque() {/** Se testea que la capa no tenga efecto */
		Unidad objetivo = new Soldado();
		Assert.assertEquals(200,objetivo.getSalud());
		arquero = new Capa(arquero);
		arquero.atacar(objetivo, 3);
		Assert.assertEquals(195,objetivo.getSalud());
	}
	
	/** ATAQUE CON ESCUDO */ 
	
	@Test
	public void quePierda10DeSalud() { /** Se testea que solo reciba el 40% del ataque */
		Unidad enemigo = new Lancero();
		Assert.assertEquals(50, arquero.getSalud());
		arquero = new Escudo(arquero);
		enemigo.atacar(arquero, 2);
		Assert.assertEquals(40, arquero.getSalud());
		
		
	}
	
	/** DISTANCIA */ 
	
	@Test
	public void queNoAtaque() /** Se testea que en una distancia menor a la mínima no ataque */
	{
		Unidad objetivo = new Soldado();
		Assert.assertEquals(200,objetivo.getSalud());
		arquero.atacar(objetivo, 1);
		Assert.assertEquals(200,objetivo.getSalud());
	}
	
	public void queNoAtaque2() { /** Se testea que en una distancia mayor a la máxima no ataque */
		Unidad objetivo = new Soldado();
		Assert.assertEquals(200,objetivo.getSalud());
		arquero.atacar(objetivo, 7);
		Assert.assertEquals(200,objetivo.getSalud());
	}
	
	/** FLECHAS */
	@Test
	public void queCargueFlechas() {
		Arquero arq = new Arquero();
		Unidad obj = new Soldado();
		for(int i =0; i<20;i++)
			arq.atacar(obj, 2);
		Assert.assertEquals(0,arq.getCantFlechas());
		Paquete paquete = new Paquete();
		arq.recargarCarcaj(paquete);
		Assert.assertEquals(6,arq.getCantFlechas());
	}

	@Test
	public void queNoAtaqueSinFlechas() {
		Unidad obj = new Soldado();
		for(int i =0; i<20;i++)
			arquero.atacar(obj, 2);
		Assert.assertEquals(100,obj.getSalud());
		arquero.atacar(obj, 3);
		Assert.assertEquals(100,obj.getSalud());
	}
}
