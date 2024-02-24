import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);


        ArrayList<Double> allResult = new ArrayList<>();
        double num1, num2, num3, result = 0;


        while(true){

            int operation = 0;
            while(operation<1 || operation>10){
                System.out.println("Enter 1 to addition the numbers");
                System.out.println("Enter 2 to subtraction the numbers");
                System.out.println("enter 3 to multiplication the numbers");
                System.out.println("enter 4 to division the numbers");
                System.out.println("enter 5 to modulus the numbers");
                System.out.println("enter 6 to find minimum number");
                System.out.println("enter 7 to find maximum number");
                System.out.println("enter 8 to find the average of numbers");
                System.out.println("enter 9 to print the last result in calculator");
                System.out.println("enter 10 to print the list of all result in calculator");
                try{
                    operation = Integer.parseInt(String.valueOf(s.next()));
                }catch(NumberFormatException e){
                    System.out.println("please choose a valid option");
                    System.out.println("----------------------------------------------");
                    continue;
                }
                if(operation<1 || operation>10){
                    System.out.println("please choose a valid option");
                    System.out.println("----------------------------------------------");
                }
            }

            switch (operation){
                case 1:
                    try{
                        System.out.println("enter the first number");
                        num1 = s.nextDouble();
                        System.out.println("enter the second number");
                        num2 = s.nextDouble();
                        System.out.println("enter the third number");
                        num3 = s.nextDouble();
                        result = addition(num1,num2,num3);
                        allResult.add(result);
                        System.out.println(num1+" + "+num2+" + "+num3+" = "+result);
                    }catch(InputMismatchException e){
                        System.out.println("input mismatch");
                    }
                    break;
                case 2:
                    try{
                        System.out.println("enter the first number");
                        num1 = s.nextDouble();
                        System.out.println("enter the second number");
                        num2 = s.nextDouble();
                        System.out.println("enter the third number");
                        num3 = s.nextDouble();
                        result = subtraction(num1,num2,num3);
                        allResult.add(result);
                        System.out.println(num1+" - "+num2+" - "+num3+" = "+result);
                    }catch(InputMismatchException e){
                        System.out.println("input mismatch");
                    }
                    break;
                case 3:
                    try{
                        System.out.println("enter the first number");
                        num1 = s.nextDouble();
                        System.out.println("enter the second number");
                        num2 = s.nextDouble();
                        System.out.println("enter the third number");
                        num3 = s.nextDouble();
                        result = multiplication(num1,num2,num3);
                        allResult.add(result);
                        System.out.println(num1+" * "+num2+" * "+num3+" = "+result);
                    }catch(InputMismatchException e){
                        System.out.println("input mismatch");
                    }

                    break;
                case 4:
                    try{
                        System.out.println("enter the first number");
                        num1 = s.nextDouble();
                        System.out.println("enter the second number");
                        num2 = s.nextDouble();
                        System.out.println("enter the third number");
                        num3 = s.nextDouble();
                        result = division(num1,num2,num3);
                        allResult.add(result);
                        System.out.println(num1+" / "+num2+" / "+num3+" = "+result);
                    }catch(InputMismatchException e){
                        System.out.println("input mismatch");
                    }
                    break;
                case 5:
                    try{
                        System.out.println("enter the first number");
                        num1 = s.nextDouble();
                        System.out.println("enter the second number");
                        num2 = s.nextDouble();
                        System.out.println("enter the third number");
                        num3 = s.nextDouble();
                        result = modulus(num1,num2,num3);
                        allResult.add(result);
                        System.out.println(num1+" % "+num2+" % "+num3+" = "+result);
                    }catch(InputMismatchException e){
                        System.out.println("input mismatch");
                    }
                    break;
                case 6:
                    try{
                        System.out.println("enter the first number");
                        num1 = s.nextDouble();
                        System.out.println("enter the second number");
                        num2 = s.nextDouble();
                        System.out.println("enter the third number");
                        num3 = s.nextDouble();
                        result = min(num1,num2,num3);
                        allResult.add(result);
                        System.out.println("the smallest number is: "+result);
                    }catch(InputMismatchException e){
                        System.out.println("input mismatch");
                    }
                    break;
                case 7:
                    try{
                        System.out.println("enter the first number");
                        num1 = s.nextDouble();
                        System.out.println("enter the second number");
                        num2 = s.nextDouble();
                        System.out.println("enter the third number");
                        num3 = s.nextDouble();
                        result = max(num1,num2,num3);
                        allResult.add(result);
                        System.out.println("the largest number is: "+result);
                    }catch(InputMismatchException e){
                        System.out.println("input mismatch");
                    }
                    break;
                case 8:
                    try{
                        System.out.println("enter the first number");
                        num1 = s.nextDouble();
                        System.out.println("enter the second number");
                        num2 = s.nextDouble();
                        System.out.println("enter the third number");
                        num3 = s.nextDouble();
                        result = min(num1,num2,num3);
                        allResult.add(result);
                        System.out.println("the average is: "+result);
                    }catch(InputMismatchException e){
                        System.out.println("input mismatch");
                    }
                    break;
                case 9:
                    System.out.println("the last result is: "+result);
                    break;
                case 10:
                    System.out.println("all result are: "+allResult);
            }

            String answer="answer";
            while(!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no")){
                System.out.println("continue ? (yes/no)");
                answer = s.next();
            }
            if(answer.equalsIgnoreCase("yes")){
                System.out.println("----------------------------------------------");
            }else System.exit(0);
        }




    }
    public static double addition(double num1, double num2, double num3){
        double result = num1 + num2 + num3;
        return result;
    }public static double subtraction(double num1, double num2, double num3){
        double result = num1 - num2 - num3;
        return result;
    }public static double multiplication(double num1, double num2, double num3){
        double result = num1 * num2 * num3;
        return result;
    }public static double division(double num1, double num2, double num3){
        double result = num1 / num2 / num3;
        return result;
    }public static double modulus(double num1, double num2, double num3){
        double result = num1 % num2 % num3;
        return result;
    }public static double min(double num1, double num2, double num3){
        double result;
        if(num1<num2 && num1<num3){
            result = num1;
        }else if(num2<num1 && num2<num3){
            result = num2;
        }else result = num3;
        return result;
    }public static double max(double num1, double num2, double num3){
        double result;
        if(num1>num2 && num1>num3){
            result = num1;
        }else if(num2>num1 && num2>num3){
            result = num2;
        }else result = num3;
        return result;
    }public static double avg(double num1, double num2, double num3){
        double result = (num1+num2+num3)/3;
        return result;
    }
}