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

public class SoldadoTest {
	
	private Unidad soldado;
	
	/**
	 * Test soldado ataca a otras unidades
	 * 
	 * SOLDADO:
	 * Salud = 200
	 * Energía = 100
	 * Puntos de daño = 10
	 * Recibir ataque = -10 puntos de salud
	 * 
	 * Restaurarán energía al beber una poción de agua.
	 * 
	 * ADICIÓN DE ITEMS:
	 * 
	 * PUÑAL:
	 * Puntos de daño = 13
	 * Recibir ataque = -13 puntos de salud
	 * 
	 * CAPA:
	 * Energía = La duplica
	 * Puntos de daño = Los reduce en un 10%
	 * 
	 * ESCUDO:
	 * Recibir ataque = Recibirá solo el 40% del ataque del oponente
	 * 
	 */
	
	@Before
	public void inicializarSoldado() {
		soldado = new Soldado();
	}
	
	/** ATAQUE SIN ITEMS ENTRE SOLDADO Y OBJETIVO*/
	
	@Test /**Se testea que un soldado inflija 10 puntos de daño a otro Soldado*/
	public void soldadoAtacaCon10aSoldado() {
		Unidad objetivo = new Soldado();
		Assert.assertEquals(200,objetivo.getSalud());
		soldado.atacar(objetivo, 0);
		Assert.assertEquals(190, objetivo.getSalud());
	}
	
	@Test /**Se testea que un soldado inflija 10 puntos de daño a un Arquero*/
	public void soldadoAtacaCon10aArquero() {
		Unidad objetivo = new Arquero();
		Assert.assertEquals(50,objetivo.getSalud());
		soldado.atacar(objetivo, 0);
		Assert.assertEquals(40, objetivo.getSalud());
	}
	
	@Test /**Se testea que un soldado inflinja 10 puntos de daño a un Lancero*/
	public void soldadoAtacaCon10aLancero() {
		Unidad objetivo = new Lancero();
		Assert.assertEquals(150,objetivo.getSalud());
		soldado.atacar(objetivo, 0);
		Assert.assertEquals(140, objetivo.getSalud());
	}
	
	@Test /**Se testea que un soldado inflinja 10 puntos de daño a un Caballero*/
	public void soldadoAtacaCon10aCaballero() {
		Unidad objetivo = new Caballero();
		Assert.assertEquals(200,objetivo.getSalud());
		soldado.atacar(objetivo, 0);
		Assert.assertEquals(190, objetivo.getSalud());
	}
	
	/** ATAQUE ENTRE SOLDADO CON PUÑAL Y OBJETIVO SIN ITEMS */
	
	@Test /**Se testea que un soldado con puñal inflija 13 puntos de daño a Soldado*/
	public void soldadoAtacaCon13aSoldado() {
		soldado = new Puñal(soldado);
		Unidad objetivo = new Soldado();
		Assert.assertEquals(200,objetivo.getSalud());
		soldado.atacar(objetivo, 0);
		Assert.assertEquals(187, objetivo.getSalud());
	}
	
	@Test /**Se testea que un soldado con puñal inflija 13 puntos de daño a Arquero*/
	public void soldadoAtacaCon13aArquero() {
		soldado = new Puñal(soldado);
		Unidad objetivo = new Arquero();
		Assert.assertEquals(50,objetivo.getSalud());
		soldado.atacar(objetivo, 0);
		Assert.assertEquals(37, objetivo.getSalud());
	}
	
	@Test /**Se testea que un soldado con puñal inflija 13 puntos de daño a Lancero*/
	public void soldadoAtacaCon13aLancero() {
		soldado = new Puñal(soldado);
		Unidad objetivo = new Lancero();
		Assert.assertEquals(150,objetivo.getSalud());
		soldado.atacar(objetivo, 0);
		Assert.assertEquals(137, objetivo.getSalud());
	}
	
