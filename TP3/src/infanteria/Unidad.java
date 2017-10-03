package infanteria;
/**
 * Clase Abstracta Unidad
 * 
 * Atributos: salud, distanciaMin, distanciaMax, puntosDaño
 * 
 */
public abstract class Unidad {
	
	protected int salud;
	protected int distanciaMin;
	protected int distanciaMax;
	protected int puntosDaño;
	
	/**
	 * Método Atacar:
	 * Pregunto si puedo atacar con distintas unidades.
	 * @param objetivo
	 * @param distancia
	 */
	public final void atacar(Unidad objetivo,int distancia) {
		if(puedeAtacar(objetivo, distancia)) {
			atacar(objetivo);
		}
	}
	
	/**
	 * Ataco al objetivo obteniendo los puntos de daño del atacante.
	 * @param objetivo
	 */
	private void atacar(Unidad objetivo) {
		objetivo.recibiAtaque(getPuntosDaño());
	}

	/**
	 * Recibi ataque
	 * Resta la salud al objetivo atacado.
	 * @param puntosDaño2
	 */
	protected void recibiAtaque(int puntosDaño2) {
		this.salud-=puntosDaño2;
	}

	/**
	 * Método puedeAtacar.
	 * @param obj
	 * @param distancia
	 * @return si puede atacar evaluando las condiciones
	 */
	protected boolean puedeAtacar(Unidad obj, int distancia) {
		if(this.salud<=0 || obj.getSalud()<=0)
			return false;
		if(distancia<this.distanciaMin || distancia>this.distanciaMax)
			return false;
		return true;
	}
	
	/**
	 * Retorna la salud de la unidad.
	 * @return salud
	 */
	public int getSalud() {
		return salud;
	}
	
	/**
	 * Retorna los puntos de daño de la unidad.
	 * @return puntosDaño
	 */
	protected int getPuntosDaño() {
		return this.puntosDaño;
	}
	
}
