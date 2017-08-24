// Given two binary strings, return their sum (also a binary string).
//
// For example,
// a = "11"
// b = "1"
// Return "100".

class Solution {
    public String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int i = a.length()-1, j = b.length()-1;
        int sum = 0;

        while(i>=0 || j>=0){

            if(i>=0) sum += a.charAt(i--) - '0';

            if(j>=0) sum += b.charAt(j--) - '0';

            sb.append(sum%2);

            sum = (sum == 2) ? 1 : sum/2;

        }

        if(sum!=0) sb.append(sum); // if it has carry

        return sb.reverse().toString();
    }
}
