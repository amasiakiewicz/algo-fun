package test.mindiff;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(final List<Integer> arr, final int expectedMinDiff) {
        //given

        //when
        final int minDiff = Result.minDiff(arr);

        //then
        assertThat(minDiff).isEqualTo(expectedMinDiff);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        Lists.newArrayList(1, 3, 3, 2, 4),
                        3
                },                
                new Object[] {
                        Lists.newArrayList(5, 1, 3, 7, 3),
                        6
                },
                new Object[] {
                        Lists.newArrayList(3, 2),
                        1
                },
        };
    }

}
