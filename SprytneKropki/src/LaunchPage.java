import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchPage implements ActionListener {
    JFrame frame = new JFrame();
    JButton startButton = new JButton("START");
    JTextField populationSizeTextField = new JTextField();
    JTextField epochsTextField = new JTextField();
    JTextField fpsTextField = new JTextField();
    JLabel pLabel = new JLabel();
    JLabel eLabel = new JLabel();
    JLabel fLabel = new JLabel();

    JLabel label = new JLabel();
    public int epochs;
    public int population;
    public int fps;
    LaunchPage(){

        startButton.setBounds(10,180,100,30);
        populationSizeTextField.setBounds(10,10,100,30);
        epochsTextField.setBounds(10,60,100,30);
        fpsTextField.setBounds(10, 110, 100, 30);
        label.setBounds(150, 10, 200, 200);
        label.setIcon(new ImageIcon("oldWiseTree.jpg"));

        pLabel.setBounds(10, 30, 130, 30);
        pLabel.setText("Rozmiar populacji");

        eLabel.setBounds(10, 80, 100, 30);
        eLabel.setText("Ilość epok");

        fLabel.setBounds(10, 130, 100, 30);
        fLabel.setText("FPS");

        startButton.setFocusable(false);
        startButton.addActionListener(this);

        frame.add(pLabel);
        frame.add(eLabel);
        frame.add(fLabel);
        frame.add(label);
        frame.add(fpsTextField);
        frame.add(populationSizeTextField);
        frame.add(epochsTextField);
        frame.add(startButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(370,250);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);

        pLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        eLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        fLabel.setFont(new Font("Serif", Font.PLAIN, 14));
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == startButton){
            try{
                epochs = Integer.parseInt(epochsTextField.getText());
                population = Integer.parseInt(populationSizeTextField.getText());
                fps = Integer.parseInt(fpsTextField.getText());
            new GameFrame(population, epochs, fps);
            }catch(NumberFormatException n){
                System.out.println("Niepoprawne dane! ");
            }



        }
    }

//    boolean tryParse(String s){
//        try(Integer.parseInt(s)){
//            return true;
//        }catch(Exception ex){
//            return false;
//        }
//    }
}
