package greedy.luckbalance;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.*;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(final int k, final int[][] contests, int expectedLuckBalance) {
        //given

        //when
        final int luckBalance = Solution.luckBalance(k, contests);

        //then
        assertThat(luckBalance).isEqualTo(expectedLuckBalance);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        3,
                        new int[][] {
                                { 5, 1 },
                                { 2, 1 },
                                { 1, 1 },
                                { 8, 1 },
                                { 10, 0 },
                                { 5, 0 },
                        },
                        29
                },
                new Object[] {
                        0,
                        new int[][] {
                                { 2, 1 },
                                { 1, 1 },
                                { 10, 0 },
                                { 5, 0 },
                        },
                        12
                },
                new Object[] {
                        1,
                        new int[][] {
                                { 5, 1 },
                                { 2, 1 },
                                { 1, 1 },
                                { 8, 1 },
                                { 10, 0 },
                                { 5, 0 },
                        },
                        15
                },
                new Object[] {
                        1,
                        new int[][] {
                                { 5, 0 },
                        },
                        5
                },
                new Object[] {
                        1,
                        new int[][] {
                                { 5, 1 },
                        },
                        5
                },
                new Object[] {
                        0,
                        new int[][] {
                                { 5, 1 },
                        },
                        -5
                },
                new Object[] {
                        0,
                        new int[][] {
                                { 5, 0 },
                        },
                        5
                },
        };
    }

}
