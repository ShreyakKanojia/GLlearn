package com.gllearn.shreyak.gllearn2.util;

/**
 * Created by Shreyak on 2/18/2017.
 */

public class MatrixHelper {


    public static void perspectiveM(float[] m, float yFovInDegrees, float aspect,
                                    float n, float f) {

        final float angleInRadians = (float) (yFovInDegrees * Math.PI / 180.0);
        final float a = (float) (1.0 / Math.tan(angleInRadians / 2.0));

        m[0] = a / aspect; //c0r0
        m[1] = 0f; //c0r1
        m[2] = 0f; //c0r2
        m[3] = 0f; //c0r3
        m[4] = 0f; //c1r0
        m[5] = a;
        m[6] = 0f;
        m[7] = 0f;
        m[8] = 0f;
        m[9] = 0f;
        m[10] = -((f + n) / (f - n));
        m[11] = -1f;
        m[12] = 0f;
        m[13] = 0f;
        m[14] = -((2f * f * n) / (f - n));
        m[15] = 0f;
    }


}
