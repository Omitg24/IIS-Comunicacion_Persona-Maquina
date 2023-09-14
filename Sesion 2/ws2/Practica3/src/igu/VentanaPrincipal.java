package igu;

import javax.swing.JFrame;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Titulo: Clase VentanaPrincipal
 * 
 * @author UO281847
 * @version 23/09/2021
 */
public class VentanaPrincipal extends JFrame{
	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo spUnidades
	 */
	private JSpinner spUnidades;
	/**
	 * Atributo btA�adir
	 */
	private JButton btA�adir;
	/**
	 * Atributo btCancelar
	 */
	private JButton btCancelar;
	/**
	 * Atributo btSiguiente
	 */
	private JButton btSiguiente;
	/**
	 * Atributo comboBox
	 */
	private JComboBox comboBox;
	/**
	 * Atributo lblPrecio
	 */
	private JLabel lblPrecio;
	/**
	 * Atributo tfPrecio
	 */
	private JTextField tfPrecio;
	/**
	 * Atributo lblUnidades
	 */
	private JLabel lblUnidades;
	/**
	 * Atributo lblLogo
	 */
	private JLabel lblLogo;
	/**
	 * Atributo lblMcDonadls
	 */
	private JLabel lblMcDonadls;
	/**
	 * Atributo lblArticulos
	 */
	private JLabel lblArticulos;	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Constructor de la ventana principal
	 */
	public VentanaPrincipal() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		getContentPane().add(getSpUnidades());
		getContentPane().add(getBtA�adir());
		getContentPane().add(getBtCancelar());
		getContentPane().add(getBtSiguiente());
		getContentPane().add(getComboBox());
		getContentPane().add(getLblPrecio());
		getContentPane().add(getTfPrecio());
		getContentPane().add(getLblUnidades());
		getContentPane().add(getLblLogo());
		getContentPane().add(getLblMcDonadls());
		getContentPane().add(getLblArticulos());
		setTitle("McDonald's Espa\u00F1a");
		setBounds(100, 100, 700, 400);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logo.png")));
		
	}
	
	/**
	 * M�todo que crea el spinner de unidades
	 * 
	 * @return spinner
	 */
	@SuppressWarnings("deprecation")
	private JSpinner getSpUnidades() {
		if (spUnidades == null) {
			spUnidades = new JSpinner();
			spUnidades.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spUnidades.setBounds(463, 191, 54, 23);
		}
		return spUnidades;
	}
	
	/**
	 * M�todo que crea el bot�n a�adir
	 *  
	 * @return boton
	 */
	private JButton getBtA�adir() {
		if (btA�adir == null) {
			btA�adir = new JButton("A\u00F1adir");
			btA�adir.setForeground(Color.WHITE);
			btA�adir.setBackground(new Color(0, 128, 0));
			btA�adir.setBounds(527, 191, 76, 23);
		}
		return btA�adir;
	}
	
	/**
	 * M�todo que crea el bot�n cancelar
	 * 
	 * @return boton
	 */
	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(EXIT_ON_CLOSE);
				}
			});
			btCancelar.setForeground(Color.WHITE);
			btCancelar.setBackground(new Color(255, 0, 0));
			btCancelar.setBounds(574, 327, 100, 23);
		}
		return btCancelar;
	}
	
	/**
	 * M�todo que crea el bot�n siguiente
	 * 
	 * @return boton
	 */
	private JButton getBtSiguiente() {
		if (btSiguiente == null) {
			btSiguiente = new JButton("Siguiente");
			btSiguiente.setEnabled(false);
			btSiguiente.setBackground(new Color(0, 128, 0));
			btSiguiente.addActionListener(new ActionListener() {				
				public void actionPerformed(ActionEvent e) {
					VentanaRegistro.main(null);				}
			});
			btSiguiente.setForeground(Color.WHITE);
			btSiguiente.setBounds(464, 327, 100, 23);
		}
		return btSiguiente;
	}
	
	/**
	 * M�todo que crea el combobox con los productos
	 * 
	 * @return combobox
	 */
	private JComboBox getComboBox() {
		if (comboBox == null) {			
			comboBox = new JComboBox();
			comboBox.setBounds(20, 191, 425, 23);
		}
		return comboBox;
	}
	
	/**
	 * M�todo que crea la etiqueta del precio
	 * 
	 * @return etiqueta
	 */
	private JLabel getLblPrecio() {
		if (lblPrecio == null) {
			lblPrecio = new JLabel("Precio Pedido:");
			lblPrecio.setBounds(463, 225, 82, 14);
		}
		return lblPrecio;
	}
	
	/**
	 * M�todo que crea el textField del precio
	 * 
	 * @return texto
	 */
	private JTextField getTfPrecio() {
		if (tfPrecio == null) {
			tfPrecio = new JTextField();
			tfPrecio.setEditable(false);
			tfPrecio.setBounds(463, 250, 70, 23);
			tfPrecio.setColumns(10);
		}
		return tfPrecio;
	}
	
	/**
	 * M�todo que creea la etiqueta de unidades
	 *  
	 * @return etiqueta
	 */
	private JLabel getLblUnidades() {
		if (lblUnidades == null) {
			lblUnidades = new JLabel("Unidades:");
			lblUnidades.setBounds(463, 157, 70, 23);
		}
		return lblUnidades;
	}
	
	/**
	 * M�todo que crea la etiqueta del logo
	 *  
	 * @return etiqueta
	 */
	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logo.png")));
			lblLogo.setBounds(40, 11, 152, 126);
		}
		return lblLogo;
	}
	
	/**
	 * M�todo que crea la etiqueta McDonald's
	 * 
	 * @return etiqueta
	 */
	private JLabel getLblMcDonadls() {
		if (lblMcDonadls == null) {
			lblMcDonadls = new JLabel("McDonald's");
			lblMcDonadls.setFont(new Font("Arial Black", Font.PLAIN, 35));
			lblMcDonadls.setBounds(202, 48, 243, 60);
		}
		return lblMcDonadls;
	}
	
	/**
	 * M�todo que crea la etiqueta de Articulos
	 * 
	 * @return etiqueta
	 */
	private JLabel getLblArticulos() {
		if (lblArticulos == null) {
			lblArticulos = new JLabel("Art\u00EDculos:");
			lblArticulos.setBounds(20, 157, 70, 23);
		}
		return lblArticulos;
	}
}