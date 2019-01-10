import java.awt.Color;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class Gridworld {
	public static void main(String[] args) {
		World world = new World();
		world.show();
		Flower bruh = new Flower();
		Flower white = new Flower();
		Flower blue = new Flower();
		int x = 0;
		int y = 0;
		Location soundEffectNumberTwo = new Location(x,y);
		//Location loc = world.getRandomEmptyLocation();
		/*Bug big = new Bug();
		Bug chungus = new Bug();
		world.add(world.getRandomEmptyLocation(), big);
		world.add(loc, chungus);
		chungus.setColor(Color.BLUE);
		chungus.setDirection(90);
		world.add(loc.getAdjacentLocation(90), bruh);
		world.add(loc.getAdjacentLocation(270), bruh);*/
		for(int o = 0;o<4;o++) {
			for(int i = 0;i<10;i++) {
				world.add(soundEffectNumberTwo = new Location(y,x), bruh);
				bruh.setColor(Color.RED);
				x++;
			}
			y++;
			x=0;
			for(int i = 0;i<10;i++) {
				world.add(soundEffectNumberTwo = new Location(y,x), white);
				white.setColor(Color.WHITE);
				x++;
			}
			y++;
			x=0;
			for(int i = 0;i<10;i++) {
				world.add(soundEffectNumberTwo = new Location(y,x), blue);
				blue.setColor(Color.BLUE);
				x++;
			}
			y++;
			x=0;
		}
	}
}
