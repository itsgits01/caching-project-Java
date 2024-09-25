package DataStructure.array;

public class TrappingRainwater {
    public static void main(String[] ars){
        int[] arr={4,2,0,6,3,2,5};

        if(arr.length<3){
            System.out.println("No Water can be trapped");
        }

        int[] left=new int[arr.length];

        left[0]=arr[0];
        for(int i=1;i<arr.length;i++){

            left[i]=Math.max(left[i-1],arr[i]);
        }

        //right max
        int[] right= new int[arr.length];
        right[arr.length-1]=arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--){
            right[i]=Math.max(right[i+1],arr[i]);
        }

        int maxwater=0;
        int width=1;
        for(int i=0;i<arr.length;i++){
            int waterLevel= Math.min(left[i],right[i]);
            maxwater+=waterLevel-arr[i];
        }

        System.out.println("Maxwater is:"+ maxwater);

    }
}
