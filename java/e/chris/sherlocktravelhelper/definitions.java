package e.chris.sherlocktravelhelper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by chris on 2/18/18.
 */

public class definitions extends AppCompatActivity {

    /* Declarations */
        expandableListAdapter listAdapter;
        ExpandableListView expListView;
        List<String> listDataHeader;
        HashMap<String, List<String>> listDataChild;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.definitions);
            /* Associate with layout IDs */
            expListView = (ExpandableListView) findViewById(R.id.definitionList);

            /* Prepare list */
            prepareListData();

            /* Set adapters */
            listAdapter = new expandableListAdapter(this, listDataHeader, listDataChild);
            expListView.setAdapter(listAdapter);
            expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

                @Override
                public boolean onGroupClick(ExpandableListView parent, View v,
                                            int groupPosition, long id) {
                    return false;
                }
            });

            /* Child on click listeners */
            expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                @Override
                public boolean onChildClick(ExpandableListView parent, View v,
                                            int groupPosition, int childPosition, long id) {
                    return false;
                }
            });
        }

    /* Prepares all of the definitions to be displayed in an expandable list */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        /* Adds headers */
        listDataHeader.add(getResources().getString(R.string.defTravHeading));
        listDataHeader.add(getResources().getString(R.string.defEventHeading));
        listDataHeader.add(getResources().getString(R.string.defVisaHeading));
        listDataHeader.add(getResources().getString(R.string.defDocumentHeading));
        listDataHeader.add(getResources().getString(R.string.defCountryHeading));
        listDataHeader.add(getResources().getString(R.string.defStateHeading));
        listDataHeader.add(getResources().getString(R.string.defBulletinHeading));

        /* Start define children */
        List<String> advisory = new ArrayList<String>();
        advisory.add(getResources().getString(R.string.defTravAdv));
        advisory.add(getResources().getString(R.string.defTravLvl1));
        advisory.add(getResources().getString(R.string.defTravLvl2));
        advisory.add(getResources().getString(R.string.defTravLvl3));
        advisory.add(getResources().getString(R.string.defTravLvl4));
        advisory.add(getResources().getString(R.string.defTravCodeC));
        advisory.add(getResources().getString(R.string.defTravCodeE));
        advisory.add(getResources().getString(R.string.defTravCodeH));
        advisory.add(getResources().getString(R.string.defTravCodeO));
        advisory.add(getResources().getString(R.string.defTravCodeT));
        advisory.add(getResources().getString(R.string.defTravCodeU));

        List<String> events = new ArrayList<String>();
        events.add(getResources().getString(R.string.defEventName));
        events.add(getResources().getString(R.string.defEventCOrigin));
        events.add(getResources().getString(R.string.defEventSOrigin));
        events.add(getResources().getString(R.string.defEventCDestination));
        events.add(getResources().getString(R.string.defEventSDestination));
        events.add(getResources().getString(R.string.defEventStart));
        events.add(getResources().getString(R.string.defEventEnd));
        events.add(getResources().getString(R.string.defEventReason));
        events.add(getResources().getString(R.string.defEventTourism));
        events.add(getResources().getString(R.string.defEventBusiness));
        events.add(getResources().getString(R.string.defEventWork));
        events.add(getResources().getString(R.string.defEventEducation));
        events.add(getResources().getString(R.string.defEventOther));

        List<String> visa = new ArrayList<String>();
        visa.add(getResources().getString(R.string.defVisaVisa));
        visa.add(getResources().getString(R.string.defVisaNoVisa));
        visa.add(getResources().getString(R.string.defVisaVOA));
        visa.add(getResources().getString(R.string.defVisaVWP));
        visa.add(getResources().getString(R.string.defVisaSchengen));
        visa.add(getResources().getString(R.string.defVisaESTA));
        visa.add(getResources().getString(R.string.defVisaReg));
        visa.add(getResources().getString(R.string.defVisaVacc));
        visa.add(getResources().getString(R.string.defVisaEP));

        List<String> docs = new ArrayList<String>();
        docs.add(getResources().getString(R.string.defDocCon));
        docs.add(getResources().getString(R.string.defDocUDHR));
        docs.add(getResources().getString(R.string.defDocVCCR));

        List<String> country = new ArrayList<String>();
        country.add(getResources().getString(R.string.defCountryCons));
        country.add(getResources().getString(R.string.defCountryCurr));
        country.add(getResources().getString(R.string.defCountryNat));
        country.add(getResources().getString(R.string.defCountryLang));

        List<String> state = new ArrayList<String>();
        state.add(getResources().getString(R.string.defStateFed));
        state.add(getResources().getString(R.string.defStateSS));
        state.add(getResources().getString(R.string.defStateSA));

        List<String> bullet = new ArrayList<String>();
        bullet.add(getResources().getString(R.string.defBulletinVisa));
        bullet.add(getResources().getString(R.string.defBulletinAll));
        bullet.add(getResources().getString(R.string.defBulletinFamily));
        bullet.add(getResources().getString(R.string.defBulletinEmployment));
        bullet.add(getResources().getString(R.string.defBulletinPreference));
        bullet.add(getResources().getString(R.string.defBulletinProcessing));
        /* End define children */

        /* Adds children to appropriate header */
        listDataChild.put(listDataHeader.get(0), advisory);
        listDataChild.put(listDataHeader.get(1), events);
        listDataChild.put(listDataHeader.get(2), visa);
        listDataChild.put(listDataHeader.get(3), docs);
        listDataChild.put(listDataHeader.get(4), country);
        listDataChild.put(listDataHeader.get(5), state);
        listDataChild.put(listDataHeader.get(6), bullet);
    }
}