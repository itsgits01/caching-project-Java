package DataStructure.sorting;

public class selectionSort {
    public static void main(String[] args){

        int[] arr= {5,4,1,3,2};
        selecSort(arr);
        for(int i:arr){
            System.out.print(i+ " ");
        }

    }

    public static void selecSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int minIntPos=i;
            for(int j=i+1;j< arr.length;j++){
                if(arr[minIntPos]>arr[j]){
                    minIntPos=j;
                    //no swapping here as we are findinf the smallest elemnt and pushing it in front of array
                }
            }

            int temp=arr[minIntPos];
            arr[minIntPos]=arr[i];
            arr[i]=temp;
        }
    }
}
