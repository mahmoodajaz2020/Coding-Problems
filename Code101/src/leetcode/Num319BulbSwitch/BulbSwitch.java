package leetcode.Num319BulbSwitch;

public class BulbSwitch {
    public int bulbSwitch(int n){
        if(n==0){
            return 0;
        }

        int a=0;
        for(int i=1; i<=n; i++){
            if(n%i==0){
                if(a==0){
                    a=1;
                }
                else{
                    a=0;
                }
            }
        }
        return a+bulbSwitch(n-1);
    }
}