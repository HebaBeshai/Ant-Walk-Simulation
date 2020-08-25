import java.util.Random;
import java.util.Scanner;
import java.awt.*;
public class AntPheromoneWalk {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Random rand = new Random();  // random number generator
        int i;
//        int numSteps = 0;       // Number of random steps the ant should take
        int counter = 0;    // Count the number of steps
        int direction;
        int x, y;           // (x,y) current position of the ant
        int oldx, oldy;     // (oldx, oldy) previous position of the ant
        int userG1;         // userinput for the size of the grid
        int maxAnts;        //number of ants user wants
        int steps = 0;
   //     int sum = 0;
        int totalAnts = 0;
        int olddirec;
       // int klm;

        System.out.println("Ant Random Walk Experiment");
        System.out.println();
        System.out.print("What is the size of the grid? ");
        userG1 = input.nextInt();


        // Ask the user for the number of ants to test
        System.out.print("How many ants do you want to test? ");
        maxAnts = input.nextInt();



        //check if its empty, before lines drawing grid before std draw
        int[][] board = new int[userG1-1][userG1-1];
            SquareGrid.drawBoard(userG1);//call method
             board[(userG1-1)/2][(userG1-1)/2]=1;




        StdDraw.setPenRadius(0.008);


        // Starting position of the ant in the middle of the coordinate grid
        x = (userG1 / 2 + 1); //middle of the grid for x axis
        y = (userG1 / 2 + 1); //middle of the grid for y axis


        // Set the pencolor to a different color, e.g. blue
        StdDraw.setPenColor(Color.blue);

        direction = -1;
        while (totalAnts < maxAnts) {
            totalAnts++;
            x = (userG1 / 2 + 1);
            y = (userG1 / 2 + 1);

            while (x < userG1-1 && x > 1 && y < userG1-1 && y > 1) {

                oldx = x;   // keep track of the previous x position
                oldy = y;   // keep track of the previous y position

                olddirec = direction;
                direction = rand.nextInt(4);

               board[oldx][oldy]  = 1;

                while ((olddirec - direction == 2) || (olddirec - direction == -2)){
                    direction = rand.nextInt(4);
                }
                if (direction == 0) {
                    y = y + 1;
                } else if (direction == 1) {
                    x = x + 1;
                } else if (direction == 2) {
                    y = y - 1;
                } else if (direction == 3) {
                    x = x - 1;
                }
                if (board[x][y] == 0){
                    StdDraw.line(oldx, oldy, x, y);
                counter ++;
                }
                else{
                    x = oldx;
                    y = oldy;

                }

                if (board[x-1][y]==1 && board[x][y-1]==1 && board[x+1][y]==1 && board[x][y+1]==1 ){
                    break;

                }
            }

        }
        System.out.println("Your average is " + counter / maxAnts + " to leave grid");

    }

}
