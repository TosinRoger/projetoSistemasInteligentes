package br.com.tosin.si.project.generators;

import br.com.tosin.si.project.constants.*;
import br.com.tosin.si.project.models.Environment;
import br.com.tosin.si.project.models.Fruit;
import br.com.tosin.si.project.models.ObjectInWorld;

import java.util.Random;

/**
 * Created by roger on 19/05/17.
 */
public class ProducesFruits {

    public static Environment producesFruits(Environment environment) {

        ObjectInWorld[][] world = environment.world;

        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world[i].length; j++) {
                if (world[i][j] == null) {
                    world[i][j] = produceFruit(i, j);
                }
            }
        }

        return environment;
    }

    private static Fruit produceFruit(int x, int y) {
        Random random = new Random();
        Fruit fruit = new Fruit(x, y);

//        CARBOIDRATOS
        int rand = random.nextInt(3);
        if (rand == 0) {
            fruit.carboidratos = CARBOIDRATOS.ALTA;
        }
        else if (rand == 1) {
            fruit.carboidratos = CARBOIDRATOS.MODERADA;
        }
        else if (rand == 2) {
            fruit.carboidratos = CARBOIDRATOS.POUCA;
        }

//        FIBRAS
        rand = random.nextInt(3);
        if (rand == 0) {
            fruit.fibras = FIBRAS.ALTA;
        }
        else if (rand == 1) {
            fruit.fibras = FIBRAS.MODERADA;
        }
        else if (rand == 2) {
            fruit.fibras = FIBRAS.POUCA;
        }

//        LIPIDIOS
        rand = random.nextInt(3);
        if (rand == 0) {
            fruit.lipidios = LIPIDIOS.ALTA;
        }
        else if (rand == 1) {
            fruit.lipidios = LIPIDIOS.MODERADA;
        }
        else if (rand == 2) {
            fruit.lipidios = LIPIDIOS.POUCA;
        }

//        MADRUREZA
        rand = random.nextInt(3);
        if (rand == 0) {
            fruit.madrureza = MADRUREZA.VERDE;
        }
        else if (rand == 1) {
            fruit.madrureza = MADRUREZA.MADRURO;
        }
        else if (rand == 2) {
            fruit.madrureza = MADRUREZA.PODRE;
        }

//        PROTEINAS
        rand = random.nextInt(3);
        if (rand == 0) {
            fruit.proteinas = PROTEINAS.ALTA;
        }
        else if (rand == 1) {
            fruit.proteinas = PROTEINAS.MODERADA;
        }
        else if (rand == 2) {
            fruit.proteinas = PROTEINAS.POUCA;
        }

        fruit.getEnergy();

        return fruit;
    }
}
