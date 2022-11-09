package es.florida;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Vista extends JFrame {

	private JFrame frame;
	private JButton btn_Fabricar;
	JTextArea textArea;
	private JTextField textField_NUM_Bacalao;
	private JTextField textField_NUM_Queso;
	private JTextField textField_NUM_Pollo;
	private JTextField textField_NUM_Jamon;
	private JLabel lblNewLabel_1;
	private JTextField textField_PRIORIDAD_Jamon;
	private JTextField textField_PRIORIDAD_Pollo;
	private JTextField textField_PRIORIDAD_Queso;
	private JTextField textField_PRIORIDAD_Bacalao;

	/**
	 * Metodo constructor de la clase Vista que inicializa los componentes
	 */
	public Vista() {
		initialize();
	}

	/**
	 * Metodo que contiene la ventana principal de la interfaz y tiene la llamada al
	 * metodo con los componentes
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 792, 301);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		components();
		this.frame.setVisible(true);
	}

	/**
	 * Metodo que contiene todos los componentes de la interfaz
	 * */
	private void components() {

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(192, 192, 192));
		desktopPane.setBounds(10, 11, 312, 247);
		frame.getContentPane().add(desktopPane);

		JLabel lblNewLabel = new JLabel("Croquetas de jamón");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 87, 134, 23);
		desktopPane.add(lblNewLabel);

		JLabel lblCroquetasDePollo = new JLabel("Croquetas de pollo");
		lblCroquetasDePollo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCroquetasDePollo.setBounds(10, 121, 134, 19);
		desktopPane.add(lblCroquetasDePollo);

		JLabel lblCroquetasDePollo_1 = new JLabel("Croquetas de queso");
		lblCroquetasDePollo_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCroquetasDePollo_1.setBounds(10, 182, 134, 22);
		desktopPane.add(lblCroquetasDePollo_1);

		JLabel lblCroquetasDePollo_1_1 = new JLabel("Croquetas de bacalao");
		lblCroquetasDePollo_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCroquetasDePollo_1_1.setBounds(10, 149, 134, 22);
		desktopPane.add(lblCroquetasDePollo_1_1);

		textField_NUM_Bacalao = new JTextField();
		textField_NUM_Bacalao.setColumns(10);
		textField_NUM_Bacalao.setBounds(154, 153, 71, 22);
		desktopPane.add(textField_NUM_Bacalao);

		textField_NUM_Queso = new JTextField();
		textField_NUM_Queso.setColumns(10);
		textField_NUM_Queso.setBounds(154, 184, 71, 22);
		desktopPane.add(textField_NUM_Queso);

		textField_NUM_Pollo = new JTextField();
		textField_NUM_Pollo.setColumns(10);
		textField_NUM_Pollo.setBounds(153, 120, 71, 22);
		desktopPane.add(textField_NUM_Pollo);

		textField_NUM_Jamon = new JTextField();
		textField_NUM_Jamon.setColumns(10);
		textField_NUM_Jamon.setBounds(153, 87, 71, 22);
		desktopPane.add(textField_NUM_Jamon);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(332, 11, 434, 246);
		frame.getContentPane().add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		textField_PRIORIDAD_Jamon = new JTextField();
		textField_PRIORIDAD_Jamon.setColumns(10);
		textField_PRIORIDAD_Jamon.setBounds(231, 87, 71, 22);
		desktopPane.add(textField_PRIORIDAD_Jamon);

		textField_PRIORIDAD_Pollo = new JTextField();
		textField_PRIORIDAD_Pollo.setColumns(10);
		textField_PRIORIDAD_Pollo.setBounds(231, 121, 71, 22);
		desktopPane.add(textField_PRIORIDAD_Pollo);

		textField_PRIORIDAD_Queso = new JTextField();
		textField_PRIORIDAD_Queso.setColumns(10);
		textField_PRIORIDAD_Queso.setBounds(231, 184, 71, 22);
		desktopPane.add(textField_PRIORIDAD_Queso);

		textField_PRIORIDAD_Bacalao = new JTextField();
		textField_PRIORIDAD_Bacalao.setColumns(10);
		textField_PRIORIDAD_Bacalao.setBounds(231, 154, 71, 22);
		desktopPane.add(textField_PRIORIDAD_Bacalao);

		lblNewLabel_1 = new JLabel("Nº croquetas");
		lblNewLabel_1.setBounds(161, 54, 63, 22);
		desktopPane.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));

		btn_Fabricar = new JButton("FABRICAR");
		btn_Fabricar.setBounds(10, 217, 292, 23);
		desktopPane.add(btn_Fabricar);

		JLabel lblNewLabel_1_1 = new JLabel("Prioridad");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1_1.setBounds(242, 54, 48, 22);
		desktopPane.add(lblNewLabel_1_1);

		Label label_2 = new Label("Fábrica de croquetas");
		label_2.setBounds(53, 10, 202, 22);
		desktopPane.add(label_2);
		label_2.setFont(new Font("Calibri", Font.PLAIN, 20));

	}

	/**
	 * Getter del text field de prioridad_Jamon
	 * @return Del text field
	 * */
	public JTextField getTextField_PRIORIDAD_Jamon() {
		return textField_PRIORIDAD_Jamon;
	}
	
	/**
	 * Getter del text field de prioridad_Pollo
	 * @return Del text field
	 * */
	public JTextField getTextField_PRIORIDAD_Pollo() {
		return textField_PRIORIDAD_Pollo;
	}

	/**
	 * Getter del text field de prioridad_Queso
	 * @return Del text field
	 * */
	public JTextField getTextField_PRIORIDAD_Queso() {
		return textField_PRIORIDAD_Queso;
	}

	/**
	 * Getter del text field de prioridad_Bacalao
	 * @return Del text field
	 * */
	public JTextField getTextField_PRIORIDAD_Bacalao() {
		return textField_PRIORIDAD_Bacalao;
	}

	/**
	 * Getter del text field de num_Bacalao
	 * @return Del text field
	 * */
	public JTextField getTextField_NUM_Bacalao() {
		return textField_NUM_Bacalao;
	}

	/**
	 * Getter del text field de num_Queso
	 * @return Del text field
	 * */
	public JTextField getTextField_NUM_Queso() {
		return textField_NUM_Queso;
	}

	/**
	 * Getter del text field de num_Pollo
	 * @return Del text field
	 * */
	public JTextField getTextField_NUM_Pollo() {
		return textField_NUM_Pollo;
	}

	/**
	 * Getter del text field de num_Jamon
	 * @return Del text field
	 * */
	public JTextField getTextField_NUM_Jamon() {
		return textField_NUM_Jamon;
	}

	/**
	 * Getter del text area
	 * @return Del text area
	 * */
	public JTextArea getTextArea() {
		return textArea;
	}

	/**
	 * Getter del btnFabricar
	 * @return Del btnFabricar
	 * */
	public JButton getBtnFabricar() {
		return btn_Fabricar;
	}
}

