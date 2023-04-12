package leetcode.Num2309RemoveStars;

public class RemoveStars {
    String s="abb*cdfg*****x*";
    public String removeStars(String s) {
        char[] arr= s.toCharArray();
        int i=s.length()-1;
        String retStr="";
        StringBuilder sb= new StringBuilder();
        int skip=0;
        while(i>=0){
            System.out.println(" Running with i="+i + " skip="+ skip);
            System.out.println("String="+ retStr );
            while(s.charAt(i)=='*'){
                System.out.println("             Inner1 with i="+i + " skip="+ skip);
                i--;
                skip++;
                if(i<0){
                    break;
                }
            }
            while(skip>0 && s.charAt(i)!='*'){
                System.out.println("             Inner2 with i="+i + " skip="+ skip);
                i--;
                skip--;
                if(i<0){
                    break;
                }
            }
            if(i<0){
                break;
            }
            if(skip==0 && s.charAt(i)!='*'){
                sb.insert(0,s.charAt(i));
                i--;
            }
        }
        retStr=sb.toString();
        return retStr;
    }
}
