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
    private int TempCounter = 0;
    private FirebaseUser user;
    private String userID;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragmentsatu, container, false);
        buttonPlus = (Button) view.findViewById(R.id.BtnPlus);
        buttonMinus = (Button) view.findViewById(R.id.BtnMinus);
        buttonReset = (Button) view.findViewById(R.id.BtnReset);

        Angka = (TextView) view.findViewById(R.id.AngkaCounter);

        user = FirebaseAuth.getInstance().getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("User").child(FirebaseAuth.getInstance().getCurrentUser().getUid());

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                TempCounter = Integer.parseInt(value);
                Angka.setText(value);
                buttonPlus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Counter = TempCounter;
                        TempCounter = 0;
                        Counter++;
                        String CounterTambah = Integer.toString(Counter);
                        databaseReference.setValue(CounterTambah);
                        Angka.setText(Integer.toString(Counter));
                    }
                });

                buttonMinus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Counter = TempCounter;
                        TempCounter = 0;
                        Counter--;
                        String CounterKurang = Integer.toString(Counter);
                        databaseReference.setValue(CounterKurang);
                        Angka.setText(Integer.toString(Counter));
                    }
                });

                buttonReset.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Counter = 0;
                        String CounterReset = Integer.toString(Counter);
                        databaseReference.setValue(CounterReset);
                        Angka.setText(Integer.toString(Counter));
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return view;
    }
}

