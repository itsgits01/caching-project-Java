package DataStructure.StringsInJAVA;
import java.util.*;
public class reverseinChunks {
    public static void main(String[] args){
        reverse("HEllo World Gitesh");
    }

    public static void reverse(String s){
        String[] arr = s.split(" ");
        StringBuilder sb= new StringBuilder();

        for(int i=arr.length-1;i>=0;i--){
            sb.append(arr[i]);
            if(i>0){
                sb.append(" ");
            }
        }

        System.out.println(sb.toString());
    }

}
