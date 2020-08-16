package test;

import org.springframework.util.DigestUtils;

/**
 * @author
 * @date 2020/8/1-16:30
 */

public class TestMD5 {

    public static void main(String[] args) {
        String s = DigestUtils.md5DigestAsHex("111111".getBytes());
        System.out.println(s);

    }
}
