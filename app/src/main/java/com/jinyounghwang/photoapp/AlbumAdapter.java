package com.jinyounghwang.photoapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ImageReader;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Jinyoung Hwang on 2015-11-17.
 */
public class AlbumAdapter extends BaseAdapter {
    Context context;
    ArrayList<ImageView> list = new ArrayList<ImageView>();

    public AlbumAdapter(Context context) {
        this.context = context;
        init();
    }

    //sd 카드내의 사진이 있는 경로를 조사하여, ArrayList 에 담아서 사진출력!!
    public void init() {
        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/MyMedia/Photo";
        File file = new File(path);
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {/* 디렉토리가 아닌 파일이라면 */
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 16;
                Bitmap bitmap = BitmapFactory.decodeFile(files[i].getAbsolutePath(), options);
                ImageView imageView = new ImageView(context);
                 /* 그래픽의 왜곡처리를 담당하는 객체인 Matrix 를 써본다 */
                Matrix matrix = new Matrix();
                matrix.postRotate(90);
                Bitmap rotateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                imageView.setImageBitmap(rotateBitmap);
                list.add(imageView);
            }
        }


    }

    @Override
    public int getCount() {

        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = null;
        view = list.get(position);
        return view;
    }
}
