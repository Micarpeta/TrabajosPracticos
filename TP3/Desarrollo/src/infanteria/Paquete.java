package infanteria;

/**
 * 
 * Clase concreta Paquete
 * 
 * Atributo: cantFlechas
 *
 */

public class Paquete{
	
	private int cantFlechas;
	
	/**
	 * Constructor
	 * Setea como valor inicial de cantFlechas 6
	 */
	public Paquete() {
		this.cantFlechas=6;
	}

	/**
	 * Obtiene la cantidad de flechas
	 * @return cantFlechas
	 */
	public int getCantFlechas() {
		return cantFlechas;
	}
}
