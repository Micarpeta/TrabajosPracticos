package infanteria;

public class Caballero extends Unidad {
	
	public int ataquesRecibidos;
	
	public Caballero() {
		this.distanciaMin=1;
		this.distanciaMax=2;
		this.salud=200;
		this.puntosDa�o=50;
		this.ataquesRecibidos=0;
	}

	//M�todo beber poci�n de Agua
	public void beberAgua() {
		this.ataquesRecibidos=0;
	}
	
	//M�todo recibiAtaque -> debo incrementarle el ataque recibido
	@Override
	protected void recibiAtaque(int puntosDa�o2) {
		this.ataquesRecibidos++;
		super.recibiAtaque(puntosDa�o2);
	}
	
	//Verifica si puede atacar -> es decir, si el caballo no esta rebelde.
	@Override
	protected boolean puedeAtacar(Unidad obj, int distancia) {
		if(!super.puedeAtacar(obj, distancia) || this.ataquesRecibidos>=3)
			return false;
		return true;
	}

	
}
