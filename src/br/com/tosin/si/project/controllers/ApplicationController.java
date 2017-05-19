package br.com.tosin.si.project.controllers;

import br.com.tosin.si.project.models.Environment;
import br.com.tosin.si.project.ui.ShowUI;

/**
 * Created by roger on 19/05/17.
 */
public class ApplicationController {

    public void execute() {

        Environment environment = BuildMap.buildMap();

        ShowUI.showWorldRender(environment.world);
        
    }
}
