import java.util.*;

public class BasicQueue{
    public static class Queue{
        static int arr[];
        static int size;
        static int rear;
        static int front;
        Queue(int n){
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }
        //isEmpty
        public boolean isEmpty(){
            return rear == -1 && front == -1;
        }
        //isFull
        public boolean isFull(){
            return (rear+1)%size == front;
        }
        //Add
        public void add(int data){
            if(isFull()){
                System.out.print("Queue is full!");
                return;
            }
            rear = (rear+1)%size;
            if(front == -1) front++; //when we add first element
            arr[rear] = data;
        }
        //Remove
        public int remove(){
            if(isEmpty()){
                System.out.print("Queue is empty!");
                return -1;
            }
            int remove = arr[front];
            if(front == rear){
                front = rear = -1;
            }else{
                front = (front+1)%size;
            }
            return remove;
        }
        //Peek
        public int peek(){
            if(isEmpty()){
                System.out.print("Queue is empty!");
                return -1;
            }
            return arr[front];
        }
        //Print Queue
        public void printQ(){
            while(!isEmpty()){
                System.out.println(remove()+" ");
            }
        }
    }
    public static void main(String[] args){
        Queue q = new Queue(6);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.remove();
        q.printQ();
    }
}