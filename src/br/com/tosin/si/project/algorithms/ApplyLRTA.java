package br.com.tosin.si.project.algorithms;

import br.com.tosin.si.project.constants.DIRECTIONS;
import br.com.tosin.si.project.models.ObjectInWorld;
import br.com.tosin.si.project.models.Position;
import br.com.tosin.si.project.utils.CONST;

/**
 * Created by roger on 20/05/17.
 */
public class ApplyLRTA {

    private double[][] cost;
    private double costRecovered;

    public static final int WIDTH  = 9;
    public static final int HEIGHT = 9;

    private static final int COST_INFINITE = 1000000;

    private static final double COST_BASE = 1;
    private static final double COST_DIAGONAL = 1.5;


    private double[][] map = new double[WIDTH][HEIGHT];

    public ApplyLRTA() {

        costRecovered = 0.0;
    }

    public void configDefaultCust(ObjectInWorld[][] world) {
        calculateCost();
        addObstacleInCost(world);
    }


    public DIRECTIONS findNextPosition(Position currentPosition) {

        DIRECTIONS nextDirections = null;
        double best = COST_INFINITE;

        // visinho norte
        if ( currentPosition.y != 0 &&  (COST_BASE + cost[currentPosition.x][currentPosition.y - 1]) < best) {
            best = (COST_BASE + cost[currentPosition.x][currentPosition.y - 1]);
            nextDirections = DIRECTIONS.N;
        }

        // visinho sul
        if ( currentPosition.y != (HEIGHT - 1) &&  (COST_BASE + cost[currentPosition.x][currentPosition.y + 1]) < best) {
            best = (COST_BASE + cost[currentPosition.x][currentPosition.y + 1]);
            nextDirections = DIRECTIONS.S;
        }

        // visinho oeste
        if ( currentPosition.x != 0 &&  (COST_BASE + cost[currentPosition.x - 1][currentPosition.y]) < best) {
            best = (COST_BASE + cost[currentPosition.x - 1][currentPosition.y]);
            nextDirections = DIRECTIONS.O;
        }

        // visinho leste
        if ( currentPosition.y != (WIDTH -1) &&  (COST_BASE + cost[currentPosition.x + 1][currentPosition.y]) < best) {
            best = (COST_BASE + cost[currentPosition.x + 1][currentPosition.y]);
            nextDirections = DIRECTIONS.L;
        }

        // visinho nordeste
        if ((currentPosition.x != (WIDTH - 1) && currentPosition.y != 0) && (COST_BASE + cost[currentPosition.x + 1][currentPosition.y - 1]) < best) {
            best = (COST_DIAGONAL + cost[currentPosition.x + 1][currentPosition.y - 1]);
            nextDirections = DIRECTIONS.ND;
        }

        // visinho noroeste
        if ((currentPosition.x != 0 && currentPosition.y != 0) && (COST_BASE + cost[currentPosition.x - 1][currentPosition.y - 1]) < best) {
            best = (COST_DIAGONAL + cost[currentPosition.x - 1][currentPosition.y - 1]);
            nextDirections = DIRECTIONS.NO;
        }

        // visinho suldeste
        if ((currentPosition.x != (WIDTH - 1) && currentPosition.y != (HEIGHT - 1)) && (COST_BASE + cost[currentPosition.x + 1][currentPosition.y + 1]) < best) {
            best = COST_DIAGONAL + cost[currentPosition.x + 1][currentPosition.y + 1];
            nextDirections = DIRECTIONS.SD;
        }

        // visinho suldoeste
        if ((currentPosition.x != 0 && currentPosition.y != (HEIGHT - 1)) && (COST_BASE + cost[currentPosition.x - 1][currentPosition.y + 1]) < best) {
            best = COST_DIAGONAL + cost[currentPosition.x - 1][currentPosition.y + 1];
            nextDirections = DIRECTIONS.SD;
        }

        return nextDirections;
    }

    private void calculateCost() {

        cost = new double[WIDTH][HEIGHT];

//        i == y
//        j == x
        for (int i = 0; i < cost.length; i++) {
            for (int j = 0; j < cost[i].length; j++) {
                double x = Math.abs(j - CONST.TARGET_X);
                x = Math.pow(x, 2);

                double y = Math.abs(i - CONST.TARGET_Y);
                y = Math.pow(y, 2);

                double distance = x + y;
                distance = Math.sqrt(distance);

                cost[j][i] = distance;
            }
        }
    }

    private void addObstacleInCost(ObjectInWorld[][] world) {
        for (int i = 0; i < cost.length; i++) {
            for (int j = 0; j < cost[i].length; j++) {
                if (world[i][j].code == CONST.CODE_WALL) {
                    cost[i][j] = COST_INFINITE;
                }
            }
        }
    }
}
