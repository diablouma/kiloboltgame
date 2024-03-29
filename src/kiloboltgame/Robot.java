package kiloboltgame;

/**
 * Created with IntelliJ IDEA.
 * User: nelson
 * Date: 9/13/13
 * Time: 5:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class Robot {

    private int centerX = 100;
    private int centerY = 382;
    private boolean jumped = false;

    private int speedX = 0;
    private int speedY = 1;

    public void update() {
        // Moves Character or Scrolls Background accordingly.
        if (speedX < 0) {
            centerX += speedX;
        } else if (speedX == 0) {
            System.out.println("Do not scroll the background.");
        } else {
            if (centerX <= 150) {
                centerX += speedX;
            } else {
                System.out.println("Scroll Background Here");
            }
        }

        if (centerY + speedY >= 382) {
            centerY = 382;
        } else {
            centerY += speedY;
        }

        // Handles Jumping
        if (jumped == true) {
            speedY += 1;

            if (centerY + speedY >= 382) {
                centerY = 382;
                speedY = 0;
                jumped = false;
            }

        }

        // Prevents going beyond X coordinate of 0
        if (centerX + speedX <= 60) {
            centerX = 61;
        }

    }

    public void moveRight() {
        speedX = 6;
    }

    public void moveLeft() {
        speedX = -6;
    }

    public void stop() {
        speedX = 0;
    }

    public void jump() {
        if (jumped == false) {
            speedY = -15;
            jumped = true;
        }

    }
}
