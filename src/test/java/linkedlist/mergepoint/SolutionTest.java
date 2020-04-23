package linkedlist.mergepoint;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(Solution.SinglyLinkedListNode head1, Solution.SinglyLinkedListNode head2, int expectedMergePoint) throws IOException {
        //given

        //when
        final int mergePoint = Solution.findMergeNode(head1, head2);

        //then
        assertThat(mergePoint).isEqualTo(expectedMergePoint);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        getHead1(),
                        "4 3 2 1"
                },
        };
    }

    private linkedlist.reversedoubly.Solution.DoublyLinkedListNode getHead1() {
        final linkedlist.reversedoubly.Solution.DoublyLinkedListNode head = new linkedlist.reversedoubly.Solution.DoublyLinkedListNode(1);

        final linkedlist.reversedoubly.Solution.DoublyLinkedListNode two = new linkedlist.reversedoubly.Solution.DoublyLinkedListNode(2);
        head.next = two;
        two.prev = head;

        final linkedlist.reversedoubly.Solution.DoublyLinkedListNode three = new linkedlist.reversedoubly.Solution.DoublyLinkedListNode(3);
        two.next = three;
        three.prev = two;

        final linkedlist.reversedoubly.Solution.DoublyLinkedListNode four = new Solution.DoublyLinkedListNode(4);
        three.next = four;
        four.prev = three;

        return head;
    }

}
