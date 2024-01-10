package main.java.algos;

import jdk.internal.util.xml.impl.Pair;

import java.util.*;

public class Temp {
    public static void main(String[] args) {
        int[] nums={3,2,2,3};

        System.out.println(removeElement(nums,3));

    }

    static public int removeElement(int[] nums, int val) {

        int i=0;int j=nums.length-1;
        int count=0;

        while(i<j){
            if(nums[i]==val && nums[j]!=val){
                swap(nums,i,j);
                i++;
                j--;
                count++;
                continue;
            }
            if(nums[i]==val){
                swap(nums,i,i+1);
                count++;
                i++;
                continue;
            }
            i++;

        }

        return (nums.length-count-1);

    }

    static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }


    public static String reverseVowels(String s) {

        List<Character> vList=new ArrayList<>();
        vList.add('a');
        vList.add('e');
        vList.add('i');
        vList.add('o');
        vList.add('u');


        if(s.length()==0 || s.length()==1){
            return s;
        }
        char ch[]=s.toLowerCase().toCharArray();
        int i=0;int j=s.length()-1;
        while((i<j))
        {
            if((vList.contains(ch[i])) && (vList.contains(ch[j])))
            {
                char temp=ch[i];
                ch[i]=ch[j];
                ch[j]=temp;
                i++;
                j--;
                continue;
            }
            if(!vList.contains(ch[i])){
                i++;
                continue;
            }

            if(!vList.contains(ch[j])){
                j--;
            }


        }
        return new String(ch);

    }

    public static int lengthOfLongestSubstring2(String s) {

        int i=0;int j=0;
        String result="";
        int maxLen=0;
        HashSet<Character> set=new HashSet<>();
        HashSet<Character> tempSet=new HashSet<>();
        for(char c:s.toCharArray()){
            set.add(c);
        }
        int window=set.size();
        while(i<s.length()-window){
            String temp=s.substring(i,set.size());
            tempSet=new HashSet<>();
            for(char c:temp.toCharArray()){
                tempSet.add(c);
            }
            if(tempSet.size()==set.size()){
                return tempSet.size();
            }
            else {

            }
        }

        return maxLen;
    }
    public static int anotherWay(String str) {
        int j=0;int count=0;
        HashMap<Character,Integer> map=new HashMap<>();

        for(int i=0;i<str.length();i++) {
            //pwwkew
            while(j<str.length()) {
                if(map.containsKey(str.charAt(j))) {
                    count=count>map.size()?count:map.size();
                    break;
                }
                map.put(str.charAt(j), 1);
                j++;
            }
            if(j==str.length()){
                count=count>map.size()?count:map.size();
            }
            map.remove(str.charAt(i));
        }
        return count;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length, n = nums2.length;
        int left = 0, right = m;

        while (left <= right) {
            int partitionA = (left + right) / 2;
            int partitionB = (m + n + 1) / 2 - partitionA;

            int maxLeftA = (partitionA == 0) ? Integer.MIN_VALUE : nums1[partitionA - 1];
            int minRightA = (partitionA == m) ? Integer.MAX_VALUE : nums1[partitionA];
            int maxLeftB = (partitionB == 0) ? Integer.MIN_VALUE : nums2[partitionB - 1];
            int minRightB = (partitionB == n) ? Integer.MAX_VALUE : nums2[partitionB];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                } else {
                    return Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                right = partitionA - 1;
            } else {
                left = partitionA + 1;
            }
        }
        return 0.0;
    }

    public static double findMedium(int[] nums1, int[] nums2) {
        if(nums1.length>=nums2.length){
            return find(nums1,nums1.length, nums2, nums2.length);
        }
        else{
            return find(nums2,nums2.length, nums1, nums1.length);
        }
    }


    public static double find(int[] num1,int n, int[] num2, int m){
        int low=0;int high=n;
        int p1;int p2;

        while(low<=high){
            p1=(low+high)/2;
            p2=(m+n+1)/2-p1;
            int maxp1Left=(p1==0)?Integer.MIN_VALUE:num1[p1-1];
            int minp1Right=(p1==n)?Integer.MAX_VALUE:num1[p1];

            int maxp2Left=(p2==0)?Integer.MIN_VALUE:num2[p2-1];
            int minp2Right=(p2==m)?Integer.MAX_VALUE:num2[p2];
            //  maxp1Left|minp1Right   maxp2Left|minp2Right
            if(maxp1Left<=minp2Right && maxp2Left<=minp1Right){
                if((n+m)%2==0){
                    return (Math.max(maxp1Left,maxp2Left) + Math.min(minp2Right,minp1Right))/2.0;
//                    (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                }
                else{
                    return (double) (Math.max(maxp1Left,maxp2Left));
                }
            }
            else if(maxp1Left>minp2Right){
                high=p1-1;
            }
            else{
                low=p1+1;
            }
        }

        return 0.0;
    }

    public static boolean isPathCrossing(String path) {
        int x=0;int y=0;
        Set<Coordinate> set=new HashSet<>();
        Coordinate c=new Coordinate(0,0);
        set.add(c);

        for(char ch: path.toCharArray()){
            if(ch=='N'){
                y=y+1;
                c=new Coordinate(x,y);
                if(set.contains(c)){
                    return true;
                }
                else{
                    set.add(c);
                }
            }
            if(ch=='S'){
                y=y-1;
                c=new Coordinate(x,y);
                if(set.contains(c)){
                    return true;
                }
                else{
                    set.add(c);
                }
            }
            if(ch=='E'){
                x=x+1;
                c=new Coordinate(x,y);
                if(set.contains(c)){
                    return true;
                }
                else{
                    set.add(c);
                }
            }
            if(ch=='W'){
                x=x-1;
                c=new Coordinate(x,y);
                if(set.contains(c)){
                    return true;
                }
                else{
                    set.add(c);
                }
            }
        }
        return false;

    }

    static class Coordinate{
        int x;
        int y;
        Coordinate(int x, int y){
            this.x=x;
            this.y=y;
        }
        public int getX(){
            return x;
        }

        public int getY(){
            return x;
        }
        public void setX(int x){
            this.x=x;
        }
        public void setY(int y){
            this.y=y;
        }

        @Override
        public boolean equals(Object o) {
            Coordinate that = (Coordinate) o;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }


}
