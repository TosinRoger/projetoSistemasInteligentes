package br.com.tosin.si.project.models;

import br.com.tosin.si.project.utils.CONST;

import java.util.*;

/**
 * Created by roger on 19/05/17.
 */
public class Environment {
    public ObjectInWorld[][] world;
    public int width;
    public int height;

    public Environment(int width, int height) {
        this.width = width;
        this.height = height;
        this.world = new ObjectInWorld[width][height];

    }

    public void addObstacle(ObjectInWorld obstacle) {
        world[obstacle.x][obstacle.y] = obstacle;
    }

    public List<ObjectInWorld> getWalls() {
        List<ObjectInWorld> list = new ArrayList<>();

        for (ObjectInWorld item : getObjectsInWorld()) {
            if (item.code == CONST.CODE_WALL) {
                list.add(item);
            }
        }
        return list;
    }

    public Agent getAgent(Agent agent) {

        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world[i].length; j++) {
                ObjectInWorld item = world[i][j];
                if (item != null && item.code == CONST.CODE_MOBILE) {
                    if (agent == null) {
                        return (Agent) item;
                    } else {
                        if (((Agent) item).id == agent.id)
                            return (Agent) item;
                    }
                }
            }
        }
        return null;

    }

    public List<ObjectInWorld> getObjectsInWorld() {
        List<ObjectInWorld> list = new ArrayList<>();
        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world[i].length; j++) {
                if (world[i][j] != null)
                    list.add(world[i][j]);
            }
        }
        return list;
    }
}
