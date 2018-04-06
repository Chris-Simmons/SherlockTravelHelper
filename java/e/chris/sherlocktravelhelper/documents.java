package e.chris.sherlocktravelhelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class documents extends AppCompatActivity {

    /* In the future, possibly check to see what other documents may want to be added into this. Make
        sure the documents added are relevant somehow though. Do not throw documents in without a
        purpose. If a document is included, write a comment explaining why it is included.

        Fill the empty space if you can. There is too much of it.*/

    /* Declarations */
    private static String TAG = "documents";
    Button btnConstitution, btnUDHR, btnVCCR;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.documents);
        /* Associate with layout IDs */
        btnConstitution = (Button) findViewById(R.id.btnConstitution);
        btnUDHR = (Button) findViewById(R.id.btnUDHR);
        btnVCCR = (Button) findViewById(R.id.btnVCCR);

        /* Opens Consitution */
        btnConstitution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                Intent openConstitution = new Intent(documents.this, documentsConstitution.class);
                startActivity(openConstitution);
            }
        });

        /* Opens UDHR */
        btnUDHR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                Intent openUDHR = new Intent(documents.this, documentsUDHR.class);
                startActivity(openUDHR);
            }
        });

        /* Opens VCCR */
        btnVCCR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                Intent openVCCR = new Intent(documents.this, documentsVCCR.class);
                startActivity(openVCCR);
            }
        });
    }
}