import java.util.Objects;

public class Particle {
    public int x;
    public int y;

    public Particle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveParticle(int move) {
        if (move==1 && x<498) x++;
        else if (move==2 && x>2) x--;
        else if (move==3 && y<498) y++;
        else if (move==4 && y>2) y--;
        else if (move==5) y-= 10;
        else if (move==6) y+= 10;
        else if (move==7) x-= 10;
        else if (move==8) x+= 10;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("x=").append(x).append("; y=").append(y);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Particle particle = (Particle) o;
        return x == particle.x && y == particle.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
