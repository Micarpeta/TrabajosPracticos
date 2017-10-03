package infanteria;
/**
 * 
 * Clase concreta Lancero hereda de Unidad
 *
 */
public class Lancero extends Unidad{
	/**
	 * Constructor
	 * Setea los valores iniciales que debe tener el Lancero
	 */
	public Lancero() {
		this.distanciaMin=1;
		this.distanciaMax=3;
		this.salud=150;
		this.puntosDaño=25;
	}
}
