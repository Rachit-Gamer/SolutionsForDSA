import java.util.Scanner;

public class RemoveEvenElementsFromArray {
    public static int RemoveDuplicates(int arr[], int n)
    {
        int j = 0;
        int k = -1;
        for(int i =0; i < n; i++)
        {
            if(arr[i]%2==0){
                arr[k] = arr[i];
            }
            k++;
        }
        for(int i=0; i<n; i++)
        {
            if(arr[i]!=arr[i-1])
            {
                arr[j++] = arr[i];
            }
        }
        arr[j++] = arr[n-1];
        return j;

    }
    public static void main(String[] args) {
        int []arr = {3,2,4,7,10,6,5};
        int length = arr.length;
        length = RemoveDuplicates(arr,length);
        for(int i=0; i<length; i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}
