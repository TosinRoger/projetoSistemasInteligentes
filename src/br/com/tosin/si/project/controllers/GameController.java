package br.com.tosin.si.project.controllers;

import br.com.tosin.si.project.models.*;
import br.com.tosin.si.project.ui.InteractClientUser;
import br.com.tosin.si.project.ui.ShowUI;

/**
 * Created by roger on 19/05/17.
 */
public class GameController {
    private ApplicationController application;
    private AgentController agentController;
    private EnvironmentController environmentController;


    public void playGame(Environment environment, Agent agent) {
        environmentController = new EnvironmentController(this, environment);
        agentController = new AgentController(this, agent);

        // agente precisa contruir o plano
//        agentController.buildPlanLRTA();

        boolean gaming = true;
        boolean agentWin = false;
        boolean agentDead = false;

        while (gaming) {
            /*
                agente diz qual e o movimento
                verifica no mapa se pode move
                se SIM
                    pega fruita da posicao a ser movida
                    pergurta para o agente que vai fazer com a fruta
                    move o agente
                se NAO
                    diz para o agente que nao pode mexer
             */
            ShowUI.agentHealth(agentController.getAgent(), "Inicio rodada == fim rodada");
            agentController.reason();
            ShowUI.agentHealth(agentController.getAgent(), "depois de pensar");

            Position nextPosition = agentController.moveTo();
            if (environmentController.canMove(nextPosition, agentController.getAgent())) {
                if (environmentController.isTarget(agentController.getAgent().getPosition(), nextPosition)) {
                    gaming = false;
                    agentWin = true;
                }

                Fruit fruit = environmentController.getFruitNextMove(nextPosition);
                if (agentController.leaveFruit(fruit)) {

                } else {
                    environmentController.removeFruit(fruit);
                }
                if (agentController.isAlive()) {
                    agentController.spendEnergyToWalk();
                    environmentController.updateEnvironment(nextPosition, agent);
                }

                // confere se o agente esta vivo depois de andar
                if (!agentController.isAlive()) {
                    gaming = false;
                    agentDead = true;
                }


                // adiciona a fruta quando o agente se mover caso ele tenha deixado na interacao anterior

            }
            InteractClientUser.confirmNextMove();
        }
        if (agentDead)
            ShowUI.gameIsOver("O agente morreu );");
        else if (agentWin)
            ShowUI.gameIsOver("O agente venceu \\o/");
        else
            ShowUI.gameIsOver("O jogo foi finalizado!");
    }

    public Position getAgentPosition(Agent agent) {
        return environmentController.getPosition(agent);
    }

    public void renderWorld() {
        ShowUI.showWorldRender(environmentController.getWorld());
    }

    public ObjectInWorld[][] getWorld() {
        return environmentController.getWorld();
    }
}
