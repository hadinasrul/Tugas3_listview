package simple.example.hewanpedia;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import simple.example.hewanpedia.model.Pedia;

public class ProfilActivity extends AppCompatActivity {

    Pedia pedia;
    TextView txJudul,txJenis,txAsal,txDeskripsi;
    ImageView ivFotoPedia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_ras);
        Intent intent = getIntent();
        pedia = (Pedia) intent.getSerializableExtra(DaftarPediaActivity.PEDIA_TERPILIH);
        inisialisasiView();
        tampilkanProfil(pedia);
    }

    private void inisialisasiView() {
        txJudul = findViewById(R.id.txJudul);
        txJenis = findViewById(R.id.txJenis);
        txAsal = findViewById(R.id.txAsal);
        txDeskripsi = findViewById(R.id.txDeskripsi);
        ivFotoPedia = findViewById(R.id.gambarPedia);
    }


    private void tampilkanProfil(Pedia pedia) {
        Log.d("Profil","Menampilkan "+pedia.getJenis());
        txJudul.setText(pedia.getJenis());
        txJenis.setText(pedia.getRas());
        txAsal.setText(pedia.getAsal());
        txDeskripsi.setText(pedia.getDeskripsi());
        ivFotoPedia.setImageDrawable(this.getDrawable(pedia.getDrawableRes()));
    }




}