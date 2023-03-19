package com.gzl.tesla;

import org.junit.Test;

public class ReverseStr {

    public String reverseStr(String s, int k) {
        StringBuffer buffer = new StringBuffer();
        int length = s.length() / (2 * k);
        if (s.length() % (2 * k) != 0) {
            length++;
        }
        for (int i = 0; i < length; i++) {
            String substring = s.substring(i * 2 * k, Math.min(s.length(), (i + 1) * 2 * k));
            String begin = reverse(s.substring(i * 2 * k, Math.min(s.length(), i * 2 * k + k)));
            buffer.append(begin);
            if (substring.length() > k) {
                buffer.append(substring.substring(k));
            }
        }
        return buffer.toString();
    }

    private String reverse(String s) {
        StringBuffer buffer = new StringBuffer();
        for (int length = s.length(); length > 0; length--) {
            buffer.append(s.charAt(length - 1));
        }
        return buffer.toString();
    }

    @Test
    public void test() {
        String s = "1234";
        System.out.println("reverseStr(s) = " + reverseStr(s, 3));
    }

    @Test
    public void test2(){
        LRUCache cache = new LRUCache(2);
        cache.get(1);
        cache.put(1,1);
        cache.put(2,2);
        cache.get(1);
        cache.put(3,3);
        cache.put(4,4);
        cache.get(2);
        cache.get(3);
    }
}
