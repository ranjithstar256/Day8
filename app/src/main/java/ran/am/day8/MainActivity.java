package ran.am.day8;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView2);
        Log.i("Mainactivty", "onCreate: executed!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss z");
        String currentDateandTime = sdf.format(new Date());
        textView.setText("User is Offline and \n last seen at \n"+currentDateandTime);
        Log.i("Mainactivty", "onPause: executed!\n User is Offline and \n last seen at \n"+currentDateandTime);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Mainactivty", "onResume: executed! user is online!");

        textView.setText("User is Online!!");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Mainactivty", "onStart: executed!");
    }
    @Override
    protected void onStop() {
        super.onStop();

        Log.i("Mainactivty", "onStop: executed!");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Mainactivty", "onDestroy: executed!");
    }
}