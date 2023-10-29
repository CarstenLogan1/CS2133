import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class MinesweeperFrame extends JFrame {

private JPanel panel;
    public MinesweeperFrame(){
        setTitle("Minesweeper!");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        setSize(screenSize.width/2, screenSize.height/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);


        JMenuItem newMenuItem = new JMenuItem("New");
        newMenuItem.addActionListener(new NewMenuItemListener());
        fileMenu.add(newMenuItem);

        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener(new SaveMenuItemListener());
        fileMenu.add(saveMenuItem);


        JMenuItem loadMenuItem = new JMenuItem("Load");
        loadMenuItem.addActionListener(new LoadMenuItemListener());
        fileMenu.add(loadMenuItem);

        JMenuItem quitMenuItem = new JMenuItem("Quit");
        quitMenuItem.addActionListener(new QuitMenuItemListener());
        fileMenu.add(quitMenuItem);



        panel = new MinesweeperPanel(15);
        add(panel);
        setVisible(true);
    }

    private class NewMenuItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object[] options = {"Easy", "Medium", "Hard"};
            int difficulty = JOptionPane.showOptionDialog(MinesweeperFrame.this,
                    "Select difficulty level", "New Game", 0,
                    3, null, options, options[2]);
            int numMines = 0;
            if (difficulty == 0) {
                numMines = 15;
            }
            if (difficulty == 1){
                numMines = 30;
            }
            if(difficulty == 2){
                    numMines = 45;
            }
            remove(panel);
            panel = new MinesweeperPanel(numMines);
            add(panel);
            validate();
        }
    }

    private class SaveMenuItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            int valid = fileChooser.showSaveDialog(MinesweeperFrame.this);
            if (valid == JFileChooser.APPROVE_OPTION) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(fileChooser.getSelectedFile());
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                    objectOutputStream.writeObject(panel);
                    objectOutputStream.close();
                    fileOutputStream.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }

    private class LoadMenuItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            int valid = fileChooser.showOpenDialog(MinesweeperFrame.this);
            if (valid == JFileChooser.APPROVE_OPTION) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(fileChooser.getSelectedFile());
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                    Object o = objectInputStream.readObject();
                    if (o instanceof MinesweeperPanel) {
                        MinesweeperPanel loadedPanel = (MinesweeperPanel) o;
                        remove(panel);
                        panel = loadedPanel;
                        add(panel);
                        validate();
                        repaint();
                    } else {
                        JOptionPane.showMessageDialog(MinesweeperFrame.this, "The selected file is not a Minesweeper game.");
                    }
                    objectInputStream.close();
                    fileInputStream.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private class QuitMenuItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            System.exit(0);
        }
    }

}
