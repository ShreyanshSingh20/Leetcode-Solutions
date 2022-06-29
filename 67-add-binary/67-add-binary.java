import java.math.BigInteger;
class Solution {
  public String addBinary(String a, String b) {
    BigInteger x = new BigInteger(a, 2);
    BigInteger y = new BigInteger(b, 2);
    BigInteger zero = new BigInteger("0", 2);
    BigInteger carry, answer;
    while (y.compareTo(zero) != 0) {
      answer = x.xor(y);//xor is addition of 2 nums withour carry
      carry = x.and(y).shiftLeft(1);//((a&b)<<1) is the carry of two nums a and b
      x = answer;
      y = carry;
    }
    return x.toString(2);
  }
}