import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class MarkdownEntityTest {
    public static final String TITLE = "Reverse Linked List";
    public static final String URL = "https://leetcode.com/problems/reverse-linked-list/";
    public static final String SOLUTION = "```java\n" +
            "while head != None:\n" +
            "    prev = head\n" +
            "    head = n_node\n" +
            "return prev\n```";
    public static final String SOLUTION_2 = "206. Reverse Linked List\n" +
            "https://leetcode.com/problems/reverse-linked-list/\n" +
            "Class Solution:\n" +
            "    def reverseList(self, head):\n" +
            "        while head != None:\n" +
            "            prev = head\n" +
            "            head = n_node\n" +
            "        return prev";
    public static final String FORMATTED_CODE = "## Reverse Linked List\n" +
            "\n" +
            "https://leetcode.com/problems/reverse-linked-list/\n\n" +
            "```java\n" +
            "while head != None:\n" +
            "    prev = head\n" +
            "    head = n_node\n" +
            "return prev\n" +
            "```";
    public static final String RESULT_TITLE = "+ [Reverse Linked List](#reverse-linked-list)";
    public static final String FORMATTED_RESULT = "## " + TITLE + "\n\n" + URL + "\n\n" + SOLUTION;
    @Test
    void testGetTitle(){
        assertEquals(RESULT_TITLE, new MarkdownEntity(TITLE, URL, SOLUTION).getTitle());
    }
    @Test
    void testGetFormattedCode(){
        assertEquals(FORMATTED_CODE, new MarkdownEntity(TITLE, URL, SOLUTION).getFormatted());
    }
    @Test
    void testParseEntity(){
        MarkdownEntity res = MarkdownEntity.parseEntity(SOLUTION_2);
        assertEquals(new MarkdownEntity(TITLE, URL, SOLUTION), res);
    }
} 