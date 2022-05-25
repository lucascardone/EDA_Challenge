package utils;

public enum Event {
    
    CHALLENGE("challenge"), YOUR_TURN("your_turn"), GAMEOVER("gameover");

    private final String string;

    Event(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}