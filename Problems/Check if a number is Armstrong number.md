Check if a number is Armstrong Number or not

Problem Statement:Given an integer N, return true it is an Armstrong number otherwise return false.

An Amrstrong number is a number that is equal to the sum of its own digits each raised to the power of the number of digits.

Algorithm

Calculate the number of digits in the input number and store it in k.

Initialise a variable sum to 0. This variable will store the sum of each digit raised to the power of number of digits in number.

Make a copy of the original number to store it in a temporary variable.

Run a while loop with the condition n>0 and at each iteration:
  
Get the last digit of n by using the modulus operator % with 10 and store it in a temporary variable ld.
  
Add the digit ld raised to the power of k of the sum.
  
Update n by integer division with 10 effectively removing the last digit.

After the loop, check if the original input number is equal to the sum of the digits raised to the power of the number of digits in the number.
  
If they are equal, return true indicating the number is an Armstrong number.
  
If they are not equal, return false indicating that the number is not an Armstrong number.
