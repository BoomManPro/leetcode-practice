package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest468 {
//给定一个字符串 queryIP。如果是有效的 IPv4 地址，返回 "IPv4" ；如果是有效的 IPv6 地址，返回 "IPv6" ；如果不是上述类型的 
//IP 地址，返回 "Neither" 。 
//
// 有效的IPv4地址 是 “x1.x2.x3.x4” 形式的IP地址。 其中 0 <= xi <= 255 且 xi 不能包含 前导零。例如: “192.1
//68.1.1” 、 “192.168.1.0” 为有效IPv4地址， “192.168.01.1” 为无效IPv4地址; “192.168.1.00” 、 “1
//92.168@1.1” 为无效IPv4地址。 
//
// 一个有效的IPv6地址 是一个格式为“x1:x2:x3:x4:x5:x6:x7:x8” 的IP地址，其中: 
//
// 
// 1 <= xi.length <= 4 
// xi 是一个 十六进制字符串 ，可以包含数字、小写英文字母( 'a' 到 'f' )和大写英文字母( 'A' 到 'F' )。 
// 在 xi 中允许前导零。 
// 
//
// 例如 "2001:0db8:85a3:0000:0000:8a2e:0370:7334" 和 "2001:db8:85a3:0:0:8A2E:0370:7
//334" 是有效的 IPv6 地址，而 "2001:0db8:85a3::8A2E:037j:7334" 和 "02001:0db8:85a3:0000:000
//0:8a2e:0370:7334" 是无效的 IPv6 地址。 
//
// 
//
// 示例 1： 
//
// 
//输入：queryIP = "172.16.254.1"
//输出："IPv4"
//解释：有效的 IPv4 地址，返回 "IPv4"
// 
//
// 示例 2： 
//
// 
//输入：queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
//输出："IPv6"
//解释：有效的 IPv6 地址，返回 "IPv6"
// 
//
// 示例 3： 
//
// 
//输入：queryIP = "256.256.256.256"
//输出："Neither"
//解释：既不是 IPv4 地址，又不是 IPv6 地址
// 
//
// 
//
// 提示： 
//
// 
// queryIP 仅由英文字母，数字，字符 '.' 和 ':' 组成。 
// 
// Related Topics 字符串 👍 138 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final String NEITHER = "Neither";
        private static final String IPV4 = "IPv4";
        private static final String IPV6 = "IPv6";

        public String validIPAddress(String queryIP) {
            if (queryIP.contains(".")) {
                return checkIpv4(queryIP);
            }
            return queryIP.contains(":") ? checkIpv6(queryIP) : "Neither";
        }

        private String checkIpv4(String queryIP) {
            if (queryIP.contains(":")) {
                return NEITHER;
            }
            if (queryIP.charAt(queryIP.length() - 1) == '.') {
                return NEITHER;
            }
            String[] split = queryIP.split("\\.");
            if (split.length != 4) {
                return NEITHER;
            }
            for (int i = 0; i < 4; i++) {
                if (!checkIpv4Split(split[i])) {
                    return NEITHER;
                }
            }
            return IPV4;
        }

        private boolean checkIpv4Split(String s) {
            if (s.length() == 0||s.length()>3) {
                return false;
            }
            int value = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                    return false;
                }
                int v = s.charAt(i) - '0';
                if (v == 0 && value == 0 && i != s.length() - 1) {
                    return false;
                }
                value = value * 10 + v;
            }
            return value>=0&&value<=255;
        }

        private String checkIpv6(String queryIP) {
            if (queryIP.contains(".")) {
                return NEITHER;
            }
            if (queryIP.charAt(queryIP.length() - 1) == ':') {
                return NEITHER;
            }
            String[] split = queryIP.split(":");
            if (split.length != 8) {
                return NEITHER;
            }
            for (int i = 0; i < 8; i++) {
                if (split[i].length()==0||split[i].length() >4) {
                    return NEITHER;
                }
                for (char c : split[i].toCharArray()) {
                     c = Character.toLowerCase(c);
                    if (c >= '0' && c <= '9') {
                        continue;
                    }
                    if (c>='a'&&c<='f'){
                        continue;
                    }
                    return NEITHER;
                }
            }
            return IPV6;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
//            Assert.assertEquals("IPv4",solution.validIPAddress("172.16.254.1"));
//            Assert.assertEquals("IPv6",solution.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
//            Assert.assertEquals("Neither",solution.validIPAddress("256.256.256.256"));
//            Assert.assertEquals("Neither",solution.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
//            Assert.assertEquals("Neither",solution.validIPAddress("20EE:FGb8:85a3:0:0:8A2E:0370:7334"));
            Assert.assertEquals("IPv4",solution.validIPAddress("192.0.0.1"));
            Assert.assertEquals("Neither",solution.validIPAddress("222.2f.22.1"));
        }

    }
}