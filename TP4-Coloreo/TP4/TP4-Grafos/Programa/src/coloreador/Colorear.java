package coloreador;

import grafo.GrafoNDNP;

import java.io.*;
import java.util.*;

public class Colorear {
	private GrafoNDNP grafo;
	private int gradMax;
	private int gradMin;
	/// LISTAS PARA GRABAR ARCHIVO
	private int colorMejorCasoSA;
	private Nodo [] ordenMejorCasoSA;
	private int colorMejorCasoMa;
	private Nodo [] ordenMejorCasoMa;
	private int colorMejorCasoWP;
	private Nodo [] ordenMejorCasoWP;
	
	public Colorear(String fileGrafo) {
		File archivo;
		FileReader reader;
		BufferedReader bufferIn = null;
		try {
			archivo = new File(fileGrafo);
			reader = new FileReader(archivo);
			bufferIn = new BufferedReader(reader);
			String [] aux = bufferIn.readLine().split(" ");
			int nodos = Integer.parseInt(aux[0]);
			grafo = new GrafoNDNP(nodos);
			gradMax = Integer.parseInt(aux[3]);
			gradMin = Integer.parseInt(aux[4]);
			int cantAristas = Integer.parseInt(aux[1]);
			for(int i = 0; i < cantAristas;i++) {
				aux = bufferIn.readLine().split(" ");
				grafo.setArista(Integer.parseInt(aux[0]), Integer.parseInt(aux[1]));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		colorMejorCasoSA = 0;
		ordenMejorCasoSA = new Nodo[grafo.getCantNodos()];
		
		colorMejorCasoMa = 0;
		ordenMejorCasoMa = new Nodo[grafo.getCantNodos()];

		colorMejorCasoWP= 0;
		ordenMejorCasoWP = new Nodo[grafo.getCantNodos()];
	}

	public int darColor(int modo) {
		modo = (modo < 0 || modo > 2)? 0 : modo;
		int colorMejorCaso, cantNodos = grafo.getCantNodos();
		Nodo [] nodos = new Nodo[cantNodos];
		Integer [] nodosDeEsteColor = new Integer[cantNodos];
		for(int i = 0; i < cantNodos; i++) {
			nodos[i] = new Nodo(i, grafo.getGradoDeUnNodo(i));
			nodosDeEsteColor[i] = -1;
		}
		/// ORDENAMIENTO
		Nodo.mezclar(nodos); // n^2
		switch(modo) {
			case 1: Arrays.sort(nodos); 
			break; 
			case 2: Arrays.sort(nodos, Nodo.ComparadorDeGrados); 
			break; 
		}
		/// COLOREO
		int colorActual = 1;
		for(int i = 0; i < cantNodos; i++) {
			int marcador = 1;
			int nodoI = nodos[i].getNodo();
			int colorI = nodos[i].getColor();
			if(colorI == 0) {
				nodos[i].setColor(colorActual);
				nodosDeEsteColor[0] = nodoI;
				for(int j = i + 1; j < cantNodos;j++) {
					int nodoJ = nodos[j].getNodo();
					int colorJ = nodos[j].getColor();
					if(nodoI != nodoJ && !esAdyacente(nodosDeEsteColor, marcador, nodoJ) && colorJ == 0) {
						nodos[j].setColor(colorActual);
						nodosDeEsteColor[marcador] = nodoJ;
						marcador++;
					}
				}
				colorActual++;
			}
		}// n^2
		colorMejorCaso = colorActual - 1;
		// REVISION DEL MEJOR CASO
		switch(modo) {
			case 0:
			if(colorMejorCasoSA == 0 || colorMejorCaso <= colorMejorCasoSA) {
				colorMejorCasoSA = colorMejorCaso;
				for(int i = 0; i < cantNodos; i++)
					ordenMejorCasoSA[i] = nodos[i];
			}
			break;
			case 1:
			if(colorMejorCasoMa == 0 || colorMejorCaso <= colorMejorCasoMa) {
				colorMejorCasoMa = colorMejorCaso;
				for(int i = 0; i < cantNodos; i++)
					ordenMejorCasoMa[i] = nodos[i];
			}
			break;
			case 2:
			if(colorMejorCasoWP == 0 || colorMejorCaso <= colorMejorCasoWP) {
				colorMejorCasoWP = colorMejorCaso;
				for(int i = 0; i < cantNodos; i++)
					ordenMejorCasoWP[i] = nodos[i];
			}
			break;
		}
		return colorMejorCaso;
	}
	
	private boolean esAdyacente(Integer [] nodosDeEsteColor, int limite, int i) {
		boolean res = false;
		int nodoVisto = 0;
		while(nodoVisto < limite) {
			if (grafo.getArista(i, nodosDeEsteColor[nodoVisto]))
				res = true;
			nodoVisto++;
		}
		return res;
	}

	public void escribirArchivo() {
		grabar("coloreadoSecuencialAleatorio.out", colorMejorCasoSA, ordenMejorCasoSA);
		grabar("coloreadoMatula.out", colorMejorCasoMa, ordenMejorCasoMa);
		grabar("coloreadoWelsh-Powell.out", colorMejorCasoWP, ordenMejorCasoWP);
	}
	
	public void grabar(String path, int colorMejor, Nodo[] ordenMejor){
		File archivo;
		FileWriter writer;
		PrintWriter bufferOut = null;
		try {
			archivo = new File(path);
			writer = new FileWriter(archivo);
			bufferOut = new PrintWriter(writer);
			int cantNod = grafo.getCantNodos();
			int cantAr = grafo.cantidadAristas();
			double perc = (double) grafo.cantidadAristas() * 100 / grafo.getMaxAristas();
			bufferOut.println(cantNod + " " + colorMejor + " " + cantAr + " " + perc + " "
					+ gradMax + " " + gradMin);
			for(Nodo nodo: ordenMejor)
				bufferOut.println("nodo " + (nodo.getNodo() + 1) + " color " + nodo.getColor());
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (bufferOut != null)
				bufferOut.close();
		}
	}
}