package gcit.edu.todo_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView showValue;
    int number=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showValue=(TextView) findViewById(R.id.textView);
    }

    public void toast(View view) {
        Toast obj=Toast.makeText(this, "Hello Toast"+"",Toast.LENGTH_LONG);
        obj.show();

    }

    public void count(View view) {
        number++;
        showValue.setText(Integer.toString(number));

    }
}