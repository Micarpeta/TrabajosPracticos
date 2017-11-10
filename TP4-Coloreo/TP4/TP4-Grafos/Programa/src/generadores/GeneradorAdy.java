package generadores;

import grafo.GrafoNDNP;

import java.io.*;
import java.util.Random;

public class GeneradorAdy {
	private GrafoNDNP grafo;
	private int grado;

	//GENERAMOS UN GRAFO RECIBIENDO EL PORCENTAJE DE ADYACENCIA
	public GeneradorAdy(int nodos, double adyacencia) {
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

	public void procesarSalida(String path) {
		grado = grafo.getCantNodos();
		int aristas = grafo.cantidadAristas();
		int minGrado = grafo.getGradoDeUnNodo(0);
		int maxGrado = grafo.getGradoDeUnNodo(0);
		double perc = (double) grafo.cantidadAristas() * 100 / grafo.getMaxAristas();
		for (int i = 1; i < grado; i++) {
			int aux = grafo.getGradoDeUnNodo(i);
			if (aux < minGrado)
				minGrado = aux;
			if (aux > maxGrado)
				maxGrado = aux;
		}
		try {
			PrintWriter salida = new PrintWriter(new File(path));
			salida.println(grado + " " + aristas + " " + perc + " " + maxGrado + " " + minGrado);
			for (int i = 0; i < grado; i++)
				for (int j = i + 1; j < grado; j++)
					if (grafo.getArista(i, j))
						salida.println(i + " " + j);
			salida.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
