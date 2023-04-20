package com.wordz.adapters.api;

import com.google.gson.Gson;
import com.vtence.molecule.Request;
import com.vtence.molecule.Response;
import com.vtence.molecule.WebServer;
import com.vtence.molecule.http.HttpStatus;
import com.vtence.molecule.routing.Routes;
import com.wordz.domain.Player;
import com.wordz.domain.Wordz;

import java.io.IOException;

public class WordzEndpoint {

    private final WebServer server;
    private Wordz wordz;

    public WordzEndpoint(Wordz wordz, String host, int port) {
        this.server = WebServer.create(host, port);
        this.wordz = wordz;

        try {
            server.route(new Routes() {{
                post("/start")
                        .to(request -> startGame(request));
            }});

        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }

    private Response startGame(Request request) {

        try {
            Player player = new Gson().fromJson(request.body(), Player.class);

            boolean isSuccessful = wordz.newGame(player);
            if (isSuccessful) {

                return Response
                        .of(HttpStatus.NOT_IMPLEMENTED)
                        .done();
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        throw new UnsupportedOperationException("Not implemented");
    }
}
