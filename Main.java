package Lab5;
import java.util.ArrayList;
import java.util.List;
import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;

public class Main {

	public static void main(String[] args) {
		
		MazeNavigator navigator =new MazeNavigator();
		
		int turningDirection = 2; // ( 2 => to the right || -2 => to the left)
		int moveDirection = 1; // ( 1 => to the forward || -1 => to backwards)
		int turningAngle = 90;
		int movingSpeed = 600;
		  
		ColorMenu colorMenu;
		List<MenuItem> menuItem = new ArrayList<MenuItem>();
		
		final int BLOCKWIDTH = 35;
		final String[] COLOR = {"Black","Blue","Green","Yellow","Red","White","Brown"};
		 
		for (int i = 1; i< COLOR.length +1; i++) {
			  MenuItem x = new MenuItem(2, i, COLOR[i-1]);
			  menuItem.add(x);	  
		  }
		  colorMenu = new ColorMenu(COLOR.length, menuItem);
		  colorMenu.displayMenu();
		  navigator.setSelectedColor(COLOR[colorMenu.displayMenu()]);
		  
		  LCD.clear();
		  Sound.setVolume(50);
		  Sound.playTone(50, 1000);
		  
		  navigator.nagivate(movingSpeed, turningAngle, moveDirection, turningDirection, BLOCKWIDTH);
     }
}