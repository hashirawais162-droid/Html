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

   
