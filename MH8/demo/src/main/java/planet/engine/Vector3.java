package planet.engine;

class Vector3 {

    private double x;
    private double y;
    private double z;

    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3(Vector3 v) {
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public Vector3 negate() {
        return new Vector3(-x, -y, -z);
    }

    public Vector3 div(double scalar) {
        return new Vector3(x / scalar, y / scalar, z / scalar);
    }

    public Vector3 times(double scalar) {
        return new Vector3(x * scalar, y * scalar, z * scalar);
    }

    public Vector3 add(Vector3 v) {
        return new Vector3(x + v.x, y + v.y, z + v.z);
    }

    public Vector3 minus(Vector3 v) {
        return add(v.negate());
    }

    public double norm() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double getDist(Vector3 v) {
        return minus(v).norm();
    }

    public double dot(Vector3 b) {
        return x * b.x + y * b.y + z * b.z;
    }
}
