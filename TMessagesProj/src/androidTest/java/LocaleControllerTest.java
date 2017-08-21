import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.telegram.messenger.LocaleController;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by ns on 21/08/2017.
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class LocaleControllerTest {

    LocaleController lc;
    LocaleController.LocaleInfo li;

    @Before
    public void setup() {
        lc = new LocaleController();
        li = new LocaleController.LocaleInfo();
        li.name = "Nederlands";
        li.nameEnglish = "Dutch";
        li.shortName = "nl";
        li.pathToFile = null;
    }

    @Test
    public void testApplyLanguage() {

        assertThat(lc.getCurrentLanguageName(), is("English"));
        lc.applyLanguage(li, true);
        assertThat(lc.getCurrentLanguageName(), is("Nederlands"));

    }
}
