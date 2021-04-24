package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

import controlador.AlumnoDAO;
import modelo.Alumno;



public class VentanaInicio extends JFrame{
	
	 public VentanaInicio() {
	        crearComponentes();
	    }
	 
	 JInternalFrame frameAltas, frameBajas, frameModificaciones, frameConsultas;
	 JTextField txtNumControl, txtNombres, txtPrimerAp, txtSegundoAp, txtEdad=new JTextField("18");
	 JButton btnAgregar, btnEliminar, btnCancelar, btnRestablecer, btnRestablecer2, btnRestablecer3, btnRestablecer4,
	         btnRestablecer5, btnRestablecer6, btnBuscar, btnModificar;
	 JComboBox<String> cboSemestre, cboCarrera;
	 JScrollPane scroll;
	 JTable tablaAlumnos;
	 
	 public void crearComponentes() {
	        
		    getContentPane().setLayout(new BorderLayout());
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setTitle("ALTAS, BAJAS, CAMBIOS Y CONSULTAS");
	        setSize(710, 660);
	        setLocationRelativeTo(null);
	        setVisible(true);

	        JDesktopPane pane = new JDesktopPane();

	        //-------------------------------------- MENU PRINCIPAL ----------------------------------

	        JMenuBar menuBar = new JMenuBar();
	        JMenu menu = new JMenu("Menu Alumnos");
	        JMenuItem menuAlt = new JMenuItem("Altas");
	        menuAlt.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));
	        menuAlt.addActionListener(new ActionListener() {

	        	@Override
				public void actionPerformed(ActionEvent arg0) {
					
					frameAltas.setVisible(true);
				}
	        });
	        menu.add(menuAlt);

	        JMenuItem menuBaj = new JMenuItem("Bajas");
	        menuBaj.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.ALT_MASK));
	        menuBaj.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent e) {
	                frameBajas.setVisible(true);
	            }
	        });
	        menu.add(menuBaj);

	        JMenuItem menuMod = new JMenuItem("Modificaciones");
	        menuMod.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.ALT_MASK));
	        menuMod.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent e) {
	                frameModificaciones.setVisible(true);
	            }
	        });
	        menu.add(menuMod);

	        JMenuItem menuCon = new JMenuItem("Consultas");
	        menuCon.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.ALT_MASK));
	        menuCon.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent e) {
	                frameConsultas.setVisible(true);
	            }
	        });
	        menu.add(menuCon);

	        menuBar.add(menu);
	        setJMenuBar(menuBar);

	        //--------------------------------------- FIN DE MENU -------------------------------------
	        
	        //------------------------------------------ ALTAS ----------------------------------------
	        frameAltas = new JInternalFrame();
	        frameAltas.setLayout(null);
	        frameAltas.setDefaultCloseOperation(HIDE_ON_CLOSE);
	        frameAltas.setSize(700, 595);
	        frameAltas.setTitle("ALTAS");
	        
	        frameAltas.setIconifiable(true);
	        frameAltas.setResizable(true);
	        frameAltas.setClosable(true);
	        frameAltas.setResizable(true);
	        

	        Font f1 = new Font("Arial", Font.ITALIC, 12);
	        JPanel panel1 = new JPanel();
	        panel1.setBackground(new Color(124, 252, 0));
	        panel1.setLayout(null);
	        panel1.setPreferredSize(new Dimension(700, 190));
	        panel1.setBounds(0, 0, 700, 80);

	        JLabel lbl1 = new JLabel("ALTAS ALUMNOS");
	        lbl1.setFont(new Font("Arial", Font.BOLD, 24));
	        lbl1.setForeground(new Color(255, 255, 255));
	        lbl1.setBounds(30, 30, 400, 20);
	        panel1.add(lbl1);

	        frameAltas.add(panel1);

	        Font f2 = new Font("Arial", Font.CENTER_BASELINE, 14);
	        JPanel panel2 = new JPanel();
	        panel2.setLayout(null);
	        panel2.setPreferredSize(new Dimension(700, 190));
	        panel2.setBounds(0, 80, 700, 330);

	        JLabel lblNumControl = new JLabel("NÚMERO DE CONTROL: ");
	        lblNumControl.setFont(f2);
	        lblNumControl.setBounds(100, 30, 400, 25);
	        panel2.add(lblNumControl);

	        txtNumControl = new JTextField(10);
	        txtNumControl.setFont(f2);
	        txtNumControl.setBounds(280, 30, 150, 23);
	        panel2.add(txtNumControl);

	        JLabel lblNombres = new JLabel("NOMBRES:");
	        lblNombres.setFont(f2);
	        lblNombres.setBounds(100, 70, 300, 25);
	        panel2.add(lblNombres);

	        txtNombres = new JTextField(10);
	        txtNombres.setFont(f2);
	        txtNombres.setBounds(200, 70, 230, 23);
	        panel2.add(txtNombres);

	        JLabel lblApePaterno = new JLabel("APELLIDO PATERNO:");
	        lblApePaterno.setFont(f2);
	        lblApePaterno.setBounds(100, 110, 300, 25);
	        panel2.add(lblApePaterno);

	        txtPrimerAp = new JTextField(10);
	        txtPrimerAp.setFont(f2);
	        txtPrimerAp.setBounds(255, 110, 176, 23);
	        panel2.add(txtPrimerAp);

	        JLabel lblApeMaterno = new JLabel("APELLIDO MATERNO:");
	        lblApeMaterno.setFont(f2);
	        lblApeMaterno.setBounds(100, 150, 300, 25);
	        panel2.add(lblApeMaterno);

	        txtSegundoAp = new JTextField(10);
	        txtSegundoAp.setFont(f2);
	        txtSegundoAp.setBounds(255, 150, 176, 23);
	        panel2.add(txtSegundoAp);

	        JLabel lblSemestre = new JLabel("SEMESTRE:");
	        lblSemestre.setFont(f2);
	        lblSemestre.setBounds(100, 200, 300, 25);
	        panel2.add(lblSemestre);

	        cboSemestre = new JComboBox<String>();
	        cboSemestre.addItem("Elige Semestre...");
	        cboSemestre.addItem("1");
	        cboSemestre.addItem("2");
	        cboSemestre.addItem("3");
	        cboSemestre.addItem("4");
	        cboSemestre.addItem("5");
	        cboSemestre.addItem("6");
	        cboSemestre.addItem("7");
	        cboSemestre.addItem("8");
	        cboSemestre.addItem("9");
	        cboSemestre.addItem("10");
	        cboSemestre.setFont(f1);
	        cboSemestre.setBounds(255, 200, 175, 23);
	        panel2.add(cboSemestre);

	        JLabel lblCarrera = new JLabel("CARRERA:");
	        lblCarrera.setFont(f2);
	        lblCarrera.setBounds(100, 240, 300, 25);
	        panel2.add(lblCarrera);

	        cboCarrera = new JComboBox<String>();
	        cboCarrera.setFont(f1);
	        cboCarrera.addItem("Elige Carrera...");
	        cboCarrera.addItem("Ingeniería en Sistemas Computacionales");
	        cboCarrera.addItem("Ingenieria Industrias Alimentarias");
	        cboCarrera.addItem("Ingenieria en Mecatrónica");
	        cboCarrera.addItem("Lincenciatura en Administración");
	        cboCarrera.addItem("Lincenciatura en Contador Publico");
	        cboCarrera.setBounds(255, 240, 175, 23);
	        panel2.add(cboCarrera);

	        btnAgregar = new JButton("AGREGAR");
	        btnAgregar.setFont(f2);
	        btnAgregar.setBounds(460, 100, 120, 30);
	        btnAgregar.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                Alumno a = new Alumno(txtNumControl.getText(), txtNombres.getText(),
	                        txtPrimerAp.getText(), txtSegundoAp.getText(),
	                        Byte.parseByte(txtEdad.getText()),
	                        Byte.parseByte(cboSemestre.getItemAt(1)),
	                        cboCarrera.getItemAt(1));
	                
	                AlumnoDAO aDAO = new AlumnoDAO();
	        		
	        		System.out.println(aDAO.insertarRegistro(a)?"EXITO":"FALLO");
	            }
	        });
	        panel2.add(btnAgregar);

	        btnCancelar = new JButton("CERRAR");
	        btnCancelar.setFont(f2);
	        btnCancelar.setBounds(460, 200, 120, 30);
	        btnCancelar.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent arg0) {
	                frameAltas.setVisible(false);
	            }
	        });
	        panel2.add(btnCancelar);

	        btnRestablecer = new JButton("RESTABLECER");
	        btnRestablecer.setFont(f2);
	        btnRestablecer.setBounds(255, 290, 174, 25);
	        btnRestablecer.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                txtNumControl.setText("");
	                txtNombres.setText("");
	                txtPrimerAp.setText("");
	                txtSegundoAp.setText("");
	                txtNumControl.requestFocus();
	            }
	        });
	        panel2.add(btnRestablecer);

	        frameAltas.add(panel2);

	        JPanel panel3 = new JPanel();
	        panel3.setLayout(null);
	        panel3.setPreferredSize(new Dimension(700, 190));
	        panel3.setBounds(0, 410, 700, 152);

	        tablaAlumnos = new JTable();
	        tablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
	                new Object[][] {}, new String [] {"Num Control", "Nombres", "Primer Ap", "Segundo Ap",
	                "Edad", "Semestre", "Carrera"}
	        ));

	        scroll = new JScrollPane(tablaAlumnos);
	        scroll.setBounds(5, 9, 678, 135);
	        panel3.add(scroll);

	        frameAltas.add(panel3);

	        pane.add(frameAltas);
	        add(pane, BorderLayout.CENTER);
	        //------------------------------------- ALTAS ---------------------------------------

	}
	 
	public static void main(String[] args) {
		
		//Suponiendo que los datos vienen desde la interfaz grafica
		
		/*Alumno a = new Alumno("01", "Luke", "Skywalker", "-", (byte)50, (byte)10, "ISC");
		
		AlumnoDAO aDAO = new AlumnoDAO();
		
		System.out.println(aDAO.insertarRegistro(a)?"EXITO":"Me cambio de carrera");*/
		
		 try {
	            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (InstantiationException e) {
	            e.printStackTrace();
	        } catch (IllegalAccessException e) {
	            e.printStackTrace();
	        } catch (UnsupportedLookAndFeelException e) {
	            e.printStackTrace();
	        }

	        SwingUtilities.invokeLater(new Runnable(){
	            @Override
	            public void run() {
	                new VentanaInicio();
	            }
	        });
	}
}
