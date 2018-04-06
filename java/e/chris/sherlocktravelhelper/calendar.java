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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;

import static android.view.View.GONE;

public class calendar extends AppCompatActivity {

    /* Declarations */
    private static final String TAG = "calendar";

    private Button btnViewAll, btnCreateEvent;
    private TextView upcomingHeading, eventName, trip, timeline, visa, consulate, advisory, vccr, emergency;

    private databaseHelper mDatabaseHelper;

    private static final String EVENT_TABLE = "events";
    private static final String ECOL0 = "eventID";
    private static final String ECOL2 = "startDate";

    private static final String COUNTRY_TABLE = "countries";
    private static final String CCOL1 = "country";

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);
        /* Associate with layout IDs */
        mDatabaseHelper = new databaseHelper(this);
        btnViewAll = (Button) findViewById(R.id.btnViewAll);
        btnCreateEvent = (Button) findViewById(R.id.btnCreateEvent);
        upcomingHeading = (TextView) findViewById(R.id.upcomingHeading);
        eventName = (TextView) findViewById(R.id.eventName);
        trip = (TextView) findViewById(R.id.trip);
        timeline = (TextView) findViewById(R.id.timeline);
        visa = (TextView) findViewById(R.id.visa);
        consulate = (TextView) findViewById(R.id.consulate);
        emergency = (TextView) findViewById(R.id.emergency);
        advisory = (TextView) findViewById(R.id.advisory);
        vccr = (TextView) findViewById(R.id.vccr);

        /* Opens all events activity */
        btnViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                Intent calendarAllIntent = new Intent(calendar.this, calendarAllEvents.class);
                startActivity(calendarAllIntent);
            }
        });

        /* Opens create event activity */
        btnCreateEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                Intent calendarNewIntent = new Intent(calendar.this, calendarCreateEvent.class);
                startActivity(calendarNewIntent);
            }
        });

        /* Get non-editable database */
        final SQLiteDatabase database = mDatabaseHelper.getReadableDatabase();

        /* Set SimpleDateFormat and DateFormat */
        final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        final DateFormat formatter = new SimpleDateFormat("M/d/yyyy");

        /* Get current Date */
        Calendar local = Calendar.getInstance();
        Date currentDate = local.getTime();

        /* Create Array List out of start dates from events table */
        final Cursor data = mDatabaseHelper.getEventData();
        ArrayList <Date> dates = new ArrayList <>();
        while (data.moveToNext()) {
            try {
                Date date = sdf.parse(data.getString(2));
                dates.add(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        /* Custom Calendar */
        customCalendar cv = (customCalendar) findViewById(R.id.calendar_view);

        /* Convert dates array list to HashSet to display on custom calendar */
        HashSet <Date> events = new HashSet <>(dates);
        cv.updateCalendar(events);

        /* Assign event handler */
        /* Note to self, try and simplify this process later */
        cv.setEventHandler(new customCalendar.EventHandler() {
            @Override
            public void onDayLongPress( Date date ) {

                /* Get date from clicked cell */
                SimpleDateFormat dForm = new SimpleDateFormat("MMM dd, yyyy");
                DateFormat selDate = formatter.getDateInstance();
                    String sDate = selDate.format(date);

                /* Convert data from (MMM dd, yyyy) to (M/dd/yyyy) as is in the event table */
                try {
                    Date seDate = dForm.parse(sDate);
                    String selectedDate = formatter.format(seDate);

                    /* Get event ID if an event occurs on that day, if not, return toast */
                    String selectQuery = "SELECT " + ECOL0 + " FROM " + EVENT_TABLE + " WHERE "
                            + ECOL2 + " = '" + selectedDate + "'";
                    Cursor selectData = database.rawQuery(selectQuery, null);
                    int eventID = -1;
                    while (selectData.moveToNext()) {
                        eventID = selectData.getInt(0);
                    }

                    /* If there is an event, get the event name, then pass ID and name and start calendarSingleEvent */
                    if (eventID > -1) {
                        String nameQuery = "SELECT * FROM " + EVENT_TABLE + " WHERE "
                                + ECOL0 + " = " +eventID;
                        Cursor nameData = database.rawQuery(nameQuery, null);
                        nameData.moveToFirst();
                        String eventName = nameData.getString(1);
                        Intent SingleEventIntent = new Intent(calendar.this, calendarSingleEvent.class);
                        SingleEventIntent.putExtra("eventID", eventID);
                        SingleEventIntent.putExtra("eventName", eventName);
                        System.out.println("eventID: " + eventID);
                        System.out.println("eventName: " + eventName);
                        startActivity(SingleEventIntent);

                        /* If no event, toast */
                    } else {
                        toastMessage("No trips planned for this day.");
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

        /* Set startDate as nearest date to current date */
        Date nearestDate = getNearestDate(dates, currentDate);
        if (nearestDate != null) {
            String startDate = formatter.format(nearestDate);
            long sDate = nearestDate.getTime();
            long cDate = currentDate.getTime();

            /* Select event with startDate, this does not close until the near the end */
            if (sDate > cDate) {
                String eventQuery = "SELECT * FROM " + EVENT_TABLE + " WHERE " + ECOL2 + " = '" + startDate + "'";
                Cursor eventData = database.rawQuery(eventQuery, null);
                System.out.println("eventData: " +eventData);
                if (eventData != null) {
                    eventData.moveToFirst();

                    final String eEName = eventData.getString(1);
                    final String eSDate = eventData.getString(2);
                    final String eEDate = eventData.getString(3);
                    final String ePassport = eventData.getString(4);
                    final String eOrigin = eventData.getString(5);
                    final String eSOrigin = eventData.getString(6);
                    final String eDestination = eventData.getString(7);
                    final String eSDestination = eventData.getString(8);
                    final String eReason = eventData.getString(9);

                    /* Select specific destination country from event table */
                    String countryQuery = "SELECT * FROM " + COUNTRY_TABLE + " WHERE " + CCOL1 + " = '" + eDestination + "'";
                    Cursor countryData = database.rawQuery(countryQuery, null);
                    if (countryData != null) {
                        countryData.moveToFirst();
                    }

                    String cAdvisory = countryData.getString(2);
                    String cCode = countryData.getString(3);
                    String cNationality = countryData.getString(5);
                    String cVCCR = countryData.getString(9);
                    String cEmergency = countryData.getString(10);

                    /* Change to upcoming event and show all data */
                    upcomingHeading.setText(getString(R.string.upcomingEvent));
                    eventName.setVisibility(View.VISIBLE);
                    trip.setVisibility(View.VISIBLE);
                    timeline.setVisibility(View.VISIBLE);
                    visa.setVisibility(View.VISIBLE);
                    consulate.setVisibility(View.VISIBLE);
                    emergency.setVisibility(View.VISIBLE);
                    advisory.setVisibility(View.VISIBLE);
                    vccr.setVisibility(View.VISIBLE);

                    /* Display event name for user */
                    eventName.setText(eEName);

                    /* Set onClick Listener to take user to single event and transfer ID and Name intent to new activity */
                    eventName.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick( View v ) {
                            Cursor data = mDatabaseHelper.getEventID(eEName);
                            int eventID = -1;
                            while (data.moveToNext()) {
                                eventID = data.getInt(0);
                            }
                            if (eventID > -1) {
                                Log.d(TAG, "onItemClick: The ID is: " + eventID);
                                Intent SingleEventIntent = new Intent(calendar.this, calendarSingleEvent.class);
                                SingleEventIntent.putExtra("eventID", eventID);
                                SingleEventIntent.putExtra("eventName", eEName);
                                startActivity(SingleEventIntent);
                            } else {
                                toastMessage(getResources().getString(R.string.noID));
                            }
                        }
                    });

                    /* Display trip origin and destination for user */
                    trip.setText(displayFormulas.trip(eOrigin, eSOrigin, eDestination, eSDestination, eReason));

                    /* Display event timeline for user */
                    timeline.setText(getResources().getString(R.string.from) + eSDate + getResources().getString(R.string.toConnector) + eEDate);

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

                    /* Display travel advisory information as well as code for user. Code definitions found in defintions */
                    if (displayFormulas.advisories(cAdvisory, cCode) == null) {
                        advisory.setVisibility(GONE);
                    } else {
                        advisory.setText(displayFormulas.advisories(cAdvisory, cCode));
                    }

                    /* Display if destination is a party to VCCR */
                    vccr.setText(displayFormulas.vccrParty(eDestination, cVCCR));
                }
            }
        }
    }

    /* Gets nearest date from created array list */
    public Date getNearestDate( ArrayList<Date> dates, Date currentDate) {
        Date nearestDate = null;
        int index = 0;
        long prevDiff = -1;
        long targetTS = currentDate.getTime();
        for (int i = 0; i < dates.size(); i++) {
            Date date = dates.get(i);
            long testDate = date.getTime();
            if (testDate > targetTS) {
                long currDiff = Math.abs(testDate - targetTS);
                if (prevDiff == -1 || currDiff < prevDiff) {
                    prevDiff = currDiff;
                    nearestDate = date;
                    index = i;
                }
            }
        }
        return nearestDate;
    }

    /* Allow toasts as necessary */
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}
