package DataStructure.array;

import java.util.Arrays;
import java.util.*;

public class uniqueElemnts {
    public static List<Integer> findUniqueElements(int[] arr) {
        // Step 1: Sort the array
        Arrays.sort(arr);

        List<Integer> uniqueElements = new ArrayList<>();
        int n = arr.length;

        // Step 2: Traverse the sorted array and find unique elements
        for (int i = 0; i < n; i++) {
            // Check if the current element is not equal to the previous or next element
            if ((i == 0 || arr[i] != arr[i - 1]) && (i == n - 1 || arr[i] != arr[i + 1])) {
                uniqueElements.add(arr[i]);
            }
        }

        return uniqueElements;
    }

    public static int uni(int[] arr) {
        HashSet<Integer> set = new HashSet<>();


        for (int i : arr) {
            set.add(i);
        }

        int[] result = new int[set.size() + arr.length];


        int index = 0;
        for (int unique : set) {
            result[index++] = unique;
        }


        for (int i = 0; i < arr.length; i++) {
            result[index++] = arr[i];
        }


        System.out.print("Resulting array: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();


        return set.size();
    }


    public static void groupUnique(int[] arr) {
        HashSet<Integer> seen = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();


        for (int num : arr) {
            if (!seen.contains(num)) {
                seen.add(num);
                result.add(num);
            }
        }


        for (int num : arr) {
            if (seen.contains(num)) {
                result.add(num);
                seen.remove(num);
            }
        }


        System.out.print("unique elements: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void u(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();

        for(int i:arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        List<Integer> outputList = new ArrayList<>();

        int maxFrequency = 0;
        for (int freq : map.values()) {
            if (freq > maxFrequency) {
                maxFrequency = freq;
            }
        }


        for (int i = 0; i < maxFrequency; i++) {
            for (int num : map.keySet()) {
                if (map.get(num) > i) {
                    outputList.add(num);
                }
            }
        }


        System.out.println(outputList);


    }
    public static void main(String[] args) {
        int arr[]={1,1,1,1,2,2,2,3,3};
        u(arr);
    }
}
