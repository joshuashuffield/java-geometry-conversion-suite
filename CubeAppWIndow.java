package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class CubeAppWIndow {

	private JFrame CubeSA;
	private JTextField SideInput;
	private JTextField AreaDisplay;
	private JTextField FormulaDisplay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CubeAppWIndow window = new CubeAppWIndow();
					window.CubeSA.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CubeAppWIndow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		CubeSA = new JFrame();
		CubeSA.setIconImage(Toolkit.getDefaultToolkit().getImage(CubeAppWIndow.class.getResource("/project/cubeCalcIcon.png")));
		CubeSA.setTitle("Surface Area Calculator For Cube");
		CubeSA.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		CubeSA.setBounds(100, 100, 920, 720);
		CubeSA.getContentPane().setLayout(null);
		
		JLabel CubeCalculatorTitle = new JLabel("Surface Area Calculator For Cube");
		CubeCalculatorTitle.setForeground(new Color(0, 128, 0));
		CubeCalculatorTitle.setFont(new Font("Tahoma", Font.BOLD, 34));
		CubeCalculatorTitle.setBounds(167, 27, 570, 52);
		CubeSA.getContentPane().add(CubeCalculatorTitle);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 90, 904, 20);
		CubeSA.getContentPane().add(separator);
		
		JLabel SideLable = new JLabel("Enter Side");
		SideLable.setHorizontalAlignment(SwingConstants.RIGHT);
		SideLable.setFont(new Font("Tahoma", Font.PLAIN, 24));
		SideLable.setBounds(57, 203, 146, 52);
		CubeSA.getContentPane().add(SideLable);
		
		SideInput = new JTextField();
		SideInput.setFont(new Font("Tahoma", Font.PLAIN, 24));
		SideInput.setBounds(213, 192, 245, 75);
		CubeSA.getContentPane().add(SideInput);
		SideInput.setColumns(10);
		
		JButton CalculateButton = new JButton("Calculate");
		CalculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double x = Double.parseDouble(SideInput.getText().trim());

					if (x < 0) {
						JOptionPane.showMessageDialog(CubeSA, "Please enter a positive radius.");
						return;
					}

					double area = 6 *(x * x );

					FormulaDisplay.setText("6 * ( "+ x + "\u00b2" + " )");
					AreaDisplay.setText(String.format("%.4f", area));

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(CubeSA, "Please enter a valid number.");
				}
			}
		});
		CalculateButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		CalculateButton.setBounds(648, 201, 129, 58);
		CubeSA.getContentPane().add(CalculateButton);
		
		JButton ResetButton = new JButton("Reset");
		ResetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SideInput.setText("");
				FormulaDisplay.setText("");
				AreaDisplay.setText("");
			}
		});
		ResetButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		ResetButton.setBounds(648, 270, 129, 58);
		CubeSA.getContentPane().add(ResetButton);
		
		JLabel FormulaCalculationLabel = new JLabel("Formula Calculation");
		FormulaCalculationLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		FormulaCalculationLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		FormulaCalculationLabel.setBounds(-68, 463, 326, 52);
		CubeSA.getContentPane().add(FormulaCalculationLabel);
		
		JLabel AreaLabel = new JLabel("Area");
		AreaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		AreaLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		AreaLabel.setBounds(40, 545, 218, 52);
		CubeSA.getContentPane().add(AreaLabel);
		
		AreaDisplay = new JTextField();
		AreaDisplay.setFont(new Font("Tahoma", Font.PLAIN, 24));
		AreaDisplay.setEditable(false);
		AreaDisplay.setColumns(10);
		AreaDisplay.setBounds(279, 544, 591, 54);
		CubeSA.getContentPane().add(AreaDisplay);
		
		FormulaDisplay = new JTextField();
		FormulaDisplay.setFont(new Font("Tahoma", Font.PLAIN, 24));
		FormulaDisplay.setEditable(false);
		FormulaDisplay.setColumns(10);
		FormulaDisplay.setBounds(279, 463, 591, 54);
		CubeSA.getContentPane().add(FormulaDisplay);
		
	}
}
