package com.example;

import java.math.BigInteger;

public class StudyIntegralTypes {

	public static void main(String[] args) {
		// byte, short, int, long
		// byte: 1-Byte -> [-128..127]
		byte b = 127;
        b++;
        System.out.println("b: "+b);
        // short: 2-Byte: [-32768..32767]
        // System.out.println(Short.MIN_VALUE);
        // System.out.println(Short.MAX_VALUE);
        short s = 32767;
        s++;
        System.out.println("s: "+s);
        // int: 4-Byte [-2147483648..2147483647]
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        int i = -2147483648;
        System.out.println("i: "+i);
        i--;
        System.out.println("i: "+i);
        // long: 8-Byte [-9223372036854775808..9223372036854775807]
        System.out.println(Long.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);
        long x = 9223372036854775807L;
        System.out.println("x: "+x);
        x++;
        System.out.println("x: "+x);
        // Caution!
        long u;
        int  v = 2147483647;
        u = v + 1L;
        System.out.println("u: "+u);
        byte p=127,q=1,r=0;
        // r = (byte)(p + q);
        // r = (byte)(r + p + q);
        r += p + q;
        System.out.println("r: "+r);
        // Caution!
        // java.lang.ArithmeticException: / by zero
        // int w = -1/0;
        // System.out.println("w: "+w);
        long k = 12345 + 5432L;
        System.out.println("k= "+k);
        // CPU: ALU
        // Immutable
        BigInteger bi = BigInteger.valueOf(9223372036854775807L);
        bi = bi.multiply(bi);
        System.out.println(bi);
	}

}
