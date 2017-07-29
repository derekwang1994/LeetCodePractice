Given two strings, write a method to decide if one is a permutation of the other.

public boolean checkPermutation(String str1, String str2){
  if(str1.length()!=str2.length()) return false;

  int[] char_set = new int[128]; // the size depends on the type of String, here I assume it's ASCII.

  for(int i=0; i<str2.length(); i++){ // store how many times of each character appears in the str2 into the char_set
    char_set[str2.charAt(i)]++;
  }

  for(int i=0; i<str1.length(); i++){
    char_set[str1.charAt(i)]--;
    if(char_set[str1.charAt(i)]<0){
      return false;
    }
  }

  return true;
}
