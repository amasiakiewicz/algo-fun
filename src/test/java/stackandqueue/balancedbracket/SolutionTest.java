package stackandqueue.balancedbracket;

import static org.assertj.core.api.Assertions.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(final String s, final String expectedBalanced) {
        //given

        //when
        final String balanced = Solution.isBalanced(s);

        //then
        assertThat(balanced).isEqualTo(expectedBalanced);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        "{{",
                        "NO",
                },             
                new Object[] {
                        "{",
                        "NO",
                },             
                new Object[] {
                        "{[()]}",
                        "YES",
                },
                new Object[] {
                        "{[(])}",
                        "NO",
                },
                new Object[] {
                        "{{[[(())]]}}",
                        "YES",
                },
        };
    }

}
