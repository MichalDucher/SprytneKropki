import java.awt.*;
import java.awt.Graphics;
import java.io.Serializable.*;
public class Dot {
    PVector pos;
    PVector vel;
    PVector acc;
    Brain brain;
    boolean dead = false;
    boolean reachedGoal = false;
    public static float help = 0;
    float fitness = 0;
    Dot(){
        brain = new Brain(1000);
        pos = new PVector(400, 750);
        vel = new PVector(0, 0);
        acc = new PVector(0, 0);
    }

    public void draw(Graphics g) {

        if(!reachedGoal){
            g.setColor(Color.black);
            g.fillOval((int)pos.x, (int)pos.y, 10, 10);
        }else{
            g.setColor(Color.green);
            g.fillOval((int)pos.x-5, (int)pos.y-5, 20, 20);
        }
    }
    void move() {

        if (brain.moves.length > brain.step) {
            acc = brain.moves[brain.step];
            brain.step++;
        } else
            dead = true;

        vel.add(acc);
        vel.limit(5);
        pos.add(vel);
    }

    void update(){
        if(!dead && !reachedGoal){
            move();
            if(pos.x < 1 || pos.y < 1 || pos.x > 790 || pos.y > 790)
                dead = true;
            else if(this.pos.distance(new PVector(400, 20)) < 1){
                help++;
                reachedGoal = true;
            }
        }
    }

    void fitnessFun(PVector finish){
        float dist = this.pos.distance(finish);
        fitness = 1/(dist*dist) + 1/(this.brain.step);
    }


    Dot gimmieBaby(){
        Dot baby = new Dot();
        baby.brain = brain.clone();
        return baby;
    }
}
