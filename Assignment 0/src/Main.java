import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {

//      taking input and output from command line
        String inputFile = args[0];
        String outputFile = args[1];
//        System.out.println(inputFile);
//        System.out.println(outputFile);

        try{
            //handling input
            File file = new File(inputFile);
            Scanner input = new Scanner(file);

            //handling output
            PrintWriter writer = new PrintWriter(outputFile);

            int testCases = 0;
            while(input.hasNextLine()){
                input.nextLine();
                testCases=testCases + 1;
            }
//            System.out.println(testCases);
            int []result = new int[testCases];
            input = new Scanner(file);
            testCases = 0;
            while(input.hasNextLine()){
                int avgTime = 0;
                String s = input.nextLine();
//                System.out.println(s);
                float p = Float.parseFloat(s.substring(0, s.indexOf(" ")));
                int w = Integer.parseInt(s.substring(s.indexOf(" ")+1));
                int l = 1000;

                for(int k = 0;k < 30;k++){
                    int time = 0;
                    Infiltrator fighter = new Infiltrator(w,l,p);
//                                System.out.println("fighter created");
                    Border border = new Border(w,l,p);
//                                System.out.println("border created");


                    while(!fighter.isReached()){
                        if(time%10 == 0){
                            border.updateBorder();
                            time++;
//                                                System.out.println("border update: " + time);
//                                                System.out.println("x: " + fighter.x);
//                                                System.out.println("y: " + fighter.y);
                            continue;
                        }

                        if((time%10)==1){
                            fighter.moveForward(border.matrix,w,l);
                            time+=9;
//                                                System.out.println("moved forward: " + time);
//                                                System.out.println("x: " + fighter.x);
//                                                System.out.println("y: " + fighter.y);
                            continue;
                        }
                    }
                    avgTime +=time;
//                    System.out.println(time);
                }



                result[testCases] = avgTime/30;
//                System.out.println(result[testCases]);
                testCases++;
//                System.out.println(avgTime);
                String resultData = String.valueOf(p) + ", " + String.valueOf(w) + ", " + String.valueOf(avgTime);
                writer.println(resultData);
            }
            writer.close();
        }catch(Exception e){System.out.println(e);}

    }
}

