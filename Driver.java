package Lab5;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3GyroSensor;
import lejos.robotics.SampleProvider;

public abstract class Driver {	
	   private EV3LargeRegulatedMotor rightMotor;
	   private EV3LargeRegulatedMotor leftMotor;
	   private MeasureDistance distance;
	   private EV3GyroSensor poseSensor;
	   private float rotation;
	   private  ColorDetector colorSensor;
	   private boolean obstacle;
	   private String selectedColor;

	public Driver() {
		rightMotor =new EV3LargeRegulatedMotor(MotorPort.B);
		leftMotor =new EV3LargeRegulatedMotor(MotorPort.C);
		distance = new MeasureDistance();
		poseSensor= new EV3GyroSensor(SensorPort.S3);
		rotation =0;
		colorSensor =new ColorDetector();
		obstacle =false;
		selectedColor=null;
}	
	public String getSelectedColor() {
		return selectedColor;
	}
	
	public EV3GyroSensor getPoseSensor() {
		return poseSensor;
	}
	
	public double getDistance() {
		return distance.distanceValue();
	}
	
	public boolean isObstaclefound() {
		return obstacle;
	}

	public void setObstacle(boolean obstacle) {
		this.obstacle = obstacle;
	}

	
	public void setSpeed(int speed) {
	rightMotor.setSpeed(speed);
    leftMotor.setSpeed(speed);
	}
	
	public void stop() {
		rightMotor.stop();
	    leftMotor.stop();
		}
	
	public void rotatetoDist(int distance) {
	final double PI=3.14159;
	rightMotor.rotate((int) (-distance*3*3600/(PI*55)),true);
	leftMotor.rotate((int) (-distance*3*3600/(PI*55)),false);
	}
	
	public void setSelectedColor(String selectedColor) {
		this.selectedColor = selectedColor;
	}

	public String getColor() {  
		return colorSensor.color();
	}
	
	public boolean IscolorFound() {
		if (selectedColor==colorSensor.color()) {
			return true;
		}
		return false;
	}
	
	 public float getAngulardisp() {
		 SampleProvider currentPose =poseSensor.getAngleMode();;
		 float [] sample_Angle= new float  [currentPose.sampleSize()];
		 currentPose.fetchSample( sample_Angle, 0);
		 rotation= sample_Angle[0]; 
		 return Math.abs(rotation);
		}
	
	public void setDirection(int directionGuide){
		 if (directionGuide == 1) { 
			   leftMotor.backward(); //turn to backward positive direction
			   rightMotor.backward();
			  } else if (directionGuide == -1){
			   rightMotor.forward(); //turn to forward negative direction
			   leftMotor.forward();
			  }else if (directionGuide == -2){
			   rightMotor.forward(); //turn to left direction
			   leftMotor.backward();
			  }else if (directionGuide == 2){
			   rightMotor.backward(); //turn to right direction
			   leftMotor.forward();
			  }
	 }
}