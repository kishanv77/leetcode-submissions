class Solution {
  public void printName(String name,int count,int n) {
    //Define the base condition after which recursion will stop
    if(count>n) return;
    //Action to be performed
    System.out.println(name);
    //Recursive function call with incremented count
    printName(name,count+1,n);
  }
}
