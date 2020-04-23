package linkedlist.reversedoubly;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(Solution.DoublyLinkedListNode head, String expectedListPrint) throws IOException {
        //given

        //when
        final Solution.DoublyLinkedListNode reverseList = Solution.reverse(head);

        //then
        final StringWriter sw = new StringWriter();
        final BufferedWriter bufferedWriter = new BufferedWriter(sw);
        Solution.printDoublyLinkedList(reverseList, " ", bufferedWriter);
        bufferedWriter.flush();
        assertThat(sw.getBuffer().toString()).isEqualTo(expectedListPrint);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        getHead1(),
                        "4 3 2 1"
                },
                new Object[] {
                        null,
                        ""
                },
                new Object[] {
                        new Solution.DoublyLinkedListNode(1),
                        "1"
                },
                new Object[] {
                        getHead2(),
                        "2 1"
                },
        };
    }

    private Solution.DoublyLinkedListNode getHead2() {
        final Solution.DoublyLinkedListNode head = new Solution.DoublyLinkedListNode(1);

        final Solution.DoublyLinkedListNode two = new Solution.DoublyLinkedListNode(2);
        head.next = two;
        two.prev = head;

        return head;
    }

    private Solution.DoublyLinkedListNode getHead1() {
        final Solution.DoublyLinkedListNode head = new Solution.DoublyLinkedListNode(1);

        final Solution.DoublyLinkedListNode two = new Solution.DoublyLinkedListNode(2);
        head.next = two;
        two.prev = head;

        final Solution.DoublyLinkedListNode three = new Solution.DoublyLinkedListNode(3);
        two.next = three;
        three.prev = two;

        final Solution.DoublyLinkedListNode four = new Solution.DoublyLinkedListNode(4);
        three.next = four;
        four.prev = three;

        return head;
    }

}
