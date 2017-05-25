package br.com.tosin.si.project.ui;

import br.com.tosin.si.project.algorithms.DecideTheFruit;
import br.com.tosin.si.project.constants.*;
import br.com.tosin.si.project.models.Fruit;

import java.io.*;

/**
 * Created by roger on 24/05/17.
 */
public class FileManager {

    public static final String FILE_NAME_WEKA = "data_game_fruit.arff";

    public static void saveDataToWeka(Fruit fruit, int health) {
        String data = openFile(FILE_NAME_WEKA);
        String temp = parseDataToWeka(fruit, health);

        if (data == null || data.isEmpty()) {
            data = defaultHeaderWeka();
            data += temp;
        }
        else
            data = temp;

        BufferedWriter writer = null;
        try {
            FileWriter fileWriter = new FileWriter(FILE_NAME_WEKA, true);
            writer = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(writer);
            printWriter.print(data);
            printWriter.close();
//            writer.write(data);
//            writer.close();

        } catch (IOException e) {
        } finally {
            try {
                if (writer != null)
                    writer.close();
            } catch (IOException e) {
            }
        }
    }

    public static String openFile(String fileName) {
        String result = "";
        String line;
        BufferedReader in;

        try {
            File file = new File(fileName);
            if(file.exists() ) {
                in = new BufferedReader(new FileReader(file));
                line = in.readLine();

                while (line != null) {
                    line = in.readLine();
                    if (line != null)
                        result += line + "\n";
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    private static String defaultHeaderWeka() {
        String data = "";
        data += "@relation eat_or_load" + "\n\n";

        data += "@attribute carboidratos    {" + CARBOIDRATOS.POUCA + ", " + CARBOIDRATOS.MODERADA + ", " + CARBOIDRATOS.ALTA + "}" + "\n";
        data += "@attribute fibra	        {" + ", " + FIBRAS.POUCA + ", " + FIBRAS.MODERADA + ", " + FIBRAS.ALTA + "}" + "\n";
        data += "@attribute lipidios	    {" + LIPIDIOS.POUCA + ", " + LIPIDIOS.MODERADA + ", " + LIPIDIOS.ALTA+  "}" + "\n";
        data += "@attribute madureza	    {" + MADRUREZA.VERDE + ", " + MADRUREZA.MADRURO + ", " + MADRUREZA.PODRE + "}" + "\n";
        data += "@attribute proteinas	    {" + PROTEINAS.POUCA + ", " + PROTEINAS.MODERADA + ", " + PROTEINAS.ALTA + "}" + "\n";
        data += "@attribute energy_fruit	{" + ENERGY_FRUITS.LOW + ", " + ENERGY_FRUITS.MIDDLE + ", " + ENERGY_FRUITS.HIGH + "}" + "\n";
        data += "@attribute health	        { 0a200, 200a400, 400a600 }" + "\n";
        data += "@attribute decide          {" + DECIDE_FRUIT.EAT + ", " + DECIDE_FRUIT.LOAD + ", " + DECIDE_FRUIT.LEAVE + "}" + "\n\n";

        data += "@data" + "\n";

        return data;
    }

    private static String parseDataToWeka(Fruit fruit, int health) {
        String data = "";

        data += fruit.carboidratos + ", ";
        data += fruit.fibras + ", ";
        data += fruit.lipidios + ", ";
        data += fruit.madrureza + ", ";
        data += fruit.proteinas + ", ";
        data += fruit.getEnergy() + ", ";
        if (health < 200)
            data += String.valueOf("0a200") + ", ";
        else if (health >= 200 && health < 400)
            data += String.valueOf("200a400") + ", ";
        else
            data += String.valueOf("400a600") + ", ";

        data += DecideTheFruit.decideEatFruit(health, fruit);
        data += "\n";

        return data;
    }

}
