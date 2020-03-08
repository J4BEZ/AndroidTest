package com.example.colorcomp2;

import android.content.pm.ActivityInfo;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.SurfaceHolder;

import androidx.appcompat.app.AppCompatActivity;

public class CameraActivity extends AppCompatActivity {

    static CameraSurface cameraSurface;
    SurfaceHolder surfaceHolder;

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //화면을 가로로 고정합니다.
        getWindow().setFormat(PixelFormat.UNKNOWN);

        //새로운 layout인 activity_camera에 적용시켜줍시다
        setContentView(R.layout.activity_camera);
        cameraSurface = findViewById(R.id.camerasurface);
        surfaceHolder = cameraSurface.getHolder();
        surfaceHolder.addCallback(cameraSurface);
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }
}


