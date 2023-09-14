package igu;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Titulo: Clase VentanaConfirmación
 * 
 * @author UO281847
 * @version 23/09/2021
 */
public class VentanaConfirmación extends JDialog {
	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo lblTick
	 */
	private JLabel lblTick;
	/**
	 * Atributo lblFinalizar
	 */
	private JLabel lblFinalizar;
	/**
	 * Atributo lblRecogida
	 */
	private JLabel lblRecogida;
	/**
	 * Atributo tfCodigo
	 */
	private JTextField tfCodigo;
	/**
	 * Atributo btnNewButton
	 */
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaConfirmación dialog = new VentanaConfirmación();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor de la ventana confrimación
	 */
	public VentanaConfirmación() {
		setTitle("McDonald's: Confirmaci\u00F3n de Pedido");
		setBounds(100, 100, 600, 300);
		getContentPane().setLayout(null);
		getContentPane().add(getLblTick());
		getContentPane().add(getLblFinalizar());
		getContentPane().add(getLblRecogida());
		getContentPane().add(getTfCodigo());
		getContentPane().add(getBtFinalizar());

	}
	
	/**
	 * Método que crea la etiqueta de Tick
	 * 
	 * @return etiqueta
	 */
	private JLabel getLblTick() {
		if (lblTick == null) {
			lblTick = new JLabel("");
			lblTick.setIcon(new ImageIcon(VentanaConfirmación.class.getResource("/img/ok.png")));
			lblTick.setBounds(10, 75, 50, 56);
		}
		return lblTick;
	}
	
	/**
	 * Método que crea la etiqueta Finalizar
	 * 
	 * @return etiqueta 
	 */
	private JLabel getLblFinalizar() {
		if (lblFinalizar == null) {
			lblFinalizar = new JLabel("Pulse Finalizar para confirmar su pedido");
			lblFinalizar.setFont(new Font("Arial Black", Font.PLAIN, 22));
			lblFinalizar.setBounds(70, 92, 504, 25);
		}
		return lblFinalizar;
	}
	
	/**
	 * Método que crea la etiqueta recogida
	 * 
	 * @return etiqueta
	 */
	private JLabel getLblRecogida() {
		if (lblRecogida == null) {
			lblRecogida = new JLabel("El c\u00F3digo de recogida es:");
			lblRecogida.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblRecogida.setBounds(132, 128, 206, 25);
		}
		return lblRecogida;
	}
	
	/**
	 * Método que crea el textField codigo
	 * 
	 * @return textField
	 */
	private JTextField getTfCodigo() {
		if (tfCodigo == null) {
			tfCodigo = new JTextField();
			tfCodigo.setEditable(false);
			tfCodigo.setBounds(348, 128, 101, 31);
			tfCodigo.setColumns(10);
		}
		return tfCodigo;
	}
	
	/**
	 * Método que crea el boton finalizar
	 * 
	 * @return boton
	 */
	private JButton getBtFinalizar() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Finalizar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Espere a recoger su pedido");
					dispose();
				}
			});
			btnNewButton.setBackground(new Color(0, 128, 0));
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setBounds(435, 190, 101, 37);
		}
		return btnNewButton;
	}
}
