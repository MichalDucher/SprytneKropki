public class PVector {
    public float x;
    public float y;
    public float z;

    public PVector() {
        x = 0;
        y = 0;
        z = 0;
    }

    public PVector(float x, float y) {
        this.x = x;
        this.y = y;
        this.z = 0;
    }

    public PVector(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public PVector add(PVector v) {
        x += v.x;
        y += v.y;
        z += v.z;
        return this;
    }

    public PVector sub(PVector v) {
        x -= v.x;
        y -= v.y;
        z -= v.z;
        return this;
    }

    public PVector mult(float n) {
        x *= n;
        y *= n;
        z *= n;
        return this;
    }

    public PVector div(float n) {
        x /= n;
        y /= n;
        z /= n;
        return this;
    }

    public float mag() {
        return (float) Math.sqrt(x*x + y*y + z*z);
    }

    public PVector normalize() {
        float m = mag();
        if (m != 0 && m != 1) {
            div(m);
        }
        return this;
    }

    public float distance(PVector v) {
        double dx = this.x - v.x;
        double dy = this.y - v.y;

        return (float)Math.sqrt(dx * dx + dy * dy);
    }

    public PVector copy() {
        return new PVector(this.x, this.y, this.z);
    }

    public void setMag(float len) {
        normalize();
        mult(len);
    }

    public void limit(float max) {
        if (mag() > max) {
            setMag(max);
        }
    }

    public static PVector fromAngle(float angle) {
        float x = (float) Math.cos(angle);
        float y = (float) Math.sin(angle);
        return new PVector(x, y);
    }
}

