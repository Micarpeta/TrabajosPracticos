package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import infanteria.Arquero;
import infanteria.Caballero;
import infanteria.Capa;
import infanteria.Escudo;
import infanteria.Lancero;
import infanteria.Pu�al;
import infanteria.Soldado;
import infanteria.Unidad;

/**
 * 
 * Test de la clase Soldado
 *
 */
public class SoldadoTest {
	
	private Unidad soldado;
	
	/**
	 * Test soldado ataca a otras unidades
	 * 
	 * SOLDADO:
	 * Salud = 200
	 * Energ�a = 100
	 * Puntos de da�o = 10
	 * Distancia de Ataque entre 0 y 1
	 * 
	 * Restaurar�n energ�a al beber una poci�n de agua.
	 * 
	 * ADICI�N DE ITEMS:
	 * 
	 * PU�AL:
	 * Puntos de da�o = +3
	 * Recibir ataque = ataque del objetivo + 3
	 * 
	 * CAPA:
	 * Energ�a = La duplica
	 * Puntos de da�o = Los reduce en un 10%
	 * 
	 * ESCUDO:
	 * Recibir ataque = Recibir� solo el 40% del ataque del oponente
	 * 
	 */
	

	@Before
	public void inicializarSoldado() {
		soldado = new Soldado();
	}
	
	/** ATAQUE SIN ITEMS ENTRE SOLDADO Y OBJETIVO*/
	
	/**
	 * Se testea que un soldado inflija 10 puntos de da�o a otra unidad
	 */
	@Test 
	public void soldadoAtacaCon10() {
		Unidad objetivo = new Soldado();
		Assert.assertEquals(200,objetivo.getSalud());
		soldado.atacar(objetivo, 0);
		Assert.assertEquals(190, objetivo.getSalud());
	}
	
	/**Se testea que un soldado inflija 10 puntos de da�o a un Arquero*/
	@Test 
	public void soldadoAtacaCon10aArquero() {
		Unidad objetivo = new Arquero();
		Assert.assertEquals(50,objetivo.getSalud());
		soldado.atacar(objetivo, 0);
		Assert.assertEquals(40, objetivo.getSalud());
	}
	
	 /**Se testea que un soldado inflinja 10 puntos de da�o a un Lancero*/
	@Test
	public void soldadoAtacaCon10aLancero() {
		Unidad objetivo = new Lancero();
		Assert.assertEquals(150,objetivo.getSalud());
		soldado.atacar(objetivo, 0);
		Assert.assertEquals(140, objetivo.getSalud());
	}
	
	/**Se testea que un soldado inflinja 10 puntos de da�o a un Caballero*/
	@Test 
	public void soldadoAtacaCon10aCaballero() {
		Unidad objetivo = new Caballero();
		Assert.assertEquals(200,objetivo.getSalud());
		soldado.atacar(objetivo, 0);
		Assert.assertEquals(190, objetivo.getSalud());
	}
	
	/** ATAQUE ENTRE SOLDADO CON PU�AL Y OBJETIVO SIN ITEMS */
	
	/**Se testea que un soldado con pu�al inflija 13 puntos de da�o a Soldado*/
	@Test 
	public void soldadoAtacaCon13aSoldado() {
		soldado = new Pu�al(soldado);
		Unidad objetivo = new Soldado();
		Assert.assertEquals(200,objetivo.getSalud());
		soldado.atacar(objetivo, 0);
		Assert.assertEquals(187, objetivo.getSalud());
	}
	
	/**Se testea que un soldado con pu�al inflija 13 puntos de da�o a Arquero*/
	@Test 
	public void soldadoAtacaCon13aArquero() {
		soldado = new Pu�al(soldado);
		Unidad objetivo = new Arquero();
		Assert.assertEquals(50,objetivo.getSalud());
		soldado.atacar(objetivo, 0);
		Assert.assertEquals(37, objetivo.getSalud());
	}

	/**Se testea que un soldado con pu�al inflija 13 puntos de da�o a Lancero*/
	@Test 
	public void soldadoAtacaCon13aLancero() {
		soldado = new Pu�al(soldado);
		Unidad objetivo = new Lancero();
		Assert.assertEquals(150,objetivo.getSalud());
		soldado.atacar(objetivo, 0);
		Assert.assertEquals(137, objetivo.getSalud());
	}
	
