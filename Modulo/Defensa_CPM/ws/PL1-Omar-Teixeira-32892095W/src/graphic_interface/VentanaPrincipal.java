package graphic_interface;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.LineBorder;

import logic.Board;
import logic.Game;
import logic.Gift;

import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Rectangle;
import javax.swing.JSlider;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URL;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.event.ChangeListener;

import events.ProcessGameFocus;

import javax.swing.event.ChangeEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * T�tulo: Clase VentanaPrincipal
 * Descripci�n: Clase que contiene los dos paneles principales, el primero de ellos,
 * que corresponde al panel de botones donde jugar a la aplicaci�n; y, posteriormente,
 * ir al panel de canjear los regalos.
 *
 * @author Omar Teixeira, UO281847
 * @version 25 dic. 2021
 */
public class VentanaPrincipal extends JFrame {
//-- CONSTANTES ----------------------------------------------------------------
	/**
	 * Constante serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constante INTERN_FILE
	 */
	private static final String INTERN_FILE = "resources/textos";
	/**
	 * Constante ECI_LOGO
	 */
	private static final String ECI_LOGO = "/images/ECI_logo.png";
	/**
	 * Constante ECI_CHRISTMAS
	 */
	private static final String ECI_CHRISTMAS = "/images/ECI_logo_Navide�o.png";
	/**
	 * Constante ALL_FILE
	 */
	private static final String ALL_FILE = "/images/products/icons/Todos.png";
	/**
	 * Constante NUTRITION_FILE
	 */
	private static final String NUTRITION_FILE = "/images/products/icons/Alimentacion.png";
	/**
	 * Constante SPORTS_FILE
	 */
	private static final String SPORTS_FILE = "/images/products/icons/Deportes.png";
	/**
	 * Constante ELECTRONICS_FILE
	 */
	private static final String ELECTRONICS_FILE = "/images/products/icons/Electronica.png";
	/**
	 * Constante TOYS_FILE
	 */
	private static final String TOYS_FILE = "/images/products/icons/Juguetes.png";
	/**
	 * Constante TRIPS_FILE
	 */
	private static final String TRIPS_FILE = "/images/products/icons/Viajes.png";
	/**
	 * Constante GIFTS_PATH
	 */
	private static final String GIFTS_PATH = "/images/products/";
	/**
	 * Constante ADORNO_DCHA
	 */
	private static final String ADORNO_DCHA = "/images/AdornoDcha.png";
	/**
	 * Constante ADORNO_IZDA
	 */
	private static final String ADORNO_IZDA = "/images/AdornoIzda.png";
	/**
	 * Constante DEFAULT_SECTION
	 */
	private static final String DEFAULT_SECTION = "Todos";
	/**
	 * Constante MAX_VALUE	
	 */
	private static final int MAX_VALUE = 2500;
	/**
	 * Constante WIDTH_CORRECTION
	 */
	private static final int WIDTH_GIFT_CORRECTION = 40;
	/**
	 * Constante HEIGHT_CORRECTION
	 */
	private static final int HEIGHT_GIFT_CORRECTION = 50;
//-- ATRIBUTOS -----------------------------------------------------------------
	/**
	 * Atributo contentPane
	 */
	private JPanel contentPane;
	/**
	 * Atributo vI
	 */
	private VentanaInicio vI;
	/**
	 * Atributo game
	 */
	private Game game;
	//-- Eventos ---------------------------------------------------------------
	/**
	 * Atributo pGameB
	 */
	private ProcessGameButton pGameB;
	/**
	 * Atributo pGameF
	 */
	private ProcessGameFocus pGameF;
	/**
	 * Atributo pGiftB
	 */
	private ProcessGiftButton pGiftB;
	/**
	 * Atributo pGiftI
	 */
	private ProcessGiftFocus pGiftF;
	//-- Internacionalizaci�n --------------------------------------------------
	/**
	 * Atributo localizacion
	 */
	private Locale localizacion;
	/**
	 * Atributo textos
	 */
	private ResourceBundle textos;	
	//-- Juego -----------------------------------------------------------------
	/**
	 * Atributo panelJuegoBotones
	 */
	private JPanel panelJuegoBotones;
	/**
	 * Atributo panelSur
	 */
	private JPanel panelSurJuego;
	/**
	 * Atributo panelNorte
	 */
	private JPanel panelNorteJuego;
	/**
	 * Atributo lblTitulo
	 */
	private JLabel lblTituloJuego;
	/**
	 * Atributo panelOeste
	 */
	private JPanel panelOesteJuego;
	/**
	 * Atributo panelCentro
	 */
	private JPanel panelCentroJuego;
	/**
	 * Atributo lblTusPuntos
	 */
	private JLabel lblTusPuntosJuego;
	/**
	 * Atributo textFieldPuntos
	 */
	private JTextField textFieldPuntosJuego;
	/**
	 * Atributo lblPuntos
	 */
	private JLabel lblPuntosJuego;
	/**
	 * Atributo btnInterrogacion
	 */
	private JButton btnInterrogacion;
	/**
	 * Atributo btnSiguienteJuego
	 */
	private JButton btnSiguiente;
	/**
	 * Atributo panelEste
	 */
	private JPanel panelEsteJuego;
	/**
	 * Atributo lblArbol
	 */
	private JLabel lblArbol;
	/**
	 * Atributo lblAdornoIzda
	 */
	private JLabel lblAdornoJuegoIzda;
	/**
	 * Atributo lblAdornoDcha
	 */
	private JLabel lblAdornoJuegoDcha;
	/**
	 * Atributo lblShots
	 */
	private JLabel lblTiradas;
	/**
	 * Atributo lblRelleno2
	 */
	private JLabel lblRellenoJuego;
	/**
	 * Atributo textFieldShots
	 */
	private JTextField textFieldTiradas;
	//-- Canjear ---------------------------------------------------------------
	/**
	 * Atributo panelCanjear
	 */
	private JPanel panelCanjearRegalos;
	/**
	 * Atributo panelCentroCanjear
	 */
	private JPanel panelCentroCanjear;
	/**
	 * Atributo panelNorteCanjear
	 */
	private JPanel panelNorteCanjear;
	/**
	 * Atributo panelSurCanjear
	 */
	private JPanel panelSurCanjear;
	/**
	 * Atributo panelEsteCanjear
	 */
	private JPanel panelEsteCanjear;
	/**
	 * Atributo lblTusPuntosCanjear
	 */
	private JLabel lblTusPuntosCanjear;
	/**
	 * Atributo textFieldPuntosCanjear
	 */
	private JTextField textFieldPuntosCanjear;
	/**
	 * Atributo lblPuntosCanjear
	 */
	private JLabel lblPuntosCanjear;
	/**
	 * Atributo lblRellenoCanjear
	 */
	private JLabel lblRellenoCanjear;
	/**
	 * Atributo lblRellenoCanjear2
	 */
	private JLabel lblRellenoCanjear2;
	/**
	 * Atributo lblRellenoCanjear3
	 */
	private JLabel lblRellenoCanjear3;
	/**
	 * Atributo btnEliminar
	 */
	private JButton btnEliminar;
	/**
	 * Atributo btnSolicitar
	 */
	private JButton btnSolicitar;
	/**
	 * Atributo lblRellenoCanjear3
	 */
	private JLabel lblUnidades;
	/**
	 * Atributo panelOesteCanjear
	 */
	private JPanel panelOesteCanjear;
	/**
	 * Atributo btnTodos
	 */
	private JButton btnTodos;
	/**
	 * Atributo btnAlimentacion
	 */
	private JButton btnAlimentacion;
	/**
	 * Atributo btnDeportes
	 */
	private JButton btnDeportes;
	/**
	 * Atributo btnElectronica
	 */
	private JButton btnElectronica;
	/**
	 * Atributo btnJuguetes
	 */
	private JButton btnJuguetes;
	/**
	 * Atributo btnViajesYExperiencias
	 */
	private JButton btnViajesYExperiencias;
	/**
	 * Atributo sliderFiltro
	 */
	private JSlider sliderFiltro;	
	/**
	 * Atributo panelSlider
	 */
	private JPanel panelSlider;
	/**
	 * Atributo panelPuntos
	 */
	private JPanel panelPuntos;
	/**
	 * Atributo lblSlider
	 */
	private JLabel lblSlider;
	/**
	 * Atributo textFieldPuntosFiltro
	 */
	private JTextField textFieldPuntosFiltro;
	/**
	 * Atributo scrollPaneLista
	 */
	private JScrollPane scrollPaneLista;
	/**
	 * Atributo modeloListaRegalos
	 */
	private DefaultListModel<Gift> modeloListaRegalos;
	/**
	 * Atributo listGift
	 */
	private JList<Gift> listGift;
	/**
	 * Atributo lblTituloCanjear
	 */
	private JLabel lblTituloCanjear;
	/**
	 * Atributo lblAdornoCanjearIzda
	 */
	private JLabel lblAdornoCanjearIzda;
	/**
	 * Atributo lblAdornoCanjearDcha
	 */
	private JLabel lblAdornoCanjearDcha;
	/**
	 * Atributo lblTituloLista
	 */
	private JLabel lblTituloLista;
	/**
	 * Atributo scrollPaneGiftInfo
	 */
	private JScrollPane scrollPaneGiftInfo;
	/**
	 * Atributo textArea
	 */ 
	private JTextArea textAreaGiftInfo;
	/**
	 * Atributo lblTituloInfo
	 */
	private JLabel lblTituloInfo;
	/**
	 * Atributo section
	 */
	private String section;
	/**
	 * Atributo spinnerUnidades
	 */
	private JSpinner spinnerUnidades;
	/**
	 * Atributo trip
	 */
	private Gift trip;
	//-- Menus -----------------------------------------------------------------
	/**
	 * Atributo menuBarPrincipal
	 */
	private JMenuBar menuBarPrincipal;
	/**
	 * Atributo mnJuego
	 */
	private JMenu mnJuego;
	/**
	 * Atributo mntmNuevo
	 */
	private JMenuItem mntmNuevo;
	/**
	 * Atributo mntmSalir
	 */
	private JMenuItem mntmSalir;
	/**
	 * Atributo mnIdioma
	 */
	private JMenu mnIdioma;
	/**
	 * Atributo mntmEspa�ol
	 */
	private JMenuItem mntmEspa�ol;
	/**
	 * Atributo mntmIngles
	 */
	private JMenuItem mntmIngles;
	/**
	 * Atributo mnAyuda
	 */
	private JMenu mnAyuda;
	/**
	 * Atributo mntmContenidos
	 */
	private JMenuItem mntmContenidos;
	/**
	 * Atributo mntmAcercaDe
	 */
	private JMenuItem mntmAcercaDe;

