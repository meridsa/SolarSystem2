package simulation;

import maths.PhysicsVector;
import physics.Particle;

public class simpleCannon {

    public static void main(String[] args){
        PhysicsVector initialPosition = new PhysicsVector();
        PhysicsVector initialVelocity = new PhysicsVector(10.0, 1000.0, 0.0);


        Particle cannonBall = new Particle(initialPosition, initialVelocity, 10);

        double timestep = 0.01;
        double gravity = 9.81;
        double forceMag = gravity * cannonBall.getMass();
        PhysicsVector force = new PhysicsVector(0.0, -forceMag, 0.0);

        double time = 0;
        double maxY = 0;

        while(cannonBall.getYPosition() >= 0) {
            cannonBall.updatePosition(timestep);
            cannonBall.updateVelocity(force, timestep);
            if(cannonBall.getYPosition() > maxY){
                maxY = cannonBall.getYPosition();
            }
            time += timestep;
        }
    }
}
