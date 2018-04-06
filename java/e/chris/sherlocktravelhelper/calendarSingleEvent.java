package e.chris.sherlocktravelhelper;

import android.annotation.TargetApi;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import static android.view.View.GONE;

/**
 * Created by chris on 2/16/18.
 */

public class calendarSingleEvent extends AppCompatActivity {

    /* Declarations */
    private static final String TAG = "calendarSingleEvent";

    private TextView eventName, dates, trip, visa, advisory, consulate, vccr, capital, nationality, emergency,
            language, currency, stateHeading, stateCapital, circuit, sanctuaryState, sanctuaryAreas, passport;
    private Button btnEdit, btnDelete;

    private databaseHelper mDatabaseHelper;

    private static final String EVENT_TABLE = "events";
    private static final String ECOL0 = "eventID";
    private static final String ECOL1 = "eventName";
    private static final String ECOL2 = "startDate";
    private static final String ECOL3 = "endDate";
    private static final String ECOL4 = "passport";
    private static final String ECOL5 = "origin";
    private static final String ECOL6 = "sOrigin";
    private static final String ECOL7 = "destination";
    private static final String ECOL8 = "sDestination";
    private static final String ECOL9 = "reason";

    private static final String COUNTRY_TABLE = "countries";
    private static final String CCOL1 = "country";

