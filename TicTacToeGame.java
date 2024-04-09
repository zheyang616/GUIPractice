import javax.swing.JButton;
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

    //constructor which has no parameters
    public TicTacToeGame() {
        //call the parent classes and pass a panel
        super("Tic Tac Toe Game");
    
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

    public boolean CheckWinner(){
        if(buttons.get(0).getText().equals(currentPlayer) && buttons.get(1).getText().equals(currentPlayer) && buttons.get(2).getText().equals(currentPlayer)){
            return true;

        }
    }
}
