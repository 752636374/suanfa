package 牛客网.一期.yaoheng.class_07;

import java.util.Arrays;
import java.util.Comparator;

public class LowestLexicography_yh {
    public static void main(String[] args) {
        String[] word = {"a","bc","ef"};
        String s = lowestLex(word);
        System.out.println(s);
    }

    private static String lowestLex(String[] word) {
        //排序
        Arrays.sort(word,new LexicographyComparator());
        //拼接字符串
        StringBuilder sb = new StringBuilder();
        for(String s:word){
            sb.append(s);
        }
        return sb.toString();
    }

    static class LexicographyComparator implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            String s1 = o1+o2;
            String s2 = o1+o2;
            return s1.compareTo(s2);
        }
    }
}
