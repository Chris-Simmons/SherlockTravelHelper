package e.chris.sherlocktravelhelper;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class bulletin extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    /* Declarations */
    private Spinner bulletinSpinner;
    private TextView f1Date, f2aDate, f2bDate, f3Date, f4Date, firstDate, secondDate, thirdDate, owDate,
            fourthDate, relDate, nrcDate, rcDate;

    private databaseHelper mDBHelper;

    private static final String TABLE_NAME = "bulletin";
    private static final String COL0 = "bulletinID";

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bulletin);
        /* Associate with layout IDs */
        bulletinSpinner = (Spinner) findViewById(R.id.bulletinSpinner);
        mDBHelper = new databaseHelper(this);
        f1Date = (TextView) findViewById(R.id.f1Date);
        f2aDate = (TextView) findViewById(R.id.f2aDate);
        f2bDate = (TextView) findViewById(R.id.f2bDate);
        f3Date = (TextView) findViewById(R.id.f3Date);
        f4Date = (TextView) findViewById(R.id.f4Date);
        firstDate = (TextView) findViewById(R.id.firstDate);
        secondDate = (TextView) findViewById(R.id.secondDate);
        thirdDate = (TextView) findViewById(R.id.thirdDate);
        owDate = (TextView) findViewById(R.id.owDate);
        fourthDate = (TextView) findViewById(R.id.fourthDate);
        relDate = (TextView) findViewById(R.id.relDate);
        nrcDate = (TextView) findViewById(R.id.nrcDate);
        rcDate = (TextView) findViewById(R.id.rcDate);

        /* Set spinner adapter and listener */
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.bulletin_array, android.R.layout.simple_spinner_item);
        bulletinSpinner.setAdapter(adapter);
        bulletinSpinner.setOnItemSelectedListener(bulletin.this);
    }

    /* Spinner listener, calls from bulletin table */
    /* Note, the vast majority of the information in the layout is hardcoded as it does not change */
    /* If the government changes definitions, will need to change code. Table is just for dynamic information */
    @Override
    public void onItemSelected( AdapterView<?> parent, View view, int position, long id) {
        databaseHelper mDBHelper = new databaseHelper(this);
        SQLiteDatabase database = mDBHelper.getReadableDatabase();
        /* Sets text for user if all chargability is selected */
        if (position == 0) {
            String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL0 + " = 'all'";
            Cursor data = database.rawQuery(query, null);
            if (data != null) {
                data.moveToFirst();
            }
            do {
                String f1D = data.getString(data.getColumnIndex("f1Date"));
                String f2aD = data.getString(data.getColumnIndex("f2aDate"));
                String f2bD = data.getString(data.getColumnIndex("f2bDate"));
                String f3D = data.getString(data.getColumnIndex("f3Date"));
                String f4D = data.getString(data.getColumnIndex("f4Date"));
                String firstD = data.getString(data.getColumnIndex("firstDate"));
                String secondD = data.getString(data.getColumnIndex("secondDate"));
                String thirdD = data.getString(data.getColumnIndex("thirdDate"));
                String owD = data.getString(data.getColumnIndex("owDate"));
                String fourthD = data.getString(data.getColumnIndex("fourthDate"));
                String relD = data.getString(data.getColumnIndex("relDate"));
                String nrcD = data.getString(data.getColumnIndex("nrcDate"));
                String rcD = data.getString(data.getColumnIndex("rcDate"));

                f1Date.setText("'" + f1D + "'");
                f2aDate.setText("'" + f2aD + "'");
                f2bDate.setText("'" + f2bD + "'");
                f3Date.setText("'" + f3D + "'");
                f4Date.setText("'" + f4D + "'");
                firstDate.setText("'" + firstD + "'");
                secondDate.setText("'" + secondD + "'");
                thirdDate.setText("'" + thirdD + "'");
                owDate.setText("'" + owD + "'");
                fourthDate.setText("'" + fourthD + "'");
                relDate.setText("'" + relD + "'");
                nrcDate.setText("'" + nrcD + "'");
                rcDate.setText("'" + rcD + "'");
            } while (data.moveToNext());
        /* Sets text for user if China is selected */
        } else if (position == 1) {
            String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL0 + " = 'chi'";
            Cursor data = database.rawQuery(query, null);
            if (data != null) {
                data.moveToFirst();
            }
            do {
                String f1D = data.getString(data.getColumnIndex("f1Date"));
                String f2aD = data.getString(data.getColumnIndex("f2aDate"));
                String f2bD = data.getString(data.getColumnIndex("f2bDate"));
                String f3D = data.getString(data.getColumnIndex("f3Date"));
                String f4D = data.getString(data.getColumnIndex("f4Date"));
                String firstD = data.getString(data.getColumnIndex("firstDate"));
                String secondD = data.getString(data.getColumnIndex("secondDate"));
                String thirdD = data.getString(data.getColumnIndex("thirdDate"));
                String owD = data.getString(data.getColumnIndex("owDate"));
                String fourthD = data.getString(data.getColumnIndex("fourthDate"));
                String relD = data.getString(data.getColumnIndex("relDate"));
                String nrcD = data.getString(data.getColumnIndex("nrcDate"));
                String rcD = data.getString(data.getColumnIndex("rcDate"));

                f1Date.setText("'" + f1D + "'");
                f2aDate.setText("'" + f2aD + "'");
                f2bDate.setText("'" + f2bD + "'");
                f3Date.setText("'" + f3D + "'");
                f4Date.setText("'" + f4D + "'");
                firstDate.setText("'" + firstD + "'");
                secondDate.setText("'" + secondD + "'");
                thirdDate.setText("'" + thirdD + "'");
                owDate.setText("'" + owD + "'");
                fourthDate.setText("'" + fourthD + "'");
                relDate.setText("'" + relD + "'");
                nrcDate.setText("'" + nrcD + "'");
                rcDate.setText("'" + rcD + "'");
            } while (data.moveToNext());
        /* Sets text for user if El Salvador is selected */
        } else if (position == 2) {
            String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL0 + " = 'els'";
            Cursor data = database.rawQuery(query, null);
            if (data != null) {
                data.moveToFirst();
            }
            do {
                String f1D = data.getString(data.getColumnIndex("f1Date"));
                String f2aD = data.getString(data.getColumnIndex("f2aDate"));
                String f2bD = data.getString(data.getColumnIndex("f2bDate"));
                String f3D = data.getString(data.getColumnIndex("f3Date"));
                String f4D = data.getString(data.getColumnIndex("f4Date"));
                String firstD = data.getString(data.getColumnIndex("firstDate"));
                String secondD = data.getString(data.getColumnIndex("secondDate"));
                String thirdD = data.getString(data.getColumnIndex("thirdDate"));
                String owD = data.getString(data.getColumnIndex("owDate"));
                String fourthD = data.getString(data.getColumnIndex("fourthDate"));
                String relD = data.getString(data.getColumnIndex("relDate"));
                String nrcD = data.getString(data.getColumnIndex("nrcDate"));
                String rcD = data.getString(data.getColumnIndex("rcDate"));

                f1Date.setText("'" + f1D + "'");
                f2aDate.setText("'" + f2aD + "'");
                f2bDate.setText("'" + f2bD + "'");
                f3Date.setText("'" + f3D + "'");
                f4Date.setText("'" + f4D + "'");
                firstDate.setText("'" + firstD + "'");
                secondDate.setText("'" + secondD + "'");
                thirdDate.setText("'" + thirdD + "'");
                owDate.setText("'" + owD + "'");
                fourthDate.setText("'" + fourthD + "'");
                relDate.setText("'" + relD + "'");
                nrcDate.setText("'" + nrcD + "'");
                rcDate.setText("'" + rcD + "'");
            } while (data.moveToNext());
        /* Sets text for user if India is selected */
        } else if (position == 3) {
            String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL0 + " = 'ind'";
            Cursor data = database.rawQuery(query, null);
            if (data != null) {
                data.moveToFirst();
            }
            do {
                String f1D = data.getString(data.getColumnIndex("f1Date"));
                String f2aD = data.getString(data.getColumnIndex("f2aDate"));
                String f2bD = data.getString(data.getColumnIndex("f2bDate"));
                String f3D = data.getString(data.getColumnIndex("f3Date"));
                String f4D = data.getString(data.getColumnIndex("f4Date"));
                String firstD = data.getString(data.getColumnIndex("firstDate"));
                String secondD = data.getString(data.getColumnIndex("secondDate"));
                String thirdD = data.getString(data.getColumnIndex("thirdDate"));
                String owD = data.getString(data.getColumnIndex("owDate"));
                String fourthD = data.getString(data.getColumnIndex("fourthDate"));
                String relD = data.getString(data.getColumnIndex("relDate"));
                String nrcD = data.getString(data.getColumnIndex("nrcDate"));
                String rcD = data.getString(data.getColumnIndex("rcDate"));

                f1Date.setText("'" + f1D + "'");
                f2aDate.setText("'" + f2aD + "'");
                f2bDate.setText("'" + f2bD + "'");
                f3Date.setText("'" + f3D + "'");
                f4Date.setText("'" + f4D + "'");
                firstDate.setText("'" + firstD + "'");
                secondDate.setText("'" + secondD + "'");
                thirdDate.setText("'" + thirdD + "'");
                owDate.setText("'" + owD + "'");
                fourthDate.setText("'" + fourthD + "'");
                relDate.setText("'" + relD + "'");
                nrcDate.setText("'" + nrcD + "'");
                rcDate.setText("'" + rcD + "'");
            } while (data.moveToNext());
        /* Sets text for user if Mexico is selected */
        } else if (position == 4) {
            String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL0 + " = 'mex'";
            Cursor data = database.rawQuery(query, null);
            if (data != null) {
                data.moveToFirst();
            }
            do {
                String f1D = data.getString(data.getColumnIndex("f1Date"));
                String f2aD = data.getString(data.getColumnIndex("f2aDate"));
                String f2bD = data.getString(data.getColumnIndex("f2bDate"));
                String f3D = data.getString(data.getColumnIndex("f3Date"));
                String f4D = data.getString(data.getColumnIndex("f4Date"));
                String firstD = data.getString(data.getColumnIndex("firstDate"));
                String secondD = data.getString(data.getColumnIndex("secondDate"));
                String thirdD = data.getString(data.getColumnIndex("thirdDate"));
                String owD = data.getString(data.getColumnIndex("owDate"));
                String fourthD = data.getString(data.getColumnIndex("fourthDate"));
                String relD = data.getString(data.getColumnIndex("relDate"));
                String nrcD = data.getString(data.getColumnIndex("nrcDate"));
                String rcD = data.getString(data.getColumnIndex("rcDate"));

                f1Date.setText("'" + f1D + "'");
                f2aDate.setText("'" + f2aD + "'");
                f2bDate.setText("'" + f2bD + "'");
                f3Date.setText("'" + f3D + "'");
                f4Date.setText("'" + f4D + "'");
                firstDate.setText("'" + firstD + "'");
                secondDate.setText("'" + secondD + "'");
                thirdDate.setText("'" + thirdD + "'");
                owDate.setText("'" + owD + "'");
                fourthDate.setText("'" + fourthD + "'");
                relDate.setText("'" + relD + "'");
                nrcDate.setText("'" + nrcD + "'");
                rcDate.setText("'" + rcD + "'");
            } while (data.moveToNext());
        /* Sets text for user if Philippines is selected */
        } else if (position == 5) {
            String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL0 + " = 'phi'";
            Cursor data = database.rawQuery(query, null);
            if (data != null) {
                data.moveToFirst();
            }
            do {
                String f1D = data.getString(data.getColumnIndex("f1Date"));
                String f2aD = data.getString(data.getColumnIndex("f2aDate"));
                String f2bD = data.getString(data.getColumnIndex("f2bDate"));
                String f3D = data.getString(data.getColumnIndex("f3Date"));
                String f4D = data.getString(data.getColumnIndex("f4Date"));
                String firstD = data.getString(data.getColumnIndex("firstDate"));
                String secondD = data.getString(data.getColumnIndex("secondDate"));
                String thirdD = data.getString(data.getColumnIndex("thirdDate"));
                String owD = data.getString(data.getColumnIndex("owDate"));
                String fourthD = data.getString(data.getColumnIndex("fourthDate"));
                String relD = data.getString(data.getColumnIndex("relDate"));
                String nrcD = data.getString(data.getColumnIndex("nrcDate"));
                String rcD = data.getString(data.getColumnIndex("rcDate"));

                f1Date.setText("'" + f1D + "'");
                f2aDate.setText("'" + f2aD + "'");
                f2bDate.setText("'" + f2bD + "'");
                f3Date.setText("'" + f3D + "'");
                f4Date.setText("'" + f4D + "'");
                firstDate.setText("'" + firstD + "'");
                secondDate.setText("'" + secondD + "'");
                thirdDate.setText("'" + thirdD + "'");
                owDate.setText("'" + owD + "'");
                fourthDate.setText("'" + fourthD + "'");
                relDate.setText("'" + relD + "'");
                nrcDate.setText("'" + nrcD + "'");
                rcDate.setText("'" + rcD + "'");
            } while (data.moveToNext());
        }
    }

    /* If nothing is selected, do nothing */
    @Override
    public void onNothingSelected( AdapterView <?> parent ) {

    }
}
