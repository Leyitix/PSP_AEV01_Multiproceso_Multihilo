package es.florida;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class Croqueta implements Runnable {

	public static ArrayList<String> resultados = new ArrayList<>();

	private String tipoCroqueta;
	private int tiempoFabricacion;
	private Pedido pedido;
	private int numCroqueta;
	public static int completadas = 0;

	/**
	 * Metodo constructor de la clase Croqueta
	 * 
	 * @param Recibe como parametro el tipo de croqueta de cada hilo, su tiempo de
	 *               fabricacion, el pedido que se ha realizado y el numero de la
	 *               croqueta que se esta procesando
	 */
	public Croqueta(String tipoCroqueta, int tiempoFabricacion, Pedido pedido, int numCroqueta) {
		this.tipoCroqueta = tipoCroqueta;
		this.tiempoFabricacion = tiempoFabricacion;
		this.pedido = pedido;
		this.numCroqueta = numCroqueta;
	}

	/**
	 * Metodo en el que procesaran todas las croquetas mientras queden hilos por
	 * ejecutar, cada una de las croquetas se fabricara en un determinado tiempo y
	 * cuando se complete una al 100% se incrementara el contador de croquetas
	 * finalizadas y esa croqueta se restara del total a fabricar en el pedido.
	 * Tambien se escribiran cada uno de los resultados en un fichero porque cuando
	 * hay muchos resultados no es posible verlos todos en consola. Cuando se
	 * complete esa croqueta el proceso pasara a false y podra entrar una nueva
	 * croqueta
	 */
	void fabricarCroquetas() {

		boolean enProceso = true;

		while (enProceso) {
			synchronized (pedido) {
				if (pedido.getTotalAFabricar() > 0) {
					double avance = 0;
					double porcentaje = 0;
					try {
						while (avance < tiempoFabricacion) {
							avance += 500 * 1;
							porcentaje = 100 * avance / tiempoFabricacion;

							String totalCompletada = "Croqueta numero " + numCroqueta + " de " + tipoCroqueta
									+ " - completada al " + String.format("%.0f", porcentaje) + " %";
							System.out.println(totalCompletada);
							resultados.add(totalCompletada);

							if (porcentaje == 100.0) {
								completadas++;
								String finalizada = "Croqueta numero " + numCroqueta + " de " + tipoCroqueta
										+ " ha trerminado de fabricarse!! (COMPLETADAS: " + completadas + ")";
								System.err.println(finalizada);
								resultados.add(finalizada);

								pedido.setTotalAFabricar(pedido.getTotalAFabricar() - 1);

								String restantes = "Croqueta de " + tipoCroqueta + " numero " + numCroqueta
										+ " terminada (quedan " + pedido.getTotalAFabricar() + " croquetas)";
								System.out.println(restantes);
								resultados.add(restantes);

								File fichero = new File("croquetas.txt");
								FileWriter fw;

								try {
									fw = new FileWriter(fichero);
									BufferedWriter bw = new BufferedWriter(fw);

									for (String resultado : resultados) {
										bw.write(String.valueOf(resultado + "\n"));
									}

									bw.close();
									fw.close();

								} catch (Exception e) {
									e.printStackTrace();
								}

								enProceso = false;

							}
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}

						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * Este metodo ejecutra un hillo y lo llama el metodo start() que se encuentra
	 * en la clase procesadora
	 */
	@Override
	public void run() {
		fabricarCroquetas();
	}

}
