//https://www.hackerrank.com/contests/hack-it-to-win-it-paypal/challenges/q4-traveling-is-fun

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class UF {
    
    private int[] father;
    private int[] size;
    
    public UF(int n) {
        father = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
            size[i] = 1;
        }
    }
    
    public int find(int x) {
        if (father[x] != x) {
            father[x] = find(father[x]);
        }
        
        return father[x];
    }
    
    public void union(int x, int y) {
        int i = find(x);
        int j = find(y);
        if (i == j) {
            return;
        }
        if (size[i] < size[j]) {
            father[i] = j;
            size[j] += size[i];
        }
        else {
            father[j] = i;
            size[i] += size[j];
        }
    }
}


public class Solution {

    static int[] connectedCities(int n, int g, int[] originCities, int[] destinationCities) {
        UF uf = new UF(n+1);
        /*the below two for loops are calculating tables from g+1 to g and adding it to the union tree */
        for (int i = g+1; i <= n; i++) {
            for (int j = 2*i; j <= n; j+=i) {
                uf.union(i, j);
            }
        }
        int len = originCities.length;
        int[] result = new int[len];
        for (int k = 0; k < len; k++) {
            int a = uf.find(originCities[k]);
            int b = uf.find(destinationCities[k]);
            if (a == b) {
                result[k] = 1;
            }
        } 
        return result;
    }
    
    private static int gcd(int x, int y) {
        
        while (y != 0) {
            int remainder = x % y;
            x = y;
            y = remainder;
        }
        return x;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int g = in.nextInt();
        int originCities_cnt = in.nextInt();
        int[] originCities = new int[originCities_cnt];
        for(int originCities_i = 0; originCities_i < originCities_cnt; originCities_i++){
            originCities[originCities_i] = in.nextInt();
        }
        int destinationCities_cnt = in.nextInt();
        int[] destinationCities = new int[destinationCities_cnt];
        for(int destinationCities_i = 0; destinationCities_i < destinationCities_cnt; destinationCities_i++){
            destinationCities[destinationCities_i] = in.nextInt();
        }
        int[] res = connectedCities(n, g, originCities, destinationCities);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + (i != res.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}