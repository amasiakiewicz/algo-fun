package warmup.jumpingcloud;

import static org.assertj.core.api.Assertions.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(int[] c, int expectedNrOfJumps) {
        //given

        //when
        final int nrOfJumps = Solution.jumpingOnClouds(c);

        //then
        assertThat(nrOfJumps).isEqualTo(expectedNrOfJumps);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        new int[] {0, 0, 1, 0, 0, 1, 0},
                        4
                },
                new Object[] {
                        new int[] {0, 0, 0, 0, 1, 0},
                        3
                },
                new Object[] {
                        new int[] {0, 1, 0, 0, 0, 1, 0},
                        3
                },
                new Object[] {
                        new int[] {0, 0},
                        1
                },
                new Object[] {
                        new int[] {0, 0, 0},
                        1
                },
                new Object[] {
                        new int[] {0, 0, 0, 0},
                        2
                },
                new Object[] {
                        new int[] {0, 1, 0, 1, 0, 1, 0},
                        3
                },
                new Object[] {
                        new int[] {0, 0, 1, 0, 0, 1, 0},
                        4
                },
                new Object[] {
                        new int[] {0, 1, 0, 1, 0, 0},
                        3
                },
        };
    }

}