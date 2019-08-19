package ca.judacribz.week5day1_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText
            etQ1,
            etQ2;

    TextView
            tvQ1,
            tvQ2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etQ1 = findViewById(R.id.etQ1);
        etQ2 = findViewById(R.id.etQ2);
        tvQ1 = findViewById(R.id.tvQ1);
        tvQ2 = findViewById(R.id.tvQ2);
    }

    public void encodeString(View view) {
        String str = checkEditText(etQ1);

        if (!str.isEmpty()) {
            tvQ1.setText(Algorithms.encodeString(str));
        }
    }

    public void getFrequency(View view) {
        String str = checkEditText(etQ2);
        if (!str.isEmpty()) {
            tvQ2.setText(flattenMap(Algorithms.getCharFrequency(str)));
        }
    }

    String checkEditText(EditText et) {
        String str = et.getText().toString().trim();
        if (str.isEmpty()) {
            et.setError("Error: Empty String");
        }

        return str;
    }

    String flattenMap(Map<Character, Integer> map) {
        StringBuilder sb = new StringBuilder();
        int val;
        for (char key : map.keySet()) {
            val = map.get(key);
            if (val != 0) {
                sb.append(key).append(": ").append(val).append("\n");
            }
        }

        return sb.toString();
    }
}
