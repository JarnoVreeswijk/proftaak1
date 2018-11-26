package hardware;

import TI.Timer;

public class Motor implements Updatable {

	private MotorStateChange motorStateChange;
	private int snelheid;
	private int doelSnelheid;

	private Timer timer;

	public Motor(int pin, MotorStateChange motorStateChange) {
		//normaal: servo = new Servo(...);

		this.snelheid = 0;
		this.doelSnelheid = 0;
		this.timer = new Timer(50);
		this.motorStateChange = motorStateChange;
	}

	public void update()
	{
		if(timer.timeout()) {
			if (this.snelheid != this.doelSnelheid) {
				if (this.snelheid > this.doelSnelheid) {
					this.snelheid--;
				} else {
					this.snelheid++;
				}

				if(this.snelheid == this.doelSnelheid) {
					motorStateChange.onMotorAtSpeed(this.snelheid);
				}
				if(this.doelSnelheid == 0 && this.snelheid == 0) {
					motorStateChange.onMotorStopped();
				}

			}


		}


	}

	public void vooruit()
	{
		this.doelSnelheid = 10;
	}

	public void achteruit()
	{
		this.doelSnelheid = -10;
	}

	public void stop()
	{
		this.doelSnelheid = 0;
	}

}
