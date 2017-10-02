package infanteria;

public class Escudo extends ItemDecorator{

	public Escudo(Unidad unidad) {
		super(unidad);
	}
	
	// RECIBE EL ATAQUE PERO SOLO EL 40% DEL MISMO
	@Override
	public void recibiAtaque(int puntosDa�o2) {
		unidad.recibiAtaque((int)(puntosDa�o2*0.4));
	}

	@Override
	protected int getPuntosDa�o() {
		return unidad.getPuntosDa�o();
	}
	
}
