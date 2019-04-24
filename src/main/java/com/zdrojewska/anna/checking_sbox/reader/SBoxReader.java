package com.zdrojewska.anna.checking_sbox.reader;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Anna Zdrojewska
 *
 * This class read sbox from file and convert to 8-bit representation.
 */
public class SBoxReader {

    //name of file with sbox
    private final String fileName = "sbox_08x08_20130109_221329_01.sbx";
    //path to directory with sbox file
    private final String filePath = "C:/Users/Ania/Desktop/Checking Sbox/";

    public List<String> readSBox(){

        //byte array to reading bytes from file
        byte[] arrayFromFile;

        //list where will be converted values from file
        List<String> convertedValuesFromFile = new ArrayList<>();

        try {
            //read bytes from file
            arrayFromFile = Files.readAllBytes(new File(filePath + fileName).toPath());

            for (int i = 0; i < arrayFromFile.length; i++) {

                //removing every even index because they're always 0 and convert representation to 8-bit
                if (i % 2 == 0 ){
                    convertedValuesFromFile.add(String.format("%8s", Integer.toBinaryString(arrayFromFile[i] & 0xFF)).replace(' ', '0'));
                }
            }
        } catch (IOException e) {
            System.out.println(getClass() + ": ERROR READING FROM FILE " + fileName);
        }

        return convertedValuesFromFile;
    }
}
