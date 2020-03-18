import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Rocketship ship;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random rand = new Random();
ObjectManager(Rocketship ship){
this.ship= ship;
}
void addProjectiles(Projectile projectiles) {
	
}
void addAlien() {
	aliens.add(new Alien(rand.nextInt(LeagueInvaders.WIDTH),0,50,50));
}
void update(){
	for (Alien alien : aliens) {
		
	}
}
}
