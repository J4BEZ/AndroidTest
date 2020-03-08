package com.example.colorcomp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button cameraButton;
    ImageView img;

    final static int TAKE_PICTURE = 1001;   //requestCode를 위해서

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cameraButton = findViewById(R.id.cameraButton);
        cameraButton.setOnClickListener(this);
        //카메라 버튼을 부착합니다.


        img = findViewById(R.id.imageView);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.cameraButton:
                Intent camSurf = new Intent(getApplicationContext(), CameraActivity.class);
                startActivityForResult(camSurf,TAKE_PICTURE);
                break;
        }
    }




}
