package util.leetcode.Num3443MaxManhattanDistance;

import java.util.stream.Stream;

public class MaxManDistance_STREAMS{

    public int maxDistanceStreams(String s, int k) {
        return Stream.of(
                maxer(s, 'N', 'W', k ),
                maxer(s, 'N', 'E', k ),
                maxer(s, 'S', 'W', k ),
                maxer(s, 'S', 'E', k )).max(Integer::compareTo).orElse(0);
    }


    int maxer(String s, char c1, char c2, int k){
        int currentSum=0;
        int max=0;
        for(int i=0; i<s.length(); i++){
            char ch= s.charAt(i);
            if(ch==c1 || ch==c2){
                currentSum++;
            }
            else{
                if(k>0){
                    currentSum++;
                    k--;
                }
                else{
                    currentSum--;
                }
            }
            if(max<currentSum){
                max=currentSum;
            }
        }
        return max;

    }
}