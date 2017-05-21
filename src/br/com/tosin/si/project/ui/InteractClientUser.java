package br.com.tosin.si.project.ui;

import br.com.tosin.si.project.constants.DIRECTIONS;
import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.Scanner;

/**
 * Created by roger on 19/05/17.
 */
public class InteractClientUser {

    public static DIRECTIONS getDirection() {
        String direction = "";

        printDirections();

        while (direction.isEmpty()) {
            System.out.println("Enter the direction to move the agent: ");

            Scanner scanner = new Scanner(System.in);
            String result = scanner.nextLine();

            result = result.toUpperCase();


//            if (isPlan(result))
//                direction = result;
//            else if (isDirection(result))
            if (isDirection(result))
                direction = result;
            else
                System.out.println("The direction is wrong!");

        }

        return DIRECTIONS.getDiretionByString(direction);
    }

    private static void printDirections() {
        System.out.println(
                "The direction is:" + "\n" +
                        DIRECTIONS.N + " north" + " - " +
                        DIRECTIONS.S + " south" + " - " +
                        DIRECTIONS.L + " west" + " - " +
                        DIRECTIONS.O + " east" + " - " +
                        DIRECTIONS.NO + " northeast" + " - " +
                        DIRECTIONS.ND + " northweast" + " - " +
                        DIRECTIONS.SO + " south weast" + " - " +
                        DIRECTIONS.SD + " southeast" + "\n"
        );
    }

    private static boolean isDirection(String result) {
        if (result.equals(String.valueOf(DIRECTIONS.N)))
            return true;
        else if (result.equals(String.valueOf(DIRECTIONS.S)))
            return true;
        else if (result.equals(String.valueOf(DIRECTIONS.L)))
            return true;
        else if (result.equals(String.valueOf(DIRECTIONS.O)))
            return true;
        else if (result.equals(String.valueOf(DIRECTIONS.NO)))
            return true;
        else if (result.equals(String.valueOf(DIRECTIONS.ND)))
            return true;
        else if (result.equals(String.valueOf(DIRECTIONS.SO)))
            return true;
        else if (result.equals(String.valueOf(DIRECTIONS.SD)))
            return true;
        return false;
    }

    private static boolean isPlan(String result) {
        result = result.toUpperCase();
        if (result.equals("PLAN"))
            return true;
        else
            return false;
    }

    public static void confirmNextMove() {
        Scanner scanner = new Scanner(System.in);
        String readString = scanner.nextLine();
    }
}
