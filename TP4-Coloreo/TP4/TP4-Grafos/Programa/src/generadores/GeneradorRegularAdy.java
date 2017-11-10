package generadores;

import grafo.GrafoNDNP;
import java.io.*;

public class GeneradorRegularAdy {
	private GrafoNDNP g;
	private int orden;
	
	/**
	 * Generador de grafos regulares por un porcentaje de adyacencia
	 * Arroja GrafoImposibleException si:
	 * - El porcentaje no está entre 0 y 100
	 * - Tanto el grado resultante como los nodos son numeros impares
	 * */
	public GeneradorRegularAdy(int nodos, double porc){
		g = new GrafoNDNP(nodos);
		orden = nodos;
		int aristasTotal = (int) Math.floor(g.getMaxAristas() * porc / 100),
				grado = 2 * aristasTotal / nodos, minimoGrado = 0;
		if (porc > 100 || porc < 0 || (grado % 2 == 1 && nodos % 2 == 1))
			return;
		int [] gradoDeNodos = new int[nodos];
		for(int i = 0; i < nodos; i++) {
			int aristasRest = grado - g.getGradoDeUnNodo(i);
			int test = 0;
			while(aristasRest > 0) {
				if(test != i && g.getGradoDeUnNodo(test) == minimoGrado) {
					g.setArista(i, test);
					aristasRest--;
					gradoDeNodos[test] += 1;
				}
				test = (test == nodos - 1)? 0: test + 1;
				if (test == 0)
					minimoGrado++;
			}
		}
	}

	public void imprimir(String path) {
		FileWriter fw;
		PrintWriter pw = null;
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
