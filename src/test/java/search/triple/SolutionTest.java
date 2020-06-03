package search.triple;

import static org.assertj.core.api.Assertions.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(final int[] arr, final int[] b, final int[] c, final long expectedTriplets) {
        //given

        //when
        final long triplets = Solution.triplets(arr, b, c);

        //then
        assertThat(triplets).isEqualTo(expectedTriplets);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        new int[] { 1, 3, 5 },
                        new int[] { 2, 3, },
                        new int[] { 1, 2, 3 },
                        8
                },                
                new Object[] {
                        new int[] { 1, 1, 3, 5 },
                        new int[] { 2, 3, },
                        new int[] { 1, 2, 3 },
                        8
                },
                new Object[] {
                        new int[] { 1, 4, 5 },
                        new int[] { 2, 3, 3 },
                        new int[] { 1, 2, 3 },
                        5
                },
                new Object[] {
                        new int[] { 1, 3, 5, 7 },
                        new int[] { 5, 7, 9, },
                        new int[] { 7, 9, 11, 13 },
                        12
                },
        };
    }

}
