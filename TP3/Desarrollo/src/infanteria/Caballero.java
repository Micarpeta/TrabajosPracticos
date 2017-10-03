package infanteria;

/**
 * 
 * Clase concreta Caballero hereda de Unidad
 * Atributos: ataquesRecibidos
 *
 */
public class Caballero extends Unidad {
	
	public int ataquesRecibidos;

	/**
	 * Constructor
	 * Setea los valores iniciales que debe tener el Caballero
	 */
	public Caballero() {
		this.distanciaMin=1;
		this.distanciaMax=2;
		this.salud=200;
		this.puntosDa�o=50;
		this.ataquesRecibidos=0;
	}

	/*
	 * Metodo beber poci�n de agua
	 */
	public void beberAgua() {
		this.ataquesRecibidos=0;
	}
	
	/**
	 * M�todo recibirAtaque
	 * Incrementa la cantidad de ataquesRecibidos y recibe el ataque como lo hace su padre Unidad 
	 */
	@Override
	protected void recibiAtaque(int puntosDa�o2) {
		this.ataquesRecibidos++;
		super.recibiAtaque(puntosDa�o2);
	}
	
	/**
	 * M�todo puedeAtacar
	 * @param obj
	 * @param distancia
	 * 
	 * Verifica que el Caballero pueda atacar teniendo en cuenta 
	 * a la distancia que se encuentra del objetivo, y la cantidad de ataques que recibio
	 */
	@Override
	protected boolean puedeAtacar(Unidad obj, int distancia) {
		if(!super.puedeAtacar(obj, distancia) || this.ataquesRecibidos>=3)
			return false;
		return true;
	}
}
