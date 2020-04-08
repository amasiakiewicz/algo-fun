package array.twodarrayds;

import static org.assertj.core.api.Assertions.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(int[][] arr, long expectedSum) {
        //given

        //when
        final long sum = Solution.hourglassSum(arr);

        //then
        assertThat(sum).isEqualTo(expectedSum);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        new int[][] {
                                { 1, 1, 1, 0, 0, 0 },
                                { 0, 1, 0, 0, 0, 0 },
                                { 1, 1, 1, 0, 0, 0 },
                                { 0, 0, 2, 4, 4, 0 },
                                { 0, 0, 0, 2, 0, 0 },
                                { 0, 0, 1, 2, 4, 0 },
                        },
                        19
                },
                new Object[] {
                        new int[][] {
                                { -1, -1, -1, -1, -1, -1 },
                                { -1, -1, -1, -1, -1, -1 },
                                { -1, -1, -1, -1, -1, -1 },
                                { -1, -1, -1, -1, -1, -1 },
                                { -1, -1, -1, -1, -1, -1 },
                                { -1, -1, -1, -1, -1, -1 },
                        },
                        -7
                },
        };
    }

}
