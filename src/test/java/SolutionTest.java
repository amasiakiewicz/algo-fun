import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.*;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(final int n, final int[] ar, final int expectedSockPairNr) {
        //given

        //when
        final int sockPairNr = Solution.sockMerchant(n, ar);

        //then
        assertThat(sockPairNr).isEqualTo(expectedSockPairNr);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        9,
                        new int[] { 10, 20, 20, 10, 10, 30, 50, 10, 20 },
                        3
                },
                new Object[] {
                        7,
                        new int[] { 1, 2, 1, 2, 1, 3, 2 },
                        2,
                },
                new Object[] {
                        1,
                        new int[] {1},
                        0,
                },
                new Object[] {
                        7,
                        new int[] {1, 2, 3, 4, 5, 6, 7},
                        0,
                },
                new Object[] {
                        7,
                        new int[] {2, 1, 1, 1, 1, 1, 1},
                        3,
                },               
                new Object[] {
                        7,
                        new int[] {1, 1, 1, 1, 1, 1, 1},
                        3,
                },                
                new Object[] {
                        6,
                        new int[] {1, 1, 1, 1, 1, 1},
                        3,
                },
        };
    }

}