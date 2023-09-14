package igu;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

/**
 * Titulo: Clase VentanaRegistro
 *  
 * @author UO281847
 * @version 23/09/2021
 */
public class VentanaRegistro extends JDialog {
	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo contentPane
	 */
	private JPanel contentPane;
	/**
	 * Atributo btSiguiente
	 */
	private JButton btSiguiente;
	/**
	 * Atributo pnPedido
	 */
	private JPanel pnPedido;
	/**
	 * Atributo rdLocal
	 */
	private JRadioButton rdLocal;
	/**
	 * Atributo rdLlevar
	 */
	private JRadioButton rdLlevar;
	/**
	 * Atributo btCancelar
	 */
	private JButton btCancelar;
	/**
	 * Atributo pnCliente
	 */
	private JPanel pnCliente;
	/**
	 * Atributo buttonGroup
	 */
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Atributo lblPassword
	 */
	private JLabel lblPassword;
	/**
	 * Atributo lblReintroduzcaPassword
	 */
	private JLabel lblReintroduzcaPassword;
	/**
	 * Atributo lblA�oDeNacimiento
	 */
	private JLabel lblA�oDeNacimiento;
	/**
	 * Atributo lblNameSurname
	 */
	private JLabel lblNameSurname;
	/**
	 * Atributo cbNacimiento
	 */
	private JComboBox<String> cbNacimiento;
	/**
	 * Atributo pwPassR
	 */
	private JPasswordField pwPassR;
	/**
	 * Atributo pwPass
	 */
	private JPasswordField pwPass;
	/**
	 * Atributo pwNameSurname
	 */
	private JTextField tfNameSurname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro frame = new VentanaRegistro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Constructor de la ventana registro
	 */
	public VentanaRegistro() {
		setTitle("McDonald's: Datos de Registro");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtSiguiente());
		contentPane.add(getPnPedido());
		contentPane.add(getBtCancelar());
		contentPane.add(getPnCliente());	
	}	
	
	/**
	 * M�todo que crea el bot�n siguiente
	 * 
	 * @return btSiguiente, button
	 */
	private JButton getBtSiguiente() {
		if (btSiguiente == null) {
			btSiguiente = new JButton("SIguiente");
			btSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					validarFormulario();
				}
			});
			btSiguiente.setForeground(new Color(255, 255, 255));
			btSiguiente.setBackground(new Color(0, 128, 0));
			btSiguiente.setBounds(327, 218, 93, 32);
		}
		return btSiguiente;
	}	
	
	/**
	 * M�todo que valida que se pueda entrar
	 *  
	 * @return true o false
	 */
	private boolean isValido() {
		if (!getTfNameSurname().getText().isEmpty() && 
				!String.valueOf(getPwPass().getPassword()).isEmpty() &&
				!String.valueOf(getPwPassR().getPassword()).isEmpty() && diffPass()){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * M�todo que comprueba si la contrase�a es distinta
	 * 
	 * @return true o false
	 */
	private boolean diffPass() {
		return String.valueOf(getPwPass().getPassword()).equals(String.valueOf(getPwPassR().getPassword()));
	}
	
	/**
	 * M�todo que valida el formulario
	 */
	private void validarFormulario() {
		if (isValido()) {
			VentanaConfirmaci�n.main(null);
		} else {
			JOptionPane.showMessageDialog(null, "Error: Pruebe otra vez");
		}		
	}
	
	/**
	 * M�todo que crea el panel del pedido
	 * 
	 * @return pnPedido, panel
	 */
	private JPanel getPnPedido() {
		if (pnPedido == null) {
			pnPedido = new JPanel();
			pnPedido.setAlignmentY(Component.TOP_ALIGNMENT);
			pnPedido.setAlignmentX(Component.LEFT_ALIGNMENT);
			pnPedido.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, 
					new Color(255, 255, 255), new Color(160, 160, 160)), "Pedido", 
					TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
			pnPedido.setBackground(new Color(255, 255, 255));
			pnPedido.setBounds(10, 181, 254, 69);
			pnPedido.setLayout(null);
			pnPedido.add(getRdLocal());
			pnPedido.add(getRdLlevar());
		}
		return pnPedido;
	}
	
	/**
	 * M�todo que crea el bot�n de selecci�n local
	 * 
	 * @return rdLocal, bot�n de selecci�n
	 */
	private JRadioButton getRdLocal() {
		if (rdLocal == null) {
			rdLocal = new JRadioButton("Local");
			rdLocal.setBounds(16, 25, 68, 23);
			buttonGroup.add(rdLocal);
			rdLocal.setSelected(true);
			rdLocal.setBackground(new Color(255, 255, 255));
		}
		return rdLocal;
	}	
	
	/**
	 * M�todo que crea el bot�n de selecci�n llevar
	 * 
	 * @return rdLlevar, bot�n de selecci�n
	 */
	private JRadioButton getRdLlevar() {
		if (rdLlevar == null) {
			rdLlevar = new JRadioButton("Llevar");
			rdLlevar.setBounds(153, 25, 68, 23);
			buttonGroup.add(rdLlevar);
			rdLlevar.setBackground(Color.WHITE);
		}
		return rdLlevar;
	}	
	
	/**
	 * M�todo que crea el bot�n de cancelar
	 * 
	 * @return btCancelar, button
	 */
	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btCancelar.setForeground(new Color(255, 255, 255));
			btCancelar.setBackground(new Color(255, 0, 0));
			btCancelar.setBounds(467, 218, 93, 32);
		}
		return btCancelar;
	}	
	
	/**
	 * M�todo que crea el panel de cliente
	 * 
	 * @return pnCliente, panel
	 */
	private JPanel getPnCliente() {
		if (pnCliente == null) {
			pnCliente = new JPanel();
			pnCliente.setLayout(null);
			pnCliente.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, 
					new Color(255, 255, 255), new Color(160, 160, 160)), "Datos del Cliente", 
					TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
			pnCliente.setBackground(Color.WHITE);
			pnCliente.setAlignmentY(0.0f);
			pnCliente.setAlignmentX(0.0f);
			pnCliente.setBounds(10, 11, 564, 168);
			pnCliente.add(getLblPassword());
			pnCliente.add(getLblReintroduzcaPassword());
			pnCliente.add(getLblA�oDeNacimiento());
			pnCliente.add(getLblNameSurname());
			pnCliente.add(getCbNacimiento());
			pnCliente.add(getPwPassR());
			pnCliente.add(getPwPass());
			pnCliente.add(getTfNameSurname());
		}
		return pnCliente;
	}	
	
	/**
	 * M�todo que crea la etiqueta de la contrase�a
	 * 
	 * @return lblPassword, etiqueta
	 */
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setBounds(10, 107, 94, 14);
		}
		return lblPassword;
	}	
	
	/**
	 * M�todo que crea la etiqueta de reintroducir la contrase�a
	 * 
	 * @return lblReintroduzcaPassword, etiqueta
	 */
	private JLabel getLblReintroduzcaPassword() {
		if (lblReintroduzcaPassword == null) {
			lblReintroduzcaPassword = new JLabel("Reintroduzca password:");
			lblReintroduzcaPassword.setBounds(10, 142, 161, 14);
		}
		return lblReintroduzcaPassword;
	}
	
	/**
	 * M�todo que crea la etiqueta de introducir el a�o de nacimiento
	 * 
	 * @return lblA�oDeNacimiento, etiqueta
	 */
	private JLabel getLblA�oDeNacimiento() {
		if (lblA�oDeNacimiento == null) {
			lblA�oDeNacimiento = new JLabel("A\u00F1o de nacimiento:");
			lblA�oDeNacimiento.setBounds(10, 70, 116, 14);
		}
		return lblA�oDeNacimiento;
	}	
	
	/**
	 * M�todo que crea la etiqueta de nombre y apellidos
	 * 
	 * @return lblNameSurname, etiqueta
	 */
	private JLabel getLblNameSurname() {
		if (lblNameSurname == null) {
			lblNameSurname = new JLabel("Nombre y Apellidos:");
			lblNameSurname.setBounds(10, 32, 116, 14);
		}
		return lblNameSurname;
	}	
	
	/**
	 * M�todo que crea el combobox
	 * 
	 * @return cbNacimiento, combobox
	 */
	private JComboBox<String> getCbNacimiento() {
		if (cbNacimiento == null) {			
			String[] a�os = new String[90];
			for (int i=0; i<90; i++) {
				a�os[i]=""+((90-i)+1920);
			}
			cbNacimiento = new JComboBox<String>();
			cbNacimiento.setModel(new DefaultComboBoxModel<String>(a�os));
			cbNacimiento.setSelectedIndex(8);
			cbNacimiento.setBounds(167, 66, 116, 22);
		}
		return cbNacimiento;
	}	
	
	/**
	 * M�todo que crea el lugar para reintroducir la contrase�a
	 * 
	 * @return pwPassR, passwordField
	 */
	private JPasswordField getPwPassR() {
		if (pwPassR == null) {
			pwPassR = new JPasswordField();
			pwPassR.setBounds(167, 104, 263, 20);
		}
		return pwPassR;
	}	
	
	/**
	 * M�todo que crea el lugar para reintroducir la contrase�a
	 * 
	 * @return pwPass, passwordField
	 */
	private JPasswordField getPwPass() {
		if (pwPass == null) {
			pwPass = new JPasswordField();
			pwPass.setBounds(167, 139, 263, 20);
		}
		return pwPass;
	}
	
	/**
	 * M�todo que crea el lugar para introducir el nombre y apellidos
	 * 
	 * @return tfNameSurname, textField
	 */
	private JTextField getTfNameSurname() {
		if (tfNameSurname == null) {
			tfNameSurname = new JTextField();
			tfNameSurname.setColumns(10);
			tfNameSurname.setBounds(167, 29, 352, 20);
		}
		return tfNameSurname;
	}
}
