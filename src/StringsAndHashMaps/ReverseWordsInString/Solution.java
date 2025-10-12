package StringsAndHashMaps.ReverseWordsInString;

public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] strArray = s.split(" ");
        String result = "";
        for(int i = strArray.length - 1; i>=0; i--){

            if(strArray[i].isBlank()){
                continue;
            }
            result += strArray[i];

            if(i != 0){
                result += " ";
            }
        }
        return result;
    }

}
