# Stacks and Queues

# 堆（Stacks）

一个stack就是先入先出（FIFO）的。

方法：push和pop

stack有两种实现方式

第一种：链表（linked-list implementation）

每一个node存储一个item值，还有一个指向下一个节点的指针，也就是一个`node`里面包含`node.item`和`node.next`。

第二种：数组（array implementation）

先构造一个数组，那么这个数组就是一个stack，缺点是长度固定，如果需要存储的node数量超过了数组长度，那么就不好搞了。



