package infanteria;

public class Arquero extends Unidad{
	
	private int cantFlechas;
	
	public Arquero() {
		this.distanciaMin=2;
		this.distanciaMax=5;
		this.salud=50;
		this.puntosDaño=5;
		this.cantFlechas=20;
	}
	
	// Método recargar Carcaj
	public void recargarCarcaj(Paquete paquete) {
		this.cantFlechas+=paquete.getCantFlechas();
	}
	
	
	public int getCantFlechas() {
		return cantFlechas;
	}	

	//Verifica si puede atacar
	@Override
	protected boolean puedeAtacar(Unidad obj, int distancia) {
		if(!super.puedeAtacar(obj, distancia) || this.getCantFlechas()<=0)
			return false;
		this.cantFlechas--;
		return true;
	}

}
