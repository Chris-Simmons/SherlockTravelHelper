package e.chris.sherlocktravelhelper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class documentsVCCR extends AppCompatActivity {

    /* Reason for this document: While the majority of the document is not important for most people,
        Article 36 states that if a traveler is arrested in another country, the arresting country has
        to notify the traveler's consulate of their arrest should the traveler choose. This is extremely
        important, but it is not widely known that people have this right. This allows access to that
        information if they choose to read it. It also fulfills a human rights interest for me in giving
        people this information through this app. I include the rest of the document for completions sake. */

    /* Declarations */
    expandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vccr);
        /* Associate with layout IDs */
        expListView = (ExpandableListView) findViewById(R.id.vccr);

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

    /* Prepares all of the VCCR to be displayed in an expandable list */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        /* Adds headers */
        listDataHeader.add(getResources().getString(R.string.art36HeadingTopVCCR));
        listDataHeader.add(getResources().getString(R.string.preambleHeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art1HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art2HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art3HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art4HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art5HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art6HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art7HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art8HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art9HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art10HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art11HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art12HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art13HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art14HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art15HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art16HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art17HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art18HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art19HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art20HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art21HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art22HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art23HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art24HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art25HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art26HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art27HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art28HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art29HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art30HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art31HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art32HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art33HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art34HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art35HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art36HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art37HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art38HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art39HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art40HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art41HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art42HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art43HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art44HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art45HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art46HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art47HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art48HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art49HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art50HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art51HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art52HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art53HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art54HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art55HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art56HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art57HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art58HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art59HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art60HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art61HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art62HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art63HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art64HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art65HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art66HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art67HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art68HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art69HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art70HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art71HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art72HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art73HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art74HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art75HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art76HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art77HeadingVCCR));
        listDataHeader.add(getResources().getString(R.string.art78HeadingVCCR));

        /* Start define children */
        List<String> vccrTravel = new ArrayList<String>();
        vccrTravel.add(getResources().getString(R.string.art36Par1VCCR));
        vccrTravel.add(getResources().getString(R.string.art36Par2VCCR));
        vccrTravel.add(getResources().getString(R.string.art36Par3VCCR));
        vccrTravel.add(getResources().getString(R.string.art36Par4VCCR));
        vccrTravel.add(getResources().getString(R.string.art36Par5VCCR));
        vccrTravel.add(getResources().getString(R.string.art36Par6VCCR));

        List<String> vccrPreamble = new ArrayList<String>();
        vccrPreamble.add(getResources().getString(R.string.preamablePar1VCCR));
        vccrPreamble.add(getResources().getString(R.string.preamablePar2VCCR));
        vccrPreamble.add(getResources().getString(R.string.preamablePar3VCCR));
        vccrPreamble.add(getResources().getString(R.string.preamablePar4VCCR));
        vccrPreamble.add(getResources().getString(R.string.preamablePar5VCCR));
        vccrPreamble.add(getResources().getString(R.string.preamablePar6VCCR));
        vccrPreamble.add(getResources().getString(R.string.preamablePar7VCCR));
        vccrPreamble.add(getResources().getString(R.string.preamablePar8VCCR));

        List<String> vccrArt1 = new ArrayList<String>();
        vccrArt1.add(getResources().getString(R.string.art1Par1VCCR));
        vccrArt1.add(getResources().getString(R.string.art1Par2VCCR));
        vccrArt1.add(getResources().getString(R.string.art1Par3VCCR));
        vccrArt1.add(getResources().getString(R.string.art1Par4VCCR));
        vccrArt1.add(getResources().getString(R.string.art1Par5VCCR));
        vccrArt1.add(getResources().getString(R.string.art1Par6VCCR));
        vccrArt1.add(getResources().getString(R.string.art1Par7VCCR));
        vccrArt1.add(getResources().getString(R.string.art1Par8VCCR));
        vccrArt1.add(getResources().getString(R.string.art1Par9VCCR));
        vccrArt1.add(getResources().getString(R.string.art1Par10VCCR));
        vccrArt1.add(getResources().getString(R.string.art1Par11VCCR));
        vccrArt1.add(getResources().getString(R.string.art1Par12VCCR));
        vccrArt1.add(getResources().getString(R.string.art1Par13VCCR));
        vccrArt1.add(getResources().getString(R.string.art1Par14VCCR));
        vccrArt1.add(getResources().getString(R.string.art1Par15VCCR));

        List<String> vccrArt2 = new ArrayList<String>();
        vccrArt2.add(getResources().getString(R.string.art2Par1VCCR));
        vccrArt2.add(getResources().getString(R.string.art2Par2VCCR));
        vccrArt2.add(getResources().getString(R.string.art2Par3VCCR));

        List<String> vccrArt3 = new ArrayList<String>();
        vccrArt3.add(getResources().getString(R.string.art3Par1VCCR));
        vccrArt3.add(getResources().getString(R.string.art3Par2VCCR));

        List<String> vccrArt4 = new ArrayList<String>();
        vccrArt4.add(getResources().getString(R.string.art4Par1VCCR));
        vccrArt4.add(getResources().getString(R.string.art4Par2VCCR));
        vccrArt4.add(getResources().getString(R.string.art4Par3VCCR));
        vccrArt4.add(getResources().getString(R.string.art4Par4VCCR));
        vccrArt4.add(getResources().getString(R.string.art4Par5VCCR));
        vccrArt4.add(getResources().getString(R.string.art4Par6VCCR));

        List<String> vccrArt5 = new ArrayList<String>();
        vccrArt5.add(getResources().getString(R.string.art5Par1VCCR));
        vccrArt5.add(getResources().getString(R.string.art5Par2VCCR));
        vccrArt5.add(getResources().getString(R.string.art5Par3VCCR));
        vccrArt5.add(getResources().getString(R.string.art5Par4VCCR));
        vccrArt5.add(getResources().getString(R.string.art5Par5VCCR));
        vccrArt5.add(getResources().getString(R.string.art5Par6VCCR));
        vccrArt5.add(getResources().getString(R.string.art5Par7VCCR));
        vccrArt5.add(getResources().getString(R.string.art5Par8VCCR));
        vccrArt5.add(getResources().getString(R.string.art5Par9VCCR));
        vccrArt5.add(getResources().getString(R.string.art5Par10VCCR));
        vccrArt5.add(getResources().getString(R.string.art5Par11VCCR));
        vccrArt5.add(getResources().getString(R.string.art5Par12VCCR));
        vccrArt5.add(getResources().getString(R.string.art5Par13VCCR));
        vccrArt5.add(getResources().getString(R.string.art5Par14VCCR));
        vccrArt5.add(getResources().getString(R.string.art5Par15VCCR));

        List<String> vccrArt6 = new ArrayList<String>();
        vccrArt6.add(getResources().getString(R.string.art6Par1VCCR));
        vccrArt6.add(getResources().getString(R.string.art6Par2VCCR));

        List<String> vccrArt7 = new ArrayList<String>();
        vccrArt7.add(getResources().getString(R.string.art7Par1VCCR));
        vccrArt7.add(getResources().getString(R.string.art7Par2VCCR));

        List<String> vccrArt8 = new ArrayList<String>();
        vccrArt8.add(getResources().getString(R.string.art8Par1VCCR));
        vccrArt8.add(getResources().getString(R.string.art8Par2VCCR));

        List<String> vccrArt9 = new ArrayList<String>();
        vccrArt9.add(getResources().getString(R.string.art9Par1VCCR));
        vccrArt9.add(getResources().getString(R.string.art9Par2VCCR));
        vccrArt9.add(getResources().getString(R.string.art9Par3VCCR));
        vccrArt9.add(getResources().getString(R.string.art9Par4VCCR));
        vccrArt9.add(getResources().getString(R.string.art9Par5VCCR));
        vccrArt9.add(getResources().getString(R.string.art9Par6VCCR));
        vccrArt9.add(getResources().getString(R.string.art9Par7VCCR));

        List<String> vccrArt10 = new ArrayList<String>();
        vccrArt10.add(getResources().getString(R.string.art10Par1VCCR));
        vccrArt10.add(getResources().getString(R.string.art10Par2VCCR));
        vccrArt10.add(getResources().getString(R.string.art10Par3VCCR));

        List<String> vccrArt11 = new ArrayList<String>();
        vccrArt11.add(getResources().getString(R.string.art11Par1VCCR));
        vccrArt11.add(getResources().getString(R.string.art11Par2VCCR));
        vccrArt11.add(getResources().getString(R.string.art11Par3VCCR));
        vccrArt11.add(getResources().getString(R.string.art11Par4VCCR));

        List<String> vccrArt12 = new ArrayList<String>();
        vccrArt12.add(getResources().getString(R.string.art12Par1VCCR));
        vccrArt12.add(getResources().getString(R.string.art12Par2VCCR));
        vccrArt12.add(getResources().getString(R.string.art12Par3VCCR));
        vccrArt12.add(getResources().getString(R.string.art12Par4VCCR));

        List<String> vccrArt13 = new ArrayList<String>();
        vccrArt13.add(getResources().getString(R.string.art13Par1VCCR));
        vccrArt13.add(getResources().getString(R.string.art13Par2VCCR));

        List<String> vccrArt14 = new ArrayList<String>();
        vccrArt14.add(getResources().getString(R.string.art14Par1VCCR));
        vccrArt14.add(getResources().getString(R.string.art14Par2VCCR));

        List<String> vccrArt15 = new ArrayList<String>();
        vccrArt15.add(getResources().getString(R.string.art15Par1VCCR));
        vccrArt15.add(getResources().getString(R.string.art15Par2VCCR));
        vccrArt15.add(getResources().getString(R.string.art15Par3VCCR));
        vccrArt15.add(getResources().getString(R.string.art15Par4VCCR));
        vccrArt15.add(getResources().getString(R.string.art15Par5VCCR));

        List<String> vccrArt16 = new ArrayList<String>();
        vccrArt16.add(getResources().getString(R.string.art16Par1VCCR));
        vccrArt16.add(getResources().getString(R.string.art16Par2VCCR));
        vccrArt16.add(getResources().getString(R.string.art16Par3VCCR));
        vccrArt16.add(getResources().getString(R.string.art16Par4VCCR));
        vccrArt16.add(getResources().getString(R.string.art16Par5VCCR));
        vccrArt16.add(getResources().getString(R.string.art16Par6VCCR));
        vccrArt16.add(getResources().getString(R.string.art16Par7VCCR));

        List<String> vccrArt17 = new ArrayList<String>();
        vccrArt17.add(getResources().getString(R.string.art17Par1VCCR));
        vccrArt17.add(getResources().getString(R.string.art17Par2VCCR));
        vccrArt17.add(getResources().getString(R.string.art17Par3VCCR));

        List<String> vccrArt18 = new ArrayList<String>();
        vccrArt18.add(getResources().getString(R.string.art18Par1VCCR));
        vccrArt18.add(getResources().getString(R.string.art18Par2VCCR));

        List<String> vccrArt19 = new ArrayList<String>();
        vccrArt19.add(getResources().getString(R.string.art19Par1VCCR));
        vccrArt19.add(getResources().getString(R.string.art19Par2VCCR));
        vccrArt19.add(getResources().getString(R.string.art19Par3VCCR));
        vccrArt19.add(getResources().getString(R.string.art19Par4VCCR));
        vccrArt19.add(getResources().getString(R.string.art19Par5VCCR));

        List<String> vccrArt20 = new ArrayList<String>();
        vccrArt20.add(getResources().getString(R.string.art20Par1VCCR));
        vccrArt20.add(getResources().getString(R.string.art20Par2VCCR));

        List<String> vccrArt21 = new ArrayList<String>();
        vccrArt21.add(getResources().getString(R.string.art21Par1VCCR));
        vccrArt21.add(getResources().getString(R.string.art21Par2VCCR));

        List<String> vccrArt22 = new ArrayList<String>();
        vccrArt22.add(getResources().getString(R.string.art22Par1VCCR));
        vccrArt22.add(getResources().getString(R.string.art22Par2VCCR));
        vccrArt22.add(getResources().getString(R.string.art22Par3VCCR));
        vccrArt22.add(getResources().getString(R.string.art22Par4VCCR));

        List<String> vccrArt23 = new ArrayList<String>();
        vccrArt23.add(getResources().getString(R.string.art23Par1VCCR));
        vccrArt23.add(getResources().getString(R.string.art23Par2VCCR));
        vccrArt23.add(getResources().getString(R.string.art23Par3VCCR));
        vccrArt23.add(getResources().getString(R.string.art23Par4VCCR));
        vccrArt23.add(getResources().getString(R.string.art23Par5VCCR));

        List<String> vccrArt24 = new ArrayList<String>();
        vccrArt24.add(getResources().getString(R.string.art24Par1VCCR));
        vccrArt24.add(getResources().getString(R.string.art24Par2VCCR));
        vccrArt24.add(getResources().getString(R.string.art24Par3VCCR));
        vccrArt24.add(getResources().getString(R.string.art24Par4VCCR));
        vccrArt24.add(getResources().getString(R.string.art24Par5VCCR));
        vccrArt24.add(getResources().getString(R.string.art24Par6VCCR));
        vccrArt24.add(getResources().getString(R.string.art24Par7VCCR));

        List<String> vccrArt25 = new ArrayList<String>();
        vccrArt25.add(getResources().getString(R.string.art25Par1VCCR));
        vccrArt25.add(getResources().getString(R.string.art25Par2VCCR));
        vccrArt25.add(getResources().getString(R.string.art25Par3VCCR));
        vccrArt25.add(getResources().getString(R.string.art25Par4VCCR));
        vccrArt25.add(getResources().getString(R.string.art25Par5VCCR));

        List<String> vccrArt26 = new ArrayList<String>();
        vccrArt26.add(getResources().getString(R.string.art26Par1VCCR));
        vccrArt26.add(getResources().getString(R.string.art26Par2VCCR));

        List<String> vccrArt27 = new ArrayList<String>();
        vccrArt27.add(getResources().getString(R.string.art27Par1VCCR));
        vccrArt27.add(getResources().getString(R.string.art27Par2VCCR));
        vccrArt27.add(getResources().getString(R.string.art27Par3VCCR));
        vccrArt27.add(getResources().getString(R.string.art27Par4VCCR));
        vccrArt27.add(getResources().getString(R.string.art27Par5VCCR));
        vccrArt27.add(getResources().getString(R.string.art27Par6VCCR));
        vccrArt27.add(getResources().getString(R.string.art27Par7VCCR));
        vccrArt27.add(getResources().getString(R.string.art27Par8VCCR));

        List<String> vccrArt28 = new ArrayList<String>();
        vccrArt28.add(getResources().getString(R.string.art28Par1VCCR));
        vccrArt28.add(getResources().getString(R.string.art28Par2VCCR));

        List<String> vccrArt29 = new ArrayList<String>();
        vccrArt29.add(getResources().getString(R.string.art29Par1VCCR));
        vccrArt29.add(getResources().getString(R.string.art29Par2VCCR));
        vccrArt29.add(getResources().getString(R.string.art29Par3VCCR));
        vccrArt29.add(getResources().getString(R.string.art29Par4VCCR));

        List<String> vccrArt30 = new ArrayList<String>();
        vccrArt30.add(getResources().getString(R.string.art30Par1VCCR));
        vccrArt30.add(getResources().getString(R.string.art30Par2VCCR));
        vccrArt30.add(getResources().getString(R.string.art30Par3VCCR));

        List<String> vccrArt31 = new ArrayList<String>();
        vccrArt31.add(getResources().getString(R.string.art31Par1VCCR));
        vccrArt31.add(getResources().getString(R.string.art31Par2VCCR));
        vccrArt31.add(getResources().getString(R.string.art31Par3VCCR));
        vccrArt31.add(getResources().getString(R.string.art31Par4VCCR));
        vccrArt31.add(getResources().getString(R.string.art31Par5VCCR));

        List<String> vccrArt32 = new ArrayList<String>();
        vccrArt32.add(getResources().getString(R.string.art32Par1VCCR));
        vccrArt32.add(getResources().getString(R.string.art32Par2VCCR));
        vccrArt32.add(getResources().getString(R.string.art32Par3VCCR));

        List<String> vccrArt33 = new ArrayList<String>();
        vccrArt33.add(getResources().getString(R.string.art33Par1VCCR));
        vccrArt33.add(getResources().getString(R.string.art33Par2VCCR));

        List<String> vccrArt34 = new ArrayList<String>();
        vccrArt34.add(getResources().getString(R.string.art34Par1VCCR));
        vccrArt34.add(getResources().getString(R.string.art34Par2VCCR));

        List<String> vccrArt35 = new ArrayList<String>();
        vccrArt35.add(getResources().getString(R.string.art35Par1VCCR));
        vccrArt35.add(getResources().getString(R.string.art35Par2VCCR));
        vccrArt35.add(getResources().getString(R.string.art35Par3VCCR));
        vccrArt35.add(getResources().getString(R.string.art35Par4VCCR));
        vccrArt35.add(getResources().getString(R.string.art35Par5VCCR));
        vccrArt35.add(getResources().getString(R.string.art35Par6VCCR));
        vccrArt35.add(getResources().getString(R.string.art35Par7VCCR));
        vccrArt35.add(getResources().getString(R.string.art35Par8VCCR));

        List<String> vccrArt36 = new ArrayList<String>();
        vccrArt36.add(getResources().getString(R.string.art36Par1VCCR));
        vccrArt36.add(getResources().getString(R.string.art36Par2VCCR));
        vccrArt36.add(getResources().getString(R.string.art36Par3VCCR));
        vccrArt36.add(getResources().getString(R.string.art36Par4VCCR));
        vccrArt36.add(getResources().getString(R.string.art36Par5VCCR));
        vccrArt36.add(getResources().getString(R.string.art36Par6VCCR));

        List<String> vccrArt37 = new ArrayList<String>();
        vccrArt37.add(getResources().getString(R.string.art37Par1VCCR));
        vccrArt37.add(getResources().getString(R.string.art37Par2VCCR));
        vccrArt37.add(getResources().getString(R.string.art37Par3VCCR));
        vccrArt37.add(getResources().getString(R.string.art37Par4VCCR));
        vccrArt37.add(getResources().getString(R.string.art37Par5VCCR));

        List<String> vccrArt38 = new ArrayList<String>();
        vccrArt38.add(getResources().getString(R.string.art38Par1VCCR));
        vccrArt38.add(getResources().getString(R.string.art38Par2VCCR));
        vccrArt38.add(getResources().getString(R.string.art38Par3VCCR));
        vccrArt38.add(getResources().getString(R.string.art38Par4VCCR));

        List<String> vccrArt39 = new ArrayList<String>();
        vccrArt39.add(getResources().getString(R.string.art39Par1VCCR));
        vccrArt39.add(getResources().getString(R.string.art39Par2VCCR));
        vccrArt39.add(getResources().getString(R.string.art39Par3VCCR));

        List<String> vccrArt40 = new ArrayList<String>();
        vccrArt40.add(getResources().getString(R.string.art40Par1VCCR));
        vccrArt40.add(getResources().getString(R.string.art40Par2VCCR));

        List<String> vccrArt41 = new ArrayList<String>();
        vccrArt41.add(getResources().getString(R.string.art41Par1VCCR));
        vccrArt41.add(getResources().getString(R.string.art41Par2VCCR));
        vccrArt41.add(getResources().getString(R.string.art41Par3VCCR));
        vccrArt41.add(getResources().getString(R.string.art41Par4VCCR));

        List<String> vccrArt42 = new ArrayList<String>();
        vccrArt42.add(getResources().getString(R.string.art42Par1VCCR));
        vccrArt42.add(getResources().getString(R.string.art42Par2VCCR));

        List<String> vccrArt43 = new ArrayList<String>();
        vccrArt43.add(getResources().getString(R.string.art43Par1VCCR));
        vccrArt43.add(getResources().getString(R.string.art43Par2VCCR));
        vccrArt43.add(getResources().getString(R.string.art43Par3VCCR));
        vccrArt43.add(getResources().getString(R.string.art43Par4VCCR));
        vccrArt43.add(getResources().getString(R.string.art43Par5VCCR));

        List<String> vccrArt44 = new ArrayList<String>();
        vccrArt44.add(getResources().getString(R.string.art44Par1VCCR));
        vccrArt44.add(getResources().getString(R.string.art44Par2VCCR));
        vccrArt44.add(getResources().getString(R.string.art44Par3VCCR));
        vccrArt44.add(getResources().getString(R.string.art44Par4VCCR));

        List<String> vccrArt45 = new ArrayList<String>();
        vccrArt45.add(getResources().getString(R.string.art45Par1VCCR));
        vccrArt45.add(getResources().getString(R.string.art45Par2VCCR));
        vccrArt45.add(getResources().getString(R.string.art45Par3VCCR));
        vccrArt45.add(getResources().getString(R.string.art45Par4VCCR));
        vccrArt45.add(getResources().getString(R.string.art45Par5VCCR));

        List<String> vccrArt46 = new ArrayList<String>();
        vccrArt46.add(getResources().getString(R.string.art46Par1VCCR));
        vccrArt46.add(getResources().getString(R.string.art46Par2VCCR));
        vccrArt46.add(getResources().getString(R.string.art46Par3VCCR));

        List<String> vccrArt47 = new ArrayList<String>();
        vccrArt47.add(getResources().getString(R.string.art47Par1VCCR));
        vccrArt47.add(getResources().getString(R.string.art47Par2VCCR));
        vccrArt47.add(getResources().getString(R.string.art47Par3VCCR));

        List<String> vccrArt48 = new ArrayList<String>();
        vccrArt48.add(getResources().getString(R.string.art48Par1VCCR));
        vccrArt48.add(getResources().getString(R.string.art48Par2VCCR));
        vccrArt48.add(getResources().getString(R.string.art48Par3VCCR));
        vccrArt48.add(getResources().getString(R.string.art48Par4VCCR));
        vccrArt48.add(getResources().getString(R.string.art48Par5VCCR));
        vccrArt48.add(getResources().getString(R.string.art48Par6VCCR));
        vccrArt48.add(getResources().getString(R.string.art48Par7VCCR));

        List<String> vccrArt49 = new ArrayList<String>();
        vccrArt49.add(getResources().getString(R.string.art49Par1VCCR));
        vccrArt49.add(getResources().getString(R.string.art49Par2VCCR));
        vccrArt49.add(getResources().getString(R.string.art49Par3VCCR));
        vccrArt49.add(getResources().getString(R.string.art49Par4VCCR));
        vccrArt49.add(getResources().getString(R.string.art49Par5VCCR));
        vccrArt49.add(getResources().getString(R.string.art49Par6VCCR));
        vccrArt49.add(getResources().getString(R.string.art49Par7VCCR));
        vccrArt49.add(getResources().getString(R.string.art49Par8VCCR));
        vccrArt49.add(getResources().getString(R.string.art49Par9VCCR));
        vccrArt49.add(getResources().getString(R.string.art49Par10VCCR));

        List<String> vccrArt50 = new ArrayList<String>();
        vccrArt50.add(getResources().getString(R.string.art50Par1VCCR));
        vccrArt50.add(getResources().getString(R.string.art50Par2VCCR));
        vccrArt50.add(getResources().getString(R.string.art50Par3VCCR));
        vccrArt50.add(getResources().getString(R.string.art50Par4VCCR));
        vccrArt50.add(getResources().getString(R.string.art50Par5VCCR));
        vccrArt50.add(getResources().getString(R.string.art50Par6VCCR));

        List<String> vccrArt51 = new ArrayList<String>();
        vccrArt51.add(getResources().getString(R.string.art51Par1VCCR));
        vccrArt51.add(getResources().getString(R.string.art51Par2VCCR));
        vccrArt51.add(getResources().getString(R.string.art51Par3VCCR));
        vccrArt51.add(getResources().getString(R.string.art51Par4VCCR));

        List<String> vccrArt52 = new ArrayList<String>();
        vccrArt52.add(getResources().getString(R.string.art52Par1VCCR));
        vccrArt52.add(getResources().getString(R.string.art52Par2VCCR));

        List<String> vccrArt53 = new ArrayList<String>();
        vccrArt53.add(getResources().getString(R.string.art53Par1VCCR));
        vccrArt53.add(getResources().getString(R.string.art53Par2VCCR));
        vccrArt53.add(getResources().getString(R.string.art53Par3VCCR));
        vccrArt53.add(getResources().getString(R.string.art53Par4VCCR));
        vccrArt53.add(getResources().getString(R.string.art53Par5VCCR));
        vccrArt53.add(getResources().getString(R.string.art53Par6VCCR));

        List<String> vccrArt54 = new ArrayList<String>();
        vccrArt54.add(getResources().getString(R.string.art54Par1VCCR));
        vccrArt54.add(getResources().getString(R.string.art54Par2VCCR));
        vccrArt54.add(getResources().getString(R.string.art54Par3VCCR));
        vccrArt54.add(getResources().getString(R.string.art54Par4VCCR));
        vccrArt54.add(getResources().getString(R.string.art54Par5VCCR));

        List<String> vccrArt55 = new ArrayList<String>();
        vccrArt55.add(getResources().getString(R.string.art55Par1VCCR));
        vccrArt55.add(getResources().getString(R.string.art55Par2VCCR));
        vccrArt55.add(getResources().getString(R.string.art55Par3VCCR));
        vccrArt55.add(getResources().getString(R.string.art55Par4VCCR));

        List<String> vccrArt56 = new ArrayList<String>();
        vccrArt56.add(getResources().getString(R.string.art56Par1VCCR));
        vccrArt56.add(getResources().getString(R.string.art56Par2VCCR));

        List<String> vccrArt57 = new ArrayList<String>();
        vccrArt57.add(getResources().getString(R.string.art57Par1VCCR));
        vccrArt57.add(getResources().getString(R.string.art57Par2VCCR));
        vccrArt57.add(getResources().getString(R.string.art57Par3VCCR));
        vccrArt57.add(getResources().getString(R.string.art57Par4VCCR));
        vccrArt57.add(getResources().getString(R.string.art57Par5VCCR));
        vccrArt57.add(getResources().getString(R.string.art57Par6VCCR));

        List<String> vccrArt58 = new ArrayList<String>();
        vccrArt58.add(getResources().getString(R.string.art58Par1VCCR));
        vccrArt58.add(getResources().getString(R.string.art58Par2VCCR));
        vccrArt58.add(getResources().getString(R.string.art58Par3VCCR));
        vccrArt58.add(getResources().getString(R.string.art58Par4VCCR));
        vccrArt58.add(getResources().getString(R.string.art58Par5VCCR));

        List<String> vccrArt59 = new ArrayList<String>();
        vccrArt59.add(getResources().getString(R.string.art59Par1VCCR));
        vccrArt59.add(getResources().getString(R.string.art59Par2VCCR));

        List<String> vccrArt60 = new ArrayList<String>();
        vccrArt60.add(getResources().getString(R.string.art60Par1VCCR));
        vccrArt60.add(getResources().getString(R.string.art60Par2VCCR));
        vccrArt60.add(getResources().getString(R.string.art60Par3VCCR));

        List<String> vccrArt61 = new ArrayList<String>();
        vccrArt61.add(getResources().getString(R.string.art61Par1VCCR));
        vccrArt61.add(getResources().getString(R.string.art61Par2VCCR));

        List<String> vccrArt62 = new ArrayList<String>();
        vccrArt62.add(getResources().getString(R.string.art62Par1VCCR));
        vccrArt62.add(getResources().getString(R.string.art62Par2VCCR));

        List<String> vccrArt63 = new ArrayList<String>();
        vccrArt63.add(getResources().getString(R.string.art63Par1VCCR));
        vccrArt63.add(getResources().getString(R.string.art63Par2VCCR));

        List<String> vccrArt64 = new ArrayList<String>();
        vccrArt64.add(getResources().getString(R.string.art64Par1VCCR));
        vccrArt64.add(getResources().getString(R.string.art64Par2VCCR));

        List<String> vccrArt65 = new ArrayList<String>();
        vccrArt65.add(getResources().getString(R.string.art65Par1VCCR));
        vccrArt65.add(getResources().getString(R.string.art65Par2VCCR));

        List<String> vccrArt66 = new ArrayList<String>();
        vccrArt66.add(getResources().getString(R.string.art66Par1VCCR));
        vccrArt66.add(getResources().getString(R.string.art66Par2VCCR));

        List<String> vccrArt67 = new ArrayList<String>();
        vccrArt67.add(getResources().getString(R.string.art67Par1VCCR));
        vccrArt67.add(getResources().getString(R.string.art67Par2VCCR));

        List<String> vccrArt68 = new ArrayList<String>();
        vccrArt68.add(getResources().getString(R.string.art68Par1VCCR));
        vccrArt68.add(getResources().getString(R.string.art68Par2VCCR));

        List<String> vccrArt69 = new ArrayList<String>();
        vccrArt69.add(getResources().getString(R.string.art69Par1VCCR));
        vccrArt69.add(getResources().getString(R.string.art69Par2VCCR));
        vccrArt69.add(getResources().getString(R.string.art69Par3VCCR));

        List<String> vccrArt70 = new ArrayList<String>();
        vccrArt70.add(getResources().getString(R.string.art70Par1VCCR));
        vccrArt70.add(getResources().getString(R.string.art70Par2VCCR));
        vccrArt70.add(getResources().getString(R.string.art70Par3VCCR));
        vccrArt70.add(getResources().getString(R.string.art70Par4VCCR));
        vccrArt70.add(getResources().getString(R.string.art70Par5VCCR));
        vccrArt70.add(getResources().getString(R.string.art70Par6VCCR));
        vccrArt70.add(getResources().getString(R.string.art70Par7VCCR));

        List<String> vccrArt71 = new ArrayList<String>();
        vccrArt71.add(getResources().getString(R.string.art71Par1VCCR));
        vccrArt71.add(getResources().getString(R.string.art71Par2VCCR));
        vccrArt71.add(getResources().getString(R.string.art71Par3VCCR));

        List<String> vccrArt72 = new ArrayList<String>();
        vccrArt72.add(getResources().getString(R.string.art72Par1VCCR));
        vccrArt72.add(getResources().getString(R.string.art72Par2VCCR));
        vccrArt72.add(getResources().getString(R.string.art72Par3VCCR));
        vccrArt72.add(getResources().getString(R.string.art72Par4VCCR));
        vccrArt72.add(getResources().getString(R.string.art72Par5VCCR));

        List<String> vccrArt73 = new ArrayList<String>();
        vccrArt73.add(getResources().getString(R.string.art73Par1VCCR));
        vccrArt73.add(getResources().getString(R.string.art73Par2VCCR));
        vccrArt73.add(getResources().getString(R.string.art73Par3VCCR));

        List<String> vccrArt74 = new ArrayList<String>();
        vccrArt74.add(getResources().getString(R.string.art74Par1VCCR));
        vccrArt74.add(getResources().getString(R.string.art74Par2VCCR));

        List<String> vccrArt75 = new ArrayList<String>();
        vccrArt75.add(getResources().getString(R.string.art75Par1VCCR));
        vccrArt75.add(getResources().getString(R.string.art75Par2VCCR));

        List<String> vccrArt76 = new ArrayList<String>();
        vccrArt76.add(getResources().getString(R.string.art76Par1VCCR));
        vccrArt76.add(getResources().getString(R.string.art76Par2VCCR));

        List<String> vccrArt77 = new ArrayList<String>();
        vccrArt77.add(getResources().getString(R.string.art77Par1VCCR));
        vccrArt77.add(getResources().getString(R.string.art77Par2VCCR));
        vccrArt77.add(getResources().getString(R.string.art77Par3VCCR));

        List<String> vccrArt78 = new ArrayList<String>();
        vccrArt78.add(getResources().getString(R.string.art78Par1VCCR));
        vccrArt78.add(getResources().getString(R.string.art78Par2VCCR));
        vccrArt78.add(getResources().getString(R.string.art78Par3VCCR));
        vccrArt78.add(getResources().getString(R.string.art78Par4VCCR));
        /* End define children */

        /* Adds children to appropriate header */
        listDataChild.put(listDataHeader.get(0), vccrTravel);
        listDataChild.put(listDataHeader.get(1), vccrPreamble);
        listDataChild.put(listDataHeader.get(2), vccrArt1);
        listDataChild.put(listDataHeader.get(3), vccrArt2);
        listDataChild.put(listDataHeader.get(4), vccrArt3);
        listDataChild.put(listDataHeader.get(5), vccrArt4);
        listDataChild.put(listDataHeader.get(6), vccrArt5);
        listDataChild.put(listDataHeader.get(7), vccrArt6);
        listDataChild.put(listDataHeader.get(8), vccrArt7);
        listDataChild.put(listDataHeader.get(9), vccrArt8);
        listDataChild.put(listDataHeader.get(10), vccrArt9);
        listDataChild.put(listDataHeader.get(11), vccrArt10);
        listDataChild.put(listDataHeader.get(12), vccrArt11);
        listDataChild.put(listDataHeader.get(13), vccrArt12);
        listDataChild.put(listDataHeader.get(14), vccrArt13);
        listDataChild.put(listDataHeader.get(15), vccrArt14);
        listDataChild.put(listDataHeader.get(16), vccrArt15);
        listDataChild.put(listDataHeader.get(17), vccrArt16);
        listDataChild.put(listDataHeader.get(18), vccrArt17);
        listDataChild.put(listDataHeader.get(19), vccrArt18);
        listDataChild.put(listDataHeader.get(20), vccrArt19);
        listDataChild.put(listDataHeader.get(21), vccrArt20);
        listDataChild.put(listDataHeader.get(22), vccrArt21);
        listDataChild.put(listDataHeader.get(23), vccrArt22);
        listDataChild.put(listDataHeader.get(24), vccrArt23);
        listDataChild.put(listDataHeader.get(25), vccrArt24);
        listDataChild.put(listDataHeader.get(26), vccrArt25);
        listDataChild.put(listDataHeader.get(27), vccrArt26);
        listDataChild.put(listDataHeader.get(28), vccrArt27);
        listDataChild.put(listDataHeader.get(29), vccrArt28);
        listDataChild.put(listDataHeader.get(30), vccrArt29);
        listDataChild.put(listDataHeader.get(31), vccrArt30);
        listDataChild.put(listDataHeader.get(32), vccrArt31);
        listDataChild.put(listDataHeader.get(33), vccrArt32);
        listDataChild.put(listDataHeader.get(34), vccrArt33);
        listDataChild.put(listDataHeader.get(35), vccrArt34);
        listDataChild.put(listDataHeader.get(36), vccrArt35);
        listDataChild.put(listDataHeader.get(37), vccrArt36);
        listDataChild.put(listDataHeader.get(38), vccrArt37);
        listDataChild.put(listDataHeader.get(39), vccrArt38);
        listDataChild.put(listDataHeader.get(40), vccrArt39);
        listDataChild.put(listDataHeader.get(41), vccrArt40);
        listDataChild.put(listDataHeader.get(42), vccrArt41);
        listDataChild.put(listDataHeader.get(43), vccrArt42);
        listDataChild.put(listDataHeader.get(44), vccrArt43);
        listDataChild.put(listDataHeader.get(45), vccrArt44);
        listDataChild.put(listDataHeader.get(46), vccrArt45);
        listDataChild.put(listDataHeader.get(47), vccrArt46);
        listDataChild.put(listDataHeader.get(48), vccrArt47);
        listDataChild.put(listDataHeader.get(49), vccrArt48);
        listDataChild.put(listDataHeader.get(50), vccrArt49);
        listDataChild.put(listDataHeader.get(51), vccrArt50);
        listDataChild.put(listDataHeader.get(52), vccrArt51);
        listDataChild.put(listDataHeader.get(53), vccrArt52);
        listDataChild.put(listDataHeader.get(54), vccrArt53);
        listDataChild.put(listDataHeader.get(55), vccrArt54);
        listDataChild.put(listDataHeader.get(56), vccrArt55);
        listDataChild.put(listDataHeader.get(57), vccrArt56);
        listDataChild.put(listDataHeader.get(58), vccrArt57);
        listDataChild.put(listDataHeader.get(59), vccrArt58);
        listDataChild.put(listDataHeader.get(60), vccrArt59);
        listDataChild.put(listDataHeader.get(61), vccrArt60);
        listDataChild.put(listDataHeader.get(62), vccrArt61);
        listDataChild.put(listDataHeader.get(63), vccrArt62);
        listDataChild.put(listDataHeader.get(64), vccrArt63);
        listDataChild.put(listDataHeader.get(65), vccrArt64);
        listDataChild.put(listDataHeader.get(66), vccrArt65);
        listDataChild.put(listDataHeader.get(67), vccrArt66);
        listDataChild.put(listDataHeader.get(68), vccrArt67);
        listDataChild.put(listDataHeader.get(69), vccrArt68);
        listDataChild.put(listDataHeader.get(70), vccrArt69);
        listDataChild.put(listDataHeader.get(71), vccrArt70);
        listDataChild.put(listDataHeader.get(72), vccrArt71);
        listDataChild.put(listDataHeader.get(73), vccrArt72);
        listDataChild.put(listDataHeader.get(74), vccrArt73);
        listDataChild.put(listDataHeader.get(75), vccrArt74);
        listDataChild.put(listDataHeader.get(76), vccrArt75);
        listDataChild.put(listDataHeader.get(77), vccrArt76);
        listDataChild.put(listDataHeader.get(78), vccrArt77);
        listDataChild.put(listDataHeader.get(79), vccrArt78);
    }
}