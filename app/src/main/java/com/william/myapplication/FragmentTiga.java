package com.william.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentTiga extends Fragment {

    View view;
    Button btnHitungBalok, btnHitungPiramida, btnHitungTabung;
    EditText BPanjang, BLebar, BTinggi, PTinggi, PSisi, TJari, TTinggi;
    TextView HBalok, HPiramida, HTabung;

    double AnsTempBalok = 0;
    double AnsTempPiramida = 0;
    double AnsTempTabung = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragmenttiga, container, false);

        btnHitungBalok = (Button) view.findViewById(R.id.BTN_Balok);
        btnHitungPiramida = (Button) view.findViewById(R.id.BTN_Piramida);
        btnHitungTabung = (Button) view.findViewById(R.id.BTN_Tabung);

        BPanjang = (EditText) view.findViewById(R.id.Panjang);
        BLebar = (EditText) view.findViewById(R.id.Lebar);
        BTinggi = (EditText) view.findViewById(R.id.BTinggi);
        PTinggi = (EditText) view.findViewById(R.id.PTinggi);
        PSisi = (EditText) view.findViewById(R.id.PSisi);
        TJari = (EditText) view.findViewById(R.id.TJAriJari);
        TTinggi = (EditText) view.findViewById(R.id.TTinggi);

        HBalok = view.findViewById(R.id.HasilBalok);
        HPiramida = view.findViewById(R.id.HasilPiramida);
        HTabung = view.findViewById(R.id.HasilTabung);

        btnHitungBalok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String balokPanjang = BPanjang.getText().toString();
                String balokLebar = BLebar.getText().toString();
                String balokTinggi = BTinggi.getText().toString();

                if(balokPanjang.isEmpty() && balokLebar.isEmpty() && balokTinggi.isEmpty()){
                    Toast.makeText(getActivity(), "Panjang, Lebar dan Tinggi Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }
                else if (balokPanjang.isEmpty()){
                    Toast.makeText(getActivity(), "Panjang Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }
                else if (balokLebar.isEmpty()){
                    Toast.makeText(getActivity(), "Lebar Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }
                else if (balokTinggi.isEmpty()){
                    Toast.makeText(getActivity(), "Tinggi Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }
                else {
                    double a = Double.parseDouble(balokPanjang);
                    double b = Double.parseDouble(balokLebar);
                    double c = Double.parseDouble(balokTinggi);
                    AnsTempBalok = (int) Math.ceil(a * b * c);
                    String Ans1 = String.valueOf(AnsTempBalok);
                    HBalok.setText(Ans1);
                    AnsTempBalok = 0;
                }
            }
        });

        btnHitungPiramida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String piramidaTinggi = PTinggi.getText().toString();
                String piramidaSisi = PSisi.getText().toString();

                if (piramidaTinggi.isEmpty() && piramidaSisi.isEmpty()){
                    Toast.makeText(getActivity(), "Tinggi dan Sisi Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }
                else if (piramidaTinggi.isEmpty()){
                    Toast.makeText(getActivity(), "Tinggi Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }
                else if (piramidaSisi.isEmpty()){
                    Toast.makeText(getActivity(), "Sisi Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }
                else {
                    double a = Double.parseDouble(piramidaTinggi);
                    double b = Double.parseDouble(piramidaSisi);
                    AnsTempPiramida = (int) Math.ceil((b * b * a) / 3);

                    String Ans2 = String.valueOf(AnsTempPiramida);
                    HPiramida.setText(Ans2);
                    AnsTempPiramida = 0;
                }
            }
        });

        btnHitungTabung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tabungJari = TJari.getText().toString();
                String tabungTinggi = TTinggi.getText().toString();

                if (tabungJari.isEmpty() && tabungTinggi.isEmpty()){
                    Toast.makeText(getActivity(), "Jari - Jari dan Tinggi Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }
                else if (tabungJari.isEmpty()){
                    Toast.makeText(getActivity(), "jari - Jari Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }
                else if (tabungTinggi.isEmpty()){
                    Toast.makeText(getActivity(), "Tinggi Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }
                else {
                    double a = Double.parseDouble(tabungJari);
                    double b = Double.parseDouble(tabungTinggi);
                    AnsTempTabung = (int) Math.ceil((22 * a * a * b) / 7);
                    String Ans3 = String.valueOf(AnsTempTabung);
                    HTabung.setText(Ans3);
                    AnsTempTabung = 0;
                }
            }
        });
        return view;
    }
}

