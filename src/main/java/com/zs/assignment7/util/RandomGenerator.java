package com.zs.assignment7.util;

import java.util.Random;

public class RandomGenerator {

    private Random random=new Random();

    /**
     * Generates random string of given length
     * @param length - length of string
     * @return - random string
     */
    public String generateRandoString(int length){

        String characters="qwertyuioplkjhgfdsazxcvbnm";
        StringBuffer string = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int randomNumber = (int) (Math.random() * 25);
            string.append(characters.charAt(randomNumber));
        }
        return string.toString();
    }

    /**
     * Generates random string of given length with numeric characters
     * @param length - length of string
     * @return - random string
     */
    public String generateRandomNumericString(int length){

        StringBuffer string = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int randomNumber = (int) (Math.random() * 9);
            string.append(randomNumber);
        }
        return string.toString();
    }
}
