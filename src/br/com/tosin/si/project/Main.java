package br.com.tosin.si.project;

import br.com.tosin.si.project.controllers.ApplicationController;

/**
 * Created by roger on 19/05/17.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("CODE START!!!");

        ApplicationController application = new ApplicationController();
        application.execute();
    }

}
