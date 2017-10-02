package infanteria;

public class Capa extends ItemDecorator{
	
	public Capa(Unidad unidad) {
		
		super(unidad);
		if(unidad instanceof Soldado) {
			((Soldado)unidad).setEnergia(((Soldado)unidad).getEnergia()*2);
		}	 
	}	
	
	//ATAQUE
	@Override
	public int getPuntosDa�o() {
		if(unidad instanceof Soldado)
			return (int)(unidad.getPuntosDa�o()*0.9);
		return unidad.getPuntosDa�o();
	}
}
