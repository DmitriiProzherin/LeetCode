package org.behemoth.Easy;

import java.awt.event.PaintEvent;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Objects;

public class NumberOf1Bits {
    public static void main(String[] args) {

    }


    public static int hammingWeight(int n) {
        byte c = 0;
        while (n != 0) {
            c+= (byte) (n&1);
            n>>>=1;
        }
        return c;
    }
}
