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
ObjectManager(Rocketship ship){
this.ship = ship;
}
void addProjectile(Projectile projectile) {
	projectiles.add(new Projectile(ship.x+20, ship.y, 10,10));
}
void addAlien() {
	aliens.add(new Alien(rand.nextInt(LeagueInvaders.WIDTH),0,50,50));
}
void update(){
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
	checkCollision();
	purgeObjects();
}
void draw(Graphics g){
	ship.draw(g);
	for (int i = 0; i < aliens.size(); i++) {
		aliens.get(i).draw(g);
	}
	for (int i = 0; i < projectiles.size(); i++) {
		projectiles.get(i).draw(g);
	}
}
void checkCollision(){
	for (Alien alien: aliens) {
		if (ship.collisionBox.intersects(alien.collisionBox)) {
			ship.isActive=false;
			alien.isActive= false;
		}
		for (Projectile projectile: projectiles) {
		if (projectile.collisionBox.intersects(alien.collisionBox)) {
		projectile.isActive = false;
		alien.isActive = false;
		}
	}
	}
}
void purgeObjects() {
	for (Alien alien : aliens) {
		if (alien.isActive = false) {
			aliens.remove(alien);
		}
	}
	for (Projectile projectile : projectiles) {
		if (projectile.isActive = false) {
			projectiles.remove(projectile);
		}
	}
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	addAlien();
}
}

