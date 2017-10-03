package infanteria;

/**
 * 
 * Clase concreta Arquero hereda de Unidad
 * Atributos: cantFlechas
 * 
 */
public class Arquero extends Unidad{
	
	private int cantFlechas;
	
	/**
	 * Constructor
	 * Setea los valores iniciales que debe tener el Arquero
	 */
	public Arquero() {
		this.distanciaMin=2;
		this.distanciaMax=5;
		this.salud=50;
		this.puntosDaño=5;
		this.cantFlechas=20;
	}
	
	/**
	 * Metodo recargar Carcaj
	 * Recarga el carcaj con el paquete de flechas que recibe
	 * @param paquete
	 */
	public void recargarCarcaj(Paquete paquete) {
		this.cantFlechas+=paquete.getCantFlechas();
	}
	
	/**
	 * Metodo obtener cantidad de flechas
	 * @return cantidad de flechas
	 */
	public int getCantFlechas() {
		return cantFlechas;
	}	

	/**
	 * Si el objetivo se encuentra distancia de ataque y tiene flechas, entonces puede atacar
	 * @return si puede atacar o no 
	 */
	@Override
	protected boolean puedeAtacar(Unidad obj, int distancia) {
		if(!super.puedeAtacar(obj, distancia) || this.getCantFlechas()<=0)
			return false;
		this.cantFlechas--;
		return true;
	}

}
