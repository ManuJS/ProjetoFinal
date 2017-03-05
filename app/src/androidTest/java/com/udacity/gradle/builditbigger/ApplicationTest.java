package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.content.Context;
import android.test.ApplicationTestCase;

import org.junit.Test;

import java.util.concurrent.ExecutionException;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

    Context mContext;

    public ApplicationTest() {
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mContext = getContext();
    }

    @Test
    public void testJokes() {
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