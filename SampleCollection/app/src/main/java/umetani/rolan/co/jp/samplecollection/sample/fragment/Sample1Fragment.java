package umetani.rolan.co.jp.samplecollection.sample.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import umetani.rolan.co.jp.samplecollection.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class Sample1Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sample1, container, false);
    }
}
