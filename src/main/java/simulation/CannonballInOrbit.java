package simulation;

import maths.PhysicsVector;
import physics.Particle;

import static java.lang.Math.PI;

public class CannonballInOrbit {

    public static void main(String[] args){
        double radiusEarth = 6.4E6;
        double speed = 10000;
        double angle = 0.05;
        PhysicsVector initialPosition = new PhysicsVector(0, radiusEarth, 0);
        PhysicsVector initialVelocity = calcInitialVelocity(speed, angle);

        Particle cannonBall = new Particle(initialPosition, initialVelocity, 10);

        double timestep = 1.0;
        double bigG = 6.67E-11;
        double massEarth = 6E24;
        double bigK = bigG * massEarth * cannonBall.getMass();
        int counter = 0;

        double time = 0;
        double timelimit = 10E9;

        long startTime = System.currentTimeMillis();


        while(cannonBall.getPosition().magnitude() >= radiusEarth && time < timelimit) {
            double oldX = cannonBall.getPosition().getX();
            PhysicsVector force = getForce(bigK, cannonBall.getPosition());
            cannonBall.updatePosition(timestep);
            cannonBall.updateVelocity(force, timestep);
            time += timestep;
            if(oldX < 0 && cannonBall.getPosition().getX() >= 0){
                counter++;

            }
        }
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        double minutes = duration / 60000.0;

        System.out.printf("X: %.2e m %n", cannonBall.getPosition().getX());
        System.out.printf("Y: %.2e m %n", cannonBall.getPosition().getY());
        System.out.println(time);
        System.out.println("Number of times circumnavigated : " + counter);
        System.out.printf("Runtime: %.2f s %n", duration / 1000.0);
    }

    public static PhysicsVector getForce(double K, PhysicsVector position){
        PhysicsVector force = new PhysicsVector(position.getUnitVector());
        double mag = position.magnitude();
        force.scale(-K / (mag * mag));
        return force;
    }

    public static PhysicsVector calcInitialVelocity(double speed, double angle){
        double y = speed * Math.sin(angle);
        double x = speed * Math.cos(angle);
        PhysicsVector initVel = new PhysicsVector(x, y, 0);
        return initVel;
    }
}
