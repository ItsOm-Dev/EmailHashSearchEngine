package emailsearchengine;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DynamicHashTable {
    private final int[] bucketSizes = {10, 100, 1000};
    private List<Node[]> levels = new ArrayList<>();

    public DynamicHashTable() {
        for (int size : bucketSizes) {
            levels.add(new Node[size]);
        }
    }

    private int getHash(String encodedKey, int level) {
        int hash = 0;
        for (int i = 0; i < encodedKey.length(); i++) {
            hash = (hash * 31 + encodedKey.charAt(i)) % bucketSizes[level];
        }
        return hash;
    }

    public void insert(String email) {
        String encoded = CharEncoder.encode(email);
        for (int level = 0; level < levels.size(); level++) {
            int index = getHash(encoded, level);
            Node[] bucket = levels.get(level);

            if (bucket[index] == null) {
                bucket[index] = new Node(encoded, email);
                return;
            } else {
                Node current = bucket[index];
                while (current != null) {
                    if (current.encodedKey.equals(encoded)) return;
                    if (current.next == null) break;
                    current = current.next;
                }
                current.next = new Node(encoded, email);
                return;
            }
        }
    }

    public boolean search(String email) {
        String encoded = CharEncoder.encode(email);
        for (int level = 0; level < levels.size(); level++) {
            int index = getHash(encoded, level);
            Node current = levels.get(level)[index];
            while (current != null) {
                if (current.encodedKey.equals(encoded)) return true;
                current = current.next;
            }
        }
        return false;
    }

    public boolean delete(String email) {
        String encoded = CharEncoder.encode(email);
        for (int level = 0; level < levels.size(); level++) {
            int index = getHash(encoded, level);
            Node current = levels.get(level)[index];
            Node prev = null;
            while (current != null) {
                if (current.encodedKey.equals(encoded)) {
                    if (prev == null) {
                        levels.get(level)[index] = current.next;
                    } else {
                        prev.next = current.next;
                    }
                    return true;
                }
                prev = current;
                current = current.next;
            }
        }
        return false;
    }

    public void printAll() {
        System.out.println("Stored Emails:");
        for (Node[] bucket : levels) {
            for (Node node : bucket) {
                Node curr = node;
                while (curr != null) {
                    System.out.print("Encoded key: " + curr.encodedKey + "  Original: ");
                    System.out.println(CharEncoder.decode(curr.encodedKey));
                    curr = curr.next;
                }
            }
        }
    }

    public void exportToFile(String filename) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Node[] bucket : levels) {
                for (Node node : bucket) {
                    Node curr = node;
                    while (curr != null) {
                        writer.write(CharEncoder.decode(curr.encodedKey) + "\n");
                        curr = curr.next;
                    }
                }
            }
        }
    }
}
