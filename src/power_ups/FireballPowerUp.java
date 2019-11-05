package power_ups;

import model.balls.FireBall;

public class FireballPowerUp implements PowerUp {
    @Override
    public void usePowerUp() {
        System.out.println("Change the ball to a fireball");
    }
}
