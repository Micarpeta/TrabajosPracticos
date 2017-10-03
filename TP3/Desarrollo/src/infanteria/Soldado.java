package infanteria;

/**
 * Clase concreta Soldado
 * 
 * Atributos: energia
 * 
 *
 */

public class Soldado extends Unidad {

	/**
	 * Atributo energ�a
	 */
	private int energia;

	/**
	 * Constructor de soldado
	 */
	public Soldado() {
		this.distanciaMin = 0;
		this.distanciaMax = 1;
		this.energia = 100;
		this.salud = 200;
		this.puntosDa�o = 10;
	}
	
	/**
	 * M�todo beber Agua: recarga toda la energ�a.
	 */
	public void beberAgua() {
		this.energia = 100;
	}	

	/** 
	 * Setea la energia
	 * @param energia
	 */
	public void setEnergia(int energia) {
		this.energia = energia;
		
	}
	
	/**
	 * Obtiene la energ�a
	 * @return energ�a
	 */
//	@Override
	public int getEnergia() {
		return energia;
	}

	/**
	 * M�todo puede atacar de Soldado
	 */
	@Override
	protected boolean puedeAtacar(Unidad obj, int distancia) {
		if(!super.puedeAtacar(obj, distancia) || this.getEnergia()<10)
			return false;
		energia-=10;
		return true;
	}

}
