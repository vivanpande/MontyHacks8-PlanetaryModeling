package planet.engine;

class State implements Cloneable {

    private Vector3 position;
    private Vector3 velocity;

    public State(Vector3 p, Vector3 v) {
        position = p;
        velocity = v;
    }

    public Vector3 getPos() {
        return position;
    }

    public void setPos(Vector3 p) {
        position = p;
    }

    public Vector3 getVel() {
        return velocity;
    }

    public void setVel(Vector3 v) {
        velocity = v;
    }

    public State clone() {
        return new State(new Vector3(position), new Vector3(velocity));
    }
}
