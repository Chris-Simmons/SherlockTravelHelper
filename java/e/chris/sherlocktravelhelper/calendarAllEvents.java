package e.chris.sherlocktravelhelper;

import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class calendarAllEvents extends AppCompatActivity {

    /* Declarations */
    private static final String TAG = "calendarAllEvents";

    databaseHelper mDatabaseHelper;

    private ListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        /* Associate with layout IDs */
        mListView = (ListView) findViewById(R.id.listView);
        mDatabaseHelper = new databaseHelper(this);


        /* Run list view function */
        populateListView();

        /* Open calendar activity */
        Button btnCalendar = findViewById(R.id.btnCalendar);
        btnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v) {
                Intent openCalendar = new Intent(calendarAllEvents.this, calendar.class);
                startActivity(openCalendar);
            }
        });

        /* Create a new event */
        Button btnNew = findViewById(R.id.btnNew);
        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v) {
                Intent openCreateEvent = new Intent(calendarAllEvents.this, calendarCreateEvent.class);
                startActivity(openCreateEvent);
            }
        });
    }

    /* Populates the list view from event table */
    private void populateListView() {
        Log.d(TAG, "populateListView: Displaying data in the ListView.");

        Cursor data = mDatabaseHelper.getEventData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            listData.add(data.getString(1));
        }

        /* Set list adapter */
        ListAdapter adapter = new ArrayAdapter<>(this, R.layout.event_list_item, listData);
        mListView.setAdapter(adapter);

        /* Set onClick Listener to take user to single event and transfer ID and Name intent to new activity */
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String eventName = adapterView.getItemAtPosition(i).toString();
                Log.d(TAG, "onItemClick: You Clicked on " + eventName);

                Cursor data = mDatabaseHelper.getEventID(eventName);
                int eventID = -1;
                while(data.moveToNext()){
                    eventID = data.getInt(0);
                }
                if(eventID > -1){
                    Log.d(TAG, "onItemClick: The ID is: " + eventID);
                    Intent SingleEventIntent = new Intent(calendarAllEvents.this, calendarSingleEvent.class);
                    SingleEventIntent.putExtra("eventID",eventID);
                    SingleEventIntent.putExtra("eventName",eventName);
                    startActivity(SingleEventIntent);
                }
                else{
                    toastMessage(getResources().getString(R.string.noID));
                }
            }
        });
    }

    /* Allows toasts as necessary */
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}