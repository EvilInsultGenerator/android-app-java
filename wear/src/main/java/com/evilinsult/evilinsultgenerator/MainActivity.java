package com.evilinsult.android;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class MainActivity extends Activity {

    private TextView mTextView;
    private TextView txtResult;
    private String language="en";
    private Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.result);
                txtResult = (TextView)findViewById(R.id.result);
                btnShow=(Button)findViewById(R.id.show);

                btnShow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        new dolt().execute();
                    }
                });

            }
        });

    }

    public class dolt extends AsyncTask<Void, Void, Void> {
        String title;

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Document doc1 = Jsoup.connect("http://evilinsult.com/generate_insult.php?lang=en").get();
                title = doc1.text();
            } catch (Exception ex) {
                ex.printStackTrace();
                title= ex.getMessage();

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
