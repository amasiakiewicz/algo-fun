package warmup.repeatedstring;

import static org.assertj.core.api.Assertions.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(String s, long n, long expectedRepeatedString) {
        //given

        //when
        final long repeatedString = Solution.repeatedString(s, n);

        //then
        assertThat(repeatedString).isEqualTo(expectedRepeatedString);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        "aba",
                        10L, 
                        7
                },
                new Object[] {
                        "a",
                        1000000000000L,
                        1000000000000L
                },
                new Object[] {
                        "abcdefacdessddaa",
                        9L,
                        2L
                },
                new Object[] {
                        "a",
                        1L,
                        1L
                },
                new Object[] {
                        "b",
                        1L,
                        0L
                },
                new Object[] {
                        "bc",
                        9L,
                        0L
                },
                new Object[] {
                        "abcdefa",
                        14L,
                        4L
                },
                new Object[] {
                        "abcdefa",
                        9L,
                        3L
                },
                new Object[] {
                        "cbcaefa",
                        9L,
                        2L
                },
                new Object[] {
                        "abcdefa",
                        18L,
                        5L
                },
        };
    }

}