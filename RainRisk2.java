import java.util.Arrays;
import java.util.Scanner;


import java.io.File;
import java.io.FileNotFoundException;

/**
 * RainRisk
 */
public class RainRisk2 {

    public static final String MVNORTH = "N";
    public static final String MVSOUTH = "S";
    public static final String MVEAST = "E";
    public static final String MVWEST = "W";
    public static final String LEFT = "L";
    public static final String RIGHT = "R";
    public static final String FORWARD = "F";

    public static void main(String[] args) {
        try {

            Scanner input = new Scanner(new File("data.txt"));
            String[] program = new String[780];
            int row = 0;
            while (input.hasNextLine()) {
                program[row] = input.nextLine();
                row++;
            }

            // Preparations done, main loop time

            int x = 0;
            int y = 0;

            int wX = 10;
            int wY = 1;

            for (String command : program) {
                String cType = Character.toString(command.charAt(0));
                int cAmount = Integer.parseInt(command.substring(1));
                switch (cType) {
                    case MVNORTH:
                        wY += cAmount;
                        break;

                    case MVSOUTH:
                        wY -= cAmount;
                        break;

                    case MVEAST:
                        wX += cAmount;
                        break;
                    
                    case MVWEST:
                        wX -= cAmount;
                        break;

                    case LEFT:
                        while (cAmount > 0) {
                            int newWX = -wY;
                            int newWY = wX;
                            wX = newWX;
                            wY = newWY;
                            cAmount -= 90;
                        }
                        break;

                    case RIGHT:
                        while (cAmount > 0) {
                            int newWX = wY;
                            int newWY = -wX;
                            wX = newWX;
                            wY = newWY;
                            cAmount -= 90;
                        }
                        break;

                    case FORWARD:
                        x += wX * cAmount;
                        y += wY * cAmount;
                        break;
                
                    default:
                        break;
                }
            }

            System.out.println("Y is " + y + ", X is " + x + ", Manhattan distane is " + (Math.abs(y) + Math.abs(x)));
            



        } catch (FileNotFoundException e) {
            System.out.println("Fuck!");
            //TODO: handle exception
        }
    }
}