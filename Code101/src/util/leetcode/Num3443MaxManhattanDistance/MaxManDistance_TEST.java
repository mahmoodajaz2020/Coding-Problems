package util.leetcode.Num3443MaxManhattanDistance;

import util.leetcode.NUM3442MaxDiffEvenOdd.MaxDiffEvenOdd_STREAMS;

import java.util.stream.Stream;

public class MaxManDistance_TEST{
    public static void runTest(int test){
        MaxManDistance maxManDistance= new MaxManDistance();
        MaxManDistance_STREAMS maxManDistance_streams= new MaxManDistance_STREAMS();
        int testNo=0;
        while(testNo<test){
            System.out.println("--------------------------------------------");
            System.out.println(" Running test  : " +testNo++);
            String tester= generateRandomString();
            int tester_k= (int)(Math.random() * (tester.length() + 1));

            System.out.println(" Running test for  : " +tester +" \n k="+tester_k);
            if(maxManDistance.maxDistance(tester, tester_k)!=maxManDistance_streams.maxDistanceStreams(tester, tester_k)){
                throw new RuntimeException(" $$$$$$$$$$$    Test failed ");
            }
            System.out.println("        -> PASSED"  );
            testNo++;
        }
        System.out.println("    ALL PASS SUCCESS"  );

    }



    public static String generateRandomString() {
        int length = (int)(Math.random() * 100_000) + 1;
        char[] directions = {'N', 'S', 'E', 'W'};
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(directions[(int)(Math.random() * 4)]);
        }
        return sb.toString();
    }

}