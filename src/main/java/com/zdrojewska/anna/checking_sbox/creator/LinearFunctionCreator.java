package com.zdrojewska.anna.checking_sbox.creator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinearFunctionCreator {

  /*  EightFunctionsCreator eightFunctionsCreator = new EightFunctionsCreator();
    */
   /* private List<String> functionAllTheSame(String number){
        List<String> allTheSame = new ArrayList<>();
        for (int i = 0; i < 256; i++) {
            allTheSame.add(number);
        }
        return allTheSame;
    }*/
    
 /*   private List<String> functionSwitchPlaces(int repeat, int shift){
        List<String> switchPlaces = new ArrayList<>(256);
        int[][] matrix = new int[256][1];
        for (int i = 0; i < repeat; i++) {
            for (int j = 0; j < shift; j++) {
                switchPlaces.add("0");
            }
            for (int j = 0; j < shift; j++) {
                switchPlaces.add("1");
            }
        }
        for (int i = 0; i < 256; i++) {
            for (int j = 0; j < 1; j++) {
                matrix[i][j] = Integer.valueOf(switchPlaces.get(i));
            }
        }
        //System.out.println(Arrays.deepToString(matrix));
        return switchPlaces;
    }
    
    public void getBasisLinearFunctions(){
        *//*List<String> allZeros = functionAllTheSame("0");
        List<String> allOnes = functionAllTheSame("1");*//*
        List<String> switch1Places = functionSwitchPlaces(128,1);
        List<String> switch2Places = functionSwitchPlaces(64,2);
        List<String> switch4Places = functionSwitchPlaces(32,4);
        List<String> switch8Places = functionSwitchPlaces(16,8);
        List<String> switch16Places = functionSwitchPlaces(8,16);
        List<String> switch32Places = functionSwitchPlaces(4,32);
        List<String> switch64Places = functionSwitchPlaces(2,64);
        List<String> switch128Places = functionSwitchPlaces(1, 128);

        int[][] matrix = new int[256][8];

        for (int i = 0; i < 256; i++) {
            for (int j = 0; j < 8; j++) {
                if(j == 0){
                    matrix[i][j] = Integer.valueOf(switch128Places.get(i));
                }
                if(j == 1){
                    matrix[i][j] = Integer.valueOf(switch64Places.get(i));
                }
                if(j == 2){
                    matrix[i][j] = Integer.valueOf(switch32Places.get(i));
                }
                if(j == 3){
                    matrix[i][j] = Integer.valueOf(switch16Places.get(i));
                }
                if(j == 4){
                    matrix[i][j] = Integer.valueOf(switch8Places.get(i));
                }
                if(j == 5){
                    matrix[i][j] = Integer.valueOf(switch4Places.get(i));
                }
                if(j == 6){
                    matrix[i][j] = Integer.valueOf(switch2Places.get(i));
                }
                if(j == 7){
                    matrix[i][j] = Integer.valueOf(switch1Places.get(i));
                }
            }
        }



    *//*    System.out.println("Function :" + switch1Places.toString().replace("[", " ").replace("]","").replaceAll(",", ""));
        System.out.println("Function :" + switch2Places.toString().replace("[", " ").replace("]","").replaceAll(",", ""));
        System.out.println("Function :" + switch4Places.toString().replace("[", " ").replace("]","").replaceAll(",", ""));
        System.out.println("Function :" + switch8Places.toString().replace("[", " ").replace("]","").replaceAll(",", ""));
        System.out.println("Function :" + switch16Places.toString().replace("[", " ").replace("]","").replaceAll(",", ""));
        System.out.println("Function :" + switch32Places.toString().replace("[", " ").replace("]","").replaceAll(",", ""));
        System.out.println("Function :" + switch64Places.toString().replace("[", " ").replace("]","").replaceAll(",", ""));
        System.out.println("Function :" + switch128Places.toString().replace("[", " ").replace("]","").replaceAll(",", ""));
*//*
    }*/

    //TO DO: REFACTOR THIS CODE AND MOVE CALCULATIONS TO NonLinearChecker
    public void calculateLinearFunctions(List<String> functionsFromFile){
        int[][] values = new int[8][256]; // [function From File][linear function number] - how many times value of linear function == value of function from file
        for (int b = 0;b<256;b++) {  // all arguments
            String arguments = createBinaryString(b);
            for (int i = 0; i < 256; i++) { // all linear functions
                int result = 0; // result of i function
                String function = createBinaryString(i); // which arguments are considered
                for (int k = 0; k < 8; k++) {
                    if (function.charAt(k) == '1') { //if it is considered argument
                        int functionValueOnKBit = Integer.parseInt(Character.toString(arguments.charAt(k)));  // argument on this bit
                        if (result != functionValueOnKBit) // dumb XOR
                        {
                            result = 1;
                        }else result = 0;
                    }
                }
                for(int k = 0;k<8;k++)
                {
                    if(Integer.parseInt(Character.toString(functionsFromFile.get(k).charAt(i))) == result) // if k function from file has the same result as i linear function
                    {
                        values[k][b]++;
                    }
                }

            }
        }
        for(int i = 0;i<8;i++) {
            int min = Arrays.stream(values[i])
                    .min()
                    .getAsInt();
            int x = i+1;
            System.out.println("Nonlinear value for function " + x +" : " + min);
        }
    }

    //TO DO: REFACTOR THIS CODE
    private String createBinaryString(int aIntToConversion)
    {
        StringBuilder builder = new StringBuilder();
        int numberOfzeroes = 8 - Integer.toBinaryString(aIntToConversion).length();
        for(int i = 0;i<numberOfzeroes;i++)
        {
            builder.append("0");
        }
        builder.append(Integer.toBinaryString(aIntToConversion));

        return builder.toString();
    }
}
