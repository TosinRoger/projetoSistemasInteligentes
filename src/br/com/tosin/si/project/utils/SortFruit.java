package br.com.tosin.si.project.utils;

import br.com.tosin.si.project.models.Fruit;

import java.util.Comparator;

/**
 * Created by roger on 19/05/17.
 */
public class SortFruit implements Comparator<Fruit> {
    @Override
    public int compare(Fruit fruit, Fruit t1) {
        if (fruit == null || t1 == null)
             return 0;
        if (fruit.getEnergy() > t1.getEnergy())
            return 1;
        else if (fruit.getEnergy() < t1.getEnergy())
            return -1;
        else
            return 0;
    }
}
