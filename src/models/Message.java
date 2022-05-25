
package models;

import lombok.Data;


@Data
public class Message {

    private String action;
    private String event;
    private DataMessage data;
}
