import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        gameStart();








    }


    public static void gameStart(){
        Scanner s = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        Scanner s3 = new Scanner(System.in);

        int gameMode = 0;

        while(gameMode != 1 || gameMode != 2) {
            try {
                System.out.println("enter 1 to play singlePlayer." +
                        "\nenter 2 to play multiplayer.");
                gameMode = Integer.parseInt(s.next());
                if(gameMode == 1 || gameMode == 2)
                    break;
            } catch (NumberFormatException e) {
                System.out.println("please enter either 1 or 2");
                System.out.println("----------------------------");
                continue;
            }
            System.out.println("please enter either 1 or 2");
            System.out.println("----------------------------");

        }



        switch(gameMode){
            case 1:

                char[][] match = {{'1','2','3'},
                                  {'4','5','6'},
                                  {'7','8','9'}}; //position in the grid

                //default settings
                boolean isPlayerTurn = true;
                char playerRole = 'x';
                char computerRole = 'o';
                int positionInput=0;
                boolean winCondtion = false;
                boolean isAvailable = false;
                int count = 0;

                String choice = "not null";

                while(!choice.equalsIgnoreCase("x") && !choice.equalsIgnoreCase("o")){
                    System.out.println("please choice X or O");
                    choice = s2.nextLine();
                }

                //if player choose o, assign o to player and x to computer.
                if (choice.equalsIgnoreCase("o")){
                    isPlayerTurn = false;
                    playerRole = 'o';
                    computerRole = 'x';
                }


                do{


                    //game Board
                    System.out.println("|-----|-----|-----|");
                    System.out.println("|  " + match[0][0] + "  |  " + match[0][1] + "  |  " + match[0][2] + "  |");
                    System.out.println("|-----|-----|-----|");
                    System.out.println("|  " + match[1][0] + "  |  " + match[1][1] + "  |  " + match[1][2] + "  |");
                    System.out.println("|-----|-----|-----|");
                    System.out.println("|  " + match[2][0] + "  |  " + match[2][1] + "  |  " + match[2][2] + "  |");
                    System.out.println("|-----|-----|-----|");


                    do{
                        System.out.println("computer choose: " + positionInput);
                        if(isPlayerTurn){
                            System.out.println("enter an available position");
                            positionInput = Integer.parseInt(String.valueOf(s.nextInt()));
                        }else{
                            positionInput = computerTurn(match);
                        }
                        isAvailable = isAvailable(match, positionInput);

                    }while(!isAvailable);


//                    isAvailable = isAvailable(match, positionInput);
//
//
//
//                    winCondtion = winCondtion(match);


                    switch(positionInput){
                        case 1:
                            if(isPlayerTurn) {
                                match[0][0] = playerRole;
                            }else match[0][0] = computerRole;
                            break;

                        case 2:
                            if(isPlayerTurn) {
                                match[0][1] = playerRole;
                            }else match[0][1] = computerRole;

                            break;
                        case 3:
                            if(isPlayerTurn) {
                                match[0][2] = playerRole;
                            }else match[0][2] = computerRole;

                            break;
                        case 4:
                            if(isPlayerTurn) {
                                match[1][0] = playerRole;
                            }else match[1][0] = computerRole;

                            break;
                        case 5:
                            if(isPlayerTurn) {
                                match[1][1] = playerRole;
                            }else match[1][1] = computerRole;

                            break;
                        case 6:
                            if(isPlayerTurn) {
                                match[1][2] = playerRole;
                            }else match[1][2] = computerRole;

                            break;
                        case 7:
                            if(isPlayerTurn) {
                                match[2][0] = playerRole;
                            }else match[2][0] = computerRole;

                            break;
                        case 8:
                            if(isPlayerTurn) {
                                match[2][1] = playerRole;
                            }else match[2][1] = computerRole;

                            break;
                        case 9:
                            if(isPlayerTurn) {
                                match[2][2] = playerRole;
                            }else match[2][2] = computerRole;
                            break;
                    }

                    winCondtion = winCondtion(match);//check if the match win or draw
                    isPlayerTurn = !isPlayerTurn;

                }while(!winCondtion);

                break;
            case 2:
                System.out.println("here multi");

                break;
            default:
                System.out.println("please enter either 1 or 2");
                break;
        }




    }

    public static boolean isAvailable(char[][] match ,int positionInput){
        boolean isAvailable = true;

        switch(positionInput){
            case 1:
                if(match[0][0] == 'x' || match[0][0] == 'o')
                    isAvailable = false;
                break;
            case 2:
                if(match[0][1] == 'x' || match[0][1] == 'o')
                    isAvailable = false;
                break;
            case 3:
                if(match[0][2] == 'x' || match[0][2] == 'o')
                    isAvailable = false;
                break;
            case 4:
                if(match[1][0] == 'x' || match[1][0] == 'o')
                    isAvailable = false;
                break;
            case 5:
                if(match[1][1] == 'x' || match[1][1] == 'o')
                    isAvailable = false;
                break;
                case 6:
                if(match[1][2] == 'x' || match[1][2] == 'o')
                    isAvailable = false;
                break;
            case 7:
                if(match[2][0] == 'x' || match[2][0] == 'o')
                    isAvailable = false;
                break;
            case 8:
                if(match[2][1] == 'x' || match[2][1] == 'o')
                    isAvailable = false;
                break;
            case 9:
                if(match[2][2] == 'x' || match[2][2] == 'o')
                    isAvailable = false;
                break;

        }



        return isAvailable;
    }

    public static boolean winCondtion(char[][] match){

        boolean firstLineH = (match[0][0] == 'x' && match[0][1] == 'x' && match[0][2] == 'x')
                || (match[0][0] == 'o' && match[0][1] == 'o' && match[0][2] == 'o');
        boolean secondLineH = (match[1][0] == 'x' && match[1][1] == 'x' && match[1][2] == 'x')
                || (match[1][0] == 'o' && match[1][1] == 'o' && match[1][2] == 'o');
        boolean thirdLineH = (match[2][0] == 'x' && match[2][1] == 'x' && match[2][2] == 'x')
                || (match[2][0] == 'o' && match[2][1] == 'o' && match[2][2] == 'o');
        boolean winCondition = false;

        if(firstLineH){
            System.out.println("win");
            winCondition = true;
        }else if(secondLineH){
            System.out.println("win");
            winCondition = true;
        } else if(thirdLineH) {
            System.out.println("win");
            winCondition = true;
        }

        return winCondition;
    }

    public static int computerTurn(char[][] match){

        boolean isAvailable = false;
        int computerInput = 0;
        do{
            Random rand = new Random();
            computerInput = rand.nextInt(1,10);

            isAvailable = isAvailable(match, computerInput);

        }while(!isAvailable);


        return computerInput;
    }

    public static void gameEnd(){

    }
}