package planet.engine;

import java.util.ArrayList;

class World {

    private final ArrayList<Body> bodies;

    public World() {
        bodies = new ArrayList<>();
    }

    public void addBody(Body b) {
        bodies.add(b);
    }

    public void reset() {
        for (Body b : bodies) {
            b.reset();
        }
    }

    private double compute_dUdv(Body in, Vector3 v) {
        double pot = 0.0;

        for (Body b : bodies) {
            if (b != in) {
                pot += b.getPot(in.getPos());
            }
        }

        for (Body b : bodies) {
            if (b != in) {
                pot -= b.getPot(in.getPos().add(v));
            }
        }

        return pot / v.norm();
    }

    private Vector3 getForce(Body in) {
        double U_x = compute_dUdv(in, new Vector3(0.01, 0, 0));
        double U_y = compute_dUdv(in, new Vector3(0, 0.01, 0));
        double U_z = compute_dUdv(in, new Vector3(0, 0, 0.01));
        return new Vector3(U_x, U_y, U_z);
    }

    public void compute() {
        for (Body b : bodies) {
            b.compute(getForce(b));
        }
    }

    public void tick() {
        compute();
        commit();
    }

    public void commit() {
        for (Body b : bodies) {
            b.commit();
        }
    }

    public int getBodyCount() {
        return bodies.size();
    }

}