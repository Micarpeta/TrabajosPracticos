package infanteria;

public class Escudo extends ItemDecorator{

	public Escudo(Unidad unidad) {
		super(unidad);
	}
	
	// RECIBE EL ATAQUE PERO SOLO EL 40% DEL MISMO
	@Override
	public void recibiAtaque(int puntosDaño2) {
		unidad.recibiAtaque((int)(puntosDaño2*0.4));
	}

	@Override
	protected int getPuntosDaño() {
		return unidad.getPuntosDaño();
	}
	
}
