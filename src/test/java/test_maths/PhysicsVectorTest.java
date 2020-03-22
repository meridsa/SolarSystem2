package test_maths;
import maths.PhysicsVector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PhysicsVectorTest {

    @Test
    public void testPhysicsVectorConstruction_0floats() {
        PhysicsVector pv = new PhysicsVector();
        assertEquals(0.0, pv.getX());
        assertEquals(0.0, pv.getY());
        assertEquals(0.0, pv.getZ());
    }

    @Test
    public void testPhysicsVectorConstruction_1float() {
        double x = 1.0;
        PhysicsVector pv = new PhysicsVector(x);
        assertEquals(1.0, pv.getX());
        assertEquals(0.0, pv.getY());
        assertEquals(0.0, pv.getZ());
    }

    @Test
    public void testPhysicsVectorConstruction_2floats() {
        double x = 1.0, y = 2.0;
        PhysicsVector pv = new PhysicsVector(x, y);
        assertEquals(1.0, pv.getX());
        assertEquals(2.0, pv.getY());
        assertEquals(0.0, pv.getZ());
    }

    public void testPhysicsVectorConstruction_3floats() {
        double x = 1.0, y = 2.0, z = 3.0;
        PhysicsVector pv = new PhysicsVector(x, y, z);
        assertEquals(1.0, pv.getX());
        assertEquals(2.0, pv.getY());
        assertEquals(3.0, pv.getZ());
    }

    @Test
    public void testPhysicsVectorConstruction_emptyVec() {
        double[] v = new double[0];
        PhysicsVector pv = new PhysicsVector(v);
        assertEquals(0.0, pv.getX());
        assertEquals(0.0, pv.getY());
        assertEquals(0.0, pv.getZ());
    }

    @Test
    public void testPhysicsVectorConstruction_tooShortVec() {
        double[] v = new double[]{1.0};
        PhysicsVector pv = new PhysicsVector(v);
        assertEquals(1.0, pv.getX());
        assertEquals(0.0, pv.getY());
        assertEquals(0.0, pv.getZ());
    }

    @Test
    public void testPhysicsVectorConstruction_correctLengthVec() {
        double[] v = new double[]{1.0, 2.0, 3.0};
        PhysicsVector pv = new PhysicsVector(v);
        assertEquals(1.0, pv.getX());
        assertEquals(2.0, pv.getY());
        assertEquals(3.0, pv.getZ());
    }

    @Test
    public void testPhysicsVectorConstruction_tooLongVec() {
        double[] v = new double[]{1.0, 2.0, 3.0, 4.0, 5.0};
        PhysicsVector pv = new PhysicsVector(v);
        assertEquals(1.0, pv.getX());
        assertEquals(2.0, pv.getY());
        assertEquals(3.0, pv.getZ());
    }
}

class PhysicsVectorAddTest {

    @Test
    public void AddEmptyVecs_AllZero() {
        PhysicsVector v1 = new PhysicsVector();
        PhysicsVector v2 = new PhysicsVector();
        v1.add(v2);
        assertArrayEquals(new double[] {0.0, 0.0, 0.0},
                v1.getPhysicsVector(),
                "Adding empty vectors does not add to zero");
    }

    @Test
    public void AddEqualVecs_Doubled() {
        double t = 1.0;
        PhysicsVector v1 = new PhysicsVector(t, 2*t, 3*t);
        PhysicsVector v2 = new PhysicsVector(t, 2*t, 3*t);
        v1.add(v2);
        assertArrayEquals(new double[] {2.0, 4.0, 6.0},
                v1.getPhysicsVector(),
                "Adding equal vectors do not make sense");
    }

    @Test
    public void AddVecToItself_Doubled() {
        double t = 1.0;
        PhysicsVector v1 = new PhysicsVector(t, 2*t, 3*t);
        v1.add(v1);
        assertArrayEquals(new double[] {2.0, 4.0, 6.0},
                v1.getPhysicsVector(),
                "Adding vec to itself failed");
    }

}