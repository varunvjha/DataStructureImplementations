"""
Implementation of the Queue abstract data structure in Python (as a collection of nodes)
"""

# the Node class acts as a base class for the implementation of nodes 
# in the queue
class Node:
    def __init__(self, value=None):
        """Initialises a node"""
        self.value = value
        self.next = None

class Queue:
    def __init__(self):
        self.top = None
        self.bottom = None

    def isEmpty(self):
        """returns True if queue is populated, False otherwise"""
        return bool(self.top) and bool(self.bottom)

    def dequeue(self):
        """removes the first item to enter the queue (top)"""
        if self.top:
            value = self.top.value
            self.top = self.top.next
            return value

        raise Exception("Cannot dequeue an empty queue")

    def enqueue(self, value):
        """adds item to the bottom of the queue"""
        node = Node(value)
        if self.top:
            self.bottom.next = node
        else:
            self.top = node

        self.bottom = node

    def size(self):
        """returns the number of nodes (item) in the queue"""
        node = self.top

        if node:
            num_nodes = 1
        else:
            return 0

        node = node.next
        while node:
            num_nodes += 1
            node = node.next
        
        return num_nodes

    def peek(self):
        """returns last item to enter the queue (bottom of the queue)"""
        return self.bottom.value



# # example 
# queue = Queue()
# for i in range(10):
#     queue.enqueue(i)
# print(queue.size())   # should print 10
# print(queue.peek())   # should print 9
# print(queue.dequeue())   # should print 0
# print(queue.size())   # should print 9
# print(queue.peek())   # should print 9
