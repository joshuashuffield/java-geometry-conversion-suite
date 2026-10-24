package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class CylinderAppWindow {

	private JFrame CylinderSA;
	private JTextField RadiusInput;
	private JTextField HeightInput;
	private JTextField FormulaDisplay;
	private JTextField AreaDisplay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CylinderAppWindow window = new CylinderAppWindow();
					window.CylinderSA.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CylinderAppWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		CylinderSA = new JFrame();
		CylinderSA.setIconImage(Toolkit.getDefaultToolkit().getImage(CylinderAppWindow.class.getResource("/project/cylinderCalcIcon.png")));
		CylinderSA.setTitle("Surface Area Calculator For Cylinder");
		CylinderSA.setBounds(100, 100, 920, 720);
		CylinderSA.getContentPane().setLayout(null);
		
		JLabel CylinderSALabel = new JLabel("Surface Area Calculator For Cylinder");
		CylinderSALabel.setForeground(new Color(0, 128, 0));
		CylinderSALabel.setHorizontalAlignment(SwingConstants.CENTER);
		CylinderSALabel.setBackground(new Color(255, 255, 255));
		CylinderSALabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		CylinderSALabel.setBounds(64, 22, 776, 58);
		CylinderSA.getContentPane().add(CylinderSALabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 90, 904, 40);
		CylinderSA.getContentPane().add(separator);
		
		JLabel RadiusInputLabel = new JLabel("Enter Radius (r)");
		RadiusInputLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		RadiusInputLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		RadiusInputLabel.setBounds(10, 181, 220, 40);
		CylinderSA.getContentPane().add(RadiusInputLabel);
		
		JLabel HeightInputLabel = new JLabel("Enter Height (h)");
		HeightInputLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		HeightInputLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		HeightInputLabel.setBounds(22, 247, 208, 40);
		CylinderSA.getContentPane().add(HeightInputLabel);
		
		RadiusInput = new JTextField();
		RadiusInput.setFont(new Font("Tahoma", Font.PLAIN, 24));
		RadiusInput.setBounds(269, 175, 150, 53);
		CylinderSA.getContentPane().add(RadiusInput);
		RadiusInput.setColumns(10);
		
		HeightInput = new JTextField();
		HeightInput.setFont(new Font("Tahoma", Font.PLAIN, 24));
		HeightInput.setColumns(10);
		HeightInput.setBounds(269, 241, 150, 53);
		CylinderSA.getContentPane().add(HeightInput);
		
		JLabel FormulaCalculationLabel = new JLabel("Formula Calculation");
		FormulaCalculationLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		FormulaCalculationLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		FormulaCalculationLabel.setBounds(0, 445, 258, 53);
		CylinderSA.getContentPane().add(FormulaCalculationLabel);
		
		JLabel lblArea = new JLabel("Area");
		lblArea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblArea.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblArea.setBounds(0, 526, 258, 53);
		CylinderSA.getContentPane().add(lblArea);
		
		FormulaDisplay = new JTextField();
		FormulaDisplay.setFont(new Font("Tahoma", Font.PLAIN, 24));
		FormulaDisplay.setEditable(false);
		FormulaDisplay.setBounds(288, 443, 581, 58);
		CylinderSA.getContentPane().add(FormulaDisplay);
		FormulaDisplay.setColumns(10);
		
		AreaDisplay = new JTextField();
		AreaDisplay.setFont(new Font("Tahoma", Font.PLAIN, 24));
		AreaDisplay.setEditable(false);
		AreaDisplay.setColumns(10);
		AreaDisplay.setBounds(288, 523, 581, 58);
		CylinderSA.getContentPane().add(AreaDisplay);
		
		JButton CalculateButton = new JButton("Calculate");
		CalculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double r = Double.parseDouble(RadiusInput.getText().trim());
					double h = Double.parseDouble(HeightInput.getText().trim());
					
					if (r < 0) {
						JOptionPane.showMessageDialog(CylinderSA, "Please enter a positive length.");
						return;
					}
					if (h < 0) {
						JOptionPane.showMessageDialog(CylinderSA, "Please enter a positive width.");
						return;
					}
						
					double area = (2*Math.PI*r*(r+h));

					FormulaDisplay.setText("2 * π * " + r + " * (" + h + " + " + r + ")");
					AreaDisplay.setText(String.format("%.4f", area));
					
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(CylinderSA, "Please enter a valid number.");
				}
			}
		});
		CalculateButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		CalculateButton.setBounds(670, 175, 139, 58);
		CylinderSA.getContentPane().add(CalculateButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RadiusInput.setText("");
				HeightInput.setText("");
				FormulaDisplay.setText("");
				AreaDisplay.setText("");
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnReset.setBounds(670, 247, 139, 58);
		CylinderSA.getContentPane().add(btnReset);
		
	}
}
