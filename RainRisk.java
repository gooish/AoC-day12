import java.util.Scanner;


import java.io.File;
import java.io.FileNotFoundException;

/**
 * RainRisk
 */
public class RainRisk {

    public static final int EAST = 0;
    public static final int SOUTH = 1;
    public static final int WEST = 2;
    public static final int NORTH = 3;

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
            int dir = EAST;


            for (String command : program) {
                String cType = Character.toString(command.charAt(0));
                int cAmount = Integer.parseInt(command.substring(1));
                switch (cType) {
                    case MVNORTH:
                        y += cAmount;
                        break;

                    case MVSOUTH:
                        y -= cAmount;
                        break;

                    case MVEAST:
                        x += cAmount;
                        break;
                    
                    case MVWEST:
                        x -= cAmount;
                        break;

                    case LEFT:
                        dir -= cAmount / 90;
                        break;

                    case RIGHT:
                        dir += cAmount / 90;
                        break;

                    case FORWARD:
                        switch (dir) {
                            case EAST:
                                x += cAmount;
                                break;
                        
                            case SOUTH:
                                y -= cAmount;
                                break;

                            case WEST:
                                x -= cAmount;
                                break;
                            
                            case NORTH:
                                y += cAmount;
                                break;
                        }
                        break;
                
                    default:
                        break;
                }

                // Make direction sensible
                if (dir > 3) {
                    dir -= 4;
                }
                if (dir < 0) {
                    dir += 4;

                }

            }

            System.out.println("Y is " + y + ", X is " + x + ", Manhattan distane is " + (Math.abs(y) + Math.abs(x)));
            



        } catch (FileNotFoundException e) {
            System.out.println("Fuck!");
        }
    }
}