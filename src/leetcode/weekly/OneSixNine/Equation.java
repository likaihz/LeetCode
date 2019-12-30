package leetcode.weekly.OneSixNine;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Li Kai
 */
public class Equation {

    public static void main(String[] args) {
        Solution solution = new Equation().new Solution();
        String[] words = {"SEND","MORE"};
        String result = "MONEY";
        solution.isSolvable(words, result);

    }
    class Solution {
        public boolean isSolvable(String[] words, String result) {
            boolean[] shown = new boolean[26];
            boolean[] noZero = new boolean[26];

            // 统计所有出现过的字母和不能为0的字母
            for(int i = 0; i < words.length; i++) {
                char[] chars = words[i].toCharArray();
                for(int j = 0; j < chars.length; j++) {
                    if(j == 0) {
                        noZero[chars[j]-'A'] = true;
                    }
                    shown[chars[j]-'A'] = true;
                }
            }
            char[] chars = result.toCharArray();
            for(int j = 0; j < chars.length; j++) {
                if(j == 0) {
                    noZero[chars[j]-'A'] = true;
                }
                shown[chars[j]-'A'] = true;
            }

            // 生成搜索空间
            int cnt = 0;
            for(boolean b: shown) {
                if(b) cnt++;
            }
            chars = new char[cnt];
            cnt = 0;
            for(int i = 0; i < 26; i++) {
                if(shown[i]) chars[cnt++] = (char)('A'+i);
            }
            int[] ctoi = new int[26];
            int[] itoc = new int[10];
            for(int i = 0; i < 26; i++) {
                ctoi[i] = -1;
            }
            for(int i = 0; i < 10; i++) itoc[i] = -1;
            System.out.println("=======================");
            for(char c: chars) {
                System.out.println(c);
            }
            System.out.println("=======================");
            return DFS(chars, 0, ctoi, itoc, noZero, words, result);
        }

        private boolean DFS(char[] chars, int crt, int[] ctoi, int[] itoc, boolean[] noZero, String[] words, String result) {
            if(crt == chars.length) {
                System.out.println(crt);
                System.out.println("------------------");
                for(int i : itoc)
                    System.out.println((char)(i+'A'));
                System.out.println("------------------");
                return check(ctoi, itoc, words, result);
            }

            boolean res = false;
            for(int i = 0; i < 10; i++) {
                if(i == 0 && noZero[chars[crt]-'A']) continue;
                if(itoc[i] == -1) {
                    ctoi[chars[crt]-'A'] = i;
                    itoc[i] = chars[crt]-'A';
                    res |= DFS(chars, crt+1, ctoi, itoc, noZero, words, result);
                    ctoi[chars[crt]-'A'] = -1;
                    itoc[i] = -1;
                }
            }
            return res;
        }

        private boolean check(int[] ctoi, int[] itoc, String[] words, String result) {
            int res = 0;
            for(char c: result.toCharArray()) {
                res = res*10+ctoi[c-'A'];
            }
            int sum = 0;
            for(String s: words) {
                int tmp = 0;
                for(char c: s.toCharArray()) {
                    tmp = tmp*10+ctoi[c-'A'];
                }
                sum += tmp;
            }
            return sum == res;
        }
    }
}
