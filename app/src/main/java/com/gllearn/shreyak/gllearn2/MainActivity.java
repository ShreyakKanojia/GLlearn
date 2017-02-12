package com.gllearn.shreyak.gllearn2;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.gllearn.shreyak.gllearn2.extras.AirHockeyRenderer;

public class MainActivity extends AppCompatActivity {

    Context mContext = this;


    private GLSurfaceView glSurfaceView;
    private boolean rendererIsSet = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        glSurfaceView = new GLSurfaceView(this);
        setContentView(glSurfaceView);


        final ActivityManager activityManager =
                (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        final ConfigurationInfo configurationInfo =
                activityManager.getDeviceConfigurationInfo();
        final boolean supportsEs2 = configurationInfo.reqGlEsVersion >= 0x20000;



        if (supportsEs2) {
        // Request an OpenGL ES 2.0 compatible context.
            glSurfaceView.setEGLContextClientVersion(2);
        // Assign our renderer.
            glSurfaceView.setRenderer(new AirHockeyRenderer(mContext));
            rendererIsSet = true;
        } else {
            Toast.makeText(this, "This device does not support OpenGL ES 2.0.",
                    Toast.LENGTH_LONG).show();
            return;
        }

    }


    @Override
    protected void onPause() {
        super.onPause();

        if(rendererIsSet){
            glSurfaceView.onPause();
        }
    }


    @Override
    protected void onResume() {
        super.onResume();

        if(rendererIsSet){
            glSurfaceView.onResume();
        }
    }
}
