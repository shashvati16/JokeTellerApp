package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.gradle.joke.backend.myApi.MyApi;
import com.gradle.jokeandroidlib.jokes.JokeActivity;

import java.io.IOException;
/**
 * Created by MCLAB on 6/8/2017.
 */
public class
EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    @Override
    protected String doInBackground(Context... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("https://finalproject-170216.appspot.com/_ah/api/");
            // end options for devappserver
            myApiService = builder.build();
        }
        context = params[0];
        try {
            return myApiService.tellJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String jokes) {
        Intent intent = new Intent(context,JokeActivity.class);
        intent.putExtra(JokeActivity.JOKE_KEY,jokes);
        context.startActivity(intent);
    }
}

