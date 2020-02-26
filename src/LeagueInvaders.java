import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	GamePanel game;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;

	LeagueInvaders() {
		frame = new JFrame();
		frame.setVisible(true);
		game = new GamePanel();
		frame.addKeyListener(game);
	}

	void setup() {
		frame.add(game);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
