package utilidades;

public class Utilidad {

	
	public void limpiezaPantalla() {
		for(int i=0; i<100;i++) {
			System.out.println();
		}

	}
	
	public void imprimirSeccion(String titulo) {
		System.out.println("---------"+titulo+"-----------");
	}
}
