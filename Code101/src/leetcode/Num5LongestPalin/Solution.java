package leetcode.Num5LongestPalin;

public class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==1){
            return s;
        }
        if(s.length()==2){
            if(s.charAt(0)==s.charAt(1)){
                return s;
            }
            return String.valueOf(s.charAt(0));
        }
        String longPalim1= longPalim(s,1,  0, 2, String.valueOf(s.charAt(1)));
        String longPalim2= longPalim2(s,0,  0, 1, "");
        // System.out.println("1: "+longPalim1);
        // System.out.println("2: "+longPalim2);
        if(longPalim1.length()>longPalim2.length()){
            return longPalim1;
        }
        return longPalim2;
    }

    public static String longPalim(String s,int start, int lP, int rP, String max ){
        if(start==s.length()){
            return max;
        }
        if(rP==s.length()){
            return longPalim(s, start+1, start, start+2,max);
        }
        if(lP<0){
            return longPalim(s, start+1, start, start+2, max);
        }
        char charL=s.charAt(lP);
        char charR=s.charAt(rP);
        if(charR==charL){
            if(rP-lP+1> max.length()){
                max=s.substring(lP, rP+1);
            }
            return longPalim(s, start, lP-1, rP+1, max);
        }
        return longPalim(s, start+1, start, start+2, max);
    }

    public static String longPalim2(String s,int start, int lP, int rP, String max ){
        //       System.out.println("Calling 2 with start="+start+ " lp="+lP+ " rP="+rP+ " max="+max);
        if(start==s.length()){
            return max;
        }
        if(rP==s.length()){
            return longPalim2(s, start+1, start+1, start+2, max);
        }
        if(lP<0){
            return longPalim2(s, start+1, start+1, start+2, max);
        }
        char charL=s.charAt(lP);
        char charR=s.charAt(rP);
        if(charR==charL){
            if(rP-lP+1> max.length()){
                max=s.substring(lP, rP+1);
            }
            return longPalim2(s, start, lP-1, rP+1, max);
        }
        return longPalim2(s, start+1, start+1, start+2, max);
    }
}
