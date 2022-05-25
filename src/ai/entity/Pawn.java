
package ai.entity;

public class Pawn {

    private Integer row;
    private Integer col;
    private String name;

    public Pawn() {
    }

    public Pawn(Integer row, Integer col, String name) {
        this.row = row;
        this.col = col;
        this.name = name;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getCol() {
        return col;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pawn{" + "row=" + row + ", col=" + col + ", Name=" + name + '}';
    }

}