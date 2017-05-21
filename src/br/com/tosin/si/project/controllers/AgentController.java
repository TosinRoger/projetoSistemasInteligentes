package br.com.tosin.si.project.controllers;

import br.com.tosin.si.project.algorithms.DecideTheFruit;
import br.com.tosin.si.project.constants.DECIDE_FRUIT;
import br.com.tosin.si.project.constants.DIRECTIONS;
import br.com.tosin.si.project.constants.ENERGY_EXPENDITURE;
import br.com.tosin.si.project.constants.ENERGY_FRUITS;
import br.com.tosin.si.project.models.*;
import br.com.tosin.si.project.ui.InteractClientUser;
import br.com.tosin.si.project.utils.SortFruit;

import java.util.Collections;
import java.util.Iterator;

/**
 * Created by roger on 19/05/17.
 */
public class AgentController {

    private GameController gameController;
    private Agent agent;

    public AgentController(GameController gameController, Agent agent) {
        this.gameController = gameController;
        this.agent = agent;
    }

    /**
     * Verifica se precisa comer alguma fruita para evitar de gastar energia andando
     */
    public void reason() {


        Collections.sort(getAgent().fruits, new SortFruit());


        Iterator<Fruit> iterator = getAgent().fruits.iterator();

        while (iterator.hasNext()) {
            Fruit fruit = iterator.next();

            if (getAgent().health + fruit.getEnergy() <= ENERGY_EXPENDITURE.MAX_ENERGY_AGENT) {
                getAgent().health += fruit.getEnergy();
                iterator.remove();
            }
        }
    }

    private DIRECTIONS getDirection(){
        // se tem um plano executa o plano,
        // senao pergunta para o usuario
        if (!agent.plans.isEmpty()) {
            return agent.plans.remove(0);
        }

        DIRECTIONS direction = InteractClientUser.getDirection();

//        if (direction.equals("PLAN")) {
////            agent.plans = BuildStaticEnvironment.makePlain1();
//            String plan = "";
//            if (!agent.plans.isEmpty()) {
//                plan = agent.plans.remove(0);
//            }
//
//            return plan;
//        }
//        else
            return direction;
    }

    public Position moveTo() {

        readPositionInWorld();

        // GET DIRECTION BY USER IN CONSOLE
        DIRECTIONS direction = getDirection();

        Position newPosition = null;

        if (direction == DIRECTIONS.N) {
            newPosition = new Position(agent.x, agent.y- 1);
        } else if (direction == DIRECTIONS.S) {
            newPosition = new Position(agent.x, agent.y + 1);
        } else if (direction == DIRECTIONS.O) {
            newPosition = new Position(agent.x - 1, agent.y);
        } else if (direction == DIRECTIONS.L) {
            newPosition = new Position(agent.x + 1, agent.y);
        } else if (direction == DIRECTIONS.NO) {
            newPosition = new Position(agent.x - 1, agent.y - 1);
        } else if (direction == DIRECTIONS.ND) {
            newPosition = new Position(agent.x + 1, agent.y - 1);
        } else if (direction == DIRECTIONS.SO) {
            newPosition = new Position(agent.x - 1, agent.y + 1);
        } else if (direction == DIRECTIONS.SD) {
            newPosition = new Position(agent.x + 1, agent.y + 1);
        }

        return newPosition;
    }

    public Position readPositionInWorld() {
        gameController.renderWorld();

        Position position = gameController.getAgentPosition(agent);

        if (position != null)
            agent.setPosition(position);

        return position;
    }

    public Agent getAgent() {
        return agent;
    }

    public void buildPlanRTLA() {
//        cria um plano e coloca em plain
    }

    public boolean leaveFruit(Fruit fruit) {
        DECIDE_FRUIT decideFruit = DecideTheFruit.decide(fruit);
        if (decideFruit == DECIDE_FRUIT.LEAVE)
            return true;
        else if (decideFruit == DECIDE_FRUIT.LOAD || decideFruit == DECIDE_FRUIT.EAT)
            getAgent().fruits.add(fruit);

        return false;
    }

    public boolean isAlive() {
        return getAgent().health > 0;
    }

    public void spendEnergyToWalk() {
        int numFruit = getAgent().fruits.size();

        getAgent().health -= numFruit * ENERGY_EXPENDITURE.LOAD;

        getAgent().health -= ENERGY_EXPENDITURE.MOVIMENT;

    }
}
