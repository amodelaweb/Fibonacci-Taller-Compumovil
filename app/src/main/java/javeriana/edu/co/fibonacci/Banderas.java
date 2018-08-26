package javeriana.edu.co.fibonacci;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Banderas extends AppCompatActivity {

    private List<Pais> paises ;
    private ListView lista ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banderas);
        this.paises = new ArrayList<Pais>() ;
        lista = (ListView) findViewById(R.id.listita);
        loadDataFromString();


        lista.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(view.getContext(),pais.class);
                intent.putExtra("Pais",paises.get(i));
                startActivity(intent);
            }
        });




}

public String loadJSONFromAsset() {
    String json = null;
    try {
        InputStream is = this.getAssets().open("paises.json");
        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();
        json = new String (buffer,"UTF-8");
    } catch (IOException e) {
        e.printStackTrace();
        return null ;
    }
    return json ;
}

private void loadDataFromString(){

    try {
        ArrayList<String> list = new ArrayList<String>();

        JSONObject json = new JSONObject(loadJSONFromAsset());
        JSONArray paisesJsonArray = json.getJSONArray("paises");
        for(int i=0 ; i < paisesJsonArray.length() ; i++){
            JSONObject jsonObject = paisesJsonArray.getJSONObject(i);
            list.add(jsonObject.getString("nombre_pais"));
            this.paises.add(new Pais(jsonObject.getString("capital"),jsonObject.getString("nombre_pais"),jsonObject.getString("nombre_pais_int"),jsonObject.getString("sigla")));
        }
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        lista.setAdapter(listAdapter);

    } catch (JSONException e) {
        e.printStackTrace();
    }

}
}

