package infanteria;

public class Puñal extends ItemDecorator {

	public Puñal(Unidad unidad) {
		super(unidad);
	}

	// RECIBE EL ATAQUE Y LE CAUSA 3 PUNTOS DE DAÑO ADICIONALES POR POSEER UN PUÑAL
	@Override
	public void recibiAtaque(int puntosDaño2) {
		unidad.recibiAtaque(puntosDaño2 + 3);		
	}
	
	//ATAQUE +3
	@Override
	public int getPuntosDaño() {
		return unidad.getPuntosDaño() + 3;
	}
}
