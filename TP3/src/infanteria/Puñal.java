package infanteria;

/**
 * 
 * Clase concreta Puñal
 * 
 *
 */
public class Puñal extends ItemDecorator {

	/**
	 * Constructor
	 * @param unidad
	 */
	public Puñal(Unidad unidad) {
		super(unidad);
	}

	/**
	 * RECIBE EL ATAQUE Y LE CAUSA 3 PUNTOS DE DAÑO ADICIONALES POR POSEER UN PUÑAL
	 * @param puntosDaño2
	 */
	@Override
	public void recibiAtaque(int puntosDaño2) {
		unidad.recibiAtaque(puntosDaño2 + 3);		
	}
	
	/**
	 * @return puntosDaño + 3
	 */
	@Override
	public int getPuntosDaño() {
		return unidad.getPuntosDaño() + 3;
	}

}
