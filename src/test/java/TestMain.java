
import Games.DrunkMan.DrunkMan;
public class TestMain {
  public static void main(String[] args){
    for (long i=0; i < 1000; i++) {
      DrunkMan dm = new DrunkMan();
      dm.startPlay();
      dm.setSeed(i);
      int countStep = 0;
      long startTime = System.currentTimeMillis();
      while (dm.getState()) {
        dm.play();
        countStep += 1;
        if (System.currentTimeMillis() - startTime > 500) {
          break;
        }
      }
      if (countStep < 100)
        System.out.println(Long.toString(i) + "  " + Integer.toString(countStep));
    }
  }
}
