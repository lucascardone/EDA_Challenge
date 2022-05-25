
package models;

import java.util.List;
import lombok.Data;

@Data
public class DataMessage {

    private String opponent;
    private String challenge_id;
    private String game_id;
    private String player_1;
    private String player_2;
    private String score_1;
    private String score_2;
    private String side;
    private String board;
    private Integer remaining_moves;
    private String turn_token;

    private List<String> users;

    private Integer from_row;
    private Integer from_col;
    private Integer to_row;
    private Integer to_col;

    //wall
    private Integer walls;
    private Integer row;
    private Integer col;
    private String orientation;
}
