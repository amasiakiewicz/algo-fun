package stringmanipulation.alternating;

import static org.assertj.core.api.Assertions.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(String s, int expectedNrOfDeletions) {
        //given

        //when
        final int nrOfDeletions = Solution.alternatingCharacters(s);

        //then
        assertThat(nrOfDeletions).isEqualTo(expectedNrOfDeletions);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        "AAAA",
                        3
                },
                new Object[] {
                        "BBBBB",
                        4
                },
                new Object[] {
                        "ABABABAB",
                        0
                },
                new Object[] {
                        "BABABA",
                        0
                },
                new Object[] {
                        "AAABBB",
                        4
                },
                new Object[] {
                        "A",
                        0
                },
                new Object[] {
                        "AA",
                        1
                },
                new Object[] {
                        "AB",
                        0
                },
                new Object[] {
                        "AABAAB",
                        2
                },
        };
    }

}
