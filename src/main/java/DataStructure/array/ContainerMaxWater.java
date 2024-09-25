package DataStructure.array;

public class ContainerMaxWater {
    public static void main(String[] args) {
        int[] arr={1,8,6,2,5,4,8,3,7};

        int maxwater=0;
        int left=0;
        int right= arr.length-1;

        while(left<right){
            int height= Math.min(arr[left], arr[right]);
            int width=right-left;

            int current= height*width;

            maxwater=Math.max(maxwater,current);


            if(arr[left]<arr[right]){
                left++;
            }else{
                right--;
            }

        }

        System.out.println("MAxwater is :"+maxwater);
    }
}


