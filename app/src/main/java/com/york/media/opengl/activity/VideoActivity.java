package com.york.media.opengl.activity;

import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.york.media.opengl.R;
import com.york.media.opengl.demo.video.GLVideoRenderer;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {
                GLSurfaceView glSurfaceView = findViewById(R.id.glSurfaceView);
                glSurfaceView.setEGLContextClientVersion(2);
                glSurfaceView.setRenderer(new GLVideoRenderer(VideoActivity.this, result));
                glSurfaceView.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
            }
        }).launch("video/*");
    }
}