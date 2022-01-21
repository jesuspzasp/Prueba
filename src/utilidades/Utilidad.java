package utilidades;

public class Utilidad {
	public static void tiempoDeEspera() {
		int esperar = 10;
		try {
			for (int i = 0; i < esperar; i++) {
				Thread.sleep(150);
			}

		} catch (InterruptedException ie) {
			System.out.print("Tiempo de espera interrumpido");
		}
	}

	public static void limpiarPantalla() {
		for (int i = 0; i < 10; i++) {
			System.out.print("");
		}
		System.out.flush();
	}

	public static void sigue() {
		tiempoDeEspera();
		limpiarPantalla();
	}
}