	/**
	 * Constructor que crea la ventana principal
	 * 
	 * @param vI, ventana de Inicio
	 * @param localizacion, localizaci�n de la aplicaci�n
	 * @param game, juego
	 */
	public VentanaPrincipal(VentanaInicio vI, Locale localizacion, Game game) {		
		this.game=game;
		this.section = DEFAULT_SECTION;
		
		this.vI = vI;		
		this.localizacion = localizacion;
		this.textos = ResourceBundle.getBundle(INTERN_FILE, localizacion);
					
		this.pGameB = new ProcessGameButton();
		this.pGameF = new ProcessGameFocus();
		this.pGiftB = new ProcessGiftButton();
		this.pGiftF = new ProcessGiftFocus();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (confirmExit()) {
					System.exit(0);
				}
			}
		});		
		addComponentListener(new ComponentAdapter() {
			@Override
			/**
			 * M�todo que actualiza los iconos de los componentes
			 * 
			 * @param e, evento
			 */
			public void componentResized(ComponentEvent e) {				
				associateButton();
			}
		});		
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource(ECI_LOGO)));				
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1600, 1050);
		setLocationRelativeTo(vI);
		setJMenuBar(getMenuBarPrincipal());
		contentPane = new JPanel();
		contentPane.setBackground(new Color(152, 251, 152));
		contentPane.setBorder(new LineBorder(new Color(165, 42, 42), 7, true));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(6, 6));
		contentPane.add(getPanelJuegoBotones(), "name_387987401178600");
		contentPane.add(getPanelCanjearRegalos(), "name_3805306715500");
		
		setMinimumSize(new Dimension(1350, 950));
		
		loadHelp();
		setTexts(localizacion);
	}
	
	/**
	 * M�todo que devuelve una referencia a la ventana de Inicio
	 * 
	 * @return vI, ventana de Inicio
	 */
	public VentanaInicio getVI() {
		return vI;
	}
	
	/**
	 * M�todo que carga la ayuda
	 */
	private void loadHelp(){
		URL hsURL;
	    HelpSet hs;
	
	     try {
	             File fichero = new File("help/Ayuda.hs");
	             hsURL = fichero.toURI().toURL();
	             hs = new HelpSet(null, hsURL);
	           }	
	     catch (Exception e){
	       System.out.println("No se ha encontrado la ayuda.");
	       System.out.println(e.getMessage());
	
	       return;
	    }
	
	    HelpBroker hb = hs.createHelpBroker();
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    Point p = new Point((int)screenSize.getWidth()/4,(int)screenSize.getHeight()/4);
	    hb.setLocation(p);
	    hb.setSize(new Dimension(900, 1000));	    
	    hb.initPresentation();
	
	    hb.enableHelpKey(getRootPane(),"Introduccion", hs);
	    hb.enableHelpOnButton(getMntmContenidos(), "Introduccion", hs);
	    
	    hb.enableHelpOnButton(getBtnInterrogacion(), "Panel de botones", hs);
	    hb.enableHelp(getPanelCentroJuego(), "Panel de botones", hs);
	    hb.enableHelp(getTextFieldPuntosJuego(), "Sus puntos", hs);
	    hb.enableHelp(getTextFieldTiradas(), "Sus tiradas", hs);
	    
	    hb.enableHelp(getPanelCentroCanjear(), "Panel de canjeo", hs);
	    hb.enableHelp(getPanelOesteCanjear(), "Filtros por seccion", hs);
	    hb.enableHelp(getPanelSlider(), "Slider de filtrado", hs);
	    hb.enableHelp(getTextFieldPuntosCanjear(), "Sus puntos", hs);
	    hb.enableHelp(getSpinnerUnidades(), "Unidades a a�adir/eliminar", hs);
	    hb.enableHelp(getScrollPaneGiftInfo(), "Informacion del regalo", hs);
	    hb.enableHelp(getScrollPaneLista(), "Lista de los regalos", hs);
	    hb.enableHelp(getBtnEliminar(), "Botones de eliminar y solicitar", hs);
	    hb.enableHelp(getBtnSolicitar(), "Botones de eliminar y solicitar", hs);
  }
	
//-- INTERNACIONALIZACI�N ------------------------------------------------------	
	/**
	 * M�todo que setea los textos seg�n su localizaci�n
	 * 
	 * @param localizacion, localizaci�n del usuario
	 */
	private void setTexts(Locale localizacion) {		
		this.textos = ResourceBundle.getBundle(INTERN_FILE, localizacion);
		
		setTitle(textos.getString("tituloJuego"));
		
		//-- Panel del Juego		
		getLblTituloJuego().setText(textos.getString("lblTituloJuego"));
		getLblTusPuntosJuego().setText(textos.getString("lblTusPuntos"));
		getLblPuntosJuego().setText(textos.getString("lblPuntos"));		
		getTextFieldPuntosJuego().setToolTipText(textos.getString("toolTipPuntos"));
		
		getBtnSiguiente().setText(textos.getString("btnSiguiente"));
		getBtnSiguiente().setMnemonic(Integer.parseInt(textos.getString("mnemonicoSiguiente")));
		getBtnSiguiente().setToolTipText(textos.getString("toolTipSiguiente"));
		
		getLblTiradas().setText(textos.getString("lblTiradas"));
		getTextFieldTiradas().setToolTipText(textos.getString("toolTipTiradas"));
		//-- Panel de Canjear
		getLblTituloCanjear().setText(textos.getString("lblTituloCanjear"));
		
		getLblTusPuntosCanjear().setText(textos.getString("lblTusPuntos"));
		getLblPuntosCanjear().setText(textos.getString("lblPuntos"));		
		getTextFieldPuntosCanjear().setToolTipText(textos.getString("toolTipPuntos"));
		
		getBtnEliminar().setText(textos.getString("btnEliminar"));
		getBtnEliminar().setMnemonic(Integer.parseInt(textos.getString("mnemonicoEliminar")));
		getBtnEliminar().setToolTipText(textos.getString("toolTipEliminar"));
		
		getBtnSolicitar().setText(textos.getString("btnSolicitar"));
		getBtnSolicitar().setMnemonic(Integer.parseInt(textos.getString("mnemonicoSolicitar")));
		getBtnSolicitar().setToolTipText(textos.getString("toolTipSolicitar"));
		
		getLblUnidades().setText(textos.getString("lblUnidades"));
		getLblUnidades().setDisplayedMnemonic(Integer.parseInt(textos.getString("mnemonicoUnidades")));
		getSpinnerUnidades().setToolTipText(textos.getString("toolTipSolicitar"));
		
		getBtnTodos().setText(textos.getString("btnTodos"));
		getBtnTodos().setMnemonic(Integer.parseInt(textos.getString("mnemonicoTodos")));
		getBtnTodos().setToolTipText(textos.getString("toolTipTodos"));
		
		getBtnAlimentacion().setText(textos.getString("btnAlimentacion"));
		getBtnAlimentacion().setMnemonic(Integer.parseInt(textos.getString("mnemonicoAlimentacion")));
		getBtnAlimentacion().setToolTipText(textos.getString("toolTipAlimentacion"));
		
		getBtnDeportes().setText(textos.getString("btnDeportes"));
		getBtnDeportes().setMnemonic(Integer.parseInt(textos.getString("mnemonicoDeportes")));
		getBtnDeportes().setToolTipText(textos.getString("toolTipDeportes"));
		
		getBtnElectronica().setText(textos.getString("btnElectronica"));
		getBtnElectronica().setMnemonic(Integer.parseInt(textos.getString("mnemonicoElectronica")));
		getBtnElectronica().setToolTipText(textos.getString("toolTipElectronica"));
		
		getBtnJuguetes().setText(textos.getString("btnJuguetes"));
		getBtnJuguetes().setMnemonic(Integer.parseInt(textos.getString("mnemonicoJuguetes")));
		getBtnJuguetes().setToolTipText(textos.getString("toolTipJuguetes"));
		
		getBtnViajesYExperiencias().setText(textos.getString("btnViajes"));
		getBtnViajesYExperiencias().setMnemonic(Integer.parseInt(textos.getString("mnemonicoViajes")));
		getBtnViajesYExperiencias().setToolTipText(textos.getString("toolTipViajes"));
		
		getLblSlider().setText(textos.getString("lblSlider"));
		getLblSlider().setDisplayedMnemonic(Integer.parseInt(textos.getString("mnemonicoSlider")));
		getTextFieldPuntosFiltro().setToolTipText(textos.getString("toolTipPuntosSlider"));
		getSliderFiltro().setToolTipText(textos.getString("toolTipSlider"));
				
		getLblTituloLista().setText(textos.getString("lblTituloLista"));
		getLblTituloLista().setDisplayedMnemonic(Integer.parseInt(textos.getString("mnemonicoLista")));
		
		getLblTituloInfo().setText(textos.getString("lblTituloInfo"));
		getLblTituloInfo().setDisplayedMnemonic(Integer.parseInt(textos.getString("mnemonicoInfo")));
		//-- Menus
		getMnJuego().setText(textos.getString("menuJuego"));
		getMnJuego().setMnemonic(Integer.parseInt(textos.getString("mnemonicoJuego")));
		getMnJuego().setToolTipText(textos.getString("toolTipJuego"));
		
		getMntmNuevo().setText(textos.getString("mntmNuevo"));
		getMntmNuevo().setMnemonic(Integer.parseInt(textos.getString("mnemonicoNuevo")));
		getMntmNuevo().setToolTipText(textos.getString("toolTipNuevo"));
		
		getMntmSalir().setText(textos.getString("mntmSalir"));
		getMntmSalir().setMnemonic(Integer.parseInt(textos.getString("mnemonicoSalir")));
		getMntmSalir().setToolTipText(textos.getString("toolTipSalir"));
		
		getMnIdioma().setText(textos.getString("menuIdioma"));
		getMnIdioma().setMnemonic(Integer.parseInt(textos.getString("mnemonicoIdioma")));
		getMnIdioma().setToolTipText(textos.getString("toolTipIdioma"));		
		
		getMntmEspa�ol().setText(textos.getString("btnEspa�ol"));
		getMntmEspa�ol().setMnemonic(Integer.parseInt(textos.getString("mnemonicoEspa�ol")));
		getMntmEspa�ol().setToolTipText(textos.getString("toolTipEspa�ol"));
		
		getMntmIngles().setText(textos.getString("btnIngles"));
		getMntmIngles().setMnemonic(Integer.parseInt(textos.getString("mnemonicoIngles")));
		getMntmIngles().setToolTipText(textos.getString("toolTipIngles"));
		
		getMnAyuda().setText(textos.getString("menuAyuda"));
		getMnAyuda().setMnemonic(Integer.parseInt(textos.getString("mnemonicoAyuda")));
		getMnAyuda().setToolTipText(textos.getString("toolTipAyuda"));
		
		getMntmContenidos().setText(textos.getString("mntmContenidos"));
		getMntmContenidos().setMnemonic(Integer.parseInt(textos.getString("mnemonicoContenidos")));
		getMntmContenidos().setToolTipText(textos.getString("toolTipContenidos"));
		
		getMntmAcercaDe().setText(textos.getString("mntmAcercaDe"));
		getMntmAcercaDe().setMnemonic(Integer.parseInt(textos.getString("mnemonicoAcercaDe")));
		getMntmAcercaDe().setToolTipText(textos.getString("toolTipAcercaDe"));
	}
	
