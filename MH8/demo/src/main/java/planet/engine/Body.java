package planet.engine;

class Body {

    private String name;
    private State initial;
    private State current;
    private State pending;

    /* earth mass */
    private double mass;
    private double radius;

    private static final double dt = 0.001;
    /* temp */
    private static final double G = 1;

    public Body(String name, State initial, double mass, double radius) {
        this.name = name;
        this.initial = initial;
        this.current = initial.clone();
        this.pending = null;
        this.mass = mass;
        this.radius = radius;
    }

    public String getName() {
        return name;
    }

    public double getPot(Vector3 p) {
        return G * mass / p.getDist(current.getPos());
    }

    public void compute(Vector3 force) {
        Vector3 a = force.div(mass);
        pending = current.clone();
        pending.getVel().add(a.times(dt));
        pending.getPos().add(pending.getVel().times(dt));
    }

    public Vector3 getPos() {
        return current.getPos();
    }

    public void reset() {
        current = initial.clone();
    }

    public void commit() {
        current = pending.clone();
        pending = null;
    }

    public double getRadius() {
        return radius;
    }

    public double getMass() {
        return mass;
    }

}
