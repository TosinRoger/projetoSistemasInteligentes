package br.com.tosin.si.project.generators;

import br.com.tosin.si.project.models.Agent;
import br.com.tosin.si.project.models.Environment;
import br.com.tosin.si.project.models.ObjectInWorld;
import br.com.tosin.si.project.utils.CONST;

/**
 * Created by roger on 19/05/17.
 */
public class BuildMap {

    private static final int WIDTH = 9;
    private static final int HEIGHT = 9;

    /**
     * Controi mapa com as especificacoes do projeto. Colocando Paredes, Objetivo e Agente na posicao inicial
     * @return
     */
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

        environment.addObstacle(new ObjectInWorld(1, 0, CONST.CODE_WALL));
        environment.addObstacle(new ObjectInWorld(1, 6, CONST.CODE_WALL));
        environment.addObstacle(new ObjectInWorld(1, 7, CONST.CODE_WALL));
        environment.addObstacle(new ObjectInWorld(1, 8, CONST.CODE_WALL));

        environment.addObstacle(new ObjectInWorld(2, 5, CONST.CODE_WALL));

        environment.addObstacle(new ObjectInWorld(3, 2, CONST.CODE_WALL));
        environment.addObstacle(new ObjectInWorld(3, 3, CONST.CODE_WALL));

        environment.addObstacle(new ObjectInWorld(4, 0, CONST.CODE_WALL));
        environment.addObstacle(new ObjectInWorld(4, 2, CONST.CODE_WALL));
        environment.addObstacle(new ObjectInWorld(4, 3, CONST.CODE_WALL));
        environment.addObstacle(new ObjectInWorld(4, 6, CONST.CODE_WALL));
        environment.addObstacle(new ObjectInWorld(4, 7, CONST.CODE_WALL));

        environment.addObstacle(new ObjectInWorld(5, 0, CONST.CODE_WALL));
        environment.addObstacle(new ObjectInWorld(5, 2, CONST.CODE_WALL));
        environment.addObstacle(new ObjectInWorld(5, 3, CONST.CODE_WALL));
        environment.addObstacle(new ObjectInWorld(5, 5, CONST.CODE_WALL));
        environment.addObstacle(new ObjectInWorld(5, 6, CONST.CODE_WALL));

        environment.addObstacle(new ObjectInWorld(6, 0, CONST.CODE_WALL));
        environment.addObstacle(new ObjectInWorld(6, 3, CONST.CODE_WALL));

        environment.addObstacle(new ObjectInWorld(7, 0, CONST.CODE_WALL));
        environment.addObstacle(new ObjectInWorld(7, 5, CONST.CODE_WALL));
        environment.addObstacle(new ObjectInWorld(7, 6, CONST.CODE_WALL));
        environment.addObstacle(new ObjectInWorld(7, 7, CONST.CODE_WALL));

        environment.addObstacle(new ObjectInWorld(CONST.TARGET_X,CONST.TARGET_Y, CONST.CODE_TARGET));

        return environment;
    }
}
