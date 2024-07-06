



collection ( i,e data structure) is a group of objects that are stored in a single unit. 
Java Collections are used to store, retrieve, manipulate, and communicate aggregate data. 

------------------------------------------------------------
types of collections in java:
------------------------------------------------------------

1. List
    - index based
    - duplicate elements
    - ordered

2. Set
    - no duplicate elements
    - ordered / unordered 

3. Map
    - key value pair
    - key is unique
    - value can be duplicate

------------------------------------------------------------
Collection Framework:
------------------------------------------------------------

Collection Framework is a unified architecture for representing and manipulating collections.


java.util.*

Collection
    - List
        - ArrayList ( dynamic array)
        - LinkedList ( doubly linked list)
        - Vector ( dynamic array) -> synchronized
        - Stack extends Vector -> synchronized ( LIFO)
    - Set
        - HashSet  ( hash table) -> unordered
        - LinkedHashSet ( hash table + linked list) -> ordered
        - TreeSet ( red-black tree) -> sorted
    - Queue ( FIFO)
        - PriorityQueue ( heap) -> sorted
        - Deque
            - ArrayDeque ( dynamic array) -> double ended queue

Map
  - HashMap ( hash table) -> unordered
  - LinkedHashMap ( hash table + linked list) -> ordered
  - TreeMap ( red-black tree) -> sorted
  - HashTable ( hash table) -> synchronized
  - Properties ( hash table) -> key value pair


------------------------------------------------------------

 -> declarative style of programming with Lambda expressions
 -> streams api for data processing with lambda expressions
  
------------------------------------------------------------