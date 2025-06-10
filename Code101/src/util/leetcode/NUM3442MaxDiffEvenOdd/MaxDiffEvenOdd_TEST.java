package util.leetcode.NUM3442MaxDiffEvenOdd;

import java.util.Random;

public class MaxDiffEvenOdd_TEST {
    public static void  runTest(){
        MaxDiffEvenOdd_STREAMS maxDiffEvenOdd_streams= new MaxDiffEvenOdd_STREAMS();
        MaxDiffEvenOdd maxDiffEvenOdd = new MaxDiffEvenOdd();
        int k=1;
            for(int i =2; i< 1000000; i=i*2){
            String str= generateRandomString(i);
            System.out.println(" ---------------------------TEST No :"+k++);
            int a1=maxDiffEvenOdd.maxDifference(str);
            int a2=maxDiffEvenOdd_streams.maxDifference_Streams(str);
            System.out.println("        -----RESULT "  );
            System.out.println("             String : "+ str);
            System.out.println("                a1 : "+ a1);
            System.out.println("                a2 : "+ a2);
            if(a1!=a2){
                throw new RuntimeException(" TEST FAILED");
            }

        }
            System.out.println(" ALL TEST PASSED");
    }

    public static String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 1; i < length; i++) {
            // Generate random char from 'a' (97) to 'z' (122)
            char randomChar = (char) ('a' + random.nextInt(26));
            sb.append(randomChar);
        }
        sb.append('a');
        sb.append('a');

        return sb.toString();
    }
}
