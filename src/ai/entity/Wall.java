
package ai.entity;


public class Wall {

    private Integer row;
    private Integer col;
    private String direction;

    public Wall() {
    }

    public Wall(Integer row, Integer col, String direction) {
        this.row = row;
        this.col = col;
        this.direction = direction;
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

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Wall{" + "row=" + row + ", col=" + col + ", direction=" + direction + '}';
    }

}
