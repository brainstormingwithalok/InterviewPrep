package main.java.algos;


import java.util.*;

public class Temp {
    static List<List<Integer>> results = new ArrayList<>();

    public static void main(String[] args) {
        getAnagrams("cbaebabacd","abc");
    }


    public static void getAnagrams(String str,String ptr){

        Map<Character,Integer> pMap=new HashMap<>();
        for (char c: ptr.toCharArray()){
            pMap.put(c,pMap.getOrDefault(c,0)+1);
        }
        Map<Character,Integer> sMap=new HashMap<>();

        for(int i=0;i<str.length();i++){
            sMap.put(str.charAt(i),sMap.getOrDefault(str.charAt(i),0)+1);

            if(i>=ptr.length()){
                char chr=str.charAt(i- ptr.length());
                if(sMap.get(chr)>1){
                    sMap.put(chr,sMap.get(chr)-1);
                }
                else{
                    sMap.remove(chr);
                }
            }

            if(pMap.equals(sMap)){
                System.out.println("Found at index->"+(i-(ptr.length()-1)));
            }
        }


    }

    public static int[] sumResult(int[] num){
        //129
        int [] result=new int[num.length+1];
        int sum=0;
        int carry=0;
        int sNum=0;
        boolean added=false;
        for(int i=num.length-1;i>=0;i--){
            if(!added) {
                sum = num[i] + carry+1;
                added=true;
            }
            else {
                sum = num[i] + carry;
            }
            carry=sum/10;
            result[i+1]=sum%10;
        }
        result[0]=carry;
        return result;
    }
    public static List<List<Integer>> permute ( int[] nums){
        perm(new ArrayList<>(), nums);
        return results;
    }


    public static void perm(List<Integer> empty, int[] nums) {

        if (nums.length == empty.size()) {
            results.add(new ArrayList<>(empty));
            return;
        }

        for (int num : nums) {
            if (!empty.contains(num)) {
                empty.add(num);
                perm(empty, nums);
                empty.remove(empty.size() - 1);
            }
        }
    }

}
