package br.com.tosin.si.project.interfaces;

import br.com.tosin.si.project.models.ObjectInWorld;
import br.com.tosin.si.project.models.Position;

/**
 * Created by roger on 19/05/17.
 */
public interface PhysicsInterface {
    boolean moveTo(ObjectInWorld[][] world, Position oldPos, Position newPos);
    boolean nextMoveIsTarget(ObjectInWorld[][] world, Position oldPos, Position newPos);
}
