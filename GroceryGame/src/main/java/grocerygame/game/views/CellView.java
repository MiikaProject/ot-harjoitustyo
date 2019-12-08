package grocerygame.game.views;

import grocerygame.game.models.Cell;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

//CellView turns Cell into actual rendeable javafx object. Color of the 
//cell is based on the type of the cell.
public class CellView {

    private Cell cell;

    public CellView(Cell cell) {
        this.cell = cell;
    }

    public Node cellImage() {

        String type = cell.getType();

        if (type.equals("O")) {
            Rectangle cell = new Rectangle(10, 10);
            cell.setFill(Color.ANTIQUEWHITE);
            return cell;
        } else if (type.equals("S")) {
            Rectangle cell = new Rectangle(10, 10);
            cell.setFill(Color.AQUA);
            return cell;
        } else if (type.equals("M")) {
            Rectangle cell = new Rectangle(10, 10);
            cell.setFill(Color.BURLYWOOD);
            return cell;
        } else if (type.equals("P")) {
            Rectangle cell = new Rectangle(10, 10);
            cell.setFill(Color.BLUEVIOLET);
            return cell;
        } else if (type.equals("B")) {
            Rectangle cell = new Rectangle(10, 10);
            cell.setFill(Color.YELLOW);
            return cell;
        } else if (type.equals("F")) {
            Rectangle cell = new Rectangle(10, 10);
            cell.setFill(Color.GREEN);
            return cell;
        } else if (type.equals("R")) {
            Rectangle cell = new Rectangle(10, 10);
            cell.setFill(Color.DARKORANGE);
            return cell;
        } else if (type.equals("C")) {
            Rectangle cell = new Rectangle(10, 10);
            cell.setFill(Color.BLACK);
            return cell;
        } else if (type.equals("E")) {
            Rectangle cell = new Rectangle(10, 10);
            cell.setFill(Color.LIGHTCORAL);
            return cell;
        } else if (type.equals("V")) {
            Rectangle cell = new Rectangle(10, 10);
            cell.setFill(Color.GREENYELLOW);
            return cell;
        } else if (type.equals("D")) {
            Rectangle cell = new Rectangle(10, 10);
            cell.setFill(Color.AQUAMARINE);
            return cell;
        } else if (type.equals("ME")) {
            Rectangle cell = new Rectangle(10, 10);
            cell.setFill(Color.CADETBLUE);
            return cell;
        } else if (type.equals("FI")) {
            Rectangle cell = new Rectangle(10, 10);
            cell.setFill(Color.LIGHTSEAGREEN);
            return cell;
        } else if (type.equals("H")) {
            Rectangle cell = new Rectangle(10, 10);
            cell.setFill(Color.GREENYELLOW);
            return cell;
        }

        return null;
    }

}
