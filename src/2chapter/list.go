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
