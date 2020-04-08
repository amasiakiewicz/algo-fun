package warmup.countingvalley;

import static org.assertj.core.api.Assertions.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(final int n, String s, final int expectedNrOfValleys) {
        //given

        //when
        final int nrOfValleys = Solution.countingValleys(n, s);

        //then
        assertThat(nrOfValleys).isEqualTo(expectedNrOfValleys);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        8,
                        "UDDDUDUU",
                        1
                },
                new Object[] {
                        8,
                        "DDUUUUDD",
                        1
                },
                new Object[] {
                        4,
                        "UDUD",
                        0
                },
                new Object[] {
                        4,
                        "UUDD",
                        0
                },
                new Object[] {
                        4,
                        "DUDU",
                        2
                },
                new Object[] {
                        4,
                        "DDUU",
                        1
                },
                new Object[] {
                        6,
                        "DDUUDU",
                        2
                },
                new Object[] {
                        8,
                        "DDDUUDUU",
                        1
                },
                new Object[] {
                        6,
                        "UUDUDD",
                        0
                },
                new Object[] {
                        8,
                        "UUUDDUDD",
                        0
                },
                new Object[] {
                        12,
                        "DDUUDDUDUUUD",
                        2
                },
        };
    }

}