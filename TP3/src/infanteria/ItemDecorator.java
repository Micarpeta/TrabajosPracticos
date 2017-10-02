package infanteria;

public abstract class ItemDecorator extends Unidad{
	
	protected Unidad unidad;
	
	/**
	 * ItemDecorator recibe una unidad a equipar
	 * @param unidad
	 */
	
	public ItemDecorator(Unidad unidad) {
		this.unidad=unidad;
	}
	
	@Override
	protected boolean puedeAtacar(Unidad obj, int distancia) {
		return unidad.puedeAtacar(obj, distancia);
	}
	
	@Override
	public int getSalud() {
		return unidad.getSalud();
	}
	
}
