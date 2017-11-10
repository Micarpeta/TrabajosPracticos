package generadores;

import java.io.File;
import java.io.PrintWriter;

import grafo.GrafoNDNP;

public abstract class Generador {
	
	protected GrafoNDNP grafo;
	protected int orden;
	
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
			System.out.println("Error al generar el archivo");
		}
	}
}
