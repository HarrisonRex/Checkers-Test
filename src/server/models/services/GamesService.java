package server.models.services;

import server.Console;
import server.DatabaseConnection;
import server.models.Games;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GamesService {

    public static String selectAllInto(List<Games> targetList) {
        targetList.clear();
        try {
            PreparedStatement statement = DatabaseConnection.newStatement(
                    "SELECT id, playerOne, playerTwo, gameState, finished FROM games"
            );
            if (statement != null) {
                ResultSet results = statement.executeQuery();
                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Games(results.getInt("id"), results.getString("playerOne"), results.getString("playerTwo"), results.getString("gameState"), results.getBoolean("finished")));


                    }
                }
            }
        } catch (SQLException resultsException) {
            String error = "Database error - can't select all from 'games' table: " + resultsException.getMessage();

            Console.log(error);
            return error;
        }
        return "OK";
    }

    public static Games selectById(int id) {
        Games result = null;
        try {
            PreparedStatement statement = DatabaseConnection.newStatement(
                    "SELECT id, playerOne, playerTwo, gameState, finished FROM games WHERE id = ?"
            );
            if (statement != null) {
                statement.setInt(1, id);
                ResultSet results = statement.executeQuery();
                if (results != null && results.next()) {
                    result = new Games(results.getInt("id"), results.getString("playerOne"), results.getString("playerTwo"), results.getString("gameState"), results.getBoolean("finished"));


                }
            }
        } catch (SQLException resultsException) {
            String error = "Database error - can't select by id from 'games' table: " + resultsException.getMessage();

            Console.log(error);
        }
        return result;
    }

    public static String insert(Games itemToSave) {
        try {
            PreparedStatement statement = DatabaseConnection.newStatement(
                    "INSERT INTO games (id, playerOne, playerTwo, gameState, finished) VALUES (?, ?, ?, ?, ?)"
            );
            statement.setInt(1, itemToSave.getId());
            statement.setString(2, itemToSave.getPlayerOne());
            statement.setString(3, itemToSave.getPlayerTwo());
            statement.setString(4, itemToSave.getGameState());
            statement.setBoolean(5, itemToSave.getFinished());





            statement.executeUpdate();
            return "OK";
        } catch (SQLException resultsException) {
            String error = "Database error - can't insert into 'games' table: " + resultsException.getMessage();

            Console.log(error);
            return error;
        }
    }

    public static String update(Games itemToSave) {
        try {
            PreparedStatement statement = DatabaseConnection.newStatement(
                    "UPDATE games SET playerOne = ?, playerTwo = ?, gameState = ?, finished = ? WHERE id = ?"
            );
            statement.setString(1, itemToSave.getPlayerOne());
            statement.setString(2, itemToSave.getPlayerTwo());
            statement.setString(3, itemToSave.getGameState());
            statement.setBoolean(4, itemToSave.getFinished());





            statement.setInt(5, itemToSave.getId());
            statement.executeUpdate();
            return "OK";
        } catch (SQLException resultsException) {
            String error = "Database error - can't update 'games' table: " + resultsException.getMessage();

            Console.log(error);
            return error;
        }
    }

    public static String deleteById(int id) {
        try {
            PreparedStatement statement = DatabaseConnection.newStatement(
                    "DELETE FROM games WHERE id = ?"
            );
            statement.setInt(1, id);
            statement.executeUpdate();
            return "OK";
        } catch (SQLException resultsException) {
            String error = "Database error - can't delete by id from 'games' table: " + resultsException.getMessage();

            Console.log(error);
            return error;
        }
    }

}