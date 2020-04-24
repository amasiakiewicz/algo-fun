package recursion.fibonacci;

import static org.assertj.core.api.Assertions.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(int n, int expectedFibonacci) {
        //given

        //when
        final int fibonacci = Solution.fibonacci(n);

        //then
        assertThat(fibonacci).isEqualTo(expectedFibonacci);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        3,
                        2
                },
        };
    }

}
