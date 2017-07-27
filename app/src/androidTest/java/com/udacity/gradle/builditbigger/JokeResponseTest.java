package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.text.TextUtils;
import android.util.Log;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static junit.framework.Assert.assertTrue;

/**
 * Created by MCLAB on 6/16/2017.
 */
@RunWith(AndroidJUnit4.class)
public class JokeResponseTest{
    public JokeResponseTest() {}    

    @Test
    public void testTellJoke() {
        EndpointsAsyncTask task = new EndpointsAsyncTask();

        try {
            task.execute();
            String response =task.get(3, TimeUnit.SECONDS);
            assertTrue(!TextUtils.isEmpty(response));
        } catch (TimeoutException | InterruptedException | ExecutionException exception) {
            Log.e(JokeResponseTest.class.getSimpleName(), exception.getMessage(), exception);
        }
    }
}


