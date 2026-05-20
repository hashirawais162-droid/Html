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
        return sb.toString();
    }

    public void fixHTML() {
        Stack<HTMLTag> stack = new Stack<>();
        Queue<HTMLTag> fixed = new LinkedList<>();
    
        while (!tags.isEmpty()) {
            HTMLTag current = tags.remove();

            if (current.isSelfClosing()) {
                fixed.add(current);
            }

            else if (current.isOpening()) {
                fixed.add(current);
                stack.push(current);
            }

            else if (current.isClosing()) {

                if (stack.isEmpty()) {
                    continue; // discard invalid closing tag
                }

                HTMLTag top = stack.peek();

                if (top.matches(current)) {
                    fixed.add(current);
                    stack.pop();
                } else {
                    fixed.add(stack.pop().getMatching());
                }
            }
        }

        while (!stack.isEmpty()) {
            fixed.add(stack.pop().getMatching());
        }

        tags = fixed;
    }   
}

   


  
