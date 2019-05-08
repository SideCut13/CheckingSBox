package com.zdrojewska.anna.checking_sbox;

import com.zdrojewska.anna.checking_sbox.checker.BalanceChecker;
import com.zdrojewska.anna.checking_sbox.checker.SACChecker;
import com.zdrojewska.anna.checking_sbox.creator.EightFunctionsCreator;
import com.zdrojewska.anna.checking_sbox.creator.LinearFunctionCreator;
import com.zdrojewska.anna.checking_sbox.reader.SBoxReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * @author Anna Zdrojewska
 *
 * Main function - only for calling the methods.
 */
public class App
{

    public static void main( String[] args )
    {
        SBoxReader sBoxReader = new SBoxReader();

        EightFunctionsCreator eightFunctionsCreator = new EightFunctionsCreator();
        List<String> functions = eightFunctionsCreator.createFunctions(sBoxReader.readSBox());

        System.out.println("----------------------BALANCE OF FUNCTION-----------------------");
        BalanceChecker balanceChecker = new BalanceChecker();
        balanceChecker.getBalance();

        System.out.println("-----------------------NONLINEAR FUNCTION-----------------------");
        LinearFunctionCreator linearFunctionCreator = new LinearFunctionCreator();
        linearFunctionCreator.calculateLinearFunctions(functions);

        System.out.println("-------------------------SAC CRITERION--------------------------");
        SACChecker sacChecker = new SACChecker();
        sacChecker.checkSACCriterion(functions);


    }

}
