package com.zdrojewska.anna.checking_sbox;

import com.zdrojewska.anna.checking_sbox.checker.BalanceChecker;

/**
 * @author Anna Zdrojewska
 *
 * Main function - only for calling the methods.
 */
public class App
{
    public static void main( String[] args )
    {
        BalanceChecker balanceChecker = new BalanceChecker();
        balanceChecker.getBalance();
    }

}
