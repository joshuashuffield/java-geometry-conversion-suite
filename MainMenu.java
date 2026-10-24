package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JInternalFrame;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class MainMenu {

	private JFrame frmShapesAndConversions;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frmShapesAndConversions.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmShapesAndConversions = new JFrame();
		frmShapesAndConversions.setIconImage(Toolkit.getDefaultToolkit().getImage(MainMenu.class.getResource("/project/CalcIcon.png")));
		frmShapesAndConversions.setTitle("Shapes and Conversions Calculator");
		frmShapesAndConversions.setBounds(100, 100, 632, 548);
		frmShapesAndConversions.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmShapesAndConversions.getContentPane().setLayout(null);
		
		JButton btnCircle = new JButton("Circle");
		btnCircle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CircleAppWindow.main(null);
			}
		});
		btnCircle.setBounds(85, 113, 124, 40);
		frmShapesAndConversions.getContentPane().add(btnCircle);
		
		JButton btnTriangle = new JButton("Triangle");
		btnTriangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TriangleAppWindow.main(null);
			}
		});
		btnTriangle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTriangle.setBounds(85, 164, 124, 40);
		frmShapesAndConversions.getContentPane().add(btnTriangle);
		
		JButton btnSquare = new JButton("Square");
		btnSquare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SquareAppWindow.main(null);
			}
		});
		btnSquare.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSquare.setBounds(85, 215, 124, 40);
		frmShapesAndConversions.getContentPane().add(btnSquare);
		
		JButton btnCube = new JButton("Cube");
		btnCube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CubeAppWIndow.main(null);
			}
		});
		btnCube.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCube.setBounds(408, 113, 124, 40);
		frmShapesAndConversions.getContentPane().add(btnCube);
		
		JButton btnRectangularPrism = new JButton("Rectangular Prism");
		btnRectangularPrism.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RectangularPrismAppWindow.main(null);
			}
		});
		btnRectangularPrism.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRectangularPrism.setBounds(408, 166, 124, 40);
		frmShapesAndConversions.getContentPane().add(btnRectangularPrism);
		
		JButton btnCylinder = new JButton("Cylinder");
		btnCylinder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CylinderAppWindow.main(null);
			}
		});
		btnCylinder.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCylinder.setBounds(408, 215, 124, 40);
		frmShapesAndConversions.getContentPane().add(btnCylinder);
		
		JLabel TwoDTitle = new JLabel("2D Shapes");
		TwoDTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		TwoDTitle.setBackground(new Color(240, 240, 240));
		TwoDTitle.setBounds(101, 69, 98, 40);
		frmShapesAndConversions.getContentPane().add(TwoDTitle);
		
		JLabel ThreeDTitle = new JLabel("3D Shapes");
		ThreeDTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		ThreeDTitle.setBackground(UIManager.getColor("Button.background"));
		ThreeDTitle.setBounds(422, 69, 98, 40);
		frmShapesAndConversions.getContentPane().add(ThreeDTitle);
		
		JLabel CalcTitle = new JLabel("2D And 3D Shapes Calculator");
		CalcTitle.setForeground(SystemColor.textHighlight);
		CalcTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		CalcTitle.setBounds(155, 11, 306, 40);
		frmShapesAndConversions.getContentPane().add(CalcTitle);
		
		JLabel ConvCalcTitle = new JLabel("Conversions Calculator");
		ConvCalcTitle.setForeground(SystemColor.textHighlight);
		ConvCalcTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		ConvCalcTitle.setBounds(190, 282, 236, 40);
		frmShapesAndConversions.getContentPane().add(ConvCalcTitle);
		
		JButton btnVolume = new JButton("Volume");
		btnVolume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VolumeAppWIndow.main(null);
			}
		});
		btnVolume.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVolume.setBounds(85, 389, 124, 40);
		frmShapesAndConversions.getContentPane().add(btnVolume);
		
		JButton btnCurrency = new JButton("Currency");
		btnCurrency.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CurrencyAppWindow.main(null);
			}
		});
		btnCurrency.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCurrency.setBounds(408, 389, 124, 40);
		frmShapesAndConversions.getContentPane().add(btnCurrency);
		
		JButton btnTime = new JButton("Time");
		btnTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimeAppWindow.main(null);
			}
		});
		btnTime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTime.setBounds(408, 440, 124, 40);
		frmShapesAndConversions.getContentPane().add(btnTime);
		
		JButton btnTemperature = new JButton("Temperature");
		btnTemperature.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TemperatureAppWIndow.main(null);
			}
		});
		btnTemperature.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTemperature.setBounds(85, 440, 124, 40);
		frmShapesAndConversions.getContentPane().add(btnTemperature);
		
		JButton btnSquare_5 = new JButton("Bird?");
		btnSquare_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomAppWindow.main(null);
			}
		});
		btnSquare_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSquare_5.setBounds(246, 415, 124, 40);
		frmShapesAndConversions.getContentPane().add(btnSquare_5);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(-44, 53, 688, 15);
		frmShapesAndConversions.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(-44, 281, 688, 15);
		frmShapesAndConversions.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(-55, 333, 688, 15);
		frmShapesAndConversions.getContentPane().add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(292, 53, 0, 229);
		frmShapesAndConversions.getContentPane().add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(307, 53, 1, 229);
		frmShapesAndConversions.getContentPane().add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setBounds(306, 53, 3, 229);
		frmShapesAndConversions.getContentPane().add(separator_5);
	}
}
