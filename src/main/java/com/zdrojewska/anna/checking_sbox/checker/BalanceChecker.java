package com.zdrojewska.anna.checking_sbox.checker;

import com.zdrojewska.anna.checking_sbox.creator.EightFunctionsCreator;

import java.util.List;

/**
 * @author Anna Zdrojewska
 *
 * This class check if function is balanced which means that the function has the same amount of 0 and 1.
 */
public class BalanceChecker {
    private EightFunctionsCreator eightFunctionsCreator = new EightFunctionsCreator();

    /**
     * This function checking balance by counting 0 and 1 in every input list
     *
     * @param function function to check (input list)
     * @param numberOfFunction number of created function (1-8)
     */
    public void checkBalance(List<String> function, int numberOfFunction) {

        //counter for 0
        int counterOfZero = 0;
        //counter for 1
        int counterOfOne = 0;


        //counting 0 and 1
        for (int i = 0; i < function.size(); i++) {
            if(function.get(i).equals("1")){
                counterOfOne++;
            }
            if(function.get(i).equals("0")) {
                counterOfZero++;
            }
        }
        //if function is balanced then the number od 1 and 0 is the same
        if(counterOfZero == counterOfOne){
            System.out.println("Function " + numberOfFunction + " is balanced. Number of 1 is " + counterOfOne + " and 0 is " + counterOfZero);
        }
        else{
            System.out.println("Function " + numberOfFunction + " in not balanced. Number of 1 is " + counterOfOne + " and 0 is " + counterOfZero);
        }
    }

    /**
     * For checking balance and creating function
     */
    public void getBalance(){
        for (int i = 1; i < 9; i++) {
            checkBalance(eightFunctionsCreator.createFunction(i), i);
        }
    }
}
