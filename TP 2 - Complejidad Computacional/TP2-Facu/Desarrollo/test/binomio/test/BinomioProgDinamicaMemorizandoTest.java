package binomio.test;

import org.junit.Test;

import binomioDeNewton.BinomioDeNewton;

public class BinomioProgDinamicaMemorizandoTest {

	@Test
	public void testNIgualA0(){
		
		BinomioDeNewton b1 = new BinomioDeNewton(2,3,0);
		
		long start = System.nanoTime();
		long valor = b1.desarrolloCompletoDelBinomioProgDinamicaMemorizando(10);
		long diff = System.nanoTime() - start;
		
		System.out.println(valor);
		System.out.println("Binomio de grado 0 ->   Tiempo ejecución: " + diff + " ns");
	}
	
	@Test
	public void testNIgualA1(){
		
		BinomioDeNewton b1 = new BinomioDeNewton(2,3,1);
		
		long start = System.nanoTime();
		long valor = b1.desarrolloCompletoDelBinomioProgDinamicaMemorizando(10);
		long diff = System.nanoTime() - start;
		
		System.out.println(valor);
		System.out.println("Binomio de grado 1 ->   Tiempo ejecución: " + diff + " ns");
	}
	
	@Test
	public void testNIgualA2(){
		
		BinomioDeNewton b1 = new BinomioDeNewton(2,3,2);
		
		long start = System.nanoTime();
		long valor = b1.desarrolloCompletoDelBinomioProgDinamicaMemorizando(10);
		long diff = System.nanoTime() - start;
		
		System.out.println(valor);
		System.out.println("Binomio de grado 2 ->   Tiempo ejecución: " + diff + " ns");
	}
	
	@Test
	public void testNIgualA3(){
		
		BinomioDeNewton b1 = new BinomioDeNewton(2,3,3);
		
		long start = System.nanoTime();
		long valor = b1.desarrolloCompletoDelBinomioProgDinamicaMemorizando(10);
		long diff = System.nanoTime() - start;
		
		System.out.println(valor);
		System.out.println("Binomio de grado 3 ->   Tiempo ejecución: " + diff + " ns");
	}
	
	@Test
	public void testNIgualA4(){
		
		BinomioDeNewton b1 = new BinomioDeNewton(2,3,4);
		
		long start = System.nanoTime();
		long valor = b1.desarrolloCompletoDelBinomioProgDinamicaMemorizando(10);
		long diff = System.nanoTime() - start;
		
		System.out.println(valor);
		System.out.println("Binomio de grado 4 ->   Tiempo ejecución: " + diff + " ns");
	}
	
	@Test
	public void testNIgualA5(){
		
		BinomioDeNewton b1 = new BinomioDeNewton(2,3,5);
		
		long start = System.nanoTime();
		long valor = b1.desarrolloCompletoDelBinomioProgDinamicaMemorizando(10);
		long diff = System.nanoTime() - start;
		
		System.out.println(valor);
		System.out.println("Binomio de grado 5 ->   Tiempo ejecución: " + diff + " ns");
	}
	
	@Test
	public void testNIgualA6(){
		
		BinomioDeNewton b1 = new BinomioDeNewton(2,3,6);
		
		long start = System.nanoTime();
		long valor = b1.desarrolloCompletoDelBinomioProgDinamicaMemorizando(10);
		long diff = System.nanoTime() - start;
		
		System.out.println(valor);
		System.out.println("Binomio de grado 6 ->   Tiempo ejecución: " + diff + " ns");
	}
	
	@Test
	public void testNIgualA7(){
		
		BinomioDeNewton b1 = new BinomioDeNewton(2,3,7);
		
		long start = System.nanoTime();
		long valor = b1.desarrolloCompletoDelBinomioProgDinamicaMemorizando(10);
		long diff = System.nanoTime() - start;
		
		System.out.println(valor);
		System.out.println("Binomio de grado 7 ->   Tiempo ejecución: " + diff + " ns");
	}
	
