package e.chris.sherlocktravelhelper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import static android.view.View.GONE;

public class mainMenu extends AppCompatActivity {

    /* Notes to self:
        -- Figure out if you want advertisements on this and to sell at a lower cost or sell
        at a higher cost to avoid adverts. Personally, I hate adverts, so a higher base cost for unlimited
        use without adverts is preferable.
        -- How much would this sell for? After telling friends about the idea and showing a rudimentary
        javascript version of the core functionality, I have had friends say that they would be willing to pay
        as low as $.99 to as high as $30. There is definitely a happy middle in there. How much is the research
        that went into creating the visa formula worth as that is the main unique code for this app and is also
        the core functionality? How much is the creation and gathering of all of the database info worth (especially
        since I had already had that information on hand from the creation of my law firm's website and I would use
        the app myself regardless of it sells or not).
        -- Make sure to go back and clean up the code. I'm sure there are a ton of small mistakes or errors that don't
        crash the program or interfere with it running, but is either not up to standards coding wise or could be written
        in a nicer and cleaner way. (Especially on the oldest activities as my coding style has evolved to something
        I like and can easily read - the older activities may not use that style. Standardize everything to one style.)
        Make sure to add comments to everything so that I or anyone who looks at this code can easily figure out what
        the code does or the purpose of the code. Get rid of redundancy and unused code (declarations, formulas, scripts).
     */

    /* Declarations */
    private static final String TAG = "mainMenu";

    private Button btnCalendar, btnSpecific, btnDocuments, btnBulletin, btnDefinitions, btnEmergency;
    private TextView upcomingHeading, eventName, trip, timeline, advisory, consulate, emergency, vccr, capital, currency, language, nationality, visa;
    private databaseHelper mDatabaseHelper;


    private static final String EVENT_TABLE = "events";
    private static final String ECOL3 = "endDate";

    private static final String COUNTRY_TABLE = "countries";
    private static final String CCOL1 = "country";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        /* Associate with layout IDs */
        mDatabaseHelper = new databaseHelper(this);
        upcomingHeading = (TextView) findViewById(R.id.upcomingHeading);
        eventName = (TextView) findViewById(R.id.eventName);
        trip = (TextView) findViewById(R.id.trip);
        timeline = (TextView) findViewById(R.id.timeline);
        visa = (TextView) findViewById(R.id.visa);
        consulate = (TextView) findViewById(R.id.consulate);
        emergency = (TextView) findViewById(R.id.emergency);
        advisory = (TextView) findViewById(R.id.advisory);
        vccr = (TextView) findViewById(R.id.vccr);
        capital = (TextView) findViewById(R.id.capital);
        currency = (TextView) findViewById(R.id.currency);
        language = (TextView) findViewById(R.id.language);
        nationality = (TextView) findViewById(R.id.nationality);
        btnCalendar = (Button) findViewById(R.id.btnCalendar);
        btnSpecific = (Button) findViewById(R.id.btnSpecific);
        btnDocuments = (Button) findViewById(R.id.btnDocuments);
        btnBulletin = (Button) findViewById(R.id.btnBulletin);
        btnDefinitions = (Button) findViewById(R.id.btnDefinitions);
        btnEmergency = (Button) findViewById(R.id.btnEmergency);

        /* Copies database if it's not already copied */
        File db = getApplicationContext().getDatabasePath(databaseHelper.DBNAME);
        if(!db.exists()) {
            mDatabaseHelper.getReadableDatabase();
            if(copyDatabase(this)) {
                Toast.makeText(this, getString(R.string.copySuccess), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, getString(R.string.copyError), Toast.LENGTH_SHORT).show();
                return;
            }
        }

        /* Get non-editable database */
        final SQLiteDatabase database = mDatabaseHelper.getReadableDatabase();

