
import java.util.Scanner;
class TicTacToe
{
    Scanner input = new Scanner(System.in);

 public static void main(String [] args)
 {
     TicTacToe t = new TicTacToe();
     char[][] loc = new char[3][3];
     char player1 = 'X';
     char player2 = 'O';
     t.processOfTheGame(loc,player1,player2);
 }
 void printGame(char[][] arr)
 {
     for(int i = 0 ; i<arr.length;i++)
     {
         for(int j = 0;j<arr[i].length;j++)
         {
             System.out.print(arr[i][j]);
         }
         System.out.println();
     }
 }
 int player1row = 0;int player1col = 0;
  void player1Input()
 {
     player1row = input.nextInt();
     player1col = input.nextInt();
 }
 int player2row = 0;int player2col = 0;
 void player2Input()
 {
     player2row = input.nextInt();
     player2col = input.nextInt();
 }

 boolean checkWin(char[][] arr, char player)
 {
        // Check rows
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == player && arr[i][1] == player && arr[i][2] == player) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < arr[0].length; j++) {
            if (arr[0][j] == player && arr[1][j] == player && arr[2][j] == player) {
                return true;
            }
        }

        // Check diagonals
        if (arr[0][0] == player && arr[1][1] == player && arr[2][2] == player) {
            return true;
        }
        if (arr[0][2] == player && arr[1][1] == player && arr[2][0] == player) {
            return true;
        }

        return false;
 }
 void processOfTheGame(char[][] arr , char playerX ,char playerY )
 {
     int count = (int) (Math.random() * 2);//X belongs to 1 and O belongs to 0
     int countCopy = count;
     System.out.println("The Player 1 has X and the Player 2 has O\nThe First chance will be getting to : "+((count==1)?"Player 1!":"Player 2!"));
     if(count == 1)
     {
         System.out.print("Enter address Player 1 : ");
         player1Input();
         System.out.print("Enter address Player 2 : ");
         player2Input();
     }
     else
     {
         System.out.print("Enter address Player 2 : ");
         player2Input();
         System.out.print("Enter address Player 1 : ");
         player1Input();
     }
     while(count<count+9)
     {if(count%2==1)
     {   if (arr[player1row][player1col] == 0)
         {
             arr[player1row][player1col] = playerX;
             //System.out.println("player1value inserted");
             count++;
             System.out.println(count);
             printGame(arr);
             if ((count == 6 || count == 8 || count == 10) && checkWin(arr, playerX))
             {
                 System.out.println("Player 1 has won the game!");
                 break;
             }
             else if(count==countCopy+11)
             {
                 System.out.print("The result is draw");
                 break;
             }
         }
         else
         {
             if(arr[player1row][player1col]!=0)
             {
                 System.out.print("enter address again Player 1 : ");
                 player1Input();
             }

         }
     }

     else if (count%2==0){
       if (arr[player2row][player2col]==0)
       {
           arr[player2row][player2col] = playerY;
           //System.out.println("player2value inserted");
           count++;
           System.out.println(count);
           printGame(arr);
           if ((count == 5|| count == 7|| count ==9)&& checkWin(arr, playerY))
           {
               System.out.println("Player 2 has won the game!");
               break;
           }
//           else if(count==10)
//           {
//               System.out.print("The result is draw");
//               break;
//           }
       }

       else
       {
           if(arr[player2row][player2col]!=0)
           {
               System.out.print("enter address again Player 2 : ");
               player2Input();

           }
       }
     }



       }
     }

 }
