import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class SolutionFileTest {
    public static final String MD_TITLE = "Reverse Linked List";
    public static final String MD_URL = "https://leetcode.com/problems/reverse-linked-list/";
    public static final String MD_Solution = "``` java\n" +
            "    def reverseList(self, head):\n" +
            "        while head != None:\n" +
            "            prev = head\n" +
            "            head = n_node\n" +
            "        return prev\n" +
            "```";
    public static final String NON_EMPTY_MD_FILE = "# LinkedList\n" +
            "\n" +
            "+ [Reverse Linked List](#reverse-linked-list)\n" +
            "\n" +
            "<!---Comment-->\n" +
            "## Reverse Linked List\n" +
            "https://leetcode.com/problems/reverse-linked-list/" +
            "``` java\n" +
            "    def reverseList(self, head):\n" +
            "        while head != None:\n" +
            "            prev = head\n" +
            "            head = n_node\n" +
            "        return prev\n" +
            "```\n";
    @Test
    void testNonEmptyMdFile(){
        SolutionFile res = SolutionFile.parseFile(NON_EMPTY_MD_FILE, FileType.MARKDOWN, "LinkedList");
        List<ItemEntity> lst = List.of(new MarkdownEntity(MD_TITLE, MD_URL, MD_Solution));
        assertEquals(new SolutionFile(lst, "# LinkedList\n"), res);
    }
    @Test
    void testEmptyMDFile(){
        SolutionFile res = SolutionFile.parseFile("", FileType.MARKDOWN, "LinkedList");
        List<ItemEntity> lst = List.of();
        assertEquals(new SolutionFile(lst, "# LinkedList\n"), res);
    }
} 