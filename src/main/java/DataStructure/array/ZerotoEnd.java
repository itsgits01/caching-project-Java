package DataStructure.array;

public class ZerotoEnd {
    public static void main(String[] args){
        int[] arr={0,1,2,0,3,4,5,0,6,7,8,9};
        int n= arr.length;
        int index=0;
        //movie non zero elements to the front of array
        for(int i=0;i<n;i++){
            if(arr[i]!=0){
                arr[index]=arr[i];
                index++;
            }
        }
        // Fill the remaining positions with zeros
        for (int i = index; i <n; i++) {
            arr[i] = 0;
        }
        for(int i: arr){
            System.out.print(i+" ");
        }
    }
}
