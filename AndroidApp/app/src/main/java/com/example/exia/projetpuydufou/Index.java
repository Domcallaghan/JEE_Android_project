package com.example.exia.projetpuydufou;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class Index extends ActionBarActivity
{

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        final Button bt_plannings = (Button) findViewById(R.id.bt_plannings); // Plannings.
        bt_plannings.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                startActivity(new Intent(Index.this, Plannings.class));

            }

        });

        final Button bt_services = (Button) findViewById(R.id.bt_services); // Services.
        bt_services.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                startActivity(new Intent(Index.this, Services.class));

            }

        });

        final Button bt_spectacles = (Button) findViewById(R.id.bt_spectacles); // Spectacles.
        bt_spectacles.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                startActivity(new Intent(Index.this, Spectacles.class));

            }

        });

        final Button bt_fileAttente = (Button) findViewById(R.id.bt_fileAttente); // File d'attente.
        bt_fileAttente.setOnClickListener(new View.OnClickListener()
        {

            public void onClick(View v)
            {

                startActivity(new Intent(Index.this, FileAttente.class));

            }

        });

        final Button bt_partage = (Button) findViewById(R.id.bt_partage); // Partage.
        bt_partage.setOnClickListener(new View.OnClickListener()
        {

            public void onClick(View v)
            {

                startActivity(new Intent(Index.this, Partage.class));

            }

        });

        final Button bt_plan = (Button) findViewById(R.id.bt_plan); // Plan du parc.
        bt_plan.setOnClickListener(new View.OnClickListener()
        {

            public void onClick(View v)
            {

                startActivity(new Intent(Index.this, PlanParc.class));

            }

        });

    }

}
