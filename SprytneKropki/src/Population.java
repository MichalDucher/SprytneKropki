import java.awt.*;
import java.util.Random;
public class Population extends Dot {
    Dot[] dots;
    float fitnessSum;
    int Generation = 0;
   Population(int size){
       Generation = 0;
       dots = new Dot[size];
       for(int i = 0; i < size; i++){
           dots[i] = new Dot();
       }
   }

   public void draw(Graphics g){
       for(int i = 0; i < dots.length; i++){
            dots[i].draw(g);
       }
    }

    public void move(){
        for(int i = 0; i < dots.length; i++){
            dots[i].move();
        }
    }
    void update(){
       for(int i = 0; i < dots.length; i++){
           dots[i].update();
       }
    }

    void fitnessFun(PVector finish){
        for(int i = 0; i < dots.length; i++){
            dots[i].fitnessFun(finish);
        }
    }

    void calculateFitenessSum(){
        fitnessSum = 0;
        for(int i = 0; i < dots.length; i++)
            fitnessSum += dots[i]. fitness;
    }

    boolean allDead(){
        for(int i = 0; i < dots.length; i++){
            if(!dots[i].dead && !dots[i].reachedGoal){
                return false;
            }
        }
        Generation++;
        return true;
    }

    void selection(){
        Dot[] newGen = new Dot[dots.length];
        calculateFitenessSum();

        for(int i = 0; i < newGen.length; i++){
            Dot parent = selectParent();

            newGen[i] = parent.gimmieBaby();

        }
        dots = newGen.clone();
    }

    void mutate(){
        for(int i = 0; i < dots.length; i++){
            dots[i].brain.mutate();
        }
    }

    Dot selectParent(){
       Random random = new Random();
       float rand = random.nextFloat(fitnessSum);

       float runningSum = 0;

       for(int i = 0; i < dots.length; i++){
           runningSum += dots[i].fitness;
           if( runningSum > rand ){
               return dots[i];
           }
       }
        return null;
    }

    float calculateResult(){
       return (Dot.help/ dots.length)*100;

    }
}
