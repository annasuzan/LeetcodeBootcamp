package StringsAndHashMaps.StringToInteger;

public class Solution {
    public int myAtoi(String s) {
        int result = 0;
        int sign = 1;
        s = s.trim();
        for(int i = 0; i < s.length(); i++){
            if(i==0 && s.charAt(0) == '-'){
                sign = -1;
                continue;
            }else if(i == 0 && s.charAt(0) == '+'){
                continue;
            }
            if(s.charAt(i) == ' ' || !Character.isDigit(s.charAt(i))){
                return sign * result;
            }
            if( result > Integer.MAX_VALUE/10 || result == Integer.MAX_VALUE/10 && s.charAt(i) - '0' > 7){
                return sign == 1? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + (s.charAt(i) - '0');
        }
        return (sign * result);
    }
}
