import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class TicTacToeGame extends MyJFrame{

    JPanel jPanel; //we want this to be accessible throughout the class
    ArrayList<JButton> buttons = new ArrayList<JButton>();
    int ROWS = 3, COLUMNS = 3;
    String currentPlayer = "x";
    Font font;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem resetGameItem;

    //constructor which has no parameters
    public TicTacToeGame() {
        //call the parent classes and pass a panel
        super("Tic Tac Toe Game");

        menuBar = new JMenuBar();//create the menu bar
        menu = new JMenu("Game Options");//create the menu
        resetGameItem = new JMenuItem("Reset Game");//create the menu item
        resetGameItem.addActionListener(e -> ResetGame());


        menu.add(resetGameItem);//add the menu item to the menu
        menuBar.add(menu);// add the menu to the menu bar
        setJMenuBar((menuBar));//add the menu bar to the JFrame
    
        jPanel = new JPanel(); // needs to be instantiated

        // jPanel.setLayout(new BorderLayout());
        // jPanel.add(new JButton("OK"), BorderLayout.CENTER);
        // jPanel.add(new JButton("Cancel"), BorderLayout.SOUTH);
        jPanel.setLayout(new GridLayout(ROWS , COLUMNS));
        
        font = new Font(Font.SERIF, Font.BOLD, 100);

        for(int i = 0; i < ROWS * COLUMNS; i++){
            JButton btn = new JButton();
            btn.addActionListener(event -> ButtonCLicked(event));
            //SET THE FONT on the BUTTON
            btn.setFont(font);
            buttons.add(btn);
            jPanel.add(btn);
        }

        setContentPane(jPanel);
        setVisible(true);
    }
    public void ResetGame(){
        currentPlayer = "x";
        for (int i = 0; i < buttons.size(); i++) {
            JButton btn = buttons.get(i);
            btn.setText("");
            btn.setBackground(null);
            btn.setEnabled(true);
        }
    }

    public void ButtonCLicked(ActionEvent event){

        JButton btnClicked = (JButton)event.getSource();
        btnClicked.setText(currentPlayer);
        btnClicked.setEnabled(false);

        if (currentPlayer == "x") {
            btnClicked.setBackground(Color.RED);
            currentPlayer = "o";
            //Do something
        }else{
            btnClicked.setBackground(Color.GREEN);
            currentPlayer = "x";
            //do something else
        }
    }

    public boolean CheckWinner() {
        
        
        JOptionPane.showMessageDialog(null, currentPlayer + " has won the game!");
        
        // first row
        if(buttons.get(0).getText().equals(currentPlayer) && buttons.get(1).getText().equals(currentPlayer) &&
                buttons.get(2).getText().equals(currentPlayer)) {
            return true;
        }

        // second row
        if(buttons.get(3).getText().equals(currentPlayer) && buttons.get(4).getText().equals(currentPlayer) &&
                buttons.get(5).getText().equals(currentPlayer)) {
            return true;
        }
        
        // third row
        if(buttons.get(6).getText().equals(currentPlayer) && buttons.get(7).getText().equals(currentPlayer) &&
                buttons.get(8).getText().equals(currentPlayer)) {
            return true;
        }

        // diagonal 1
        if(buttons.get(0).getText().equals(currentPlayer) && buttons.get(4).getText().equals(currentPlayer) &&
                buttons.get(8).getText().equals(currentPlayer)) {
            return true;
        }
        
        // diagonal 2
        if(buttons.get(2).getText().equals(currentPlayer) && buttons.get(4).getText().equals(currentPlayer) &&
                buttons.get(6).getText().equals(currentPlayer)) {
            return true;
        }
        
        // column 1 
        if(buttons.get(0).getText().equals(currentPlayer) && buttons.get(3).getText().equals(currentPlayer) &&
                buttons.get(6).getText().equals(currentPlayer)) {
            return true;
        }
        
        // column 2
        if(buttons.get(1).getText().equals(currentPlayer) && buttons.get(4).getText().equals(currentPlayer) &&
                buttons.get(7).getText().equals(currentPlayer)) {
            return true;
        }
        
        // column 3
        if(buttons.get(2).getText().equals(currentPlayer) && buttons.get(5).getText().equals(currentPlayer) &&
        buttons.get(8).getText().equals(currentPlayer)) {
            return true;
        }  
            
        
        return false;
    }
}
