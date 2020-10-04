package Lab5;

public class MenuItem {

	private String displayText;
	private int x, y;
	//private boolean isSelected = false;
	
	public MenuItem(int x, int y, String displayText) {
		this.x = x;
		this.y = y;
		this.displayText = displayText;
	}
	
	public String getDisplayText(int pointerposition) {
		if (pointerposition == y) { 
	        return ">" + displayText; }
		else {
			return " " + displayText;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
