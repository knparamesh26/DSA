#include<iostream>
#include<queue>
using namespace std;

struct node{
    int data;
    node *left;
    node *right;
};

node *root = NULL;

node*  makenew_node(int new_data){

    node *new_node = new node;
    new_node->data = new_data;
    new_node->left = new_node->right = NULL;
    return new_node;

}

node* insert(node *root, int new_data){
    if( root == NULL ){
        root = makenew_node(new_data);
        return root;
    }
    else if( new_data == root->data ){
        //root->data = new_data;
        return root;
    }
    else if( new_data < root->data ){
        root->left = insert(root->left, new_data);
    }
    else if( new_data > root->data){
        root->right = insert(root->right, new_data);
    }

}

int find_height(node* root){
    
    if( root == NULL ){
        return -1;
    }

    return max(find_height(root->left), find_height(root->right)) + 1;
}

int  find_min( node* root ){

    node *itr = root;
    while( itr->left ){
        itr = itr->left;
    }

    return itr->data;

}


int find_max( node *root ){

    //iterative way
    node *itr = root;
    while( itr->right ){
        itr = itr->right;
    }
    return itr->data;
    // recursive way
    // node* itr = root;
    // if( root == NULL ){
    //     cout << "Tree empty" << endl;
    //     return 0;
    // }
    
    // else if( itr->right == NULL ){
    //     return itr->data;
    // }
    // find_max(itr->right);
}
 
void level_order(node* root){
    
    if( root == NULL ){
        cout << "Tree is empty" << endl;
        return ;
    }
    queue<node*> q;
    q.push(root);
    while( q.size()!=0 ){

        node* itr = q.front();
        cout << itr->data << " ";
        q.pop();
        if( itr->left!=NULL )
            q.push(itr->left);
        if( itr->right!=NULL )
            q.push(itr->right);

    }
    
}

void preorder( node* root ){

    if( root == NULL ) return;

        cout << root->data << " ";
        preorder( root->left );
        preorder( root->right );
    
}

void inorder( node* root ){
    if( root == NULL ) return;

        inorder( root->left );
        cout << root->data << " ";
        inorder( root->right );

}

void postorder( node* root ){

    if( root == NULL ) return;

        postorder( root->left );
        postorder( root->right );
        cout << root->data << " ";

}

bool search( node* root, int data){

    if( root == NULL) return false;
    else if( data == root->data ) return true;
    else if( data<=root->data ) return search(root->left, data);
    else return search(root->right, data);

}

vector<int> arr;
bool is_bst(node* root){

    if( root == NULL ){
        for(int i=1; i<arr.size(); ++i){
            if( arr[i]<arr[i-1] ){
                return false;
            }
        }
        return true;
    }
    is_bst(root->left);
    arr.push_back(root->data);
    is_bst(root->right);


}

int main(){

    root = insert(root, 2);
    root = insert(root, 1);
    root = insert(root, 3);
    root = insert(root, 4);
    root = insert(root, 53);
    root = insert(root, 53);
    root = insert(root, 15);
    root = insert(root, 67);
    root = insert(root, 100);
    root = insert( root, 1);
    root = insert(root, 3);
    inorder( root );
    // preorder( root );
    // cout << endl;
    // inorder( root );
    // cout << endl;
    // postorder( root );
    // cout << endl;
    // if( is_bst(root) ) cout << "this is a binary tree";
    // else cout << "this is not a binary tree";

}

