"""
Implementation of the Stack abstract data structure in Python (as a collection of nodes)
"""

# the Node class acts as a base class for the implementation of nodes 
# in the stack
class Node:
    def __init__(self, value=None):
        """Initialises a node"""
        self.value = value
        self.next = None

class Stack:
    def __init__(self):
        self.top = None

    def isEmpty(self):
        """returns True if Stack is populated, False otherwise"""
        return bool(self.top)

    def pop(self):
        """removes last element (the one at the top of the stack) and returns it"""
        node = self.top
        
        if node:
            self.top = node.next
            return node.value
        else:
             raise Exception("Cannot delete from empty stack")

    def push(self, value):
        """adds an item to the top of the stack"""
        node = Node(value)
        node.next = self.top
        self.top = node

    def size(self):
        """returns the number of nodes (item) in the stack"""
        node = self.top

        if node:
            num_nodes = 1
        else:
            return 0

        node = node.next

        # iterate through all nodes while incrementing num_nodes to 
        # track the number of nodes
        while node:
            num_nodes += 1
            node = node.next
        
        return num_nodes

    def peek(self):
        """returns last item to enter the stack (top of the stack)"""
        return self.top.value


# # example 
# stack = Stack()
# for i in range(10):
#     stack.push(i)
# print(stack.size())   # should print 10
# print(stack.peek())   # should print 9
# print(stack.pop())    # should print 9
# print(stack.size())   # should print 9
# print(stack.peek())   # should print 8
