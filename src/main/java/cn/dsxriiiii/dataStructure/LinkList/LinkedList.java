package cn.dsxriiiii.dataStructure.LinkList;

public class LinkedList<E> {
    Node<E> _head; //链表头节点
    int _size;//链表长度大小

    public LinkedList() {
        this._head = null;
        this._size = 0;//构造函数初始化
    }
    public void addNode(E data) {
        Node<E> newNode = new Node<>(data);//构建新节点
        if (_head == null) {   //判断头节点是否为空
            _head = newNode;   //如果为空，将新节点赋值给_head，即_head节点指向newNode
        } else {
            Node<E> current = _head;   //当前节点从_head出发
            while (current.next != null) {  //最终current节点停留在最后一个节点，此时current.next为空，就要防止空指针异常
                current = current.next;
            }
            current.next = newNode;//将current指向新的节点
            newNode.pre = current;//将新节点的pre指针指向当前节点
        }
        _size++;
    }
    public void addAtHead(E data){
        Node<E> newNode = new Node<>(data);//构建新节点
        newNode.next = _head;//更新节点指向
        if (_head != null) { //链表不为空时
            _head.pre = newNode;//设置前置节点
        }
        _head = newNode;//此时当前节点的值就是头节点
        newNode.pre = null;//头节点前置一般为null
        _size++;//增加链表长度
    }
    public void addAtLast(E data){
        Node<E> newNode = new Node<>(data);//构建新节点
        if(_head == null){
            _head = newNode;//如果链表为空，新节点就是头节点
        }else {
            Node<E> current = _head;
            while (current.next != null) {
                current = current.next;//从头节点遍历到最后一个节点
            }
            current.next = newNode;
            newNode.pre = current;//修改新节点的两个指向
        }
        _size++;//增加链表长度
    }
    public void addAtIndex(int index,E data){
        if (index < 0 || index > _size){  //首先查看index坐标有没有超过限定位置，index > _size，如果在_size节点插入就是插入尾节点
            throw new IndexOutOfBoundsException("Invalid index provided");
        }else if(_head == null){
            _head = new Node<>(data);//要先判断链表是否为空，否则在以下的代码会出现空指针异常
        }else{
            if(index == 0){
                this.addAtHead(data);//如果是在0号位置插入就是在头节点插入
            }else if(index == _size){
                this.addAtLast(data);//尾节点插入
            }else{
                Node<E> newNode = new Node<>(data);
                Node<E> current = _head;//从head头节点开始遍历
                while(index != 0){
                    current = current.next;
                    index--;  //利用index不断变少的规则，实现插入节点位置的不断变更
                }
                newNode.next = current.next;
                newNode.pre = current;  //修改指针的指向
                if(current.next != null){
                    current.next.pre = newNode;//每次设置pre前置指针的时候都要判断是否为空
                }
                current.next = newNode;
                _size++;
            }
        }

    }
    public void deleteNode( int index){
        if(_head == null || index < 0 || index > _size - 1){
            throw new IndexOutOfBoundsException("INDEX ERROR!");
        }else {
            if (index == 0) {
                if (_head.next != null) { //当要删除第一个节点时，链表可能只有一个节点
                    _head = _head.next;  //如果不为空，那么head的下一个节点就会继承head指针
                    _head.pre = null;
                } else {  //如果链表只有一个节点，那么直接将head赋值为空即可
                    _head = null;
                }
            } else {
                Node<E> current = _head;
                while (index > 1) {  //index = 0时会停止
                    index--;
                    current = current.next;
                }
                if (current == null || current.next == null) {
                    _size--;
                    return;
                }
                current.next = current.next.next;  //执行删除操作，也就是操作
                if (current.next != null){
                    current.next.pre = current;  //每次设置pre前置指针的时候都要判断是否为空
                }
                System.out.println("第" + index + "个节点删除成功");
            }
        }
        _size--;
    }
    public void deleteByBackCount(int num){  //删除倒数第num个节点
        Node<E> dummyHead = new Node<>(null);
        dummyHead.next = _head;
        Node<E> fastNode = dummyHead;//使用快慢指针实现
        Node<E> slowNode = dummyHead;//快指针先走num+1个位置
        for (int i = 0; i <= num && fastNode != null; i++) {
            /*
            * 在代码中，第一个循环将快指针 fastNode 移动到距离链表头部 (index + 1) 个节点的位置。
            * 但是，第二个循环中需要修改条件以确保当 fastNode 到达链表末尾时，slowNode 恰好指向待删除节点的前一个节点
            * */
            fastNode=fastNode.next;
        }
        while(fastNode != null){  //快慢指针一起走
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        if (slowNode.next !=null) {  //空指针异常处理
            slowNode.next = slowNode.next.next;  //执行删除操作，将节点覆盖掉
            if(slowNode.next.next != null){
                slowNode.next.next.pre = slowNode;  //每次设置pre前置指针的时候都要判断是否为空
            }
        }
        _size--;
    }
    public E getDataByIndex(int index){
        //根据下标查找节点
        if (index < 0 || index > _size - 1 || _head == null){
            throw new IndexOutOfBoundsException("Invalid index provided");  //判断下标是否合理
        }else{
            Node<E> current = _head;
            while(current.next != null && index > 1){
                // 指针从头节点出发,那么第一个节点的index值就为1，查找第二个节点就只会让current向前走一步
                // 类似的查找第三个节点就只会走两步，那么 满足的条件为index - 1 > 0;index-1就是这个原因
                index--;
                current = current.next;
            }
            return current.data;
        }
    }
    public void printLinkedList(){
        Node<E> current = _head;
        if(_head == null){
            System.out.println("当前链表为空");
        }
        System.out.println();
        while(current != null){
            System.out.print("Node_" + current.data + " ");
            current = current.next;//从头向后遍历，直到尾节点，将每个节点的data值打出来，类型为E
        }
        System.out.println();
    }
    public void reverseList(){  //将链表反转
        if(_head == null){
            System.out.println("链表为空");
            return;  //如果链表为空那么就反转不了
        }
        Node<E> temp;
        Node<E> current = _head;
        Node<E> preNode = null;//在最开始的阶段 pre = 前置节点(1) current = 当前节点(2) temp = 下一节点(3)
        while(current!= null){
            temp = current.next;  //先将下一节点(3)保存好到temp中
            current.next = preNode;  //current(2)的下一个节点指向前置节点(1) 而不是修改下一节点(3)的指向
            preNode = current;  //相当于移动current,更新current指针的位置
            current = temp;  //相当于移动temp,更新temp指针的位置
        }
        _head = preNode;  //最后不要忘记将头指针指向头节点，也就是没有更新之前的尾节点
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        //添加节点
        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);
        linkedList.addNode(4);
        linkedList.addAtHead(0);//头部添加节点
        linkedList.addAtLast(9);//尾部添加节点
        System.out.println("根据坐标查找链表节点的值为" + linkedList.getDataByIndex(2));
        linkedList.addAtIndex(0,100);
        System.out.print("0号位置插入节点Node_100后的链表为");
        linkedList.printLinkedList();
        linkedList.deleteNode(0);
        System.out.print("0号位置删除节点Node_100后的链表为");
        linkedList.printLinkedList();
        linkedList.deleteByBackCount(2);
        System.out.print("删除倒数第2个后的链表为");
        linkedList.printLinkedList();
        System.out.print("反转后的链表为");
        linkedList.reverseList();
        linkedList.printLinkedList();
        System.out.println();
        System.out.println("链表长度为：" + linkedList._size);

    }
}
