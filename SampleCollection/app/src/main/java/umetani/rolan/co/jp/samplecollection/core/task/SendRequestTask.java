package umetani.rolan.co.jp.samplecollection.core.task;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by umetani on 2016/01/20.
 */
public class SendRequestTask extends AsyncTask<String, Void, String> {

    private int len = 500;

    @Override
    protected String doInBackground(String... params) {
        String result = null;
        try {
            result = sendGetRequest(params[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    private String sendGetRequest(String url) throws IOException {
        String result = null;
        InputStream is = null;

        URL requestUrl = new URL(url);
        HttpURLConnection con = (HttpURLConnection)requestUrl.openConnection();
        con.setReadTimeout(10000);
        con.setRequestMethod("GET");
        con.setDoInput(true);

        con.connect();
        int response = con.getResponseCode();
        Log.d(this.getClass().getSimpleName(), String.format("The response is: %d", response));
        is = con.getInputStream();

        result = convertResponse(is, len);
        return result;
    }

    private String convertResponse(InputStream is, int len) throws IOException {
        Reader reader = null;
        reader = new InputStreamReader(is, "UTF-8");
        char[] buffer = new char[len];
        reader.read(buffer);
        return new String(buffer);
    }
}