//-- PANEL DEL JUEGO -----------------------------------------------------------
	/**
	 * M�todo que crea el panel del juego de botones
	 * 
	 * @return panelJuegoBotones, panel del juego de botones
	 */
	private JPanel getPanelJuegoBotones() {
		if (panelJuegoBotones == null) {
			panelJuegoBotones = new JPanel();
			panelJuegoBotones.setBackground(new Color(152, 251, 152));
			panelJuegoBotones.setLayout(new BorderLayout(7, 7));
			panelJuegoBotones.add(getPanelSurJuego(), BorderLayout.SOUTH);
			panelJuegoBotones.add(getPanelNorteJuego(), BorderLayout.NORTH);
			panelJuegoBotones.add(getPanelOesteJuego(), BorderLayout.WEST);
			panelJuegoBotones.add(getPanelCentroJuego(), BorderLayout.CENTER);
			panelJuegoBotones.add(getPanelEsteJuego(), BorderLayout.EAST);
		}
		return panelJuegoBotones;
	}
	
	/**
	 * M�todo que crea el panel sur
	 * 
	 * @return panelSur, panel sur
	 */
	private JPanel getPanelSurJuego() {
		if (panelSurJuego == null) {
			panelSurJuego = new JPanel();
			panelSurJuego.setBackground(new Color(152, 251, 152));
			panelSurJuego.setLayout(new GridLayout(1, 0, 5, 5));
			panelSurJuego.add(getLblTusPuntosJuego());
			panelSurJuego.add(getTextFieldPuntosJuego());
			panelSurJuego.add(getLblPuntosJuego());
			panelSurJuego.add(getLblTiradas());
			panelSurJuego.add(getTextFieldTiradas());
			panelSurJuego.add(getLblRellenoJuego());
			panelSurJuego.add(getBtnSiguiente());
		}
		return panelSurJuego;
	}
	
	/**
	 * M�todo que crea el panel norte
	 * 
	 * @return panelNorte, panel norte
	 */
	private JPanel getPanelNorteJuego() {
		if (panelNorteJuego == null) {
			panelNorteJuego = new JPanel();
			panelNorteJuego.setBackground(new Color(152, 251, 152));
			panelNorteJuego.setLayout(new GridLayout(1, 1, 0, 0));
			panelNorteJuego.add(getLblAdornoJuegoIzda());
			panelNorteJuego.add(getLblTituloJuego());
			panelNorteJuego.add(getLblAdornoJuegoDcha());
		}
		return panelNorteJuego;
	}
	
	/**
	 * M�todo que crea el panel oeste
	 * 
	 * @return panelOeste, panel oeste
	 */
	private JPanel getPanelOesteJuego() {
		if (panelOesteJuego == null) {
			panelOesteJuego = new JPanel();
			panelOesteJuego.setBackground(new Color(152, 251, 152));
			panelOesteJuego.setLayout(new BoxLayout(panelOesteJuego, BoxLayout.X_AXIS));
			panelOesteJuego.add(getBtnInterrogacion());
		}
		return panelOesteJuego;
	}
	
	/**
	 * M�todo que crea el panel central
	 * 
	 * @return panelCentro, panel central
	 */
	private JPanel getPanelCentroJuego() {
		if (panelCentroJuego == null) {
			panelCentroJuego = new JPanel();
			panelCentroJuego.setBackground(new Color(152, 251, 152));
			panelCentroJuego.setLayout(new GridLayout(5, 5, 7, 7));
			addGameButtons(Board.DIM);
		}
		return panelCentroJuego;
	}
	
	/**
	 * M�todo que crea el panel este 
	 * 
	 * @return panelEste, panel este
	 */
	private JPanel getPanelEsteJuego() {
		if (panelEsteJuego == null) {
			panelEsteJuego = new JPanel();
			panelEsteJuego.setBackground(new Color(152, 251, 152));
			panelEsteJuego.setLayout(new GridLayout(1, 0, 0, 0));
			panelEsteJuego.add(getLblArbol());
		}
		return panelEsteJuego;
	}
	
	/**
	 * M�todo que crea la etiqueta del arbol
	 * 
	 * @return lblArbol, etiqueta del arbol
	 */
	private JLabel getLblArbol() {
		if (lblArbol == null) {
			lblArbol = new JLabel("");
			lblArbol.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/images/Arbol.png")));
			lblArbol.setBackground(new Color(152, 251, 152));			
		}
		return lblArbol;
	}
	
	/**
	 * M�todo que crea la etiqueta del adorno de la izquierda
	 * 
	 * @return lblAdornoIzda, etiqueta del adorno de la izquierda
	 */
	private JLabel getLblAdornoJuegoIzda() {
		if (lblAdornoJuegoIzda == null) {
			lblAdornoJuegoIzda = new JLabel("");
			lblAdornoJuegoIzda.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(ADORNO_IZDA)));
			lblAdornoJuegoIzda.setBackground(new Color(152, 251, 152));			
		}
		return lblAdornoJuegoIzda;
	}
	
	/**
	 * M�todo que crea la etiqueta del adorno de la derecha
	 * 
	 * @return lblAdornoDcha, etiqueta del adorno de la derecha
	 */
	private JLabel getLblAdornoJuegoDcha() {
		if (lblAdornoJuegoDcha == null) {
			lblAdornoJuegoDcha = new JLabel("");
			lblAdornoJuegoDcha.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(ADORNO_DCHA)));
			lblAdornoJuegoDcha.setHorizontalAlignment(SwingConstants.TRAILING);
			lblAdornoJuegoDcha.setBackground(new Color(152, 251, 152));
		}
		return lblAdornoJuegoDcha;
	}
	
	/**
	 * M�todo que crea la etiqueta del titulo
	 * 
	 * @return lblTitulo, etiqueta del titulo
	 */
	private JLabel getLblTituloJuego() {
		if (lblTituloJuego == null) {
			lblTituloJuego = new JLabel("");
			lblTituloJuego.setForeground(new Color(165, 42, 42));
			lblTituloJuego.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 48));
			lblTituloJuego.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblTituloJuego;
	}
	
	/**
	 * M�todo que crea la etiquta de tus puntos
	 * 
	 * @return lblTusPuntos, etiqueta de tus puntos
	 */
	private JLabel getLblTusPuntosJuego() {
		if (lblTusPuntosJuego == null) {
			lblTusPuntosJuego = new JLabel("");
			lblTusPuntosJuego.setHorizontalAlignment(SwingConstants.CENTER);
			lblTusPuntosJuego.setBackground(new Color(152, 251, 152));
			lblTusPuntosJuego.setForeground(new Color(165, 42, 42));
			lblTusPuntosJuego.setFont(new Font("Tahoma", Font.BOLD, 20));
		}
		return lblTusPuntosJuego;
	}
	
	/**
	 * M�todo que crea el text field de tus puntos
	 * 
	 * @return textFieldPuntos, text field de tus puntos 
	 */
	private JTextField getTextFieldPuntosJuego() {
		if (textFieldPuntosJuego == null) {
			textFieldPuntosJuego = new JTextField();
			textFieldPuntosJuego.setForeground(new Color(152, 251, 152));
			textFieldPuntosJuego.setEditable(false);
			textFieldPuntosJuego.setBackground(new Color(46, 139, 87));
			textFieldPuntosJuego.setBorder(new LineBorder(new Color(0, 100, 0), 4, true));
			textFieldPuntosJuego.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldPuntosJuego.setFont(new Font("Tahoma", Font.BOLD, 26));
			textFieldPuntosJuego.setText(String.valueOf(game.getPoints()));
		}
		return textFieldPuntosJuego;
	}
	
	/**
	 * M�todo que crea la etiqueta de puntos
	 * 
	 * @return lblPuntos, etiqueta de puntos
	 */
	private JLabel getLblPuntosJuego() {
		if (lblPuntosJuego == null) {
			lblPuntosJuego = new JLabel("");
			lblPuntosJuego.setForeground(new Color(165, 42, 42));
			lblPuntosJuego.setBackground(new Color(152, 251, 152));
			lblPuntosJuego.setFont(new Font("Tahoma", Font.ITALIC, 18));
		}
		return lblPuntosJuego;
	}
	
	/**
	 * M�todo que crea el boton de interrogacion
	 * 
	 * @return btnInterrogacion, boton de interrogacion
	 */
	private JButton getBtnInterrogacion() {
		if (btnInterrogacion == null) {
			btnInterrogacion = new JButton("");
			btnInterrogacion.setBorder(new LineBorder(new Color(0, 100, 0), 4, true));
			btnInterrogacion.setBackground(new Color(143, 188, 143));
			btnInterrogacion.setBounds(new Rectangle(0, 0, 100, 100));
			btnInterrogacion.setIcon(new ImageIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/images/Interrogacion.png")).getImage().getScaledInstance(
							getBtnInterrogacion().getWidth(), getBtnInterrogacion().getHeight(), Image.SCALE_SMOOTH)));
		}
		return btnInterrogacion;
	}
	
	/**
	 * M�todo que crea el boton de siguiente del panel de juego
	 * 
	 * @return btnSiguienteJuego, boton de siguiente del panel de juego
	 */
	private JButton getBtnSiguiente() {
		if (btnSiguiente == null) {
			btnSiguiente = new JButton("");
			btnSiguiente.addActionListener(new ActionListener() {
				/**
				 * M�todo que ejecuta una acci�n
				 * 
				 * @param e, evento
				 */
				public void actionPerformed(ActionEvent e) {
					getTextFieldPuntosCanjear().setText(String.valueOf(game.getPoints()));
					System.out.println("\nPuntos obtenidos: " + game.getPoints());
					System.out.println("\n~~~~~~~~ CANJEAR REGALOS ~~~~~~~~");
					setTitle(textos.getString("tituloCanjear"));
					((CardLayout) getContentPane().getLayout()).next(contentPane);					
				}
			});
			btnSiguiente.setEnabled(false);
			btnSiguiente.setBorder(new LineBorder(new Color(0, 100, 0), 4, true));
			btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 18));
			btnSiguiente.setForeground(new Color(47, 79, 79));
			btnSiguiente.setBackground(new Color(60,179,113));
		}
		return btnSiguiente;
	}
	
	/**
	 * M�todo que crea los botones del juego
	 * 
	 * @param i, numero del boton
	 * @return btnCasillas
	 */
	private JButton createGameButtons(int i) {
		JButton btnBoxes = new JButton("");
		btnBoxes.setActionCommand(String.valueOf(i));
		btnBoxes.setBackground(new Color(143,188,143));
		btnBoxes.setFocusPainted(false);
		btnBoxes.setBorder(new LineBorder(new Color(165, 42, 42), 4, true));
		btnBoxes.setToolTipText(textos.getString("toolTipBotonesJuego"));
		btnBoxes.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(ECI_CHRISTMAS)));
		btnBoxes.setDisabledIcon(new ImageIcon(VentanaPrincipal.class.getResource(ECI_CHRISTMAS)));
		btnBoxes.addActionListener(pGameB);
		btnBoxes.addMouseListener(pGameF);		
		return btnBoxes;
	}
	
	/**
	 * M�todo que a�ade al panel central un numero de botones pasado como par�metro
	 * 
	 * @param nBotones, numero de Botones a a�adir 
	 */
	private void addGameButtons(int nBotones) {
		getPanelCentroJuego().removeAll();
		for (int i = 0; i < nBotones; i++) {
			getPanelCentroJuego().add(createGameButtons(i));
		}
		validate();
	}	
	
	/**
	 * M�todo que crea una etiqueta de relleno
	 * 
	 * @return lblRelleno, etiqueta de relleno
	 */
	private JLabel getLblTiradas() {
		if (lblTiradas == null) {
			lblTiradas = new JLabel("");
			lblTiradas.setHorizontalAlignment(SwingConstants.CENTER);
			lblTiradas.setForeground(new Color(165, 42, 42));
			lblTiradas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lblTiradas;
	}
	
	/**
	 * M�todo que crea la etiqueta de relleno 
	 * 
	 * @return lblRelleno2, etiqueta de relleno 
	 */
	private JLabel getLblRellenoJuego() {
		if (lblRellenoJuego == null) {
			lblRellenoJuego = new JLabel("");
		}
		return lblRellenoJuego;
	}
	
	/**
	 * M�todo que crea el text field con las tiradas
	 * 
	 * @return textFieldShots, text field con las tiradas
	 */
	private JTextField getTextFieldTiradas() {
		if (textFieldTiradas == null) {
			textFieldTiradas = new JTextField();
			textFieldTiradas.setForeground(new Color(152, 251, 152));
			textFieldTiradas.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldTiradas.setToolTipText((String) null);
			textFieldTiradas.setFont(new Font("Tahoma", Font.BOLD, 26));
			textFieldTiradas.setEditable(false);
			textFieldTiradas.setBorder(new LineBorder(new Color(0, 100, 0), 4, true));
			textFieldTiradas.setBackground(new Color(46, 139, 87));
			textFieldTiradas.setText(String.valueOf(game.getShots()));
		}
		return textFieldTiradas;
	}
	
	/**
	 * M�todo que abre la casilla escogida por el jugador
	 * 
	 * @param pos, posici�n donde abrir
	 */
	public void shoot(int pos) {
		game.shoot(pos);
		showGame(pos);		
	}
	
	/**
	 * M�todo que actualiza el juego a partir de la casilla seleccionada
	 * 
	 * @param pos, posici�n desde donde actualizar
	 */
	private void showGame(int pos) {
		paintPointsAndShotsLeft();
		paintBox(pos);
		checkGameOver();
	}
	
	/**
	 * M�todo que dibuja la casilla, ense�ando lo que contiene
	 * 
	 * @param pos, posici�n de la casilla
	 */
	private void paintBox(int pos) {
		ImageIcon icon = ImageFactory.getIcon(game.getBoard().getBoxes()[pos]);
		((JButton) getPanelCentroJuego().getComponent(pos)).setIcon(icon);
		((JButton) getPanelCentroJuego().getComponent(pos)).setDisabledIcon(icon);
	}
	
	/**
	 * M�todo que pinta el tablero
	 */
	private void paintBoard() {
		for (int i = 0; i < getPanelCentroJuego().getComponents().length; i++) {
			paintBox(i);
		}
	}
	
	/**
	 * M�todo que pinta los puntos
	 */
	private void paintPointsAndShotsLeft() {
		getTextFieldPuntosJuego().setText(String.valueOf(game.getPoints()));
		getTextFieldTiradas().setText(String.valueOf(game.getShots()));
	}
	
	/**
	 * M�todo que habilita o desahabilita el tablero
	 * 
	 * @param state, estado
	 */
	private void enableOrDisableBoard(boolean state) {
		for (int i = 0; i < getPanelCentroJuego().getComponents().length; i++) {
			getPanelCentroJuego().getComponents()[i].setEnabled(state);
		}
	}
	
	/**
	 * M�todo que comprueba si el juego ha terminado
	 */
	private void checkGameOver() {
		if (game.gameOver()) {
			enableOrDisableBoard(false);
			if (game.getPoints()==0) {
				paintBoard();
				JOptionPane.showMessageDialog(this, textos.getString("mensajeNoPuntos"),
						textos.getString("tituloJuego"), JOptionPane.INFORMATION_MESSAGE) ;
				dispose();
				game.startGame();				
				getVI().restart();
			} else {				
				paintBoard();
				JOptionPane.showMessageDialog(this, textos.getString("mensajeCanjear1") + " "
						+ game.getPoints()  + " " + textos.getString("mensajeCanjear2"),
						textos.getString("tituloJuego"), JOptionPane.INFORMATION_MESSAGE);
				getBtnSiguiente().setEnabled(true);
			}
		}
	}
	
//-- CANJEAR -------------------------------------------------------------------
	/**
	 * M�todo que crea el panel de canjear
	 * 
	 * @return panelCanjear, panel de canjear
	 */
	private JPanel getPanelCanjearRegalos() {
		if (panelCanjearRegalos == null) {
			panelCanjearRegalos = new JPanel();
			panelCanjearRegalos.setBackground(new Color(152, 251, 152));
			panelCanjearRegalos.setLayout(new BorderLayout(7, 7));
			panelCanjearRegalos.add(getPanelCentroCanjear(), BorderLayout.CENTER);
			panelCanjearRegalos.add(getPanelNorteCanjear(), BorderLayout.NORTH);
			panelCanjearRegalos.add(getPanelSurCanjear(), BorderLayout.SOUTH);
			panelCanjearRegalos.add(getPanelEsteCanjear(), BorderLayout.EAST);
			panelCanjearRegalos.add(getPanelOesteCanjear(), BorderLayout.WEST);
		}
		return panelCanjearRegalos;
	}
	
	/**
	 * M�todo que crea el panel central del panel de canjear
	 * 
	 * @return panelCentroCanjear, panel central del panel de canjear
	 */
	private JPanel getPanelCentroCanjear() {
		if (panelCentroCanjear == null) {
			panelCentroCanjear = new JPanel();
			panelCentroCanjear.setBackground(new Color(152, 251, 152));
			panelCentroCanjear.setLayout(new GridLayout(0, 5, 6, 6));
			addGiftButtons(game.getGifts().length);
		}
		return panelCentroCanjear;
	}
	
	/**
	 * M�todo que crea el panel norte del panel de canjear
	 * 
	 * @return panelNorteCanjear, panel norte del panel de canjear
	 */
	private JPanel getPanelNorteCanjear() {
		if (panelNorteCanjear == null) {
			panelNorteCanjear = new JPanel();
			panelNorteCanjear.setBackground(new Color(152, 251, 152));
			panelNorteCanjear.setLayout(new GridLayout(0, 3, 0, 0));
			panelNorteCanjear.add(getLblAdornoCanjearIzda());
			panelNorteCanjear.add(getLblTituloCanjear());
			panelNorteCanjear.add(getLblAdornoCanjearDcha());
		}
		return panelNorteCanjear;
	}
	
	/**
	 * M�todo que crea el panel sur del panel de canjear
	 * 
	 * @return panelSurCanjear, panel sur del panel de canjear
	 */
	private JPanel getPanelSurCanjear() {
		if (panelSurCanjear == null) {
			panelSurCanjear = new JPanel();
			panelSurCanjear.setBackground(new Color(152, 251, 152));
			panelSurCanjear.setLayout(new GridLayout(1, 0, 5, 5));
			panelSurCanjear.add(getLblRellenoCanjear());
			panelSurCanjear.add(getLblRellenoCanjear2());
			panelSurCanjear.add(getLblTusPuntosCanjear());
			panelSurCanjear.add(getTextFieldPuntosCanjear());
			panelSurCanjear.add(getLblPuntosCanjear());
			panelSurCanjear.add(getLblRellenoCanjear3());
			panelSurCanjear.add(getLblUnidades());
			panelSurCanjear.add(getSpinnerUnidades());
			panelSurCanjear.add(getBtnEliminar());
			panelSurCanjear.add(getBtnSolicitar());
		}
		return panelSurCanjear;
	}
	
	/**
	 * M�todo que crea el panel este del panel de canjear
	 * 
	 * @return panelEsteCanjear, panel este del panel de canjear
	 */
	private JPanel getPanelEsteCanjear() {
		if (panelEsteCanjear == null) {
			panelEsteCanjear = new JPanel();
			panelEsteCanjear.setBackground(new Color(152, 251, 152));
			panelEsteCanjear.setLayout(new GridLayout(0, 1, 7, 7));
			panelEsteCanjear.add(getScrollPaneGiftInfo());
			panelEsteCanjear.add(getScrollPaneLista());
		}
		return panelEsteCanjear;
	}
	
	/**
	 * M�todo que crea la etiqueta de tus puntos del panel de canjear
	 * 
	 * @return lblTusPuntosCanjear, etiqueta de tus puntos del panel de canjear
	 */
	private JLabel getLblTusPuntosCanjear() {
		if (lblTusPuntosCanjear == null) {
			lblTusPuntosCanjear = new JLabel((String) null);
			lblTusPuntosCanjear.setHorizontalAlignment(SwingConstants.CENTER);
			lblTusPuntosCanjear.setForeground(new Color(165, 42, 42));
			lblTusPuntosCanjear.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblTusPuntosCanjear.setBackground(new Color(152, 251, 152));
		}
		return lblTusPuntosCanjear;
	}
	
	/**
	 * M�todo que crea el text field de tus puntos del panel de canjear
	 * 
	 * @return textFieldPuntosCanjear, text field de tus puntos del panel de canjear
	 */
	private JTextField getTextFieldPuntosCanjear() {
		if (textFieldPuntosCanjear == null) {
			textFieldPuntosCanjear = new JTextField();
			textFieldPuntosCanjear.setToolTipText((String) null);
			textFieldPuntosCanjear.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldPuntosCanjear.setForeground(new Color(152, 251, 152));
			textFieldPuntosCanjear.setFont(new Font("Tahoma", Font.BOLD, 26));
			textFieldPuntosCanjear.setEditable(false);
			textFieldPuntosCanjear.setBorder(new LineBorder(new Color(0, 100, 0), 4, true));
			textFieldPuntosCanjear.setBackground(new Color(46, 139, 87));
		}
		return textFieldPuntosCanjear;
	}
	
	/**
	 * M�todo que crea la etiqueta de puntos del panel de canjear
	 * 
	 * @return lblPuntosCanjear, etiqueta de puntos del panel de canjear
	 */
	private JLabel getLblPuntosCanjear() {
		if (lblPuntosCanjear == null) {
			lblPuntosCanjear = new JLabel((String) null);
			lblPuntosCanjear.setForeground(new Color(165, 42, 42));
			lblPuntosCanjear.setFont(new Font("Tahoma", Font.ITALIC, 18));
			lblPuntosCanjear.setBackground(new Color(152, 251, 152));
		}
		return lblPuntosCanjear;
	}
	
	/**
	 * M�todo que crea la etiqueta de relleno del panel de canjear
	 * 
	 * @return lblRellenoCanjear, etiqueta de relleno del panel de canjear
	 */
	private JLabel getLblRellenoCanjear() {
		if (lblRellenoCanjear == null) {
			lblRellenoCanjear = new JLabel("");
		}
		return lblRellenoCanjear;
	}
	
	/**
	 * M�todo que crea la etiqueta de relleno 2 del panel de canjear
	 * 
	 * @return lblRellenoCanjear2, etiqueta de relleno 2 del panel de canjear
	 */
	private JLabel getLblRellenoCanjear2() {
		if (lblRellenoCanjear2 == null) {
			lblRellenoCanjear2 = new JLabel("");
		}
		return lblRellenoCanjear2;
	}
	
	/**
	 * M�todo que crea la etiqueta de relleno 3 del panel de canjear
	 * 
	 * @return lblRellenoCanjear3, etiqueta de relleno 3 del panel de canjear
	 */
	private JLabel getLblRellenoCanjear3() {
		if (lblRellenoCanjear3 == null) {
			lblRellenoCanjear3 = new JLabel("");
		}
		return lblRellenoCanjear3;
	}
	
	/**
	 * M�todo que crea el boton de solicitar
	 * 
	 * @return btnSolicitar, boton de solicitar
	 */
	private JButton getBtnSolicitar() {
		if (btnSolicitar == null) {
			btnSolicitar = new JButton((String) null);
			btnSolicitar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkEnding();
				}
			});
			btnSolicitar.setToolTipText((String) null);
			btnSolicitar.setForeground(new Color(47, 79, 79));
			btnSolicitar.setFont(new Font("Tahoma", Font.BOLD, 18));
			btnSolicitar.setEnabled(false);
			btnSolicitar.setBorder(new LineBorder(new Color(0, 100, 0), 4, true));
			btnSolicitar.setBackground(new Color(60,179,113));
		}
		return btnSolicitar;
	}
	
	/**
	 * M�todo que comprueba el final de la aplicaci�n
	 */
	protected void checkEnding(){
		if (game.getPoints()!=0) {
			int answer = JOptionPane.showOptionDialog(this,  textos.getString("mensajePuntosPendientes1") +
					"\n" + textos.getString("mensajePuntosPendientes2") + " " + game.getPoints() + " pts.\n"  + 
						textos.getString("mensajePuntosPendientes3") + "\n\n" + game.getSelectedGiftsToString() + 
							textos.getString("mensajePuntosPendientes4"), textos.getString("tituloPuntosPendientes"), 
								JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, new Object[] {textos.getString("opcionSi"), 
										textos.getString("opcionNo")}, textos.getString("opcionSi"));
			if (answer == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(this, textos.getString("mensajeFinal"), textos.getString("tituloFinal"), 
						JOptionPane.INFORMATION_MESSAGE);
				confirmEnding();
			}
		} else {
			int answer = JOptionPane.showOptionDialog(this,  textos.getString("mensajeConfirmacion1") + "\n\n" +
					game.getSelectedGiftsToString() + textos.getString("mensajeConfirmacion2"), textos.getString("tituloConfimacion"), 
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {textos.getString("opcionSi"), 
								textos.getString("opcionNo")}, textos.getString("opcionSi"));
			if (answer == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(this, textos.getString("mensajeFinal"), textos.getString("tituloFinal"), 
						JOptionPane.INFORMATION_MESSAGE);
				confirmEnding();
			}			
		}
	}
	
	/**
	 * M�todo que realiza las acciones requeridas cuando el cliente ha canjeado sus puntos y ha terminado su juego en el programa
	 */
	private void confirmEnding() {
		game.showSelectedGifts();
		game.saveDeliveriesToFile();
		restartApp();
	}
	
	/**
	 * M�todo que reinicia la aplicaci�n prepar�ndola para un nuevo usuario
	 */
	private void restartApp() {
		modeloListaRegalos.removeAllElements();		
		getVI().restart();
		dispose();		
	}

	/**
	 * M�todo que crea la etiqueta de relleno 3 del panel de canjear
	 * 
	 * @return lblRellenoCanjear3, etiqueta de relleno 3 del panel de canjear
	 */
	private JLabel getLblUnidades() {
		if (lblUnidades == null) {
			lblUnidades = new JLabel("");
			lblUnidades.setHorizontalAlignment(SwingConstants.CENTER);
			lblUnidades.setForeground(new Color(165, 42, 42));
			lblUnidades.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblUnidades.setLabelFor(getSpinnerUnidades());
		}
		return lblUnidades;
	}
	
	/**
	 * M�todo que crea el panel oeste del panel de canjear
	 * 
	 * @return panelOesteCanjear, panel oeste del panel de canjear
	 */
	private JPanel getPanelOesteCanjear() {
		if (panelOesteCanjear == null) {
			panelOesteCanjear = new JPanel();
			panelOesteCanjear.setBackground(new Color(152, 251, 152));
			panelOesteCanjear.setLayout(new GridLayout(0, 1, 3, 5));
			panelOesteCanjear.add(getBtnTodos());
			panelOesteCanjear.add(getBtnAlimentacion());
			panelOesteCanjear.add(getBtnDeportes());
			panelOesteCanjear.add(getBtnElectronica());
			panelOesteCanjear.add(getBtnJuguetes());
			panelOesteCanjear.add(getBtnViajesYExperiencias());
			panelOesteCanjear.add(getPanelSlider());
		}
		return panelOesteCanjear;
	}
	
	/**
	 * M�todo que crea el boton de filtrado de Todos
	 * 
	 * @return btnTodos, boton de filtrado de Todos
	 */
	private JButton getBtnTodos() {
		if (btnTodos == null) {
			btnTodos = new JButton("");
			btnTodos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					section = "Todos";
					int value = getSliderFiltro().getValue();
					enableSelectedButtons(section, value);
				}
			});
			btnTodos.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnTodos.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnTodos.setHorizontalTextPosition(SwingConstants.CENTER);
			btnTodos.setBackground(new Color(152, 251, 152));
			btnTodos.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(ALL_FILE)));
		}
		return btnTodos;
	}
	
	/**
	 * M�todo que crea el boton de filtrado de Alimentacion
	 * 
	 * @return btnAlimentacion, boton de filtrado de Alimentacion
	 */
	private JButton getBtnAlimentacion() {
		if (btnAlimentacion == null) {
			btnAlimentacion = new JButton("");
			btnAlimentacion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					section = "A";
					int value = getSliderFiltro().getValue();
					enableSelectedButtons(section, value);
				}
			});
			btnAlimentacion.setFont(new Font("Dialog", Font.PLAIN, 14));
			btnAlimentacion.setBackground(new Color(152, 251, 152));
			btnAlimentacion.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnAlimentacion.setHorizontalTextPosition(SwingConstants.CENTER);
			btnAlimentacion.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(NUTRITION_FILE)));
		}
		return btnAlimentacion;
	}
		
	/**
	 * M�todo que crea el boton de filtrado de Deportes
	 * 
	 * @return btnDeportes, boton de filtrado de Deportes
	 */
	private JButton getBtnDeportes() {
		if (btnDeportes == null) {
			btnDeportes = new JButton("");
			btnDeportes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					section = "D";
					int value = getSliderFiltro().getValue();
					enableSelectedButtons(section, value);
				}
			});
			btnDeportes.setFont(new Font("Dialog", Font.PLAIN, 14));
			btnDeportes.setBackground(new Color(152, 251, 152));
			btnDeportes.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnDeportes.setHorizontalTextPosition(SwingConstants.CENTER);
			btnDeportes.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(SPORTS_FILE)));
		}
		return btnDeportes;
	}
	
	/**
	 * M�todo que crea el boton de filtrado de Electronica
	 * 
	 * @return btnElectronica, boton de filtrado de Electronica
	 */
	private JButton getBtnElectronica() {
		if (btnElectronica == null) {
			btnElectronica = new JButton("");
			btnElectronica.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					section = "E";
					int value = getSliderFiltro().getValue();
					enableSelectedButtons(section, value);
				}
			});
			btnElectronica.setFont(new Font("Dialog", Font.PLAIN, 14));
			btnElectronica.setBackground(new Color(152, 251, 152));
			btnElectronica.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnElectronica.setHorizontalTextPosition(SwingConstants.CENTER);
			btnElectronica.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(ELECTRONICS_FILE)));
		}
		return btnElectronica;
	}
	
	/**
	 * M�todo que crea el boton de filtrado de Juguetes
	 * 
	 * @return btnJuguetes, boton de filtrado de Juguetes
	 */
	private JButton getBtnJuguetes() {
		if (btnJuguetes == null) {
			btnJuguetes = new JButton("");
			btnJuguetes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					section = "J";
					int value = getSliderFiltro().getValue();
					enableSelectedButtons(section, value);
				}
			});
			btnJuguetes.setFont(new Font("Dialog", Font.PLAIN, 14));
			btnJuguetes.setBackground(new Color(152, 251, 152));
			btnJuguetes.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnJuguetes.setHorizontalTextPosition(SwingConstants.CENTER);
			btnJuguetes.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(TOYS_FILE)));
		}
		return btnJuguetes;
	}
	
	/**
	 * M�todo que crea el boton de filtrado de ViajesYExperiencias
	 * 
	 * @return btnViajesYExperiencias, boton de filtrado de ViajesYExperiencias
	 */
	private JButton getBtnViajesYExperiencias() {
		if (btnViajesYExperiencias == null) {
			btnViajesYExperiencias = new JButton("");
			btnViajesYExperiencias.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					section = "V";
					int value = getSliderFiltro().getValue();
					enableSelectedButtons(section, value);
				}
			});
			btnViajesYExperiencias.setFont(new Font("Dialog", Font.PLAIN, 14));
			btnViajesYExperiencias.setBackground(new Color(152, 251, 152));
			btnViajesYExperiencias.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnViajesYExperiencias.setHorizontalTextPosition(SwingConstants.CENTER);
			btnViajesYExperiencias.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(TRIPS_FILE)));
		}
		return btnViajesYExperiencias;
	}
	
	/**
	 * M�todo que crea el slider del filtro
	 * 
	 * @return sliderFiltro, slider del filtro
	 */
	private JSlider getSliderFiltro() {
		if (sliderFiltro == null) {
			sliderFiltro = new JSlider();
			sliderFiltro.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					int value = getSliderFiltro().getValue();
					getTextFieldPuntosFiltro().setText(String.valueOf(value));
					enableSelectedButtons(section, value);
				}
			});
			sliderFiltro.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
			sliderFiltro.setOrientation(SwingConstants.VERTICAL);
			sliderFiltro.setFont(new Font("Tahoma", Font.BOLD, 12));
			sliderFiltro.setForeground(new Color(165, 42, 42));
			sliderFiltro.setMajorTickSpacing(500);
			sliderFiltro.setSnapToTicks(true);
			sliderFiltro.setMinorTickSpacing(50);
			sliderFiltro.setBackground(new Color(152, 251, 152));
			sliderFiltro.setPaintTicks(true);
			sliderFiltro.setPaintLabels(true);
			sliderFiltro.setMaximum(MAX_VALUE);
			sliderFiltro.setValue(MAX_VALUE);
		}
		return sliderFiltro;
	}
	
	/**
	 * M�todo que crea el panel del slider
	 * 
	 * @return panelSlider, panel del slider
	 */
	private JPanel getPanelSlider() {
		if (panelSlider == null) {
			panelSlider = new JPanel();
			panelSlider.setBackground(new Color(152, 251, 152));
			panelSlider.setLayout(new GridLayout(0, 2, 0, 0));
			panelSlider.add(getPanelPuntos());
			panelSlider.add(getSliderFiltro());
		}
		return panelSlider;
	}
	
	/**
	 * M�todo que crea el panel de los puntos
	 * 
	 * @return panelPuntos, panel de los puntos
	 */
	private JPanel getPanelPuntos() {
		if (panelPuntos == null) {
			panelPuntos = new JPanel();
			panelPuntos.setBackground(new Color(152, 251, 152));
			panelPuntos.setLayout(new GridLayout(0, 1, 3, 3));
			panelPuntos.add(getLblSlider());
			panelPuntos.add(getTextFieldPuntosFiltro());
		}
		return panelPuntos;
	}
	
	/**
	 * M�todo que crea la etiqueta del slider
	 * 
	 * @return lblSlider, etiqueta del slider
	 */
	private JLabel getLblSlider() {
		if (lblSlider == null) {
			lblSlider = new JLabel((String) null);
			lblSlider.setLabelFor(getSliderFiltro());
			lblSlider.setForeground(new Color(165, 42, 42));
			lblSlider.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblSlider.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblSlider;
	}
	
	/**
	 * M�todo que crea el text field de puntos 
	 * 
	 * @return textFieldPutnosFiltro, text field de puntos
	 */
	private JTextField getTextFieldPuntosFiltro() {
		if (textFieldPuntosFiltro == null) {
			textFieldPuntosFiltro = new JTextField();			
			textFieldPuntosFiltro.setEditable(false);
			textFieldPuntosFiltro.setBorder(new LineBorder(new Color(47, 79, 79), 3, true));
			textFieldPuntosFiltro.setBackground(new Color(46, 139, 87));
			textFieldPuntosFiltro.setForeground(new Color(152, 251, 152));
			textFieldPuntosFiltro.setFont(new Font("Tahoma", Font.BOLD, 22));
			textFieldPuntosFiltro.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldPuntosFiltro.setText(String.valueOf(getSliderFiltro().getValue()));
		}
		return textFieldPuntosFiltro;
	}	
	
	/**
	 * M�todo que crea el panel de botones
	 * 
	 * @param i, numero del boton
	 * @return btnCasillas
	 */
	private JButton createGiftButtons(int i) {
		JButton btnGifts = new JButton("");
		btnGifts.setActionCommand(String.valueOf(i));
		btnGifts.setBackground(new Color(143,188,143));
		btnGifts.setFocusPainted(false);
		btnGifts.setBorder(new LineBorder(new Color(165, 42, 42), 4, true));		
		btnGifts.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnGifts.setForeground(new Color(165, 42, 42));
		btnGifts.setToolTipText(textos.getString("toolTipBotonesCanjear"));
		btnGifts.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnGifts.setVerticalAlignment(SwingConstants.TOP);
		btnGifts.setHorizontalTextPosition(SwingConstants.CENTER);
		btnGifts.addActionListener(pGiftB);
		btnGifts.addMouseListener(pGiftF);
		return btnGifts;
	}
	
	/**
	 * M�todo que a�ade los botones de regalos al panel de regalos
	 * 
	 * @param nBotones, numero de botones a a�adir
	 */
	private void addGiftButtons(int nBotones) {
		getPanelCentroCanjear().removeAll();
		for (int i = 0; i < nBotones; i++) {
			getPanelCentroCanjear().add(createGiftButtons(i));
		}
		validate();
	}
	
	/**
	 * M�todo que setea la imagen pasada como par�metro adaptandola al boton
	 * 
	 * @param button, boton
	 * @param imgPath, ruta imagen
	 */
	private void setAdaptedIcon(JButton button, String imgPath) {
		Image originalImg = new ImageIcon(getClass().getResource(imgPath)).getImage();
		Image rescaledImg = originalImg.getScaledInstance(button.getWidth()-WIDTH_GIFT_CORRECTION, 
				button.getHeight()-HEIGHT_GIFT_CORRECTION, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(rescaledImg);
		button.setIcon(icon);
	}
	
	/**
	 * M�todo que asocia los botones a las im�genes
	 */
	private void associateButton() {
		for (int i = 0; i < getPanelCentroCanjear().getComponents().length; i++) {
			final JButton button = (JButton) (getPanelCentroCanjear().getComponents()[i]);
			button.setText(game.getGifts()[i].pointsToString());
			setAdaptedIcon(button, GIFTS_PATH + game.getGiftList().get(i).getId() + ".png");
		}
	}
	
	/**
	 * M�todo que habilita los botones determinados que cumplen los requisitos
	 * 
	 * @param section, secci�n
	 * @param pointsCost, coste de puntos m�ximo
	 */
	private void enableSelectedButtons(String section, int pointsCost) {
		if (section=="Todos") {
			for (int i = 0; i < getPanelCentroCanjear().getComponentCount(); i++) {
				if (Integer.valueOf(game.getGiftList().get(i).getPoints()) <= pointsCost) {
					((JButton) getPanelCentroCanjear().getComponents()[i]).setBackground(new Color(143,188,143));
					((JButton) getPanelCentroCanjear().getComponents()[i]).setEnabled(true);
				} else {					
					((JButton) getPanelCentroCanjear().getComponents()[i]).setBackground(new Color(152, 251, 152));
					((JButton) getPanelCentroCanjear().getComponents()[i]).setEnabled(false);
				}
			}
		} else {
			for (int i = 0; i < getPanelCentroCanjear().getComponentCount(); i++) {
				if ((game.getGiftList().get(i).getSection().equals(section)) && (Integer.valueOf(game.getGiftList().get(i).getPoints())) <= pointsCost) {
					((JButton) getPanelCentroCanjear().getComponents()[i]).setBackground(new Color(143,188,143));
					((JButton) getPanelCentroCanjear().getComponents()[i]).setEnabled(true);
				} else {
					((JButton) getPanelCentroCanjear().getComponents()[i]).setBackground(new Color(152, 251, 152));
					((JButton) getPanelCentroCanjear().getComponents()[i]).setEnabled(false);
				}
			}
		}			
	}
	
	/**
	 * M�todo que a�ade a la lista el contenido
	 * 
	 * @param gift, regalo a a�adir
	 */
	private void addToList(Gift gift) {
		int points = Integer.valueOf(gift.getPoints()) * (int) getSpinnerUnidades().getValue();
		if (points > game.getPoints()) {
			JOptionPane.showMessageDialog(this, textos.getString("mensajeNoPuedeA�adir1") +
					game.getPoints() +  " pts."+ textos.getString("mensajeNoPuedeA�adir2") + points + " pts.", 
						textos.getString("tituloCanjear"), JOptionPane.INFORMATION_MESSAGE);
			getSpinnerUnidades().setValue(1);
		} else {
			if (gift.getSection().equals(Gift.TRIPS)) {	
				JOptionPane.showMessageDialog(this, textos.getString("mensajeViajes"), textos.getString("tituloAvisoViajes"), JOptionPane.INFORMATION_MESSAGE);
				this.trip = new Gift(gift);
				VentanaAuxiliar vA = new VentanaAuxiliar(this, localizacion);				
				vA.setVisible(true);				
				if(!trip.getDate().equals("")) {
					modeloListaRegalos.removeAllElements();
					game.add(trip, 1);
					getTextFieldPuntosCanjear().setText(String.valueOf(game.getPoints()));	
					modeloListaRegalos.addAll(game.getSelectedGifts());
					getSpinnerUnidades().setValue(1);
					checkButtons();
				}				
			} else {
				modeloListaRegalos.removeAllElements();
				int value = (int) getSpinnerUnidades().getValue();
				game.add(gift, value);
				getTextFieldPuntosCanjear().setText(String.valueOf(game.getPoints()));			
				modeloListaRegalos.addAll(game.getSelectedGifts());
				getSpinnerUnidades().setValue(1);
				checkButtons();
			}			
		}		
	}
	
	/**
	 * M�todo que devuelve el viaje o experiencia seleccionado
	 * 
	 * @return trip, viaje o experiencia
	 */
	public Gift getTrip() {
		return trip;
	}
	
	/**
	 * M�todo que setea el viaje o experiencia seleccionado
	 * 
	 * @param trip, viaje o experiencia
	 */
	public void setTrip(Gift trip) {
		this.trip = trip;
	}
	
	/**
	 * M�todo que crea el boton de eliminar
	 * 
	 * @return btnEliminar, boton de eliminar
	 */
	private JButton getBtnEliminar() {
		if (btnEliminar == null) {
			btnEliminar = new JButton("");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					removeGifts();						
				}
			});
			btnEliminar.setEnabled(false);
			btnEliminar.setForeground(new Color(128, 0, 0));
			btnEliminar.setBorder(new LineBorder(new Color(139, 0, 0), 4, true));
			btnEliminar.setBackground(new Color(205, 92, 92));
			btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		return btnEliminar;
	}	
	
	/**
	 * M�todo encargado de eliminar los regalos de la lista
	 */
	protected void removeGifts() {
		if (getListGift().getSelectedIndex() == -1) {
			getListGift().setSelectedIndex(0);
		}
		int value = (int) getSpinnerUnidades().getValue();
		removeFromList(getListGift().getSelectedValue(), value);	
	}
	
	/**
	 * M�todo que elimina el regalo seleccionado de la lista 
	 * 
	 * @param gift, regalo a eliminar de la lista
	 * @param units, unidades a eliminar de la lista
	 */
	private void removeFromList(Gift gift, int units) {
		if (gift.getUnits() < units) {
			JOptionPane.showMessageDialog(this, textos.getString("mensajeNoPuedeEliminar1") +
					gift.getUnits() + " " + textos.getString("mensajeNoPuedeEliminar2") + units + " " +
						textos.getString("mensajeNoPuedeEliminar3"), textos.getString("tituloCanjear"), JOptionPane.INFORMATION_MESSAGE);
			getSpinnerUnidades().setValue(1);
		} else {
			modeloListaRegalos.removeAllElements();
			game.remove(gift, units);
			getTextFieldPuntosCanjear().setText(String.valueOf(game.getPoints()));		
			modeloListaRegalos.addAll(game.getSelectedGifts());
			getSpinnerUnidades().setValue(1);
			checkButtons();
		}
	}

	/**
	 * M�todo que comprueba si los botones pueden o no habilitarse
	 */
	private void checkButtons() {
		if (modeloListaRegalos.size()!=0) {
			getBtnSolicitar().setEnabled(true);
			getBtnEliminar().setEnabled(true);
		} else if (modeloListaRegalos.size()==0) {
			getBtnSolicitar().setEnabled(false);
			getBtnEliminar().setEnabled(false);
		}
	}
	
	/**
	 * M�todo que crea el spinner de las unidades
	 * 
	 * @return spinnerUnidades, spinner de las unidades
	 */
	private JSpinner getSpinnerUnidades() {
		if (spinnerUnidades == null) {
			spinnerUnidades = new JSpinner();
			spinnerUnidades.setBorder(new LineBorder(new Color(47, 79, 79), 3, true));
			spinnerUnidades.setBackground(new Color(143, 188, 143));
			spinnerUnidades.setForeground(new Color(0, 100, 0));
			spinnerUnidades.setFont(new Font("Tahoma", Font.BOLD, 18));
			spinnerUnidades.setModel(new SpinnerNumberModel(1, 1, 250, 1));
		}
		return spinnerUnidades;
	}
	
	/**
	 * M�todo que crea panel de scroll de la lista
	 * 
	 * @return scrollPanelLista, panel de scroll de la lista
	 */
	private JScrollPane getScrollPaneLista() {
		if (scrollPaneLista == null) {
			scrollPaneLista = new JScrollPane();
			scrollPaneLista.setBackground(new Color(143, 188, 143));
			scrollPaneLista.setBorder(new LineBorder(new Color(47, 79, 79), 3, true));
			scrollPaneLista.setViewportView(getListGift());
			scrollPaneLista.setColumnHeaderView(getLblTituloLista());
		}
		return scrollPaneLista;
	}
	
	/**
	 * M�todo que crea la lista de regalos
	 * 
	 * @return listGift, lista de regalos
	 */
	private JList<Gift> getListGift() {
		if (listGift == null) {
			modeloListaRegalos = new DefaultListModel<Gift>();
			listGift = new JList<Gift>(modeloListaRegalos);			
			listGift.setForeground(new Color(0, 0, 0));
			listGift.setBorder(new LineBorder(new Color(0, 100, 0), 2, true));
			listGift.setBackground(new Color(152, 251, 152));
			listGift.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);			
		}
		return listGift;
	}
	
	/**
	 * M�todo que crea la etiqueta del titulo
	 * 
	 * @return lblTituloCanjear, etiqueta del titulo
	 */
	private JLabel getLblTituloCanjear() {
		if (lblTituloCanjear == null) {
			lblTituloCanjear = new JLabel("");
			lblTituloCanjear.setForeground(new Color(165, 42, 42));
			lblTituloCanjear.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 48));
			lblTituloCanjear.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblTituloCanjear;
	}
	
	/**
	 * M�todo que crea la etiqueta del adorno de la izda
	 * 
	 * @return lblAdornoCanjearIzda, etiqueta del adorno de la izda 
	 */
	private JLabel getLblAdornoCanjearIzda() {
		if (lblAdornoCanjearIzda == null) {
			lblAdornoCanjearIzda = new JLabel("");
			lblAdornoCanjearIzda.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(ADORNO_IZDA)));
		}
		return lblAdornoCanjearIzda;
	}
	
	/**
	 * M�todo que crea la etiqueta del adorno de la dcha
	 * 
	 * @return lblAdornoCanjearDcha, etiqueta del adorno de la dcha 
	 */
	private JLabel getLblAdornoCanjearDcha() {
		if (lblAdornoCanjearDcha == null) {
			lblAdornoCanjearDcha = new JLabel("");
			lblAdornoCanjearDcha.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(ADORNO_DCHA)));
			lblAdornoCanjearDcha.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblAdornoCanjearDcha;
	}
	
	/**
	 * M�todo que crea la etiqueta del titulo de la lista
	 * 
	 * @return lblTituloLista, etiqueta del titulo de la lista
	 */
	private JLabel getLblTituloLista() {
		if (lblTituloLista == null) {
			lblTituloLista = new JLabel("");
			lblTituloLista.setForeground(new Color(0, 100, 0));
			lblTituloLista.setLabelFor(getListGift());
			lblTituloLista.setHorizontalAlignment(SwingConstants.CENTER);
			lblTituloLista.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblTituloLista.setBackground(new Color(143, 188, 143));
			lblTituloLista.setOpaque(true);
		}
		return lblTituloLista;
	}
	
	/**
	 * M�todo que crea el panel de scroll de la info del regalo
	 * 
	 * @return scrollPaneGiftInfo, panel de scroll de la info del regalo
	 */
	private JScrollPane getScrollPaneGiftInfo() {
		if (scrollPaneGiftInfo == null) {
			scrollPaneGiftInfo = new JScrollPane();
			scrollPaneGiftInfo.setViewportView(getTextAreaGiftInfo());
			scrollPaneGiftInfo.setColumnHeaderView(getLblTituloInfo());
			scrollPaneGiftInfo.setBorder(new LineBorder(new Color(47, 79, 79), 3, true));
		}
		return scrollPaneGiftInfo;
	}
	
	/**
	 * M�todo que crea el text area de la info del regalo
	 * 
	 * @return textAreaGiftInfo, text area de la info del regalo
	 */
	private JTextArea getTextAreaGiftInfo() {
		if (textAreaGiftInfo == null) {
			textAreaGiftInfo = new JTextArea();
			textAreaGiftInfo.setWrapStyleWord(true);
			textAreaGiftInfo.setFont(new Font("Monospaced", Font.PLAIN, 17));
			textAreaGiftInfo.setLineWrap(true);
			textAreaGiftInfo.setBackground(new Color(152, 251, 152));
			textAreaGiftInfo.setBorder(new LineBorder(new Color(0, 100, 0), 2, true));
			textAreaGiftInfo.setEditable(false);
		}
		return textAreaGiftInfo;
	}
	
	/**
	 * M�todo que crea la etiqueta del titulo de la informaci�n
	 * 
	 * @return lblTituloInfo, etiqueta del titulo de la informaci�n
	 */
	private JLabel getLblTituloInfo() {
		if (lblTituloInfo == null) {
			lblTituloInfo = new JLabel("");
			lblTituloInfo.setForeground(new Color(0, 100, 0));
			lblTituloInfo.setBackground(new Color(143, 188, 143));
			lblTituloInfo.setOpaque(true);
			lblTituloInfo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTituloInfo.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		return lblTituloInfo;
	}	

//-- MENU ----------------------------------------------------------------------
	/**
	 * M�todo que crea la barra de menus principal
	 * 
	 * @return menuBarPrincipal, barra de menus principal
	 */
	private JMenuBar getMenuBarPrincipal() {
		if (menuBarPrincipal == null) {
			menuBarPrincipal = new JMenuBar();
			menuBarPrincipal.setBackground(new Color(143, 188, 143));
			menuBarPrincipal.add(getMnJuego());
			menuBarPrincipal.add(getMnIdioma());
			menuBarPrincipal.add(getMnAyuda());
		}
		return menuBarPrincipal;
	}
	
	/**
	 * M�todo que crea el menu de juego
	 * 
	 * @return mnJuego,, menu de juego
	 */
	private JMenu getMnJuego() {
		if (mnJuego == null) {
			mnJuego = new JMenu("");
			mnJuego.setFont(new Font("Segoe UI", Font.BOLD, 16));
			mnJuego.setBackground(new Color(152, 251, 152));
			mnJuego.add(getMntmNuevo());
			mnJuego.add(getMntmSalir());
		}
		return mnJuego;
	}
	
	/**
	 * M�todo que crea el item de nuevo
	 * 
	 * @return mntmNuevo, item de nuevo
	 */
	private JMenuItem getMntmNuevo() {
		if (mntmNuevo == null) {
			mntmNuevo = new JMenuItem("");
			mntmNuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (confirmNew()) {
						restartApp();
					}					
				}
			});
			mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
			mntmNuevo.setFont(new Font("Tahoma", Font.ITALIC, 14));
		}
		return mntmNuevo;
	}
	
	/**
	 * M�todo que confirma el reinicio de la aplicaci�n
	 * 
	 * @return true o false, en funci�n de si se sale de la aplicaci�n.
	 */
	private boolean confirmNew() {
		int answer = JOptionPane.showOptionDialog(this,  textos.getString("mensajeNuevo"), textos.getString("tituloNuevo"), 
				JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, new Object[] {textos.getString("opcionSi"), 
						textos.getString("opcionNo")}, textos.getString("opcionSi"));
		if (answer==JOptionPane.YES_OPTION) {
			return true;
		}
		return false;
	}
	
	/**
	 * M�todo que crea el item de salir
	 * 
	 * @return mntmSalir, item de salir
	 */
	private JMenuItem getMntmSalir() {
		if (mntmSalir == null) {
			mntmSalir = new JMenuItem("");
			mntmSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (confirmExit()) {
						System.exit(0);
					}
				}
			});
			mntmSalir.setFont(new Font("Tahoma", Font.ITALIC, 14));
		}
		return mntmSalir;
	}
	
	/**
	 * M�todo que confirma la salida de la aplicaci�n
	 * 
	 * @return true o false, si se confirma
	 */
	private boolean confirmExit() {
		int answer = JOptionPane.showOptionDialog(this,  textos.getString("mensajeSalir"), textos.getString("tituloSalir"), 
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, new Object[] {textos.getString("opcionSi"), 
								textos.getString("opcionNo")}, textos.getString("opcionSi"));
		if (answer==JOptionPane.YES_OPTION) {
			return true;
		}
		return false;
	}
	
	/**
	 * M�todo que crea el men� de idioma
	 * 
	 * @return mnIdioma, menu de idioma
	 */
	private JMenu getMnIdioma() {
		if (mnIdioma == null) {
			mnIdioma = new JMenu("");
			mnIdioma.setBackground(new Color(143, 188, 143));
			mnIdioma.setFont(new Font("Segoe UI", Font.BOLD, 16));
			mnIdioma.add(getMntmEspa�ol());
			mnIdioma.add(getMntmIngles());
		}
		return mnIdioma;
	}
	
	/**
	 * M�todo que crea el menu item de cambio a espa�ol
	 * 
	 * @return mntmEspa�ol, menu item de cambio a espa�ol
	 */
	private JMenuItem getMntmEspa�ol() {
		if (mntmEspa�ol == null) {
			mntmEspa�ol = new JMenuItem("");
			mntmEspa�ol.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					localizacion = new Locale("es");
					setTexts(localizacion);
					game.changeToSpanish();
					modeloListaRegalos.removeAllElements();
					modeloListaRegalos.addAll(game.getSelectedGifts());
				}
			});
			mntmEspa�ol.setFont(new Font("Tahoma", Font.ITALIC, 14));
		}
		return mntmEspa�ol;
	}
	
	/**
	 * M�todo que crea el menu item de cambio a ingles
	 * 
	 * @return mntmIngles, menu item de cambio a ingles
	 */	
	private JMenuItem getMntmIngles() {
		if (mntmIngles == null) {
			mntmIngles = new JMenuItem("");
			mntmIngles.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					localizacion = new Locale("en");
					setTexts(localizacion);
					game.changeToEnglish();
					modeloListaRegalos.removeAllElements();
					modeloListaRegalos.addAll(game.getSelectedGifts());
				}
			});
			mntmIngles.setFont(new Font("Tahoma", Font.ITALIC, 14));
		}
		return mntmIngles;
	}
	
	/**
	 * M�todo que crea el men� de ayuda
	 * 
	 * @return mnAyuda, men� de ayuda
	 */
	private JMenu getMnAyuda() {
		if (mnAyuda == null) {
			mnAyuda = new JMenu("");
			mnAyuda.setBackground(new Color(143, 188, 143));
			mnAyuda.setFont(new Font("Segoe UI", Font.BOLD, 16));
			mnAyuda.add(getMntmContenidos());
			mnAyuda.add(getMntmAcercaDe());
		}
		return mnAyuda;
	}
	
	/**
	 * M�todo que crea el item de contenidos
	 * 
	 * @return mntmContenidos, item de contenidos
	 */
	private JMenuItem getMntmContenidos() {
		if (mntmContenidos == null) {
			mntmContenidos = new JMenuItem("");
			mntmContenidos.setFont(new Font("Tahoma", Font.ITALIC, 14));
			mntmContenidos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		}
		return mntmContenidos;
	}
	
	/**
	 * M�todo que crea el item de acerca de
	 * 
	 * @return mntmAcercaDe, item de acerca de 
	 */
	private JMenuItem getMntmAcercaDe() {
		if (mntmAcercaDe == null) {
			mntmAcercaDe = new JMenuItem("");
			mntmAcercaDe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showAbout();
				}
			});
			mntmAcercaDe.setFont(new Font("Tahoma", Font.ITALIC, 14));
		}
		return mntmAcercaDe;
	}
	
	/**
	 * M�todo que muestra el panel Acerca De
	 */
	private void showAbout() {
		JOptionPane.showMessageDialog(this, textos.getString("mensajeAcercaDe"), 
				textos.getString("tituloAcercaDe"), JOptionPane.INFORMATION_MESSAGE);
	}
	
