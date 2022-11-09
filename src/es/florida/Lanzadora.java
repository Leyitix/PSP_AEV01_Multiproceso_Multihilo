package es.florida;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Lanzadora {

	public static Vista vista;
	public static ActionListener actionListenerFabricar;

	/**
	 * Metodo que se encarga de ejecutar la aplicacion Procesadora
	 * 
	 * @param Recibe como parametros dos enteros por cada tipo de croqueta. Un
	 *               entero es para el numero de croquetas y otro es para la
	 *               prioridad de fabricacion para cada una
	 *
	 **/
	public static void lanzador(int numJamon, int numPollo, int numBacalao, int numQueso, int prioridadJamonm,
			int prioridadPollo, int prioridadBacalao, int prioridadQueso) {

		String clase = "es.florida.Procesadora";

		String nJ = Integer.toString(numJamon);
		String nP = Integer.toString(numPollo);
		String nB = Integer.toString(numBacalao);
		String nQ = Integer.toString(numQueso);

		String pJ = Integer.toString(prioridadJamonm);
		String pP = Integer.toString(prioridadPollo);
		String pB = Integer.toString(prioridadBacalao);
		String pQ = Integer.toString(prioridadQueso);

		try {

			String javaHome = System.getProperty("java.home");
			String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
			String classpath = System.getProperty("java.class.path");
			System.out.println(classpath);
			String className = clase;

			List<String> command = new ArrayList<String>();
			command.add(javaBin);
			command.add("-cp");
			command.add(classpath);
			command.add(className);
			command.add(nJ.toString());
			command.add(nP.toString());
			command.add(nB.toString());
			command.add(nQ.toString());
			command.add(pJ.toString());
			command.add(pP.toString());
			command.add(pB.toString());
			command.add(pQ.toString());

			ProcessBuilder builder = new ProcessBuilder(command);
			Process process = builder.inheritIO().start();
			process.waitFor();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Método Main de la aplicacion lanzadora
	 */
	public static void main(String[] args) {

		vista = new Vista();

		/**
		 * Metodo que se ejecuta al pulsar en el boton fabricar y que recibe desde la
		 * interfaz el numero de croquetas y su prioridad de fabricacion. Una vez
		 * recibida la cantidad cuenta si las croquetas son multiples de 6 y si no
		 * cuadran no dejara ejecutar el programa (doy la opcion de restar las croquetas
		 * restantes). Una vez las croquetqas sean las correctas se enviaran a la clase
		 * Procesadora
		 **/
		actionListenerFabricar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String numCroquetasJamon = vista.getTextField_NUM_Jamon().getText();
				int numCroquetasJamon_int = Integer.parseInt(numCroquetasJamon);

				String numCroquetasPollo = vista.getTextField_NUM_Pollo().getText();
				int numCroquetasPollo_int = Integer.parseInt(numCroquetasPollo);

				String numCroquetasBacalao = vista.getTextField_NUM_Bacalao().getText();
				int numCroquetasBacalao_int = Integer.parseInt(numCroquetasBacalao);

				String numCroquetasQueso = vista.getTextField_NUM_Queso().getText();
				int numCroquetasQueso_int = Integer.parseInt(numCroquetasQueso);

				String prioridadJamon = vista.getTextField_PRIORIDAD_Jamon().getText();
				int prioridadJamon_int = Integer.parseInt(prioridadJamon);

				String prioridadPollo = vista.getTextField_PRIORIDAD_Pollo().getText();
				int prioridadPollo_int = Integer.parseInt(prioridadPollo);

				String prioridadBacalao = vista.getTextField_PRIORIDAD_Bacalao().getText();
				int prioridadBacalao_int = Integer.parseInt(prioridadBacalao);

				String prioridadQueso = vista.getTextField_PRIORIDAD_Queso().getText();
				int prioridadQueso_int = Integer.parseInt(prioridadQueso);

				int jamon = 0;
				int sobrantesJamon = 0;

				int pollo = 0;
				int sobrantesPollo = 0;

				int bacalao = 0;
				int sobrantesBacalao = 0;

				int queso = 0;
				int sobrantesQueso = 0;

				int paquetes = 0;

				for (int i = 1; i <= numCroquetasJamon_int; i++) {
					jamon++;
					if (jamon % 6 == 0) {
						paquetes += 1;
						sobrantesJamon = 0;
					} else {
						sobrantesJamon += 1;
					}

				}

				for (int i = 1; i <= numCroquetasPollo_int; i++) {
					pollo++;
					if (pollo % 6 == 0) {
						paquetes += 1;
						sobrantesPollo = 0;
					} else {
						sobrantesPollo += 1;
					}

				}

				for (int i = 1; i <= numCroquetasBacalao_int; i++) {
					bacalao++;
					if (bacalao % 6 == 0) {
						paquetes += 1;
						sobrantesBacalao = 0;
					} else {
						sobrantesBacalao += 1;
					}

				}

				for (int i = 1; i <= numCroquetasQueso_int; i++) {
					queso++;
					if (queso % 6 == 0) {
						paquetes += 1;
						sobrantesQueso = 0;
					} else {
						sobrantesQueso += 1;
					}

				}

				vista.getTextArea().append("NO SE PUEDEN EMPAQUETAR " + sobrantesJamon + " DE JAMÓN \n");
				vista.getTextArea().append("NO SE PUEDEN EMPAQUETAR " + sobrantesPollo + " DE POLLO \n");
				vista.getTextArea().append("NO SE PUEDEN EMPAQUETAR " + sobrantesBacalao + " DE BACALAO \n");
				vista.getTextArea().append("NO SE PUEDEN EMPAQUETAR " + sobrantesQueso + " DE QUESO \n");

				if (sobrantesJamon > 0 || sobrantesPollo > 0 || sobrantesBacalao > 0 || sobrantesQueso > 0) {

					JOptionPane.showMessageDialog(new JFrame(),
							"Las croquetas deben producirse en paquetes de 6 del mismo tipo", "ERROR EN LA PRODUCCIÓN!",
							JOptionPane.ERROR_MESSAGE);

					int option = JOptionPane.showConfirmDialog(null,
							"Deseas eliminar de la producción las croquetas que no se pueden empaquetar?",
							"Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (option == 0) {

						numCroquetasJamon_int -= sobrantesJamon;
						numCroquetasPollo_int -= sobrantesPollo;
						numCroquetasBacalao_int -= sobrantesBacalao;
						numCroquetasQueso_int -= sobrantesQueso;
						int total = numCroquetasJamon_int + numCroquetasPollo_int + numCroquetasBacalao_int
								+ numCroquetasQueso_int;

						vista.getTextArea().append("SE VAN A PRODUCIR " + total + " CROQUETAS \n");
						vista.getTextArea().append("TOTAL DE PAQUETES A FABRICAR: " + paquetes + "\n");

						lanzador(numCroquetasJamon_int, numCroquetasPollo_int, numCroquetasBacalao_int,
								numCroquetasQueso_int, prioridadJamon_int, prioridadPollo_int, prioridadBacalao_int,
								prioridadQueso_int);

					} else if (option == 1) {
						JOptionPane.showMessageDialog(new JFrame(), "Vuelve a introducir un número válido de croquetas",
								"", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}

		};

		vista.getBtnFabricar().addActionListener(actionListenerFabricar);

	}

}
