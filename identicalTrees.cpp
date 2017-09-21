/* Check if two trees are identical. */
#include <iostream>

using namespace std;

typedef struct node {
    int data;
    struct node *left;
    struct node *right;
} Node;

bool isIdentical(Node *n1, Node *n2)
{
    if (n1 == NULL && n2 == NULL) {
        return true;
    } else if (n1 == NULL || n2 == NULL) {
        return false;
    } else if (n1->data != n2->data) {
        return false;
    }

    return isIdentical(n1->left, n2->left) && isIdentical(n1->right, n2->right);
}

int main()
{
	Node *r1, *r2;
	
	Node *n1 = new Node();
	n1->data = 5;
	n1->left = NULL;
	n1->right = NULL;
	r1 = n1;
	
	n1 = new Node();
	n1->data = 3;
	n1->left = NULL;
	n1->right = NULL;
	r1->left = n1;
	
	n1 = new Node();
	n1->data = 7;
	n1->left = NULL;
	n1->right = NULL;
	r1->right = n1;
	
	Node *n2 = new Node();
	n2->data = 5;
	n2->left = NULL;
	n2->right = NULL;
	r2 = n2;
	
	n2 = new Node();
	n2->data = 3;
	n2->left = NULL;
	n2->right = NULL;
	r2->left = n2;
	
	n2 = new Node();
	n2->data = 7;
	n2->left = NULL;
	n2->right = NULL;
	r2->right = n2;
	
	if (isIdentical(r1, r2)) {
		cout << "Identical" << endl;
	} else {
		cout << "Not identical" << endl;
	}
	
	return 0;
}