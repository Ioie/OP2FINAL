package francisco.villalba.parcial.facitec.edu.py.op2final;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import retrofit.RetrofitError;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.client.Response;

public class MainPrincipal extends AppCompatActivity {

    ListView BatmanListview ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_principal);
        BatmanListview = (ListView) findViewById(R.id.listViewBatman);
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("http://www.omdbapi.com").build();
        BatmanService servicio = restAdapter.create(BatmanService.class);



        servicio.obtenerBatman(new Callback<Resultado>() {
            @Override
            public void success(Resultado resultado, Response response) {
                AdapterBat adapter = new AdapterBat(getApplicationContext(), resultado.Search);
                BatmanListview.setAdapter(adapter);


                //TODO AVATAR

            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("ERROR", error.getMessage());

                Toast.makeText(getApplicationContext(), error.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });


    }
}