	 /**Se testea que un soldado con pu�al inflija 13 puntos de da�o a Caballero*/
	@Test
	public void soldadoAtacaCon13aCaballero() {
		soldado = new Pu�al(soldado);
		Unidad objetivo = new Caballero();
		Assert.assertEquals(200,objetivo.getSalud());
		soldado.atacar(objetivo, 0);
		Assert.assertEquals(187, objetivo.getSalud());
	}

	/** ATAQUE ENTRE SOLDADO CON PU�AL Y OBJETIVO CON PU�AL */
	
	/**Se testea que un soldado con pu�al inflija 16 puntos de da�o a Soldado con pu�al*/
	@Test 
	public void soldadoAtacaCon16aSoldado() {
		soldado = new Pu�al(soldado);
		Unidad objetivo = new Pu�al(new Soldado());
		Assert.assertEquals(200,objetivo.getSalud());
		soldado.atacar(objetivo, 0);
		Assert.assertEquals(184, objetivo.getSalud());
	}
	
	/**Se testea que un soldado con pu�al inflija 16 puntos de da�o a Arquero con pu�al*/
	@Test 
	public void soldadoAtacaCon16aArquero() {
		soldado = new Pu�al(soldado);
		Unidad objetivo = new Pu�al(new Arquero());
		Assert.assertEquals(50,objetivo.getSalud());
		soldado.atacar(objetivo, 0);
		Assert.assertEquals(34, objetivo.getSalud());
	}
	
	 /**Se testea que un soldado con pu�al inflija 16 puntos de da�o a Lancero con pu�al*/
	@Test
	public void soldadoAtacaCon16aLancero() {
		soldado = new Pu�al(soldado);
		Unidad objetivo = new Pu�al(new Lancero());
		Assert.assertEquals(150,objetivo.getSalud());
		soldado.atacar(objetivo, 0);
		Assert.assertEquals(134, objetivo.getSalud());
	}
	
	@Test /**Se testea que un soldado con pu�al inflija 16 puntos de da�o a Caballero con pu�al*/
	public void soldadoAtacaCon16aCaballero() {
		soldado = new Pu�al(soldado);
		Unidad objetivo = new Pu�al(new Caballero());
		Assert.assertEquals(200,objetivo.getSalud());
		soldado.atacar(objetivo, 0);
		Assert.assertEquals(184, objetivo.getSalud());
	}
	
	/** SOLDADO CON CAPA*/
	
	/** Se testea que la capa duplique la energia del soldado*/ 
	@Test
	public void queDupliqueLaEnergia() { 
		Assert.assertEquals(100,((Soldado)soldado).getEnergia());
		soldado = new Capa(soldado);	
		Assert.assertEquals(200,((Capa)soldado).getEnergia());
	}
	
	 /** Se testea que al tener una capa se reduzca el ataque en un 10% */
	@Test
	public void queAtaqueCon9() {
		soldado = new Capa(soldado);
		Unidad objetivo = new Arquero();
		Assert.assertEquals(50,objetivo.getSalud());
		soldado.atacar(objetivo,1);
		Assert.assertEquals(41,objetivo.getSalud());
	}
	
	/** ATAQUE DE SOLDADO CON ESCUDO*/
	
	/** Se testea que al tener un escudo, solo reciba el 40% del da�o del enemigo */
	@Test
	public void queDisminuyaEn20LaSalud() { 
		Unidad enemigo = new Caballero();
		Assert.assertEquals(200,soldado.getSalud());
		soldado = new Escudo(soldado);
		enemigo.atacar(soldado, 1);
		Assert.assertEquals(180, soldado.getSalud());
		
	}
	
	/** BEBER AGUA */
	/** Se testea que al tomar agua aumente su energ�a a 100 */
	@Test
	public void queAumenteLaEnergia() { 
		Soldado soldier = new Soldado();
		Unidad objetivo = new Caballero();
		soldier.atacar(objetivo,1);
		soldier.atacar(objetivo,1);
		soldier.atacar(objetivo, 1);
		Assert.assertEquals(70,soldier.getEnergia());
		soldier.beberAgua();
		Assert.assertEquals(100,soldier.getEnergia());
	}
	
	/** SOLDADO SIN ENERGIA */
	
	/** Se testea que si el soldado no tiene la energ�a suficiente, que no pueda atacar */
	@Test
	public void queNoAtaqueSinEnergia() { 
		Unidad objetivo = new Lancero();
		for(int i=0;i<10;i++)
			soldado.atacar(objetivo, 1);
		Assert.assertEquals(50,objetivo.getSalud());
		soldado.atacar(objetivo,1);
		Assert.assertEquals(50,objetivo.getSalud());
	}
	
}