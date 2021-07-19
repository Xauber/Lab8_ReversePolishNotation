public class Runner {
    public static void main(String[] args){
        Postfix postfix = new Postfix();
        postfix.evaluate("12*3+");          //a)
        postfix.evaluate("123*+");          //b)
        postfix.evaluate("12+34-^");        //c)
        postfix.evaluate("12^34*-");        //d)
        postfix.evaluate("123*+45^^6+");    //e)
        postfix.evaluate("12+3*456-^^");    //f)
        postfix.evaluate("12+34/+5+678+*+");//g)
        postfix.evaluate("91-2-32*-1-");    //h)



    }
}
