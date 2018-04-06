package e.chris.sherlocktravelhelper;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Objects;

import static android.view.View.GONE;

/**
 * Created by chris on 2/18/18.
 */

public class calendarEditEvent extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    /* Declarations */
    private static String TAG = "calendarEditEvent";

    private Spinner originSpinner, destinationSpinner, stateOriginSpinner, stateDestinationSpinner,
            reasonSpinner, passportSpinner;
    private TextView startDate, endDate, stateOriginText, stateDestinationText;
    private EditText eventName;
    private Button btnUpdateEvent, btnDeleteEvent;
    private CheckBox passportCheckbox;
    private DatePickerDialog.OnDateSetListener startDateListener;
    private DatePickerDialog.OnDateSetListener endDateListener;

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

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_event);
        /* Associate with layout IDs */
        mDatabaseHelper = new databaseHelper(this);
        originSpinner = (Spinner) findViewById(R.id.originSpinner);
        destinationSpinner = (Spinner) findViewById(R.id.destinationSpinner);
        stateOriginSpinner = (Spinner) findViewById(R.id.stateOriginSpinner);
        stateDestinationSpinner = (Spinner) findViewById(R.id.stateDestinationSpinner);
        reasonSpinner = (Spinner) findViewById(R.id.reasonSpinner);
        passportSpinner = (Spinner) findViewById(R.id.passportSpinner);
        passportCheckbox = (CheckBox) findViewById(R.id.passportCheckbox);
        eventName = (EditText) findViewById(R.id.eventName);
        btnUpdateEvent = (Button) findViewById(R.id.btnUpdateEvent);
        btnDeleteEvent = (Button) findViewById(R.id.btnDeleteEvent);
        startDate = (TextView) findViewById(R.id.startDate);
        endDate = (TextView) findViewById(R.id.endDate);
        stateOriginText = (TextView) findViewById(R.id.stateOriginText);
        stateDestinationText = (TextView) findViewById(R.id.stateDestinationText);

        /* Get writable database */
        SQLiteDatabase db = mDatabaseHelper.getWritableDatabase();

        /* Receive intent to make sure this is the correct event */
        Intent receivedIntent = getIntent();
        String eName = receivedIntent.getStringExtra("evName");
        final int eventID = receivedIntent.getIntExtra("evID", -1);

        /* Select specific event from event table */
        String eventQuery = "SELECT * FROM " + EVENT_TABLE + " WHERE " + ECOL0 + " = " + eventID;
        Cursor eventData = db.rawQuery(eventQuery, null);
        if (eventData != null) {
            eventData.moveToFirst();

            /* Get old data to be written over */
            final String oldENAME = eventData.getString(1);
            final String oldSDATE = eventData.getString(2);
            final String oldEDATE = eventData.getString(3);
            final String oldPASSPORT = eventData.getString(4);
            final String oldORIGIN = eventData.getString(5);
            final String oldSORIGIN = eventData.getString(6);
            final String oldDESTINATION = eventData.getString(7);
            final String oldSDESTINATION = eventData.getString(8);
            final String oldREASON = eventData.getString(9);

            /* Updates event and sends back to all events*/
            btnUpdateEvent.setOnClickListener(new View.OnClickListener() {
                @TargetApi(Build.VERSION_CODES.KITKAT)
                @Override
                public void onClick( View v ) {
                    String newENAME = (String) eventName.getText().toString();
                    String newSDATE = (String) startDate.getText().toString();
                    String newEDATE = (String) endDate.getText().toString();
                    String newPASSPORT = (String) passportSpinner.getSelectedItem().toString();
                    String newORIGIN = (String) originSpinner.getSelectedItem().toString();
                    String newSORIGIN = (String) stateOriginSpinner.getSelectedItem().toString();
                    String newDESTINATION = (String) destinationSpinner.getSelectedItem().toString();
                    String newSDESTINATION = (String) stateDestinationSpinner.getSelectedItem().toString();
                    String newREASON = (String) reasonSpinner.getSelectedItem().toString();

                    SQLiteDatabase database = mDatabaseHelper.getWritableDatabase();

                    if (!Objects.equals(newENAME, "") && !Objects.equals(newSDATE, "") && !Objects.equals(newEDATE, "")) {

                        String newENQuery = "UPDATE " + EVENT_TABLE + " SET " + ECOL1 + " = '" + newENAME + "' WHERE " + ECOL0 + " = '" + eventID + "'" + " AND " + ECOL1 + " = '" + oldENAME + "'";
                        String newSDateQuery = "UPDATE " + EVENT_TABLE + " SET " + ECOL2 + " = '" + newSDATE + "' WHERE " + ECOL0 + " = '" + eventID + "'" + " AND " + ECOL2 + " = '" + oldSDATE + "'";
                        String newEDateQuery = "UPDATE " + EVENT_TABLE + " SET " + ECOL3 + " = '" + newEDATE + "' WHERE " + ECOL0 + " = '" + eventID + "'" + " AND " + ECOL3 + " = '" + oldEDATE + "'";
                        String newPQuery = "UPDATE " + EVENT_TABLE + " SET " + ECOL4 + " = '" + newPASSPORT + "' WHERE " + ECOL0 + " = '" + eventID + "'" + " AND " + ECOL4 + " = '" + oldPASSPORT + "'";
                        String newOQuery = "UPDATE " + EVENT_TABLE + " SET " + ECOL5 + " = '" + newORIGIN + "' WHERE " + ECOL0 + " = '" + eventID + "'" + " AND " + ECOL4 + " = '" + oldORIGIN + "'";
                        String newSOQuery = "UPDATE " + EVENT_TABLE + " SET " + ECOL6 + " = '" + newSORIGIN + "' WHERE " + ECOL0 + " = '" + eventID + "'" + " AND " + ECOL5 + " = '" + oldSORIGIN + "'";
                        String newDQuery = "UPDATE " + EVENT_TABLE + " SET " + ECOL7 + " = '" + newDESTINATION + "' WHERE " + ECOL0 + " = '" + eventID + "'" + " AND " + ECOL6 + " = '" + oldDESTINATION + "'";
                        String newSDQuery = "UPDATE " + EVENT_TABLE + " SET " + ECOL8 + " = '" + newSDESTINATION + "' WHERE " + ECOL0 + " = '" + eventID + "'" + " AND " + ECOL7 + " = '" + oldSDESTINATION + "'";
                        String newRQuery = "UPDATE " + EVENT_TABLE + " SET " + ECOL9 + " = '" + newREASON + "' WHERE " + ECOL0 + " = '" + eventID + "'" + " AND " + ECOL8 + " = '" + oldREASON + "'";

                        database.execSQL(newENQuery);
                        database.execSQL(newSDateQuery);
                        database.execSQL(newEDateQuery);
                        database.execSQL(newPQuery);
                        database.execSQL(newOQuery);
                        database.execSQL(newSOQuery);
                        database.execSQL(newDQuery);
                        database.execSQL(newSDQuery);
                        database.execSQL(newRQuery);

                        Log.d(TAG, "btnCreateEventOnClick: Updating " + EVENT_TABLE + " -> " + oldENAME + " into " + newENAME + ", " + oldSDATE + " into " + newSDATE + ", " + oldEDATE + " into " + newEDATE + ", " + oldORIGIN + " into " + newORIGIN + ", " + oldSORIGIN + " into " + newSORIGIN + ", " + oldDESTINATION + " into " + newDESTINATION + ", " + oldSDESTINATION + " into " + newSDESTINATION + ", " + oldREASON + " into " + newREASON + ".");

                        toastMessage(getResources().getString(R.string.updateSuccess));

                        Intent ListDataIntent = new Intent(calendarEditEvent.this, calendarAllEvents.class);
                        startActivity(ListDataIntent);
                    } else {
                        toastMessage(getResources().getString(R.string.fillAll));
                    }
                }
            });

            /* Deletes events */
            /* Future, can this be made to force a confirmation popup */
            btnDeleteEvent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick( View v ) {
                    SQLiteDatabase database = mDatabaseHelper.getWritableDatabase();

                    String delENQuery = "DELETE FROM " + EVENT_TABLE + " WHERE " + ECOL0 + " = '" + eventID + "'" + " AND "
                            + ECOL1 + " = '" + oldENAME + "'";
                    String delSDateQuery = "DELETE FROM " + EVENT_TABLE + " WHERE " + ECOL0 + " = '" + eventID + "'" + " AND "
                            + ECOL2 + " = '" + oldSDATE + "'";
                    String delEDateQuery = "DELETE FROM " + EVENT_TABLE + " WHERE " + ECOL0 + " = '" + eventID + "'" + " AND "
                            + ECOL3 + " = '" + oldEDATE + "'";
                    String delPQuery = "DELETE FROM " + EVENT_TABLE + " WHERE " + ECOL0 + " = '" + eventID + "'" + " AND "
                            + ECOL4 + " = '" + oldORIGIN + "'";
                    String delOQuery = "DELETE FROM " + EVENT_TABLE + " WHERE " + ECOL0 + " = '" + eventID + "'" + " AND "
                            + ECOL5 + " = '" + oldORIGIN + "'";
                    String delSOQuery = "DELETE FROM " + EVENT_TABLE + " WHERE " + ECOL0 + " = '" + eventID + "'" + " AND "
                            + ECOL6 + " = '" + oldSORIGIN + "'";
                    String delDQuery = "DELETE FROM " + EVENT_TABLE + " WHERE " + ECOL0 + " = '" + eventID + "'" + " AND "
                            + ECOL7 + " = '" + oldDESTINATION + "'";
                    String delSDQuery = "DELETE FROM " + EVENT_TABLE + " WHERE " + ECOL0 + " = '" + eventID + "'" + " AND "
                            + ECOL8 + " = '" + oldSDESTINATION + "'";
                    String delRQuery = "DELETE FROM " + EVENT_TABLE + " WHERE " + ECOL0 + " = '" + eventID + "'" + " AND "
                            + ECOL9 + " = '" + oldREASON + "'";

                    database.execSQL(delENQuery);
                    database.execSQL(delSDateQuery);
                    database.execSQL(delEDateQuery);
                    database.execSQL(delPQuery);
                    database.execSQL(delOQuery);
                    database.execSQL(delSOQuery);
                    database.execSQL(delDQuery);
                    database.execSQL(delSDQuery);
                    database.execSQL(delRQuery);

                    Log.d(TAG, "btnDeleteEvent: Deleting all columns from row containing event ID " +eventID);

                    toastMessage(getResources().getString(R.string.deletionSuccess));

                    Intent ListDataIntent = new Intent (calendarEditEvent.this, calendarAllEvents.class);
                    startActivity(ListDataIntent);
                }
            });

            /* On click, allows user to pick date. This is to keep dates uniform for later */
            startDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick( View view ) {
                    Calendar cal = Calendar.getInstance();
                    int sYear = cal.get(Calendar.YEAR);
                    int sMonth = cal.get(Calendar.MONTH);
                    int sDay = cal.get(Calendar.DAY_OF_MONTH);

                    DatePickerDialog dialog = new DatePickerDialog(calendarEditEvent.this, android.R.style.Theme_Holo_Dialog_MinWidth, startDateListener, sYear, sMonth, sDay);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.show();
                }
            });

             /* On click, allows user to pick date. This is to keep dates uniform for later */
            endDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick( View view ) {
                    Calendar cal = Calendar.getInstance();
                    int eYear = cal.get(Calendar.YEAR);
                    int eMonth = cal.get(Calendar.MONTH);
                    int eDay = cal.get(Calendar.DAY_OF_MONTH);

                    DatePickerDialog dialog = new DatePickerDialog(calendarEditEvent.this, android.R.style.Theme_Holo_Dialog_MinWidth, endDateListener, eYear, eMonth, eDay);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.show();
                }
            });

            /* Date listener for start date, sets start date as a string. Will need to be parsed when called */
            startDateListener = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet( DatePicker datePicker, int sYear, int sMonth, int sDay ) {
                    sMonth = sMonth + 1;
                    Log.d(TAG, "OnDateSet: MM/DD/YYYY: " + sMonth + "/" + sDay + "/" + sYear);
                    String start = sMonth + "/" + sDay + "/" + sYear;
                    startDate.setText(start);
                }
            };

            /* Date listener for end date, sets end date as a string. Will need to be parsed when called */
            endDateListener = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet( DatePicker datePicker, int eYear, int eMonth, int eDay ) {
                    eMonth = eMonth + 1;
                    Log.d(TAG, "OnDateSet: MM/DD/YYYY: " + eMonth + "/" + eDay + "/" + eYear);
                    String end = eMonth + "/" + eDay + "/" + eYear;
                    endDate.setText(end);
                }
            };

            /* Passport Checkbox */
            passportCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (passportCheckbox.isChecked()) {
                        passportSpinner.setSelection(originSpinner.getSelectedItemPosition());
                        passportSpinner.setVisibility(GONE);
                    } else {
                        passportSpinner.setVisibility(View.VISIBLE);
                    }
                }
            });

             /* Array adapters */
            ArrayAdapter <CharSequence> countryAdapter = ArrayAdapter.createFromResource(this, R.array.country_list, android.R.layout.simple_spinner_item);
            ArrayAdapter <CharSequence> reasonAdapter = ArrayAdapter.createFromResource(this, R.array.reason_list, android.R.layout.simple_spinner_item);
            ArrayAdapter <CharSequence> stateAdapter = ArrayAdapter.createFromResource(this, R.array.state_list, android.R.layout.simple_spinner_item);

            /* Sets spinners with appropriate adapters and listeners */
            originSpinner.setAdapter(countryAdapter);
            originSpinner.setOnItemSelectedListener(calendarEditEvent.this);

            stateOriginSpinner.setAdapter(stateAdapter);
            stateOriginSpinner.setOnItemSelectedListener(calendarEditEvent.this);

            destinationSpinner.setAdapter(countryAdapter);
            destinationSpinner.setOnItemSelectedListener(calendarEditEvent.this);

            stateDestinationSpinner.setAdapter(stateAdapter);
            stateDestinationSpinner.setOnItemSelectedListener(calendarEditEvent.this);

            reasonSpinner.setAdapter(reasonAdapter);
            reasonSpinner.setOnItemSelectedListener(calendarEditEvent.this);

            /* Sets layout to display old data */
            eventName.setText(oldENAME);
            startDate.setText(oldSDATE);
            endDate.setText(oldEDATE);
            passportSpinner.setSelection(countryAdapter.getPosition(oldPASSPORT));
            if (Objects.equals(oldPASSPORT, oldORIGIN)) {
                passportCheckbox.setChecked(true);
            } else {
                passportCheckbox.setChecked(false);
            }
            originSpinner.setSelection(countryAdapter.getPosition(oldORIGIN));
            stateOriginSpinner.setSelection(stateAdapter.getPosition(oldSORIGIN));
            destinationSpinner.setSelection(countryAdapter.getPosition(oldDESTINATION));
            stateDestinationSpinner.setSelection(stateAdapter.getPosition(oldSDESTINATION));
            reasonSpinner.setSelection(reasonAdapter.getPosition(oldREASON));
        }
    }

    /* Spinner listeners, hides or shows state spinner depending on if US is selected or not */
    @Override
    public void onItemSelected( AdapterView<?> parent, View view, int position, long id) {
        int origin = (int) originSpinner.getSelectedItemId();
        int destination = (int) destinationSpinner.getSelectedItemId();

        /* If origin is US, shows states. If not, hides states and resets state to "---" */
        /* It is important that the state gets reset on hide, otherwise it messes with code when called later */
        if (origin == 182) {
            stateOriginSpinner.setVisibility(View.VISIBLE);
            stateOriginText.setVisibility(View.VISIBLE);
        } else {
            stateOriginSpinner.setVisibility(GONE);
            stateOriginText.setVisibility(GONE);
            stateOriginSpinner.setSelection(0);
        }

        if (passportCheckbox.isChecked()) {
            passportSpinner.setSelection(originSpinner.getSelectedItemPosition());
        }

        /* If destination is US, shows states. If not, hides states and resets state to "---" */
        /* It is important that the state gets reset on hide, otherwise it messes with code when called later */
        if (destination == 182) {
            stateDestinationSpinner.setVisibility(View.VISIBLE);
            stateDestinationText.setVisibility(View.VISIBLE);
        } else {
            stateDestinationSpinner.setVisibility(GONE);
            stateDestinationText.setVisibility(GONE);
            stateDestinationSpinner.setSelection(0);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    /* Allow toasts as necessary */
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}