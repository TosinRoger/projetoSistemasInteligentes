package br.com.tosin.si.project.controllers;

import br.com.tosin.si.project.models.Environment;
import br.com.tosin.si.project.models.ObjectInWorld;
import br.com.tosin.si.project.utils.CONST;

/**
 * Created by roger on 19/05/17.
 */
public class BuildMap {

    private static final int WIDTH = 9;
    private static final int HEIGHT = 9;

    public static Environment buildMap() {
        Environment environment = new Environment(WIDTH, HEIGHT);

        environment = putWalls(environment);

        return environment;
    }

    /**
     * Coloca paredes conforme descricao do projeto
     * @param environment
     * @return
     */
    private static Environment putWalls(Environment environment) {

        environment.addObstacle(new ObjectInWorld(0, 0, CONST.CODE_WALL));
        environment.addObstacle(new ObjectInWorld(0, 1, CONST.CODE_WALL));
        environment.addObstacle(new ObjectInWorld(0, 4, CONST.CODE_WALL));
        environment.addObstacle(new ObjectInWorld(0, 5, CONST.CODE_WALL));
        environment.addObstacle(new ObjectInWorld(0, 6, CONST.CODE_WALL));
        environment.addObstacle(new ObjectInWorld(0, 7, CONST.CODE_WALL));

        environment.addObstacle(new ObjectInWorld(1, 0, CONST.CODE_WALL));

        environment.addObstacle(new ObjectInWorld(2, 3, CONST.CODE_WALL));
        environment.addObstacle(new ObjectInWorld(2, 4, CONST.CODE_WALL));
        environment.addObstacle(new ObjectInWorld(2, 5, CONST.CODE_WALL));

        environment.addObstacle(new ObjectInWorld(3, 3, CONST.CODE_WALL));
        environment.addObstacle(new ObjectInWorld(3, 4, CONST.CODE_WALL));
        environment.addObstacle(new ObjectInWorld(3, 5, CONST.CODE_WALL));
        environment.addObstacle(new ObjectInWorld(3, 6, CONST.CODE_WALL));

        environment.addObstacle(new ObjectInWorld(5, 2, CONST.CODE_WALL));
        environment.addObstacle(new ObjectInWorld(5, 5, CONST.CODE_WALL));
        environment.addObstacle(new ObjectInWorld(5, 7, CONST.CODE_WALL));

        environment.addObstacle(new ObjectInWorld(6, 1, CONST.CODE_WALL));
        environment.addObstacle(new ObjectInWorld(6, 4, CONST.CODE_WALL));
        environment.addObstacle(new ObjectInWorld(6, 5, CONST.CODE_WALL));
        environment.addObstacle(new ObjectInWorld(6, 7, CONST.CODE_WALL));

        environment.addObstacle(new ObjectInWorld(7, 1, CONST.CODE_WALL));
        environment.addObstacle(new ObjectInWorld(7, 4, CONST.CODE_WALL));
        environment.addObstacle(new ObjectInWorld(7, 7, CONST.CODE_WALL));

        environment.addObstacle(new ObjectInWorld(8, 1, CONST.CODE_WALL));
        environment.addObstacle(new ObjectInWorld(8, 2, CONST.CODE_WALL));

        environment.addObstacle(new ObjectInWorld(8, 0, CONST.CODE_MOBILE));

        environment.addObstacle(new ObjectInWorld(2,6, CONST.CODE_TARGET));

        return environment;
    }
}
