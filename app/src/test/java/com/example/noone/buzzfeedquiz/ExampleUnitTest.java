package com.example.noone.buzzfeedquiz;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testQuestions() {
        Questions test = new Questions("Question 1");
        assertEquals("Question 1", test.question);
    }

    @Test
    public void testReadQuestions(){
        Questions [] test = Questions.getQuestions();
        Questions [] actual = {
                new Questions("What do you like to do on your free time?"),
                new Questions("If you could go anywhere in the world, where would you go?"),
                new Questions("What kind of super powers would you like?"),
                new Questions("What kind of pet do you want?"),
                new Questions("What kind of food do you like to eat?")
        };
        for(int i = 0; i < test.length; i ++) {
            assertEquals(test[i], actual[i]);
        }
    }

    @Test
    public void testReadQuestionFalse(){
        Questions test = new Questions("What do you like to do on your free time?");
        assertNotEquals(test, "");
    }

    @Test
    public void testPrintQuestions() {

        for (int i = 0; i < 5; i++) {
            Questions.printQuestions(Questions.getQuestions(), i);
        }
    }

    @Test
    public void testPrintAnswers(){

        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 4; j++)
                Answers.printAnswers(Answers.getAnswers(), i, j);
    }

    @Test
    public void testCheck() {
        boolean trueResult = Answers.check("A");
        boolean falseResult = Answers.check("V");
        boolean finalResult = Answers.check("a");

        assertTrue(trueResult);
        assertTrue(finalResult);
        assertFalse(falseResult);
    }

    @Test
    public void testParse() {
        String [] results = {"a", "A", "b", "B", "c", "C", "d", "D"};
        int [] Tally = Answers.parse(results);
        int [] actual = {2, 2, 2, 2};

        for(int i = 0; i < Tally.length; i ++) {
            assertEquals(Tally[i], actual[i]);
        }
    }

    @Test
    public void testTotal(){
        int [] Test = {0,1,2,3};
        int index = Answers.total(Test);
        assertEquals(index, 3);

        int [] Test2 = {1,1,2,2};
        int index2 = Answers.total(Test2);
        assertTrue(Answers.Tie);

    }

    @Test
    public void testPrintResults() {
        String res = Answers.getResults(true, 0);
        System.out.println(res);

        for (int i = 0; i < 4; i++) {
            res = Answers.getResults(false, i);
            System.out.println(res);
        }
    }
}
