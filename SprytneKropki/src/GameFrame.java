import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    GameFrame(int p , int e, int f){
        this.add(new GamePanel1(p, e, f));
        this.setTitle("Sprytne Kropki");
        this.setResizable(false);
        this.setBackground(Color.white);
        this.setVisible(true);
        this.pack();
    }

    GameFrame(){
        this.add(new GamePanel1(500, 100, 100));
        this.setTitle("Sprytne Kropki");
        this.setResizable(false);
        this.setBackground(Color.white);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.pack();
    }

}
