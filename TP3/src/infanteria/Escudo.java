package infanteria;

/**
 * 
 * Clase concreta Escudo hereda de ItemDecorator
 *
 */
public class Escudo extends ItemDecorator{

	/**Constructor de Escudo
	 * @param unidad
	 */
	public Escudo(Unidad unidad) {
		super(unidad);
	}
	
	/**
	 * Recibe el ataque pero solo transmite a la unidad el 40% del mismo
	 * @param puntosDaño2
	 */
	@Override
	public void recibiAtaque(int puntosDaño2) {
		unidad.recibiAtaque((int)(puntosDaño2*0.4));
	}

	/**
	 * Metodo getPuntosDaño
	 * @return puntosDaño de la unidad
	 */
	@Override
	protected int getPuntosDaño() {
		return unidad.getPuntosDaño();
	}
}
