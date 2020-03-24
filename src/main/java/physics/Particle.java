package physics;

import maths.PhysicsVector;

public class Particle {

    PhysicsVector position;
    PhysicsVector velocity;
    double mass;

    public Particle(PhysicsVector pos, PhysicsVector vel, double mass){
        this.position = new PhysicsVector(pos);
        this.velocity = new PhysicsVector(vel);
        this.mass = mass;
    }

    public PhysicsVector getPosition() {
        return position;
    }

    public PhysicsVector getVelocity() {
        return velocity;
    }

    public double getYPosition() {
        return this.velocity.getY();
    }

    public double getMass() {
        return mass;
    }

    public void updatePosition(double timestep){
        //dx = v * dt
        this.position.add(
                PhysicsVector.scale(this.velocity, timestep)
        );
    }

    public void updateVelocity(PhysicsVector force, double timestep){
        // a = F / m
        force.scale(1.0 / this.mass);
        PhysicsVector acceleration = force;
        // dv = a * dt
        acceleration.scale(timestep);
        PhysicsVector changeInVelocity = acceleration;
        this.velocity.add(changeInVelocity);
    }


}
