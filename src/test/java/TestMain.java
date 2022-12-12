
import Games.DrunkMan.DrunkMan;
import java.time.Clock;
public class TestMain {
  public static void main(String[] args){
    DrunkMan dm = new DrunkMan();
    for(long i = 0; i < 1000; i++){
    dm.startPlay();
    dm.setSeed(i);
    int countStep = 0;
    long startTime = System.currentTimeMillis();
    while(dm.getState()) {
        dm.play();
        countStep +=1;
        if (System.currentTimeMillis() - startTime > 5000) {
          break;
        }
    }

      if (countStep < 100)
        System.out.println(Integer.toString(countStep) + "    " +  Long.toString(i));
    }
  }
}
