package DataStructure.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class targetSum {
    public static void main(String[] args) {
        int[] arr= {5,1,2,3,4,5};

        int target=8;

//        for(int i=0;i<arr.length;i++){
//            for(int j=i+1;j<arr.length;j++){
//                int sum=arr[i]+arr[j];
//                if(sum==target){
//                    System.out.println("target sum is found at"+"("+i+","+j+")");
//                }
//            }
//        }

        //sorting the array
//        Arrays.sort(arr);
//        int start=0;
//        int end= arr.length-1;
//        while(start<end){
//            int sum=arr[start]+arr[end];
//
//            if (sum==target){
//                System.out.println("target sum is found at"+"("+start+","+end+")");
//                start++;
//                end--;
//            } else if (target<sum) {
//                start++;
//            }else {
//                end--;
//            }
//        }

//        HashMap<Integer, Integer> map= new HashMap<>();
//
//        for(int x:arr){
//            int complement=target-x;
//
//            if(map.containsKey(complement)){
//                System.out.println("Pair found "+ x + " and "+ complement);
//            }
//
//            map.put(x, map.getOrDefault(x,0)+1);
//        }

        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
//        int target;

        System.out.println("Enter the target sum: ");
        target = scanner.nextInt();

        System.out.println("Enter numbers (input -1 to stop): ");

        while (true) {
            int num = scanner.nextInt();
            if (num == -1) {
                break; // Stop input when -1 is entered
            }

            // Calculate the complement
            int complement = target - num;

            // Check if the complement already exists in the map
            if (map.containsKey(complement)) {
                System.out.println("Pair found: " + num + " and " + complement);
            }

            // Store the number in the map
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
    }
}
