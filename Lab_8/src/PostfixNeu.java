import java.lang.Math;

public class Postfix
{
    static Stack<Double> stack = new StackasList();

    static Stack<Character> stackChar = new StackasList(); // Aufgabe 4

    public static double evaluate (String pfx)
    {
        for(int i = 0;i < pfx.length();  i++)
        {
            if(pfx.charAt(i) != '+' && pfx.charAt(i) != '-' &&
               pfx.charAt(i) != '*' && pfx.charAt(i) != '/' && pfx.charAt(i) != '^')
            {
                double number = Character.getNumericValue(pfx.charAt(i));
                stack.push(number);
            }
            if(stack.getSize() >= 2 && pfx.charAt(i) == '+' || pfx.charAt(i) == '-' ||
                    pfx.charAt(i) == '*' || pfx.charAt(i) == '/' || pfx.charAt(i) == '^')
            {
                double result;
                switch (pfx.charAt(i))
                {
                    case '+' -> {
                        result = stack.pop() + stack.pop();
                        stack.push(result);
                    }
                    case '-' -> {
                        double a = stack.pop();
                        double b = stack.pop();
                        result = b - a;
                        stack.push(result);
                    }
                    case '*' -> {
                        result = stack.pop() * stack.pop();
                        stack.push(result);
                    }
                    case '/' -> {
                        double a = stack.pop();
                        double b = stack.pop();
                        result = b / a;
                        stack.push(result);
                    }
                    case '^' -> {
                        double a = stack.pop();
                        double b = stack.pop();
                        result = Math.pow(b,a);
                        stack.push(result);
                    }
                }
            }
        }
        return stack.pop();
    }












     public static String infixToPostfix (String ifx) //"1 + 2 + 3 / 4 + 5 + 6 * ( 7 + 8 )"
    {
        char ch ;
        String result="";
        for (int i =0; i<ifx.length() ;i++)
        {
            if(ifx.charAt(i) == ' ' )
                continue;
            else if(isOperator(ifx.charAt(i)) )
            {
                while (stackChar.isEmpty() == false && isOperatorHighPriority(ifx.charAt(i)) && stackChar.peek() != '(')
                {
                    result = result + stackChar.pop();
                }
                stackChar.push(ifx.charAt(i));
                ch = stackChar.peek();
                System.out.println(result); ////////
            }
            else if(isOperand(ifx.charAt(i)))
            {
                result = result + ifx.charAt(i);
                System.out.println(result); /////////
            }
            else if(ifx.charAt(i) == '(')
            {
                stackChar.push(ifx.charAt(i));
                System.out.println(result);/////////
            }
            else if(ifx.charAt(i) == ')')
            {
                while (stackChar.isEmpty() == false && stackChar.peek() !='(')
                {
                    result = result + stackChar.pop();
                }
                stackChar.pop();
                System.out.println(result);///////
            }
        }
        System.out.println(result);//////////
        while (!stackChar.isEmpty())
        {
            result = result + stackChar.pop();
        }
        System.out.println(result);//////////

        return result;
    }


    private static boolean isOperatorHighPriority(char operator)
    {
        int topElementInStack = getOperatorWeight(stackChar.peek()); //^  w=3
        int op = getOperatorWeight(operator); //^ w =3

        if ( topElementInStack == op)
        {
            if(op == 3)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        else if(topElementInStack > op)
        {
            return true;
        }
        else
        {
            return false;
        }


            /*
        if((stackChar.peek() =='+' || stackChar.peek() =='+' && operator == '*' || operator == '/') ||
           (stackChar.peek() == '*' || stackChar.peek() == '/' && operator == '^' ))
        {
            return true; //stackChar.push(operator);
        }
        else
        {
            return false;
        }*/
    }



    private static boolean isOperand(char c)
    {
        if(c >= '0' && c <= '9')
            return true;
        return false;
    }

    private static boolean isOperator(char c)
    {
        if(c == '+' || c == '-' || c == '*' || c == '/' || c == '^')
            return true;
        return false;
    }
/*
    private static boolean isRightAssociative(char operator)
    {
        if (operator == '^') {
            return true;
        }
        return false;
    }
*/
    private static int getOperatorWeight(char operator)
    {
        int weight = 0;
        switch(operator)
        {
            case '+':
                weight = 1;
            case '-':
                weight = 1;
            case '*':
                weight = 2;
            case '/':
                weight = 2;
            case '^':
                weight = 3;
        }
        return weight;
    }


    public static void main(String[] args)
    {
        infixToPostfix("1 + 2 + 3 / 4 + 5 + 6 * ( 7 + 8 )");


    }




}
