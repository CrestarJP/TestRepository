package umetani.rolan.co.jp.samplecollection.sample.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import umetani.rolan.co.jp.samplecollection.R;

public class FragmentSampleActivity extends AppCompatActivity implements Sample2Fragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_sample);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        if (findViewById(R.id.fragment_container) != null) {
            if(savedInstanceState != null) {
                return;
            }

            Sample1Fragment fragment = new Sample1Fragment();
            Sample2Fragment fragment2 = Sample2Fragment.newInstance("","");
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment2)
                    .addToBackStack(null)
                    .commit();

        }

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
