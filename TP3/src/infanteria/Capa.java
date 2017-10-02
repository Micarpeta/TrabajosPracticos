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
	public int getPuntosDaño() {
		if(unidad instanceof Soldado)
			return (int)(unidad.getPuntosDaño()*0.9);
		return unidad.getPuntosDaño();
	}
}
