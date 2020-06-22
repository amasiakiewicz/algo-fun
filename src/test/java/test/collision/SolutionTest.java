package test.collision;

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
    public void shouldResult(final List<Integer> speed, final int pos, final int expectedCollision) {
        //given

        //when
        final int collision = Result.collision(speed, pos);

        //then
        assertThat(collision).isEqualTo(expectedCollision);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        Lists.newArrayList(2, 1),
                        0,
                        1
                },
                new Object[] {
                        Lists.newArrayList(6, 6, 1, 6, 3, 4, 6, 8),
                        2,
                        2
                },
                new Object[] {
                        Lists.newArrayList(8, 3, 6, 3, 2, 2, 4, 8, 1, 6),
                        7,
                        2
                },
                new Object[] {
                        Lists.newArrayList(1, 3, 7, 4, 6, 4),
                        3,
                        1
                },
        };
    }

}