	@Test /**Se testea que un soldado con puñal inflija 13 puntos de daño a Caballero*/
	public void soldadoAtacaCon13aCaballero() {
		soldado = new Puñal(soldado);
		Unidad objetivo = new Caballero();
		Assert.assertEquals(200,objetivo.getSalud());
		soldado.atacar(objetivo, 0);
		Assert.assertEquals(187, objetivo.getSalud());
	}

	/** ATAQUE ENTRE SOLDADO CON PUÑAL Y OBJETIVO CON PUÑAL */
	
	@Test /**Se testea que un soldado con puñal inflija 16 puntos de daño a Soldado con puñal*/
	public void soldadoAtacaCon16aSoldado() {
		soldado = new Puñal(soldado);
		Unidad objetivo = new Puñal(new Soldado());
		Assert.assertEquals(200,objetivo.getSalud());
		soldado.atacar(objetivo, 0);
		Assert.assertEquals(184, objetivo.getSalud());
	}
	
	@Test /**Se testea que un soldado con puñal inflija 16 puntos de daño a Arquero con puñal*/
	public void soldadoAtacaCon16aArquero() {
		soldado = new Puñal(soldado);
		Unidad objetivo = new Puñal(new Arquero());
		Assert.assertEquals(50,objetivo.getSalud());
		soldado.atacar(objetivo, 0);
		Assert.assertEquals(34, objetivo.getSalud());
	}
	
	@Test /**Se testea que un soldado con puñal inflija 16 puntos de daño a Lancero con puñal*/
	public void soldadoAtacaCon16aLancero() {
		soldado = new Puñal(soldado);
		Unidad objetivo = new Puñal(new Lancero());
		Assert.assertEquals(150,objetivo.getSalud());
		soldado.atacar(objetivo, 0);
		Assert.assertEquals(134, objetivo.getSalud());
	}
	
	@Test /**Se testea que un soldado con puñal inflija 16 puntos de daño a Caballero con puñal*/
	public void soldadoAtacaCon16aCaballero() {
		soldado = new Puñal(soldado);
		Unidad objetivo = new Puñal(new Caballero());
		Assert.assertEquals(200,objetivo.getSalud());
		soldado.atacar(objetivo, 0);
		Assert.assertEquals(184, objetivo.getSalud());
	}
	
	/** SOLDADO CON CAPA*/
	
	@Test
	public void queDupliqueLaEnergia() { /** REVISAR GET ENERGIA */ 
		Assert.assertEquals(100,((Soldado)soldado).getEnergia());
		soldado = new Capa(soldado);	
		//Assert.assertEquals(200,soldado.getEnergia());
	}
	
	@Test
	public void queAtaqueCon9() { /** Se testea que al tener una capa se reduzca el ataque en un 10% */
		Unidad objetivo = new Arquero();
		soldado = new Capa(soldado);
		Assert.assertEquals(50,objetivo.getSalud());
		soldado.atacar(objetivo,1);
		Assert.assertEquals(41,objetivo.getSalud());
	}
	
	/** ATAQUE DE SOLDADO CON ESCUDO*/
	
	@Test
	public void queDisminuyaEn20LaSalud() { /** Se testea que al tener un escudo, solo reciba el 40% del daño del enemigo */
		Unidad enemigo = new Caballero();
		Assert.assertEquals(200,soldado.getSalud());
		soldado = new Escudo(soldado);
		enemigo.atacar(soldado, 1);
		Assert.assertEquals(180, soldado.getSalud());
		
	}
	

	
	/** BEBER AGUA */
	
	@Test
	public void queAumenteLaEnergia() { /** Se testea que al tomar agua aumente su energía a 100 */
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
	
	@Test
	public void queNoAtaqueSinEnergia() { /** Se testea que si el soldado no tiene la energía suficiente, que no pueda atacar */
		Unidad objetivo = new Lancero();
		for(int i=0;i<10;i++)
			soldado.atacar(objetivo, 1);
		Assert.assertEquals(50,objetivo.getSalud());
		soldado.atacar(objetivo,1);
		Assert.assertEquals(50,objetivo.getSalud());
	}
	
	
}