package project;

import java.awt.EventQueue;
import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class TriangleAppWindow {

	private JFrame frame;
	private JTextField EnterBase;
	private JTextField EnterHeight;
	private JTextField FormulaCalculationDisplay;
	private JTextField AreaDisplay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TriangleAppWindow window = new TriangleAppWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TriangleAppWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(TriangleAppWindow.class.getResource("/project/triangleCalcIcon.png")));
		frame.setTitle("Surface Area Calculator For Triangle");
		frame.setBounds(100, 100, 920, 720);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel TriangleSATitle = new JLabel("Surface Area Calculator For Triangle");
		TriangleSATitle.setForeground(new Color(0, 128, 0));
		TriangleSATitle.setHorizontalAlignment(SwingConstants.CENTER);
		TriangleSATitle.setFont(new Font("Tahoma", Font.BOLD, 44));
		TriangleSATitle.setBounds(10, 57, 884, 67);
		frame.getContentPane().add(TriangleSATitle);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 148, 904, 2);
		frame.getContentPane().add(separator);

		JLabel EnterBaseLabel = new JLabel("Enter Base");
		EnterBaseLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		EnterBaseLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		EnterBaseLabel.setBounds(52, 218, 163, 46);
		frame.getContentPane().add(EnterBaseLabel);

		EnterBase = new JTextField();
		EnterBase.setFont(new Font("Tahoma", Font.PLAIN, 24));
		EnterBase.setBounds(239, 205, 234, 74);
		frame.getContentPane().add(EnterBase);
		EnterBase.setColumns(10);

		JLabel EnterHeightLabel = new JLabel("Enter Height");
		EnterHeightLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		EnterHeightLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		EnterHeightLabel.setBounds(52, 311, 163, 46);
		frame.getContentPane().add(EnterHeightLabel);

		EnterHeight = new JTextField();
		EnterHeight.setFont(new Font("Tahoma", Font.PLAIN, 24));
		EnterHeight.setColumns(10);
		EnterHeight.setBounds(239, 298, 234, 74);
		frame.getContentPane().add(EnterHeight);

		JButton CalculateButton = new JButton("Calculate");
		CalculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculateTriangleArea();
			}
		});
		CalculateButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		CalculateButton.setBounds(661, 205, 200, 74);
		frame.getContentPane().add(CalculateButton);

		JButton ResetButton = new JButton("Reset");
		ResetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnterBase.setText("");
				EnterHeight.setText("");
				FormulaCalculationDisplay.setText("");
				AreaDisplay.setText("");
			}
		});
		ResetButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		ResetButton.setBounds(661, 298, 200, 74);
		frame.getContentPane().add(ResetButton);

		JLabel FormulaCalculationLabel = new JLabel("Formula Calculation");
		FormulaCalculationLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		FormulaCalculationLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		FormulaCalculationLabel.setBounds(0, 480, 254, 46);
		frame.getContentPane().add(FormulaCalculationLabel);

		FormulaCalculationDisplay = new JTextField();
		FormulaCalculationDisplay.setEditable(false);
		FormulaCalculationDisplay.setFont(new Font("Tahoma", Font.PLAIN, 22));
		FormulaCalculationDisplay.setBounds(283, 474, 587, 58);
		frame.getContentPane().add(FormulaCalculationDisplay);
		FormulaCalculationDisplay.setColumns(10);

		JLabel AreaLabel = new JLabel("Area");
		AreaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		AreaLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		AreaLabel.setBounds(123, 559, 131, 46);
		frame.getContentPane().add(AreaLabel);

		AreaDisplay = new JTextField();
		AreaDisplay.setEditable(false);
		AreaDisplay.setFont(new Font("Tahoma", Font.PLAIN, 22));
		AreaDisplay.setColumns(10);
		AreaDisplay.setBounds(283, 553, 587, 58);
		frame.getContentPane().add(AreaDisplay);
	}

	private void calculateTriangleArea() {
		String baseText = EnterBase.getText().trim();
		String heightText = EnterHeight.getText().trim();

		if (baseText.isEmpty() || heightText.isEmpty()) {
			JOptionPane.showMessageDialog(frame, "Please enter both base and height.");
			return;
		}

		double base;
		double height;

		try {
			base = Double.parseDouble(baseText);
			height = Double.parseDouble(heightText);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(frame, "Please enter valid numbers.");
			return;
		}

		if (base < 0 || height < 0) {
			JOptionPane.showMessageDialog(frame, "Please enter positive values.");
			return;
		}

		double area = 0.5 * base * height;
		DecimalFormat df = new DecimalFormat("0.####");

		FormulaCalculationDisplay.setText("1/2 × " + df.format(base) + " × " + df.format(height));
		AreaDisplay.setText(df.format(area));
	}
}