package infanteria;
/**
 * Clase Abstracta Unidad
 * 
 * Atributos: salud, distanciaMin, distanciaMax, puntosDa�o
 * 
 *
 */
public abstract class Unidad {
	
	protected int salud;
	protected int distanciaMin;
	protected int distanciaMax;
	protected int puntosDa�o;
	
	/**
	 * M�todo Atacar:
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
	 * Ataco al objetivo obteniendo los puntos de da�o del atacante.
	 * @param objetivo
	 */
	private void atacar(Unidad objetivo) {
		objetivo.recibiAtaque(getPuntosDa�o());
	}

	/**
	 * Recibi ataque
	 * Resta la salud al objetivo atacado.
	 * @param puntosDa�o2
	 */
	protected void recibiAtaque(int puntosDa�o2) {
		this.salud-=puntosDa�o2;
	}

	/**
	 * M�todo boolean que devuelve si puede o no atacar.
	 * @param obj
	 * @param distancia
	 * @return
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
	 * @return
	 */
	public int getSalud() {
		return salud;
	}
	
	/**
	 * Retorna los puntos de da�o de la unidad.
	 * @return
	 */
	protected int getPuntosDa�o() {
		return this.puntosDa�o;
	}
}
