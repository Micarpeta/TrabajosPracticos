package infanteria;

public class Capa extends ItemDecorator{
	
	public Capa(Unidad unidad) {
		
		super(unidad);
		if(unidad instanceof Soldado) {
			this.unidad = (Soldado)unidad;
			if(((Soldado)unidad).getEnergia()<50)
				((Soldado)unidad).setEnergia(((Soldado)unidad).getEnergia()*2);
			else
				((Soldado)unidad).setEnergia(100);
		}	 
	}
	
//	public Capa(Soldado soldado) {
//		super(soldado);
//		if(((Soldado)unidad).getEnergia()<50)
//			((Soldado)unidad).setEnergia(soldado.getEnergia()*2);
//		else
//			((Soldado)unidad).setEnergia(100);
//	}
	
	
	//ATAQUE
	@Override
	public int getPuntosDaño() {
		if(unidad instanceof Soldado)
			return (int)(unidad.getPuntosDaño()*0.9);
		return unidad.getPuntosDaño();
	}
}


//public Capa(Unidad unidad) {
//	
//		
//		if(unidad instanceof Soldado) {
//			super(soldado);
//			this.unidad = (Soldado)unidad;
//			if(((Soldado)unidad).getEnergia()<50)
//				((Soldado)unidad).setEnergia(((Soldado)unidad).getEnergia()*2);
//			else
//				((Soldado)unidad).setEnergia(100);
//		}
//		else
//			unidad = null;
	 
//}
