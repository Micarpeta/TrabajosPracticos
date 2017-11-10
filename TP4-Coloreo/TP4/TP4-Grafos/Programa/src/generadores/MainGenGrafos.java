package generadores;

public class MainGenGrafos {

	public static void main(String[] args) {
		try {
			GeneradorAdy genAdy600_40 = new GeneradorAdy(600, 40);
			GeneradorAdy genAdy600_60 = new GeneradorAdy(600, 60);
			GeneradorAdy genAdy600_90 = new GeneradorAdy(600, 90);
//			GeneradorRegularAdy genAdy1000_50 = new GeneradorRegularAdy(1000, 50);
//			GeneradorRegularAdy genAdy1000_75 = new GeneradorRegularAdy(1000, 75);
			GeneradorProbabilidad genProb5_60 = new GeneradorProbabilidad(5, 0.6);
			GeneradorRegularGrado genReg6_3 = new GeneradorRegularGrado(6, 3);
			
			
			genAdy600_40.procesarSalida("grafo600_40.in");
			genAdy600_60.procesarSalida("grafo600_60.in");
			genAdy600_90.procesarSalida("grafo600_90.in");
//			genAdy1000_50.imprimir("grafo1000_50.in");
//			genAdy1000_75.imprimir("grafo1000_75.in");
			genProb5_60.procesarSalida("grafo5_60.in");
			genReg6_3.procesarSalida("grafo6_3.in");
			
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Generador falló. Revisar.");
		}
	}

}
