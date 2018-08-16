package server.models;

import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Games {
    private int id;
    private String playerOne;
    private String playerTwo;
    private String gameState;
    private boolean finished;


    public static ArrayList<Games> gamess = new ArrayList<>();

    public Games(int id, String playerOne, String playerTwo, String gameState, boolean finished) {
        this.id = id;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.gameState = gameState;
        this.finished = finished;
    }

    public static int nextId() {
        int id = 0;
        for (Games g : gamess) {
            if (g.getId() > id) {
                id = g.getId();
            }
        }
        return id + 1;
    }

    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject j = new JSONObject();
        j.put("id", getId());
        j.put("playerOne", getPlayerOne());
        j.put("playerTwo", getPlayerTwo());
        j.put("gameState", getGameState());
        j.put("finished", getFinished());

        return j;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(String playerOne) {
        this.playerOne = playerOne;
    }

    public String getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(String playerTwo) {
        this.playerTwo = playerTwo;
    }

    public String getGameState() {
        return gameState;
    }

    public void setGameState(String gameState) {
        this.gameState = gameState;
    }

    public boolean getFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}