package infanteria;

public class Lancero extends Unidad{
	
	public Lancero() {
		this.distanciaMin=1;
		this.distanciaMax=3;
		this.salud=150;
		this.puntosDaño=25;
	}
	
	//el metodo puedeAtacar lo va a buscar directamente al padre-> Unidad

}
