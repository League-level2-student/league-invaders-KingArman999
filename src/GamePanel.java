import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Rocketship rocket = new Rocketship(250, 700, 50, 50);
	Timer frameDraw;
	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	Font enterFont = new Font("Arial", Font.PLAIN, 24);
	Font endFont = new Font("Arial", Font.PLAIN, 48);
	Font scoreFont = new Font("Arial", Font.PLAIN, 20);
	ObjectManager object = new ObjectManager(rocket);
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	Timer alienSpawn;
	
	GamePanel() {
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
		if (needImage) {
			loadImage("space.png");
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}
	}

	void updateMenuState() {

	}

	void updateGameState() {
		object.update();
		if (rocket.isActive == false) {
			currentState = END;
		}
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("LEAGUE INVADERS", 20, 120);
		g.setFont(enterFont);
		g.setColor(Color.WHITE);
		g.drawString("Press ENTER to start", 130, 500);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 800);
		g.setColor(Color.WHITE);
		object.draw(g);
		g.setFont(scoreFont);
		g.drawString("Score: " + object.getScore(), 50, 100);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(endFont);
		g.setColor(Color.WHITE);
		g.drawString("GAME OVER", 90, 120);
		g.setFont(enterFont);
		g.setColor(Color.WHITE);
		g.drawString("Press ENTER to go to the MENU", 60, 500);
	}

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}

	void startGame() {
		alienSpawn = new Timer(1000, object);
		alienSpawn.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END) {
			updateEndState();
		}
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == MENU) {
				currentState = GAME;
				rocket = new Rocketship(250, 700, 50, 50);
				object = new ObjectManager(rocket);
				startGame();
				return;
			}
			if (currentState == GAME) {
				currentState = END;
				alienSpawn.stop();
				return;
			}
			if (currentState == END) {
				currentState = MENU;
				return;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (rocket.y > 0) {
				rocket.up();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (rocket.x < LeagueInvaders.WIDTH - rocket.width - 19) {
				rocket.right();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (rocket.x > 0) {
				rocket.left();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (rocket.y < LeagueInvaders.HEIGHT - rocket.height - 30) {
				rocket.down();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (currentState == GAME) {
				object.addProjectile(rocket.getProjectile());
			}
		}
		if (currentState == END) {
			rocket.isActive= false;
			Rocketship rocket = new Rocketship(250, 700, 50, 50);
			ObjectManager object = new ObjectManager(rocket);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}
