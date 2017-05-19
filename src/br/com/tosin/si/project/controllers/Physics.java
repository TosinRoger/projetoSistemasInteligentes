package br.com.tosin.si.project.controllers;

import br.com.tosin.si.project.interfaces.PhysicsInterface;
import br.com.tosin.si.project.models.Fruit;
import br.com.tosin.si.project.models.ObjectInWorld;
import br.com.tosin.si.project.models.Position;
import br.com.tosin.si.project.utils.CONST;

/**
 * Created by roger on 19/05/17.
 */
public class Physics implements PhysicsInterface {
    @Override
    public boolean moveTo(ObjectInWorld[][] world, Position oldPos, Position newPos) {
        if (newPos.x >= 0 && newPos.x < world.length && newPos.y >= 0 && newPos.y < world[0].length) {
            if (world[newPos.x][newPos.y] == null || world[newPos.x][newPos.y] instanceof Fruit) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }

    }

    @Override
    public boolean nextMoveIsTarget(ObjectInWorld[][] world, Position oldPos, Position newPos) {
        if (newPos.x >= 0 && newPos.x < world.length && newPos.y >= 0 && newPos.y < world[0].length) {
            ObjectInWorld objectInWorld = world[newPos.x][newPos.y];
            if (objectInWorld == null) {
                return false;
            }
            else {
                if (objectInWorld.code == CONST.CODE_TARGET)
                    return true;
            }
        }
        return false;
    }
}
