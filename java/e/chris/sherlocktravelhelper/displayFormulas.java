package e.chris.sherlocktravelhelper;

import android.annotation.TargetApi;
import android.os.Build;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

/**
 * Created by chris on 2/21/18.
 */

public class displayFormulas {

    /* To do:
            Now that I have this functioning, the majority of the work left to do is refining the tables and
            inputting data into them. Make sure to use a consistent code while doing so. When that is finished,
            take the code and apply it in the formula to generate the visa warnings. Try to use a non-country
            specific code unless information is only used for that single country. Consider putting the code in
            a manual so that others can easily tell what's going on if there is confusion.

            Make sure to deal with visas first. Consulate numbers will be more annoying to obtain due to the
            uniqueness of most numbers and depending on the availability of them for some countries, but it is
            of less importance than ensuring the core functionality of this app is finished, namely the visas.
     */

    /* Formulas on this page are only for when a display option has multiple possibilities for what is displayed
        These are not for when the option is either display something or set visibility to GONE. Do that in the
        actual class. */

    /* Calculates whether a visa is required for a trip */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static String visaReqs(String passport, String eDestination, int visaLength, String eSDate, String eEDate, String eReason, String visaReq, String visaCode) {

        /* Calculates the difference between the start date and end date and assigns as eDuration */
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        String visa = null;
        try {
            Date start = sdf.parse(eSDate);
            Date end = sdf.parse(eEDate);

            long diff = end.getTime() - start.getTime();
            long eDuration = diff / (1000 * 60 * 60 * 24);

            String visaType = null;
            String visaNote = null;

            /* Start visa formulas */
            /* These formulas all work together in a series of if/else statements, see comment for rules followed */
            if (Objects.equals(passport, eDestination)) {
                visa = displayHelper.getContext().getResources().getString(R.string.noTravel);
            } else if (visaLength > eDuration && Objects.equals(eReason, "Tourism") || Objects.equals(eReason, "Business")) {
                /* visa requirement codes */
                if (Objects.equals(visaReq, "yn") || Objects.equals(visaReq, null)) {
                    visaType = displayHelper.getContext().getResources().getString(R.string.visaYes);
                }
                if (Objects.equals(visaReq, "nv")) {
                    visaType = displayHelper.getContext().getResources().getString(R.string.visaNo);
                }
                if (Objects.equals(visaReq, "voa")) {
                    visaType = displayHelper.getContext().getResources().getString(R.string.voa);
                }
                if (Objects.equals(visaReq, "poa")) {
                    visaType = displayHelper.getContext().getResources().getString(R.string.poa);
                }
                if (Objects.equals(visaReq, "res")) {
                    visaType = displayHelper.getContext().getResources().getString(R.string.res);
                }
                if (Objects.equals(visaReq, "ev")) {
                    visaType = displayHelper.getContext().getResources().getString(R.string.ev);
                }

                /* Visa note codes */
                if (Objects.equals(visaCode, "---") || Objects.equals(visaCode, null)) {
                    visaNote = ".";
                }
                if (Objects.equals(visaCode, "30wi60")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.t30wi60);
                }
                if (Objects.equals(visaCode, "30wi180")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.t30wi180);
                }
                if (Objects.equals(visaCode, "30wi365")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.t30wi365);
                }
                if (Objects.equals(visaCode, "60wi180")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.t60wi365);
                }
                if (Objects.equals(visaCode, "90wi180")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.t90wi180);
                }
                if (Objects.equals(visaCode, "90wi180reg")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.t90wi180reg);
                }
                if (Objects.equals(visaCode, "90wi365")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.t90wi365);
                }
                if (Objects.equals(visaCode, "120wi365")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.t120wi365);
                }
                if (Objects.equals(visaCode, "180wi365")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.t180wi365);
                }
                if (Objects.equals(visaCode, "e60")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.e60);
                }
                if (Objects.equals(visaCode, "e60noIsr")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.e60noIsr);
                }
                if (Objects.equals(visaCode, "e90")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.e90);
                }
                if (Objects.equals(visaCode, "e120")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.e120);
                }
                if (Objects.equals(visaCode, "e180")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.e180);
                }
                if (Objects.equals(visaCode, "e180wi365")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.e180wi365);
                }
                if (Objects.equals(visaCode, "e240")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.e240);
                }
                if (Objects.equals(visaCode, "e365")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.e365);
                }
                if (Objects.equals(visaCode, "armair")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.armair);
                }
                if (Objects.equals(visaCode, "azerair")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.azerair);
                }
                if (Objects.equals(visaCode, "bangair")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.bangair);
                }
                if (Objects.equals(visaCode, "belair")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.belair);
                }
                if (Objects.equals(visaCode, "burkair")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.burkair);
                }
                if (Objects.equals(visaCode, "caricom")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.caricom);
                }
                if (Objects.equals(visaCode, "eta")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.eta);
                }
                if (Objects.equals(visaCode, "inv")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.inv);
                }
                if (Objects.equals(visaCode, "iranair")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.iranair);
                }
                if (Objects.equals(visaCode, "iraqair")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.iraqair);
                }
                if (Objects.equals(visaCode, "kyrgair")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.kyrgair);
                }
                if (Objects.equals(visaCode, "maurair")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.maurair);
                }
                if (Objects.equals(visaCode, "mexus")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.mexus);
                }
                if (Objects.equals(visaCode, "mozair")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.mozair);
                }
                if (Objects.equals(visaCode, "nepair")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.nepair);
                }
                if (Objects.equals(visaCode, "qatair")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.qatair);
                }
                if (Objects.equals(visaCode, "qatproof")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.qatproof);
                }
                if (Objects.equals(visaCode, "parair")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.parair);
                }
                if (Objects.equals(visaCode, "proof")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.proof);
                }
                if (Objects.equals(visaCode, "reg")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.reg);
                }
                if (Objects.equals(visaCode, "reg30")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.reg30);
                }
                if (Objects.equals(visaCode, "schengen")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.schengen);
                }
                if (Objects.equals(visaCode, "somair")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.somair);
                }
                if (Objects.equals(visaCode, "surair")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.surair);
                }
                if (Objects.equals(visaCode, "tajair")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.tajair);
                }
                if (Objects.equals(visaCode, "tcard")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.tcard) + eDestination + ".";
                }
                if (Objects.equals(visaCode, "timair")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.timair);
                }
                if (Objects.equals(visaCode, "ukrair")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.ukrair);
                }
                if (Objects.equals(visaCode, "usvw")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.usvw);
                }
                if (Objects.equals(visaCode, "vacc")) {
                    visaNote = displayHelper.getContext().getResources().getString(R.string.vacc);
                }

                /* Puts it together */
                visa = visaType + visaNote;
            } else {
                visa = displayHelper.getContext().getResources().getString(R.string.visaYes);
            }
            /* End Visa Formulas */

        /* Closes find duration, catches any problems with finding duration, closes main sections of code */
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return visa;
    }

    /* Display travel advisories for a country */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static String advisories (String advisory, String code) {
        String travelWarning = null;
        String aLevel = null;
        if (Objects.equals(advisory, "level 1, exercise normal precautions")) {
            aLevel = displayHelper.getContext().getResources().getString(R.string.lvl1);
        }
        if (Objects.equals(advisory, "level 2, exercise increased caution")) {
            aLevel = displayHelper.getContext().getResources().getString(R.string.lvl2);
        }
        if (Objects.equals(advisory, "level 3, reconsider travel")) {
            aLevel = displayHelper.getContext().getResources().getString(R.string.lvl3);
        }
        if (Objects.equals(advisory, "level 4, do not travel")) {
            aLevel = displayHelper.getContext().getResources().getString(R.string.lvl4);
        }
        if (Objects.equals(code, "---")) {
            travelWarning = displayHelper.getContext().getResources().getString(R.string.advisory) + aLevel;
        } else {
            travelWarning = displayHelper.getContext().getResources().getString(R.string.advisory) + aLevel + displayHelper.getContext().getResources().getString(R.string.dueToConnector) + code;
        } return travelWarning;
    }

    /* Display if destination is a party to VCCR */
    
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static String vccrParty (String destination, String vccr) {
        String party = null;
        if (Objects.equals(vccr, "Yes")) {
            party = displayHelper.getContext().getResources().getString(R.string.vccrStart) + destination + displayHelper.getContext().getResources().getString(R.string.vccrEndYes);
        } else {
            party = displayHelper.getContext().getResources().getString(R.string.vccrStart) + destination + displayHelper.getContext().getResources().getString(R.string.vccrEndNo);
        } return party;
    }

    /* Display state sanctuary areas if there are any for user */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static String sanctuary (String sancArea) {
        String sancAreas = null;
        if (Objects.equals(sancArea, "all")) {
            sancAreas = displayHelper.getContext().getResources().getString(R.string.sanctuaryAreaAll);
        } else if (Objects.equals(sancArea, "none")) {
            sancAreas = displayHelper.getContext().getResources().getString(R.string.sanctuaryAreaNone);
        } else {
            sancAreas = displayHelper.getContext().getResources().getString(R.string.sanctuaryAreas) + sancArea;
        } return sancAreas;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static String trip (String origin, String sOrigin, String destination, String sDestination, String reason) {
        String trip = null;
        String reasonDisplay = null;
        if (Objects.equals(reason, "Tourism")) {
            reasonDisplay = displayHelper.getContext().getResources().getString(R.string.tourism).toString();
        }
        if (Objects.equals(reason, "Business")) {
            reasonDisplay = displayHelper.getContext().getResources().getString(R.string.business);
        }
        if (Objects.equals(reason, "Work")) {
            reasonDisplay = displayHelper.getContext().getResources().getString(R.string.work);
        }
        if (Objects.equals(reason, "Education")) {
            reasonDisplay = displayHelper.getContext().getResources().getString(R.string.school);
        }
        if (Objects.equals(reason, "Other")) {
            reasonDisplay = displayHelper.getContext().getResources().getString(R.string.other);
        }
        if (Objects.equals(sOrigin, "---") && !Objects.equals(sDestination, "---")) {
            trip = displayHelper.getContext().getResources().getString(R.string.travelFrom) + origin + origin + displayHelper.getContext().getResources().getString(R.string.toConnector)
                    + sDestination + ", " + destination + displayHelper.getContext().getResources().getString(R.string.forConnector) + reasonDisplay;
        } else if (Objects.equals(sDestination, "---") && !Objects.equals(sOrigin, "---")) {
            trip = displayHelper.getContext().getResources().getString(R.string.travelFrom) + sOrigin + ", " + origin + origin + displayHelper.getContext().getResources().getString(R.string.toConnector)
                    + destination + displayHelper.getContext().getResources().getString(R.string.forConnector) + reasonDisplay;
        } else if (Objects.equals(sOrigin, "---") && (Objects.equals(sDestination, "---"))) {
            trip = displayHelper.getContext().getResources().getString(R.string.travelFrom) + origin + displayHelper.getContext().getResources().getString(R.string.toConnector)
                    + destination + displayHelper.getContext().getResources().getString(R.string.forConnector) + reasonDisplay;
        } else {
            trip = displayHelper.getContext().getResources().getString(R.string.travelFrom) + sOrigin + ", " + origin + origin + displayHelper.getContext().getResources().getString(R.string.toConnector)
                    + sDestination + ", " + destination + displayHelper.getContext().getResources().getString(R.string.forConnector) + reasonDisplay;
        } return trip;
    }
}
