package infanteria;

public class Pu�al extends ItemDecorator {

	public Pu�al(Unidad unidad) {
		super(unidad);
	}

	// RECIBE EL ATAQUE Y LE CAUSA 3 PUNTOS DE DA�O ADICIONALES POR POSEER UN PU�AL
	@Override
	public void recibiAtaque(int puntosDa�o2) {
		unidad.recibiAtaque(puntosDa�o2 + 3);		
	}
	
	//ATAQUE +3
	@Override
	public int getPuntosDa�o() {
		return unidad.getPuntosDa�o() + 3;
	}
}
