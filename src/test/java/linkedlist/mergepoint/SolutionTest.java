package linkedlist.mergepoint;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import lombok.AllArgsConstructor;
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
        final HeadCouple heads1 = getHeads1();
        final HeadCouple heads2 = getHeads2();
        
        return new Object[] {
                new Object[] {
                        heads1.head1,
                        heads1.head2,
                        2
                },
                new Object[] {
                        heads2.head1,
                        heads2.head2,
                        3
                },
        };
    }

    private HeadCouple getHeads2() {
        Solution.SinglyLinkedListNode head1 = new Solution.SinglyLinkedListNode(1);
        Solution.SinglyLinkedListNode head2 = new Solution.SinglyLinkedListNode(1);

        final Solution.SinglyLinkedListNode two = new Solution.SinglyLinkedListNode(2);
        head1.next = two;

        final Solution.SinglyLinkedListNode three = new Solution.SinglyLinkedListNode(3);
        two.next = three;
        head2.next = three;

        return new HeadCouple(head1, head2);
    }

    private HeadCouple getHeads1() {
        Solution.SinglyLinkedListNode head1 = new Solution.SinglyLinkedListNode(1);
        Solution.SinglyLinkedListNode head2 = new Solution.SinglyLinkedListNode(1);

        final Solution.SinglyLinkedListNode two = new Solution.SinglyLinkedListNode(2);
        head1.next = two;
        head2.next = two;

        final Solution.SinglyLinkedListNode three = new Solution.SinglyLinkedListNode(3);
        two.next = three;

        return new HeadCouple(head1, head2);
    }

    @AllArgsConstructor
    private class HeadCouple {
        Solution.SinglyLinkedListNode head1;
        Solution.SinglyLinkedListNode head2;
    }
    
}
