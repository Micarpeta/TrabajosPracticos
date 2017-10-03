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
	public int getPuntosDaņo() {
		if(unidad instanceof Soldado)
			return (int)(unidad.getPuntosDaņo()*0.9);
		return unidad.getPuntosDaņo();
	}
	
	
//	public int getEnergia() {
//		if(unidad instanceof Soldado)
//			return ((Soldado) unidad).getEnergia();
//		return 0;
//	}

}