	@Test
	public void testNIgualA8(){
		
		BinomioDeNewton b1 = new BinomioDeNewton(2,3,8);
		
		long start = System.nanoTime();
		long valor = b1.desarrolloCompletoDelBinomioProgDinamicaMemorizando(10);
		long diff = System.nanoTime() - start;
		
		System.out.println(valor);
		System.out.println("Binomio de grado 8 ->   Tiempo ejecución: " + diff + " ns");
	}
	
	@Test
	public void testNIgualA9(){
		
		BinomioDeNewton b1 = new BinomioDeNewton(2,3,9);
		
		long start = System.nanoTime();
		long valor = b1.desarrolloCompletoDelBinomioProgDinamicaMemorizando(10);
		long diff = System.nanoTime() - start;
		
		System.out.println(valor);
		System.out.println("Binomio de grado 9 ->   Tiempo ejecución: " + diff + " ns");
	}
	
	@Test
	public void testNIgualA_10(){
		
		BinomioDeNewton b1 = new BinomioDeNewton(2,3,10);
		
		long start = System.nanoTime();
		long valor = b1.desarrolloCompletoDelBinomioProgDinamicaMemorizando(10);
		long diff = System.nanoTime() - start;
		
		System.out.println(valor);
		System.out.println("Binomio de grado 10 ->   Tiempo ejecución: " + diff + " ns");
	}
	
	@Test
	public void testNIgualA_11(){
		
		BinomioDeNewton b1 = new BinomioDeNewton(2,3,11);
		
		long start = System.nanoTime();
		long valor = b1.desarrolloCompletoDelBinomioProgDinamicaMemorizando(10);
		long diff = System.nanoTime() - start;
		
		System.out.println(valor);
		System.out.println("Binomio de grado 11 ->   Tiempo ejecución: " + diff + " ns");
	}
	
	@Test
	public void testNIgualA_12(){
		
		BinomioDeNewton b1 = new BinomioDeNewton(2,3,12);
		
		long start = System.nanoTime();
		long valor = b1.desarrolloCompletoDelBinomioProgDinamicaMemorizando(10);
		long diff = System.nanoTime() - start;
		
		System.out.println(valor);
		System.out.println("Binomio de grado 12 ->   Tiempo ejecución: " + diff + " ns");
	}
	
	@Test
	public void testNIgualA_13(){
		
		BinomioDeNewton b1 = new BinomioDeNewton(2,3,13);
		
		long start = System.nanoTime();
		long valor = b1.desarrolloCompletoDelBinomioProgDinamicaMemorizando(10);
		long diff = System.nanoTime() - start;
		
		System.out.println(valor);
		System.out.println("Binomio de grado 13 ->   Tiempo ejecución: " + diff + " ns");
	}
	
//	@Test
//	public void testNIgualA_14(){
//		
//		BinomioDeNewton b1 = new BinomioDeNewton(2,3,14);
//		
//		long start = System.nanoTime();
//		long valor = b1.desarrolloCompletoDelBinomioProgDinamicaMemorizando(10);
//		long diff = System.nanoTime() - start;
//		
//		System.out.println(valor);
//		System.out.println("Binomio de grado 14 ->   Tiempo ejecución: " + diff + " ns");
//	}
//	
//	@Test
//	public void testNIgualA_15(){
//		
//		BinomioDeNewton b1 = new BinomioDeNewton(2,3,15);
//		
//		long start = System.nanoTime();
//		long valor = b1.desarrolloCompletoDelBinomioProgDinamicaMemorizando(10);
//		long diff = System.nanoTime() - start;
//		
//		System.out.println(valor);
//		System.out.println("Binomio de grado 15 ->   Tiempo ejecución: " + diff + " ns");
//	}
//	
//	@Test
//	public void testNIgualA_16(){
//		
//		BinomioDeNewton b1 = new BinomioDeNewton(2,3,16);
//		
//		long start = System.nanoTime();
//		long valor = b1.desarrolloCompletoDelBinomioProgDinamicaMemorizando(10);
//		long diff = System.nanoTime() - start;
//		
//		System.out.println(valor);
//		System.out.println("Binomio de grado 16 ->   Tiempo ejecución: " + diff + " ns");
//	}
	
}