//-- EVENTOS -------------------------------------------------------------------
	/**
	 * T�tulo: Clase ProcessGameButton
	 * Descripci�n: Clase que procesa el evento de las casillas del juego 
	 *
	 * @author Omar Teixeira, UO281847
	 * @version 30 dic. 2021
	 */
	public class ProcessGameButton implements ActionListener {
		/**
		 * M�todo que ejecuta una acci�n
		 * 
		 * @param e, evento
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			((JButton) e.getSource()).setBorder(new LineBorder(new Color(0, 0, 255), 8, true));
			((JButton) e.getSource()).setEnabled(false);
			int pos = Integer.parseInt(((JButton) e.getSource()).getActionCommand());
			shoot(pos);
		}		
	}
	
	/**
	 * T�tulo: Clase ProcessGiftButton
	 * Descripci�n: Clase que procesa el evento de los botones de los regalos 
	 *
	 * @author Omar Teixeira, UO281847
	 * @version 2 ene. 2021
	 */
	public class ProcessGiftButton implements ActionListener {
		/**
		 * M�todo que ejecuta una acci�n
		 * 
		 * @param e, evento
		 */
		@Override
		public void actionPerformed(ActionEvent e) {			
			JButton btn = (JButton) e.getSource();
			btn.setBorder(new LineBorder(new Color(0, 0, 255), 8, true));
			addToList(game.getGifts()[Integer.valueOf(btn.getActionCommand())]);
		}		
	}	
	/**
	 * Titulo: Clase processGiftInfo
	 * Descripci�n: Clase que procesa cuando el rat�n se posa sobre uno de los botones mostrado as� la informaci�n
	 *
	 * @author Omar Teixeira, UO281847
	 * @version 2 ene. 2022
	 */
	public class ProcessGiftFocus extends MouseAdapter {
		/**
		 * M�todo que capta el evento de cuando el rat�n se posa sobre el boton
		 * 
		 * @param e, evento
		 */
		public void mouseEntered(MouseEvent e) {
			JButton btn = (JButton) e.getSource();
			if (btn.isEnabled()) {
				btn.setBorder(new LineBorder(new Color(212,175,55), 8, true));
				getTextAreaGiftInfo().setText(game.getGiftInfo(Integer.valueOf(btn.getActionCommand())));
			}			
		}
		
		/**
		 * M�todo que capta el evento de cuando el rat�n sale del boton
		 * 
		 * @param e, evento
		 */
		public void mouseExited(MouseEvent e) {
			JButton btn = (JButton) e.getSource();
			if (btn.isEnabled()) {
				btn.setBorder(new LineBorder(new Color(165, 42, 42), 4, true));
				getTextAreaGiftInfo().setText("");
			}
		}
	}
}	