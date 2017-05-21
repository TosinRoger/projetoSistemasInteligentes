package br.com.tosin.si.project.controllers;

import br.com.tosin.si.project.algorithms.ApplyLRTA;
import br.com.tosin.si.project.algorithms.DecideTheFruit;
import br.com.tosin.si.project.constants.DECIDE_FRUIT;
import br.com.tosin.si.project.constants.DIRECTIONS;
import br.com.tosin.si.project.constants.ENERGY_EXPENDITURE;
import br.com.tosin.si.project.models.Agent;
import br.com.tosin.si.project.models.Fruit;
import br.com.tosin.si.project.models.Position;
import br.com.tosin.si.project.ui.InteractClientUser;
import br.com.tosin.si.project.utils.SortFruit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by roger on 19/05/17.
 */
public class AgentController {

    private GameController gameController;
    private Agent agent;
    private ApplyLRTA lrta;

    public AgentController(GameController gameController, Agent agent) {
        this.gameController = gameController;
        this.agent = agent;
        this.lrta = new ApplyLRTA();
        this.lrta.configDefaultCust(gameController.getWorld());
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
        if (getAgent().health > 600)
            getAgent().health = 600;

        readPositionInWorld();
        buildPlanLRTA();
    }

    private DIRECTIONS getDirection(){
        // se tem um plano executa o plano,
        // senao pergunta para o usuario
        if (!getAgent().plans.isEmpty()) {
            return getAgent().plans.remove(0);
        }

        DIRECTIONS direction = InteractClientUser.getDirection();

        return direction;
    }

    public Position moveTo() {

        readPositionInWorld();

        // GET DIRECTION BY USER IN CONSOLE
        DIRECTIONS direction = getDirection();

        Position newPosition = null;

        if (direction == DIRECTIONS.N) {
            newPosition = new Position(getAgent().x, getAgent().y- 1);
        } else if (direction == DIRECTIONS.S) {
            newPosition = new Position(getAgent().x, getAgent().y + 1);
        } else if (direction == DIRECTIONS.O) {
            newPosition = new Position(getAgent().x - 1, getAgent().y);
        } else if (direction == DIRECTIONS.L) {
            newPosition = new Position(getAgent().x + 1, getAgent().y);
        } else if (direction == DIRECTIONS.NO) {
            newPosition = new Position(getAgent().x - 1, getAgent().y - 1);
        } else if (direction == DIRECTIONS.ND) {
            newPosition = new Position(getAgent().x + 1, getAgent().y - 1);
        } else if (direction == DIRECTIONS.SO) {
            newPosition = new Position(getAgent().x - 1, getAgent().y + 1);
        } else if (direction == DIRECTIONS.SD) {
            newPosition = new Position(getAgent().x + 1, getAgent().y + 1);
        }

        return newPosition;
    }

    public Position readPositionInWorld() {
        gameController.renderWorld();

        Position position = gameController.getAgentPosition(getAgent());

        if (position != null)
            getAgent().setPosition(position);

        return position;
    }

    public Agent getAgent() {
        return agent;
    }

    public void buildPlanLRTA() {
//        cria um plano e coloca em plain
        if (getAgent().plans == null) {
            getAgent().plans = new ArrayList<>();
        }

        DIRECTIONS d = lrta.findNextPosition(getAgent().getPosition());

        if (d != null)
            getAgent().plans.add(d);
    }

    public boolean leaveFruit(Fruit fruit) {
        if (fruit == null)
            return true;
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
