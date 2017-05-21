package br.com.tosin.si.project.ui;

import br.com.tosin.si.project.models.Agent;
import br.com.tosin.si.project.models.ObjectInWorld;
import br.com.tosin.si.project.utils.CONST;

/**
 * Created by roger on 19/05/17.
 */
public class ShowUI {

    public static void showWorldRender(ObjectInWorld[][] matrix) {

        for (int i = 0; i < (matrix.length + 4); i++) {
            System.out.print("=");
        }
        System.out.print("\n");

        // plota matrix
        for (int i = 0; i < matrix.length; i++) {
            // index linha (valores y)
            System.out.format("%3d ", (matrix.length - i - 1));
            for (int j = 0; j < matrix[i].length; j++) {

                // i == y e j == x
                if (matrix[j][i] == null)
                    System.out.print((char) CONST.CODE_BLANK);
                else
                    System.out.print((char)matrix[j][i].code);
            }
            System.out.print("\n");
        }

        System.out.print("    ");
        for (int i = 0; i < matrix[0].length; i++) {
            int temp = i ;
            if (temp > 9)
                temp = temp -10;

            // index coluna (valores X)
            System.out.format("%1d", temp);
        }
        System.out.print("\n");

        for (int i = 0; i < (matrix.length + 4); i++) {
            System.out.print("=");
        }
        System.out.print("\n");

    }

    public static void agentHealth(Agent agent, String msg) {
        if (msg != null)
            System.out.println(msg);
        System.out.println("O agente possui " + agent.health + " de energia");
        System.out.println("O agente esta carregando " + agent.fruits.size() + " frutas");
    }

    public static void gameIsOver(String msg) {
        System.out.println("O jogo chegou ao fim!");
        System.out.println(msg);
    }
}
