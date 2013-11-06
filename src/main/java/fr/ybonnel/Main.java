package fr.ybonnel;

import fr.ybonnel.model.PlayerInfo;
import fr.ybonnel.services.BattleService;
import fr.ybonnel.simpleweb4j.exception.HttpErrorException;
import fr.ybonnel.simpleweb4j.handlers.Response;
import fr.ybonnel.simpleweb4j.handlers.Route;
import fr.ybonnel.simpleweb4j.handlers.RouteParameters;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static fr.ybonnel.simpleweb4j.SimpleWeb4j.*;

/**
 * Main class.
 */
public class Main {


    private static BattleService battleService = new BattleService();

    /**
     * Start the server.
     * @param port http port to listen.
     * @param waitStop true to wait the stop.
     */
    public static void startServer(int port, boolean waitStop) throws IOException {

        // Set the http port.
        setPort(port);
        // Set the path to static resources.
        setPublicResourcesPath("/fr/ybonnel/public");

        get(new Route<Void, List<PlayerInfo>>("/battle/:pseudo1/:pseudo2", Void.class) {

            @Override
            public Response<List<PlayerInfo>> handle(Void param, RouteParameters routeParams) throws HttpErrorException {
                String pseudo1 = routeParams.getParam("pseudo1");
                String pseudo2 = routeParams.getParam("pseudo2");
                if (pseudo1 == null || pseudo2 == null || pseudo1.equals(pseudo2)) {
                    throw new HttpErrorException(HttpServletResponse.SC_BAD_REQUEST);
                }
                return new Response<>(battleService.getPlayersInfo(pseudo1, pseudo2));

            }
        });

        get(new Route<Void, List<String>>("pseudos", Void.class) {

            @Override
            public Response<List<String>> handle(Void param, RouteParameters routeParams) throws HttpErrorException {
                return new Response<>(battleService.getPseudos());
            }
        });

        // Start the server.
        start(waitStop);
    }

    /**
     * @return port to use
     */
    private static int getPort() {
        // Heroku
        String herokuPort = System.getenv("PORT");
        if (herokuPort != null) {
            return Integer.parseInt(herokuPort);
        }

        // Cloudbees
        String cloudbeesPort = System.getProperty("app.port");
        if (cloudbeesPort != null) {
            return Integer.parseInt(cloudbeesPort);
        }

        // Default port;
        return 10000;
    }

    public static void main(String[] args) throws IOException {
        // For main, we want to wait the stop.
        startServer(getPort(), true);
    }
}
