/***********************************************************************************************************************
 * @file   AntRandomWalkSimulation .java
 * @brief  This program lets the user enter the number of steps it should take, then stimulates the moves on a grid
 * @author Heba Beshai
 * @date   February 16, 2016
 **********************************************************************************************************************/
import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class AntRandomWalkSimulation {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Random rand = new Random();  // random number generator
        int i;
        int numSteps = 0;       // Number of random steps the ant should take
        int counter = 0;    // Count the number of steps
        int direction;
        int x, y;           // (x,y) current position of the ant
        int oldx, oldy;     // (oldx, oldy) previous position of the ant

        // Set the x and y axis to be between 0 and 20, so corner coordinates are:
        // (0, 20)      (20, 20)
        //
        // (0, 0)       (20, 0)
        StdDraw.setXscale(0, 20);
        StdDraw.setYscale(0, 20);

        // Use a loop to draw the grid by drawing 21 vertical lines and 21
        // horizontal lines
        i = 0;
        while (i <= 20) {
            StdDraw.line(i , 0, i , 20);  // vertical line from (i,0) to (i,20)
            StdDraw.line(0 , i, 20 , i);
            i++;
        }

        StdDraw.setPenRadius(0.008);
        // Ask the user for the number of random steps the ant should take.
        // I am assuming you are using variable numSteps to store this value.
        System.out.println("How many steps do you want to take?");
        numSteps = input.nextInt();

        // Keep track of the ant's position in the grid using two variables for its
        // x and y location.
        x = 10;  // middle of the grid in the x axis
        y = 10;  // middle of the grid in the y axis

        // Set the pencolor to a different color, e.g. blue
        StdDraw.setPenColor(Color.blue);

        // Loop to make the ant take the number of steps chosen by the user
        while (counter < numSteps) {

            oldx = x;   // keep track of the previous x position
            oldy = y;   // keep track of the previous y position

            // Choose a random number from 0, 1, 2, 3
            // Assign in your mind a direction to each number, e.g.
            // 0 -> north
            // 1 -> east
            // 2 -> south
            // 3 -> west
            direction = rand.nextInt(4);

            // if (direction == 0) then change the ant's position to north
            // by increasing y by 1
            if (direction == 0){
                y = y+1;
            }
            // else if (direction == 1) then change the ant's position to east
            // by increasing x by 1
             else if(direction == 1) {
                x = x+1;
            }
             else if(direction == 2){
                y = y-1;
            }
            else if (direction == 3){
                x = x-1;
            }
            // etc.

            // Draw a small line from (xold, yold) to (x, y)
            StdDraw.line(oldx, oldy, x, y);

            counter++;
        }

    }

}