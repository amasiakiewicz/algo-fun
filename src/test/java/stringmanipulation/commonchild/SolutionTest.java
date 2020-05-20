package stringmanipulation.commonchild;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.*;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(final String s1, final String s2, final int expectedCommonChild) {
        //given

        //when
        final int commonChild = Solution.commonChild(s1, s2);

        //then
        assertThat(commonChild).isEqualTo(expectedCommonChild);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        "HARRY",
                        "SALLY",
                        2
                },
                new Object[] {
                        "AA",
                        "BB",
                        0
                },
                new Object[] {
                        "SHINCHAN",
                        "NOHARAAA",
                        3
                },
                new Object[] {
                        "ABCDEF",
                        "FBDAMN",
                        2
                },
        };
    }

}
