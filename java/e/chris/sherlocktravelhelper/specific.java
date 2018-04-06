package e.chris.sherlocktravelhelper;

import android.annotation.TargetApi;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Objects;

/**
 * Created by chris on 2/18/18.
 */

public class specific extends AppCompatActivity {

    /* Declarations */
    private static String TAG = "specific";

    private Spinner passportSpinner, countrySpinner, stateSpinner;
    private TextView countryCapital, countryNationality, countryConsulate, countryEmergency, countryLanguage,
            countryCurrency, countryAdvisory, countryVccr, stateCapital, stateCircuit, stateSanc, stateSancArea;
    private databaseHelper mDatabaseHelper;

    private static final String COUNTRY_TABLE = "countries";
    private static final String CCOL1 = "country";

    private static final String STATE_TABLE = "states";
    private static final String SCOL1 = "state";

    private static final String CONSULATE_TABLE = "consulate";
    private static final String PCOL0 = "consulateID";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.specific);
        /* Associate with layout IDs */
        mDatabaseHelper = new databaseHelper(this);
        passportSpinner = (Spinner) findViewById(R.id.passportSpinner);
        countrySpinner = (Spinner) findViewById(R.id.countrySpinner);
        stateSpinner = (Spinner) findViewById(R.id.stateSpinner);
        countryCapital = (TextView) findViewById(R.id.countryCapital);
        countryNationality = (TextView) findViewById(R.id.countryNationality);
        countryConsulate = (TextView) findViewById(R.id.countryConsulate);
        countryEmergency = (TextView) findViewById(R.id.countryEmergency);
        countryLanguage = (TextView) findViewById(R.id.countryLanguage);
        countryCurrency = (TextView) findViewById(R.id.countryCurrency);
        countryAdvisory = (TextView) findViewById(R.id.countryAdvisory);
        countryVccr = (TextView) findViewById(R.id.countryVccr);
        stateCapital = (TextView) findViewById(R.id.stateCapital);
        stateCircuit = (TextView) findViewById(R.id.stateCircuit);
        stateSanc = (TextView) findViewById(R.id.stateSanc);
        stateSancArea = (TextView) findViewById(R.id.stateSancArea);

        /* Array adapters */
        ArrayAdapter<CharSequence> countryAdapter = ArrayAdapter.createFromResource
                (this, R.array.country_list, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> stateAdapter = ArrayAdapter.createFromResource
                (this, R.array.state_list, android.R.layout.simple_spinner_item);
        stateSpinner.setSelection(1);

        /* Set country adapter and display information depending on passport and country spinners */
        passportSpinner.setAdapter(countryAdapter);
        passportSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                /* Get spinner selections */
                String country = countrySpinner.getSelectedItem().toString();
                String passport = passportSpinner.getSelectedItem().toString();

                /* Call database and get data from country table */
                SQLiteDatabase database = mDatabaseHelper.getReadableDatabase();
                String countryQuery = "SELECT * FROM " + COUNTRY_TABLE + " WHERE " + CCOL1 + " = '" + country + "'";
                Cursor countryData = database.rawQuery(countryQuery, null);
                if (countryData != null) {
                    countryData.moveToFirst();
                }

                String cNationality = countryData.getString(5);

                /* Get data from consulate table */
                String adjustedPassport = passport.replace(" ", "");
                String consulateQuery = "SELECT * FROM " + CONSULATE_TABLE + " WHERE " + PCOL0 + " = '" + country + "'";
                Cursor consulateData = database.rawQuery(consulateQuery, null);
                if (consulateData != null) {
                    consulateData.moveToFirst();
                }

                String pPhone = consulateData.getString(consulateData.getColumnIndex(adjustedPassport));

                /* Set text or hide textViews depending on information */
                if (Objects.equals(pPhone, "---")) {
                    countryConsulate.setVisibility(View.GONE);
                } else if (Objects.equals(cNationality, "---")) {
                    countryConsulate.setText(getResources().getString(R.string.consulateNumber) + pPhone);
                    countryConsulate.setVisibility(View.VISIBLE);
                } else {
                    countryConsulate.setText(cNationality + getResources().getString(R.string.consulateNumber) + pPhone);
                    countryConsulate.setVisibility(View.VISIBLE);
                }
            }

            /* If nothing selected is forced */
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        countrySpinner.setAdapter(countryAdapter);
        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                /* Get spinner selections */
                String country = countrySpinner.getSelectedItem().toString();
                String passport = passportSpinner.getSelectedItem().toString();

                /* Call database and get data from country table */
                SQLiteDatabase database = mDatabaseHelper.getReadableDatabase();
                String countryQuery = "SELECT * FROM " + COUNTRY_TABLE + " WHERE " + CCOL1 + " = '" + country + "'";
                Cursor countryData = database.rawQuery(countryQuery, null);
                if (countryData != null) {
                    countryData.moveToFirst();
                }

                String cAdvisory = countryData.getString(2);
                String cCode = countryData.getString(3);
                String cCapital = countryData.getString(4);
                String cNationality = countryData.getString(5);
                String cLanguage = countryData.getString(6);
                String cCurrency = countryData.getString(7);
                String cAbbr = countryData.getString(8);
                String cVCCR = countryData.getString(9);
                String cEmergency = countryData.getString(10);

                /* Get data from consulate table */
                String adjustedPassport = passport.replace(" ", "");
                String consulateQuery = "SELECT * FROM " + CONSULATE_TABLE + " WHERE " + PCOL0 + " = '" + country + "'";
                Cursor consulateData = database.rawQuery(consulateQuery, null);
                if (consulateData != null) {
                    consulateData.moveToFirst();
                }

                String pPhone = consulateData.getString(consulateData.getColumnIndex(adjustedPassport));

                /* Set text or hide textViews depending on information */
                if (Objects.equals(cCapital, "---")) {
                    countryCapital.setVisibility(View.GONE);
                } else {
                    countryCapital.setText(getResources().getString(R.string.capital) + cCapital);
                    countryCapital.setVisibility(View.VISIBLE);
                }
                if (Objects.equals(cNationality, "---")) {
                    countryNationality.setVisibility(View.GONE);
                } else {
                    countryNationality.setText(getResources().getString(R.string.nationality) + cNationality);
                    countryNationality.setVisibility(View.VISIBLE);
                }
                if (Objects.equals(cEmergency, "---")) {
                    countryEmergency.setVisibility(View.GONE);
                } else {
                    countryEmergency.setText(getResources().getString(R.string.emergencyNumber) + cEmergency);
                    countryEmergency.setVisibility(View.VISIBLE);
                }
                if (Objects.equals(cLanguage, "---")) {
                    countryLanguage.setVisibility(View.GONE);
                } else {
                    countryLanguage.setText(getResources().getString(R.string.language) + cLanguage);
                    countryLanguage.setVisibility(View.VISIBLE);
                }
                if (Objects.equals(cCurrency, "---")) {
                    countryCurrency.setVisibility(View.GONE);
                } else {
                    countryCurrency.setText(getResources().getString(R.string.currency) + cCurrency + " (" + cAbbr + ")");
                    countryCurrency.setVisibility(View.VISIBLE);
                }
                if (Objects.equals(cAdvisory, "---")) {
                    countryAdvisory.setVisibility(View.GONE);
                } else {
                    countryAdvisory.setText(displayFormulas.advisories(cAdvisory, cCode));
                    countryAdvisory.setVisibility(View.VISIBLE);
                }
                if (Objects.equals(cVCCR, "---")) {
                    countryVccr.setVisibility(View.GONE);
                } else if (Objects.equals(cVCCR, "Yes")) {
                    countryVccr.setText(getResources().getString(R.string.vccrEndYes));
                    countryVccr.setVisibility(View.VISIBLE);
                } else {
                    countryVccr.setText(getResources().getString(R.string.vccrEndNo));
                    countryVccr.setVisibility(View.VISIBLE);
                }
            }

            /* If nothing selected is forced */
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        stateSpinner.setAdapter(stateAdapter);
        stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String state = stateSpinner.getSelectedItem().toString();

                /* Call database and get data from state table */
                SQLiteDatabase database = mDatabaseHelper.getReadableDatabase();
                String stateQuery = "SELECT * FROM " + STATE_TABLE + " WHERE " + SCOL1 + " = '" + state + "'";
                Cursor stateData = database.rawQuery(stateQuery, null);
                if (stateData != null) {
                    stateData.moveToFirst();
                }

                String sState = stateData.getString(1);
                String sCapital = stateData.getString(2);
                String sCircuit = stateData.getString(3);
                String sSanc = stateData.getString(4);
                String sArea = stateData.getString(5);

                /* Set text or hide textViews depending on information */
                if (Objects.equals(sCapital, "---")) {
                    stateCapital.setVisibility(View.GONE);
                } else {
                    stateCapital.setText(getResources().getString(R.string.capital) + sCapital);
                    stateCapital.setVisibility(View.VISIBLE);
                }
                if (Objects.equals(sCircuit, "---")) {
                    stateCircuit.setVisibility(View.GONE);
                } else {
                    stateCircuit.setText(getResources().getString(R.string.circuit) + sCircuit);
                    stateCircuit.setVisibility(View.VISIBLE);
                }
                if (Objects.equals(sSanc, "---")) {
                    stateSanc.setVisibility(View.GONE);
                } else if (Objects.equals(sSanc, "Yes")) {
                    stateSanc.setText(sState + getResources().getString(R.string.sanctuaryStateYes));
                    stateSanc.setVisibility(View.VISIBLE);
                } else if (Objects.equals(sSanc, "No")) {
                    stateSanc.setText(sState + getResources().getString(R.string.sanctuaryStateNo));
                    stateSanc.setVisibility(View.VISIBLE);
                }
                if (Objects.equals(sArea, "---")) {
                    stateSancArea.setVisibility(View.GONE);
                } else {
                    stateSancArea.setText(displayFormulas.sanctuary(sArea));
                    stateSancArea.setVisibility(View.VISIBLE);
                }
            }

            /* If nothing selected is forced */
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}