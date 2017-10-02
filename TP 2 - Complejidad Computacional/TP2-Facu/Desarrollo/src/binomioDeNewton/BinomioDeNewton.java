package binomioDeNewton;

public class BinomioDeNewton {
	int a;
	int b;
	int n;
	static int[][] pascal;
	static int g = -1;
	
	public BinomioDeNewton(int a, int b, int n){
		this.a = a;
		this.b = b;
		this.n = n;
	}
	
	public void setG(int g) {
		BinomioDeNewton.g = g;
	}
	
	public int getG() {
		return g;
	}
	
	public static void setPascal(int[][] pascal) {
		BinomioDeNewton.pascal = pascal;
	}
	
	//RESOLUCION DEL BINOMIO DE NEWTON USANDO METODOS NO RECURSIVOS
	
	private long factorial(int n){
		long factorial = 1;
		for(int i=1; i <= n; i++){
			factorial *= i;
		}
		return factorial;
	}
	
	public long obtenerCoeficienteEnK(int k){
		long coeficiente = factorial(this.n)/(factorial(k)*factorial(n-k));
		return coeficiente;
	}
	
	public long[] obtenerCoeficientes() {
		
		long[] coeficientes = new long[this.n + 1];
		
		for(int i = 0; i <= this.n; i++) {
			coeficientes[i] = obtenerCoeficienteEnK(i);
		}
		return coeficientes;
	}
	
	public long desarrolloCompletoDelBinomio(int x){
		long resultado =0;
		long[] coeficientes = obtenerCoeficientes();
		
		for(int k = 0; k <= n; k ++){
			resultado +=coeficientes[k] * Math.pow(this.a*x, this.n -k) * Math.pow(this.b, k);
		}
		return resultado;
	}
	
	
	//RESOLUCION DEL BINOMIO DE NEWTON USANDO RECURSIVIDAD
	
	private long factorialRecursivo(int n){
		if(n > 0){
			return n* factorialRecursivo(n-1);
		}
		return 1;
	}
	
	public long obtenerCoeficienteEnKRecursivo(int k){
		long coeficiente = factorialRecursivo(this.n)/(factorialRecursivo(k)*factorialRecursivo(n-k));
		return coeficiente;
	}
	
	public long[] obtenerCoeficientesRecursivo() {
		
		long[] coeficientes = new long[this.n + 1];
		
		for(int i = 0; i <= this.n; i++) {
			coeficientes[i] = obtenerCoeficienteEnKRecursivo(i);
		}
		return coeficientes;
	}
	
	public long desarrolloCompletoDelBinomioRecursivo(int x){
		long resultado = 0;
		long[] coeficientes = obtenerCoeficientesRecursivo();
		
		for(int k = 0; k <= n; k ++){
			resultado += coeficientes[k] * Math.pow(this.a*x, this.n -k) * Math.pow(this.b, k);
		}
		return resultado;
	}
	
	
	//RESOLUCION DEL BINOMIO DE NEWTON USANDO PROGRAMACION DINAMICA CON MEMORIZACION
	
	public long desarrolloCompletoDelBinomioProgDinamicaMemorizando(int x) {
		long resultado = 0;
		
		llenarTrianguloPascal(this.n);
		
		for(int k = 0; k <= n; k ++){
			resultado += pascal[n][k] * Math.pow(this.a*x, this.n -k) * Math.pow(this.b, k);
		}
		return resultado;
		
	}
	
	private void llenarTrianguloPascal(int n) {
		
		if(this.getG() < n){
			this.setG(n);
			int pasc[][] = new int[n+1][n+1];
			
			for (int i = 0; i <= n; i++){
				pasc[i][i] = 1;
				pasc[i][0] = 1;
			}
			for (int i = 2; i <= n; i++) {
				for (int j = 1; j < i; j++) {
					pasc[i][j] = pasc[i - 1][j] + pasc[i - 1][j - 1];
				}
			}
			setPascal(pasc);
		}
	}

}
