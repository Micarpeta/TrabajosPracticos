package probador;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		ProbadorGrafos p = new ProbadorGrafos("grafo1000_50.in", "coloreado.out");
		Calendar ti = new GregorianCalendar();
		p.resolver();
		Calendar tf = new GregorianCalendar();
		long dif = tf.getTimeInMillis() - ti.getTimeInMillis();
		System.out.println("Tiempo de respuesta: " + dif + " ms.");
	}

}
