package linkedlist.insertdoublylinked;

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
    public void shouldResult(Solution.DoublyLinkedListNode head, int data, String expectedListPrint) throws IOException {
        //given

        //when
        final Solution.DoublyLinkedListNode listHead = Solution.sortedInsert(head, data);

        //then
        final StringWriter sw = new StringWriter();
        final BufferedWriter bufferedWriter = new BufferedWriter(sw);
        Solution.printDoublyLinkedList(listHead, " ", bufferedWriter);
        bufferedWriter.flush();
        assertThat(sw.getBuffer().toString()).isEqualTo(expectedListPrint);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        getHead1(),
                        5,
                        "1 3 4 5 10"
                },
                new Object[] {
                        new Solution.DoublyLinkedListNode(8),
                        5,
                        "5 8"
                },
                new Object[] {
                        new Solution.DoublyLinkedListNode(3),
                        5,
                        "3 5"
                },
                new Object[] {
                        getHead2(),
                        1,
                        "1 2 3 4 10"
                },
                new Object[] {
                        getHead1(),
                        15,
                        "1 3 4 10 15"
                },
        };
    }

    private Solution.DoublyLinkedListNode getHead2() {
        final Solution.DoublyLinkedListNode head = new Solution.DoublyLinkedListNode(2);

        final Solution.DoublyLinkedListNode three = new Solution.DoublyLinkedListNode(3);
        head.next = three;
        three.prev = head;

        final Solution.DoublyLinkedListNode four = new Solution.DoublyLinkedListNode(4);
        three.next = four;
        four.prev = three;

        final Solution.DoublyLinkedListNode ten = new Solution.DoublyLinkedListNode(10);
        four.next = ten;
        ten.prev = four;

        return head;
    }

    private Solution.DoublyLinkedListNode getHead1() {
        final Solution.DoublyLinkedListNode head = new Solution.DoublyLinkedListNode(1);

        final Solution.DoublyLinkedListNode three = new Solution.DoublyLinkedListNode(3);
        head.next = three;
        three.prev = head;

        final Solution.DoublyLinkedListNode four = new Solution.DoublyLinkedListNode(4);
        three.next = four;
        four.prev = three;

        final Solution.DoublyLinkedListNode ten = new Solution.DoublyLinkedListNode(10);
        four.next = ten;
        ten.prev = four;
        
        return head;
    }

}
