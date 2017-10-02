package test;

import org.junit.Assert;
import org.junit.Test;

import infanteria.Arquero;
import infanteria.Caballero;
import infanteria.Lancero;
import infanteria.Pu�al;
import infanteria.Soldado;
import infanteria.Unidad;

public class SoldadoTest {
	
	/*
	 * Test soldado ataca a otras unidades
	 */
	
	@Test //Se testea que un soldado inflija 10 puntos de da�o a otra unidad
	public void soldadoAtacaCon10() {
		Unidad soldado = new Soldado();
		Unidad objetivo = new Soldado();
		Assert.assertEquals(200,objetivo.getSalud());
		soldado.atacar(objetivo, 0);
		Assert.assertEquals(190, objetivo.getSalud());
	}
	
	@Test //Se testea que un soldado con pu�al inflija 13 puntos de da�o a otra unidad
	public void soldadoAtacaCon13() {
		Unidad soldado = new Pu�al(new Soldado());
		Unidad objetivo = new Arquero();
		Assert.assertEquals(50,objetivo.getSalud());
		soldado.atacar(objetivo, 0);
		Assert.assertEquals(37, objetivo.getSalud());
	}
	
	@Test //Se testea que un soldado inflija 13 puntos de da�o a otra unidad con pu�al
	public void soldadoAtacaCon13bis() {
		Unidad soldado = new Soldado();
		Unidad objetivo = new Pu�al(new Lancero());
		Assert.assertEquals(150,objetivo.getSalud());
		soldado.atacar(objetivo, 0);
		Assert.assertEquals(137, objetivo.getSalud());
	}
	
	@Test //Se testea que un soldado con pu�al inflija 16 puntos de da�o a otra unidad
	public void soldadoAtacaCon16() {
		Unidad soldado = new Pu�al(new Soldado());
		Unidad objetivo = new Pu�al(new Caballero());
		Assert.assertEquals(200,objetivo.getSalud());
		soldado.atacar(objetivo, 0);
		Assert.assertEquals(184, objetivo.getSalud());
	}
	
	/*
	 * TEST DISTANCIA
	 */
	
	/*
	 * TEST BEBER AGUA
	 */
	
	/*
	 * TEST SOLDADO SIN ENERGIA
	 */
	
	//Falta probar escudo y capa en soldado
	/**
	 * @Test
	 * public void soldadoConEscudo();
	 * 
	 * 
	 * 
	 * @Test
	 * public void soldadoConCapa();
	 * 
	 */
	
	//Hacer este test en Arquero, Lancero y Caballero
	
	
	
	
	
}
