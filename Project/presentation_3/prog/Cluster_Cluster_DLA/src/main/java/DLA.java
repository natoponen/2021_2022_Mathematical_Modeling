import java.awt.Color;
import java.util.*;

public class DLA {
    private static final int N = 500;  // N-by-N grid
    public static boolean[][] dla = new boolean[N][N];   // is cell (x, y) occupied
    private static final int launch = N - 10;  // row to launch particles from
    public static ArrayList<Particle> cluster;
    public static Map<Integer, ArrayList<Particle>> clusters = new HashMap<Integer, ArrayList<Particle>>();  //Map of clusters

    public static boolean isOccupied(int x, int y) {
        if (x>0 && x<500 && y>0 && y<500) {
            return dla[x][y];
        } else return false;
    }
    public static void moveCluster(int move, ArrayList<Particle> cluster, Picture pic){
        for (Particle p: cluster) {
            int x_before = p.x;
            int y_before = p.y;
            p.moveParticle(move);
            dla[x_before][y_before]=false;
            dla[p.x][p.y]=true;
            pic.set(p.x, N-p.y-1, Color.white);
            pic.set(x_before,N-y_before-1, Color.black);
            pic.show();
        }
    }

    public static void mergeClusters(Particle p1, Particle p2) {
        ArrayList<Particle> list1 = new ArrayList<>();
        ArrayList<Particle> list2 = new ArrayList<>();
        Integer numOfCluster1 = 0;
        Integer numOfCluster2 = 0;
        for (Map.Entry<Integer, ArrayList<Particle>> entry : clusters.entrySet()) {
            if (entry.getValue().contains(p1)) {
                list1.addAll(entry.getValue());
                numOfCluster1 = entry.getKey();
            }
            if (entry.getValue().contains(p2)) {
                list2.addAll(entry.getValue());
                numOfCluster2 = entry.getKey();
            }
        }
        if (!list1.isEmpty() && !list2.isEmpty()) {
            list1.addAll(list2);
            clusters.put(numOfCluster1, list1);
            list2.removeAll(list2);
            clusters.put(numOfCluster2, list2);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Picture pic = new Picture(N, N);

        //Randomly placing particles on the surface
        int P = 15000; // number of particles

        for (int i = 0; i<P; i++) {
            int xp = (int) (Math.random()*490);
            int yp = (int) (Math.random()*490);
            cluster = new ArrayList<>();
            Particle p = new Particle(xp,yp);
            cluster.add(p);
            if (!isOccupied(xp,yp)) {
                dla[xp][yp]=true;
                clusters.put(i,cluster);
            }
        }

        boolean done = false;
        Iterator<Map.Entry<Integer, ArrayList<Particle>>> iterator;
        while (!done) {
            iterator = clusters.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, ArrayList<Particle>> entry = iterator.next();
                double r = Math.random();
                int move;
                if (r < 0.25) move = 1;
                else if (r < 0.50) move = 2;
                else if (r < 0.75) move = 3;
                else move = 4;
                moveCluster(move, entry.getValue(), pic);
                for (Particle p : entry.getValue()) {
                    if (isOccupied(p.x-1,p.y)) {
                        Particle pc = new Particle(p.x - 1, p.y);
                        if (entry.getValue().contains(pc)) {
                            break;
                        } else {
                            mergeClusters(p,pc);
                        }
                    }
                    if (isOccupied(p.x+1,p.y)) {
                        Particle pc = new Particle(p.x + 1, p.y);
                        if (entry.getValue().contains(pc)) {
                            break;
                        } else {
                            mergeClusters(p,pc);
                        }
                    }
                    if (isOccupied(p.x,p.y-1)) {
                        Particle pc = new Particle(p.x, p.y - 1);
                        if (entry.getValue().contains(pc)) {
                            break;
                        } else {
                            mergeClusters(p,pc);
                        }
                    }
                    if (isOccupied(p.x,p.y+1)) {
                        Particle pc = new Particle(p.x, p.y + 1);
                        if (entry.getValue().contains(pc)) {
                            break;
                        } else {
                            mergeClusters(p,pc);
                        }
                    }
                    if (isOccupied(p.x-1,p.y-1)) {
                        Particle pc = new Particle(p.x - 1, p.y - 1);
                        if (entry.getValue().contains(pc)) {
                            break;
                        } else {
                            mergeClusters(p,pc);
                        }
                    }
                    if (isOccupied(p.x+1,p.y+1)) {
                        Particle pc = new Particle(p.x + 1, p.y + 1);
                        if (entry.getValue().contains(pc)) {
                            break;
                        } else {
                            mergeClusters(p,pc);
                        }
                    }
                    if (isOccupied(p.x-1,p.y+1)) {
                        Particle pc = new Particle(p.x - 1, p.y + 1);
                        if (entry.getValue().contains(pc)) {
                            break;
                        } else {
                            mergeClusters(p,pc);
                        }
                    }
                    if (isOccupied(p.x+1,p.y-1)) {
                        Particle pc = new Particle(p.x + 1, p.y - 1);
                        if (entry.getValue().contains(pc)) {
                            break;
                        } else {
                            mergeClusters(p,pc);
                        }
                    }
                    if (p.y > launch) {
                        moveCluster(5, entry.getValue(), pic);
                    } else if (p.y < 10) {
                        moveCluster(6, entry.getValue(), pic);
                    } else if (p.x > launch) {
                        moveCluster(7, entry.getValue(), pic);
                    } else if (p.x < 10) {
                        moveCluster(8, entry.getValue(), pic);
                    }
                }
                if (entry.getValue().size()==P) {
                    done = true;
                }
                pic.show();
            }
        }
    }
}
