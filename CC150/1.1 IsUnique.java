// Implement an algorithm to determine if a string has all unique characters.

// solution 1:
//   x depends on the type of the string.
//  if it's ASCII then x = 128 or 256(extended ASCII)

//  time complexity = O(n); space complexity = O(1)
  public boolean isUnique(String str){
    if(str.length > x) return false;

    boolean[] used = new boolean[x];
    for(int i=0; i<str.length(); i++){
      int val = str.charAt(i);
      if(used[val) return false;
      used[val] = true;
    }
    return true;
  }
// solution 2:
//  use bit vector to reduct the space usage.
//  we assume that the string only contains lowercase characters.
//  since int in java is 32 bit long and there are only 26 lowercase characters,
//  we can use bitwise opertor to check wether the character has appeared or not.

//  time complexity = O(n); space complexity = O(1)
  public boolean isUnique(String str){
    int checker = 0;
    for(int i=0; i<str.length; i++){
      int val = str.charAt(i);
      if( (checker & (1<<val)) > 0) return false;
      checker |= (1<<val);
    }
    return true;
  }

//  What if you cannot use additional data structures?
//  solution 3:
//   Brutal force : compare every character to the other characters in the string.
//   time complexity: O(n^2); space complexity: O(1)
