package HackatonInicioUsuario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class InsertarUsuario extends JFrame {

	private JPanel contentPane;
	private String base = "usuarios";
	private final String URL = "jdbc:mysql://localhost:3306/" + base + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private final String USERNAME = "root";
	private final String PASSWORD = "Metnet1973!";
	public Connection con = null;

	public Connection getConnection() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);

		} catch (ClassNotFoundException | SQLException e) {

			System.err.println(e);

		}

		return con;

	}

	public void limpiarCajas() {

		txtUsuario.setText(null);
		txtNombre.setText(null);
		txtPassword.setText(null);
		txtConfirmarPassword.setText(null);
		txtCorreo.setText(null);
	}

	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	private JPasswordField txtConfirmarPassword;
	private JTextField txtNombre;
	private JTextField txtCorreo;
	public UsuPoo usu = new UsuPoo();
	private JTextField txtPais;
	private JTextField txtEstado;
	private JTextField txtCondado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertarUsuario frame = new InsertarUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InsertarUsuario() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 545, 531);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("USER");
		lblNewLabel.setFont(new Font("Futura Bk BT", Font.BOLD, 11));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(42, 338, 101, 14);
		contentPane.add(lblNewLabel);

		txtUsuario = new JTextField();
		txtUsuario.setBackground(Color.WHITE);
		txtUsuario.setBounds(153, 338, 290, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setFont(new Font("Futura Bk BT", Font.BOLD, 11));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(42, 114, 114, 14);
		contentPane.add(lblNewLabel_1);

		txtPassword = new JPasswordField();
		txtPassword.setBackground(Color.WHITE);
		txtPassword.setBounds(153, 114, 290, 20);
		contentPane.add(txtPassword);

		JLabel lblNewLabel_2 = new JLabel("<html>CONFIRM PASSWORD</html>");
		lblNewLabel_2.setFont(new Font("Futura Bk BT", Font.BOLD, 11));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(42, 163, 89, 28);
		contentPane.add(lblNewLabel_2);

		txtConfirmarPassword = new JPasswordField();
		txtConfirmarPassword.setBackground(Color.WHITE);
		txtConfirmarPassword.setBounds(153, 163, 290, 20);
		contentPane.add(txtConfirmarPassword);

		JLabel lblNewLabel_3 = new JLabel("NAME");
		lblNewLabel_3.setFont(new Font("Futura Bk BT", Font.BOLD, 11));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(42, 65, 89, 14);
		contentPane.add(lblNewLabel_3);

		txtNombre = new JTextField();
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setBounds(153, 65, 290, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("E-MAIL ADRESS");
		lblNewLabel_4.setFont(new Font("Futura Bk BT", Font.BOLD, 11));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(42, 392, 101, 14);
		contentPane.add(lblNewLabel_4);

		txtCorreo = new JTextField();
		txtCorreo.setBackground(Color.WHITE);
		txtCorreo.setBounds(153, 392, 290, 20);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);

		JButton btnRegistrar = new JButton("REGISTER");
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setBackground(Color.GRAY);
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String pass = new String(txtPassword.getPassword());
				String passCon = new String(txtConfirmarPassword.getPassword());

				if (txtUsuario.getText().equals("") || pass.equals("") || passCon.equals("")
						|| txtNombre.getText().equals("") || txtCorreo.getText().equals("")
						|| txtPais.getText().equals("") || txtEstado.getText().equals("")
						|| txtCondado.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "There are spaces that need to be filled");
				} else {
					if (pass.equals(passCon)) {

						if (usuarioExistente(txtUsuario.getText()) == 0) {

							if (esEmail(txtCorreo.getText())) {

								String nuevoPass = hash.sha1(pass);

								usu.setUsuario(txtUsuario.getText());
								usu.setPassword(nuevoPass);
								usu.setNombre(txtNombre.getText());
								usu.setCorreo(txtCorreo.getText());
								usu.setId_tipo(1);
								usu.setPais(txtPais.getText());
								usu.setCiudad(txtCondado.getText());
								usu.setEstado(txtEstado.getText());

								int confirmar = JOptionPane.showConfirmDialog(null,
										"The Password ans the usar cnt be changed, are you sure you want the password to be <<"
												+ pass + ">> and the user <<" + txtUsuario.getText()
												+ ">> ? \n	We recomend that you take a picture of this pane or anotate the information",
										"Porfavor seleccione", JOptionPane.YES_NO_OPTION);

								if (confirmar == 0) {

									if (registrar(usu)) {
										JOptionPane.showMessageDialog(null, "Information Saved");
										limpiarCajas();

									} else {
										JOptionPane.showMessageDialog(null, "Error at saving the user");
										limpiarCajas();
									}

								} else {
									JOptionPane.showMessageDialog(null, "Perfect, change the password for something safer");
								}
							} else {
								JOptionPane.showMessageDialog(null, "The E-Mail doesnt have E-mail format");
							}
						} else {
							JOptionPane.showMessageDialog(null, "The user already exists");
						}

					} else {
						JOptionPane.showMessageDialog(null, "Passwords arent the same");
					}

				}

			}
		});
		btnRegistrar.setBounds(227, 445, 101, 23);
		contentPane.add(btnRegistrar);

		JButton btnAtras = new JButton("BACK");
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setBackground(Color.GRAY);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnAtras.setBounds(417, 11, 89, 23);
		contentPane.add(btnAtras);

		JLabel lblNewLabel_1_1 = new JLabel("COUNTRY");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(42, 228, 114, 14);
		contentPane.add(lblNewLabel_1_1);

		txtPais = new JTextField();
		txtPais.setBounds(114, 226, 131, 20);
		contentPane.add(txtPais);
		txtPais.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("<html>STATE</html>");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNewLabel_2_1.setBounds(258, 225, 89, 20);
		contentPane.add(lblNewLabel_2_1);

		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(312, 226, 131, 20);
		contentPane.add(txtEstado);

		JLabel lblNewLabel_2_1_1 = new JLabel("<html>CITY/COUNTY</html>");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNewLabel_2_1_1.setBounds(123, 283, 89, 20);
		contentPane.add(lblNewLabel_2_1_1);

		txtCondado = new JTextField();
		txtCondado.setColumns(10);
		txtCondado.setBounds(217, 284, 196, 20);
		contentPane.add(txtCondado);
	}

	public boolean registrar(UsuPoo usu) {

		PreparedStatement ps = null;
		Connection con = getConnection();

		try {
			String sql = "INSERT INTO `usuarios`.`usuarios` (`usuario`, `password`, `nombre`, `correo`, `id_tipo`) VALUES (?,?,?,?,?); ";
			ps = con.prepareStatement(sql);

			ps.setString(1, usu.getUsuario());
			ps.setString(2, usu.getPassword());
			ps.setString(3, usu.getNombre());
			ps.setString(4, usu.getCorreo());
			ps.setInt(5, usu.getId_tipo());

			ps.execute();
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		} finally {

			try {
				con.close();
			} catch (SQLException e) {
				System.err.println(e);
			}

		}

	}

	public int usuarioExistente(String usuario) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection();

		try {
			String sql = "SELECT count(`id_tipo`) FROM `usuarios`.`usuarios` WHERE (`usuario` = ?); ";
			ps = con.prepareStatement(sql);

			ps.setString(1, usuario);
			rs = ps.executeQuery();

			if (rs.next()) {

				return rs.getInt(1);
			}

			return 1;

		} catch (SQLException e) {
			System.err.println(e);
			return 1;
		} finally {

			try {
				con.close();
			} catch (SQLException e) {
				System.err.println(e);
			}

		}

	}

	public boolean esEmail(String correo) {

		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		Matcher matcher = pattern.matcher(correo);

		return matcher.find();

	}
}
