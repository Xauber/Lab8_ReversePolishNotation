
import org.junit.Test;
import static org.junit.Assert.*;


public class TestPostfixEvaluation {

//@author Muhammad & Ben
//

    //Test Calc
    @Test
    public void testA() {
        Postfix postfix = new Postfix();
      double output =  postfix.evaluate("12*3+"); //checked
        assertEquals(5, output);
    }

    @Test
    public void testB() {
        Postfix postfix = new Postfix();
        double output =  postfix.evaluate("123*+"); //checked
        assertEquals(7, output);
    }

    @Test
    public void testC() {
        Postfix postfix = new Postfix();
        double output =  postfix.evaluate("12+34^-"); //checked
        assertEquals(-78, output);
    }

    @Test
    public void testD() {
        Postfix postfix = new Postfix();
        double output =  postfix.evaluate("12^34*-"); //checked
        assertEquals(-11, output);
    }

    @Test
    public void testE() {
        Postfix postfix = new Postfix();
        double output =  postfix.evaluate("123*+45^-6+"); //checked
        assertEquals(-1011, output);
    }

    @Test
    public void testF() {
        Postfix postfix = new Postfix();
        double output =   postfix.evaluate("12+3*456-^+"); //checked
        assertEquals(9.25,output);
    }

    @Test
    public void testG() {
        Postfix postfix = new Postfix();
        double output =  postfix.evaluate("12+34/+5+678+*+"); //checked
        assertEquals(98.75, output);
    }

    @Test
    public void testH() {
        Postfix postfix = new Postfix();
        double output =   postfix.evaluate("91-2-32*-1-"); //checked
        assertEquals(-1, output);
    }



}
