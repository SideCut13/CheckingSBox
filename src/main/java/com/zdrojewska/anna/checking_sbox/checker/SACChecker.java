package com.zdrojewska.anna.checking_sbox.checker;


import java.util.Arrays;
import java.util.List;

//TO DO: REFACTOR THIS CODE
public class SACChecker {

    public void checkSACCriterion(List<String> functionsFromFile){
        double[] sacValues = new double[8]; //Sac values for every function
        int arrayCounter = 0; // counter for every function, used only with sacValues array
        for (String function : functionsFromFile) {
            int result = 0; // how many times bits are different
            for (int i = 0; i < 256; i++) { // every function has 256 possible values

                for (int k = 0; k < 8; k++) // bit negation,
                {
                    int negation = i ^ (1 << k); // i with negate k bit
                    if (function.charAt(i) != function.charAt(negation)) // dumb XOR
                    {
                        result++;
                    }

                }

            }
            sacValues[arrayCounter++] =  100.00 * result / (256.0 * 8); // 100% * number of different bits / (number of possible values * number of arguments)
        }
        for(int i = 0;i<8;i++)
        {
            int x = i+1;
            System.out.println("SAC value for Function " + x + " : " + sacValues[i]);
        }
        double sacAvg = Arrays.stream(sacValues)
                .average()
                .getAsDouble();

        System.out.println("Average SAC value : " + sacAvg);
    }
}
