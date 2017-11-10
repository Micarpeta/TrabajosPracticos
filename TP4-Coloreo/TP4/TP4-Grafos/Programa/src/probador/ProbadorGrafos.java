package probador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Clase que comprueba si un grafo esta bien coloreado
 *
 */
public class ProbadorGrafos extends Archivos {
	private int [][] comparadorAristas;
	private String [] color;
	private int cA, nodos;
	
	public ProbadorGrafos(String in, String out) {
		super(new File(in), new File(out));
		FileReader archEnt = null, archSal = null;
		BufferedReader lectorEnt = null, lectorSal;
		try {
			archEnt = new FileReader(entrada);
			archSal = new FileReader(salida);
			lectorEnt = new BufferedReader(archEnt);
			lectorSal = new BufferedReader(archSal);
			String [] aux = lectorEnt.readLine().split(" ");
			nodos = Integer.parseInt(aux[0]);
			color = new String[nodos];
			cA = Integer.parseInt(aux[1]);
			comparadorAristas = new int[cA][2];
			for(int i = 0; i < cA; i++) {
				aux = lectorEnt.readLine().split(" ");
				comparadorAristas[i][0] = Integer.parseInt(aux[0]);
				comparadorAristas[i][1] = Integer.parseInt(aux[1]);
			}
			lectorSal.readLine();
			for(int i = 0; i < nodos; i++) {
				aux = lectorSal.readLine().split(" ");
				color[i] = aux[1];
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				archEnt.close();
				archSal.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void resolver() {
		boolean casoCorrecto = true;
		for(int i = 0; i < cA; i++)
			casoCorrecto = !(color[comparadorAristas[i][0]].equals(color[comparadorAristas[i][1]]));
		System.out.println(casoCorrecto);
	}

}
