package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by ramascan on 06/04/15.
 */
public class PracticalTest01SecondaryActivity extends Activity {
    Intent intent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_secondary);

        intent = getIntent();
        ((EditText) findViewById(R.id.buttonClicksText)).setText(
                "Top Right: " + intent.getIntExtra("topRight",0) +
                " Top Left: " + intent.getIntExtra("topLeft",0) +
                " Center: " + intent.getIntExtra("center",0)
        );

        ((Button) findViewById(R.id.verifiButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("result","The Verify button has been pushed.");
                setResult(5,intent);
                finish();
            }
        });

        ((Button) findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("result","The Cancel button has been pushed.");
                setResult(5,intent);
                finish();
            }
        });
    }


}
