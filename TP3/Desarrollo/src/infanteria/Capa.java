package infanteria;
/**
 * 
 * Clase concreta Capa hereda de ItemDecorator
 *
 */
public class Capa extends ItemDecorator{
	
	/**
	 * Constructor
	 * Si la unidad es un soldado, le setea el doble de energ�a
	 * @param unidad
	 */
	public Capa(Unidad unidad) {
		
		super(unidad);
		if(unidad instanceof Soldado) {
			((Soldado)unidad).setEnergia(((Soldado)unidad).getEnergia()*2);
		}	 
	}	
	
	//ATAQUE
	/**
	 * Si la unidad es un soldado retorna el 90% del da�o
	 */
	@Override
	public int getPuntosDa�o() {
		if(unidad instanceof Soldado)
			return (int)(unidad.getPuntosDa�o()*0.9);
		return unidad.getPuntosDa�o();
	}
	
	/**
	 * Si la unidad es un soldado
	 * @return soldado.energia sino retorna 0
	 */
	public int getEnergia() {
		if(unidad instanceof Soldado)
			return ((Soldado)unidad).getEnergia();
		return 0;
	}
}
