package br.com.tosin.si.project.models;

import br.com.tosin.si.project.utils.CONST;

import java.util.*;

/**
 * Created by roger on 19/05/17.
 */
public class Agent extends ObjectInWorld {

    public long id;
    public List<String> plans = new ArrayList<>();

    public Agent(int x, int y) {
        super(x, y, CONST.CODE_MOBILE);
        this.id = (long)new Random().nextInt(1000);
    }

    public void setPosition(Position pos){
        x = pos.x;
        y = pos.y;
    }
}
