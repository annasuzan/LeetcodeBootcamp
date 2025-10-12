package StringsAndHashMaps.FindAllAnagrams;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] pCount = new int[256];
        int[] sCount = new int[256];
        if(p.length() > s.length()){
            return result;
        }
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i)]++;
            sCount[s.charAt(i)]++;
        }
        for (int i = p.length(); i < s.length(); i++) {
            if (Arrays.equals(pCount, sCount)) {
                result.add(i - p.length());
            }
            sCount[s.charAt(i)]++;
            sCount[s.charAt(i - p.length())]--;
        }
        if (Arrays.equals(pCount, sCount)) {
            result.add(s.length() - p.length());
        }
        return result;
    }
}
