package dict.twostring;

import static org.assertj.core.api.Assertions.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(String s1, String s2, String expectedTwoStrings) {
        //given

        //when
        final String twoStrings = Solution.twoStrings(s1, s2);

        //then
        assertThat(twoStrings).isEqualTo(expectedTwoStrings);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        "hello",
                        "world",
                        "YES"
                },
                new Object[] {
                        "hi",
                        "world",
                        "NO"
                },
                new Object[] {
                        "i",
                        "i",
                        "YES"
                },
                new Object[] {
                        "i",
                        "j",
                        "NO"
                },
                new Object[] {
                        "hi",
                        "wohid",
                        "YES"
                },
                new Object[] {
                        "hiii",
                        "worild",
                        "YES"
                },
        };
    }

}
