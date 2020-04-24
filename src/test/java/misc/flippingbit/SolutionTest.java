package misc.flippingbit;

import static org.assertj.core.api.Assertions.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(long n, long expectedFlippingBits) {
        //given

        //when
        final long flippingBits = Solution.flippingBits(n);

        //then
        assertThat(flippingBits).isEqualTo(expectedFlippingBits);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        2147483647L,
                        2147483648L
                },
                new Object[] {
                        1L,
                        4294967294L
                },
                new Object[] {
                        0L,
                        4294967295L
                },
                new Object[] {
                        4L,
                        4294967291L
                },
                new Object[] {
                        123456L,
                        4294843839L
                },
                new Object[] {
                        802743475L,
                        3492223820L
                },
                new Object[] {
                        35601423L,
                        4259365872L
                },
        };
    }

}
