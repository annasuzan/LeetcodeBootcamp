package Arrays.SortColors;

class Solution {
    public void sortColors(int[] nums) {
        int zero_pointer = 0;
        int two_pointer = nums.length - 1;
        int i = 0;
        while(i < nums.length){
            if(nums[i] == 2 && i < two_pointer){
                int temp = nums[two_pointer];
                nums[two_pointer] = nums[i];
                nums[i] = temp;
                two_pointer--;
            }
            else if(nums[i] == 0 & i != zero_pointer){
                int temp = nums[zero_pointer];
                nums[zero_pointer] = nums[i];
                nums[i] = temp;
                zero_pointer++;
            }else{
                i++;
            }
        }

    }
}
