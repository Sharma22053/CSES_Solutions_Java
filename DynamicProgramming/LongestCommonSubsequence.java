import java.util.Scanner;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        

        for(int i=0;i<n1;i++){
            arr1[i] = sc.nextInt();
        }
        for(int i=0;i<n2;i++){
            arr2[i] = sc.nextInt();
        }
        
        System.out.println(helper(arr1,arr2,0,0));
        sc.close();
    }
    static int helper(int[] arr1, int[] arr2, int index1 ,int index2){
        if(index1 == arr1.length || index2 == arr2.length) return 0;
        if(arr1[index1] == arr2[index2]){
            return  1 + helper(arr1,arr2,index1+1,index2+1);
        }
         return Math.max(helper(arr1,arr2,index1+1,index2) , 
         helper(arr1,arr2,index1,index2+1));

    }
}

