package grafo;

public class GrafoNDNP extends MatrizSimetricaEnVector{

	public GrafoNDNP(int nodos) {
		super(nodos);
	}

	public void setArista(int fil, int col){
		vector[obtenerIndice(fil, col)] = true;
	} 
	
	public boolean getArista(int fil, int col) {
		return vector[obtenerIndice(fil, col)];
	}

	public void borrarArista(int fil, int col){
		vector[obtenerIndice(fil, col)] = false;
	}

	public int getMaxAristas() {
		return gradoMat*(gradoMat - 1)/2;
	}

	public int cantidadAristas() {
		int aristas = 0;
		int maxAristas = gradoMat*(gradoMat - 1)/2;
		for(int i = 0; i < maxAristas; i++)
			if(vector[i])
				aristas++;
		return aristas;
	}

	public int getGradoDeUnNodo(int nodo) {
		int grado = 0;
		for(int i = 0; i < gradoMat; i++)
			if(nodo != i && vector[obtenerIndice(nodo, i)])
				grado++;
		return grado;
	}
	
	public int getCantNodos() {
		return gradoMat;
	}
}
