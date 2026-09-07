class Solution {
  public static boolean isArmstrong(int num) {
    int k= String.valueOf(num).length();
    int sum=0;
    while(num>0) {
      int lastDigit= num%10;
      sum+=Math.pow(lastDigit,k); //Number= LastDigit, Raised to power of = k
      n/=10;
    }
    if(sum==num) {
      return true;
    }
    else {
      return false;
    }
  }
}
      
