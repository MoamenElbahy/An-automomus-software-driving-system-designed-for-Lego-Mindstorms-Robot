package Lab5;
import lejos.hardware.port.SensorPort;
import lejos.robotics.SampleProvider;
import lejos.hardware.sensor.EV3UltrasonicSensor;

public class MeasureDistance {
	private EV3UltrasonicSensor distanceSensor;
	private SampleProvider distance;
	private float[] sample;
	
	public MeasureDistance() {
		distanceSensor = new EV3UltrasonicSensor(SensorPort.S4);
		distance = distanceSensor.getDistanceMode();
		sample = new float [distance.sampleSize()];
	}
	
	public double distanceValue() {
		distance.fetchSample(sample, 0);
		float distanceValue =sample[0];
		return distanceValue*100;
	}
}