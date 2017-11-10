package grafo;

public class Grafo {
	private boolean [] adyacente;
	private int grado;

	public Grafo(int nodos) {
		grado = nodos;
		adyacente = new boolean[grado*(grado - 1)/2];
	}

	private int convertirIJ(int fil, int col) {
		return fil*grado+col-(fil*fil+3*fil+2)/2;
	}

	public boolean getArista(int fil, int col) {
		return adyacente[convertirIJ(fil, col)];
	}

	public int getFila(int i) { 
		return (int) (adyacente.length - (Math.ceil(1 + Math.sqrt(1+ 8 *(adyacente.length - i))))/ 2);
	}

	public int getColumna(int i) {
		return grado - (adyacente.length - i - ((grado - getFila(i) - 1) * 2 - (grado - getFila(i) - 1))/2);
	}

	public void setArista(int fil, int col) {
		adyacente[convertirIJ(fil, col)] = true;
	}

	public void eliminarArista(int fil, int col) {
		adyacente[convertirIJ(fil, col)] = false;
	}

	public int getOrden() {
		return grado;
	}

	public int getMaxAristas() {
		return grado*(grado - 1)/2;
	}

	public int cantidadAristas() {
		int aristas = 0;
		int maxAristas = grado*(grado - 1)/2;
		for(int i = 0; i < maxAristas; i++)
			if(adyacente[i])
				aristas++;
		return aristas;
	}

	public int getGrado(int nodo) {
		int grado = 0;
		for(int i = 0; i < grado; i++)
			if(adyacente[convertirIJ(nodo, i)])
				grado++;
		return grado;
	}

}
