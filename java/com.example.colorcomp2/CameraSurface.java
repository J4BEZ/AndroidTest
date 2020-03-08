package com.example.colorcomp2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

//SurfaceView 카메라는 https://argc.tistory.com/237[SPRING :: NOTE 를 운영하시는
//RAYZIE님의 게시글을 참조하였습니다!

public class CameraSurface extends SurfaceView implements SurfaceHolder.Callback{

    Camera camera;
    boolean previewing = false;

    public CameraSurface(Context context) {
        super(context);
        camera = Camera.open();
    }

    @Override
    protected void onDraw(Canvas canvas){
        Paint p = new Paint();
        p.setStyle(Paint.Style.FILL_AND_STROKE);
        p.setColor(Color.GREEN);
        p.setTextSize(100);
        canvas.drawText("생활코딩 안녕하세요!", 20, 20, p);
    }

    // 카메라 위에 필터를 그리기 위해서예요!
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setWillNotDraw(false);
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        camera = Camera.open();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        if(previewing){
            camera.stopPreview();
            previewing = false;
        }

        if(camera != null){
            try{
                camera.setPreviewDisplay(holder);
                camera.startPreview();
                previewing = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        camera.stopPreview();
        camera.release();
        camera = null;
        previewing = false;
    }
}
