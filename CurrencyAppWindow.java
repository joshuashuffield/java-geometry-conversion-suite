package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class CurrencyAppWindow {

	private JFrame CurrConv;
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
					CurrencyAppWindow window = new CurrencyAppWindow();
					window.CurrConv.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CurrencyAppWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		CurrConv = new JFrame();
		CurrConv.setIconImage(Toolkit.getDefaultToolkit().getImage(CurrencyAppWindow.class.getResource("/project/CalcIcon.png")));
		CurrConv.setTitle("Currency Conversion");
		CurrConv.setBounds(100, 100, 1312, 743);
		CurrConv.getContentPane().setLayout(null);
		
		JLabel CurrencyConversions = new JLabel("Currency Conversions");
		CurrencyConversions.setHorizontalAlignment(SwingConstants.CENTER);
		CurrencyConversions.setForeground(new Color(0, 128, 0));
		CurrencyConversions.setFont(new Font("Tahoma", Font.BOLD, 54));
		CurrencyConversions.setBounds(291, 11, 714, 70);
		CurrConv.getContentPane().add(CurrencyConversions);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 102, 1296, 80);
		CurrConv.getContentPane().add(separator);
		
		UnitsInputSelect = new JComboBox<String>();
		UnitsInputSelect.setFont(new Font("Tahoma", Font.PLAIN, 28));
		UnitsInputSelect.setModel(new DefaultComboBoxModel(new String[] {"Select here", "USD (US Dollars)", "CAD (Canadian Dollars)", "EUR (Euro)"}));
		UnitsInputSelect.setBounds(100, 427, 399, 100);
		CurrConv.getContentPane().add(UnitsInputSelect);
		
		UnitsOutputSelect = new JComboBox<String>();
		UnitsOutputSelect.setFont(new Font("Tahoma", Font.PLAIN, 28));
		UnitsOutputSelect.setModel(new DefaultComboBoxModel(new String[] {"Select here", "USD (US Dollars)", "CAD (Canadian Dollars)", "EUR (Euro)"}));
		UnitsOutputSelect.setBounds(786, 427, 399, 100);
		CurrConv.getContentPane().add(UnitsOutputSelect);
		
		JButton ConvertButton = new JButton("Convert");
		ConvertButton.setFont(new Font("Tahoma", Font.PLAIN, 28));
		ConvertButton.setBounds(544, 572, 207, 83);
		CurrConv.getContentPane().add(ConvertButton);
		
		UnitsInput = new JTextField();
		UnitsInput.setFont(new Font("Tahoma", Font.PLAIN, 36));
		UnitsInput.setBounds(100, 293, 399, 100);
		CurrConv.getContentPane().add(UnitsInput);
		UnitsInput.setColumns(10);
		
		UnitsOutput = new JTextField();
		UnitsOutput.setFont(new Font("Tahoma", Font.PLAIN, 36));
		UnitsOutput.setEditable(false);
		UnitsOutput.setColumns(10);
		UnitsOutput.setBounds(786, 293, 399, 100);
		CurrConv.getContentPane().add(UnitsOutput);
		
		JLabel UnitsInputLabel = new JLabel("...");
		UnitsInputLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		UnitsInputLabel.setHorizontalAlignment(SwingConstants.CENTER);
		UnitsInputLabel.setBounds(135, 206, 329, 76);
		CurrConv.getContentPane().add(UnitsInputLabel);
		
		JLabel UnitsOutputLabel = new JLabel("...");
		UnitsOutputLabel.setHorizontalAlignment(SwingConstants.CENTER);
		UnitsOutputLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		UnitsOutputLabel.setBounds(821, 206, 329, 76);
		CurrConv.getContentPane().add(UnitsOutputLabel);
		
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
				convertCurrency();
			}
		});
	}

	private void convertCurrency() {
		String sourceUnit = UnitsInputSelect.getSelectedItem().toString();
		String destinationUnit = UnitsOutputSelect.getSelectedItem().toString();
		String inputText = UnitsInput.getText().trim();

		if (sourceUnit.equals("Select Here") && destinationUnit.equals("Select here")) {
			JOptionPane.showMessageDialog(CurrConv, "Please select source and destination units.");
			return;
		}

		if (sourceUnit.equals("Select Here")) {
			JOptionPane.showMessageDialog(CurrConv, "Please select the source unit.");
			return;
		}

		if (destinationUnit.equals("Select Here")) {
			JOptionPane.showMessageDialog(CurrConv, "Please select the destination unit.");
			return;
		}

		if (inputText.isEmpty()) {
			JOptionPane.showMessageDialog(CurrConv, "Please enter a value to convert.");
			return;
		}

		double inputValue;

		try {
			inputValue = Double.parseDouble(inputText);
			if (inputValue < 0) {
				JOptionPane.showMessageDialog(CurrConv, "Please enter a positive Currency.");
				return;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(CurrConv, "Please enter a valid number.");
			return;
		}

		double result = 0.0;

		if (sourceUnit.equals(destinationUnit)) {
			result = inputValue;
		}
		else if (sourceUnit.equals("USD (US Dollars)") && destinationUnit.equals("CAD (Canadian Dollars)")) {
			result = inputValue * 1.25f;
		}
		else if (sourceUnit.equals("CAD (Canadian Dollars)") && destinationUnit.equals("USD (US Dollars)")) {
			result = inputValue * 0.80f;
		}
		else if (sourceUnit.equals("USD (US Dollars)") && destinationUnit.equals("EUR (Euro)")) {
			result = inputValue * 0.91f;
		}
		else if (sourceUnit.equals("EUR (Euro)") && destinationUnit.equals("USD (US Dollars)")) {
			result = inputValue * 1.10f;
		}
		else if (sourceUnit.equals("CAD (Canadian Dollars)") && destinationUnit.equals("EUR (Euro)")) {
			result = inputValue * 0.73f;
		}
		else if (sourceUnit.equals("EUR (Euro)") && destinationUnit.equals("CAD (Canadian Dollars)")) {
			result = inputValue * 1.37f;
		}

		DecimalFormat df = new DecimalFormat("0.####");
		UnitsOutput.setText(df.format(result));
		
	}
		
}

