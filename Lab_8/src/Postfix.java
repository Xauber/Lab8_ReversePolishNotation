import java.util.*;
//import java.util.Stack;

public class Postfix {

    //public Postfix postfix = new Postfix();


/*
    public double evaluate(String pfx){
        Stack<Double> stackOfCharacters = new StackAsList();
        //Stack<String> operatorStack = new StackAsList();

        for(int i = pfx.length()-1; i >= 0; i--){
        //for(int i = 0;i < pfx.length();  i++){

            //char c = pfx.charAt(i);
            double c = Character.getNumericValue(pfx.charAt(i));
            stackOfCharacters.push(c);
            //System.out.println(stackOfCharacters);
        }

        for(int i = 0; i < stackOfCharacters.getSize();  i++){
            if((stackOfCharacters.peek() == '*') || (stackOfCharacters.peek() == '/') ||
                    (stackOfCharacters.peek() == '+') || (stackOfCharacters.peek() == '-') ||
                    (stackOfCharacters.peek() == '^')) {

                //operatorStack.push(stackOfCharacters.pop().toString());
                //String op = operatorStack.pop();

                if(stack.getSize() >= 2 && pfx.charAt(i) == '+' || pfx.charAt(i) == '-' ||
                        pfx.charAt(i) == '*' || pfx.charAt(i) == '/' || pfx.charAt(i) == '^')


                double result =  calculateResult(stackOfCharacters.pop(),stackOfCharacters.pop(), op);
                stackOfCharacters.push(result);

               // System.out.println(result);
                return result;


                //1. if is operator calculate stackOfCharacters pop, pop and push result to stackOfCharacters,
                //2. while ! empty redo step 1
            }
        }

        System.out.println((double)stackOfCharacters.peek());
        return (double)stackOfCharacters.peek();

    }


    public String infixToPostfix(String infix){

    }*/

    public double evaluate(String pfx) {
        Stack<Double> stackOfCharacters = new StackAsList();
        Stack<String> operatorStack = new StackAsList();

        for (int i = pfx.length() - 1; i >= 0; i--) {

            double c = Character.getNumericValue(pfx.charAt(i));
            stackOfCharacters.push(c);
            //System.out.println(stackOfCharacters);
        }

        for (int i = 0; i < stackOfCharacters.getSize(); i++) {
            if (stackOfCharacters.getSize() >= 2 && pfx.charAt(i) == '+' || pfx.charAt(i) == '-' ||
                    pfx.charAt(i) == '*' || pfx.charAt(i) == '/' || pfx.charAt(i) == '^') {
                String op = stackOfCharacters.pop().toString();
                double result = calculateResult(stackOfCharacters.pop(), stackOfCharacters.pop(), op);
                stackOfCharacters.push(result);
            }
        }
    }







        public double calculateResult(Double A, Double B, String operator){
        if (operator == "*"){
            return A * B;
        }
        if (operator == "/"){
            return A / B;
        }
        if (operator == "+"){
            return A + B;
        }
        if (operator == "-"){
            return A - B;
        }
        if (operator == "^"){
          return Math.pow(A, B);
        }
        else return 0;
    }
}


