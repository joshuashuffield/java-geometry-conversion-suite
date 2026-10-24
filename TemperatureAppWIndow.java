package project;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Toolkit;

public class TemperatureAppWIndow {

	private JFrame TempConv;
	private JTextField UnitsInput;
	private JTextField UnitsOutput;
	private JComboBox<String> UnitsInputSelect;
	private JComboBox<String> UnitsOutputSelect;
	private JLabel UnitsInputLabel;
	private JLabel UnitsOutputLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TemperatureAppWIndow window = new TemperatureAppWIndow();
					window.TempConv.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TemperatureAppWIndow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		TempConv = new JFrame();
		TempConv.setIconImage(Toolkit.getDefaultToolkit().getImage(TemperatureAppWIndow.class.getResource("/project/CalcIcon.png")));
		TempConv.setTitle("Temperature Conversions");
		TempConv.setBounds(100, 100, 1312, 743);
		TempConv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		TempConv.getContentPane().setLayout(null);

		JLabel TemperatureConversions = new JLabel("Temperature Conversions");
		TemperatureConversions.setForeground(new Color(0, 128, 0));
		TemperatureConversions.setHorizontalAlignment(SwingConstants.CENTER);
		TemperatureConversions.setFont(new Font("Tahoma", Font.BOLD, 54));
		TemperatureConversions.setBounds(223, 67, 860, 71);
		TempConv.getContentPane().add(TemperatureConversions);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 181, 1296, 2);
		TempConv.getContentPane().add(separator);

		UnitsInputLabel = new JLabel("...");
		UnitsInputLabel.setHorizontalAlignment(SwingConstants.CENTER);
		UnitsInputLabel.setFont(new Font("Tahoma", Font.PLAIN, 38));
		UnitsInputLabel.setBounds(137, 235, 336, 52);
		TempConv.getContentPane().add(UnitsInputLabel);

		UnitsOutputLabel = new JLabel("...");
		UnitsOutputLabel.setHorizontalAlignment(SwingConstants.CENTER);
		UnitsOutputLabel.setFont(new Font("Tahoma", Font.PLAIN, 38));
		UnitsOutputLabel.setBounds(758, 235, 387, 52);
		TempConv.getContentPane().add(UnitsOutputLabel);

		UnitsInput = new JTextField();
		UnitsInput.setFont(new Font("Tahoma", Font.PLAIN, 36));
		UnitsInput.setBounds(91, 314, 429, 95);
		TempConv.getContentPane().add(UnitsInput);
		UnitsInput.setColumns(10);

		UnitsOutput = new JTextField();
		UnitsOutput.setFont(new Font("Tahoma", Font.PLAIN, 36));
		UnitsOutput.setEditable(false);
		UnitsOutput.setBounds(726, 314, 450, 95);
		TempConv.getContentPane().add(UnitsOutput);
		UnitsOutput.setColumns(10);

		UnitsInputSelect = new JComboBox<String>();
		UnitsInputSelect.setFont(new Font("Tahoma", Font.PLAIN, 28));
		UnitsInputSelect.setModel(new DefaultComboBoxModel(new String[] {"Select here", "Celsius", "Fahrenheit", "Kelvin"}));
		UnitsInputSelect.setBounds(91, 439, 429, 95);
		TempConv.getContentPane().add(UnitsInputSelect);

		UnitsOutputSelect = new JComboBox<String>();
		UnitsOutputSelect.setFont(new Font("Tahoma", Font.PLAIN, 28));
		UnitsOutputSelect.setModel(new DefaultComboBoxModel<String>(new String[] {"Select here", "Celsius", "Fahrenheit", "Kelvin"}));
		UnitsOutputSelect.setBounds(726, 439, 450, 95);
		TempConv.getContentPane().add(UnitsOutputSelect);

		JButton ConvertButton = new JButton("Convert");
		ConvertButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		ConvertButton.setBounds(519, 596, 207, 83);
		TempConv.getContentPane().add(ConvertButton);

		UnitsInputSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UnitsInputLabel.setText(UnitsInputSelect.getSelectedItem().toString());
			}
		});

		UnitsOutputSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UnitsOutputLabel.setText(UnitsOutputSelect.getSelectedItem().toString());
			}
		});

		ConvertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				convertTemperature();
			}
		});
	}

	private void convertTemperature() {
		String sourceUnit = UnitsInputSelect.getSelectedItem().toString();
		String destinationUnit = UnitsOutputSelect.getSelectedItem().toString();
		String inputText = UnitsInput.getText().trim();

		if (sourceUnit.equals("Select here") && destinationUnit.equals("Select here")) {
			JOptionPane.showMessageDialog(TempConv, "Please select source and destination units.");
			return;
		}

		if (sourceUnit.equals("Select here")) {
			JOptionPane.showMessageDialog(TempConv, "Please select the source unit.");
			return;
		}

		if (destinationUnit.equals("Select here")) {
			JOptionPane.showMessageDialog(TempConv, "Please select the destination unit.");
			return;
		}

		if (inputText.isEmpty()) {
			JOptionPane.showMessageDialog(TempConv, "Please enter a value to convert.");
			return;
		}

		double inputValue;

		try {
			inputValue = Double.parseDouble(inputText);
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(TempConv, "Please enter a valid number.");
			return;
		}

		double result = 0.0;

		if (sourceUnit.equals(destinationUnit)) {
			result = inputValue;
		}
		else if (sourceUnit.equals("Celsius") && destinationUnit.equals("Fahrenheit")) {
			result = (inputValue * 9.0 / 5.0) + 32.0;
		}
		else if (sourceUnit.equals("Fahrenheit") && destinationUnit.equals("Celsius")) {
			result = (inputValue - 32.0) * 5.0 / 9.0;
		}
		else if (sourceUnit.equals("Celsius") && destinationUnit.equals("Kelvin")) {
			result = inputValue + 273.15;
		}
		else if (sourceUnit.equals("Kelvin") && destinationUnit.equals("Celsius")) {
			result = inputValue - 273.15;
		}
		else if (sourceUnit.equals("Fahrenheit") && destinationUnit.equals("Kelvin")) {
			result = (inputValue - 32.0) * 5.0 / 9.0 + 273.15;
		}
		else if (sourceUnit.equals("Kelvin") && destinationUnit.equals("Fahrenheit")) {
			result = (inputValue - 273.15) * 9.0 / 5.0 + 32.0;
		}

		DecimalFormat df = new DecimalFormat("0.####");
		UnitsOutput.setText(df.format(result));
	}
}