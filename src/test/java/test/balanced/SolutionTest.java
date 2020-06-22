package test.balanced;

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
    public void shouldResult(final List<String> expressions, final List<Integer> maxReplacements, final List<Integer> expectedBalancedOrNot) {
        //given

        //when
        final List<Integer> balancedOrNot = Result.balancedOrNot(expressions, maxReplacements);

        //then
        assertThat(balancedOrNot).isEqualTo(expectedBalancedOrNot);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        Lists.newArrayList("<<>>", "<>", "<><>", ">>", "<<>", "><><"),
                        Lists.newArrayList(0, 1, 2, 2, 2, 2),
                        Lists.newArrayList(1, 1, 1, 1, 0, 0)
                },
                new Object[] {
                        Lists.newArrayList("<>>>", "<>>>>"),
                        Lists.newArrayList(2, 2),
                        Lists.newArrayList(1, 0)
                },
                new Object[] {
                        Lists.newArrayList("<>", "<>><"),
                        Lists.newArrayList(1, 0),
                        Lists.newArrayList(1, 0)
                },
                new Object[] {
                        Lists.newArrayList("<<<><><>"),
                        Lists.newArrayList(2),
                        Lists.newArrayList(0)
                },
        };
    }

}
