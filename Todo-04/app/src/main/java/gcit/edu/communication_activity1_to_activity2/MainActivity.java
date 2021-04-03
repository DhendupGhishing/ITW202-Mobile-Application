package gcit.edu.communication_activity1_to_activity2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "gcit.edu.communication_activity1_to_activity2.extra.MESSAGE";
    private EditText mMessageEditText;
    public static final int TEXT_REQUEST = 1;
    private TextView headmsg;
    private TextView reply_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = (EditText) findViewById(R.id.edit_id);
        headmsg=(TextView)findViewById(R.id.textViewa);
        reply_text=(TextView)findViewById(R.id.textViewb);
    }

    public void sendtext(View view) {
        Intent intent = new Intent(this, Activity2.class);
        String message = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);


    }
    @Override
    public void onActivityResult(int requestCode, int resultCode,Intent data ){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==TEXT_REQUEST){
            if(resultCode==RESULT_OK){
                String reply= data.getStringExtra(Activity2.EXTRA_replay);
                headmsg.setVisibility(View.VISIBLE);
               reply_text.setText(reply);
                reply_text.setVisibility(View.VISIBLE);
            }
        }
    }
}