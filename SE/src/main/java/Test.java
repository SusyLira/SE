/**
 * Name: Susy Lira (lira)
 * Course: CSCI 241 - Computer Science I
 * Assignment: 3
 *
 * Project/Class Description: This program will use a formula to calculate the
 * heat index using the numbers that the user inputs
 * Known bugs: None.
 */
import java.util.*;
public class Test {
        public static void main (String[]args){
            //Print heading for user
            System.out.println("Heat Index Calculator Program");
            System.out.println("_____________________________");
            //Set up scanner
            Scanner input = new Scanner(System.in);
            //Ask the user for a relative humidity
            System.out.println("Enter the Fahrenheit temperature (between 80 deg F and 110 deg F): ");
            int temperature = input.nextInt();
            //Ask the user for humidity
            System.out.println("Enter the relative humidity (between 40% and 100%): ");
            int humidity = input.nextInt();
            //Calculate the heat index
            double heatIndex = -42.379 + 2.04901523*temperature + 10.14333127*humidity - 0.22475541*temperature*humidity
                    -6.83783*Math.pow(10,-3)*Math.pow(temperature,2) - 5.481717*Math.pow(10,-2)*Math.pow(humidity,2) + 1.22874
                    *Math.pow(10,-3)*Math.pow(temperature,2)*humidity + 8.5282*Math.pow(10,-4)*temperature*Math.pow(humidity,2)
                    -1.99*Math.pow(10,-6)*Math.pow(temperature,2)*Math.pow(humidity,2);
            double roundHeat = heatIndex + 0.5;
            int finHeatIndex = (int)roundHeat;
            //Display result to user
            System.out.print("At " + (double)temperature + " degrees Fahrenheit with " + (double)humidity + " % humidity,\nthe heat index will make it feel like " + (int)finHeatIndex + " degrees.");



        }
    }
