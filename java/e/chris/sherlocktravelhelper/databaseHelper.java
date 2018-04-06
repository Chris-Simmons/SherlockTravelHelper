package e.chris.sherlocktravelhelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by chris on 2/13/18.
 */

public class databaseHelper extends SQLiteOpenHelper {

    /* Declarations */
    private static final String TAG = "databaseHelper";

    public static final String DBNAME = "traveldb.db";
    public static String DBPATH = "";
    private Context mContext;
    private SQLiteDatabase mDatabase;
    private static final String EVENT_TABLE = "events";
    private static final String ECOL0 = "eventID";
    private static final String ECOL1 = "eventName";

    /* Get database path, name, and version number */
    public databaseHelper( Context context ) {
        super(context, DBNAME, null, 1);
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            DBPATH = context.getApplicationInfo().dataDir + "/databases/";
        } else {
            DBPATH = "/data/data/" + context.getPackageName() + "/databases/";
        }
        this.mContext = context;
    }

    /* On create is empty until needed */
    @Override
    public void onCreate( SQLiteDatabase db ) {

    }

    /* On upgrade is empty until later, still need to learn to upgrade databases */
    @Override
    public void onUpgrade( SQLiteDatabase db, int oldVersion, int newVersion ) {

    }

    /* Gets data from events table */
    public Cursor getEventData(){
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "SELECT * FROM " + EVENT_TABLE;
        Cursor data = database.rawQuery(query, null);
        return data;
    }

    /* Gets specific event ID from events table using eventName */
    public Cursor getEventID(String eventName){
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "SELECT " + ECOL0 + " FROM " + EVENT_TABLE +
                " WHERE " + ECOL1 + " = '" + eventName + "'";
        Cursor data = database.rawQuery(query, null);
        return data;
    }
}
