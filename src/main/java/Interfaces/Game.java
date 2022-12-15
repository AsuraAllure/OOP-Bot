package Interfaces;

public interface Game {
  public void startPlay();
  public void setSeed(long a);
  public boolean getState();
  public String play(String input);
  public void refresh();

}
