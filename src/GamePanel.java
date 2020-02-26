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
	System.out.println("action");
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
		System.out.println("UP");
	}
	if (e.getKeyCode()== KeyEvent.VK_RIGHT) {
		System.out.println("RIGHT");
	}
	if (e.getKeyCode()== KeyEvent.VK_LEFT) {
		System.out.println("LEFT");
	}
	if (e.getKeyCode()== KeyEvent.VK_DOWN) {
		System.out.println("Down");
	}
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
}

