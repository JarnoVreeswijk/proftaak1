package hardware;

public interface MotorStateChange {
	void onMotorStopped();
	void onMotorAtSpeed(int speed);
}
