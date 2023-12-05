package com.william.myapplication;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FragmentSatu extends Fragment {
    View view;
    Button buttonPlus, buttonMinus, buttonReset;
    TextView Angka;
    private int Counter = 0;
    private FirebaseUser user;
    private DatabaseReference dRef;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragmentsatu, container, false);
        buttonPlus = (Button) view.findViewById(R.id.BtnPlus);
        buttonMinus = (Button) view.findViewById(R.id.BtnMinus);
        buttonReset = (Button) view.findViewById(R.id.BtnReset);

        Angka = (TextView) view.findViewById(R.id.AngkaCounter);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("User").child(FirebaseAuth.getInstance().getCurrentUser().getUid());

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                Counter = Integer.parseInt(value);
                Angka.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Counter++;
                String CounterTambah = Integer.toString(Counter);
                myRef.setValue(CounterTambah);
                Angka.setText(Integer.toString(Counter));
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Counter--;
                String CounterKurang = Integer.toString(Counter);
                myRef.setValue(CounterKurang);
                Angka.setText(Integer.toString(Counter));
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Counter = 0;
                String CounterReset = Integer.toString(Counter);
                myRef.setValue(CounterReset);
                Angka.setText(Integer.toString(Counter));
            }
        });
        return view;
    }
}

