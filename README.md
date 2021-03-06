# Test cases

---
## DequeNode TestCases
### Exceptions
Item = null - Exception
### Set
Setting different values to a single node -> setItem() -> changes the item of the node

---
--Size = 1

- Size=1 - getItem() -> Returns Same Item
- Size=1 - getNext() -> Returns Same Item
- Size=1 - getPrevious() -> Returns Same Item
- Size=1 - isFirstNode() -> True
- Size=1 - isLastNode() -> True
- Size=1 - isNotATerminalNode() -> False
---
--Size = 2
--Item Position = first

- Size=2 - getItem() -> Returns the Same Item
- Size=2 - getNext() -> Returns the last Item of the list (next one)
- Size=2 - getPrevious() -> Returns Exception
- Size=2 - isFirstNode() -> True
- Size=2 - isLastNode() -> False
- Size=2 - isNotATerminalNode() -> False
---
--Item Position = second

- Size=2 - getItem() -> Exception
- Size=2 - getNext() -> Returns the last Item of the list (next one)
- Size=2 - getPrevious() -> Returns Exception
- Size=2 - isFirstNode() -> True
- Size=2 - isLastNode() -> False
- Size=2 - isNotATerminalNode() -> False
---
--Size = 3
--Item Position = First

- Size=3 - getItem() -> Returns the Same Item
- Size=3 - getNext() -> Returns the middle Item of the list (next one)
- Size=3 - getPrevious() -> Returns Exception
- Size=3 - isFirstNode() -> True
- Size=3 - isLastNode() -> False
- Size=3 - isNotATerminalNode() -> False

--Item Position = Second

- Size=3 - getItem() -> Returns the Same Item
- Size=3 - getNext() -> Returns the last Item of the list (next one)
- Size=3 - getPrevious() -> Returns the first element
- Size=3 - isFirstNode() -> False
- Size=3 - isLastNode() -> False
- Size=3 - isNotATerminalNode() -> True

--Item Position = Third

- Size=3 - getItem() -> Returns the Same Item
- Size=3 - getNext() -> Returns exception
- Size=3 - getPrevious() -> Returns the middle element
- Size=3 - isFirstNode() -> False
- Size=3 - isLastNode() -> True
- Size=3 - isNotATerminalNode() -> False

---
## DoubleLinkedListQueueTest
### Append
Appending the queue increases it's size - append() -> queue size increases
Appending the queue with a null item - append () -> returns RuntimeException
### LeftAppend
Appending the queue increases it's size - leftAppend() -> queue size increases
Appending the queue with a null item - leftAppend() -> returns RuntimeException
### DeleteFirst
Deleting an element reduces the size of the queue - deleteFirst() -> reduces the size
Deleting an element from an empty queue - deleteFirst() -> returns RuntimeException
### DeleteLast
Deleting an element reduces the size of the queue - deleteLast() -> reduces the size
Deleting an element from an empty queue - deleteLast() -> returns RuntimeException
### PeekFirst
PickFirst returns the first element of the queue - peekFirst() -> returns the first element
PickFirst returns null when the queue is empty - peekFirst() -> returns null
### PeekFirst
PickLast returns the last element of the queue - peekLast() -> returns the last element
PickFirst returns null when the queue is empty - peekLast() -> returns null
### IsEmpty
isEmpty returns the actual size of a non-empty queue - isEmpty() -> returns the size of the queue
### GetAt
Getting a non-element from an empty queue with the position 0 - getAt() -> returns RuntimeException
Passing an argument bigger than the size of queue in the function GetAt - getAt() -> returns RuntimeException
Getting an item with a concrete position located in the queue - getAt() -> returns the item located at that position
### Find
Finding an element from an empty queue - find() -> returns Null
Finding a non-existent from a queue - find() -> returns Null
Finding all the elements from a queue - delete() -> returns all the elements
### Delete
Deleting an element from an empty queue - delete() -> returns RuntimeException
Deleting a non existent from a queue - delete() -> returns RuntimeException
Deleting an element from a queue - delete() -> removes the element from the queue
Deleting an element from the queue - delete() -> size of the queue reduces
### Sort
Function Sort converts the queue into an ascending one - Sort() -> converts the queue into a sorted one
Function Sort converts the queue into a descending one - Sort() -> converts the queue into a sorted one
