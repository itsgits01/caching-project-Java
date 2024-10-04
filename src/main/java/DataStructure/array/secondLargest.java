package DataStructure.array;

public class secondLargest {
    public static int findSecondLargest(int[] arr) {
        int n = arr.length;

        // Array should have at least two elements
        if (n < 2) {
            System.out.println("Array needs at least two elements");
            return -1;
        }

        // Initialize the largest and second largest
        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        // Traverse the array
        for (int i = 0; i < n; i++) {
            // If current element is greater than first_largest
            if (arr[i] > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = arr[i];
            }
            // If current element is greater than secondLargest but not equal to firstLargest
            else if (arr[i] > secondLargest && arr[i] != firstLargest) {
                secondLargest = arr[i];
            }
        }

        // Check if second largest was updated
        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("No second largest element found");
            return -1;
        }

        return secondLargest;
    }
    public static void main(String[] args) {
        int[] arr= {2,2,2,2,2};
        System.out.println(findSecondLargest(arr));

    }
}
