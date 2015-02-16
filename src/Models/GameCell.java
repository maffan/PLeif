package Models;

import java.awt.*;

/**
 * Created by Marcus on 2/16/2015.
 */
public class GameCell {
    private Point point;
    private String description;

    public GameCell(Point point, String description) {
        this.point = point;
        this.description = description;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "GameCell{" +
                "point=" + point +
                ", description='" + description + '\'' +
                '}';
    }
}
