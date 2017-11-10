package generadores;

import grafo.GrafoNDNP;

public class GeneradorAleatorioProba extends Generador{
	/**
	 * Generador de Grafo Aleatorio recibiendo cantidad de nodos
	 * y probabilidad para cada arista
	 * @param nodos
	 * @param probabilidad
	 */
	//GENERAMOS EL GRAFO RECIBIENDO LA PROBABILIDAD Y LA CANTIDAD DE NODOS
	public GeneradorAleatorioProba(int nodos, double probabilidad) {
		grafo = new GrafoNDNP(nodos);
		for(int i = 0; i < nodos; i++) {
			for(int j = i + 1; j < nodos; j++)
				if(Math.random() < probabilidad)
					grafo.setArista(i, j);
		}
	}	
}
