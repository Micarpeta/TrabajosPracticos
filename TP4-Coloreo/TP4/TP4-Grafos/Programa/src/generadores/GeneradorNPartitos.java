package generadores;

import grafo.GrafoNDNP;

public class GeneradorNPartitos extends Generador{
	/**
	 * Generador de Grafo dado nodos y
	 * cantidad de Nodos de un subconjunto
	 * @param nodos
	 * @param cantNodosSub
	 */
	//GENERADOR DE GRAFOS N-PARTITOS
	//ARMA GRAFOS N-PARTITOS, DADOS LOS NODOS Y LA CANTIDAD DE NODOS DE UN SUBCONJUNTO
	public GeneradorNPartitos(int nodos, int cantNodosSub){
		if (cantNodosSub >= nodos)
			return;
		grafo = new GrafoNDNP(nodos);
		orden = grafo.getCantNodos();
		for(int i = 0; i < nodos; i++)
			for(int j = (i / cantNodosSub) * cantNodosSub + cantNodosSub; j < nodos; j++)
				grafo.setArista(i, j);
	}
}
