package com.zdrojewska.anna.checking_sbox.creator;

import com.zdrojewska.anna.checking_sbox.reader.SBoxReader;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anna Zdrojewska
 *
 * This class convert list from file to eight different functions.
 * Functions created in this class will be checked by BalanceChecker.
 *
 */
public class EightFunctionsCreator {

    private SBoxReader sBoxReader = new SBoxReader();

    //list with values from file (sbox from file)
    private final List<String> arrayFromFile = sBoxReader.readSBox();

    /**
     * This function converts input list (sbox from file) to another list
     * which contains values from indexes. Values from indexes are selected
     * from the last to first in every iteration.
     * for example:
     * input: 001 000 010 111
     * created 1: 1001
     * created 2: 0011
     * created 3: 0001
     *
     * @param numberOfFunction which function should be create (1-8)
     * @return created function
     */
    public List<String> createFunction(int numberOfFunction){

        //list with converted values - last values from every index - now it's empty
        List<String> function = new ArrayList<>();

        //converting list to get last values from every index of input list
        //
        for (int i = 0; i < arrayFromFile.size(); i++) {
            //get value from index
            String s = arrayFromFile.get(i);
            //get last value from every chosen index
            char s2 = s.charAt(s.length() - numberOfFunction);
            //add value to new list
            function.add(String.valueOf(s2));
        }
        //print new function
        System.out.println("Function " + numberOfFunction + " :" + function.toString().replace("[", " ").replace("]","").replaceAll(",", ""));
        return function;
    }
}
