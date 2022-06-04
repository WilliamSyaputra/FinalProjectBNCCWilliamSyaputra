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

public class FragmentDua extends Fragment {

    View view;
    Button buttonHitungPersegi, buttonHitungSegitiga, buttonHitungLingkaran;
    EditText Sisi, Alas, Tinggi, JariJari;
    TextView HasilPersegi, HasilSegitiga, HasilLingkaran;

    double ansTempPersegi = 0;
    double ansTempSegitiga = 0;
    double ansTempLingkaran = 0;



        @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragmentdua, container, false);

        buttonHitungPersegi = (Button) view.findViewById(R.id.BtnHitungPersegi);
        buttonHitungLingkaran = (Button) view.findViewById(R.id.BtnHitungLingkaran);
        buttonHitungSegitiga = (Button) view.findViewById(R.id.BtnHitungSegitiga);


        Sisi = (EditText) view.findViewById(R.id.et_Sisi);
        Alas = (EditText) view.findViewById(R.id.et_Alas);
        Tinggi =(EditText) view.findViewById(R.id.et_Tinggi);
        JariJari =(EditText) view.findViewById(R.id.et_JariJari);

        HasilPersegi = view.findViewById(R.id.HasilPersegi);
        HasilSegitiga = view.findViewById(R.id.HasilSegitiga);
        HasilLingkaran = view.findViewById(R.id.HasilLingkaran);

        buttonHitungPersegi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sisi = Sisi.getText().toString();
                if (sisi.isEmpty()){
                    Toast.makeText(getActivity(), "Sisi Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }
                else {
                    double a = Double.parseDouble(Sisi.getText().toString());
                    ansTempPersegi = (int) Math.ceil(a * a);
                    String Ans1 = String.valueOf(ansTempPersegi);
                    HasilPersegi.setText(Ans1);
                    ansTempPersegi = 0;
                }
            }
        });

        buttonHitungSegitiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String alas = Alas.getText().toString();
                String tinggi = Tinggi.getText().toString();
                if (alas.isEmpty() && tinggi.isEmpty()){
                    Toast.makeText(getActivity(), "Alas dan Tinggi Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }
                else if (alas.isEmpty()){
                    Toast.makeText(getActivity(), "Alas Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }
                else if (tinggi.isEmpty()){
                    Toast.makeText(getActivity(), "Tinggi Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }
                else{
                    double a = Double.parseDouble(alas);
                    double b = Double.parseDouble(tinggi);
                    ansTempSegitiga = (int) Math.ceil((a * b) / 2);
                    String ans2 = String.valueOf(ansTempSegitiga);
                    HasilSegitiga.setText(ans2);
                    ansTempSegitiga = 0;
                }
            }
        });

        buttonHitungLingkaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jari = JariJari.getText().toString();
                if (jari.isEmpty()){
                    Toast.makeText(getActivity(), "Jari - Jari Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }
                else {
                    double a = Double.parseDouble(jari);
                    ansTempLingkaran = (int) Math.ceil(((22 * a * a)/ 7));
                    String ans3 = String.valueOf(ansTempLingkaran);
                    HasilLingkaran.setText(ans3);
                    ansTempLingkaran = 0;
                }
            }
        });

        return view;
    }
}

