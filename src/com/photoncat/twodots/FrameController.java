package com.photoncat.twodots;

import com.sun.javafx.scene.paint.GradientUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.*;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * A controller for the frame.
 */
public class FrameController {
    @FXML Path painter;
    @FXML GridPane root;
    private LineTo lineEnd = null;

    public FrameController() {
    }

    private void initializePainter() {
        painter.getElements().clear();
        painter.getElements().add(new MoveTo(0, 0));
        painter.getElements().add(new LineTo(root.getWidth(), 0));
        painter.getElements().add(new LineTo(root.getWidth(), root.getHeight()));
        painter.getElements().add(new LineTo(0, root.getHeight()));
        painter.getElements().add(new LineTo(0, 0));
    }

    public void onMouseDragged(MouseEvent mouseEvent) {
        if (lineEnd != null) {
            lineEnd.setX(mouseEvent.getX());
            lineEnd.setY(mouseEvent.getY());
        }
    }

    public void onMousePressed(MouseEvent mouseEvent) {
        lineEnd = new LineTo(mouseEvent.getX(), mouseEvent.getY());

        painter.getElements().add(new MoveTo(mouseEvent.getX(), mouseEvent.getY()));
        painter.getElements().add(lineEnd);
    }

    public void onMouseReleased(MouseEvent mouseEvent) {
        initializePainter();
        lineEnd = null;
    }
}
