package main.java.algos.recursionandbacktracking;

import java.util.ArrayList;
import java.util.List;

public class GetAnagramOfString {
    public static void main(String[] args) {

        List<String> result=getAnagram("abc");
        System.out.println(result);
    }

    static List<String> getAnagram(String str){
        if(str.length()==0){
            List<String> baseList=new ArrayList<>();
            baseList.add("");
            return baseList;
        }

        //get first character say a
        char c=str.charAt(0);
        //Get all the anagram for remaining
        String rem=str.substring(1);
        List<String> remainingList=getAnagram(rem);
        List<String> resultList=new ArrayList<>();
        for(String s:remainingList){
            for(int i=0;i<=s.length();i++){
                String beg=s.substring(0,i);
                String end=s.substring(i);
                resultList.add(beg+c+end);
            }
        }
        return resultList;
    }
}
