package lazyboywu.leetcode.problems.p0700_p0800.p0745PrefixAndSuffixSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author lazyboywu
 * @since
 */
public class WordFilter {
    Map<String, List<Integer>> mapPref = new HashMap<>();
    Map<String,List<Integer>> mapSuff = new HashMap<>();
    public WordFilter(String[] words) {
        for (int j = 0; j < words.length; j++) {
            String str = words[j];
            List<Integer> a = mapPref.getOrDefault(str, new ArrayList<>());
            a.add(j);
            mapPref.put(str,a);
            List<Integer> b = mapSuff.getOrDefault(str, new ArrayList<>());
            b.add(j);
            mapSuff.put(str,b);
            for (int i = 1; i < str.length(); i++) {
                List<Integer> prefOrDefault = mapPref.getOrDefault(str.substring(0, i), new ArrayList<>());
                prefOrDefault.add(j);
                mapPref.put(str.substring(0, i),prefOrDefault);
                List<Integer> suffOrDefault = mapSuff.getOrDefault(str.substring(i, str.length()), new ArrayList<>());
                suffOrDefault.add(j);
                mapSuff.put(str.substring(i, str.length()),suffOrDefault);
            }
        }
    }

    public int f(String pref, String suff) {
        List<Integer> listPref = mapPref.get(pref);
        List<Integer> listSuff = mapSuff.get(suff);
        if (listPref==null||listSuff==null){
            return -1;
        }
        int i = listPref.size()-1;
        int j = listSuff.size()-1;
        while (i>-1&&j>-1){
            Integer a = listPref.get(i);
            Integer b = listSuff.get(j);
            if (a>b){
                i--;
            }else if (a<b){
                j--;
            }else {
                return a;
            }
        }
        return -1;
    }
}
