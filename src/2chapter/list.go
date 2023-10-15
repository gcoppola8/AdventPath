package gclist

import "fmt"

type Node struct {
	data int
	next *Node
}

type LinkedList struct {
	head   *Node
	length int
}

func (l *LinkedList) insert(data int) {
	l.head = insert(l.head, data)
	l.length++
}

func insert(head *Node, data int) *Node {
	newNode := &Node{data, nil}

	if head == nil {
		return newNode
	}

	newNode.next = head
	return newNode

}

func (l *LinkedList) delete(data int) {
	l.head = delete(l.head, data)

	l.calcLength()
}

func (l *LinkedList) calcLength() {
	curr := l.head
	l.length = 0

	for curr != nil {
		l.length++
		curr = curr.next
	}
}

func delete(head *Node, data int) *Node {

	if head == nil {
		return nil
	}

	if head.data == data {
		return delete(head.next, data)
	}

	head.next = delete(head.next, data)

	return head
}

func (l *LinkedList) removeDuplicates() {
	m := make(map[int]int)

	curr := l.head
	prev := l.head

	for curr != nil {
		m[curr.data]++

		if m[curr.data] > 1 {
			prev.next = delete(curr, curr.data)
		}

		prev = curr
		curr = curr.next
	}

	l.calcLength()
}

func (l *LinkedList) NthToLast(n int) int {
	_, result := nthToLast(l.head, n)

	return result
}

func nthToLast(head *Node, n int) (index int, result int) {
	if head == nil {
		return 0, -1
	}

	i, result := nthToLast(head.next, n)
	i = i + 1

	if i == n {
		fmt.Printf("%dth to last node is %d\n", n, head.data)
		return i, head.data
	}

	return i, result
}

func (l *LinkedList) deleteMiddle(node *Node) {
	curr := l.head
	prev := l.head

	for curr != nil {

		if curr == node {
			prev.next = curr.next
			curr.next = nil
		}

		prev = curr
		curr = curr.next
	}

	l.length--
}

func merge(left *LinkedList, right *LinkedList) *LinkedList {

	curr := left.head

	for curr.next != nil {
		curr = curr.next
	}

	curr.next = right.head

	return left
}

func (l *LinkedList) partition(pivot int) *LinkedList {
	left := &LinkedList{nil, 0}
	right := &LinkedList{nil, 0}

	curr := l.head

	for curr != nil {
		if curr.data <= pivot {
			left.head = insert(left.head, curr.data)
		} else {
			right.head = insert(right.head, curr.data)
		}

		curr = curr.next
	}

	return merge(left, right)
}

func (l *LinkedList) String() string {
	curr := l.head
	s := ""

	for curr != nil {
		s += fmt.Sprintf("%d -> ", curr.data)
		curr = curr.next
	}

	return s[:len(s)-4]
}

func (l *LinkedList) Reverse() {
	buff := &LinkedList{nil, 0}

	curr := l.head

	for curr != nil {

		buff.insert(curr.data)

		curr = curr.next
	}

	l.head = buff.head
}

func sumLists(l1 *LinkedList, l2 *LinkedList) *LinkedList {
	result := &LinkedList{nil, 0}

	curr1 := l1.head
	curr2 := l2.head

	carry := 0

	for curr1 != nil || curr2 != nil {
		n := 0

		if curr1 != nil {
			n += curr1.data
			curr1 = curr1.next
		}

		if curr2 != nil {
			n += curr2.data
			curr2 = curr2.next
		}

		n += carry

		if n >= 10 {
			carry = 1
			n %= 10
		} else {
			carry = 0
		}

		result.insert(n)
	}

	result.Reverse()

	return result
}

func sumListsRec(l1 *Node, l2 *Node, carry int) *Node {
	if l1 == nil && l2 == nil && carry == 0 {
		return nil
	}

	n := carry
	if l1 != nil {
		n += l1.data
		l1 = l1.next
	}

	if l2 != nil {
		n += l2.data
		l2 = l2.next
	}

	carry = n / 10
	n %= 10

	return &Node{n, sumListsRec(l1, l2, carry)}

}
