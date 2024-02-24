import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        gameStart();
    }


    public static void gameStart(){
        Scanner s = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);

        int gameMode = 0;

        while(gameMode != 1 && gameMode != 2) {
            try {
                System.out.println("enter 1 to play singlePlayer." +
                        "\nenter 2 to play multiplayer.");
                gameMode = Integer.parseInt(s.next());

            } catch(NumberFormatException e){
            }
            if(gameMode !=1 && gameMode != 2) {
                System.out.println("please enter either 1 or 2");
                System.out.println("----------------------------");
            }

        }



        switch(gameMode){
            case 1:
                char[][] match = {{'1','2','3'},
                                  {'4','5','6'},
                                  {'7','8','9'}}; //position in the grid

                //default settings
                boolean isPlayerTurn = false;
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
                    isPlayerTurn = true;
                    playerRole = 'o';
                    computerRole = 'x';
                }


                do{


                    winCondtion = winCondition(match, playerRole, computerRole, isPlayerTurn);//check if the match win or draw
                    isPlayerTurn = !isPlayerTurn;




                    int playerInput=5;
                    do{

                        if(isPlayerTurn){
                            System.out.println("|-----|-----|-----|");
                            System.out.println("|  " + match[0][0] + "  |  " + match[0][1] + "  |  " + match[0][2] + "  |");
                            System.out.println("|-----|-----|-----|");
                            System.out.println("|  " + match[1][0] + "  |  " + match[1][1] + "  |  " + match[1][2] + "  |");
                            System.out.println("|-----|-----|-----|");
                            System.out.println("|  " + match[2][0] + "  |  " + match[2][1] + "  |  " + match[2][2] + "  |");
                            System.out.println("|-----|-----|-----|");

                            if(positionInput!=0 && !(playerInput>9 || playerInput<1))
                                System.out.println("computer choose: " + positionInput);
                            System.out.println("enter an available position");
                            try{
                                positionInput = Integer.parseInt(String.valueOf(s.next()));
                            }catch(NumberFormatException e){
                            }
                        }else{
                            positionInput = computerTurn(match);
                        }
                        isAvailable = isAvailable(match, positionInput);
                        playerInput = positionInput;

                    }while(!isAvailable || playerInput>9 || playerInput<1);




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
                    count++;
                }while(count<9);
                gameEnd(match, playerRole, computerRole, isPlayerTurn, winCondtion);

                break;
            case 2:

                System.out.println("here multi");
                match = new char[][]{{'1', '2', '3'},//position in the grid
                                     {'4', '5', '6'},
                                     {'7', '8', '9'}};
                boolean isPlayer1Turn = false;
                char player1Role = 'x';
                char player2Role = 'o';
                positionInput=0;
                winCondtion = false;
                isAvailable = false;
                count = 0;


                do{
                    winCondtion = winCondition(match, player1Role, player2Role, isPlayer1Turn);//check if the match win or draw
                    isPlayer1Turn = !isPlayer1Turn;


                    int playerInput=5;
                    do{


                            System.out.println("|-----|-----|-----|");
                            System.out.println("|  " + match[0][0] + "  |  " + match[0][1] + "  |  " + match[0][2] + "  |");
                            System.out.println("|-----|-----|-----|");
                            System.out.println("|  " + match[1][0] + "  |  " + match[1][1] + "  |  " + match[1][2] + "  |");
                            System.out.println("|-----|-----|-----|");
                            System.out.println("|  " + match[2][0] + "  |  " + match[2][1] + "  |  " + match[2][2] + "  |");
                            System.out.println("|-----|-----|-----|");
                            if(isPlayer1Turn){
                                System.out.println("enter an available position: player1");
                            }else System.out.println("enter an available position: player2");
                            try{
                                positionInput = Integer.parseInt(String.valueOf(s.next()));
                            }catch(NumberFormatException e){
                            }

                        isAvailable = isAvailable(match, positionInput);
                        playerInput = positionInput;

                    }while(!isAvailable || playerInput>9 || playerInput<1);


                    switch(positionInput){
                        case 1:
                            if(isPlayer1Turn) {
                                match[0][0] = player1Role;
                            }else match[0][0] = player2Role;
                            break;

                        case 2:
                            if(isPlayer1Turn) {
                                match[0][1] = player1Role;
                            }else match[0][1] = player2Role;

                            break;
                        case 3:
                            if(isPlayer1Turn) {
                                match[0][2] = player1Role;
                            }else match[0][2] = player2Role;

                            break;
                        case 4:
                            if(isPlayer1Turn) {
                                match[1][0] = player1Role;
                            }else match[1][0] = player2Role;

                            break;
                        case 5:
                            if(isPlayer1Turn) {
                                match[1][1] = player1Role;
                            }else match[1][1] = player2Role;

                            break;
                        case 6:
                            if(isPlayer1Turn) {
                                match[1][2] = player1Role;
                            }else match[1][2] = player2Role;

                            break;
                        case 7:
                            if(isPlayer1Turn) {
                                match[2][0] = player1Role;
                            }else match[2][0] = player2Role;

                            break;
                        case 8:
                            if(isPlayer1Turn) {
                                match[2][1] = player1Role;
                            }else match[2][1] = player2Role;

                            break;
                        case 9:
                            if(isPlayer1Turn) {
                                match[2][2] = player1Role;
                            }else match[2][2] = player2Role;
                            break;
                    }



                    count++;
                }while(count<9);

                gameEnd(match, player1Role, player2Role, isPlayer1Turn, winCondtion);





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

    public static boolean winCondition(char[][] match, char playerRole, char computerRole , boolean isPlayerTurn){

        boolean firstRow = match[0][0] ==  match[0][1] && match[0][2] == match[0][0];
        boolean secondRow = match[1][0] == match[1][1] && match[1][2] == match[1][0];
        boolean thirdRow = match[2][0] == match[2][1] && match[2][2] == match[2][0];
        boolean firstColumn = match[0][0] == match[1][0] && match[2][0] == match[0][0];
        boolean secondColum = match[0][1] == match[1][1] && match[2][1] == match[0][1];
        boolean thirdColum = match[0][2] == match[1][2] && match[2][2] == match[0][2];
        boolean diagonalRL = match[0][2] == match[1][1] && match[2][0] == match[0][2];
        boolean diagonalLR = match[0][0] == match [1][1] && match[2][2] == match[0][0];

        boolean winCondition = false;
        if(firstRow){
            winCondition = true;
            gameEnd(match, playerRole, computerRole, isPlayerTurn, winCondition);
        }else if(secondRow){
            winCondition = true;
            gameEnd(match, playerRole, computerRole, isPlayerTurn, winCondition);
        }else if(thirdRow){
            winCondition = true;
            gameEnd(match, playerRole, computerRole, isPlayerTurn, winCondition);
        }else if(firstColumn){
            winCondition = true;
            gameEnd(match, playerRole, computerRole, isPlayerTurn, winCondition);
        } else if(secondColum) {
            winCondition = true;
            gameEnd(match, playerRole, computerRole, isPlayerTurn, winCondition);
        }else if(thirdColum){
            winCondition = true;
            gameEnd(match, playerRole, computerRole, isPlayerTurn, winCondition);
        }else if(diagonalLR){
            winCondition = true;
            gameEnd(match, playerRole, computerRole, isPlayerTurn, winCondition);
        }else if(diagonalRL){
            winCondition = true;
            gameEnd(match, playerRole, computerRole, isPlayerTurn, winCondition);
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
    public static void gameEnd(char[][] match,char playerRole,char computerRole,boolean isPlayerTurn, boolean winCondtion){
        Scanner s = new Scanner(System.in);

        //if gameMode==1 etc

        System.out.println("|-----|-----|-----|");
        System.out.println("|  " + match[0][0] + "  |  " + match[0][1] + "  |  " + match[0][2] + "  |");
        System.out.println("|-----|-----|-----|");
        System.out.println("|  " + match[1][0] + "  |  " + match[1][1] + "  |  " + match[1][2] + "  |");
        System.out.println("|-----|-----|-----|");
        System.out.println("|  " + match[2][0] + "  |  " + match[2][1] + "  |  " + match[2][2] + "  |");
        System.out.println("|-----|-----|-----|");
        if(isPlayerTurn && winCondtion) {
            System.out.println("player won: " + playerRole);
        }else if(!isPlayerTurn && winCondtion){
            System.out.println("computer won:" + computerRole);
        }else System.out.println("game ended in a draw");


        String answer;
        do{
            System.out.println("end");
            System.out.println("continue ? (yes/no)");
             answer = s.nextLine();
        }while(!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no"));

        if(answer.equalsIgnoreCase("yes")){
            System.out.println("-----------------------------------");
            gameStart();
        }else System.exit(0);
    }
}