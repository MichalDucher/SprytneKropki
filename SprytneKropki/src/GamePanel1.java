import javax.swing.*;
import java.awt.*;

public class GamePanel1 extends JPanel{

    JLabel epochsLabel = new JLabel();
    JLabel resultLabel1 = new JLabel();
    JLabel resultLabel2 = new JLabel();
    static final int SCREEN_WIDTH = 800;
    static final int SCREEN_HEIGHT = 800;
    int FPS;
    int DELAY;
    PVector finish = new PVector(SCREEN_WIDTH/2,20);
    int populationSize;
    int epochs;
    Population test;
    public GamePanel1(int p, int e, int f){
        epochsLabel.setBounds(660,0,200,60);
        resultLabel1.setBounds(360,250,200,200);
        resultLabel2.setBounds(660,15,240,60);

        epochsLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        resultLabel1.setFont(new Font("Serif", Font.PLAIN, 50));
        resultLabel2.setFont(new Font("Serif", Font.PLAIN, 14));


        epochsLabel.setText("Epoka 0");
        resultLabel1.setText("");
        resultLabel2.setText("Skuteczność 0%");

        this.add(epochsLabel);
        this.add(resultLabel1);
        this.add(resultLabel2);
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.white);
        this.setFocusable(true);
        this.setVisible(true);
        this.setLayout(null);

        FPS = f;
        DELAY = 1000 / FPS;
        populationSize = p;
        epochs = e;
        test = new Population(populationSize);
        startGameLoop();
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        test.draw(g);
        g.setColor(Color.blue);
        g.fillOval((int)finish.x, (int)finish.y, 10, 10);
    }

    private void updateGameState() {
        test.update();
    }

    private void startGameLoop() {
        new Thread(() -> {
            while (true) {
                updateGameState();

                if(test.allDead()){
                    test.fitnessFun(finish);
                    test.selection();
                    test.mutate();
                    epochsLabel.setText("Epoka " + test.Generation);
                    resultLabel2.setText("Skuetczność " + test.calculateResult() + "%");
                    if(epochs > test.Generation)
                        Dot.help = 0;
                }
                repaint();
                try {
                    Thread.sleep(DELAY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(test.Generation == epochs) {
                    resultLabel1.setText(test.calculateResult() + "%");
                    break;
                }


            }
        }).start();
    }
}
