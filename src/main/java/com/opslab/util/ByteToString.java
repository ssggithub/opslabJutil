package com.opslab.util;

public class ByteToString {
    public static void main(String[] args) {
        // byte[] bytes = "\xe7\xbb\x91\xe5\xae\x9a\xe6\x8c\xaa\xe8\xbd\xa6\xe5\x8d\xa1\xe4\xbf\xa1\xe6\x81\xaf";删除bytes中的"\x"
        String str = "e7bb91e5ae9ae68caae8bda6e58da1e4bfa1e681af";
        String s = toStringHex(str);
        System.out.println(s);
    }

    public static String toStringHex(String s) {
        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            s = new String(baKeyword, "utf-8");// UTF-16le:Not
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;
    }
}
