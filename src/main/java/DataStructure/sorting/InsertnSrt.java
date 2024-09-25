package DataStructure.sorting;

public class InsertnSrt {
    public static void main(String[] args) {
        int[] arr ={2,1,6,5,4};
        isort(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }


    public static void isort(int[] num){
        for(int i=1;i<num.length;i++){
            int curr=num[i];
            int prev=i-1;

            while(prev>=0 && num[prev]<curr){
                //swap
                num[prev+1]=num[prev];
                prev--;
            }

            num[prev+1]=curr;
        }
    }
}
