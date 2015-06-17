package com.example.exia.projetpuydufou;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Spectacles extends ActionBarActivity
{

    ListView vue;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spectacles);

        TextView tv = (TextView) findViewById(R.id.textView5);

        fillSpectaclesList();

    }

    public void fillSpectaclesList()
    {

        vue = (ListView) findViewById(R.id.listView);

        SoapCommunicator sc = SoapCommunicator.getInstance(); // Appel d'une instance de singleton SoapCommunicator.

        ArrayList<Spectacle> listeSpectacles = new ArrayList<Spectacle>();

        listeSpectacles = sc.getAllSpectacles();

        System.out.println(listeSpectacles.size() + " elements");

        listeSpectacles = sc.getAllSpectacles();

        List<HashMap<String, String>> liste = new ArrayList<HashMap<String, String>>();

        HashMap<String, String> element;

        for(int i = 0 ; i < listeSpectacles.size(); i++) {

            element = new HashMap<String, String>();

            element.put("text1", listeSpectacles.get(i).getNom());
            element.put("text2", Float.toString(listeSpectacles.get(i).getDuree()));

            liste.add(element);
        }

        ListAdapter adapter = new SimpleAdapter(this, liste, android.R.layout.simple_list_item_2, new String[] {"text1", "text2"},new int[] {android.R.id.text1, android.R.id.text2 });

        vue.setAdapter(adapter);

    }

}
