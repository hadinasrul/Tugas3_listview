package simple.example.hewanpedia;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import simple.example.hewanpedia.model.Pedia;

public class DaftarPediaActivity extends AppCompatActivity {
    public final static String PEDIA_TERPILIH ="pedia_obj_key";
    List<Pedia> pedias;
    ListView listView;
    String jenisPedia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_pedia);
        Intent intent = getIntent();
        jenisPedia = intent.getStringExtra(MainActivity.JENIS_GALERI_KEY);
        TextView txJudul = findViewById(R.id.text_title_daftar);
        txJudul.setText("DAFTAR BERBAGAI RAS "+jenisPedia.toUpperCase());
        pedias = DataProvider.getPediasByTipe(this,jenisPedia);
        setupListView();
    }

    private void setupListView() {
        listView = findViewById(R.id.listview_daftar_pedia);
        DaftarPediaAdapter adapter = new DaftarPediaAdapter(this,pedias);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(onListClik);
    }

    private AdapterView.OnItemClickListener onListClik = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            Pedia terpilih = pedias.get(position);
            bukaProfilePedia(terpilih);
        }
    };

    private void bukaProfilePedia(Pedia pediaTerpilih) {
        Log.d("MAIN","Buka activity galeri");
        Intent intent = new Intent(this, ProfilActivity.class);
        intent.putExtra(PEDIA_TERPILIH, pediaTerpilih);
        startActivity(intent);
    }


}