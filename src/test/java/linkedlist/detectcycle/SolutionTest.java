package linkedlist.detectcycle;

import static org.assertj.core.api.Assertions.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(Solution.Node head, boolean expectedHasCycle) {
        //given
        final Solution solution = new Solution();

        //when
        final boolean hasCycle = solution.hasCycle(head);

        //then
        assertThat(hasCycle).isEqualTo(expectedHasCycle);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        new Solution.Node(1),
                        false
                },
                new Object[] {
                        getHead1(),
                        true
                },
                new Object[] {
                        null,
                        false
                },
        };
    }

    private Solution.Node getHead1() {
        final Solution.Node head = new Solution.Node(1);

        final Solution.Node two = new Solution.Node(2);
        head.next = two;

        final Solution.Node three = new Solution.Node(3);
        two.next = three;
        three.next = two;

        return head;
    }

}
