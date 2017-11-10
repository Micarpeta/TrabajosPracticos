package coloreador;

import java.util.Comparator;
import java.util.Random;

public class Nodo implements Comparable<Nodo>{
	protected int nodo;
	protected int grado;
	protected int color;
	
	public Nodo(int nodo, int grado) {
		this.nodo = nodo;
		this.grado = grado;
		color = 0;
	}

	public int getNodo() {
		return nodo;
	}

	public int getGrado() {
		return grado;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	@Override
	public int compareTo(Nodo o) {
		return this.grado > o.grado? 1: this.grado == o.grado? 0 : -1;
	}
	
	public static Comparator<Nodo> ComparadorDeGrados = new Comparator<Nodo>() {
		public int compare(Nodo g1, Nodo g2) {
			return g1.grado > g2.grado? -1: g1.grado == g2.grado? 0 : 1;
		}
	};

	public static void mezclar(Nodo[] vec) {
	    Random rnd = new Random();
	    for (int i = 0; i < vec.length; i++) {
	    	int pos = rnd.nextInt(vec.length);
	    	Nodo a = vec[pos];
	    	vec[pos] = vec[i];
	    	vec[i] = a;
	    }
	}
}
