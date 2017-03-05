package com.udacity.gradle.builditbigger;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.aprendizagem.projeto.mynewnewlibraryandroid.MyClassAndroidLib;
import com.example.emanu.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by emanu on 28/02/2017.
 */
class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    private Button button;
    private ProgressBar loading;
    private boolean containViews;

    public EndpointsAsyncTask(Context context) {
        this.context = context;
        containViews = false;
    }

    public EndpointsAsyncTask(Context context, View view) {
        this.context = context;
        button = (Button) view.findViewById(R.id.button_joke);
        loading = (ProgressBar) view.findViewById(R.id.progress_bar);
        containViews = true;
    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if(myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://projeto-final-158219.appspot.com/_ah/api/");
            myApiService = builder.build();
        }
        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (containViews) {
            button.setVisibility(View.GONE);
            loading.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if (context instanceof Activity) {
            Intent intent = new Intent(context, MyClassAndroidLib.class);
            intent.putExtra(MyClassAndroidLib.TAG_JOKE, result);
            context.startActivity(intent);
        }

        if (containViews) {
            button.setVisibility(View.VISIBLE);
            loading.setVisibility(View.GONE);
        }
    }
}
