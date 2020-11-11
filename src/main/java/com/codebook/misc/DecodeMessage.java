package com.codebook.misc;

import java.util.HashMap;
import java.util.Map;

/*
 * NumOfWays(12345)
 *      BaseCase:
 *          NumOfWays("") -> 1
 *          NumOfWays(01234) -> 0
 *      NumOfWays(2345) + NumOfWays(345)
 *      ... NumOfWays(45)
 *      ... NumOfWays(5)
 */

public class DecodeMessage {
    Map<Integer, Character> characterIntegerMap = new HashMap<Integer, Character>();

    Map<String, Integer> memory = new HashMap<String, Integer>();

    public DecodeMessage() {
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        for(int i = 0; i < 26; i++){
            characterIntegerMap.put(i + 1, alphabets.charAt(i));
        }
    }

    public int waysToDecodeMessage(String message){
        if(memory.containsKey(message)){
            return memory.get(message);
        }

        if(message.length() == 0){
            return 1;
        }

        int numOfWays = 0;
        String rightMessage = message.substring(1);
        int decodedNumber = Integer.decode(message.substring(0, 1));

        if(decodedNumber < 1 || decodedNumber > 26){
            return 0;
        }

        numOfWays += waysToDecodeMessage(rightMessage);
        memory.put(rightMessage, numOfWays);

        if (message.length() > 1) {
            rightMessage = message.substring(2);
            decodedNumber = Integer.decode(message.substring(0, 2));
            if (decodedNumber < 1 || decodedNumber > 26) {
                return numOfWays;
            }

            numOfWays += waysToDecodeMessage(rightMessage);
            memory.put(rightMessage, numOfWays);
        }

        return numOfWays;
    }

    public static void main(String[] args) {
        DecodeMessage decodeMessage = new DecodeMessage();
        long startTime = System.currentTimeMillis();
        System.out.println(decodeMessage.waysToDecodeMessage("1224211276172328121222111231415161718126")+" in "+ (System.currentTimeMillis()-startTime) +" ms");
    }
}
