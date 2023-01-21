import java.util.Random;
import java.lang.Math;
public class Brain {
    Random random = new Random();
    PVector[] moves;
    int step = 0;

    Brain(int size){
        moves = new PVector[size];
        setRandomMoves();
    }

    void setRandomMoves(){
        for(int i = 0; i < moves.length; i++){
            float randomAngle = random.nextFloat() * 2 * (float)Math.PI;
            moves[i] = PVector.fromAngle(randomAngle);
        }
    }

    public Brain clone(){
        Brain clone = new Brain(moves.length);
        for(int i = 0; i < this.moves.length; i++){
            clone.moves[i] = moves[i].copy();
        }
        return clone;
    }

    public void mutate(){
        float mutautionRate = (float)0.001;
        for(int i = 0; i < moves.length; i++){
            float rand = random.nextFloat(1);

            if(rand < mutautionRate){
                float randomAngle = random.nextFloat() * 2 * (float)Math.PI;
                moves[i] = PVector.fromAngle(randomAngle);
            }
        }
    }
}
