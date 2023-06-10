import java.util.List;

public class Main {
    public static void main(String[] args) {
        int a=1;
        Main main= new Main();
    }
    public int minFlips(int a, int b, int c) {
        String as=binRep(a);
        String bs=binRep(b);
        String cs=binRep(c);
        if(c>a && c>b){
            while(as.length()!=cs.length()){
                as="0"+as;
            }
            while(bs.length()!=cs.length()){
                bs="0"+bs;
            }
        }
        else if(a>c && a>b){
            while(cs.length()!=as.length()){
                cs="0"+cs;
            }
            while(bs.length()!=as.length()){
                bs="0"+bs;
            }
        }
        else if(b>a && b>c){
            while(as.length()!=bs.length()){
                as="0"+as;
            }
            while(cs.length()!=bs.length()){
                cs="0"+cs;
            }
        }
        int count=0;
        for(int i=0; i< cs.length(); i++){
            if(cs.charAt(i)=='0'){
                if(as.charAt(i)=='1' && bs.charAt(i)=='1'){
                    count=count+2;
                }
                if((as.charAt(i)=='0' && bs.charAt(i)=='1' )  || (as.charAt(i)=='1' && bs.charAt(i)=='0')){
                    count++;
                }
            }
            else{
                if(as.charAt(i)=='0' && bs.charAt(i)=='0'){
                    count++;
                }
            }
        }
        return count;
    }
    String binRep(int a){
        if(a==0){
            return "";
        }
        return binRep(a/2)+ String.valueOf(a%2);
    }
}


