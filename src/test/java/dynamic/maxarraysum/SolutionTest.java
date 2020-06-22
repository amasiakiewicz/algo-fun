package dynamic.maxarraysum;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.*;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(int[] arr, int expectedMaxSubsetSum) {
        //given

        //when
        final int maxSubsetSum = Solution.maxSubsetSum(arr);

        //then
        assertThat(maxSubsetSum).isEqualTo(expectedMaxSubsetSum);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        new int[] { 3, 5, -7, 8, 10, 15, 6, 9 },
                        37
                },               
                new Object[] {
                        new int[] { 3, 5, -7, 8, 10 },
                        15
                },
                new Object[] {
                        new int[] { 1, 2, 3, 4, 5, 6 },
                        12
                },
                new Object[] {
                        new int[] { -2, 1, 3, -4, 5 },
                        8
                },
                new Object[] {
                        new int[] { 3, 7, 4, 6, 5 },
                        13
                },
                new Object[] {
                        new int[] { 2, 1, 5, 8, 4 },
                        11
                },
                new Object[] {
                        new int[] { 8, 10, 5 },
                        13
                },
                new Object[] {
                        new int[] { -8, 10, -5 },
                        10
                },
                new Object[] {
                        new int[] { -8, -10, -5 },
                        -5
                },
                new Object[] {
                        new int[] { 8 },
                        8
                },
                new Object[] {
                        new int[] { 8, 10 },
                        10
                },
        };
    }

}
