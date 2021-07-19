import java.util.EmptyStackException;

class StackasList implements Stack {

    Node topNode;
    int size;
    String showContents="";

    public StackasList()
    {
        size=0;
        topNode=null;
    }


    @Override
    public int getSize()
    {
        return size;
    }


    @Override
    public void push(Object element)
    {
        topNode = new Node(element,topNode);
        size++;
        showContents += element;
    }

    @Override
    public Object pop()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        Node oldTop = topNode;
        topNode = topNode.getNext();
        size--;
        return oldTop.getData();

    }

    @Override
    public boolean isEmpty()
    {
        if(size != 0) {return false;} else {return true;}
    }

    @Override
    public Object peek() {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        return topNode.getData() ;
    }


    @Override
    public String toString()
    {
        String reverse ="";
        for (int i =size; i>0 ;i--)
        {
            reverse += "["+showContents.charAt(i-1)+"]"+"\n";
        }
        return reverse;
    }





    private class Node<T>
    {

        T data;
        Node next;

        public Node(T data, Node<T> next)
        {
            this.data= data;
            this.next=next;
        }

        public Node(T data)
        {
            this.data= data;
        }




        public Node getNext()
        {
            return next;
        }
        public T getData()
        {
            return data;
        }

    }


}