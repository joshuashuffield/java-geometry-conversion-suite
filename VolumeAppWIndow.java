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

public class VolumeAppWIndow {

	private JFrame VolConv;
	private JTextField UnitInput;
	private JTextField UnitsOutput;
	private JComboBox<String> UnitsInputSelect;
	private JComboBox<String> UnitsOutputSelect;
	private JLabel UnitInputLabel;
	private JLabel UnitsOutputLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VolumeAppWIndow window = new VolumeAppWIndow();
					window.VolConv.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VolumeAppWIndow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		VolConv = new JFrame();
		VolConv.setIconImage(Toolkit.getDefaultToolkit().getImage(VolumeAppWIndow.class.getResource("/project/CalcIcon.png")));
		VolConv.setTitle("Volume Conversions");
		VolConv.setBounds(100, 100, 1312, 743);
		VolConv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		VolConv.getContentPane().setLayout(null);

		JLabel VolumesConversionsTitle = new JLabel("Volume Conversions");
		VolumesConversionsTitle.setForeground(new Color(0, 128, 0));
		VolumesConversionsTitle.setBackground(Color.WHITE);
		VolumesConversionsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		VolumesConversionsTitle.setFont(new Font("Tahoma", Font.BOLD, 54));
		VolumesConversionsTitle.setBounds(282, 67, 731, 71);
		VolConv.getContentPane().add(VolumesConversionsTitle);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 181, 1296, 2);
		VolConv.getContentPane().add(separator);

		UnitInputLabel = new JLabel("...");
		UnitInputLabel.setHorizontalAlignment(SwingConstants.CENTER);
		UnitInputLabel.setFont(new Font("Tahoma", Font.PLAIN, 38));
		UnitInputLabel.setBounds(194, 235, 261, 52);
		VolConv.getContentPane().add(UnitInputLabel);

		UnitsOutputLabel = new JLabel("...");
		UnitsOutputLabel.setHorizontalAlignment(SwingConstants.CENTER);
		UnitsOutputLabel.setFont(new Font("Tahoma", Font.PLAIN, 38));
		UnitsOutputLabel.setBounds(832, 235, 287, 52);
		VolConv.getContentPane().add(UnitsOutputLabel);

		UnitInput = new JTextField();
		UnitInput.setFont(new Font("Tahoma", Font.PLAIN, 36));
		UnitInput.setBounds(110, 314, 429, 95);
		VolConv.getContentPane().add(UnitInput);
		UnitInput.setColumns(10);

		UnitsOutput = new JTextField();
		UnitsOutput.setFont(new Font("Tahoma", Font.PLAIN, 36));
		UnitsOutput.setEditable(false);
		UnitsOutput.setBounds(750, 314, 450, 95);
		VolConv.getContentPane().add(UnitsOutput);
		UnitsOutput.setColumns(10);

		UnitsInputSelect = new JComboBox<String>();
		UnitsInputSelect.setFont(new Font("Tahoma", Font.PLAIN, 28));
		UnitsInputSelect.setModel(new DefaultComboBoxModel(new String[] {"Select here", "Gallons", "Liters", "Pints"}));
		UnitsInputSelect.setBounds(110, 439, 429, 95);
		VolConv.getContentPane().add(UnitsInputSelect);

		UnitsOutputSelect = new JComboBox<String>();
		UnitsOutputSelect.setFont(new Font("Tahoma", Font.PLAIN, 28));
		UnitsOutputSelect.setModel(new DefaultComboBoxModel<String>(new String[] {"Select here", "Gallons", "Liters", "Pints"}));
		UnitsOutputSelect.setBounds(750, 439, 450, 95);
		VolConv.getContentPane().add(UnitsOutputSelect);

		JButton ConvertButton = new JButton("Convert");
		ConvertButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		ConvertButton.setBounds(544, 596, 207, 83);
		VolConv.getContentPane().add(ConvertButton);

		UnitsInputSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UnitInputLabel.setText(UnitsInputSelect.getSelectedItem().toString());
			}
		});

		UnitsOutputSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UnitsOutputLabel.setText(UnitsOutputSelect.getSelectedItem().toString());
			}
		});

		ConvertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				convertVolume();
			}
		});
	}

	private void convertVolume() {
		String sourceUnit = UnitsInputSelect.getSelectedItem().toString();
		String destinationUnit = UnitsOutputSelect.getSelectedItem().toString();
		String inputText = UnitInput.getText().trim();

		if (sourceUnit.equals("Select here") && destinationUnit.equals("Select here")) {
			JOptionPane.showMessageDialog(VolConv, "Please select source and destination units.");
			return;
		}

		if (sourceUnit.equals("Select here")) {
			JOptionPane.showMessageDialog(VolConv, "Please select the source unit.");
			return;
		}

		if (destinationUnit.equals("Select here")) {
			JOptionPane.showMessageDialog(VolConv, "Please select the destination unit.");
			return;
		}

		if (inputText.isEmpty()) {
			JOptionPane.showMessageDialog(VolConv, "Please enter a value to convert.");
			return;
		}

		double inputValue;

		try {
			inputValue = Double.parseDouble(inputText);
			if (inputValue < 0) {
				JOptionPane.showMessageDialog(VolConv, "Please enter a positive Volume.");
				return;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(VolConv, "Please enter a valid number.");
			return;
		}

		double result = 0.0;

		if (sourceUnit.equals(destinationUnit)) {
			result = inputValue;
		}
		else if (sourceUnit.equals("Gallons") && destinationUnit.equals("Liters")) {
			result = inputValue * 3.785;
		}
		else if (sourceUnit.equals("Liters") && destinationUnit.equals("Gallons")) {
			result = inputValue * 0.264;
		}
		else if (sourceUnit.equals("Gallons") && destinationUnit.equals("Pints")) {
			result = inputValue * 8.0;
		}
		else if (sourceUnit.equals("Pints") && destinationUnit.equals("Gallons")) {
			result = inputValue * 0.125;
		}
		else if (sourceUnit.equals("Liters") && destinationUnit.equals("Pints")) {
			result = inputValue * 2.113;
		}
		else if (sourceUnit.equals("Pints") && destinationUnit.equals("Liters")) {
			result = inputValue * 0.473;
		}

		DecimalFormat df = new DecimalFormat("0.####");
		UnitsOutput.setText(df.format(result));
	}
}