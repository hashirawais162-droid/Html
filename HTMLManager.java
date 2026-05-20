import java.util.*;

public class HTMLManager {
    private Queue<HTMLTag> tags;

    public HTMLManager(Queue<HTMLTag> html) {
        if (html == null) {
            throw new IllegalArgumentException("Queue cannot be null");
        }

        tags = new LinkedList<>();

        for (HTMLTag tag : html) {
            tags.add(tag);
        }
    }

 public Queue<HTMLTag> getTags() {
        return tags;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = tags.size();

        for (int i = 0; i < size; i++) {
            HTMLTag tag = tags.remove();
            sb.append(tag.toString().trim());
            tags.add(tag);
        }
        return sb.toSring();

        return sb.toString();
    }

  
