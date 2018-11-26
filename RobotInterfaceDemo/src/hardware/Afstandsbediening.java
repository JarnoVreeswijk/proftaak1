package hardware;

public class Afstandsbediening implements Updatable {

	private AfstandsbedieningButtonPress onButtonPress;

	public Afstandsbediening(int pin, AfstandsbedieningButtonPress onButtonPress) {
		this.onButtonPress = onButtonPress;
	}

	@Override
	public void update() {
		if(Math.random() < 0.001)
		{
			int button = (int) (Math.random()*10);
			onButtonPress.onAfstandsbediening(button);
		}
	}
}
