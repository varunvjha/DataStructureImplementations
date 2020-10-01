#include <iostream>
using namespace std;

struct Node {
	int val;
	Node* next;
};

struct Edge {
	int src, dest;
};

class Graph
{

	Node* getAdjListNode(int dest, Node* head)
	{
		Node* newNode = new Node;
		newNode->val = dest;
		newNode->next = head;
		return newNode;
	}

	int N;

public:

	Node **head;

	// Constructor
	Graph(Edge edges[], int n, int N) {
		head = new Node*[N]();
		this->N = N;

		for (int i = 0; i < N; i++)
			head[i] = nullptr;

		for (unsigned i = 0; i < n; i++)
		{
			int src = edges[i].src;
			int dest = edges[i].dest;

			Node* newNode = getAdjListNode(dest, head[src]);

			head[src] = newNode;
		}
	}

	// Destructor
	~Graph() {
		for (int i = 0; i < N; i++)
			delete[] head[i];

		delete[] head;
	}
};

// print all neighboring vertices of given vertex
void printList(Node* ptr)
{
	while (ptr != nullptr)
	{
		cout << " -> " << ptr->val << " ";
		ptr = ptr->next;
	}
	cout << endl;
}