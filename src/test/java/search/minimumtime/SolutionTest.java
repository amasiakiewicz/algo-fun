package search.minimumtime;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.*;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(final long[] machines, final long goal, final long expectedMinTime) {
        //given

        //when
        final long minTime = Solution.minTime(machines, goal);

        //then
        assertThat(minTime).isEqualTo(expectedMinTime);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        new long[] { 4, 5, 6 },
                        12L,
                        20L
                },
                new Object[] {
                        new long[] { 4, 5, 6 },
                        5L,
                        10L
                },         
                new Object[] {
                        new long[] { 2, 3 },
                        5L,
                        6L
                },
                new Object[] {
                        new long[] { 2, 3, 2 },
                        10L,
                        8L
                },
                new Object[] {
                        new long[] { 1, 3, 4 },
                        10L,
                        7L
                },
        };
    }

}
