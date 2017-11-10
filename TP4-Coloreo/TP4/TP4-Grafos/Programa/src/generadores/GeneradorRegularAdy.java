package generadores;

import grafo.GrafoNDNP;


public class GeneradorRegularAdy extends Generador {	
	/**
	 * Generador de Grafo Regular dado el porcentaje de adyacencia.
	 * @param nodos
	 * @param porcentaje de adyacencia
	 */
	public GeneradorRegularAdy(int nodos, double porcentaje){
		grafo = new GrafoNDNP(nodos);
		orden = nodos;
		int aristasTotal = (int) Math.floor(grafo.getMaxAristas() * porcentaje / 100);
		int grado = 2 * aristasTotal / nodos;
		int minimoGrado = 0;
		if (porcentaje > 100 || porcentaje < 0 || (grado % 2 == 1 && nodos % 2 == 1))
			return;
		int [] gradoDeNodos = new int[nodos];
		for(int i = 0; i < nodos; i++) {
			int aristasRest = grado - grafo.getGradoDeUnNodo(i);
			int test = 0;
			while(aristasRest > 0) {
				if(test != i && grafo.getGradoDeUnNodo(test) == minimoGrado) {
					grafo.setArista(i, test);
					aristasRest--;
					gradoDeNodos[test] += 1;
				}
				test = (test == nodos - 1)? 0: test + 1;
				if (test == 0)
					minimoGrado++;
			}
		}
	}
}
