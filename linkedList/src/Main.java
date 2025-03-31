

class  main{

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append(10);
        list.append(20);
        list.append(30);
        list.prepend(5);

        System.out.println("Linked List after adding elements:");
        list.traverse(); // Output: 5 -> 10 -> 20 -> 30 -> null

        list.delete(20);
        System.out.println("Linked List after deleting 20:");
        list.traverse(); // Output: 5 -> 10 -> 30 -> null

        System.out.println("Found 10? " + list.search(10));
        System.out.println("Found 50? " + list.search(50));
    }
}
