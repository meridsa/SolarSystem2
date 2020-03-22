package maths;
import java.lang.Math;

public class PhysicsVector {
    public static final int dimension = 3;
    private double[] physicsVector = new double[dimension];

    public PhysicsVector(double... vec){
        System.arraycopy(vec, 0, this.physicsVector, 0, Math.min(dimension, vec.length));
    }

    public double getX(){
        double x = this.physicsVector[0];
        return x;
    }

    public double getY(){
        double y = this.physicsVector[1];
        return y;
    }

    public double getZ(){
        double z = this.physicsVector[2];
        return z;
    }

    public double[] getPhysicsVector() {
        return physicsVector;
    }

    public void add(PhysicsVector otherVector){
        for (int i = 0; i < PhysicsVector.dimension; i++){
            this.physicsVector[i] += otherVector.physicsVector[i];
        }
    }

    public void subtract(PhysicsVector otherVector){
        for (int i = 0; i < PhysicsVector.dimension; i++){
            this.physicsVector[i] -= otherVector.physicsVector[i];
        }
    }


}
