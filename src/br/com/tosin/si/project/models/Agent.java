package br.com.tosin.si.project.models;

import br.com.tosin.si.project.constants.DIRECTIONS;
import br.com.tosin.si.project.constants.ENERGY_EXPENDITURE;
import br.com.tosin.si.project.utils.CONST;

import java.util.*;

/**
 * Created by roger on 19/05/17.
 */
public class Agent extends ObjectInWorld {

    public long id;
    public List<DIRECTIONS> plans = new ArrayList<>();
    public List<Fruit> fruits = new ArrayList<>();
    public int health;

    public Agent(int x, int y) {
        super(x, y, CONST.CODE_MOBILE);
        this.id = (long)new Random().nextInt(1000);
        health = ENERGY_EXPENDITURE.INITIAL_ENERGY_AGENT;
    }

    public void setPosition(Position pos){
        x = pos.x;
        y = pos.y;
    }

}
