package generadores;

import grafo.GrafoNDNP;
import java.util.Random;

public class GeneradorRegularGrado extends Generador{

	/**
	 * Generador Grafo Regular dado nodos totales y grado de los nodos
	 * si ambos parametros recibidos son impares no se podra generar el 
	 * grafo regular
	 * @param nodos
	 * @param grado
	 */
	public GeneradorRegularGrado(int nodos, int grado){
		if (grado >= nodos || (grado % 2 == 1 && nodos % 2 == 1)) {
			System.out.println("No se puede generar el grafo con estos parametros");
			return;
		}
		int aristasPorNodo[] = new int[nodos];
		grafo = new GrafoNDNP(nodos);
		orden = grafo.getCantNodos();
		for(int i = 0; i < nodos; i++) {
			int aristasRestantes = grado;
			for(int j = 0; j < i; j++) { //VERIFICAMOS QUE NO EL NODO YA TENGA ALGUNA ARISTA
				aristasRestantes -= grafo.getArista(i, j) ? 1 : 0;
			}
			
			while(aristasRestantes > 0) { //MIENTRAS HAYA ARISTAS POR AGREGARLE AL NODO
				int random = this.randomEntre(0 , orden); //BUSCAMOS UN NODO MAYOR AL ACTUAL
				if(!grafo.getArista(i, random) && (i != random) && (aristasPorNodo[i] < grado) && (aristasPorNodo[random]<grado)) {
					grafo.setArista(i, random); //SI NO TIENE ARISTA, SE LA SETEAMOS
					aristasPorNodo[i]++;
					aristasPorNodo[random]++;
					aristasRestantes--;
				}
			}
		}
	}

	private int randomEntre(int a, int b) {
		Random rnd = new Random();
		return rnd.nextInt(b - a) + a;
	}
}
