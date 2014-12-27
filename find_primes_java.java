/*  Thomas F. Maher, Jr. ("T.J.")
    tj.maher@gmail.com

    Senior QA Lead / BSCS / Masters of Software Engineering

    #   Assignment: Write a program in the language
    #   of your choice that will return the first n prime numbers.
    #
    #   This assignment was written in Java

*/

package com.maher.tj;

import java.util.ArrayList;
import java.util.Scanner;

public class find_primes_java {

/* isPRIME: Function is based off of the http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes ...
	Input: an integer n > 1
	Let A be an array of Boolean values, indexed by integers 2 to n, initially all set to true.
		for i = 2, 3, 4, ..., not exceeding (Square root of) n:
		if A[i] is true:
		for j = i2, i2+i, i2+2i, ..., not exceeding n:
		A[j] := false
		Output: all i such that A[i] is true.
*/
    public static boolean isPrime(Integer intTestNumber){
        if (intTestNumber == 2 ){   // "intTestNumber" is the number we are testing if it is prime or not.
            return true;            // If the number being tested is 2, then, yes, 2 is a prime number.
        }
        else if ((intTestNumber < 2) || (intTestNumber % 2 == 0)){
            return false;
        }

        // Sieve of Eratosthenes: Search from 3, 5, 7 ... up until the Square root of the number.
        for ( int i = 3 ; i < Math.sqrt(intTestNumber + 1) ; i += 2 ) {
            if (intTestNumber % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Integer maxNumPrimes;
        String strUserPrompt = "-- FIND_PRIMES_JAVA returns the first N primes.\n"
                + "-- How many prime numbers would you like me to find?\n"
                + "> ";
        String prompt = "> ";
        String strInvalidEntry = "-- INVALID ENTRY:\n"
                + "-- Please enter input in the form of a positive integer.\n"
                + "> ";
        Scanner scanner = new Scanner(System.in);

        Integer intCountOfPrimes = 1;
        Integer testNum = 3;

        System.out.println(strUserPrompt);
        do {
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.printf(strInvalidEntry, input);
            }
            maxNumPrimes = scanner.nextInt();
            if (maxNumPrimes < 1) { System.out.println(strInvalidEntry); }
        } while (maxNumPrimes < 1);

        System.out.println("\n... Attempting to find the first " + maxNumPrimes +
                " prime numbers...");

        ArrayList ArrayOfPrimes = new ArrayList();
        ArrayOfPrimes.add(2);

        while (intCountOfPrimes < maxNumPrimes){
            if (isPrime(testNum)) {
                ArrayOfPrimes.add(testNum);
                intCountOfPrimes += 1;
            }
            testNum += 2;
        }
        System.out.println(ArrayOfPrimes);

    }
}