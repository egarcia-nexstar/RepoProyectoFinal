package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;

public class RegSolicitante extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JComboBox cbxPaisResidencia;
	private JComboBox cbxPaisOrigen;
	private JDateChooser dateChooser;

	private JPanel pnlObrero;
	private JPanel pnlTecnico;
	private JPanel pnlGraduado;

	private JRadioButton rdbtnGraduado;
	private JRadioButton rdbtnTecnico;
	private JRadioButton rdbtnObrero;

	/**
	 * Create the dialog.
	 */
	public RegSolicitante() {
		setTitle("Registro de Solicitante");
		setResizable(false);
		setBounds(100, 100, 390, 540);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 364, 285);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setBounds(10, 20, 135, 14);
		panel.add(lblCdula);

		txtCedula = new JTextField();
		txtCedula.setBounds(10, 40, 177, 23);
		panel.add(txtCedula);
		txtCedula.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 70, 135, 14);
		panel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(10, 90, 344, 23);
		panel.add(txtNombre);

		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(10, 120, 135, 14);
		panel.add(lblApellidos);

		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(10, 140, 344, 23);
		panel.add(txtApellidos);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
		lblFechaDeNacimiento.setBounds(10, 170, 135, 14);
		panel.add(lblFechaDeNacimiento);

		JLabel lblGnero = new JLabel("G\u00E9nero:");
		lblGnero.setBounds(200, 170, 135, 14);
		panel.add(lblGnero);

		JComboBox cbxGenero = new JComboBox();
		cbxGenero.setModel(new DefaultComboBoxModel(new String[] { "<Seleccione>", "Masculino", "Femenino" }));
		cbxGenero.setBounds(200, 190, 154, 23);
		panel.add(cbxGenero);

		JLabel lblPasDeOrigen = new JLabel("Pa\u00EDs de Origen:");
		lblPasDeOrigen.setBounds(10, 220, 135, 14);
		panel.add(lblPasDeOrigen);

		cbxPaisOrigen = new JComboBox();
		cbxPaisOrigen.setBounds(10, 240, 154, 23);
		panel.add(cbxPaisOrigen);

		JLabel lblPasDeResidencia = new JLabel("Pa\u00EDs de Residencia: ");
		lblPasDeResidencia.setBounds(200, 220, 135, 14);
		panel.add(lblPasDeResidencia);

		cbxPaisResidencia = new JComboBox();
		cbxPaisResidencia.setBounds(200, 240, 154, 23);
		panel.add(cbxPaisResidencia);

		dateChooser = new JDateChooser(new Date());
		dateChooser.setBounds(10, 190, 154, 23);
		panel.add(dateChooser);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Formaci\u00F3n",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 307, 364, 70);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		rdbtnGraduado = new JRadioButton("Graduado");
		rdbtnGraduado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadPanel(true, false, false);
			}
		});
		rdbtnGraduado.setBounds(9, 23, 109, 23);
		panel_1.add(rdbtnGraduado);

		rdbtnTecnico = new JRadioButton("T\u00E9cnico");
		rdbtnTecnico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadPanel(false, true, false);
			}
		});
		rdbtnTecnico.setBounds(127, 23, 109, 23);
		panel_1.add(rdbtnTecnico);

		rdbtnObrero = new JRadioButton("Obrero");
		rdbtnObrero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadPanel(false, false, true);
			}
		});
		rdbtnObrero.setBounds(245, 23, 109, 23);
		panel_1.add(rdbtnObrero);

		pnlGraduado = new JPanel();
		pnlGraduado.setBorder(new TitledBorder(null, "Graduado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlGraduado.setBounds(10, 388, 364, 70);
		contentPanel.add(pnlGraduado);
		pnlGraduado.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u00C1rea de Estudio:");
		lblNewLabel.setBounds(10, 28, 120, 14);
		pnlGraduado.add(lblNewLabel);

		JComboBox cbxAreaEstudio = new JComboBox();
		cbxAreaEstudio.setBounds(124, 24, 230, 23);
		pnlGraduado.add(cbxAreaEstudio);

		pnlTecnico = new JPanel();
		pnlTecnico.setLayout(null);
		pnlTecnico.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "T\u00E9cnico",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlTecnico.setBounds(10, 388, 364, 70);
		contentPanel.add(pnlTecnico);

		JLabel lblTtulo = new JLabel("T\u00EDtulo:");
		lblTtulo.setBounds(10, 28, 75, 14);
		pnlTecnico.add(lblTtulo);

		JComboBox cbxTitulo = new JComboBox();
		cbxTitulo.setBounds(124, 24, 230, 23);
		pnlTecnico.add(cbxTitulo);

		pnlObrero = new JPanel();
		pnlObrero.setLayout(null);
		pnlObrero.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Obrero", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlObrero.setBounds(10, 388, 364, 70);
		contentPanel.add(pnlObrero);

		JLabel lblHabilidad = new JLabel("Habilidad:");
		lblHabilidad.setBounds(10, 28, 75, 14);
		pnlObrero.add(lblHabilidad);

		JComboBox cbxHabilidad = new JComboBox();
		cbxHabilidad.setBounds(124, 24, 230, 23);
		pnlObrero.add(cbxHabilidad);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSiguiente = new JButton("Siguiente");
				btnSiguiente.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (dateChooser.getDate() == null) {
							JOptionPane.showMessageDialog(null, "La fecha de nacimiento no es v�lida");
						}
					}
				});
				buttonPane.add(btnSiguiente);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

		loadCountries();
		loadPanel(true, false, false);
	}

	private void loadCountries() {
		String[] locales = Locale.getISOCountries();

		cbxPaisOrigen.addItem("<Seleccione>");
		cbxPaisResidencia.addItem("<Seleccione>");

		for (String countryCode : locales) {
			Locale obj = new Locale("", countryCode);

			cbxPaisOrigen.addItem(obj.getDisplayCountry());
			cbxPaisResidencia.addItem(obj.getDisplayCountry());
		}
	}

	private void loadPanel(boolean graduado, boolean tecnico, boolean obrero) {
		rdbtnGraduado.setSelected(graduado);
		rdbtnTecnico.setSelected(tecnico);
		rdbtnObrero.setSelected(obrero);

		pnlGraduado.setVisible(graduado);
		pnlTecnico.setVisible(tecnico);
		pnlObrero.setVisible(obrero);
	}
}