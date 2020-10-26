package test.profit;

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
    public void shouldResult(final List<Integer> stocksProfit, final long target, final int expectedStockPairs) {
        //given

        //when
        final int stockPairs = Result.stockPairs(stocksProfit, target);

        //then
        assertThat(stockPairs).isEqualTo(expectedStockPairs);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        Lists.newArrayList(1, 3, 46, 1, 3, 9),
                        47,
                        1
                },
                new Object[] {
                        Lists.newArrayList(0, 1, 0, 8, 0),
                        0,
                        1
                },
                new Object[] {
                        Lists.newArrayList(0, 1, 5, 8, 6),
                        0,
                        0
                },
                new Object[] {
                        Lists.newArrayList(6, 6, 3, 9, 3, 5, 1),
                        12,
                        2
                }
        };
    }

}
