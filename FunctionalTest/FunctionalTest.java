package BotPackage.FunctionalTest;
import BotPackage.Classes.Bot;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FunctionalTest {

    @Test
    public void Test1(){
        Bot testBot = new Bot(new TestFactory());
        testBot.setNameOfFile("/Users/ulya/Desktop/Bot_Git/FunctionalTest/Test1");
        testBot.run();

        boolean[] arrayTest1 = new boolean[5];
        for (int i = 0; i < 5; i++) arrayTest1[i] = false;
        testBot.getState(arrayTest1);

        boolean[] arrayExpected1 = new boolean[]
                {false, true, true, true, false};
        assertArrayEquals(arrayExpected1, arrayTest1);
    }

    @Test
    public void Test2(){
        Bot testBot = new Bot(new TestFactory());
        testBot.setNameOfFile("/Users/ulya/Desktop/Bot_Git/FunctionalTest/Test2");
        testBot.run();

        boolean[] arrayTest1 = new boolean[5];
        for (int i = 0; i < 5; i++) arrayTest1[i] = false;
        testBot.getState(arrayTest1);

        boolean[] arrayExpected1 = new boolean[]
                {false, true, true, false, true};
        assertArrayEquals(arrayExpected1, arrayTest1);
    }


    @Test
    public void Test3(){
        Bot testBot = new Bot(new TestFactory());
        testBot.setNameOfFile("/Users/ulya/Desktop/Bot_Git/FunctionalTest/Test3");
        testBot.run();

        boolean[] arrayTest1 = new boolean[5];
        for (int i = 0; i < 5; i++) arrayTest1[i] = false;
        testBot.getState(arrayTest1);

        boolean[] arrayExpected1 = new boolean[]
                {false, true, true, true, false};
        assertArrayEquals(arrayExpected1, arrayTest1);
    }


    @Test
    public void Test4(){
        Bot testBot = new Bot(new TestFactory());
        testBot.setNameOfFile("/Users/ulya/Desktop/Bot_Git/FunctionalTest/Test4");
        testBot.run();

        boolean[] arrayTest1 = new boolean[5];
        for (int i = 0; i < 5; i++) arrayTest1[i] = false;
        testBot.getState(arrayTest1);

        boolean[] arrayExpected1 = new boolean[]
                {true, false, false, false, false};
        assertArrayEquals(arrayExpected1, arrayTest1);
    }


    @Test
    public void Test5(){
        Bot testBot = new Bot(new TestFactory());
        testBot.setNameOfFile("/Users/ulya/Desktop/Bot_Git/FunctionalTest/Test5");
        testBot.run();

        boolean[] arrayTest1 = new boolean[5];
        for (int i = 0; i < 5; i++) arrayTest1[i] = false;
        testBot.getState(arrayTest1);

        boolean[] arrayExpected1 = new boolean[]
                {true, false, true, false, false};
        assertArrayEquals(arrayExpected1, arrayTest1);
    }
}
