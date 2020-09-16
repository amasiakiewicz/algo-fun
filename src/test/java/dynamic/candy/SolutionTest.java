package dynamic.candy;

import static org.assertj.core.api.Assertions.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(final int n, final int[] arr, final long expectedCandies) {
        //given

        //when
        final long candies = Solution.candies(n, arr);

        //then
        assertThat(candies).isEqualTo(expectedCandies);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        6,
                        new int[] {4, 6, 4, 5, 6, 2},
                        10
                },
                new Object[] {
                        3,
                        new int[] {1, 2, 2},
                        4
                },
                new Object[] {
                        10,
                        new int[] {2, 4, 2, 6, 1, 7, 8, 9, 2, 1},
                        19
                },
                new Object[] {
                        8,
                        new int[] {2, 4, 3, 5, 2, 6, 4, 5},
                        12
                },
        };
    }

}
