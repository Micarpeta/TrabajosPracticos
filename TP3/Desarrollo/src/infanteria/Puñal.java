package infanteria;

/**
 * 
 * Clase concreta Pu�al
 * 
 *
 */
public class Pu�al extends ItemDecorator {

	/**
	 * Constructor
	 * @param unidad
	 */
	public Pu�al(Unidad unidad) {
		super(unidad);
	}

	/**
	 * RECIBE EL ATAQUE Y LE CAUSA 3 PUNTOS DE DA�O ADICIONALES POR POSEER UN PU�AL
	 * @param puntosDa�o2
	 */
	@Override
	public void recibiAtaque(int puntosDa�o2) {
		unidad.recibiAtaque(puntosDa�o2 + 3);		
	}
	
	/**
	 * @return puntosDa�o + 3
	 */
	@Override
	public int getPuntosDa�o() {
		return unidad.getPuntosDa�o() + 3;
	}

}
