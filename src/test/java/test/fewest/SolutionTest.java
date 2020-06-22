package test.fewest;

import static org.assertj.core.api.Assertions.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(final String coins, final int expectedFewestCoins) {
        //given

        //when
        final int fewestCoins = Result.fewestCoins(coins);

        //then
        assertThat(fewestCoins).isEqualTo(expectedFewestCoins);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        "dabbcabcd",
                        4
                },
                new Object[] {
                        "bab",
                        2
                },
                new Object[] {
                        "asdfkjeghfalawefhaef",
                        13
                },
        };
    }

}
