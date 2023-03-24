package vista;
import java.awt.EventQueue;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import DatosJugador.DatosJugador;
import modelo.Jugador;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;

public class vJugador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
//	private JLabel lblID;
	private JComboBox<Object> cmbEquipo;
	private JSpinner spnNumeroCamiseta;
	private JTextField txtNombre;
	private JTextField txtAltura;
	private JButton btnLimpiar;
	private JButton btnGuardar;
	private JButton btnEliminar;
	private JButton btnModificar;
	DatosJugador Datos = new DatosJugador();
	DefaultTableModel modelo = new DefaultTableModel();
	ArrayList<Jugador> lista;
	int fila = -1;
	Jugador jugadorTablita = new Jugador();
	private JScrollPane scrollPane;
	private JTable tblJugador;
	private JLabel lblID_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vJugador frame = new vJugador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void actualizarTabla() {

		while (modelo.getRowCount() > 0) {
			modelo.removeRow(0);
		}

		lista = Datos.consultaJugador();

		for (Jugador n : lista) {
			Object jugadorTabla[] = new Object[5];
			jugadorTabla[0] = n.getID_Jugador();
			jugadorTabla[1] = n.getNombre();
			jugadorTabla[2] = n.getEquipo();
			jugadorTabla[3] = n.getNumeroCamiseta();
			jugadorTabla[4] = n.getAltura();
			modelo.addRow(jugadorTabla);
		}
		tblJugador.setModel(modelo);
	}

	public void Limpiar() {
		lblID_1.setText("");
     	txtNombre.setText("");
    	cmbEquipo.setSelectedItem("Selecciona");
    	txtAltura.setText(String.valueOf(""));
		spnNumeroCamiseta.setValue(0);
	

	}

	public vJugador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setTitle("CRUD JUGADOR");
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Plataforma De Informacion De Jugadores");
		lblNewLabel.setBounds(71, 11, 427, 40);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		contentPane.add(lblNewLabel);

		JLabel lblID_Jugador = new JLabel("ID_Jugador:");
		lblID_Jugador.setBounds(29, 62, 100, 20);
		lblID_Jugador.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		contentPane.add(lblID_Jugador);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(29, 110, 68, 20);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		contentPane.add(lblNombre);

		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setBounds(29, 155, 63, 20);
		lblEquipo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		contentPane.add(lblEquipo);

		JLabel lblNumeroCamiseta = new JLabel("NumeroCamiseta");
		lblNumeroCamiseta.setBounds(24, 200, 135, 27);
		lblNumeroCamiseta.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		contentPane.add(lblNumeroCamiseta);

		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(30, 250, 62, 20);
		lblAltura.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		contentPane.add(lblAltura);

		lblID_1 = new JLabel("0");
		lblID_1.setBounds(154, 62, 46, 19);
		lblID_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		contentPane.add(lblID_1);

		txtNombre = new JTextField();
		txtNombre.setBounds(106, 110, 94, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		cmbEquipo = new JComboBox<Object>();
		cmbEquipo.setBounds(106, 153, 94, 22);
		cmbEquipo.setModel(new DefaultComboBoxModel<Object>(new String[] { "Selecciona", "Eraklyom", "Solaria",
				"Linphea", "Andross", "Magix", "Domino", "Zenith" }));
		contentPane.add(cmbEquipo);

		spnNumeroCamiseta = new JSpinner();
		spnNumeroCamiseta.setBounds(169, 205, 43, 20);
		spnNumeroCamiseta.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		contentPane.add(spnNumeroCamiseta);

		txtAltura = new JTextField();
		txtAltura.setBounds(91, 252, 94, 20);
		txtAltura.setColumns(10);
		contentPane.add(txtAltura);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(127, 335, 144, 23);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                     if (Datos.eliminarJugador(jugadorTablita.getID_Jugador())) {
					    actualizarTabla();
						Limpiar();
						JOptionPane.showMessageDialog(null, "Se eliminaron los datos correctamente!!!");
					} else {
						JOptionPane.showMessageDialog(null, "ERROR");
					}

				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "AQUI HAY UN ERROR AL ELIMINAR");
				}
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(btnEliminar);

		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(212, 301, 144, 23);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtNombre.getText().equals("") || cmbEquipo.getSelectedItem().equals("Selecciona")
							 || txtAltura.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "CAMPOS VACIOS Y SON REQUERIDOS");
						return;
						
					}
					jugadorTablita.setNombre(txtNombre.getText());
					jugadorTablita.setEquipo(cmbEquipo.getSelectedItem().toString());
					jugadorTablita.setNumeroCamiseta(Integer.parseInt(spnNumeroCamiseta.getValue().toString()));
					jugadorTablita.setAltura(Double.parseDouble(txtAltura.getText()));
					System.out.print(cmbEquipo.getSelectedItem());
					if (Datos.editarJugador(jugadorTablita)) {
					    actualizarTabla();	
					    Limpiar();
					    JOptionPane.showMessageDialog(null, "Se modificaron los datos correctamente!!!");
					}else {
						JOptionPane.showMessageDialog(null, "ERROR");
					}
				}catch(Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "AQUI HAY UN ERROR AL MODIFICAR");
				}
			}
		});
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(btnModificar);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(419, 318, 135, 23);
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Limpiar();
			}
		});
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(btnLimpiar);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(30, 301, 144, 23);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (txtNombre.getText().equals("") || cmbEquipo.getSelectedItem().equals("Selecciona")
							 || txtAltura.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "CAMPOS VACIOS Y SON REQUERIDOS");
						return;
					}

					Jugador Jugador1 = new Jugador();
					Jugador1.setNombre(txtNombre.getText());
					Jugador1.setEquipo(cmbEquipo.getSelectedItem().toString());
					Jugador1.setNumeroCamiseta(Integer.parseInt(spnNumeroCamiseta.getValue().toString()));
					Jugador1.setAltura(Double.parseDouble(txtAltura.getText()));
					System.out.print(txtAltura.getText());
					if (Datos.insertarJugador(Jugador1)) {
					    actualizarTabla();
						Limpiar();
						JOptionPane.showMessageDialog(null, "Se guardaron los datos correctamente!!!");
					} else {
						JOptionPane.showMessageDialog(null, "ERROR");
					}

				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "AQUI HAY UN ERROR");
				}
			}
		});
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(btnGuardar);
						
						scrollPane = new JScrollPane();
						scrollPane.setBounds(271, 73, 287, 205);
						contentPane.add(scrollPane);
						
						tblJugador = new JTable();
						tblJugador.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								fila=tblJugador.getSelectedRow();
								jugadorTablita = lista.get(fila);
								lblID_1.setText(""+jugadorTablita.getID_Jugador());
								txtNombre.setText(jugadorTablita.getNombre());
								cmbEquipo.setSelectedItem(jugadorTablita.getEquipo());
								txtAltura.setText(String.valueOf(jugadorTablita.getAltura()));
								System.out.print(txtNombre.getText());
								spnNumeroCamiseta.setValue(jugadorTablita.getNumeroCamiseta());
							}
							
						});
						tblJugador.setModel(new DefaultTableModel(
							new Object[][] {
								{null, null, null, null, null},
								{null, null, null, null, null},
								{null, null, null, null, null},
								{null, null, null, null, null},
								{null, null, null, null, null},
							},
							new String[] {
								"New column", "New column", "New column", "New column", "New column"
							}
						));
						scrollPane.setViewportView(tblJugador);
		                modelo.addColumn("ID");
		                modelo.addColumn("NOMBRE");
		                modelo.addColumn("EQUIPO");
		                modelo.addColumn("NUMEROcAMISETA");
		                modelo.addColumn("ALTURA");
		                actualizarTabla();
	         }
     }
