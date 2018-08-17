package server.controllers;

import server.Console;
import server.models.Games;
import server.models.services.GamesService;
import server.models.services.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;

@Path("games/")
public class GamesController {
    @POST
    @Path("new")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String newGames(@CookieParam("sessionToken") Cookie sessionCookie){
        String currentUsername = UserService.validateSessionCookie(sessionCookie);
        if (currentUsername == null) return "Error: Invalid user session token";

        Console.log("Ping from " + currentUsername);

        GamesService.selectAllInto(Games.games);
        int gameId = Games.nextId();

        Games newGames = new Games(gameId, )

    }
}