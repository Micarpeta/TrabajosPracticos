package generadores;

import grafo.GrafoNDNP;

import java.io.*;
import java.util.Random;

public class GeneradorRegularGrado {
	private GrafoNDNP grafo;
	private int orden;

	//GENERAMOS UN GRAFO REGULAR, RECIBIENDO LA CANTIDAD DE NODOS Y EL GRADO DE CADA NODO
	//SI AMBOS PARAMETROS RECIBIDOS SON IMPARES, NO SE PODRA GENERAR EL GRAFO REGULAR
	public GeneradorRegularGrado(int nodos, int grado){
		if (grado >= nodos || (grado % 2 == 1 && nodos % 2 == 1)) {
			System.out.println("No se puede generar el grafo con estos parametros");
			return;
		}
		grafo = new GrafoNDNP(nodos);
		orden = grafo.getCantNodos();
		for(int i = 0; i < nodos; i++) {
			int aristasRestantes = grado;
			for(int j = 0; j < i; j++) { //VERIFICAMOS QUE NO EL NODO YA TENGA ALGUNA ARISTA
				aristasRestantes -= grafo.getArista(i, j) ? 1 : 0;
			}
			
			while(aristasRestantes > 0) { //MIENTRAS HAYA ARISTAS POR AGREGARLE AL NODO
				int test = this.randomEntre(i + 1, orden); //BUSCAMOS UN NODO MAYOR AL ACTUAL
				if(!grafo.getArista(i, test)) {
					grafo.setArista(i, test); //SI NO TIENE ARISTA, SE LA SETEAMOS
					aristasRestantes--;
				}
			}
		}
	}

	private int randomEntre(int a, int b) {
		Random rnd = new Random();
		return rnd.nextInt(b - a) + a;
	}

	public void procesarSalida(String path) {
		orden = grafo.getCantNodos();
		int aristas = grafo.cantidadAristas();
		int minGrado = grafo.getGradoDeUnNodo(0);
		int maxGrado = grafo.getGradoDeUnNodo(0);
		double perc = (double) grafo.cantidadAristas() * 100/grafo.getMaxAristas();
		for(int i = 1; i < orden; i++) {
			int aux = grafo.getGradoDeUnNodo(i);
			if(aux < minGrado)
				minGrado = aux;
			if(aux > maxGrado)
				maxGrado = aux;
		}
		try {
			PrintWriter salida = new PrintWriter(new File(path));
			salida.println(orden + " " + aristas + " " + perc + " " + maxGrado + " " + minGrado);
			for(int i = 0; i < orden; i++)
				for(int j = i + 1; j < orden; j++)
					if (grafo.getArista(i, j))
						salida.println(i + " " + j);
			salida.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
