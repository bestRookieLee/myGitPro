class Solution{
        public static void main(String[] args) {
            int []nums = {2, 4, 7, 8, 23, 24, 27};
            int target = 15;
            int []indexArr = twoSum(nums,target);
            for (int num : indexArr) {
                System.out.println(num);
            }
        }
      public static int[] twoSum(int[] nums, int target)
       {
         for(int i=0;i<nums.length;i++)
          {
            for(int j=i+1;j<nums.length;j++)
              {
                  if(nums[j]==target-nums[i])
                     return new int [] {i,j};
              }
          }
         throw new IllegalArgumentException("No two sum solution");
       }
 }