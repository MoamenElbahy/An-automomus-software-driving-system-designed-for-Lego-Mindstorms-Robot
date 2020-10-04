package Lab5;
import java.util.List;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class ColorMenu {
	private int size;
	List<MenuItem> menuItem;
	private int pointerposition = 1;
	
	public ColorMenu(int size, List<MenuItem> menuItem) {
		this.size = size;
		this.menuItem = menuItem;
	}
	public int displayMenu() {
		while (! Button.ENTER.isDown()) {
		movePointer();
		LCD.drawString("Select color: ", 1, 0);
		for (int i = 0; i < size; i++) {
			LCD.drawString(menuItem.get(i).getDisplayText(pointerposition),menuItem.get(i).getX(),menuItem.get(i).getY());
			Delay.msDelay(50);
		}
	}
		return pointerposition-1;
	}
	public void movePointer() {
		if (Button.UP.isDown()) {
			if (pointerposition == 1) {
				pointerposition = 1; }
				else {
					pointerposition --;
				}
		}
		if (Button.DOWN.isDown()){
			if (pointerposition == 8) {
				pointerposition = 8;
		}else{
					pointerposition ++;
		}
	  }
	}
}