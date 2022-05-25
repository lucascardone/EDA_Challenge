package connection;

import ai.implement.AI;
import ai.implement.ActionWall;
import ai.entity.Board;
import ai.entity.Pawn;
import ai.entity.Wall;
import connection.constants.Constant;
import utils.Event;
import java.net.URI;
import java.net.URISyntaxException;
import models.Message;
import utils.Util;


public final class Connection {

    private WebSocketClient clientEndPoint;

    private String url;

    public Connection() throws URISyntaxException {
        setURL();
        start();
    }

    private void setURL() {
        url = Constant.ROOT.concat(Constant.TOKEN);
    }

    public String getUrl() {
        return url;
    }

    public void start() throws URISyntaxException {

        try {

            clientEndPoint = new WebSocketClient(new URI(url));
            clientEndPoint.addMessageHandler((String msj) -> {
                Message message = Util.JSONToObject(msj);
                
                // Accept Challenge
                
                if (msj.contains(Event.CHALLENGE.getString())) {
                    System.out.println("CONECTADO 1.");
                    System.out.println("EVENT: " + message.getEvent());
                    System.out.println("DATA: \n"
                            + "opponent: " + message.getData().getOpponent() + "\n"
                            + "challenge_id: " + message.getData().getChallenge_id());

                    clientEndPoint.sendMessage(Util.acceptChallenge(message.getData().getChallenge_id()));
                } else {
                    System.out.println("...1");
                }
                
                // Turn
                
                if (msj.contains(Event.YOUR_TURN.getString())) {
                    showData(message);
                    sendBestAction(message);
                } else {
                    System.out.println("...2");
                }

                // Gameover
                
                if (msj.contains(Event.GAMEOVER.getString())) {
                    System.out.println("GAMEOVER");
                } else {
                    System.out.println("...3");
                }

                if (msj.contains("users")) {
                    System.out.println(msj);
                }
            });

            while (true) {
                Thread.sleep(1000);
            }

        } catch (InterruptedException ex) {
            System.err.println("InterruptedException exception: " + ex.getMessage());
        } catch (URISyntaxException ex) {
            System.err.println("URISyntaxException exception: " + ex.getMessage());
        }
    }

    public void showData(Message message) {
        System.out.println("CONECTADO 2.");

        System.out.println("EVENT: " + message.getEvent());
        System.out.println("DATA: " + "\n"
                + "player_2: " + message.getData().getPlayer_2() + "\n"
                + "player_1: " + message.getData().getPlayer_1() + "\n"
                + "score_2: " + message.getData().getScore_2() + "\n"
                + "walls: " + message.getData().getWalls() + "\n"
                + "score_1: " + message.getData().getScore_1() + "\n"
                + "side: " + message.getData().getSide() + "\n"
                + "remaining_moves: " + message.getData().getRemaining_moves() + "\n"
                + "turn token: " + message.getData().getTurn_token() + "\n"
                + "game_id: " + message.getData().getGame_id() + "\n");

        int counter = 0;
        char[][] m = new char[17][17];
        for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 17; j++) {
                m[i][j] = message.getData().getBoard().charAt(counter);
                counter++;
                System.out.print("[" + m[i][j] + "]");
            }
            System.out.println("");
        }
    }

    public void sendBestAction(Message message) {
        AI ai = new AI();
        ActionWall actionWall = new ActionWall();
        Wall wall = new Wall();
        Board board = new Board(message.getData().getBoard());
        int[] movement;
        if (message.getData().getSide().equalsIgnoreCase("N")) {
            Pawn pawn = ai.northAnalyzeSouth(board.getBoard());
            if (pawn.getRow() <= 8) {
                wall = actionWall.southStalkerWall(board.getBoard(), pawn, wall);
                if (wall.getRow() == null) {
                    movement = ai.choose(message.getData().getSide(), board);
                    clientEndPoint.sendMessage(Util.move(message, movement[0], movement[1], movement[2], movement[3]));
                } else if(message.getData().getWalls() > 1){
                    wall.setRow((wall.getRow() - 1) / 2);
                    wall.setCol((wall.getCol() - 1) / 2);
                    clientEndPoint.sendMessage(Util.wall(message, wall.getRow(), wall.getCol(), wall.getDirection()));
                }else{
                    movement = ai.choose(message.getData().getSide(), board);
                    clientEndPoint.sendMessage(Util.move(message, movement[0], movement[1], movement[2], movement[3]));
                }
            } else {
                movement = ai.choose(message.getData().getSide(), board);
                clientEndPoint.sendMessage(Util.move(message, movement[0], movement[1], movement[2], movement[3]));
            }
        } else {
            Pawn pawn = ai.southAnalyzeNorth(board.getBoard());
            if (pawn.getRow() >= 8) {
                wall = actionWall.northStalkerWall(board.getBoard(), pawn, wall);
                if (wall.getRow() == null) {
                    movement = ai.choose(message.getData().getSide(), board);
                    clientEndPoint.sendMessage(Util.move(message, movement[0], movement[1], movement[2], movement[3]));
                } else if(message.getData().getWalls() > 1){
                    wall.setRow((wall.getRow() - 1) / 2);
                    wall.setCol((wall.getCol() - 1) / 2);
                    clientEndPoint.sendMessage(Util.wall(message, wall.getRow(), wall.getCol(), wall.getDirection()));
                }else{
                    movement = ai.choose(message.getData().getSide(), board);
                    clientEndPoint.sendMessage(Util.move(message, movement[0], movement[1], movement[2], movement[3]));
                }
            } else {
                movement = ai.choose(message.getData().getSide(), board);
                clientEndPoint.sendMessage(Util.move(message, movement[0], movement[1], movement[2], movement[3]));
            }
        }
    }
}