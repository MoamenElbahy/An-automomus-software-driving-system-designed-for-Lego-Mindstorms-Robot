package Lab5;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.SensorMode;
import lejos.hardware.sensor.EV3ColorSensor;

public class ColorDetector {
	private EV3ColorSensor colorSensor;
	private SensorMode colorID;
	
	public ColorDetector(){
		colorSensor = new EV3ColorSensor(SensorPort.S1);
		colorID = colorSensor.getColorIDMode();
	}
	
	public String color(){
		float[] sampleID = new float [colorID.sampleSize()];
		colorID.fetchSample(sampleID, 0);
		int id =(int) sampleID[0];
		
		String Color = null;
		switch(id) {
		case 0:
			Color="No Color";
			break;
		case 1:
			Color="Black";
			break;
		case 2:
			Color="Blue";
			break;
		case 3:
			Color="Green";
			break;
		case 4:
			Color="Yellow";
			break;
		case 5:
			Color="Red";
			break;
		case 6:
			Color="White";
			break;
		case 7:
			Color="Brown";
			break;
			}
		return Color;
	}
}