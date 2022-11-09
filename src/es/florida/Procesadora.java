package es.florida;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Procesadora {

	static ArrayList<String> contenidoFichero = new ArrayList<String>();
	public static Vista vista;
	long tiempoFin = 0;
	public static long tiempoInicio = 0;
	public int numCroqueta = 0;

	/**
	 * Metodo procesar contiene el numero de croquetas, las prioridades, el tiempo
	 * que cada una tarda en fabricarse, los tipos de croquetas y el total que se
	 * fabricara. Desde este metodo se controla el tiempo que tardan todos los hilos
	 * en terminar. Desde aqui a traves del bucle anidado se lanzan la totalidad de
	 * croquetas (hilos) que el usuario ha introducido en la interfaz.
	 * 
	 * @param Recibe las cantidades correspondientes a cada croqueta y sus
	 *               prioridades
	 */
	public void procesar(int numJamon, int numPollo, int numBacalao, int numQueso, int pJamon, int pPollo, int pBacalao,
			int pQueso) throws IOException {

		Thread hiloCroqueta;

		tiempoInicio = System.nanoTime(); // inicio del tiempo de ejecución

		int numCroquetas[] = { numJamon, numPollo, numBacalao, numQueso };
		int[] prioridades = { pJamon, pPollo, pBacalao, pQueso };
		String[] tiposCroquetas = { "jamon", "pollo", "bacalao", "queso" };
		int[] tiempoFabricacion = { 5000, 6000, 7000, 8000 };
		int totalAFabricar = numJamon + numPollo + numBacalao + numQueso;

		Pedido pedido = new Pedido(totalAFabricar);
		Croqueta croqueta;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < numCroquetas[i]; j++) {
				numCroqueta++;
				croqueta = new Croqueta(tiposCroquetas[i], tiempoFabricacion[i], pedido, numCroqueta);
				hiloCroqueta = new Thread(croqueta);
				hiloCroqueta.setPriority(prioridades[i]);
				hiloCroqueta.start();
			}
		}
		while (pedido.getTotalAFabricar() > 0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		tiempoFin = System.nanoTime();

		long duracion = (tiempoFin - tiempoInicio) / 1000000; // milisegundos
		System.out.println("Fin - Tiempo ejecucion total: " + duracion + " ms");
		JOptionPane.showMessageDialog(new JFrame(), "Fin - Tiempo ejecución total: " + duracion + " ms",
				"SE HAN FABRICADO TODAS LAS CROQUETAS!", JOptionPane.INFORMATION_MESSAGE);

	}

	/**
	 * Metodo principal de la aplicacion procesadora llama a la clase Procesadora y
	 * le pasa los argumentos al metodo. Tambien comprueba si extiste un fichero ya
	 * creado, si existe lo borra y despues lo crea, y si no existe lo crea (esto lo
	 * he anyadido para poder ver todo el contenido de la consola)
	 * 
	 * @param Recibe como parametros cada uno de los argumentos que lanza la
	 *               aplicacion lanzadora y se los pasa como paramentros al metodo
	 *               procesar
	 */
	public static void main(String[] args) throws IOException {

		// la consola no permite ver todas las lineas por eso creo un fichero donde
		// se almacenan todos los resultados
		File fichero = new File("croquetas.txt");

		if (fichero.exists()) {
			File borrarFichero = new File("croquetas.txt");
			borrarFichero.delete();
			fichero.createNewFile();
		} else {
			fichero.createNewFile();
		}

		Procesadora procesadora = new Procesadora();

		int numJamon = Integer.parseInt(args[0]);
		int numPollo = Integer.parseInt(args[1]);
		int numBacalao = Integer.parseInt(args[2]);
		int numQueso = Integer.parseInt(args[3]);
		int pJamon = Integer.parseInt(args[4]);
		int pPollo = Integer.parseInt(args[5]);
		int pBacalao = Integer.parseInt(args[6]);
		int pQueso = Integer.parseInt(args[7]);

		procesadora.procesar(numJamon, numPollo, numBacalao, numQueso, pJamon, pPollo, pBacalao, pQueso);

	}

}