        /* Open Calendar */
        btnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                Intent calendarIntent = new Intent(mainMenu.this, calendar.class);
                startActivity(calendarIntent);
            }
        });

        /* Open World */
        btnSpecific.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                Intent specificIntent = new Intent(mainMenu.this, specific.class);
                startActivity(specificIntent);
            }
        });

        /* Open Documents */
        btnDocuments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                Intent documentsIntent = new Intent(mainMenu.this, documents.class);
                startActivity(documentsIntent);
            }
        });

        /* Open Bulletin */
        btnBulletin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                Intent bulletinIntent = new Intent(mainMenu.this, bulletin.class);
                startActivity(bulletinIntent);
            }
        });

        /* Open Definitions */
        btnDefinitions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                Intent definitionsIntent = new Intent(mainMenu.this, definitions.class);
                startActivity(definitionsIntent);
            }
        });

        /* Default Emergency Call */
        btnEmergency.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick( View v ) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:911"));
                startActivity(intent);
                return false;
            }
        });

        /* Set SimpleDateFormat and DateFormat */
        final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        final DateFormat formatter = new SimpleDateFormat("M/d/yyyy");

        /* Get current Date */
        Calendar local = Calendar.getInstance();
        Date currentDate = local.getTime();

        /* Create Array List out of start dates from events table */
        final Cursor data = mDatabaseHelper.getEventData();
        ArrayList <Date> endDates = new ArrayList <>();
        while (data.moveToNext()) {
            try {
                Date date = sdf.parse(data.getString(3));
                endDates.add(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        /* Set startDate as nearest date to current date */
        Date nearestDate = getNearestDate(endDates, currentDate);
        if (nearestDate != null) {
            String endDate = formatter.format(nearestDate);
            long eDate = nearestDate.getTime();
            long cDate = currentDate.getTime();

            /* Select event with startDate, this does not close until the near the end */
            if (eDate > cDate) {
                String eventQuery = "SELECT * FROM " + EVENT_TABLE + " WHERE " + ECOL3 + " = '" + endDate + "'";
                Cursor eventData = database.rawQuery(eventQuery, null);
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
                    String cCapital = countryData.getString(4);
                    String cNationality = countryData.getString(5);
                    String cLanguage = countryData.getString(6);
                    String cCurrency = countryData.getString(7);
                    String cCAbbreviation = countryData.getString(8);
                    String cVCCR = countryData.getString(9);
                    final String cEmergency = countryData.getString(10);

                    /* Change to upcoming event and show all data */
                    upcomingHeading.setVisibility(GONE);
                    eventName.setVisibility(View.VISIBLE);
                    trip.setVisibility(View.VISIBLE);
                    timeline.setVisibility(View.VISIBLE);
                    visa.setVisibility(View.VISIBLE);
                    consulate.setVisibility(View.VISIBLE);
                    advisory.setVisibility(View.VISIBLE);
                    vccr.setVisibility(View.VISIBLE);
                    capital.setVisibility(View.VISIBLE);
                    nationality.setVisibility(View.VISIBLE);
                    currency.setVisibility(View.VISIBLE);
                    language.setVisibility(View.VISIBLE);

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
                                Intent SingleEventIntent = new Intent(mainMenu.this, calendarSingleEvent.class);
                                SingleEventIntent.putExtra("eventID", eventID);
                                SingleEventIntent.putExtra("eventName", eEName);
                                startActivity(SingleEventIntent);
                            } else {
                                toastMessage(getString(R.string.noID));
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

                    /* Display travel advisory information as well as code for user. Code definitions found in definitions */
                    advisory.setText(displayFormulas.advisories(cAdvisory, cCode));

                    /* Display if destination is a party to VCCR */
                    vccr.setText(displayFormulas.vccrParty(eDestination, cVCCR));

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

                    /* Emergency Call, changes number dialed to country emergency number only if the trip is the current trip
                       If the trip is upcoming, but not currently happening, defaults to 911 */
                    try {
                        Date stDate = sdf.parse(eSDate);
                        long sDate = stDate.getTime();
                        if (cDate > sDate) {
                            btnEmergency.setOnLongClickListener(new View.OnLongClickListener() {
                                @Override
                                public boolean onLongClick( View v ) {
                                    Intent intent = new Intent(Intent.ACTION_DIAL);
                                    intent.setData(Uri.parse("tel:" + cEmergency));
                                    startActivity(intent);
                                    return false;
                                }
                            });
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* Copies database */
    private boolean copyDatabase(Context context) {
        try {

            InputStream inputStream = context.getAssets().open(databaseHelper.DBNAME);
            String outFileName = databaseHelper.DBPATH + databaseHelper.DBNAME;
            OutputStream outputStream = new FileOutputStream(outFileName);
            byte[]buff = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buff)) > 0) {
                outputStream.write(buff, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            Log.w("MainActivity","DB copied");
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* Gets nearest date from created array list */
    public Date getNearestDate( ArrayList<Date> endDates, Date currentDate) {
        Date nearestDate = null;
        int index = 0;
        long prevDiff = -1;
        long targetTS = currentDate.getTime();
            for (int i = 0; i < endDates.size(); i++) {
                Date date = endDates.get(i);
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