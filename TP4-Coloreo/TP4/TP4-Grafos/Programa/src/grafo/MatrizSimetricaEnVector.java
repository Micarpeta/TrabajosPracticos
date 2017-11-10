package grafo;

public class MatrizSimetricaEnVector {
	protected boolean [] vector;
	protected int gradoMat;

	public MatrizSimetricaEnVector(int cantNodos) {
		this.gradoMat = cantNodos;
		int tamVector = cantNodos * (cantNodos - 1) / 2;
		vector = new boolean[tamVector];
	}

	//METODO PARA OBTENER LA POSICION EN EL VECTOR SEGUN LA FILA Y COLUMNA DE LA MATRIZ
	protected int obtenerIndice(int fil, int col) {
		int indiceVector;
		if (fil > col) {
			int auxiliar = col;
			col = fil;
			fil = auxiliar;
		}
		indiceVector = fil * gradoMat + col - (fil * fil + 3 * fil + 2) / 2;
		if(fil == col) {
			indiceVector = 0;
		}
		return indiceVector; 
	}

}
