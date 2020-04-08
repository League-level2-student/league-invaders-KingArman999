import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	Rocketship ship;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random rand = new Random();
	public int score = 0;
	ObjectManager(Rocketship ship) {
		this.ship = ship;
	}

	void addProjectile(Projectile projectile) {
		projectiles.add(new Projectile(ship.x + 20, ship.y, 10, 10));
	}

	void addAlien() {
		aliens.add(new Alien(rand.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
	}

	void update() {
		for (Alien alien : aliens) {
			if (alien.y > LeagueInvaders.HEIGHT) {
				alien.isActive = false;
			}
			alien.update();
		}
		for (Projectile projectile : projectiles) {
			if (projectile.y <= 0) {
				projectile.isActive = false;
			}
			projectile.update();
		}
		ship.update();
		checkCollision();
		purgeObjects();
	}

	void draw(Graphics g) {
		ship.draw(g);
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
	}

	void checkCollision() {
		for (Alien alien : aliens) {
			if (ship.collisionBox.intersects(alien.collisionBox)) {
				ship.isActive = false;
				break;
			}
			for (Projectile projectile : projectiles) {
				if (projectile.collisionBox.intersects(alien.collisionBox)) {
					projectile.isActive = false;
					alien.isActive = false;
					score+=1;
				}
			}
		}
	}

	void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			if (aliens.get(i).isActive == false) {
				aliens.remove(i);
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			if (projectiles.get(i).isActive == false) {
				projectiles.remove(i);
			}
		}
	}
	public int getScore() {
		return this.score;
	}
	public void setScore(int score1) {
		this.score = score1;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}
}
