package util.leetcode.Num516LongestPalimSubseq;

import java.util.HashMap;

public class PalimSubseq {
    public int longestPalindromeSubseq(String s) {
        HashMap<String, Integer> map1= new HashMap<>();
        return longestPalindromeSubseq2(s, map1, 0, s.length()-1);
    }
    int longestPalindromeSubseq2(String s,HashMap<String, Integer> map1, int start, int end) {
        //         System.out.println("calling with s="+ s+ " // start, end="+ start+ ", "+end);
        String key= String.valueOf(start)+ ","+ String.valueOf(end);
        if(map1.get(key)!=null){
            return map1.get(key);
        }
        if(end==start){
            return 1;
        }
        if(end==start+1){
            if(s.charAt(start)==s.charAt(end)){
                return 2;
            }
            return 1;
        }
        else {
            int index=-1;
            int count=0;
            for (int i = 0; i < (end-start+1)/ 2; i++) {
                if (s.charAt(start+i) != s.charAt(end-i)) {
                    index=i;
                    break;
                }
                count=count+2;
            }
            if(index==-1) {
                return end-start+1;
            }
            else{
                int left=longestPalindromeSubseq2(s, map1, start+index, end-index-1 );
                int right=longestPalindromeSubseq2(s, map1, start+index+1, end-index);
                map1.put(key, count+max(left, right));
                return count+max(left, right);
            }
        }
    }
    int max(int a, int b){
        //     System.out.println("     CALING max for a= "+a + "    ::,b= "+b);
        if(a>b){
            return a;
        }
        return b;
    }
}