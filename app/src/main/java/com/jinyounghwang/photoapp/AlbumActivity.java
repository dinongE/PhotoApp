package com.jinyounghwang.photoapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

/**
 * Created by Jinyoung Hwang on 2015-11-17.
 */
public class AlbumActivity extends Activity implements AdapterView.OnItemClickListener{
    GridView gridView;
    AlbumAdapter albumAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_layout);
        gridView = (GridView)findViewById(R.id.gridView);
        albumAdapter = new AlbumAdapter(this);
        gridView.setAdapter(albumAdapter);
        gridView.setOnItemClickListener(this);/* 리스너와 연결*/

    }

    public void btnClick(View view) {
        finish();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d(this.getClass().getName(), position+"번째거 나누름?");
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("image", view.);
    }
}
