package leetcode.Num649Dota2Senate;

public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        char[] arr= senate.toCharArray();
        int i=0;
        while(true){
            if(arr[i]=='R'){
                int j=i+1;
                if(j==arr.length){
                    j=0;
                }
                while(true){
                    if(j==i){
                        return "Radiant";
                    }
                    if(arr[j]=='D'){
                        arr[j]='.';
                        break;
                    }
                    j++;
                    if(j==arr.length-1){
                        j=0;
                    }
                }
            }
            if(arr[i]=='D'){
                int j=i+1;
                if(j==arr.length){
                    j=0;
                }
                while(true){
                    if(j==i){
                        return "Dire";
                    }
                    if(arr[j]=='R'){
                        arr[j]='.';
                        break;
                    }
                    j++;
                    if(j==arr.length){
                        j=0;
                    }
                }
            }
            i++;
            if(i==arr.length){
                i=0;
            }
        }
    }
}
