package sorting.fraudulent;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.*;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(final int[] expenditure, final int d, final int expectedActivityNotifications) {
        //given

        //when
        final int activityNotifications = Solution.activityNotifications(expenditure, d);

        //then
        assertThat(activityNotifications).isEqualTo(expectedActivityNotifications);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        new int[] { 2, 3, 4, 2, 3, 6, 8, 4, 5 },
                        5,
                        2
                },
                new Object[] {
                        new int[] { 1, 2, 3, 4, 4 },
                        4,
                        0
                },
                new Object[] {
                        new int[] { 1, 2, 3, 4, 4 },
                        1,
                        1
                },
                new Object[] {
                        new int[] { 1, 2, 3, 4, 4 },
                        5,
                        0
                },
        };
    }

}
