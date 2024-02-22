import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        gameStart();








    }


    public static void gameStart(){
        Scanner s = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);

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
                boolean winCondtion = false;
                boolean isAvailable = true;


                String choice = "not null";

                while(!choice.equalsIgnoreCase("X") || !choice.equalsIgnoreCase("o")){
                    System.out.println("please choice X or O");
                    choice = s2.nextLine();
                }

                //if player choose o, assign o to player and x to computer.
                if (choice.equalsIgnoreCase("O")){
                    isPlayerTurn = false;
                    playerRole = 'o';
                    computerRole = 'x';
                }


                do{
                    //game Board

//                    System.out.println("-----|-----|-----");
//                    System.out.println("  1  |  2  |  3  ");
//                    System.out.println("-----|-----|-----");
//                    System.out.println("  4  |  5  |  6  ");
//                    System.out.println("-----|-----|-----");
//                    System.out.println("  7  |  8  |  9  ");
                    System.out.println("|-----|-----|-----|");
                    System.out.println("|  " + match[0][0] + "  |  " + match[0][1] + "  |  " + match[0][2] + "  |");
                    System.out.println("|-----|-----|-----|");
                    System.out.println("|  " + match[1][0] + "  |  " + match[1][1] + "  |  " + match[1][2] + "  |");
                    System.out.println("|-----|-----|-----|");
                    System.out.println("|  " + match[2][0] + "  |  " + match[2][1] + "  |  " + match[2][2] + "  |");
                    System.out.println("|-----|-----|-----|");



                    isAvailable = isAvailable(match);
                    int positionInput=0;
                    if(isPlayerTurn){
                        System.out.println("enter an available position");
                        positionInput = Integer.parseInt(String.valueOf(s.nextInt()));
                    }else positionInput = computerTurn(match);


                    isPlayerTurn = !isPlayerTurn;

                    winCondtion = winCondtion(match);



                    switch(positionInput){
                        case 1:
                            if(isPlayerTurn) {
                                match[0][0] = playerRole;
                            }else match[0][0] = computerRole;
                            break;

                        case 2:
                            if(isPlayerTurn) {
                                match[0][1] = 'X';
                            }else match[0][1] ='O';

                            break;
                        case 3:
                            if(isPlayerTurn) {
                                match[0][2] = 'X';
                            }else match[0][2] ='O';

                            break;
                        case 4:
                            if(isPlayerTurn) {
                                match[1][0] = 'X';
                            }else match[1][0] ='O';

                            break;
                        case 5:
                            if(isPlayerTurn) {
                                match[1][1] = 'X';
                            }else match[1][1] ='O';

                            break;
                        case 6:
                            if(isPlayerTurn) {
                                match[1][2] = 'X';
                            }else match[1][2] ='O';

                            break;
                        case 7:
                            if(isPlayerTurn) {
                                match[2][0] = 'X';
                            }else match[2][0] ='O';

                            break;
                        case 8:
                            if(isPlayerTurn) {
                                match[2][1] = 'X';
                            }else match[2][1] ='O';

                            break;
                        case 9:
                            if(isPlayerTurn) {
                                match[2][2] = 'X';
                            }else match[2][2] ='O';
                            break;
                    }

                }while(winCondtion || !isAvailable);

                break;
            case 2:
                System.out.println("here multi");

                break;
            default:
                System.out.println("please enter either 1 or 2");
                break;
        }




    }

    public static boolean isAvailable(char[][] match){

        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){

            }
        }
        return true;
    }

    public static boolean winCondtion(char[][] match){
        return true;
    }

    public static int computerTurn(char[][] match){

        int computerInput = 0;

        return computerInput;
    }

    public static void gameEnd(){

    }
}