    private static final String STATE_TABLE = "states";
    private static final String SCOL1 = "state";

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_event);
        /* Associate with layout IDs */
        mDatabaseHelper = new databaseHelper(this);
        eventName = (TextView) findViewById(R.id.eventName);
        dates = (TextView) findViewById(R.id.dates);
        trip = (TextView) findViewById(R.id.trip);
        passport = (TextView) findViewById(R.id.passport);
        visa = (TextView) findViewById(R.id.visa);
        advisory = (TextView) findViewById(R.id.advisory);
        consulate = (TextView) findViewById(R.id.consulate);
        emergency = (TextView) findViewById(R.id.emergency);
        vccr = (TextView) findViewById(R.id.vccr);
        capital = (TextView) findViewById(R.id.capital);
        nationality = (TextView) findViewById(R.id.nationality);
        language = (TextView) findViewById(R.id.language);
        currency = (TextView) findViewById(R.id.currency);
        stateHeading = (TextView) findViewById(R.id.stateHeading);
        stateCapital = (TextView) findViewById(R.id.stateCapital);
        circuit = (TextView) findViewById(R.id.circuit);
        sanctuaryState = (TextView) findViewById(R.id.sanctuaryState);
        sanctuaryAreas = (TextView) findViewById(R.id.sanctuaryAreas);
        btnEdit = (Button) findViewById(R.id.btnEdit);
        btnDelete = (Button) findViewById(R.id.btnDelete);

        /* Get edit item, transfer to update activity to allow editing */
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v) {
                String eName = eventName.getText().toString();

                SQLiteDatabase database = mDatabaseHelper.getReadableDatabase();
                String query = "SELECT " + ECOL0 + " FROM " + EVENT_TABLE + " WHERE " + ECOL1 + " = '" + eName + "'";
                Cursor eventID = database.rawQuery(query, null);
                if (eventID != null) {
                    eventID.moveToFirst();
                    int eID = eventID.getInt(0);

                    Intent updateEventIntent = new Intent (calendarSingleEvent.this, calendarEditEvent.class);
                    updateEventIntent.putExtra("evName", eName);
                    updateEventIntent.putExtra("evID", eID);
                    startActivity(updateEventIntent);
                }
            }
        });

        /* Deletes event from event table and sends back to full list */
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                Intent receivedIntent = getIntent();
                String eName = receivedIntent.getStringExtra("eventName");
                int eventID = receivedIntent.getIntExtra("eventID", -1);

                SQLiteDatabase database = mDatabaseHelper.getWritableDatabase();
                String eventQuery = "SELECT * FROM " + EVENT_TABLE + " WHERE " + ECOL0 + " = " + eventID;
                Cursor eventData = database.rawQuery(eventQuery, null);
                if (eventData != null) {
                    eventData.moveToFirst();

                final String oldENAME = eventData.getString(1);
                final String oldSDATE = eventData.getString(2);
                final String oldEDATE = eventData.getString(3);
                final String oldPASSPORT = eventData.getString(4);
                final String oldORIGIN = eventData.getString(5);
                final String oldSORIGIN = eventData.getString(6);
                final String oldDESTINATION = eventData.getString(7);
                final String oldSDESTINATION = eventData.getString(8);
                final String oldREASON = eventData.getString(9);

                    String delENQuery = "DELETE FROM " + EVENT_TABLE + " WHERE " + ECOL0 + " = '" + eventID + "'" + " AND " + ECOL1 + " = '" + oldENAME + "'";
                    String delSDateQuery = "DELETE FROM " + EVENT_TABLE + " WHERE " + ECOL0 + " = '" + eventID + "'" + " AND " + ECOL2 + " = '" + oldSDATE + "'";
                    String delEDateQuery = "DELETE FROM " + EVENT_TABLE + " WHERE " + ECOL0 + " = '" + eventID + "'" + " AND " + ECOL3 + " = '" + oldEDATE + "'";
                    String delPQuery = "DELETE FROM " + EVENT_TABLE + " WHERE " + ECOL0 + " = '" + eventID + "'" + " AND " + ECOL4 + " = '" + oldORIGIN + "'";
                    String delOQuery = "DELETE FROM " + EVENT_TABLE + " WHERE " + ECOL0 + " = '" + eventID + "'" + " AND " + ECOL5 + " = '" + oldPASSPORT + "'";
                    String delSOQuery = "DELETE FROM " + EVENT_TABLE + " WHERE " + ECOL0 + " = '" + eventID + "'" + " AND " + ECOL6 + " = '" + oldSORIGIN + "'";
                    String delDQuery = "DELETE FROM " + EVENT_TABLE + " WHERE " + ECOL0 + " = '" + eventID + "'" + " AND " + ECOL7 + " = '" + oldDESTINATION + "'";
                    String delSDQuery = "DELETE FROM " + EVENT_TABLE + " WHERE " + ECOL0 + " = '" + eventID + "'" + " AND " + ECOL8 + " = '" + oldSDESTINATION + "'";
                    String delRQuery = "DELETE FROM " + EVENT_TABLE + " WHERE " + ECOL0 + " = '" + eventID + "'" + " AND " + ECOL9 + " = '" + oldREASON + "'";

                    database.execSQL(delENQuery);
                    database.execSQL(delSDateQuery);
                    database.execSQL(delEDateQuery);
                    database.execSQL(delPQuery);
                    database.execSQL(delOQuery);
                    database.execSQL(delSOQuery);
                    database.execSQL(delDQuery);
                    database.execSQL(delSDQuery);
                    database.execSQL(delRQuery);

                    Log.d(TAG, "btnDeleteEvent: Deleting all columns from row containing event ID " + eventID);

                    toastMessage(getResources().getString(R.string.deletionSuccess));

                    Intent ListDataIntent = new Intent(calendarSingleEvent.this, calendarAllEvents.class);
                    startActivity(ListDataIntent);
                }
            }
        });

        /* Receive intents to make sure this event is the one clicked on */
        Intent receivedIntent = getIntent();
        String eName = receivedIntent.getStringExtra("eventName");
        int eventID = receivedIntent.getIntExtra("eventID", -1);

        eventName.setText(eName);

        /* Get non-editable database */
        SQLiteDatabase database = mDatabaseHelper.getReadableDatabase();

        /* Select specific event, this does not close until the near the end */
        String eventQuery = "SELECT * FROM " + EVENT_TABLE + " WHERE " + ECOL0 + " = " +eventID;
        Cursor eventData = database.rawQuery(eventQuery, null);
        if (eventData != null) {
            eventData.moveToFirst();

            String eSDate = eventData.getString(2);
            String eEDate = eventData.getString(3);
            String ePassport = eventData.getString(4);
            String eOrigin = eventData.getString(5);
            String eSOrigin = eventData.getString(6);
            String eDestination = eventData.getString(7);
            String eSDestination = eventData.getString(8);
            String eReason = eventData.getString(9);

                /* Select specific destination country from event table */
            String countryQuery = "SELECT * FROM " + COUNTRY_TABLE + " WHERE " + CCOL1 + " = '" + eDestination + "'";
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
            String cCAbbreviation = countryData.getString(8);
            String cVCCR = countryData.getString(9);
            String cEmergency = countryData.getString(10);

            /* Select specific destination state from event table, no state is "---" */
            String stateQuery = "SELECT * FROM " + STATE_TABLE + " WHERE " + SCOL1 + " = '" + eSDestination + "'";
            Cursor stateData = database.rawQuery(stateQuery, null);
            if (stateData != null) {
                stateData.moveToFirst();
            }

            String sCapital = stateData.getString(2);
            String sCircuit = stateData.getString(3);
            String sSancState = stateData.getString(4);
            String sSancAreas = stateData.getString(5);

            /* Display event timeline for user */
            dates.setText(getResources().getString(R.string.from) + eSDate + getResources().getString(R.string.toConnector) + eEDate);

            /* Display trip origin and destination for user */
            trip.setText(displayFormulas.trip(eOrigin, eSOrigin, eDestination, eSDestination, eReason));
            passport.setText(getResources().getString(R.string.passportFrom) + ePassport);

            /* Visa formula start */
                    /* Declarations and adjust destination for table */
            String VISA_TABLE = "visas";
            String VCOL0 = "countryID";
            String adjustedPassport = ePassport.replace(" ", "");
            System.out.println("eDestination: "+eDestination);

            /* Call row with same name as destination */
            String visaQuery = "SELECT * FROM " + VISA_TABLE + " WHERE " + VCOL0 + " = '" + eDestination + "'";
            Cursor visaData = database.rawQuery(visaQuery, null);
            if (visaData != null) {
                visaData.moveToFirst();
            }

            /* Get column index for visa and notes */
            int colC = visaData.getColumnIndex(adjustedPassport);
            int colV = colC + 1;
            int colN = colC + 2;
            int visaLength = visaData.getInt(colC);

            String visaReq = visaData.getString(colV);
            String visaCode = visaData.getString(colN);

            visa.setText(displayFormulas.visaReqs(ePassport, eDestination, visaLength, eSDate, eEDate, eReason, visaReq, visaCode));
            /* Visa formula close */

            /* Display travel advisory information as well as code for user. Code definitions found in definitions */
            if (displayFormulas.advisories(cAdvisory, cCode) == null) {
                advisory.setVisibility(GONE);
            } else {
                advisory.setText(displayFormulas.advisories(cAdvisory, cCode));
            }

            /* Start consulate formula */
            /* Declarations and adjust destination for table */
            String CONSULATE_TABLE = "consulate";
            String PCOL1 = "consulateID";

            /* Call row with same name as passport */
            String consulateQuery = "SELECT * FROM " + CONSULATE_TABLE + " WHERE " + PCOL1 + " = '" + eDestination + "'";
            Cursor consulateData = database.rawQuery(consulateQuery, null);
            if (consulateData != null) {
                consulateData.moveToFirst();
            }

            /* Get column index for destination */
            int colP = consulateData.getColumnIndex(adjustedPassport);
            if (Objects.equals(consulateData.getString(colP), "---")) {
                consulate.setVisibility(GONE);
            } else {
                consulate.setText(cNationality + getResources().getString(R.string.consulateNumber) + consulateData.getString(colP));
            }
            /* Consulate formula close */

            /* Display destination's emergency phone number for user */
            if (Objects.equals(cEmergency, "---")) {
                emergency.setVisibility(GONE);
            } else {
                emergency.setText(getResources().getString(R.string.emergencyNumber) + cEmergency);
            }

            /* Display if destination is a party to VCCR */
            vccr.setText(displayFormulas.vccrParty(eDestination, cVCCR));

            /* Start country specific information */
            /* Display country capital for user */
            if (Objects.equals(cCapital, "---")) {
                capital.setVisibility(GONE);
            } else {
                capital.setText(getResources().getString(R.string.capital) + cCapital);
            }

            /* Display country nationality for user */
            if (Objects.equals(cNationality, "---")) {
                nationality.setVisibility(GONE);
            } else {
                nationality.setText(getResources().getString(R.string.nationality) + cNationality);
            }

            /* Display country language and currency for user */
            language.setText(getResources().getString(R.string.language) + cLanguage);
            currency.setText(getResources().getString(R.string.currency) + cCurrency + " (" + cCAbbreviation + ")");

            /* End country specific information */

            /* Start state specific information */
            /* Hide state information from user if no state was selected in event */
            if (Objects.equals(eSDestination, "---")) {
                stateHeading.setVisibility(GONE);
                stateCapital.setVisibility(GONE);
                circuit.setVisibility(GONE);
                sanctuaryState.setVisibility(GONE);
                sanctuaryAreas.setVisibility(GONE);
            }

            /* Display state capital for user */
            if (Objects.equals(sCapital, "---")) {
                stateCapital.setVisibility(GONE);
            } else {
                stateCapital.setText(getResources().getString(R.string.capital) + sCapital);
            }

            /* Display state federal circuit for user */
            if (Objects.equals(sCircuit, "---")) {
                circuit.setVisibility(GONE);
            } else {
                circuit.setText(getResources().getString(R.string.circuit) + sCircuit);
            }

            /* Display if a state is or is not a sanctuary state for user */
            if (Objects.equals(sSancState, "Yes")) {
                sanctuaryState.setText(getResources().getString(R.string.sanctuaryStateYes));
                sanctuaryAreas.setVisibility(GONE);
            } else {
                sanctuaryState.setText(getResources().getString(R.string.sanctuaryStateNo));
            }

            /* Display state sanctuary areas if there are any for user */
            sanctuaryAreas.setText(displayFormulas.sanctuary(sSancAreas));
        }
    }

    /* Allow toasts as necessary */
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}
