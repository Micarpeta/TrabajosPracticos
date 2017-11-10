package generadores;

import grafo.GrafoNDNP;

import java.io.*;

public class GeneradorNPartitos {
	private GrafoNDNP g;
	private int orden;

	/**
	 * Generador de grafos N-partitos
	 * Arroja GrafoImposibleException si los subconjuntos son más que los nodos
	 * Arma grafos N-partitos, dados los nodos y los nodos de un subconjunto
	 * */
	public GeneradorNPartitos(int nodos, int part){
		if (part >= nodos)
			return;
		g = new GrafoNDNP(nodos);
		orden = g.getCantNodos();
		for(int i = 0; i < nodos; i++)
			for(int j = (i / part) * part + part; j < nodos; j++)
				g.setArista(i, j);
	}

	public void imprimir(String path) {
		FileWriter fw;
		PrintWriter pw = null;
		orden = g.getCantNodos();
		int aristas = g.cantidadAristas(), minG = g.getGradoDeUnNodo(0), maxG = g.getGradoDeUnNodo(0);
		double perc = (double) g.cantidadAristas() * 100/g.getMaxAristas();
		for(int i = 1; i < orden; i++) {
			int aux = g.getGradoDeUnNodo(i);
			if(aux < minG)
				minG = aux;
			if(aux > maxG)
				maxG = aux;
		}
		try {
			fw = new FileWriter(path);
			pw = new PrintWriter(fw);
			pw.println(orden + " " + aristas + " " + perc + " " + maxG + " " + minG);
			for(int i = 0; i < orden; i++)
				for(int j = i + 1; j < orden; j++)
					if (g.getArista(i, j))
						pw.println(i + " " + j);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}
	}
}
