package com.example.com.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.zip.Inflater;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setTitle("그리드뷰 영화 포스터");

        final GridView gv = (GridView) findViewById(R.id.gridView1);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);
    }

    public class MyGridAdapter extends BaseAdapter {
        LayoutInflater inflater;
        Context context;

        public MyGridAdapter(Context c) {
            context = c;
            inflater = LayoutInflater.from(context);
        }

        public int getCount() {
            return posterID.length;
        }

        public Object getItem(int arg0) {
            return null;
        }

        public long getItemId(int arg0) {
            return 0;
        }

        Integer[] posterID = { R.drawable.a, R.drawable.b, R.drawable.c,
                R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g,
                R.drawable.h, R.drawable.i, R.drawable.j, R.drawable.k,
                R.drawable.l };

        String[] posterTitle={"말아톤","레미제라블","크로싱","엘리시움", "아바타",
                "화려한휴가", "셜록홈즈", "더 테러라이브", "로보캅", "300", "몬스터", "감기"
        };

        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.dialog, null);
            ImageView imageview = (ImageView)view.findViewById(R.id.imageView1);
            TextView textView=(TextView)view.findViewById(R.id.textView1);
            //imageview.setLayoutParams(new GridView.LayoutParams(100, 150));
            imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageview.setPadding(5, 5, 5, 5);
            imageview.setImageResource(posterID[position]);
            textView.setText(posterTitle[position]);
            final int pos = position;

            imageview.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    View dialogView = (View) View.inflate(MainActivity.this,
                            R.layout.dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(
                            MainActivity.this);

                    ImageView ivPoster = (ImageView) dialogView
                            .findViewById(R.id.imageView1);
                    ivPoster.setImageResource(posterID[pos]);


                    dlg.setTitle(posterTitle[pos]);
                    dlg.setIcon(R.drawable.image);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();
                }
            });
            return view;
        }
    }

}
