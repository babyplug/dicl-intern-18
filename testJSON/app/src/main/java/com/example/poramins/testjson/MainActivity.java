package com.example.poramins.testjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView lv ;
    String[] NAMES;
    String url="";
    ImageView img;

    JSONArray arr;
    int[] IMAGES = {R.drawable.pos1, R.drawable.pos2, R.drawable.pos3, R.drawable.pos4
            , R.drawable.pos5, R.drawable.pos6, R.drawable.pos7};

    //private String[] DESCRIPTIONS = {"This picture is a rare.", "This picture is a rare."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getJson();
        lv = (ListView)findViewById(R.id.list_view);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,NAMES);
        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView tv = (TextView)view;
        /*TextView name = findViewById(R.id.nameView), year = findViewById(R.id.yearView),
                runtime = findViewById(R.id.runtimeView), director = findViewById(R.id.directorView)
                , actors = findViewById(R.id.actorView), plot = findViewById(R.id.plotView);*/

        JSONObject obj;

        try {
            obj = arr.getJSONObject(position);
            setContentView(R.layout.decriptionlayout);
            Toast.makeText(this,"You click on "+tv.getText(),Toast.LENGTH_LONG).show();
            TextView name = findViewById(R.id.nameView);
            name.setText(obj.getString("name"));
            TextView year = findViewById(R.id.yearView);
            year.setText(obj.getString("year"));
            TextView runtime = findViewById(R.id.runtimeView);
            runtime.setText(obj.getString("runtime"));
            TextView director = findViewById(R.id.directorView);
            director.setText(obj.getString("director"));
            TextView actors = findViewById(R.id.actorView);
            actors.setText(obj.getString("actors"));
            TextView plot = findViewById(R.id.plotView);
            plot.setText(obj.getString("plot"));
            img= findViewById(R.id.imgView);
            //img.setImageResource(IMAGES[position]);


            url = obj.getString("posterUrl");
            loadImageFromUrl(url);

        }catch (JSONException e){
            e.printStackTrace();
        }

    }

    private void loadImageFromUrl(String url) {
        Picasso.get().load(url).into(img);
    }

    public void getJson(){
        String json;
        InputStream is;

        try{
            is = getAssets().open("movie.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer,"UTF-8");
            arr = new JSONArray(json);
            NAMES = new String[arr.length()];
            for (int i=0; i< arr.length();i++){
                JSONObject obj = arr.getJSONObject(i);
                NAMES[i] = obj.getString("name");
            }
            //Toast.makeText(this,"name: "+name[0],Toast.LENGTH_LONG).show();
        }catch (JSONException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

    }


}
