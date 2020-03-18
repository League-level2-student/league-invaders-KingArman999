import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;



public class GamePanel extends JPanel implements ActionListener, KeyListener  {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState= MENU;
	Rocketship rocket = new Rocketship(250,700,50,50);
	Timer frameDraw;
	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	Font enterFont = new Font("Arial", Font.PLAIN, 24);
	Font spaceFont = new Font("Arial", Font.PLAIN, 24);
	GamePanel(){
		frameDraw = new Timer(1000/60,this);
	    frameDraw.start();
	}
	@Override
	public void paintComponent(Graphics g) {
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}

void updateMenuState() {  
	
}

void updateGameState() {
	
}

void updateEndState()  {  
	
}
void drawMenuState(Graphics g) {  
	g.setColor(Color.BLUE);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	g.setFont(titleFont);
	g.setColor(Color.WHITE);
	g.drawString("LEAGUE INVADERS", 20,120);
	g.setFont(enterFont);
	g.setColor(Color.WHITE);
	g.drawString("Press ENTER to start", 130,500);
	g.setFont(spaceFont);
	g.setColor(Color.WHITE);
	g.drawString("Press SPACE for instructions", 95,650);
}
void drawGameState(Graphics g) {  
	g.setColor(Color.BLACK);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	rocket.draw(g);
}
void drawEndState(Graphics g)  {  
	g.setColor(Color.RED);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(currentState == MENU){
	    updateMenuState();
	}else if(currentState == GAME){
	    updateGameState();
	}else if(currentState == END){
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
	if (e.getKeyCode()== KeyEvent.VK_ENTER){
		if (currentState == END) {
			currentState = MENU;
		}else {
			currentState++;
		}
	}
	if (e.getKeyCode()== KeyEvent.VK_UP) {
		if (rocket.y>0) {
			rocket.up();	
			}
	}
	if (e.getKeyCode()== KeyEvent.VK_RIGHT) {
		if (rocket.x<LeagueInvaders.WIDTH-rocket.width) {
			rocket.right();	
			}
	}
	if (e.getKeyCode()== KeyEvent.VK_LEFT) {
		if (rocket.x>0+5) {
			rocket.left();	
			}
	}
	if (e.getKeyCode()== KeyEvent.VK_DOWN) {
		if (rocket.y<LeagueInvaders.HEIGHT-rocket.height-25) {
		rocket.down();	
		}
		
	}
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
}

