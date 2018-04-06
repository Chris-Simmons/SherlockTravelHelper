package e.chris.sherlocktravelhelper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class documentsUDHR extends AppCompatActivity {

    /* Reason for this document: I believe everyone in the world should have a copy available as this
        document lays out some basic human rights and is the basis of some of customary international
        law, this gives them one. It is me fulfilling a small bit of human rights work within the app */

    /* Declarations */
    expandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.udhr);
        /* Associate with layout IDs */
        expListView = (ExpandableListView) findViewById(R.id.udhr);

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

    /* Prepares all of the UDHR to be displayed in an expandable list */
    private void prepareListData() {


        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        /* Adds headers */
        listDataHeader.add(getResources().getString(R.string.preambleHeadingUDHR));
        listDataHeader.add(getResources().getString(R.string.art1HeadingUDHR));
        listDataHeader.add(getResources().getString(R.string.art2HeadingUDHR));
        listDataHeader.add(getResources().getString(R.string.art3HeadingUDHR));
        listDataHeader.add(getResources().getString(R.string.art4HeadingUDHR));
        listDataHeader.add(getResources().getString(R.string.art5HeadingUDHR));
        listDataHeader.add(getResources().getString(R.string.art6HeadingUDHR));
        listDataHeader.add(getResources().getString(R.string.art7HeadingUDHR));
        listDataHeader.add(getResources().getString(R.string.art8HeadingUDHR));
        listDataHeader.add(getResources().getString(R.string.art9HeadingUDHR));
        listDataHeader.add(getResources().getString(R.string.art10HeadingUDHR));
        listDataHeader.add(getResources().getString(R.string.art11HeadingUDHR));
        listDataHeader.add(getResources().getString(R.string.art12HeadingUDHR));
        listDataHeader.add(getResources().getString(R.string.art13HeadingUDHR));
        listDataHeader.add(getResources().getString(R.string.art14HeadingUDHR));
        listDataHeader.add(getResources().getString(R.string.art15HeadingUDHR));
        listDataHeader.add(getResources().getString(R.string.art16HeadingUDHR));
        listDataHeader.add(getResources().getString(R.string.art17HeadingUDHR));
        listDataHeader.add(getResources().getString(R.string.art18HeadingUDHR));
        listDataHeader.add(getResources().getString(R.string.art19HeadingUDHR));
        listDataHeader.add(getResources().getString(R.string.art20HeadingUDHR));
        listDataHeader.add(getResources().getString(R.string.art21HeadingUDHR));
        listDataHeader.add(getResources().getString(R.string.art22HeadingUDHR));
        listDataHeader.add(getResources().getString(R.string.art23HeadingUDHR));
        listDataHeader.add(getResources().getString(R.string.art24HeadingUDHR));
        listDataHeader.add(getResources().getString(R.string.art25HeadingUDHR));
        listDataHeader.add(getResources().getString(R.string.art26HeadingUDHR));
        listDataHeader.add(getResources().getString(R.string.art27HeadingUDHR));
        listDataHeader.add(getResources().getString(R.string.art28HeadingUDHR));
        listDataHeader.add(getResources().getString(R.string.art29HeadingUDHR));
        listDataHeader.add(getResources().getString(R.string.art30HeadingUDHR));

        /* Start define children */
        List<String> udhrPreamble = new ArrayList<String>();
        udhrPreamble.add(getResources().getString(R.string.preamablePar1UDHR));
        udhrPreamble.add(getResources().getString(R.string.preamablePar2UDHR));
        udhrPreamble.add(getResources().getString(R.string.preamablePar3UDHR));
        udhrPreamble.add(getResources().getString(R.string.preamablePar4UDHR));
        udhrPreamble.add(getResources().getString(R.string.preamablePar5UDHR));
        udhrPreamble.add(getResources().getString(R.string.preamablePar6UDHR));
        udhrPreamble.add(getResources().getString(R.string.preamablePar7UDHR));
        udhrPreamble.add(getResources().getString(R.string.preamablePar8UDHR));
        List<String> udhrArt1 = new ArrayList<String>();
        udhrArt1.add(getResources().getString(R.string.art1Par1UDHR));

        List<String> udhrArt2 = new ArrayList<String>();
        udhrArt2.add(getResources().getString(R.string.art2Par1UDHR));

        List<String> udhrArt3 = new ArrayList<String>();
        udhrArt3.add(getResources().getString(R.string.art3Par1UDHR));

        List<String> udhrArt4 = new ArrayList<String>();
        udhrArt4.add(getResources().getString(R.string.art4Par1UDHR));

        List<String> udhrArt5 = new ArrayList<String>();
        udhrArt5.add(getResources().getString(R.string.art5Par1UDHR));

        List<String> udhrArt6 = new ArrayList<String>();
        udhrArt6.add(getResources().getString(R.string.art6Par1UDHR));

        List<String> udhrArt7 = new ArrayList<String>();
        udhrArt7.add(getResources().getString(R.string.art7Par1UDHR));

        List<String> udhrArt8 = new ArrayList<String>();
        udhrArt8.add(getResources().getString(R.string.art8Par1UDHR));

        List<String> udhrArt9 = new ArrayList<String>();
        udhrArt9.add(getResources().getString(R.string.art9Par1UDHR));

        List<String> udhrArt10 = new ArrayList<String>();
        udhrArt10.add(getResources().getString(R.string.art10Par1UDHR));

        List<String> udhrArt11 = new ArrayList<String>();
        udhrArt11.add(getResources().getString(R.string.art11Par1UDHR));
        udhrArt11.add(getResources().getString(R.string.art11Par2UDHR));

        List<String> udhrArt12 = new ArrayList<String>();
        udhrArt12.add(getResources().getString(R.string.art12Par1UDHR));

        List<String> udhrArt13 = new ArrayList<String>();
        udhrArt13.add(getResources().getString(R.string.art13Par1UDHR));
        udhrArt13.add(getResources().getString(R.string.art13Par2UDHR));

        List<String> udhrArt14 = new ArrayList<String>();
        udhrArt14.add(getResources().getString(R.string.art14Par1UDHR));
        udhrArt14.add(getResources().getString(R.string.art14Par2UDHR));

        List<String> udhrArt15 = new ArrayList<String>();
        udhrArt15.add(getResources().getString(R.string.art15Par1UDHR));
        udhrArt15.add(getResources().getString(R.string.art15Par2UDHR));

        List<String> udhrArt16 = new ArrayList<String>();
        udhrArt16.add(getResources().getString(R.string.art16Par1UDHR));
        udhrArt16.add(getResources().getString(R.string.art16Par2UDHR));
        udhrArt16.add(getResources().getString(R.string.art16Par3UDHR));

        List<String> udhrArt17 = new ArrayList<String>();
        udhrArt17.add(getResources().getString(R.string.art17Par1UDHR));
        udhrArt17.add(getResources().getString(R.string.art17Par2UDHR));

        List<String> udhrArt18 = new ArrayList<String>();
        udhrArt18.add(getResources().getString(R.string.art18Par1UDHR));

        List<String> udhrArt19 = new ArrayList<String>();
        udhrArt19.add(getResources().getString(R.string.art19Par1UDHR));

        List<String> udhrArt20 = new ArrayList<String>();
        udhrArt20.add(getResources().getString(R.string.art20Par1UDHR));
        udhrArt20.add(getResources().getString(R.string.art20Par2UDHR));

        List<String> udhrArt21 = new ArrayList<String>();
        udhrArt21.add(getResources().getString(R.string.art21Par1UDHR));
        udhrArt21.add(getResources().getString(R.string.art21Par2UDHR));
        udhrArt21.add(getResources().getString(R.string.art21Par3UDHR));

        List<String> udhrArt22 = new ArrayList<String>();
        udhrArt22.add(getResources().getString(R.string.art22Par1UDHR));

        List<String> udhrArt23 = new ArrayList<String>();
        udhrArt23.add(getResources().getString(R.string.art23Par1UDHR));
        udhrArt23.add(getResources().getString(R.string.art23Par2UDHR));
        udhrArt23.add(getResources().getString(R.string.art23Par3UDHR));
        udhrArt23.add(getResources().getString(R.string.art23Par4UDHR));

        List<String> udhrArt24 = new ArrayList<String>();
        udhrArt24.add(getResources().getString(R.string.art24Par1UDHR));

        List<String> udhrArt25 = new ArrayList<String>();
        udhrArt25.add(getResources().getString(R.string.art25Par1UDHR));
        udhrArt25.add(getResources().getString(R.string.art25Par2UDHR));

        List<String> udhrArt26 = new ArrayList<String>();
        udhrArt26.add(getResources().getString(R.string.art26Par1UDHR));
        udhrArt26.add(getResources().getString(R.string.art26Par2UDHR));
        udhrArt26.add(getResources().getString(R.string.art26Par3UDHR));

        List<String> udhrArt27 = new ArrayList<String>();
        udhrArt27.add(getResources().getString(R.string.art27Par1UDHR));
        udhrArt27.add(getResources().getString(R.string.art27Par2UDHR));

        List<String> udhrArt28 = new ArrayList<String>();
        udhrArt28.add(getResources().getString(R.string.art28Par1UDHR));

        List<String> udhrArt29 = new ArrayList<String>();
        udhrArt29.add(getResources().getString(R.string.art29Par1UDHR));
        udhrArt29.add(getResources().getString(R.string.art29Par2UDHR));
        udhrArt29.add(getResources().getString(R.string.art29Par3UDHR));

        List<String> udhrArt30 = new ArrayList<String>();
        udhrArt30.add(getResources().getString(R.string.art30Par1UDHR));
        /* End define children */

        /* Adds children to appropriate header */
        listDataChild.put(listDataHeader.get(0),udhrPreamble);
        listDataChild.put(listDataHeader.get(1), udhrArt1);
        listDataChild.put(listDataHeader.get(2), udhrArt2);
        listDataChild.put(listDataHeader.get(3), udhrArt3);
        listDataChild.put(listDataHeader.get(4), udhrArt4);
        listDataChild.put(listDataHeader.get(5), udhrArt5);
        listDataChild.put(listDataHeader.get(6), udhrArt6);
        listDataChild.put(listDataHeader.get(7), udhrArt7);
        listDataChild.put(listDataHeader.get(8), udhrArt8);
        listDataChild.put(listDataHeader.get(9), udhrArt9);
        listDataChild.put(listDataHeader.get(10), udhrArt10);
        listDataChild.put(listDataHeader.get(11), udhrArt11);
        listDataChild.put(listDataHeader.get(12), udhrArt12);
        listDataChild.put(listDataHeader.get(13), udhrArt13);
        listDataChild.put(listDataHeader.get(14), udhrArt14);
        listDataChild.put(listDataHeader.get(15), udhrArt15);
        listDataChild.put(listDataHeader.get(16), udhrArt16);
        listDataChild.put(listDataHeader.get(17), udhrArt17);
        listDataChild.put(listDataHeader.get(18), udhrArt18);
        listDataChild.put(listDataHeader.get(19), udhrArt19);
        listDataChild.put(listDataHeader.get(20), udhrArt20);
        listDataChild.put(listDataHeader.get(21), udhrArt21);
        listDataChild.put(listDataHeader.get(22), udhrArt22);
        listDataChild.put(listDataHeader.get(23), udhrArt23);
        listDataChild.put(listDataHeader.get(24), udhrArt24);
        listDataChild.put(listDataHeader.get(25), udhrArt25);
        listDataChild.put(listDataHeader.get(26), udhrArt26);
        listDataChild.put(listDataHeader.get(27), udhrArt27);
        listDataChild.put(listDataHeader.get(28), udhrArt28);
        listDataChild.put(listDataHeader.get(29), udhrArt29);
        listDataChild.put(listDataHeader.get(30), udhrArt30);

    }
}