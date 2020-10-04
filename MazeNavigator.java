package Lab5;
import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class MazeNavigator extends Driver{
	
	public MazeNavigator() {
	}
	
	public void simpleMove(double dist, int speed) {
	       if(getDistance() < dist) {
	    	   setObstacle(true);
	    	   checkColor(500,1);
	       }else {
			setSpeed(speed);
			rotatetoDist((int)dist);
			
			if(Button.ESCAPE.isDown()) {
				stop();
			}
			
			}
	}
	 
	public void turn(double desiredAngle, int directionGuide) {
		getPoseSensor().reset();
		 while (true) {
		if (getAngulardisp() <= (desiredAngle*0.85)) {
			setSpeed(500);
		} else if (getAngulardisp() > (desiredAngle*0.85) && getAngulardisp() < desiredAngle) {
			setSpeed(100);
		} else if (getAngulardisp() >= desiredAngle){
			setSpeed(0);
			break;
		}
		setDirection(directionGuide);
		
		if(Button.ESCAPE.isDown() || IscolorFound()) {
			stop();
			break;
		}
     }	
  }
	
	public void checkColor(int speed, int directionGuide) {
		while (true) {
			if ( getDistance() > 3.8) {
				setSpeed(speed);
			    setDirection(1);
	        } else if (getDistance() <= 3.8) {
	        	setSpeed(0);
	        	LCD.drawString( "color: "+getColor(),1,2);
	        	Delay.msDelay(500);
	        	LCD.clear();
	        	setSpeed(speed);
	        	rotatetoDist(-6);
		     	break;
	       }
			
			if(Button.ESCAPE.isDown() || IscolorFound()) {
				stop();
				break;
			}
		}
	}
	
	public void nagivate(int movingSpeed, int turningAngle, int moveDirection, int turningDirection, int BLOCKWIDTH) {
		
		while (true){
			LCD.drawString( "Search for "+getSelectedColor(),1,4);
			simpleMove(moveDirection * BLOCKWIDTH, movingSpeed);
			
			if (isObstaclefound()) {
				turn(turningAngle,-turningDirection);
				setObstacle(false);
			}else {
			turn(turningAngle,turningDirection);
			if (isObstaclefound()) {
			checkColor(movingSpeed,moveDirection);
			turn(turningAngle,-turningDirection);
			}
		  }
			if(Button.ESCAPE.isDown() || IscolorFound()) {
				stop();
				break;
			}
		}
		
		
			if(IscolorFound()) {
			Sound.setVolume(60);
			Sound.playTone(50, 1000);
			LCD.drawString("Color found ", 1, 4);
			Delay.msDelay(2000);
		}
	}
	
	
}