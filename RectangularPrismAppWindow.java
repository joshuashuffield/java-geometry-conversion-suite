package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class RectangularPrismAppWindow {

	private JFrame RectangularPrismSA;
	private JTextField LengthInput;
	private JTextField WidthInput;
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
					RectangularPrismAppWindow window = new RectangularPrismAppWindow();
					window.RectangularPrismSA.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RectangularPrismAppWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		RectangularPrismSA = new JFrame();
		RectangularPrismSA.setIconImage(Toolkit.getDefaultToolkit().getImage(RectangularPrismAppWindow.class.getResource("/project/rectangularPrismCalcIcon.png")));
		RectangularPrismSA.setTitle("Surface Area Calculator For Rectangular Prism");
		RectangularPrismSA.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		RectangularPrismSA.setBounds(100, 100, 920, 720);
		RectangularPrismSA.getContentPane().setLayout(null);
		
		JLabel RectangularPrismSATitle = new JLabel("Surface Area Calculator For Rectangular Prism");
		RectangularPrismSATitle.setForeground(new Color(0, 128, 0));
		RectangularPrismSATitle.setHorizontalAlignment(SwingConstants.CENTER);
		RectangularPrismSATitle.setFont(new Font("Tahoma", Font.BOLD, 34));
		RectangularPrismSATitle.setBounds(45, 29, 813, 50);
		RectangularPrismSA.getContentPane().add(RectangularPrismSATitle);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 90, 904, 21);
		RectangularPrismSA.getContentPane().add(separator);
		
		JLabel EnterLengthLabel = new JLabel("Enter Length");
		EnterLengthLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		EnterLengthLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		EnterLengthLabel.setBounds(29, 178, 197, 40);
		RectangularPrismSA.getContentPane().add(EnterLengthLabel);
		
		JLabel EnterWidthLabel = new JLabel("Enter Width");
		EnterWidthLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		EnterWidthLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		EnterWidthLabel.setBounds(29, 254, 197, 40);
		RectangularPrismSA.getContentPane().add(EnterWidthLabel);
		
		JLabel EnterHeightLabel = new JLabel("Enter Height");
		EnterHeightLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		EnterHeightLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		EnterHeightLabel.setBounds(29, 330, 197, 40);
		RectangularPrismSA.getContentPane().add(EnterHeightLabel);
		
		LengthInput = new JTextField();
		LengthInput.setFont(new Font("Tahoma", Font.PLAIN, 24));
		LengthInput.setBounds(265, 179, 184, 50);
		RectangularPrismSA.getContentPane().add(LengthInput);
		LengthInput.setColumns(10);
		
		WidthInput = new JTextField();
		WidthInput.setFont(new Font("Tahoma", Font.PLAIN, 24));
		WidthInput.setColumns(10);
		WidthInput.setBounds(265, 254, 184, 50);
		RectangularPrismSA.getContentPane().add(WidthInput);
		
		HeightInput = new JTextField();
		HeightInput.setFont(new Font("Tahoma", Font.PLAIN, 24));
		HeightInput.setColumns(10);
		HeightInput.setBounds(265, 330, 184, 50);
		RectangularPrismSA.getContentPane().add(HeightInput);
		
		JLabel FormulaCalculationLabel = new JLabel("Formula Calculation");
		FormulaCalculationLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		FormulaCalculationLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		FormulaCalculationLabel.setBounds(-19, 516, 278, 29);
		RectangularPrismSA.getContentPane().add(FormulaCalculationLabel);
		
		JLabel AreaDisplayLabel = new JLabel("Area");
		AreaDisplayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		AreaDisplayLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		AreaDisplayLabel.setBounds(-19, 586, 278, 29);
		RectangularPrismSA.getContentPane().add(AreaDisplayLabel);
		
		FormulaDisplay = new JTextField();
		FormulaDisplay.setEditable(false);
		FormulaDisplay.setFont(new Font("Tahoma", Font.PLAIN, 24));
		FormulaDisplay.setColumns(10);
		FormulaDisplay.setBounds(284, 502, 585, 58);
		RectangularPrismSA.getContentPane().add(FormulaDisplay);
		
		AreaDisplay = new JTextField();
		AreaDisplay.setEditable(false);
		AreaDisplay.setFont(new Font("Tahoma", Font.PLAIN, 24));
		AreaDisplay.setColumns(10);
		AreaDisplay.setBounds(284, 572, 585, 58);
		RectangularPrismSA.getContentPane().add(AreaDisplay);
		
		JButton CalculateButton = new JButton("Calculate");
		CalculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double l = Double.parseDouble(LengthInput.getText().trim());
					double w = Double.parseDouble(WidthInput.getText().trim());
					double h = Double.parseDouble(HeightInput.getText().trim());

					if (l < 0) {
						JOptionPane.showMessageDialog(RectangularPrismSA, "Please enter a positive length.");
						return;
					}
					if (w < 0) {
						JOptionPane.showMessageDialog(RectangularPrismSA, "Please enter a positive width.");
						return;
					}
					if (h < 0) {
						JOptionPane.showMessageDialog(RectangularPrismSA, "Please enter a positive height.");
						return;
					}

					double area = 2*((l*h)+(h*w)+(l*w));

					FormulaDisplay.setText("2 * ((" + l + "*" + h + ") + (" + h + "*" + w + ") + (" + l + "*" + w + "))");
					AreaDisplay.setText(String.format("%.4f", area));

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(RectangularPrismSA, "Please enter a valid number.");
				}
			}
		});
		CalculateButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		CalculateButton.setBounds(678, 175, 134, 58);
		RectangularPrismSA.getContentPane().add(CalculateButton);
		
		JButton ResetButton = new JButton("Reset");
		ResetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LengthInput.setText("");
				WidthInput.setText("");
				HeightInput.setText("");
				FormulaDisplay.setText("");
				AreaDisplay.setText("");
			}
		});
		ResetButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		ResetButton.setBounds(678, 246, 134, 58);
		RectangularPrismSA.getContentPane().add(ResetButton);
		
	}

}
