package 牛客网.二期.yaoheng.class_06;

public class RegularExpressionMatch {
    /**
     *
     * @param s 目标字符串
     * @param p 模式字符串
     * @return
     */
    public static boolean isMatch(String s, String p) {
        // 如果模式字符串 p 为空
        if (p.isEmpty()) {
            // 返回目标字符串 s 是否为空
            return s.isEmpty();
        }

        // 判断目标字符串 s 的第一个字符是否与模式字符串 p 的第一个字符匹配
        boolean firstMatch = (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));

        // 如果模式字符串 p 的长度大于等于 2 并且第二个字符是 '*'
        if (p.length() >= 2 && p.charAt(1) == '*') {
            // 返回以下两种情况的逻辑或：
            // 1. 忽略模式字符串 p 的前两个字符，继续匹配目标字符串 s
            // 2. 如果目标字符串 s 的第一个字符与模式字符串 p 的第一个字符匹配，继续匹配目标字符串 s 的下一个字符与模式字符串 p
            return (isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p)));
        } else {
            // 否则，返回以下两种情况的逻辑与：
            // 1. 目标字符串 s 的第一个字符与模式字符串 p 的第一个字符匹配
            // 2. 继续匹配目标字符串 s 的下一个字符与模式字符串 p 的下一个字符
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }


    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        boolean isMatch = isMatch(s, p);
        System.out.println("Is Match: " + isMatch);
    }
}
