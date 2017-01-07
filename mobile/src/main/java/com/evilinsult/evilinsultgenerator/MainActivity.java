package com.evilinsult.android;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView = null;
    Toolbar toolbar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set the fragment initially
        MainFragment fragment = new MainFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        TextView txtSubject = (TextView) findViewById(R.id.result);
        if (id == R.id.action_settings) {
            Intent share=new Intent(Intent.ACTION_SEND);
            share.setType("text/plain");
            String shareBody=txtSubject.getText().toString()+"\n\nhttps://evilinsult.com/";
            String shareSubject=txtSubject.getText().toString();
            share.putExtra(Intent.EXTRA_SUBJECT,shareSubject);
            share.putExtra(Intent.EXTRA_TEXT,shareBody);
            startActivity(Intent.createChooser(share,"Share using"));
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_proposal) {
            //Set the fragment initially

            Intent intent = new Intent();
            String uriText =
                    "mailto:marvin@evilinsult.com" +
                            "?subject=" + URLEncoder.encode("Evil\bInsult\bGenerator\bProposal") +
                            "&body=" + URLEncoder.encode("Hej\bfuckers,\n\n" +
                            "please\badd\bthis\bbeauty:\n\n" +
                            "insult:...\n" +
                            "language:...\n" +
                            "comment\b(optional):...\n\n...");

            Uri uri = Uri.parse(uriText);

            Intent sendIntent = new Intent(Intent.ACTION_SENDTO);
            sendIntent.setData(uri);
            startActivity(Intent.createChooser(sendIntent, "Send email"));
        } else if (id == R.id.nav_facebook) {
            //Set the fragment initially

            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/EvilInsultGenerator/"));
            startActivity(intent);

        } else if (id == R.id.nav_twitter) {
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/__E__I__G__"));
            startActivity(intent);

        } else if (id == R.id.nav_newsletter) {
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://evilinsult.com/newsletter/"));
            startActivity(intent);

        } else if (id == R.id.nav_contact) {

            Intent intent = new Intent();
            String uriText =
                    "mailto:marvin@evilinsult.com" +
                            "?subject=" + URLEncoder.encode("Evil\bInsult\bGenerator\bContact") +
                            "&body=" + URLEncoder.encode("Marvin,\bfuck\byou!");

            Uri uri = Uri.parse(uriText);

            Intent sendIntent = new Intent(Intent.ACTION_SENDTO);
            sendIntent.setData(uri);
            startActivity(Intent.createChooser(sendIntent, "Send email"));

        } else if (id == R.id.nav_website) {
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://evilinsult.com/"));
            startActivity(intent);
        }else if (id == R.id.nav_legal) {
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://evilinsult.com/legal.html"));
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    String url;
    public void browser(View view){
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);

    }
}