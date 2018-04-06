package e.chris.sherlocktravelhelper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class documentsConstitution extends AppCompatActivity {

    /* Reason for this document: I believe everyone in the US should have a copy available, this gives them one.
        This also gives aliens who are visiting the US a copy of the constitution should they need one */

    /* Declarations */
    expandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.constitution);
        /* Associate with layout IDs */
        expListView = (ExpandableListView) findViewById(R.id.constitution);

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

    /* Prepares all of the Constitution to be displayed in an expandable list */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        /* Adds headers */
        listDataHeader.add(getResources().getString(R.string.preambleHeading));
        listDataHeader.add(getResources().getString(R.string.art1sec1Heading));
        listDataHeader.add(getResources().getString(R.string.art1sec2Heading));
        listDataHeader.add(getResources().getString(R.string.art1sec3Heading));
        listDataHeader.add(getResources().getString(R.string.art1sec4Heading));
        listDataHeader.add(getResources().getString(R.string.art1sec5Heading));
        listDataHeader.add(getResources().getString(R.string.art1sec6Heading));
        listDataHeader.add(getResources().getString(R.string.art1sec7Heading));
        listDataHeader.add(getResources().getString(R.string.art1sec8Heading));
        listDataHeader.add(getResources().getString(R.string.art1sec9Heading));
        listDataHeader.add(getResources().getString(R.string.art1sec10Heading));
        listDataHeader.add(getResources().getString(R.string.art2sec1Heading));
        listDataHeader.add(getResources().getString(R.string.art2sec2Heading));
        listDataHeader.add(getResources().getString(R.string.art2sec3Heading));
        listDataHeader.add(getResources().getString(R.string.art2sec4Heading));
        listDataHeader.add(getResources().getString(R.string.art3sec1Heading));
        listDataHeader.add(getResources().getString(R.string.art3sec2Heading));
        listDataHeader.add(getResources().getString(R.string.art3sec3Heading));
        listDataHeader.add(getResources().getString(R.string.art4sec1Heading));
        listDataHeader.add(getResources().getString(R.string.art4sec2Heading));
        listDataHeader.add(getResources().getString(R.string.art4sec3Heading));
        listDataHeader.add(getResources().getString(R.string.art4sec4Heading));
        listDataHeader.add(getResources().getString(R.string.art5Heading));
        listDataHeader.add(getResources().getString(R.string.art6Heading));
        listDataHeader.add(getResources().getString(R.string.art7Heading));
        listDataHeader.add(getResources().getString(R.string.signersHeading));
        listDataHeader.add(getResources().getString(R.string.amend1Heading));
        listDataHeader.add(getResources().getString(R.string.amend2Heading));
        listDataHeader.add(getResources().getString(R.string.amend3Heading));
        listDataHeader.add(getResources().getString(R.string.amend4Heading));
        listDataHeader.add(getResources().getString(R.string.amend5Heading));
        listDataHeader.add(getResources().getString(R.string.amend6Heading));
        listDataHeader.add(getResources().getString(R.string.amend7Heading));
        listDataHeader.add(getResources().getString(R.string.amend8Heading));
        listDataHeader.add(getResources().getString(R.string.amend9Heading));
        listDataHeader.add(getResources().getString(R.string.amend10Heading));
        listDataHeader.add(getResources().getString(R.string.amend11Heading));
        listDataHeader.add(getResources().getString(R.string.amend12Heading));
        listDataHeader.add(getResources().getString(R.string.amend13Heading));
        listDataHeader.add(getResources().getString(R.string.amend14Heading));
        listDataHeader.add(getResources().getString(R.string.amend15Heading));
        listDataHeader.add(getResources().getString(R.string.amend16Heading));
        listDataHeader.add(getResources().getString(R.string.amend17Heading));
        listDataHeader.add(getResources().getString(R.string.amend18Heading));
        listDataHeader.add(getResources().getString(R.string.amend19Heading));
        listDataHeader.add(getResources().getString(R.string.amend20Heading));
        listDataHeader.add(getResources().getString(R.string.amend21Heading));
        listDataHeader.add(getResources().getString(R.string.amend22Heading));
        listDataHeader.add(getResources().getString(R.string.amend23Heading));
        listDataHeader.add(getResources().getString(R.string.amend24Heading));
        listDataHeader.add(getResources().getString(R.string.amend25Heading));
        listDataHeader.add(getResources().getString(R.string.amend26Heading));
        listDataHeader.add(getResources().getString(R.string.amend27Heading));

        /* Start define children */
        List<String> preamble = new ArrayList<String>();
        preamble.add(getResources().getString(R.string.preamblePar1));

        List<String> art1sec1 = new ArrayList<String>();
        art1sec1.add(getResources().getString(R.string.art1sec1Par1));

        List<String> art1sec2 = new ArrayList<String>();
        art1sec2.add(getResources().getString(R.string.art1sec2Par1));
        art1sec2.add(getResources().getString(R.string.art1sec2Par2));
        art1sec2.add(getResources().getString(R.string.art1sec2Par3));
        art1sec2.add(getResources().getString(R.string.art1sec2Par4));
        art1sec2.add(getResources().getString(R.string.art1sec2Par5));

        List<String> art1sec3 = new ArrayList<String>();
        art1sec3.add(getResources().getString(R.string.art1sec3Par1));
        art1sec3.add(getResources().getString(R.string.art1sec3Par2));
        art1sec3.add(getResources().getString(R.string.art1sec3Par3));
        art1sec3.add(getResources().getString(R.string.art1sec3Par4));
        art1sec3.add(getResources().getString(R.string.art1sec3Par5));
        art1sec3.add(getResources().getString(R.string.art1sec3Par6));
        art1sec3.add(getResources().getString(R.string.art1sec3Par7));

        List<String> art1sec4 = new ArrayList<String>();
        art1sec4.add(getResources().getString(R.string.art1sec4Par1));
        art1sec4.add(getResources().getString(R.string.art1sec4Par2));

        List<String> art1sec5 = new ArrayList<String>();
        art1sec5.add(getResources().getString(R.string.art1sec5Par1));
        art1sec5.add(getResources().getString(R.string.art1sec5Par2));
        art1sec5.add(getResources().getString(R.string.art1sec5Par3));
        art1sec5.add(getResources().getString(R.string.art1sec5Par4));

        List<String> art1sec6 = new ArrayList<String>();
        art1sec6.add(getResources().getString(R.string.art1sec6Par1));
        art1sec6.add(getResources().getString(R.string.art1sec6Par2));

        List<String> art1sec7 = new ArrayList<String>();
        art1sec7.add(getResources().getString(R.string.art1sec7Par1));
        art1sec7.add(getResources().getString(R.string.art1sec7Par2));
        art1sec7.add(getResources().getString(R.string.art1sec7Par3));

        List<String> art1sec8 = new ArrayList<String>();
        art1sec8.add(getResources().getString(R.string.art1sec8Par1));
        art1sec8.add(getResources().getString(R.string.art1sec8Par2));
        art1sec8.add(getResources().getString(R.string.art1sec8Par3));
        art1sec8.add(getResources().getString(R.string.art1sec8Par4));
        art1sec8.add(getResources().getString(R.string.art1sec8Par5));
        art1sec8.add(getResources().getString(R.string.art1sec8Par6));
        art1sec8.add(getResources().getString(R.string.art1sec8Par7));
        art1sec8.add(getResources().getString(R.string.art1sec8Par8));
        art1sec8.add(getResources().getString(R.string.art1sec8Par9));
        art1sec8.add(getResources().getString(R.string.art1sec8Par10));
        art1sec8.add(getResources().getString(R.string.art1sec8Par11));
        art1sec8.add(getResources().getString(R.string.art1sec8Par12));
        art1sec8.add(getResources().getString(R.string.art1sec8Par13));
        art1sec8.add(getResources().getString(R.string.art1sec8Par14));
        art1sec8.add(getResources().getString(R.string.art1sec8Par15));
        art1sec8.add(getResources().getString(R.string.art1sec8Par16));
        art1sec8.add(getResources().getString(R.string.art1sec8Par17));
        art1sec8.add(getResources().getString(R.string.art1sec8Par18));

        List<String> art1sec9 = new ArrayList<String>();
        art1sec9.add(getResources().getString(R.string.art1sec9Par1));
        art1sec9.add(getResources().getString(R.string.art1sec9Par2));
        art1sec9.add(getResources().getString(R.string.art1sec9Par3));
        art1sec9.add(getResources().getString(R.string.art1sec9Par4));
        art1sec9.add(getResources().getString(R.string.art1sec9Par5));
        art1sec9.add(getResources().getString(R.string.art1sec9Par6));
        art1sec9.add(getResources().getString(R.string.art1sec9Par7));
        art1sec9.add(getResources().getString(R.string.art1sec9Par8));

        List<String> art1sec10 = new ArrayList<String>();
        art1sec10.add(getResources().getString(R.string.art1sec10Par1));
        art1sec10.add(getResources().getString(R.string.art1sec10Par2));
        art1sec10.add(getResources().getString(R.string.art1sec10Par3));

        List<String> art2sec1 = new ArrayList<String>();
        art2sec1.add(getResources().getString(R.string.art2sec1Par1));
        art2sec1.add(getResources().getString(R.string.art2sec1Par2));
        art2sec1.add(getResources().getString(R.string.art2sec1Par3));
        art2sec1.add(getResources().getString(R.string.art2sec1Par4));
        art2sec1.add(getResources().getString(R.string.art2sec1Par5));
        art2sec1.add(getResources().getString(R.string.art2sec1Par6));
        art2sec1.add(getResources().getString(R.string.art2sec1Par7));
        art2sec1.add(getResources().getString(R.string.art2sec1Par8));

        List<String> art2sec2 = new ArrayList<String>();
        art2sec2.add(getResources().getString(R.string.art2sec2Par1));
        art2sec2.add(getResources().getString(R.string.art2sec2Par2));
        art2sec2.add(getResources().getString(R.string.art2sec2Par3));

        List<String> art2sec3 = new ArrayList<String>();
        art2sec3.add(getResources().getString(R.string.art2sec3Par1));

        List<String> art2sec4 = new ArrayList<String>();
        art2sec4.add(getResources().getString(R.string.art2sec4Par1));

        List<String> art3sec1 = new ArrayList<String>();
        art3sec1.add(getResources().getString(R.string.art3sec1Par1));

        List<String> art3sec2 = new ArrayList<String>();
        art3sec2.add(getResources().getString(R.string.art3sec2Par1));
        art3sec2.add(getResources().getString(R.string.art3sec2Par2));
        art3sec2.add(getResources().getString(R.string.art3sec2Par3));

        List<String> art3sec3 = new ArrayList<String>();
        art3sec3.add(getResources().getString(R.string.art3sec3Par1));
        art3sec3.add(getResources().getString(R.string.art3sec3Par2));

        List<String> art4sec1 = new ArrayList<String>();
        art4sec1.add(getResources().getString(R.string.art4sec1Par1));

        List<String> art4sec2 = new ArrayList<String>();
        art4sec2.add(getResources().getString(R.string.art4sec2Par1));
        art4sec2.add(getResources().getString(R.string.art4sec2Par2));
        art4sec2.add(getResources().getString(R.string.art4sec2Par3));

        List<String> art4sec3 = new ArrayList<String>();
        art4sec3.add(getResources().getString(R.string.art4sec3Par1));
        art4sec3.add(getResources().getString(R.string.art4sec3Par2));

        List<String> art4sec4 = new ArrayList<String>();
        art4sec4.add(getResources().getString(R.string.art4sec4Par1));

        List<String> art5 = new ArrayList<String>();
        art5.add(getResources().getString(R.string.art5Par1));

        List<String> art6 = new ArrayList<String>();
        art6.add(getResources().getString(R.string.art6Par1));
        art6.add(getResources().getString(R.string.art6Par2));
        art6.add(getResources().getString(R.string.art6Par3));

        List<String> art7 = new ArrayList<String>();
        art7.add(getResources().getString(R.string.art7Par1));

        List<String> signers = new ArrayList<String>();
        signers.add(getResources().getString(R.string.signersPar1));
        signers.add(getResources().getString(R.string.signersPar2));
        signers.add(getResources().getString(R.string.signersPar3));
        signers.add(getResources().getString(R.string.signersPar4));
        signers.add(getResources().getString(R.string.signersPar5));
        signers.add(getResources().getString(R.string.signersPar6));
        signers.add(getResources().getString(R.string.signersPar7));
        signers.add(getResources().getString(R.string.signersPar8));
        signers.add(getResources().getString(R.string.signersPar9));
        signers.add(getResources().getString(R.string.signersPar10));
        signers.add(getResources().getString(R.string.signersPar11));
        signers.add(getResources().getString(R.string.signersPar12));
        signers.add(getResources().getString(R.string.signersPar13));
        signers.add(getResources().getString(R.string.signersPar14));
        signers.add(getResources().getString(R.string.signersPar15));

        List<String> amend1 = new ArrayList<String>();
        amend1.add(getResources().getString(R.string.amend1Par1));

        List<String> amend2 = new ArrayList<String>();
        amend2.add(getResources().getString(R.string.amend2Par1));

        List<String> amend3 = new ArrayList<String>();
        amend3.add(getResources().getString(R.string.amend3Par1));

        List<String> amend4 = new ArrayList<String>();
        amend4.add(getResources().getString(R.string.amend4Par1));

        List<String> amend5 = new ArrayList<String>();
        amend5.add(getResources().getString(R.string.amend5Par1));

        List<String> amend6 = new ArrayList<String>();
        amend6.add(getResources().getString(R.string.amend6Par1));

        List<String> amend7 = new ArrayList<String>();
        amend7.add(getResources().getString(R.string.amend7Par1));

        List<String> amend8 = new ArrayList<String>();
        amend8.add(getResources().getString(R.string.amend8Par1));

        List<String> amend9 = new ArrayList<String>();
        amend9.add(getResources().getString(R.string.amend9Par1));

        List<String> amend10 = new ArrayList<String>();
        amend10.add(getResources().getString(R.string.amend10Par1));

        List<String> amend11 = new ArrayList<String>();
        amend11.add(getResources().getString(R.string.amend11Par1));

        List<String> amend12 = new ArrayList<String>();
        amend12.add(getResources().getString(R.string.amend12Par1));

        List<String> amend13 = new ArrayList<String>();
        amend13.add(getResources().getString(R.string.amend13Par1));
        amend13.add(getResources().getString(R.string.amend13Par2));

        List<String> amend14 = new ArrayList<String>();
        amend14.add(getResources().getString(R.string.amend14Par1));
        amend14.add(getResources().getString(R.string.amend14Par2));
        amend14.add(getResources().getString(R.string.amend14Par3));
        amend14.add(getResources().getString(R.string.amend14Par4));
        amend14.add(getResources().getString(R.string.amend14Par5));

        List<String> amend15 = new ArrayList<String>();
        amend15.add(getResources().getString(R.string.amend15Par1));
        amend15.add(getResources().getString(R.string.amend15Par2));

        List<String> amend16 = new ArrayList<String>();
        amend16.add(getResources().getString(R.string.amend16Par1));

        List<String> amend17 = new ArrayList<String>();
        amend17.add(getResources().getString(R.string.amend17Par1));
        amend17.add(getResources().getString(R.string.amend17Par2));
        amend17.add(getResources().getString(R.string.amend17Par3));

        List<String> amend18 = new ArrayList<String>();
        amend18.add(getResources().getString(R.string.amend18Par1));
        amend18.add(getResources().getString(R.string.amend18Par2));
        amend18.add(getResources().getString(R.string.amend18Par3));

        List<String> amend19 = new ArrayList<String>();
        amend19.add(getResources().getString(R.string.amend19Par1));
        amend19.add(getResources().getString(R.string.amend19Par2));

        List<String> amend20 = new ArrayList<String>();
        amend20.add(getResources().getString(R.string.amend20Par1));
        amend20.add(getResources().getString(R.string.amend20Par2));
        amend20.add(getResources().getString(R.string.amend20Par3));
        amend20.add(getResources().getString(R.string.amend20Par4));
        amend20.add(getResources().getString(R.string.amend20Par5));
        amend20.add(getResources().getString(R.string.amend20Par6));

        List<String> amend21 = new ArrayList<String>();
        amend21.add(getResources().getString(R.string.amend21Par1));
        amend21.add(getResources().getString(R.string.amend21Par2));
        amend21.add(getResources().getString(R.string.amend21Par3));

        List<String> amend22 = new ArrayList<String>();
        amend22.add(getResources().getString(R.string.amend22Par1));
        amend22.add(getResources().getString(R.string.amend22Par2));

        List<String> amend23 = new ArrayList<String>();
        amend23.add(getResources().getString(R.string.amend23Par1));
        amend23.add(getResources().getString(R.string.amend23Par2));
        amend23.add(getResources().getString(R.string.amend23Par3));

        List<String> amend24 = new ArrayList<String>();
        amend24.add(getResources().getString(R.string.amend24Par1));
        amend24.add(getResources().getString(R.string.amend24Par2));

        List<String> amend25 = new ArrayList<String>();
        amend25.add(getResources().getString(R.string.amend25Par1));
        amend25.add(getResources().getString(R.string.amend25Par2));
        amend25.add(getResources().getString(R.string.amend25Par3));
        amend25.add(getResources().getString(R.string.amend25Par4));
        amend25.add(getResources().getString(R.string.amend25Par5));

        List<String> amend26 = new ArrayList<String>();
        amend26.add(getResources().getString(R.string.amend26Par1));
        amend26.add(getResources().getString(R.string.amend26Par2));

        List<String> amend27 = new ArrayList<String>();
        amend27.add(getResources().getString(R.string.amend27Par1));
        /* End define children */

        /* Adds children to appropriate header */
        listDataChild.put(listDataHeader.get(0),preamble);
        listDataChild.put(listDataHeader.get(1), art1sec1);
        listDataChild.put(listDataHeader.get(2), art1sec2);
        listDataChild.put(listDataHeader.get(3), art1sec3);
        listDataChild.put(listDataHeader.get(4), art1sec4);
        listDataChild.put(listDataHeader.get(5), art1sec5);
        listDataChild.put(listDataHeader.get(6), art1sec6);
        listDataChild.put(listDataHeader.get(7), art1sec7);
        listDataChild.put(listDataHeader.get(8), art1sec8);
        listDataChild.put(listDataHeader.get(9), art1sec9);
        listDataChild.put(listDataHeader.get(10), art1sec10);
        listDataChild.put(listDataHeader.get(11), art2sec1);
        listDataChild.put(listDataHeader.get(12), art2sec2);
        listDataChild.put(listDataHeader.get(13), art2sec3);
        listDataChild.put(listDataHeader.get(14), art2sec4);
        listDataChild.put(listDataHeader.get(15), art3sec1);
        listDataChild.put(listDataHeader.get(16), art3sec2);
        listDataChild.put(listDataHeader.get(17), art3sec3);
        listDataChild.put(listDataHeader.get(18), art4sec1);
        listDataChild.put(listDataHeader.get(19), art4sec2);
        listDataChild.put(listDataHeader.get(20), art4sec3);
        listDataChild.put(listDataHeader.get(21), art4sec4);
        listDataChild.put(listDataHeader.get(22), art5);
        listDataChild.put(listDataHeader.get(23), art6);
        listDataChild.put(listDataHeader.get(24), art7);
        listDataChild.put(listDataHeader.get(25), signers);
        listDataChild.put(listDataHeader.get(26), amend1);
        listDataChild.put(listDataHeader.get(27), amend2);
        listDataChild.put(listDataHeader.get(28), amend3);
        listDataChild.put(listDataHeader.get(29), amend4);
        listDataChild.put(listDataHeader.get(30), amend5);
        listDataChild.put(listDataHeader.get(31), amend6);
        listDataChild.put(listDataHeader.get(32), amend7);
        listDataChild.put(listDataHeader.get(33), amend8);
        listDataChild.put(listDataHeader.get(34), amend9);
        listDataChild.put(listDataHeader.get(35), amend10);
        listDataChild.put(listDataHeader.get(36), amend11);
        listDataChild.put(listDataHeader.get(37), amend12);
        listDataChild.put(listDataHeader.get(38), amend13);
        listDataChild.put(listDataHeader.get(39), amend14);
        listDataChild.put(listDataHeader.get(40), amend15);
        listDataChild.put(listDataHeader.get(41), amend16);
        listDataChild.put(listDataHeader.get(42), amend17);
        listDataChild.put(listDataHeader.get(43), amend18);
        listDataChild.put(listDataHeader.get(44), amend19);
        listDataChild.put(listDataHeader.get(45), amend20);
        listDataChild.put(listDataHeader.get(46), amend21);
        listDataChild.put(listDataHeader.get(47), amend22);
        listDataChild.put(listDataHeader.get(48), amend23);
        listDataChild.put(listDataHeader.get(49), amend24);
        listDataChild.put(listDataHeader.get(50), amend25);
        listDataChild.put(listDataHeader.get(51), amend26);
        listDataChild.put(listDataHeader.get(52), amend27);
    }
}