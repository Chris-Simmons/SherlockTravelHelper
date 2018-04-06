package e.chris.sherlocktravelhelper;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

/**
 * Created by chris on 2/22/18.
 */

public class customCalendar extends LinearLayout {

    /* To do:
        There's a problem with displaying events on refresh or when you switch from month to month.
        Figure out how exactly this can be fixed. I think it's just a matter of adding some code to the
        update bits, but the question is what code exactly?
     */

    /* Declarations */
    private static final String TAG = "customCalendar";

    /* Days count is set to 42 (6 weeks) for worst case scenarios where 31 days in a month and month
        starts on a Saturday so that it displays full weeks regardless of time in the month */
    private static final int DAYS_COUNT = 42;
    private static final String DATE_FORMAT = "MMM yyyy";

    private String dateFormat;
    private Calendar currentDate = Calendar.getInstance();
    private EventHandler eventHandler = null;
    private LinearLayout header;
    private ImageView btnPrev;
    private ImageView btnNext;
    private TextView txtDate;
    private GridView grid;

    public customCalendar( Context context)
    {
        super(context);
    }

    public customCalendar( Context context, AttributeSet attrs) {
        super(context, attrs);
        initControl(context, attrs);
    }

    public customCalendar( Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initControl(context, attrs);
    }

    /* Load control layout */
    private void initControl(Context context, AttributeSet attrs) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.control_calendar, this);

        loadDateFormat(attrs);
        assignUiElements();
        assignClickHandlers();

        updateCalendar();
    }

    private void loadDateFormat(AttributeSet attrs) {
        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.customCalendar);

        try {
            dateFormat = ta.getString(R.styleable.customCalendar_dateFormat);
            if (dateFormat == null)
                dateFormat = DATE_FORMAT;
        }
        finally {
            ta.recycle();
        }
    }
    private void assignUiElements() {
        /* Define local variables */
        header = (LinearLayout)findViewById(R.id.calendar_header);
        btnPrev = (ImageView)findViewById(R.id.calendar_prev_button);
        btnNext = (ImageView)findViewById(R.id.calendar_next_button);
        txtDate = (TextView)findViewById(R.id.calendar_date_display);
        grid = (GridView)findViewById(R.id.calendar_grid);
    }

    private void assignClickHandlers() {
        /* Add a month */
        btnNext.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                currentDate.add(Calendar.MONTH, 1);
                updateCalendar();
            }
        });

        /* Subtract a month */
        btnPrev.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                currentDate.add(Calendar.MONTH, -1);
                updateCalendar();
            }
        });

        /* Long press a day */
        grid.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {

            @Override
            public boolean onItemLongClick(AdapterView<?> view, View cell, int position, long id)
            {
                if (eventHandler == null)
                    return false;

                eventHandler.onDayLongPress((Date)view.getItemAtPosition(position));
                return true;
            }
        });
    }

    /* Display dates to grid */
    public void updateCalendar()
    {
        updateCalendar(null);
    }

    /* Display dates to grid */
    public void updateCalendar(HashSet<Date> events) {
        ArrayList<Date> cells = new ArrayList<>();
        Calendar calendar = (Calendar)currentDate.clone();

        /* Find cell for start of month */
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int monthBeginningCell = calendar.get(Calendar.DAY_OF_WEEK) - 1;

        /* Move calendar backwards to the beginning of the week */
        calendar.add(Calendar.DAY_OF_MONTH, -monthBeginningCell);

        /* Fill cells */
        while (cells.size() < DAYS_COUNT)
        {
            cells.add(calendar.getTime());
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        /* Update grid */
        grid.setAdapter(new CalendarAdapter(getContext(), cells, events));

        /* Update month and year */
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        txtDate.setText(sdf.format(currentDate.getTime()));
    }


    private class CalendarAdapter extends ArrayAdapter<Date> {
        /* Day with events */
        private HashSet<Date> eventDays;

        /* Inflate Layout */
        private LayoutInflater inflater;

        public CalendarAdapter(Context context, ArrayList<Date> days, HashSet<Date> eventDays) {
            super(context, R.layout.control_calendar_day, days);
            this.eventDays = eventDays;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            /* Day */
            Date date = getItem(position);
            int day = date.getDate();
            int month = date.getMonth();
            int year = date.getYear();

            /* Today */
            Date today = new Date();

            /* Inflate if none exists */
            if (view == null)
                view = inflater.inflate(R.layout.control_calendar_day, parent, false);

            /* Display event image if there is an image */
            view.setBackgroundResource(0);
            if (eventDays != null) {
                for (Date eventDate : eventDays) {
                    if (eventDate.getDate() == day &&
                            eventDate.getMonth() == month &&
                            eventDate.getYear() == year) {
                        /* Mark the day */
                        ((TextView)view).setBackgroundColor(getResources().getColor(R.color.gold_leaf));
                        ((TextView)view).setTypeface(null, Typeface.BOLD);
                        ((TextView)view).setTextColor(getResources().getColor(R.color.black_steel));
                        break;
                    }
                }
            }

            if (month != today.getMonth() || year != today.getYear()) {
                /* Grey out days outside of the month */
                ((TextView)view).setTextColor(getResources().getColor(R.color.silver));
            }
            else if (day == today.getDate()) {
                /* Show today as blue and bold */
                ((TextView)view).setBackgroundColor(getResources().getColor(R.color.silver));
                ((TextView)view).setTypeface(null, Typeface.BOLD);
                ((TextView)view).setTextColor(getResources().getColor(R.color.gold_leaf));
            }

            /* Set text */
            ((TextView)view).setText(String.valueOf(date.getDate()));

            return view;
        }
    }

    /* Assign EventHandler */
    public void setEventHandler(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    /* Define what is shown */
    public interface EventHandler {
        void onDayLongPress(Date date);
    }
}