package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    EditText buttonListText;

    private int topLeftCount = 0;
    private int topRightCount = 0;
    private int centerCount = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);

        buttonListText = (EditText) findViewById(R.id.buttonPressedText);

        final Button topLeftButton = (Button) findViewById(R.id.topLeftButton);
        Button topRightButton = (Button) findViewById(R.id.topRightButton);
        Button bottomLeftButton = (Button) findViewById(R.id.bottomLeftButton);
        Button bottomRightButton = (Button) findViewById(R.id.bottomRightButton);
        final Button centerButton = (Button) findViewById(R.id.centerButton);

        topLeftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topLeftCount++;
                String text = buttonListText.getText().toString();
                buttonListText.setText(text + "Top Left, ");
            }
        });

        topRightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topRightCount++;
                String text = buttonListText.getText().toString();
                buttonListText.setText(text + "Top Right, ");
            }
        });

        bottomLeftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = buttonListText.getText().toString();
                buttonListText.setText(text + "Bottom Left, ");
            }
        });

        bottomRightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = buttonListText.getText().toString();
                buttonListText.setText(text + "Bottom Right, ");
            }
        });

        centerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                centerCount++;
                String text = buttonListText.getText().toString();
                buttonListText.setText(text + "Center, ");
            }
        });

        ((Button) findViewById(R.id.activityButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PracticalTest01SecondaryActivity.class);
                intent.putExtra("topRight", topRightCount);
                intent.putExtra("topLeft",topLeftCount);
                intent.putExtra("center",centerCount);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("topRight", topRightCount);
        savedInstanceState.putInt("topLeft",topLeftCount);
        savedInstanceState.putInt("center",centerCount);
        System.out.println("ON SAVE: Top Left: " + topLeftCount +" Top Right: " + topRightCount + " Center: " + centerCount);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        topRightCount = savedInstanceState.getInt("topRight");
        topLeftCount = savedInstanceState.getInt("topLeft");
        centerCount = savedInstanceState.getInt("center");
        System.out.println("ON RESTORE: Top Left: " + topLeftCount +" Top Right: " + topRightCount + " Center: " + centerCount);
        Toast.makeText(this,"Top Left: " + topLeftCount +" Top Right: " + topRightCount + " Center: " + centerCount, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == 5) {
                String result = data.getStringExtra("result");
                Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();

            }
        }
    }

}
