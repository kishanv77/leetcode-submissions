class Solution {
  public void print(int n) {
    //Define the base condition
    if(n<1) return;
    //Action to be performed
    System.out.println(n);
    //Recursive function call with decrementation because we are printing reverse
    print(n-1);
  }
}
