package sorting.marktoy;

import static org.assertj.core.api.Assertions.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(int[] prices, int k, int expectedMaximumToys) {
        //given

        //when
        final int maximumToys = Solution.maximumToys(prices, k);

        //then
        assertThat(maximumToys).isEqualTo(expectedMaximumToys);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        new int[] { 1, 12, 5, 111, 200, 1000, 10 },
                        50,
                        4
                },
                new Object[] {
                        new int[] { 1, 2, 3, 4 },
                        7,
                        3
                },
                new Object[] {
                        new int[] { 1 },
                        1,
                        1
                },
                new Object[] {
                        new int[] { 3 },
                        1,
                        0
                },
                new Object[] {
                        new int[] { 1 },
                        7,
                        1
                },
                new Object[] {
                        new int[] { 2, 3 },
                        1,
                        0
                },
                new Object[] {
                        new int[] { 1, 2 },
                        1,
                        1
                },
                new Object[] {
                        new int[] { 1, 2 },
                        2,
                        1
                },
                new Object[] {
                        new int[] { 1, 2 },
                        3,
                        2
                },
                new Object[] {
                        new int[] { 1, 2 },
                        4,
                        2
                },
        };
    }

}
