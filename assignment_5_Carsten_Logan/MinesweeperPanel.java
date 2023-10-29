import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.SwingUtilities;
import javax.swing.JButton;

public class MinesweeperPanel extends JPanel {

    private static final int ROWS = 10;
    private static final int COLUMNS = 10;
    private  int numMines;
    private static final int MINE = -1;
    private JButton [][] buttons;

    private int [][] mines;
    private int counter = 0;


    public MinesweeperPanel(int numMines) {

        this.numMines = numMines;

        setLayout(new GridLayout(ROWS, COLUMNS));
        buttons = new JButton[ROWS][COLUMNS];

        for(int i = 0; i< ROWS; i++){
            for(int j = 0; j < COLUMNS; j++){
                JButton button = new JButton("?");
                button.addMouseListener(new MouseHandler(i,j));
                buttons[i][j] = button;
                add(button);
            }
        }
        placeMines();
    }

    private void placeMines(){
        int mine= 0;
        mines = new int [ROWS][COLUMNS];
        Random r = new Random();

        while(mine < numMines) {
            int row = r.nextInt(ROWS);
            int column = r.nextInt(COLUMNS);
            if(mines[row][column] != MINE){
                mines[row][column] = MINE;
                mine++;
            }

        }
    }

    private int adjacentMines(int row, int column) {
        int count = 0;
        if (row >= 1 && row < 9 && column >= 1 && column < 9){
            for (int i = row - 1; i <= row + 1; i++) {
                for (int j = column - 1; j <= column + 1; j++) {
                    if (mines[i][j] == MINE) {
                        count++;
                    }
                }
            }
        } else if(row == 0 && column == 0){
            for (int i = row; i <= row + 1; i++) {
                for (int j = column; j <= column + 1; j++) {
                    if (mines[i][j] == MINE) {
                        count++;
                    }
                }
            }
        } else if(row == 0 && column == 9 ){
            for (int i = row; i <= row + 1; i++) {
                for (int j = column-1; j <= column; j++) {
                    if (mines[i][j] == MINE) {
                        count++;
                    }
                }
            }

        } else if(row > 0 && row < 9 && column == 9){
            for (int i = row-1; i <= row; i++) {
                for (int j = column-1; j <= column; j++) {
                    if (mines[i][j] == MINE) {
                        count++;
                    }
                }
            }

        } else if(row == 9 && column == 0){
            for (int i = row+1; i <= row; i++) {
                for (int j = column; j <= column+1; j++) {
                    if (mines[i][j] == MINE) {
                        count++;
                    }
                }
            }

        } else if(row == 9 && column == 9){
            for (int i = row-1; i <= row; i++) {
                for (int j = column-1; j <= column; j++) {
                    if (mines[i][j] == MINE) {
                        count++;
                    }
                }
            }

        } else if(row > 0 && row < 9 && column == 0){
            for (int i = row-1; i <= row+1; i++) {
                for (int j = column; j <= column+1; j++) {
                    if (mines[i][j] == MINE) {
                        count++;
                    }
                }
            }

        } else if(row == 9 && column > 0 && column < 9){
            for (int i = row-1; i <= row; i++) {
                for (int j = column-1; j <= column+1; j++) {
                    if (mines[i][j] == MINE) {
                        count++;
                    }
                }
            }

        }
        return count;
    }

    private boolean mineCheck(int row, int column){
        boolean mineCheck;
        if(mines[row][column] == -1){
            mineCheck = true;
        } else {
            mineCheck = false;
        }
        return mineCheck;
    }


    private class MouseHandler extends MouseAdapter {
        private int row;
        private int column;

        public MouseHandler(int row, int column){
            this.row = row;
            this.column = column;
        }

        public void mouseClicked(MouseEvent e){
            if(SwingUtilities.isLeftMouseButton(e)){
                if(buttons[row][column].getText() != "?"){
                    return;
                }
                if(mineCheck(clickedX(e),clickedY(e))== true){
                    JOptionPane.showMessageDialog(MinesweeperPanel.this, "Blown up! Darn, Game Over!");
                    System.exit(0);
                } else {
                    revealCell(clickedX(e),clickedY(e), adjacentMines(clickedX(e),clickedY(e)));
                    counter++;
                    if(victory()== true){
                        JOptionPane.showMessageDialog(MinesweeperPanel.this, "HOORAY!! VICTORY!!");
                        System.exit(0);
                    }
                }
            } else if(SwingUtilities.isRightMouseButton(e)){
                flag(clickedX(e),clickedY(e));
            }
        }

        public int clickedX(MouseEvent e){
            JButton button = (JButton) e.getSource();
            for(int i = 0; i < ROWS; i++){
                for(int j = 0; j<COLUMNS; j++){
                    if(buttons[i][j] == button){
                        return i;
                    }
                }
            }
            return 0;
        }

        public int clickedY(MouseEvent e){
            JButton button = (JButton) e.getSource();
            for(int i = 0; i < ROWS; i++){
                for(int j = 0; j<COLUMNS; j++){
                    if(buttons[i][j] == button){
                        return j;
                    }
                }
            }
            return 0;
        }
    }

    private void revealCell(int x, int y, int z) {
        JButton button = buttons[x][y];
        int numMines = z;
        button.setText(Integer.toString(numMines));
    }

    public void flag(int row, int column){

        JButton button = buttons[row][column];
        button.setText("F");

    }

    public boolean victory(){
        boolean victory;
        if(counter == (100- numMines)){
            victory = true;
        } else {
            victory = false;
        }
        return victory;
    }

  
}


