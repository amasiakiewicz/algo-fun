package sorting.bublesort;

import static org.assertj.core.api.Assertions.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(int[] a, String expectedCountSwapsString) {
        //given

        //when
        final String countSwapsString = Solution.printCountSwaps(a);

        //then
        assertThat(countSwapsString).isEqualTo(expectedCountSwapsString);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        new int[] { 1, 2, 3 },
                        "Array is sorted in 0 swaps.\n" +
                                "First Element: 1\n" +
                                "Last Element: 3"
                },
                new Object[] {
                        new int[] { 3, 2, 1 },
                        "Array is sorted in 3 swaps.\n" +
                                "First Element: 1\n" +
                                "Last Element: 3"
                },
        };
    }

}
