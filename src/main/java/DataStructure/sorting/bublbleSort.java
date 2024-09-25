package DataStructure.sorting;

public class bublbleSort {
    public static void main(String[] args) {
        int[] arr= {9, 7, 2, -1, 0};
        bsort(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }

    public static void bsort(int[] arr){
        for(int turn=0;turn<arr.length-1;turn++){
            for(int j=0;j<arr.length-1-turn;j++){
                if(arr[j]>arr[j+1]){
                    //swap
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
}
