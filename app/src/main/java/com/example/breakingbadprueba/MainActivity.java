package com.example.breakingbadprueba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.breakingbadprueba.adapter.AdapterCharacter;
import com.example.breakingbadprueba.model.Character;
import com.example.breakingbadprueba.adapter.AdapterCharacter;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    public static final String URL ="https://www.breakingbadapi.com/api/characters";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ProcessHttp();//va a ser llamada
    }

    public void ProcessHttp(){
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(URL, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String data = new String(responseBody);
                Log.d("INFO",data);
                processCharacter(data);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    public void processCharacter(String data) {

        try {
            JSONArray person = new JSONArray(data);
            //recorrer la lista de todos los personajes
            List<Character> list = new ArrayList<>();
            for (int i = 0; i<person.length(); i++) {
                JSONObject character = person.getJSONObject(i);
                String name = character.getString("name");
                String img = character.getString("img");
                Character character2 = new Character(name,img);
                list.add(character2);
            }
            //cargar recycler
            RecyclerView rc = findViewById(R.id.rc_character);
            AdapterCharacter ad= new AdapterCharacter(this,list,R.layout.item_character);
            LinearLayoutManager lm = new LinearLayoutManager(this);
            lm.setOrientation(RecyclerView.VERTICAL);

            rc.setLayoutManager(lm);
            rc.setAdapter(ad);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}