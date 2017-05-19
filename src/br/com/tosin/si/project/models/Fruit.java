package br.com.tosin.si.project.models;

import br.com.tosin.si.project.algorithms.CalculateEnergyFruit;
import br.com.tosin.si.project.constants.*;
import br.com.tosin.si.project.utils.CONST;

import java.util.Random;

/**
 * Created by roger on 19/05/17.
 */
public class Fruit extends ObjectInWorld {

    public long id;

    public Fruit(int x, int y) {
        super(x, y, CONST.CODE_FRUIT);
        this.id = (long)new Random().nextInt(1000);
    }

    public MADRUREZA madrureza;
    public CARBOIDRATOS carboidratos;
    public FIBRAS fibras;
    public PROTEINAS proteinas;
    public LIPIDIOS lipidios;
    private int energy;

    public int getEnergy() {
        energy = CalculateEnergyFruit.calculate(this);
        return energy;
    }
}
