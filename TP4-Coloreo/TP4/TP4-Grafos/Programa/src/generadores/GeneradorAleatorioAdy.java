package generadores;

import grafo.GrafoNDNP;

import java.util.Random;

public class GeneradorAleatorioAdy extends Generador{

	/**
	 * Generador de Grafo Aleatorio recibiendo cantidad de nodos
	 * y porcentaje de adyacencia.
	 * @param nodos
	 * @param adyacencia
	 */
	public GeneradorAleatorioAdy(int nodos, double adyacencia) {
		if (adyacencia > 100 || adyacencia < 0) //SI LA ADYACENCIA ES MENOR A 0 o MAYOR A 100, SALIMOS
			return;
		grafo = new GrafoNDNP(nodos);
		int aristasRestantes = (int) Math.floor(grafo.getMaxAristas() * adyacencia / 100); //REDONDEAMOS PARA ABAJO
		int fila = this.randomEntre(0, nodos); //BUSCAMOS UNA FILA RANDOM
		int columna = this.randomEntre(0, nodos); //BUSCAMOS UNA COLUMNA RANDOM
		while (aristasRestantes > 0) {
			//SI NO TIENE ARISTA PUESTA, SE LA SETEAMOS
			if (!grafo.getArista(fila, columna)) {
				grafo.setArista(fila, columna);
				aristasRestantes--;
			}
			fila = this.randomEntre(0, nodos);
			columna = this.randomEntre(0, nodos);
		}
	}

	private int randomEntre(int a, int b) {
		Random rnd = new Random();
		return rnd.nextInt(b - a) + a;
	}
}
