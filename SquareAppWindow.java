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

public class SquareAppWindow {

	private JFrame frame;
	private JTextField EnterSide;
	private JTextField ForulaCalculationDisplay;
	private JTextField AreaDisplay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SquareAppWindow window = new SquareAppWindow();
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
	public SquareAppWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(SquareAppWindow.class.getResource("/project/squareCalcIcon.png")));
		frame.setTitle("Surface Area Calculator For Square");
		frame.setBounds(100, 100, 920, 720);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel SquareSATitle = new JLabel("Surface Area Calculator For Square");
		SquareSATitle.setForeground(new Color(0, 128, 0));
		SquareSATitle.setHorizontalAlignment(SwingConstants.CENTER);
		SquareSATitle.setFont(new Font("Tahoma", Font.BOLD, 44));
		SquareSATitle.setBounds(10, 57, 884, 67);
		frame.getContentPane().add(SquareSATitle);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 148, 904, 2);
		frame.getContentPane().add(separator);

		JLabel EnterSideLabel = new JLabel("Enter Side");
		EnterSideLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		EnterSideLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		EnterSideLabel.setBounds(66, 218, 163, 46);
		frame.getContentPane().add(EnterSideLabel);

		EnterSide = new JTextField();
		EnterSide.setFont(new Font("Tahoma", Font.PLAIN, 24));
		EnterSide.setBounds(239, 205, 234, 74);
		frame.getContentPane().add(EnterSide);
		EnterSide.setColumns(10);

		JButton CalculateButton = new JButton("Calculate");
		CalculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculateSquareArea();
			}
		});
		CalculateButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		CalculateButton.setBounds(661, 205, 200, 74);
		frame.getContentPane().add(CalculateButton);

		JButton ResetButton = new JButton("Reset");
		ResetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnterSide.setText("");
				ForulaCalculationDisplay.setText("");
				AreaDisplay.setText("");
			}
		});
		ResetButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		ResetButton.setBounds(661, 298, 200, 74);
		frame.getContentPane().add(ResetButton);

		JLabel FormulaCalculationLabel = new JLabel("Formula Calculation");
		FormulaCalculationLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		FormulaCalculationLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		FormulaCalculationLabel.setBounds(-16, 460, 280, 46);
		frame.getContentPane().add(FormulaCalculationLabel);

		ForulaCalculationDisplay = new JTextField();
		ForulaCalculationDisplay.setEditable(false);
		ForulaCalculationDisplay.setFont(new Font("Tahoma", Font.PLAIN, 22));
		ForulaCalculationDisplay.setBounds(289, 456, 582, 58);
		frame.getContentPane().add(ForulaCalculationDisplay);
		ForulaCalculationDisplay.setColumns(10);

		JLabel AreaLabel = new JLabel("Area");
		AreaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		AreaLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		AreaLabel.setBounds(133, 539, 131, 46);
		frame.getContentPane().add(AreaLabel);

		AreaDisplay = new JTextField();
		AreaDisplay.setEditable(false);
		AreaDisplay.setFont(new Font("Tahoma", Font.PLAIN, 22));
		AreaDisplay.setColumns(10);
		AreaDisplay.setBounds(289, 535, 582, 58);
		frame.getContentPane().add(AreaDisplay);
	}

	private void calculateSquareArea() {
		String sideText = EnterSide.getText().trim();

		if (sideText.isEmpty()) {
			JOptionPane.showMessageDialog(frame, "Please enter the side length.");
			return;
		}

		double side;

		try {
			side = Double.parseDouble(sideText);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
			return;
		}

		if (side < 0) {
			JOptionPane.showMessageDialog(frame, "Please enter a positive value.");
			return;
		}

		double area = side * side;
		DecimalFormat df = new DecimalFormat("0.####");

		ForulaCalculationDisplay.setText(df.format(side) + "²");
		AreaDisplay.setText(df.format(area));
	}
}