package ma.ensa.e_certificates;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    private TextView text;
    private Button quitter,retour;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        text=findViewById(R.id.textView11);
        quitter=findViewById(R.id.quitter);
        retour=findViewById(R.id.retour);
        text.setText(this.getIntent().getStringExtra("rslt"));

        quitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
         retour.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent1= new Intent(MainActivity2.this, MainActivity.class);
                 startActivity(intent1);
                 finish();
             }
         });



    }
}