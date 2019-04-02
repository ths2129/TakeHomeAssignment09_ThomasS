package com.example.takehomeassignment09_thomass;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.Calendar;

public class SecondActivity extends AppCompatActivity {

    private TextView displayDetails;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference halalRef = database.getReference("Main order");
    private DatabaseReference mySecondHalal = database.getReference("Another Order");
    private DatabaseReference myThirdHalal = database.getReference("last Order");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toast.makeText(this, "Your Order", Toast.LENGTH_LONG).show();

        Calendar calendar = Calendar.getInstance(); //has current date - single reference to object
        String today = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());//save date in String

        TextView dateView = findViewById(R.id.text_view_today);
        dateView.setText(today);

        displayDetails = (TextView) findViewById(R.id.text_view_information);

        halalRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                HalalCart halal = dataSnapshot.getValue(HalalCart.class);
                displayDetails.setText(halal.toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(SecondActivity.this, "No halal for you", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void SetHalal(View view) {
        halalRef.setValue(new HalalCart("Chicken over rice", 6, true, true));
        Toast.makeText(this, "First Order", Toast.LENGTH_SHORT).show();
    }

    public void AddHalal(View view) {
        mySecondHalal.setValue(new HalalCart("Chicken on a stick", 3, false, false));
        Toast.makeText(this, "Another Order", Toast.LENGTH_SHORT).show();
    }

    public void AddThird(View view) {
        myThirdHalal.setValue(new HalalCart("Hot dog", 2, false, false));
        Toast.makeText(this, "A third Order", Toast.LENGTH_SHORT).show();
    }

}
