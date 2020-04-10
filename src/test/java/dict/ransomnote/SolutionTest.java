package dict.ransomnote;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.*;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(final String[] magazine, final String[] note, String expectedCheckMagazine) {
        //given

        //when
        final String checkMagazine = Solution.printCheckMagazine(magazine, note);

        //then
        assertThat(checkMagazine).isEqualTo(expectedCheckMagazine);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        new String[] { "give", "me", "one", "grand", "today", "night" },
                        new String[] { "give", "one", "grand", "today" },
                        "Yes"
                },
                new Object[] {
                        new String[] { "two", "times", "three", "is", "not", "four", },
                        new String[] { "two", "times", "two", "is", "four", },
                        "No"
                },
                new Object[] {
                        new String[] { "ive", "got", "a", "lovely", "bunch", "of", "coconuts", },
                        new String[] { "ive", "got", "some", "coconuts", },
                        "No"
                },
        };
    }

}
