package HACKATON;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FootPrint extends JFrame {

	private JPanel contentPane;
	private JTextField txtgastosAgua;
	private JTextField txtgastosGas;
	private JTextField txtgastosElectricidad;
	private JLabel lblCalculate;
	private JLabel lblWater;
	private JLabel lblElectricity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FootPrint frame = new FootPrint();
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
	public FootPrint() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 574);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtgastosAgua = new JTextField();
		txtgastosAgua.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 11));
		txtgastosAgua.setBounds(226, 77, 147, 19);
		contentPane.add(txtgastosAgua);
		txtgastosAgua.setColumns(10);

		txtgastosGas = new JTextField();
		txtgastosGas.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 11));
		txtgastosGas.setBounds(226, 119, 142, 19);
		contentPane.add(txtgastosGas);
		txtgastosGas.setColumns(10);

		txtgastosElectricidad = new JTextField();
		txtgastosElectricidad.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 11));
		txtgastosElectricidad.setBounds(226, 167, 142, 19);
		contentPane.add(txtgastosElectricidad);
		txtgastosElectricidad.setColumns(10);

		JSpinner txtfamily = new JSpinner();
		txtfamily.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 11));
		txtfamily.setBounds(226, 39, 40, 27);
		contentPane.add(txtfamily);

		JLabel lblHousehold = new JLabel("Household residents ");
		lblHousehold.setForeground(Color.WHITE);
		lblHousehold.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblHousehold.setBounds(35, 39, 204, 24);
		contentPane.add(lblHousehold);

		JLabel lblBillCost = new JLabel("Gas bill cost");
		lblBillCost.setForeground(Color.WHITE);
		lblBillCost.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblBillCost.setBounds(35, 115, 164, 27);
		contentPane.add(lblBillCost);

		JButton btncalculate = new JButton("Calculate");
		btncalculate.setBackground(Color.GRAY);
	
		btncalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int cont  = 0;
				
				if(txtgastosAgua.getText().equals("") || txtgastosElectricidad.getText().equals("") || txtgastosGas.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Some data is missing");
					
				} else {
					if (Integer.parseInt(txtgastosAgua.getText()) <= 25) {
						
						cont = cont + 0;
						
					} else if (Integer.parseInt(txtgastosAgua.getText())>25 && Integer.parseInt(txtgastosAgua.getText())<=100) {
						
						cont = cont + 1;
					} else if (Integer.parseInt(txtgastosAgua.getText()) > 100) {
						
						cont= cont + 2;
					} 
					
					if (Integer.parseInt(txtgastosElectricidad.getText()) <= 25) {

						cont = cont + 0;
					} else if (Integer.parseInt(txtgastosElectricidad.getText())>25 && Integer.parseInt(txtgastosElectricidad.getText())<=100) {
						
						cont = cont + 1;
					} else if (Integer.parseInt(txtgastosElectricidad.getText()) > 100) {
						
						cont = cont + 2;
					} 
					
					if (Integer.parseInt(txtgastosGas.getText()) <= 25) {

						cont = cont + 0;
					} else if (Integer.parseInt(txtgastosGas.getText())>25 && Integer.parseInt(txtgastosGas.getText())<=100) {
						
						cont = cont + 1;
					} else if (Integer.parseInt(txtgastosGas.getText()) > 100) {
						
						cont = cont + 2;
					} 
					
					
					if(cont<=1) {
						lblElectricity.setIcon(setIconPresionado("/IMG/BUENO.png"));
						lblElectricity.setBackground(Color.WHITE);
						lblElectricity.setForeground(Color.PINK);
					}else if(cont>1 && cont<=4) {
						lblElectricity.setIcon(setIconPresionado("/IMG/MEDIO.png"));
						lblElectricity.setBackground(Color.WHITE);
						lblElectricity.setForeground(Color.PINK);
					}else {
						lblElectricity.setIcon(setIconPresionado("/IMG/MALO.png"));
						lblElectricity.setBackground(Color.WHITE);
						lblElectricity.setForeground(Color.PINK);
					}
				}
				
				

			}
		});
		btncalculate.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		btncalculate.setBounds(57, 215, 126, 27);
		contentPane.add(btncalculate);

		lblCalculate = new JLabel("Water bill cost");
		lblCalculate.setForeground(Color.WHITE);
		lblCalculate.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblCalculate.setBounds(35, 73, 204, 27);
		contentPane.add(lblCalculate);

		lblWater = new JLabel("Electricity consumption");
		lblWater.setForeground(Color.WHITE);
		lblWater.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblWater.setBounds(35, 163, 229, 27);
		contentPane.add(lblWater);

		lblElectricity = new JLabel("");
		lblElectricity.setBounds(10, 253, 652, 271);
		contentPane.add(lblElectricity);
		int width = lblElectricity.getWidth();
		int height = lblElectricity.getHeight();
		System.out.println();
		lblElectricity.setIcon(setIconPresionado("/IMG/SOLO.png"));
		lblElectricity.setBackground(Color.WHITE);
		lblElectricity.setForeground(Color.PINK);

		
	}

	public Icon setIconPresionado(String url) {

		ImageIcon icon = new ImageIcon(getClass().getResource(url));
		ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(400 , 200, Image.SCALE_DEFAULT));

		return icono;

	}

}
