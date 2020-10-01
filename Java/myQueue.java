
public class myQueue<E>
{
	Node<E> head,rear;
	public void enqueue(E e)
	{
		Node<E> toAdd=new Node<E>(e);
		if(head==null)
			head=rear=toAdd;
		else
		{
			rear.next=toAdd;
			rear=rear.next;
		}
	}
	public  void dequeue()
	{
		if(head==null)
		{
			System.out.println("cant remove from empty queue");
			System.exit(0);
		}
		else if(head==rear)
		{
			head=rear=null;

		}
		else
		{
			head=head.next;
		}
	}
	public void peek()
	{
		if(head==null)
		{
			System.out.println("empty queue");
		}
		else
			System.out.println(head.data +" ");
	}
	public void print()
	{
		Node<E> temp=head;
		if(head==null)
			System.out.println("queue is empty");
		else
		{
			while(temp!=rear)
			{
				System.out.print(temp.data+"  ");
				temp=temp.next;
			}
			System.out.println(temp.data);

		}
	}

	static  class Node<E>
	{
		E data;
		Node<E> next;
		public Node(E data){
			this.data=data;
			this.next=null;
		}
	}
}
