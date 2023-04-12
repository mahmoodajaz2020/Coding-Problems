package leetcode.Num70SimplifyPath;

import java.util.ArrayList;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] arr= path.split("/");
        StringBuilder sb= new StringBuilder();
        int skip=0;
        ArrayList<String> list1= new ArrayList<>();
        int i=arr.length-1;
        while(i>=0){
            if(arr[i].equals("") || arr[i].equals(".")){
                i--;
            }
            else if(arr[i].equals("..")){
                skip++;
                i--;
            }
            else{
                if(skip==0) {
                    list1.add(arr[i]);
                    list1.add("/");
                    i--;
                }
                else{
                    skip--;
                    i--;
                }
            }
        }
        if(skip>0){
            list1.add("/");
        }
        for(int j=list1.size()-1; j>=0; j--){
            sb.append(list1.get(j));
        }
        return sb.toString();
    }
}
