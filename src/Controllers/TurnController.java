package Controllers;

import Models.Entity;

import java.util.LinkedList;

/**
 * Created by Marcus on 2/4/2015.
 */
public class TurnController {
    private LinkedList<Entity> entities;

    public LinkedList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(LinkedList<Entity> entities) {
        this.entities = entities;
    }

    public TurnController(LinkedList<Entity> entities) {

        this.entities = entities;
    }

    public TurnController() {

    }

    public void nextTurn(){

    }
}
