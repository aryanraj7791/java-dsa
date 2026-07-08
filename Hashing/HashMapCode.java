import java.util.*;

public class HashMapCode{

    public static class HashMap<K,V> { //Generic

        private class Node{
            K key;
            V val;
            public Node(K key, V val){
                this.key = key;
                this.val = val;
            }
        }

        private int n; //n=Total nodes
        private int N; //buckets.length
        private LinkedList<Node> buckets[]; //N=buckets.length

        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i=0; i<4; i++){
                buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key){
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int searchInLL(K key, int bi){
            LinkedList<Node> ll = buckets[bi];
            for(int i=0; i<ll.size(); i++){
                Node node = ll.get(i);
                if(node.key == key) return i;
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash(){
            LinkedList<Node> oldBuck[] = buckets;
            buckets = new LinkedList[N*2];
            N = N*2;
            for(int i=0; i<N; i++){
                buckets[i] = new LinkedList<>();
            }
            for(int i=0; i<oldBuck.length; i++){
                LinkedList<Node> ll = oldBuck[i];
                while(!ll.isEmpty()){
                    Node node = ll.remove();
                    put(node.key,node.val);
                }
            }

        }

        public void put(K key, V val){ //TC->O(lambda)->O(1)
            //find bucket index
            int bi = hashFunction(key); // 0 to size-1
            int di = searchInLL(key,bi); // Valid idx if key exits in LL otherwise -1 to indicate key doesnot exits in LL

            if(di == -1){ //key doesn't exists in LL
                buckets[bi].add(new Node(key,val));
                n++;
            }else{ //key exists in LL
                Node node = buckets[bi].get(di);
                node.val = val; //update
            }

            //check for rehashing
            double lambda = (double)n/N;
            if(lambda > 2.0){
                rehash();
            }
        }

        public boolean containsKey(K key){ //TC->O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);
            if(di != -1){
                return true;
            }
            return false;
        }

        public V remove(K key){ //TC->O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);
            if(di != -1){
                Node node = buckets[bi].remove(di);
                n--;
                return node.val;
            }
            return null;
        }

        public V get(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);
            if(di != -1){
                Node node = buckets[bi].get(di);
                return node.val;
            }
            return null;
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for(int i=0; i<buckets.length; i++){
                LinkedList<Node> ll = buckets[i];
                for(int j=0; j<ll.size(); j++){
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty(){
            return n == 0;
        }

    }

    public static void main(String[] args){
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("India",100);
        hm.put("France",64);
        hm.put("Russia",215);
        hm.put("US",173);
        ArrayList<String> keys = hm.keySet();
        for(String key : keys){
            System.out.println(key);
        }
        System.out.println(hm.get("India"));
        System.out.println(hm.remove("India"));
        System.out.println(hm.get("India"));
    }
}