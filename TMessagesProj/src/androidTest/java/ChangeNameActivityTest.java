import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import android.support.v4.app.SupportActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.telegram.messenger.MessagesController;
import org.telegram.messenger.NotificationCenter;
import org.telegram.messenger.UserConfig;
import org.telegram.tgnet.ConnectionsManager;
import org.telegram.tgnet.RequestDelegate;
import org.telegram.tgnet.TLObject;
import org.telegram.tgnet.TLRPC;
import org.telegram.ui.ChangeNameActivity;

import java.util.Collection;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.runner.lifecycle.Stage.RESUMED;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


/**
 * Created by ns on 21/08/2017.
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class ChangeNameActivityTest {

    private ChangeNameActivity cna;
    private TLRPC.User user;
    private SupportActivity currentActivity;

    private String currentName = "Nick Lasagna";
    private String newFirstName = "Lasagna";
    private String newLastName = "Picante";
    private String newName = newFirstName + " " + newLastName;


    @Before
    public void setup() throws Throwable {
        cna = new ChangeNameActivity();
        user = UserConfig.getCurrentUser();
//        cna.createView(getActivityInstance());
    }

    public SupportActivity getActivityInstance() {
        getInstrumentation().runOnMainSync(new Runnable() {
            public void run() {
                Collection resumedActivities = ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(RESUMED);
                if (resumedActivities.iterator().hasNext()){
                    currentActivity = (SupportActivity) resumedActivities.iterator().next();
                }
            }
        });

        return currentActivity;
    }


    @Test
    public void testSaveName() {
        assertThat(user.first_name + " " + user.last_name, is(currentName));

        TLRPC.TL_account_updateProfile req = new TLRPC.TL_account_updateProfile();
        req.flags = 3;
        user.first_name = req.first_name = newFirstName;
        user.last_name = req.last_name = newLastName;
        TLRPC.User user = MessagesController.getInstance().getUser(UserConfig.getClientUserId());
        UserConfig.saveConfig(true);
        NotificationCenter.getInstance().postNotificationName(NotificationCenter.mainUserInfoChanged);
        NotificationCenter.getInstance().postNotificationName(NotificationCenter.updateInterfaces,
                MessagesController.UPDATE_MASK_NAME);
        ConnectionsManager.getInstance().sendRequest(req, new RequestDelegate() {
            @Override
            public void run(TLObject response, TLRPC.TL_error error) {

            }
        });
        cna.finishFragment();
        user = UserConfig.getCurrentUser();
        assertThat(user.first_name + " " + user.last_name, is(newName));
    }
}
