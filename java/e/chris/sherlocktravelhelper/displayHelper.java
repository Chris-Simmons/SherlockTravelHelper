package e.chris.sherlocktravelhelper;

import android.app.Application;
import android.content.Context;

/**
 * Created by Chris on 15-Mar-18.
 */

public class displayHelper extends Application {

    /* This class is only used to help display strings from strings.xml in the formulas used throughout
        this app via displayFormulas simply because displayFormulas does not have an activity and thus
        no context. The application name in the manifest points here to allow for this context. Without
        this, when displayed, the visa formulas would only return a series of numbers when asked to
        retrieve the value from a string because there was no way for it to use getResources(). Do not
        add anything at all to this class and do not use it for anything else except when an class requires
        a context but does not have one. To use this for strings use the following code:

                    displayHelper.getContext().getResources().getString(R.string.STRING_NAME)
     */

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext(){
        return mContext;
    }
}