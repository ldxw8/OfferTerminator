package cn.kofes.code;

public class LongestPalindrome {

    public String longestPalindrome(String s) {

        int max = 0;
        String maxStr = "", maxFormer = null, maxLatter = null;

        if ( null != s  && !"".equals(s) ) {
            if ( s.length() < 2 ) {
                maxStr = s;
            } else {

                for (int i = 0; i < s.length() - 1; i++) {
                    int former = isPalindrome(s, i, i);
                    int latter = isPalindrome(s, i, i+1);

                    if ( former != 0 ||  latter != 0 ) {
                        String tmp = (former > latter)?getPalindrome(s, i, i):getPalindrome(s, i, i+1);
                        if ( null == maxStr  ) {
                            maxStr = tmp;
                        } else {
                            if ( tmp.length() >= maxStr.length() ) {
                                maxStr = tmp;
                            }
                        }
                    } else {
                        continue;
                    }
                }

            }
        }

        return maxStr;
    }

    // 判断是否为回文字符串
    private int isPalindrome(String s, int former, int latter) {
        while ( former >= 0 && latter < s.length() && s.charAt(former) == s.charAt(latter) ) {
                former--;
                latter++;
        }
        return latter - former -1;
    }

    // 取出回文字符串
    private String getPalindrome(String s, int former, int latter) {
        while ( former >= 0 && latter < s.length() && s.charAt(former) == s.charAt(latter) ) {
            former--;
            latter++;
        }
        return s.substring(former+1, latter);
    }

}
