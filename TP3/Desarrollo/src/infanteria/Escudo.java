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
	 * @param puntosDa�o2
	 */
	@Override
	public void recibiAtaque(int puntosDa�o2) {
		unidad.recibiAtaque((int)(puntosDa�o2*0.4));
	}

	/**
	 * Metodo getPuntosDa�o
	 * @return puntosDa�o de la unidad
	 */
	@Override
	protected int getPuntosDa�o() {
		return unidad.getPuntosDa�o();
	}
}
