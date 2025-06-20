package util.leetcode.Num3443MaxManhattanDistance;

public class MaxManDistance{

    public int maxDistance(String s, int k) {
        int max=0;
        int a1= maxer(s, 'N', 'W', k );
        if(max<a1){
            max=a1;
        }
        a1= maxer(s, 'N', 'E', k );
        if(max<a1){
            max=a1;
        }
        a1= maxer(s, 'S', 'W', k );
        if(max<a1){
            max=a1;
        }
        a1= maxer(s, 'S', 'E', k );
        if(max<a1){
            max=a1;
        }
        return max;
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