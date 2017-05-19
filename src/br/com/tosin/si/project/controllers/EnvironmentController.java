package br.com.tosin.si.project.controllers;

import br.com.tosin.si.project.models.*;

/**
 * Created by roger on 19/05/17.
 */
public class EnvironmentController extends Physics {

    private GameController gameController;
    private Environment environment;
    private Fruit auxLastMove;

    public EnvironmentController(GameController gameController, Environment environment) {
        this.gameController = gameController;
        this.environment = environment;
    }



    public ObjectInWorld[][] getWorld() {
        ObjectInWorld[][] world = environment.world;
        return world;
    }

    public Position getPosition(Agent agent) {
        return environment.getAgent(agent);
    }

    public boolean canMove(Position newPos, Agent agent) {
        return moveTo(environment.world, agent.getPosition(), newPos);
    }

    public Fruit getFruitNextMove(Position position) {
        return (Fruit) environment.world[position.x][position.y];
    }

    public void updateEnvironment(Position newPos, Agent agent) {
        /*
            salva a fruta da proxima posicao
            move o agente
            verifica se precisa recolocar a fruta da posicao anterior
         */
        Agent a = (Agent) environment.world[agent.x][agent.y];
        Fruit fruitNextPosition = environment.world[newPos.x][newPos.y] instanceof Fruit ? (Fruit) environment.world[newPos.x][newPos.y] : null;

        if (a != null && a.id == agent.id) {
            environment.world[agent.x][agent.y] = null;
            a.setPosition(newPos);
            environment.world[newPos.x][newPos.y] = a;
        }

        if (auxLastMove != null)
            environment.addObstacle(auxLastMove);

        auxLastMove = fruitNextPosition;
    }

    public void removeFruit(Fruit fruit) {
        environment.world[fruit.x][fruit.y] = null;
    }

    public boolean isTarget(Position position, Position newPosition) {
        return nextMoveIsTarget(environment.world, position, newPosition);
    }

}
