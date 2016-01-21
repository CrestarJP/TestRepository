package umetani.rolan.co.jp.samplecollection.sample.networking;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import umetani.rolan.co.jp.samplecollection.R;
import umetani.rolan.co.jp.samplecollection.core.task.SendRequestTask;

public class NetworkingActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_networking);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mContext = this;

        ConnectivityManager cm = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info != null && info.isConnected()) {
            Toast.makeText(this, String.format("%s connected", info.getTypeName()), Toast.LENGTH_SHORT).show();
            if(info.getType() == ConnectivityManager.TYPE_WIFI) {
                Toast.makeText(this, "working on WIFI", Toast.LENGTH_SHORT).show();
                new SendRequestToGoogle().executeSend();
            }

        }

    }

    /**
     * Send HTTP request to defined URL on executeSend
     * it can manage that response on onPostExecute
     */
    private class SendRequestToGoogle extends SendRequestTask {

        private final String SEND_URL = "http://www.google.co.jp";

        public void executeSend() {
            execute(SEND_URL);
        }

        @Override
        protected void onPostExecute(String result){
            Toast.makeText(mContext, result, Toast.LENGTH_LONG).show();
        }

    }

}
