import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        merge(A, 0, A.length - 1);
        merge(B, 0, B.length - 1);
        
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[A.length - 1 - i];
        }

        return answer;
    }
    
    public void merge(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        
        int mid = (right + left) / 2;
        
        merge(arr, left, mid);
        merge(arr, mid + 1, right);
        
        mergeSort(arr, left, mid, right);
    }
    
    public void mergeSort(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        
        while(i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        
        while(i <= mid) {
            temp[k++] = arr[i++];
        }
        
        while(j <= right) {
            temp[k++] = arr[j++];
        }
        
        for (int t = 0; t < temp.length; t++) {
            arr[left + t] = temp[t];
        }
    }
    
}