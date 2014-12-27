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

/* 
	First, we print out to the screen, prompting the user on how many prime numbers they want us to find.
	If the next set of characters are not an integer (such a decimal or a set of characters), we tell 
	the user that they have entered an Invalid Entry, and will have to enter new text. 
	If the next set of characters read by the scanner is less than 1 (0, -1, -2...), we also prompt the user 
	that they entered an Invalid Entry. 
	
	If these conditions are not seen, we exit the Do While loop and continue with the program, since the 
	maxNumPrimes is proven to be 1, 2, 3... or some other positive non-zero integer. 
*/

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

/*
	While generating the ArrayList of prime numbers, we will add the first prime number,
	a "2", to the array, since we know that is prime. 
*/

        ArrayList ArrayOfPrimes = new ArrayList();
        ArrayOfPrimes.add(2);
        
/* 
	Starting with the number "3", we will test every other number to see if it is prime. 
	If it is prime, we will add that testNum to the Array List of Primes. 
	After the number is added, we will increase the count of primes by one.
	This process will stop when the number of primes that have been added isn't equal to 
	the maxiumum number of primes that the user has selected.  
	It will test 3, then 5, then 7, and the rest of the series of odd numbers, since we know that 
	all even numbers except "2" is not prime. 
*/

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
