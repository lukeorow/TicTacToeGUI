import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacToe extends Application {

    private static final int BOARD_SIZE = 3;
    private Button[][] buttons = new Button[BOARD_SIZE][BOARD_SIZE];
    private int turn = 1;

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane = new GridPane();
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                Button button = new Button();
                button.setPrefSize(100, 100);
                button.setOnAction(event -> {
                    if (button.getText().isEmpty()) {
                        if (turn % 2 == 1) {
                            button.setText("X");
                        } else {
                            button.setText("O");
                        }
                        turn++;
                        checkForWin();
                    }
                });
                buttons[i][j] = button;
                gridPane.add(button, j, i);
            }
        }

        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void checkForWin() {
        String winner = "";
        // Check rows
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (buttons[i][0].getText().equals(buttons[i][1].getText())
                    && buttons[i][1].getText().equals(buttons[i][2].getText())
                    && !buttons[i][0].getText().isEmpty()) {
                winner = buttons[i][0].getText();
            }
        }

        // Check columns
        for (int j = 0; j < BOARD_SIZE; j++) {
            if (buttons[0][j].getText().equals(buttons[1][j].getText())
                    && buttons[1][j].getText().equals(buttons[2][j].getText())
                    && !buttons[0][j].getText().isEmpty()) {
                winner = buttons[0][j].getText();
            }
        }

        // Check diagonals
        if (buttons[0][0].getText().equals(buttons[1][1].getText())
                && buttons[1][1].getText().equals(buttons[2][2].getText())
                && !buttons[0][0].getText().isEmpty()) {
            winner = buttons[0][0].getText();
        }

        if (buttons[0][2].getText().equals(buttons[1][1].getText())
                && buttons[1][1].getText().equals(buttons[2][0].getText())
                && !buttons[0][2].getText().isEmpty()) {
            winner = buttons[0][2].getText();
        }

        if (!winner.isEmpty()) {
            System.out.println(winner + " wins!");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
