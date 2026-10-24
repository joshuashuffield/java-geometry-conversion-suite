package project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Toolkit;

public class CustomAppWindow {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomAppWindow window = new CustomAppWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CustomAppWindow() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(CustomAppWindow.class.getResource("/project/flappybirdIcon.png")));
		frame.setTitle("Flappy Bird");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		FlappyBirdPanel panel = new FlappyBirdPanel();
		frame.setContentPane(panel);
		frame.addKeyListener(panel.getGameKeyListener());
	}

	class FlappyBirdPanel extends JPanel implements ActionListener {

		Timer timer = new Timer(20, this);

		int birdX = 150;
		int birdY = 250;
		int birdSize = 30;
		int velocity = 0;
		int score = 0;

		boolean start = false;
		boolean dead = false;

		ArrayList<Rectangle> top = new ArrayList<Rectangle>();
		ArrayList<Rectangle> bottom = new ArrayList<Rectangle>();

		Random r = new Random();

		public FlappyBirdPanel() {
			setBackground(new Color(135, 206, 235));

			for (int i = 0; i < 3; i++) {
				int x = 700 + i * 300;
				int h = 50 + r.nextInt(250);

				top.add(new Rectangle(x, 0, 80, h));
				bottom.add(new Rectangle(x, h + 170, 80, 520 - (h + 170)));
			}

			timer.start();
		}

		public KeyAdapter getGameKeyListener() {
			return new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_SPACE) {

						if (dead) {
							birdY = 250;
							velocity = 0;
							score = 0;
							dead = false;
							start = false;

							top.clear();
							bottom.clear();

							for (int i = 0; i < 3; i++) {
								int x = 700 + i * 300;
								int h = 50 + r.nextInt(250);

								top.add(new Rectangle(x, 0, 80, h));
								bottom.add(new Rectangle(x, h + 170, 80, 520 - (h + 170)));
							}
						}
						else {
							start = true;
							velocity = -10;
						}
					}
				}
			};
		}

		public void actionPerformed(ActionEvent e) {

			if (start && !dead) {
				velocity = velocity + 1;
				birdY = birdY + velocity;

				Rectangle bird = new Rectangle(birdX, birdY, birdSize, birdSize);

				for (int i = 0; i < top.size(); i++) {
					top.get(i).x = top.get(i).x - 5;
					bottom.get(i).x = bottom.get(i).x - 5;

					if (top.get(i).intersects(bird) || bottom.get(i).intersects(bird)) {
						dead = true;
					}
				
				
				if (top.get(i).x + 80 == birdX) {
					score++;
				}
				}

				if (top.get(0).x < -80) {
					top.remove(0);
					bottom.remove(0);

					int x = top.get(top.size() - 1).x + 300;
					int h = 50 + r.nextInt(250);

					top.add(new Rectangle(x, 0, 80, h));
					bottom.add(new Rectangle(x, h + 170, 80, 520 - (h + 170)));
				}

				if (birdY < 0 || birdY + birdSize > 520) {
					dead = true;
				}
			}

			repaint();
		}

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.setColor(new Color(135, 206, 235));
			g.fillRect(0, 0, 800, 600);

			g.setColor(new Color(222, 184, 135));
			g.fillRect(0, 520, 800, 80);

			g.setColor(Color.green);
			for (int i = 0; i < top.size(); i++) {
				g.fillRect(top.get(i).x, top.get(i).y, 80, top.get(i).height);
				g.fillRect(bottom.get(i).x, bottom.get(i).y, 80, bottom.get(i).height);
			}

			g.setColor(Color.yellow);
			g.fillOval(birdX, birdY, birdSize, birdSize);

			g.setColor(Color.black);
			
			g.drawString("Score: " + score, 50, 50);

			if (!start) {
				g.drawString("press space", 330, 250);
			}

			if (dead) {
				g.drawString("game over", 340, 250);
				g.drawString("space to restart", 330, 280);
			}
		}
	}
}