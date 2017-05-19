package br.com.tosin.si.project.algorithms;

import br.com.tosin.si.project.constants.*;
import br.com.tosin.si.project.models.Fruit;

/**
 * Created by roger on 19/05/17.
 */
public class CalculateEnergyFruit {

    public static int calculate(Fruit fruit) {
        if (fruit.lipidios == LIPIDIOS.ALTA || fruit.lipidios == LIPIDIOS.MODERADA) {
            if (fruit.carboidratos == CARBOIDRATOS.ALTA || fruit.carboidratos == CARBOIDRATOS.MODERADA) {
                if (fruit.madrureza == MADRUREZA.VERDE)
                    return ENERGY_FRUITS.MIDDLE;
                if (fruit.madrureza == MADRUREZA.MADRURO)
                    return ENERGY_FRUITS.HIGH;
                if (fruit.madrureza == MADRUREZA.PODRE)
                    return ENERGY_FRUITS.LOW;
            }
            if (fruit.carboidratos == CARBOIDRATOS.POUCA) {
                if (fruit.madrureza == MADRUREZA.VERDE || fruit.madrureza == MADRUREZA.PODRE)
                    return ENERGY_FRUITS.LOW;
                if (fruit.madrureza == MADRUREZA.MADRURO)
                    return ENERGY_FRUITS.MIDDLE;
            }
        }

        if (fruit.lipidios == LIPIDIOS.POUCA) {
            if (fruit.carboidratos == CARBOIDRATOS.ALTA || fruit.carboidratos == CARBOIDRATOS.MODERADA) {
                if (fruit.madrureza == MADRUREZA.VERDE || fruit.madrureza == MADRUREZA.PODRE)
                    return ENERGY_FRUITS.LOW;
                if (fruit.madrureza == MADRUREZA.MADRURO)
                    return ENERGY_FRUITS.HIGH;
            }
            if (fruit.carboidratos == CARBOIDRATOS.POUCA) {
                if (fruit.proteinas == PROTEINAS.ALTA && fruit.fibras == FIBRAS.ALTA && fruit.madrureza != MADRUREZA.PODRE)
                    return ENERGY_FRUITS.MIDDLE;
            }
        }

        return ENERGY_FRUITS.LOW;
    }
}
