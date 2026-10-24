package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class TimeAppWindow {

	private JFrame TimeConv;
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
					TimeAppWindow window = new TimeAppWindow();
					window.TimeConv.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TimeAppWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		TimeConv = new JFrame();
		TimeConv.setIconImage(Toolkit.getDefaultToolkit().getImage(TimeAppWindow.class.getResource("/project/CalcIcon.png")));
		TimeConv.setTitle("Time Conversions");
		TimeConv.setBounds(100, 100, 1312, 743);
		TimeConv.getContentPane().setLayout(null);
		
		JLabel TimeConversions = new JLabel("Time Conversions");
		TimeConversions.setForeground(new Color(0, 128, 0));
		TimeConversions.setFont(new Font("Tahoma", Font.BOLD, 54));
		TimeConversions.setHorizontalAlignment(SwingConstants.CENTER);
		TimeConversions.setBounds(360, 21, 575, 90);
		TimeConv.getContentPane().add(TimeConversions);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 122, 1296, 29);
		TimeConv.getContentPane().add(separator);
		
		JButton ConvertButton = new JButton("Convert");
		ConvertButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		ConvertButton.setBounds(544, 574, 207, 83);
		TimeConv.getContentPane().add(ConvertButton);
		
		UnitsInputSelect = new JComboBox<String>();
		UnitsInputSelect.setFont(new Font("Tahoma", Font.PLAIN, 34));
		UnitsInputSelect.setModel(new DefaultComboBoxModel(new String[] {"Select here", "Seconds", "Minutes", "Hours"}));
		UnitsInputSelect.setBounds(116, 432, 423, 90);
		TimeConv.getContentPane().add(UnitsInputSelect);
		
		UnitsInput = new JTextField();
		UnitsInput.setFont(new Font("Tahoma", Font.PLAIN, 34));
		UnitsInput.setBounds(116, 320, 423, 90);
		TimeConv.getContentPane().add(UnitsInput);
		UnitsInput.setColumns(10);
		
		JLabel UnitsInputLabel = new JLabel("...");
		UnitsInputLabel.setHorizontalAlignment(SwingConstants.CENTER);
		UnitsInputLabel.setFont(new Font("Tahoma", Font.PLAIN, 34));
		UnitsInputLabel.setBounds(136, 210, 383, 83);
		TimeConv.getContentPane().add(UnitsInputLabel);
		
		UnitsOutputSelect = new JComboBox<String>();
		UnitsOutputSelect.setModel(new DefaultComboBoxModel(new String[] {"Select here", "Seconds", "Minutes", "Hours"}));
		UnitsOutputSelect.setFont(new Font("Tahoma", Font.PLAIN, 34));
		UnitsOutputSelect.setBounds(749, 432, 423, 90);
		TimeConv.getContentPane().add(UnitsOutputSelect);
		
		UnitsOutput = new JTextField();
		UnitsOutput.setEditable(false);
		UnitsOutput.setFont(new Font("Tahoma", Font.PLAIN, 34));
		UnitsOutput.setColumns(10);
		UnitsOutput.setBounds(749, 320, 423, 90);
		TimeConv.getContentPane().add(UnitsOutput);
		
		JLabel UnitsOutputLabel = new JLabel("...");
		UnitsOutputLabel.setHorizontalAlignment(SwingConstants.CENTER);
		UnitsOutputLabel.setFont(new Font("Tahoma", Font.PLAIN, 34));
		UnitsOutputLabel.setBounds(769, 210, 383, 83);
		TimeConv.getContentPane().add(UnitsOutputLabel);
		
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

		if (sourceUnit.equals("Select Here") && destinationUnit.equals("Select here")) {
			JOptionPane.showMessageDialog(TimeConv, "Please select source and destination units.");
			return;
		}

		if (sourceUnit.equals("Select Here")) {
			JOptionPane.showMessageDialog(TimeConv, "Please select the source unit.");
			return;
		}

		if (destinationUnit.equals("Select Here")) {
			JOptionPane.showMessageDialog(TimeConv, "Please select the destination unit.");
			return;
		}

		if (inputText.isEmpty()) {
			JOptionPane.showMessageDialog(TimeConv, "Please enter a value to convert.");
			return;
		}

		double inputValue;

		try {
			inputValue = Double.parseDouble(inputText);
			
			if (inputValue < 0) {
				JOptionPane.showMessageDialog(TimeConv, "Please enter a positive Time.");
				return;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(TimeConv, "Please enter a valid number.");
			return;
		}

		double result = 0.0;

		if (sourceUnit.equals(destinationUnit)) {
			result = inputValue;
		}
		else if (sourceUnit.equals("Seconds") && destinationUnit.equals("Minutes")) {
			result = inputValue * (1f/60f);
		}
		else if (sourceUnit.equals("Minutes") && destinationUnit.equals("Seconds")) {
			result = inputValue * 60;
		}
		else if (sourceUnit.equals("Minutes") && destinationUnit.equals("Hours")) {
			result = inputValue * (1f/60f);
		}
		else if (sourceUnit.equals("Hours") && destinationUnit.equals("Minutes")) {
			result = inputValue * 60;
		}
		else if (sourceUnit.equals("Seconds") && destinationUnit.equals("Hours")) {
			result = inputValue * (1f/3600f);
		}
		else if (sourceUnit.equals("Hours") && destinationUnit.equals("Seconds")) {
			result = inputValue * 3600;
		}

		DecimalFormat df = new DecimalFormat("0.####");
		UnitsOutput.setText(df.format(result));
		
	}

}
