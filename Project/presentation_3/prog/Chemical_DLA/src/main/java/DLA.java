/*
 * This class simulates chemical diffusion limited aggregation.
 * Author: Toponen N.A.
 * Date: 10.03.2022
 */

import java.awt.Color;

public class DLA {
    // test client
    public static void main(String[] args) {
        int N = 500;     // N-by-N grid
        int launch = N - 10;                   // row to launch particles from
        boolean[][] dla = new boolean[N][N];   // is cell (x, y) occupied

        Picture pic = new Picture(N, N);

        // set seed to be bottom row
        dla[240][240] = true;


        // repeat until aggregate hits top
        boolean done = false;
        while (!done) {

            // random launching point
            double m = Math.random();
            int x;
            int y;
            //Bottom
            if (m < 0.25) {
                x = (int) (N * Math.random());
                y = launch;
            }
            //Top
            else if (m < 0.50) {
                x = (int) (N * Math.random());
                y = 10;
            }
            //Left
            else if (m < 0.75) {
                x = 10;
                y = (int) (N*Math.random());
            }
            //Right
            else {
                x = launch;
                y = (int) (N*Math.random());
            }

            // particle takes a 2d random walk
            while (x < N - 2 && x > 1 && y < N - 2 && y > 1) {
                double r = Math.random();
                if      (r < 0.25) x--;
                else if (r < 0.50) x++;
                else if (r < 0.75) y++;
                else               y--;

                // check if neighboring site is occupied
                if (dla[x-1][y]   || dla[x+1][y]   || dla[x][y-1]   || dla[x][y+1]   ||
                        dla[x-1][y-1] || dla[x+1][y+1] || dla[x-1][y+1] || dla[x+1][y-1] ) {
                    double n = Math.random();
                    if (n<0.3) {
                        dla[x][y] = true;
                    }
                    pic.set(x, N-y-1, Color.white);
                    pic.show();

                    // aggregate hits top, so set flag to stop outer while loop
                    if (y > launch) done = true;
                    else if (y < 10) done = true;
                    else if (x > launch) done = true;
                    else if (x < 10) done = true;

                    // particle stuck, so break out of inner while loop
                    break;
                }
            }
        }
    }
}