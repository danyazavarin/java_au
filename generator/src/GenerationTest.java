import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class GenerationTest {
    public static final String RESULT = "# LinkedList\n" +
            "\n" +
            "+ [Reverse Linked List](#reverse-linked-list)\n" +
            "\n" +
            "<!---Comment-->\n\n" +
            "## Reverse Linked List\n\n" +
            "https://leetcode.com/problems/reverse-linked-list/\n\n" +
            "``` java\n" +
            "def reverseList(self, head):\n" +
            "    while head != None:\n" +
            "        prev = head\n" +
            "        head = n_node\n" +
            "    return prev\n" +
            "```\n\n";
    public static final String SOLUTION = "206. Reverse Linked List\n" +
            "https://leetcode.com/problems/reverse-linked-list/\n" +
            "Class Solution:\n" +
            "    def reverseList(self, head):\n" +
            "        while head != None:\n" +
            "            prev = head\n" +
            "            head = n_node\n" +
            "        return prev";
    public static final String PATH = "C:\\Users\\Даниил\\IdeaProjects\\java_au\\src\\array.md";
    public static final String TWO_SOLUTIONS_TOGETHER = "# LinkedList\n" +
            "\n" +
            "+ [Reverse Linked List](#reverse-linked-list)\n" +
            "+ [Reverse Linked List](#reverse-linked-list)\n" +
            "\n" +
            "<!---Comment-->\n\n" +
            "## Reverse Linked List\n\n" +
            "https://leetcode.com/problems/reverse-linked-list/\n\n" +
            "``` java\n" +
            "def reverseList(self, head):\n" +
            "    while head != None:\n" +
            "        prev = head\n" +
            "        head = n_node\n" +
            "    return prev\n" +
            "```\n\n" +
            "# LinkedList\n\n" +
            "https://leetcode.com/problems/reverse-linked-list/\n\n" +
            "``` java\n" +
            "def reverseList(self, head):\n" +
            "    while head != None:\n" +
            "        prev = head\n" +
            "        head = n_node\n" +
            "    return prev\n" +
            "```\n\n";
    @Test
    void testWithEmptyMD(){
        assertEquals(RESULT, Generation.getNewContent(SOLUTION, "", PATH));
    }
    @Test
    void testWithNonEmptyMD(){
        String oldFileContent = Generation.getNewContent(SOLUTION, "", PATH);
        oldFileContent = Generation.getNewContent(SOLUTION, oldFileContent, PATH);
        assertEquals(TWO_SOLUTIONS_TOGETHER, oldFileContent);
    }
} 