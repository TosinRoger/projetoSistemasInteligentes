package br.com.tosin.si.project.models;

/**
 * Created by roger on 21/05/17.
 */
public class Statitcs {

    public int totalGame;
    public int gameWon;
    public int playerDied;

    public Statitcs() {
        this.totalGame = 0;
        this.gameWon = 0;
        this.playerDied = 0;
    }

    public void addGameWon() {
        totalGame++;
        gameWon++;
    }

    public void addPlayDied() {
        totalGame++;
        playerDied++;
    }
}
