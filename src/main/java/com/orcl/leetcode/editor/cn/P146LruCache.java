//请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。 
//
// 实现 LRUCache 类： 
//
// 
// 
// 
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 
//key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 
// 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
// 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 10⁵ 
// 最多调用 2 * 10⁵ 次 get 和 put 
// 
// Related Topics 设计 哈希表 链表 双向链表 👍 2032 👎 0

package com.orcl.leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @description: P146 LRU 缓存
 * @date: 2022-03-21 14:39:28
 * @author: orcl
 */
public class P146LruCache {
    public static void main(String[] args) {
        LRUCache lRUCache = new P146LruCache().new LRUCache(1);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1); // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2); // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1); // 返回 -1 (未找到) lRUCache.get(3); // 返回 3
        lRUCache.get(4); // 返回 4
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache2 {

        private HashMap<Integer, Node> map;

        private DoubleList cache;

        private int cap;

        public LRUCache2(int capacity) {
            this.cap = capacity;
            map = new HashMap<>();
            cache = new DoubleList();
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            // 将数据提升为最近使用的
            makeRecently(key);
            return map.get(key).val;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                // 删除旧的数据
                deleteKey(key);
                // 新插入的数据为最近使用的数据
                addRecently(key, value);
                return;
            }

            if (cap == cache.size) {
                removeLeastRecently();
            }
            addRecently(key, value);
        }

        /**
         * 将某个 key 提升为最近使用的
         *
         * @param key
         */
        private void makeRecently(int key) {
            Node x = map.get(key);
            // 先从链表中删除这个节点
            cache.remove(x);
            // 重新插到队尾
            cache.addLast(x);
        }

        /**
         * 添加最近使用的元素
         *
         * @param key
         * @param val
         */
        private void addRecently(int key, int val) {
            Node x = new Node(key, val);
            // 链表尾部就是最近使用的元素
            cache.addLast(x);
            // 在 map 中添加 key 的映射
            map.put(key, x);
        }

        /**
         * 删除某一个 key
         *
         * @param key
         */
        private void deleteKey(int key) {
            Node x = map.get(key);
            // 从链表中删除
            cache.remove(x);
            // 从map中删除
            map.remove(key);
        }

        /**
         * 删除最久未使用的元素
         */
        private void removeLeastRecently() {
            // 链表头部的第一个元素就是最久未使用的
            Node deletedNode = cache.removeFirst();
            // 同时从 map 中删除它的 key
            int deletedKey = deletedNode.key;
            map.remove(deletedKey);
        }

        class Node {
            public int key, val;

            public Node next, prev;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        class DoubleList {
            /**
             * 头尾虚节点
             */
            private Node head, tail;

            /**
             * 链表元素
             */
            private int size;

            public DoubleList() {
                head = new Node(0, 0);
                tail = new Node(0, 0);
                head.next = tail;
                tail.prev = head;
                size = 0;
            }

            /**
             * 在链表尾部添加节点x，时间O(1)
             *
             * @param x
             */
            public void addLast(Node x) {
                x.prev = tail.prev;
                x.next = tail;
                tail.prev.next = x;
                tail.prev = x;
                size++;
            }

            /**
             * 删除链表中的 x 节点（x 一定存在），由于是双链表且给的目标是 Node 节点，时间O(1)
             *
             * @param x
             */
            public void remove(Node x) {
                x.prev.next = x.next;
                x.next.prev = x.prev;
                size--;
            }

            /**
             * 删除链表中第一个节点，并返回该节点，时间O(1)
             *
             * @return
             */
            public Node removeFirst() {
                if (head.next == tail) {
                    return null;
                }
                Node first = head.next;
                remove(first);
                return first;
            }

            /**
             * 返回链表的长度，时间O(1)
             *
             * @return
             */
            public int size() {
                return size;
            }
        }
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */

    class LRUCache {
        int                             capacity;
        LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!cache.containsKey(key)) {
                return -1;
            }
            makeRecently(key);
            return cache.get(key);
        }

        public void put(int key, int val) {
            if (cache.containsKey(key)) {
                cache.put(key, val);
                makeRecently(key);
                return;
            }

            if (cache.size() >= this.capacity) {
                Integer oldestKey = cache.keySet().iterator().next();
                cache.remove(oldestKey);
            }
            cache.put(key, val);
        }

        private void makeRecently(int key) {
            Integer val = cache.get(key);
            // 删除 key ，重新插入到队尾
            cache.remove(key);
            cache.put(key, val);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}