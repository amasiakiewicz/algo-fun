package test.firstocc;

import static org.assertj.core.api.Assertions.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(final String s, final String x, final int expectedFirstOccurrence) {
        //given

        //when
        final int firstOccurrence = Result.firstOccurrence(s, x);

        //then
        assertThat(firstOccurrence).isEqualTo(expectedFirstOccurrence);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        "juliasamanthasamanthajulia",
                        "ant*as",
                        8
                },
                new Object[] {
                        "xabcdey",
                        "ab*de",
                        1
                },
                new Object[] {
                        "juliasamanthantjulia",
                        "ant",
                        8
                },
                new Object[] {
                        "juliasamanthasamanthajulia",
                        "has",
                        11
                },
                new Object[] {
                        "juliasamanthasamanthajulia",
                        "lol",
                        -1
                },
        };
    }

}
