package stringmanipulation.specialstring;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.*;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(final int n, final String s, final long expectedSubstrCount) {
        //given

        //when
        final long substrCount = Solution.substrCount(n, s);

        //then
        assertThat(substrCount).isEqualTo(expectedSubstrCount);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        5,
                        "asasd",
                        7
                },
                new Object[] {
                        7,
                        "abcbaba",
                        10
                },
                new Object[] {
                        4,
                        "aaaa",
                        10
                },
                new Object[] {
                        1,
                        "a",
                        1
                },
        };
    }

}
