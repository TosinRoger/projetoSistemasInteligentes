package br.com.tosin.si.project.algorithms;

import br.com.tosin.si.project.constants.DECIDE_FRUIT;
import br.com.tosin.si.project.constants.ENERGY_EXPENDITURE;
import br.com.tosin.si.project.constants.ENERGY_FRUITS;
import br.com.tosin.si.project.models.Fruit;

/**
 * Created by roger on 19/05/17.
 */
public class DecideTheFruit {

    /**
     * Aqui deve ser implementado a logica do ID3
     * @param fruit
     * @return
     */
    public static DECIDE_FRUIT decide(Fruit fruit) {
        if (fruit.getEnergy() <= ENERGY_EXPENDITURE.EAT)
            return DECIDE_FRUIT.LEAVE;
        else if (fruit.getEnergy() > ENERGY_EXPENDITURE.EAT && fruit.getEnergy() < (ENERGY_EXPENDITURE.MAX_ENERGY_AGENT - ENERGY_FRUITS.HIGH))
            return DECIDE_FRUIT.EAT;
        else
            return DECIDE_FRUIT.LOAD;
    }

    /**
     * Metodo que decide sobre comer ou carregar a fruta, sem o ID3
     * @param health
     * @param fruit
     * @return
     */
    public static DECIDE_FRUIT decideEatFruit(int health, Fruit fruit) {
        if (health < 200) {
            return DECIDE_FRUIT.EAT;
        }
        else {
            return DECIDE_FRUIT.LOAD;
        }
    }
}
