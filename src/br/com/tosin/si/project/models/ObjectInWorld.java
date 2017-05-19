package br.com.tosin.si.project.models;

/**
 * Created by roger on 19/05/17.
 */
public class ObjectInWorld extends Position {
    public int code = 0;

    public ObjectInWorld(int x, int y, int code) {
        super(x, y);
        // TODO Auto-generated constructor stub
        this.code = code;

    }

    public Position getPosition() {
        Position pos = new Position(x, y);
        return pos;
    }
}
