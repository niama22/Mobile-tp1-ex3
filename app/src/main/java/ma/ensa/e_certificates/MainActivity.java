package ma.ensa.e_certificates;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private CheckBox ch1, ch2, ch3, ch4;
    private RadioGroup radioGroup;
    private Button suiv,quitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ch1 = findViewById(R.id.checkBox1);
        ch2 = findViewById(R.id.checkBox2);
        ch3 = findViewById(R.id.checkBox3);
        ch4 = findViewById(R.id.checkBox4);
        radioGroup = findViewById(R.id.radioGroup);
        suiv = findViewById(R.id.sendii);
        quitter=findViewById(R.id.sendi);

        suiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = generateResults();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("rslt", result);
                startActivity(intent);
                finish();
            }
        });
        quitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    private String generateResults() {
        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append("Le pattern MVC signifie :\n")
                .append(getCheckedItem(ch1))
                .append(getCheckedItem(ch2))
                .append(getCheckedItem(ch3))
                .append(getCheckedItem(ch4))
                .append("\nLa syntaxe $[x] est permise dans une JSP : \n")
                .append(getSelectedRadioButtonText());

        return resultBuilder.toString();
    }

    private String getCheckedItem(CheckBox checkBox) {
        return checkBox.isChecked() ? "- " + checkBox.getText().toString() + "\n" : "";
    }

    private String getSelectedRadioButtonText() {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        if (selectedId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedId);
            return selectedRadioButton.getText().toString();
        }
        return "";
    }
}
