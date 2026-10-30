//Solution 1 with time complexity of O(m+n) [OPTIMAL APPROACH]
class Solution {
  public void merge(int[] nums1,int m, int[] nums2, int n) {
    int p1= m-1;
    int p2= n-1;
    int pMerge = m+n-1;
    while(p1>=0) {
      if(p2>=0 && nums2[p2] > nums1[p1]) {
        nums1[pMerge--] = nums2[p2--];
      }
      else {
        nums1[pMerge--] = nums1[p1--];
      }
    }
  }
}  

//Alternative Solution with time complexity of O(m+n)log(m+n) [NOT APPLICABLE FOR LEETCODE 88]
class Solution2 {
  public static int[] merge(int[] nums1,int m, int[] nums2,int n) {
    int[] result= new int[m+n];
    System.arraycopy(nums1,0,result,0,m);
    System.arraycopy(nums2,0,result,m,n);
    Arrays.sort(result);
    return result;
  }
}
