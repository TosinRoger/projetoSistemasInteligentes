package br.com.tosin.si.project.controllers;

import br.com.tosin.si.project.generators.BuildMap;
import br.com.tosin.si.project.generators.ProducesFruits;
import br.com.tosin.si.project.models.Agent;
import br.com.tosin.si.project.models.Environment;
import br.com.tosin.si.project.ui.ShowUI;

/**
 * Created by roger on 19/05/17.
 */
public class ApplicationController {

    public void execute() {

        // controi cenario
        Environment environment = BuildMap.buildMap();
        ShowUI.showWorldRender(environment.world);

        Agent agent = new Agent(8, 0);

        environment.addObstacle(agent);

        GameController gameController = new GameController();

        // gerar as frutas de acordo com a logica do projeto
        environment = ProducesFruits.producesFruits(environment);
        ShowUI.showWorldRender(environment.world);

        // inicia o jogo
        gameController.playGame(environment, agent);

    }

}
