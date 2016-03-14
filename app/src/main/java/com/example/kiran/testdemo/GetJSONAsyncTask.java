package com.example.kiran.testdemo;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiran on 3/9/2016.
 */
public class GetJSONAsyncTask extends AsyncTask<Void,Void,List<City>>{
    Context context;
    String serviceEndPoint;
    ProgressDialog progressDialog;
    BufferedReader rd  = null;
    StringBuilder sb = null;
    String line = null;
    TextView textView;
    boolean success;
    Spinner spinner;
    List<City> responseName;
    List<City> cityList = new ArrayList<>();
    public GetJSONAsyncTask(Context context,String serviceEndPoint,TextView textView,Spinner spinner){
        this.context = context;
        this.serviceEndPoint = serviceEndPoint;
        this.textView = textView;
        this.spinner = spinner;
    }

    @Override
    protected List<City> doInBackground(Void...arg0) {
        try {
            URL url = new URL("http://express-it.optusnet.com.au/sample.json");
            URLConnection conexion = url.openConnection();
            HttpURLConnection httpURLConnection = (HttpURLConnection) conexion;
            // httpURLConnection.setRequestProperty("Accept-Encoding", "");
             httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setReadTimeout(10 * 1000);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode()==200){
                rd  = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                sb = new StringBuilder();

                while ((line = rd.readLine()) != null)
                {
                    sb.append(line + '\n');
                }
                 //sb.toString();
                    //System.out.println(sb);


                JSONArray jsonArray = new JSONArray(sb.toString());
               for (int i = 0; i<jsonArray.length(); i++){
                   JSONObject jsonObject = jsonArray.getJSONObject(i);
                   String name = jsonObject.getString("name");
                   JSONObject fromcentral = jsonObject.getJSONObject("fromcentral");
                   JSONObject location = jsonObject.getJSONObject("location");
                   String car = fromcentral.getString("car");
                   City city = new City();
                   try {
                       String train = fromcentral.getString("train");
                       city.setTrain(train);
                   }catch (Exception e){
                       city.setTrain("N/A");
                   }

                   double latitude = location.getDouble("latitude");
                   double longitude = location.getDouble("longitude");

                   city.setName(name);
                   city.setCar(car);
                   city.setLatitude(latitude);
                   city.setLongitude(longitude);

                   cityList.add(city);
                   responseName = cityList;
                   //System.out.println("Your Name is = "+name);
               }

                MainActivity.success = true;
                ((HttpURLConnection) conexion).disconnect();

            }
        }catch (Exception e){
            e.printStackTrace();

            MainActivity.success = false;
        }

        return responseName;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        progressDialog.setCancelable(false);
    }

    @Override
    protected void onPostExecute(List<City> cityList) {
        super.onPostExecute(cityList);
        progressDialog.dismiss();
        //System.out.println("size="+cityList.size());
        if (cityList !=null){
            CityListAdapter   spinnerAdapter = new CityListAdapter(context,cityList);
            spinner.setAdapter(spinnerAdapter);
        }

    }
}
