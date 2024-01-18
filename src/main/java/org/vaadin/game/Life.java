package org.vaadin.game;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and use @Route
 * annotation to announce it in a URL as a Spring managed bean.
 * <p>
 * A new instance of this class is created for every new user and every browser
 * tab/window.
 * <p>
 * The main view contains a text field for getting the user name and a button
 * that shows a greeting message in a notification.
 */
@Route("life")
@CssImport("./styles/styles.css")
public class Life extends VerticalLayout {

    private static final int SIZE = 1000;
    private boolean[][] cells = new boolean[SIZE][SIZE];
    private TextArea textArea = new TextArea();
    private Timer timer = new Timer();

    public Life() {
        initGlider(1, 1);
        initLWSS(10, 10);
        initBlinker(20, 20);
        initBeacon(30, 30);

        textArea.setReadOnly(true);
        textArea.getStyle().set("font-family", "monospace");

        textArea.setSizeFull();
        add(textArea);

        // Schedule a task to advance the game by one generation every second
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                getUI().ifPresentOrElse(ui -> ui.access(() -> {
                    nextStep();
                }), () -> {timer.cancel();});
            }
        }, 1500, 100);
    }


    private void initGlider(int x, int y){
        cells[x][y+1] = true;
        cells[x+1][y+2] = true;
        cells[x+2][y] = true;
        cells[x+2][y+1] = true;
        cells[x+2][y+2] = true;
    }
    
    private void initLWSS(int x, int y){
        cells[x][y+2] = true;
        cells[x][y+3] = true;
        cells[x+1][y+1] = true;
        cells[x+1][y+3] = true;
        cells[x+2][y+3] = true;
        cells[x+3][y] = true;
        cells[x+3][y+1] = true;
        cells[x+3][y+2] = true;
        cells[x+3][y+3] = true;
    }
    
    private void initBlinker(int x, int y){
        cells[x][y+1] = true;
        cells[x+1][y+1] = true;
        cells[x+2][y+1] = true;
    }
    
    private void initBeacon(int x, int y){
        cells[x][y] = true;
        cells[x][y+1] = true;
        cells[x+1][y] = true;
        cells[x+1][y+1] = true;
        cells[x+2][y+2] = true;
        cells[x+2][y+3] = true;
        cells[x+3][y+2] = true;
        cells[x+3][y+3] = true;
    }

    private void nextStep(){
        cells = nextGeneration(cells);
        updateTextArea();
    }

    private void updateTextArea() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                sb.append(cells[i][j] ? "\u2588" : " ");
            }
            sb.append("\n");
        }
        textArea.setValue(sb.toString());
    }

    private boolean[][] nextGeneration(boolean[][] currentCells) {
        boolean[][] newCells = new boolean[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int liveNeighbors = countLiveNeighbors(currentCells, i, j);

                if (currentCells[i][j]) {
                    newCells[i][j] = liveNeighbors == 2 || liveNeighbors == 3;
                } else {
                    newCells[i][j] = liveNeighbors == 3;
                }
            }
        }

        return newCells;
    }

    private int countLiveNeighbors(boolean[][] cells, int x, int y) {
        int count = 0;

        for (int i = Math.max(0, x - 1); i <= Math.min(SIZE - 1, x + 1); i++) {
            for (int j = Math.max(0, y - 1); j <= Math.min(SIZE - 1, y + 1); j++) {
                if ((i != x || j != y) && cells[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

}
