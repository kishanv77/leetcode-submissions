class Solution {
  public void print(int current,int n) {
    // Define the base condition
    if(current > n) return;
    // Perform the action
    System.out.println(current);
    //Recursive function call with incrementation
    print(current+1,n);
  }
}
