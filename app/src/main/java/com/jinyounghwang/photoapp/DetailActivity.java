package com.jinyounghwang.photoapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by Jinyoung Hwang on 2015-11-17.
 */
public class DetailActivity extends Activity{
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);
        imageView = (ImageView)findViewById(R.id.detailImage);
        Intent intent = new Intent();
        intent.getExtras().
    }
    public void init()
}
