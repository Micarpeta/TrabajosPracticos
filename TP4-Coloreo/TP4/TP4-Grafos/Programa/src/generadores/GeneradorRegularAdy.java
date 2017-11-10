package generadores;

import grafo.GrafoNDNP;
import java.io.*;

public class GeneradorRegularAdy {
	private GrafoNDNP grafo;
	private int orden;
	
	// Generador de grafos regulares dados N y el porcentaje de adyacencia.
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

	public void procesarSalida(String path) {
		
		int aristas = grafo.cantidadAristas(), minG = grafo.getGradoDeUnNodo(0), maxG = grafo.getGradoDeUnNodo(0);
		double perc = (double) grafo.cantidadAristas() * 100/grafo.getMaxAristas();
		for(int i = 1; i < orden; i++) {
			int aux = grafo.getGradoDeUnNodo(i);
			if(aux < minG)
				minG = aux;
			if(aux > maxG)
				maxG = aux;
		}
		try {
			PrintWriter pw = new PrintWriter(new File(path));
			pw.println(orden + " " + aristas + " " + perc + " " + maxG + " " + minG);
			for(int i = 0; i < orden; i++)
				for(int j = i + 1; j < orden; j++)
					if (grafo.getArista(i, j))
						pw.println(i + " " + j);
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
