package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Toolkit;

public class CircleAppWindow {

	private JFrame CircleSA;
	private JTextField RadiusInput;
	private JTextField FormulaCalculationDisplay;
	private JTextField AreaDisplay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CircleAppWindow window = new CircleAppWindow();
					window.CircleSA.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CircleAppWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		CircleSA = new JFrame();
		CircleSA.setIconImage(Toolkit.getDefaultToolkit().getImage(CircleAppWindow.class.getResource("/project/circleCalcIcon.png")));
		CircleSA.setTitle("Surface Area Calculator For Circle");
		CircleSA.setBounds(100, 100, 920, 720);
		CircleSA.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		CircleSA.getContentPane().setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 148, 904, 2);
		CircleSA.getContentPane().add(separator);

		JButton CalculateButton = new JButton("Calculate");
		CalculateButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		CalculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double r = Double.parseDouble(RadiusInput.getText().trim());

					if (r < 0) {
						JOptionPane.showMessageDialog(CircleSA, "Please enter a positive radius.");
						return;
					}

					double area = Math.PI * r * r;

					FormulaCalculationDisplay.setText("π × " + r + "²");
					AreaDisplay.setText(String.format("%.4f", area));

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(CircleSA, "Please enter a valid number.");
				}
			}
		});
		CalculateButton.setBounds(661, 209, 200, 74);
		CircleSA.getContentPane().add(CalculateButton);

		JButton ResetButton = new JButton("Reset");
		ResetButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		ResetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RadiusInput.setText("");
				FormulaCalculationDisplay.setText("");
				AreaDisplay.setText("");
			}
		});
		ResetButton.setBounds(661, 298, 200, 74);
		CircleSA.getContentPane().add(ResetButton);

		JLabel RadiusInputLable = new JLabel("Enter Radius");
		RadiusInputLable.setFont(new Font("Tahoma", Font.PLAIN, 24));
		RadiusInputLable.setBounds(22, 213, 163, 46);
		CircleSA.getContentPane().add(RadiusInputLable);

		RadiusInput = new JTextField();
		RadiusInput.setFont(new Font("Tahoma", Font.PLAIN, 24));
		RadiusInput.setBounds(239, 205, 234, 74);
		CircleSA.getContentPane().add(RadiusInput);
		RadiusInput.setColumns(10);

		JLabel FormulaCalculationLable = new JLabel("Formula Calculation");
		FormulaCalculationLable.setFont(new Font("Tahoma", Font.BOLD, 24));
		FormulaCalculationLable.setBounds(22, 417, 246, 46);
		CircleSA.getContentPane().add(FormulaCalculationLable);

		JLabel AreaLable = new JLabel("Area");
		AreaLable.setHorizontalAlignment(SwingConstants.CENTER);
		AreaLable.setFont(new Font("Tahoma", Font.BOLD, 24));
		AreaLable.setBounds(205, 496, 63, 46);
		CircleSA.getContentPane().add(AreaLable);

		FormulaCalculationDisplay = new JTextField();
		FormulaCalculationDisplay.setEditable(false);
		FormulaCalculationDisplay.setFont(new Font("Tahoma", Font.PLAIN, 22));
		FormulaCalculationDisplay.setBounds(298, 413, 572, 58);
		CircleSA.getContentPane().add(FormulaCalculationDisplay);
		FormulaCalculationDisplay.setColumns(10);

		AreaDisplay = new JTextField();
		AreaDisplay.setEditable(false);
		AreaDisplay.setFont(new Font("Tahoma", Font.PLAIN, 22));
		AreaDisplay.setBounds(298, 492, 572, 58);
		CircleSA.getContentPane().add(AreaDisplay);
		AreaDisplay.setColumns(10);
		
		JLabel CircleCalulatorTitle = new JLabel("Surface Area Calculator For Circle");
		CircleCalulatorTitle.setForeground(new Color(0, 128, 0));
		CircleCalulatorTitle.setFont(new Font("Tahoma", Font.BOLD, 34));
		CircleCalulatorTitle.setBounds(161, 46, 582, 46);
		CircleSA.getContentPane().add(CircleCalulatorTitle);
	}
}