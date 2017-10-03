package infanteria;

/**
 * 
 * Clase abstracta ItemDecorator
 *
 */
public abstract class ItemDecorator extends Unidad{
	
	protected Unidad unidad;
	
	/**
	 * ItemDecorator recibe una unidad a equipar
	 * @param unidad
	 */
	
	public ItemDecorator(Unidad unidad) {
		this.unidad=unidad;
	}
	
	/**
	 * Sobreescribe el metodo puede atacar del padre y se lo asigna a la unidad.
	 */
	@Override
	protected boolean puedeAtacar(Unidad obj, int distancia) {
		return unidad.puedeAtacar(obj, distancia);
	}
	
	/**
	 * Sobreescribe el metodo get Salud del padre y se lo asigna a la unidad.
	 */
	@Override
	public int getSalud() {
		return unidad.getSalud();
	}
	
}
