import java.util.*;

class Main {  
  public static void main(String args[]) { 
    char[][] matrix = new char[3][3];

    Scanner in = new Scanner(System.in);
    String p1 = in.nextLine();
    String p2 = in.nextLine();

    String [] player1 = p1.split(" ");
    String [] player2 = p2.split(" ");

    char turn = 'X';
    //char prev_turn = '';
    //System.out.println(p1);
    //System.out.println(p2);
    
    
    for(int i=0; i<3; i++){
      for(int j=0; j<3; j++){
        matrix[i][j] = '-';
      }
    }

    print(matrix);

    
    for(int i=0; i<9; i++){
      char next_move = input(matrix, turn);
      if(next_move != 'Z'){
       turn = next_move; 
      }
      else{
        break;
      }
     // winner(matrix, player1, player2);
      int check = check_game_over(matrix);
      if(check == 0){
        System.out.println("Game Over");
        break;
      }
    }

    
  }

  public static void print(char[][] matrix){
    for(int i=0; i<3; i++){
      for(int j=0; j<3; j++){
        System.out.print(matrix[i][j]);
      }
      System.out.println();
    }
  }

  public static char input(char [] [] matrix, char turn){
    Scanner in = new Scanner(System.in);
    String move = in.nextLine();

    if(move == "exit"){
      System.exit(-1);
    }

    String [] move_parse = move.split(" ");
    int row = Integer.parseInt(move_parse[0]);
    int col = Integer.parseInt(move_parse[1]);

    //System.out.println(row+" "+col);
    if(matrix[row-1][col-1] == '-'){
      matrix[row-1][col-1] = turn;
      print(matrix);
      if(turn == 'X'){
        turn = 'O';
      }
      else if(turn == 'O'){
        turn = 'X';
      }
    }
    else{
      System.out.println("Invalid Move");
      turn = 'Z';
    }

    return turn;
  }

  public static int check_game_over(char [] [] matrix){
    int res = 0;
    for(int i=0;i<3;i++){
      for(int j=0; j<3; j++){
        if(matrix[i][j] == '-'){
          res = 1;
          break;
        }
      }
      if(res == 1){
        break;
      }
    }

    return res;
    
  }

//  public static void winner(char [] [] matrix, String [] player1, String [] player 2){
  //  String winner = "";
  //  String [] arr1 = player1.split(" ");
  //  String [] arr2 = player2.split(" ");
  //  for(int i=0;i<3;i++){
  //    for(int j=0;j<3;j++){
  //      if(matrix[i][j] == matrix[i][j+1] && matrix[i][j] == matrix[i][j+2]){
         
  //        if(arr1[0]) == matrix[i][j]){
  //          winner = arr1[1];
  //        }
  //        else if(arr2[0] == matrix[i][j]){
  //          winner = arr2[1];
   //       }
    
  //      }
  //    }
  //  }
 // }

}
