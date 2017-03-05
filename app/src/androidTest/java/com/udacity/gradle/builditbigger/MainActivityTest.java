package com.udacity.gradle.builditbigger;

import android.content.Context;

import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

/**
 * Created by emanu on 01/03/2017.
 */
public class MainActivityTest {
    Context mContext;
    @Test
    public void tellJoke() throws Exception {
        EndpointsAsyncTask task = new EndpointsAsyncTask(mContext);
        String output = null;
        try {
            output = task.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertNotNull(output);

    }

}