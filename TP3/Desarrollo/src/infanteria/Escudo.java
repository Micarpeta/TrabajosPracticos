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
	 * @param puntosDaņo2
	 */
	@Override
	public void recibiAtaque(int puntosDaņo2) {
		unidad.recibiAtaque((int)(puntosDaņo2*0.4));
	}

	/**
	 * Metodo getPuntosDaņo
	 * @return puntosDaņo de la unidad
	 */
	@Override
	protected int getPuntosDaņo() {
		return unidad.getPuntosDaņo();
	}
}
