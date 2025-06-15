package emailsearchengine;

public class Node {
    String encodedKey;
    String originalEmail;
    Node next;

    Node(String encodedKey, String originalEmail) {
        this.encodedKey = encodedKey;
        this.originalEmail = originalEmail;
    }
}
