package com.aprendizagem.projeto.mynewnewlibraryandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by emanu on 24/02/2017.
 */

public class MyClassAndroidLib extends AppCompatActivity {

    public final static String TAG_JOKE = "joke";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_class_android_lib);

        String joke = getIntent().getStringExtra(TAG_JOKE);
        TextView jokeContainer = (TextView) findViewById(R.id.container_joke);
        jokeContainer.setText(joke);
    }
}
