package coloreador;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ComparaColores {

	public static void main(String[] args) {
		int [] repeticionesCantColoresSA = new int [600];
		int [] repeticionesCantColoresMA = new int [600];
		int [] repeticionesCantColoresWP = new int [600];
		int cantColores = 0;
		int coloresMinimos = 100000;
		int mejorPasadaSecuencial = 0;
		int mejorPasadaMatula = 0;
		
		Colorear col = new Colorear("grafo600_40.in");
		Calendar t00 = new GregorianCalendar();
		for(int i = 0; i < 10000; i++) {
			repeticionesCantColoresSA[col.darColor(0) - 1]++; // SECUENCIAL-ALEATORIO
			System.out.println(i);
		}
		Calendar t01 = new GregorianCalendar();
////		for(int i = 0; i < 10000; i++)
//			repeticionesCantColoresMA[col.darColor(1) - 1]++; // MATULA
//		Calendar t02 = new GregorianCalendar();
////		for(int i = 0; i < 10000; i++)
////			repeticionesCantColoresWP[col.darColor(2) - 1]++; // WELSH-POWELL
		Calendar t03 = new GregorianCalendar();
		System.out.println("Tiempo para Algoritmo Secuencial-Aleatorio:" + (t01.getTimeInMillis() - t00.getTimeInMillis()) + " ms");
//		System.out.println("Tiempo para Algoritmo de Matula:" + (t02.getTimeInMillis() - t01.getTimeInMillis()) + " ms");
//		System.out.println("Tiempo para Algoritmo de Welsh-Powell:" + (t03.getTimeInMillis() - t02.getTimeInMillis()) + " ms");
		col.escribirArchivo();
		ComparaColores.grabar("frecuenciasSecAleatoria.out", repeticionesCantColoresSA);
//		ComparaColores.grabar("frecuenciasMatula.out", repeticionesCantColoresMA);
//		ComparaColores.grabar("frecuenciasWelshPowel.out", repeticionesCantColoresWP);
		
	}
	
	public static void grabar(String path, int [] frecuencias){
		File archivo;
		FileWriter writer;
		PrintWriter bufferOut = null;
		try {
			archivo = new File(path);
			writer = new FileWriter(archivo);
			bufferOut = new PrintWriter(writer);
			for(int i = 0; i < 1000; i++)
				if(frecuencias[i] != 0)
					bufferOut.println((i + 1) + " colores - " + frecuencias[i]);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (bufferOut != null)
				bufferOut.close();
		}
	}
	

}
