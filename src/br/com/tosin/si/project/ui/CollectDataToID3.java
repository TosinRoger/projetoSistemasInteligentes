package br.com.tosin.si.project.ui;

import br.com.tosin.si.project.models.Fruit;

/**
 * Created by roger on 24/05/17.
 */
public class CollectDataToID3 {

    public static void collect(Fruit fruit, int health) {
        FileManager.saveDataToWeka(fruit, health);
    }
}
