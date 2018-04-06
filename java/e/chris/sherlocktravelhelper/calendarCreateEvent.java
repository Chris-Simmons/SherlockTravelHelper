package e.chris.sherlocktravelhelper;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
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

public class calendarCreateEvent extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    /* Declarations */
    private static String TAG = "calendarCreateEvent";

    private Spinner originSpinner, destinationSpinner, stateOriginSpinner, stateDestinationSpinner,
            reasonSpinner, passportSpinner;
    private TextView startDate, endDate, originText, stateOriginText, destinationText,
            stateDestinationText;
    private EditText eventName;
    private Button btnCreateEvent, btnView;
    private CheckBox passportCheckbox;
    private DatePickerDialog.OnDateSetListener startDateListener;
    private DatePickerDialog.OnDateSetListener endDateListener;

    private databaseHelper mDatabaseHelper;

    private static final String EVENT_TABLE = "events";
    private static final String ECOL1 = "eventName";
    private static final String ECOL2 = "startDate";
    private static final String ECOL3 = "endDate";
    private static final String ECOL4 = "passport";
    private static final String ECOL5 = "origin";
    private static final String ECOL6 = "sOrigin";
    private static final String ECOL7 = "destination";
    private static final String ECOL8 = "sDestination";
    private static final String ECOL9 = "reason";

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_event);
        /* Associate with layout IDs */
        mDatabaseHelper = new databaseHelper(this);
        originSpinner = (Spinner) findViewById(R.id.originSpinner);
        destinationSpinner = (Spinner) findViewById(R.id.destinationSpinner);
        stateOriginSpinner = (Spinner) findViewById(R.id.stateOriginSpinner);
        stateDestinationSpinner = (Spinner) findViewById(R.id.stateDestinationSpinner);
        passportSpinner = (Spinner) findViewById(R.id.passportSpinner);
        passportCheckbox = (CheckBox) findViewById(R.id.passportCheckbox);
        reasonSpinner = (Spinner) findViewById(R.id.reasonSpinner);
        eventName = (EditText) findViewById(R.id.eventName);
        btnCreateEvent = (Button) findViewById(R.id.btnCreateEvent);
        btnView = (Button) findViewById(R.id.btnView);
        startDate = (TextView) findViewById(R.id.startDate);
        endDate = (TextView) findViewById(R.id.endDate);
        originText = (TextView) findViewById(R.id.originText);
        stateOriginText = (TextView) findViewById(R.id.stateOriginText);
        destinationText = (TextView) findViewById(R.id.destinationText);
        stateDestinationText = (TextView) findViewById(R.id.stateDestinationText);

        /* Creates event and adds to events table with unique ID */
        btnCreateEvent.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick( View v) {
                String ENAME = (String) eventName.getText().toString();
                String SDATE = (String) startDate.getText().toString();
                String EDATE = (String) endDate.getText().toString();
                String PASSPORT = (String) passportSpinner.getSelectedItem().toString();
                String ORIGIN = (String) originSpinner.getSelectedItem().toString();
                String SORIGIN = (String) stateOriginSpinner.getSelectedItem().toString();
                String DESTINATION = (String) destinationSpinner.getSelectedItem().toString();
                String SDESTINATION = (String) stateDestinationSpinner.getSelectedItem().toString();
                String REASON = (String) reasonSpinner.getSelectedItem().toString();

                SQLiteDatabase database = mDatabaseHelper.getWritableDatabase();

                if (!Objects.equals(ENAME, "") && !Objects.equals(SDATE, "") && !Objects.equals(EDATE, "")) {

                    ContentValues eventValues = new ContentValues();
                    eventValues.put(ECOL1, ENAME);
                    eventValues.put(ECOL2, SDATE);
                    eventValues.put(ECOL3, EDATE);
                    eventValues.put(ECOL4, PASSPORT);
                    eventValues.put(ECOL5, ORIGIN);
                    eventValues.put(ECOL6, SORIGIN);
                    eventValues.put(ECOL7, DESTINATION);
                    eventValues.put(ECOL8, SDESTINATION);
                    eventValues.put(ECOL9, REASON);

                    database.insert(EVENT_TABLE, null, eventValues);

                    Log.d(TAG, "btnCreateEventOnClick: Adding into " + EVENT_TABLE + " -> " + ENAME + " into " + ECOL1 + ", " + SDATE + " into " + ECOL2 + ", " + EDATE + " into " + ECOL3 + ", " + ORIGIN + " into " + ECOL4 + ", " + SORIGIN + " into " + ECOL5 + ", " + DESTINATION + " into " + ECOL6 + ", " + SDESTINATION + " into " + ECOL7 + ", " + REASON + " into " + ECOL8 + ".");

                    toastMessage(getString(R.string.creationSuccess));

                    Intent ListDataIntent = new Intent(calendarCreateEvent.this, calendarAllEvents.class);
                    startActivity(ListDataIntent);
                } else {
                    toastMessage(getResources().getString(R.string.fillAll));
                }
            }
        });

        /* View all events, does not copy anything to events table */
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(calendarCreateEvent.this, calendarAllEvents.class);
                startActivity(intent);
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

                DatePickerDialog dialog = new DatePickerDialog(
                        calendarCreateEvent.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        startDateListener,
                        sYear, sMonth, sDay);
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

                DatePickerDialog dialog = new DatePickerDialog(
                        calendarCreateEvent.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        endDateListener,
                        eYear, eMonth, eDay);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        /* Date listener for start date, sets start date as a string. Will need to be parsed when called */
        startDateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int sYear, int sMonth, int sDay ) {
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
        ArrayAdapter<CharSequence> countryAdapter = ArrayAdapter.createFromResource
                (this, R.array.country_list, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> reasonAdapter = ArrayAdapter.createFromResource
                (this, R.array.reason_list, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> stateAdapter = ArrayAdapter.createFromResource
                (this, R.array.state_list, android.R.layout.simple_spinner_item);

        /* Sets spinners with appropriate adapters and listeners */
        originSpinner.setAdapter(countryAdapter);
        originSpinner.setOnItemSelectedListener(calendarCreateEvent.this);

        stateOriginSpinner.setAdapter(stateAdapter);
        stateOriginSpinner.setOnItemSelectedListener(calendarCreateEvent.this);

        destinationSpinner.setAdapter(countryAdapter);
        destinationSpinner.setOnItemSelectedListener(calendarCreateEvent.this);

        stateDestinationSpinner.setAdapter(stateAdapter);
        stateDestinationSpinner.setOnItemSelectedListener(calendarCreateEvent.this);

        passportSpinner.setAdapter(countryAdapter);
        passportSpinner.setOnItemSelectedListener(calendarCreateEvent.this);

        reasonSpinner.setAdapter(reasonAdapter);
        reasonSpinner.setOnItemSelectedListener(calendarCreateEvent.this);
    }

    /* Spinner listeners, hides or shows state spinner depending on if US is selected or not */
    @Override
    public void onItemSelected( AdapterView<?> parent, View view, int position, long id) {
        int origin = (int) originSpinner.getSelectedItemId();
        int destination = (int) destinationSpinner.getSelectedItemId();

        /* If origin is US, shows states. If not, hides states and resets state to "---" */
        /* Currently the US is 182. When adding or subtracting countries, change that value to the new one */
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
        /* Currently the US is 182. When adding or subtracting countries, change that value to the new one */
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

    /* If nothing is selected, do nothing */
    @Override
    public void onNothingSelected( AdapterView <?> parent ) {

    }

    /* Allow toasts as necessary */
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}
