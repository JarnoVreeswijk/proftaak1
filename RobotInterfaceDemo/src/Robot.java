import hardware.*;

import java.util.ArrayList;

public class Robot implements UltrasoneDetectie, MotorStateChange, AfstandsbedieningButtonPress {
	Motor motor;
	Ultrasone ultrasone;
	ArrayList<Updatable> updatables;

	public Robot()
	{
		updatables = new ArrayList<>();

		updatables.add(motor = new Motor(15, this));
		updatables.add(new Afstandsbediening(5, this));
		updatables.add(new Ultrasone(10, this));


		motor.vooruit();
	}

	public void step() {


		for(Updatable updatable : updatables) {
			updatable.update();
		}
	}

	@Override
	public void onUltraSoneDetect(int distance) {
		System.out.println("Ultrasoon: " + distance);
		if(distance < 10)
		{
			motor.stop();
		}
	}

	@Override
	public void onMotorStopped() {
		System.out.println("Motor is gestopt");
	}

	@Override
	public void onMotorAtSpeed(int speed) {
		System.out.println("De motor is op doelsnelheid " + speed);
	}

	@Override
	public void onAfstandsbediening(int code) {
		System.out.println("Er is op een knop gedrukt: " + code);
		if(code == 1)
			motor.vooruit();
	}
}
