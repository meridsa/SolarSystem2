package maths;
import java.lang.Math;

public class PhysicsVector {
    public static final int dimension = 3;
    private double[] physicsVector = new double[dimension];

    public PhysicsVector(double... vec){
        System.arraycopy(vec, 0, this.physicsVector, 0, Math.min(dimension, vec.length));
    }

    public PhysicsVector(PhysicsVector other){
        System.arraycopy(other.physicsVector, 0, this.physicsVector, 0, dimension);
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

    public double[] getPhysicsVector(){
        double [] returnVec = new double[dimension];
        System.arraycopy(this.physicsVector, 0, returnVec, 0, dimension);
        return returnVec;
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

    public PhysicsVector getUnitVector(){
        return PhysicsVector.scale(this, 1 / this.magnitude());
    }

    public double magnitude(){
        double magnitude = 0;
        for (double dimensionLength: this.physicsVector) {
            magnitude += dimensionLength * dimensionLength;
        }
        return Math.sqrt(magnitude);
    }

    public void scale(double scalar){
        for (int i = 0; i < dimension; i++) {
            this.physicsVector[i] *= scalar;
        }
    }

    // ---------- STATIC METHODS ----------

    public static PhysicsVector add(PhysicsVector a, PhysicsVector b){
        PhysicsVector physicsVector = new PhysicsVector(a);
        physicsVector.add(b);
        return physicsVector;
    }

    public static PhysicsVector subtract(PhysicsVector a, PhysicsVector b){
        PhysicsVector physicsVector = new PhysicsVector(a);
        physicsVector.add(b);
        return physicsVector;
    }

    public static PhysicsVector scale(PhysicsVector physicsVector, double scalar){
        PhysicsVector returnedPhysicsVector = new PhysicsVector(physicsVector);
        returnedPhysicsVector.scale(scalar);
        return returnedPhysicsVector;
    }

    public static PhysicsVector unitVector(PhysicsVector physicsVector){
        return physicsVector.getUnitVector();
    }

    public static double magnitude(PhysicsVector physicsVector){
        return physicsVector.magnitude();
    }
}
