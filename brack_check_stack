#include<iostream>
using namespace std;

char arr[50];
int size=0;
class Stack{
    public:
        void push(char data){
            arr[size] = data;
            size++;
        }

        void pop(){
            size--;
        }

        bool isempty(){
            if( size==0 ) return true;
            else return false;
        }

        char top(){
            if( size==0 ) return 0;
            return arr[size-1];
        }

};

bool balanced(string exp){
    Stack s;
    for(int i=0; i<exp.size(); ++i){
        if( exp[i]=='[' || exp[i]=='{' || exp[i]=='(' ){
            s.push(exp[i]);
            continue;
        }

        if( s.isempty() ) return false;
        char temp;
        switch( exp[i] ){
            case ')':
                temp = s.top();
                s.pop();
                if( temp == '{' || temp == '[' ){
                    return false;
                }
                break;
                
            case '}':
                temp = s.top();
                s.pop();
                if( temp == '(' || temp == '[' ){
                    return false;
                }
                break;

            case ']':
                temp = s.top();
                s.pop();
                if( temp == '(' || temp == '{' ){
                    return false;
                }
                break;
        }
        
    }

    if( size!=0 ) return false;

    return true;

}

int main(){

    string ex;
    cin >> ex;
    if( balanced(ex) ){
        cout << "Brackets balanced" << endl;
    }
    else{
        cout << "Not balanced " << endl;
    }

}

