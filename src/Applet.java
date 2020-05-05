
import processing.core.PApplet;

public class Applet extends PApplet {
	public static int WIDTH = 1000;
	public static int HEIGHT = 900;

	private static final int CIRCLES = 10; // Number of circles
	private static double BASE_MOVEMENT = 2; // Rotation speed
	private static double VARIABLE_MOVEMENT = 0.5; // Shift speed

	double[] angle;

	int size = 800;

	public Applet() {
		angle = new double[CIRCLES];
		for (int i = 0; i < CIRCLES; i++) {
			angle[i] = 0;
		}
	}

	public void settings() {
		size(WIDTH, HEIGHT);
	}

	public void setup() {
		frameRate(60);
		stroke(0, 50, 0);
	}

	public void draw() {
		background(10, 50, 25);
		double totalX = 0;
		double totalY = 0;
		fill(0, 100, 0);
		circle(width / 2, height / 2, size + size / angle.length);
		for (int i = 0; i < angle.length; i++) {

			if (keyPressed && keyCode == RIGHT) {
				angle[i] += BASE_MOVEMENT + VARIABLE_MOVEMENT * i;
			} else if (keyPressed && keyCode == LEFT) {
				angle[i] -= BASE_MOVEMENT + VARIABLE_MOVEMENT * i;
			} else if (keyPressed && keyCode == UP) {
				angle[i] += 2 * (BASE_MOVEMENT + VARIABLE_MOVEMENT * i);
			} else if (keyPressed && keyCode == DOWN) {
				angle[i] -= 2 * (BASE_MOVEMENT + VARIABLE_MOVEMENT * i);
			}
			totalX += Math.sin(Math.toRadians(angle[i]));
			totalY += Math.cos(Math.toRadians(angle[i]));

			// Fill code
			fill(0, 100, 55 + 200 * (float) i / angle.length);

			circle(width / 2 + totalX * size / 2 / angle.length, height / 2 + totalY * size / 2 / angle.length,
					size - (double) size / angle.length * i);

		}
	}

	private void circle(double x, double y, double size) {
		ellipse((float) x, (float) y, (float) size, (float) size);
	}

}
