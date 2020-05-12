package dict.frequency;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(final List<List<Integer>> queries, final List<Integer> expectedFreqQuery) {
        //given

        //when
        final List<Integer> freqQuery = Solution.freqQuery(queries);

        //then
        assertThat(freqQuery).isEqualTo(expectedFreqQuery);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        Arrays.asList(
                                Arrays.asList(1, 5),
                                Arrays.asList(1, 6),
                                Arrays.asList(3, 2),
                                Arrays.asList(1, 10),
                                Arrays.asList(1, 10),
                                Arrays.asList(1, 6),
                                Arrays.asList(2, 5),
                                Arrays.asList(3, 2)
                        ),
                        Arrays.asList(0, 1)
                },
                new Object[] {
                        Arrays.asList(
                                Arrays.asList(3, 4),
                                Arrays.asList(2, 1003),
                                Arrays.asList(1, 16),
                                Arrays.asList(3, 1)
                        ),
                        Arrays.asList(0, 1)
                },
                new Object[] {
                        Arrays.asList(
                                Arrays.asList(1, 3),
                                Arrays.asList(2, 3),
                                Arrays.asList(3, 2),
                                Arrays.asList(1, 4),
                                Arrays.asList(1, 5),
                                Arrays.asList(1, 5),
                                Arrays.asList(1, 4),
                                Arrays.asList(3, 2),
                                Arrays.asList(2, 4),
                                Arrays.asList(3, 2)
                        ),
                        Arrays.asList(0, 1, 1)
                },
                new Object[] {
                        Arrays.asList(
                                Arrays.asList(1, 1),
                                Arrays.asList(2, 2),
                                Arrays.asList(3, 2),
                                Arrays.asList(1, 1),
                                Arrays.asList(1, 1),
                                Arrays.asList(2, 1),
                                Arrays.asList(3, 2)
                        ),
                        Arrays.asList(0, 1)
                },
                new Object[] {
                        Arrays.asList(
                                Arrays.asList(2, 1),
                                Arrays.asList(2, 1),
                                Arrays.asList(1, 1),
                                Arrays.asList(3, 1)
                        ),
                        Collections.singletonList(1)
                },
                new Object[] {
                        Collections.singletonList(
                                Arrays.asList(2, 1)
                        ),
                        Collections.emptyList()
                },
        };
    }

}
