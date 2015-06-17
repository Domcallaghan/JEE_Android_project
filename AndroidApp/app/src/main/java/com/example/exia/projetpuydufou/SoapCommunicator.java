package com.example.exia.projetpuydufou;

import android.os.StrictMode;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.ksoap2.SoapFault;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by Xavier on 11/06/2015.
 */
public class SoapCommunicator
{

    private static SoapCommunicator instance;

    private static final String NAMESPACE = "http://facade.com/";
    private static final String URL = "http://10.176.129.88:10080/fouService/fouService";
    private static final String SOAP_ACTION = "";

    private static final String METHOD_NAME_getAllSpectacles = "getAllSpectacles";
    private static final String METHOD_NAME_getSpectacleByName = "getSpectacle";
    private static final String METHOD_NAME_getSpectacleById = "getSpectacleById";
    private static final String METHOD_NAME_addSpectacle = "addSpectacle";
    private static final String METHOD_NAME_noterSpectacle = "noterSpectacle";
    private static final String METHOD_NAME_getBoutiqueById = "getBoutiqueById";
    private static final String METHOD_NAME_getAllBoutiques = "getAllBoutiques";
    private static final String METHOD_NAME_getRestaurantById = "getRestaurantById";
    private static final String METHOD_NAME_getAllRestaurants = "getAllRestaurant";
    private static final String METHOD_NAME_noterBoutique = "noterBoutique";

    private SoapCommunicator(){ /**/ } // Constructeur vide mais indispensable pour le singleton.

    public static SoapCommunicator getInstance() // Singleton de ouf.
    {

        if (null == instance)
        {

            instance = new SoapCommunicator(); // Création d'une instance à la demande.

        }

        return instance;

    }

    private SoapObject sendRequest(SoapObject request)
    {

        // Build Soap Message
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(request);
        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

        try
        {

            // Bypass error about requesting on main thread
            if (android.os.Build.VERSION.SDK_INT > 9)
            {

                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);

            }

            // Call WebService
            androidHttpTransport.call(SOAP_ACTION, envelope);

            // Print error
            //SoapFault fault = (SoapFault) envelope.bodyIn;
            //System.out.println(fault);

            // Print result

            SoapObject resultsRequestSOAP = (SoapObject) envelope.bodyIn;
            //System.out.println(resultsRequestSOAP);
            return resultsRequestSOAP;

        }

        catch (Exception e)
        {

            e.printStackTrace();

        }

        return null;

    }

    // Récupération des informations de tous les spectacles.
    public ArrayList<Spectacle> getAllSpectacles()
    {

        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME_getAllSpectacles);
        SoapObject result = sendRequest(request);

        ArrayList<Spectacle> listeSpectacles = new ArrayList<>();

        // On parcours la liste
        for (int i = 0; i < result.getPropertyCount(); i++)
        {

            SoapObject thisObject = (SoapObject)result.getProperty(i);

            // Pour chaque spectacle
            Spectacle spectacle = new Spectacle();

            spectacle.setId(Integer.parseInt(thisObject.getPropertyAsString("idSpectacle")));
            spectacle.setNom(new String(thisObject.getPropertyAsString("nomSpectacle")));
            spectacle.setDuree(Float.parseFloat(thisObject.getPropertyAsString("dureeSpectacle")));
            spectacle.setNbrActeurs(Integer.parseInt(thisObject.getPropertyAsString("nombreActeurs")));
            spectacle.setEvenement(new String(thisObject.getPropertyAsString("evenementHistoriqueSpectacle")));
            spectacle.setNote(Float.parseFloat(thisObject.getPropertyAsString("noteSpectacle")));
            spectacle.setLocalisation(new String(thisObject.getPropertyAsString("localisation")));
            spectacle.setCommentaire(new String(thisObject.getPropertyAsString("commentairesSpectacles")));

            listeSpectacles.add(spectacle);

        }

        return listeSpectacles;

    }

    // Récupération des informations d'un spectacle par ID.
    public ArrayList<Spectacle> getSpectacleById(int id)
    {

        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME_getAllSpectacles);
        SoapObject result = sendRequest(request);

        ArrayList<Spectacle> listeSpectacles = new ArrayList<>();

        SoapObject thisObject = (SoapObject)result.getProperty(id - 1); // -1 car pas d'ID 0 en base.

        // Pour chaque spectacle
        Spectacle spectacle = new Spectacle();

        spectacle.setId(Integer.parseInt(thisObject.getPropertyAsString("idSpectacle")));
        spectacle.setNom(new String(thisObject.getPropertyAsString("nomSpectacle")));
        spectacle.setDuree(Float.parseFloat(thisObject.getPropertyAsString("dureeSpectacle")));
        spectacle.setNbrActeurs(Integer.parseInt(thisObject.getPropertyAsString("nombreActeurs")));
        spectacle.setEvenement(new String(thisObject.getPropertyAsString("evenementHistoriqueSpectacle")));
        spectacle.setNote(Float.parseFloat(thisObject.getPropertyAsString("noteSpectacle")));
        spectacle.setLocalisation(new String(thisObject.getPropertyAsString("localisation")));
        spectacle.setCommentaire(new String(thisObject.getPropertyAsString("commentairesSpectacles")));

        listeSpectacles.add(spectacle);

        return listeSpectacles;

    }

    // Récupération des informations d'une boutique par ID.
    public ArrayList<Boutique> getBoutiqueById(int id)
    {

        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME_getBoutiqueById);
        SoapObject result = sendRequest(request);

        ArrayList<Boutique> listeBoutique = new ArrayList<>();

        SoapObject thisObject = (SoapObject)result.getProperty(id - 1); // -1 car pas d'ID 0 en base.

        Boutique boutique = new Boutique();

        boutique.setId(Integer.parseInt(thisObject.getPropertyAsString("idBoutique")));
        boutique.setLocalisation(new String(thisObject.getPropertyAsString("localisationBoutique")));
        boutique.setNom(new String(thisObject.getPropertyAsString("nomBoutique")));
        boutique.setNote(Float.parseFloat(thisObject.getPropertyAsString("noteBoutique")));
        boutique.setNbrNotes(Integer.parseInt(thisObject.getPropertyAsString("nbNotes")));

        listeBoutique.add(boutique);

        return listeBoutique;

    }

    // Noter une boutique.
    public void noterBoutique(int id, float note)
    {

        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME_noterBoutique);

        request.addProperty("id", id - 1);
        request.addProperty("note", note);

        SoapObject result = sendRequest(request);

    }

}
