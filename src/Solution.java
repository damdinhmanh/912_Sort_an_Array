import java.util.Arrays;

public class Solution {

    static void mergeSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, r);
    }

    static void merge(int[] nums, int l, int r) {
        int mid = l + (r - l) / 2;
        int[] tmp = new int[r - l + 1];
        int i = l, j = mid + 1, k = 0;
        while (i <= mid || j <= r) {
            if (i > mid || j <= r && nums[i] > nums[j]) {
                tmp[k++] = nums[j++];
            } else {
                tmp[k++] = nums[i++];
            }
        }
        System.arraycopy(tmp, 0, nums, l, r - l + 1);
    }

    public static int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        mergeSort(nums, 0, nums.length - 1);

        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {5,1,1,2,0,0};

        sortArray(arr);

        System.out.println(Arrays.toString(arr));
    }
}
