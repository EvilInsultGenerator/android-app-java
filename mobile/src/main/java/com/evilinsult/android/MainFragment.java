package com.evilinsult.android;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }

    private TextView txtResult;
    private Button btnShow;
    private String language="en";
    private Spinner spinner;
    Languages languages=new Languages();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        txtResult = (TextView) rootView.findViewById(R.id.result);
        btnShow = (Button) rootView.findViewById(R.id.main_button);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new dolt().execute();
            }
        });


        spinner=(Spinner)rootView.findViewById(R.id.lang_button);

        String[] plants = new String[]{
                "English",
                "Spanish",
                "Chinese",
                "Hindi",
                "Arabic",
                "Portuguese",
                "Bengali",
                "Russian",
                "Japanese",
                "Javanese",
                "Swahili",
                "German",
                "Korean",
                "French",
                "Telugu",
                "Marathi",
                "Turkish",
                "Tamil",
                "Vietnamese",
                "Urdu",
                "Greek",
                "Italian",
                "Czech",
                "Latin"
        };

        // Initializing an ArrayAdapter
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                getActivity().getApplicationContext(),R.layout.spinner_item,plants
        );
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(spinnerArrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                language=languages.getLang(parent.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        // Inflate the layout for this fragment
        return rootView;
    }

    public class dolt extends AsyncTask<Void, Void, Void> {
        String title;

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Document doc1 = Jsoup.connect("http://evilinsult.com/generate_insult.php?lang="+language).get();
                title = doc1.text();

            } catch (Exception ex) {
                ex.printStackTrace();



            }
            return null;
        }

        @Override
        protected void onPostExecute(Void avoid) {
            super.onPostExecute(avoid);
            txtResult.setText(title);
        }
    }


}