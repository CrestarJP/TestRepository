package umetani.rolan.co.jp.samplecollection.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import umetani.rolan.co.jp.samplecollection.R;
import umetani.rolan.co.jp.samplecollection.sample.bgoperation.BGOperationMenuActivity;
import umetani.rolan.co.jp.samplecollection.sample.fragment.FragmentSampleActivity;
import umetani.rolan.co.jp.samplecollection.sample.networking.NetworkingActivity;

public class MainActivity extends AppCompatActivity {

    private Activity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mContext = this;

        Button bgOperationBtn = (Button)findViewById(R.id.bgOperationBtn);
        bgOperationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, BGOperationMenuActivity.class);
                startActivity(intent);
            }
        });

        Button fragmentBtn = (Button)findViewById(R.id.mainFragmentBtn);
        fragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, FragmentSampleActivity.class);
                startActivity(intent);
            }
        });

        Button networkBtn = (Button)findViewById(R.id.mainNetworkBtn);
        networkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, NetworkingActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent();
            intent.setAction(Settings.ACTION_SETTINGS);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
