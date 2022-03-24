package ran.am.day8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView=findViewById(R.id.textView);
       String s1= getIntent().getStringExtra("sone");
       String s2= getIntent().getStringExtra("stwo");
       textView.setText(s1+"\n"+s2);
       //notification
        //
    }
}