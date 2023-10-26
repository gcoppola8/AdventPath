package gclist

import (
	"reflect"
	"testing"
)

func TestLinkedList(t *testing.T) {
	l1 := LinkedList{nil, 0}

	if l1.length != 0 {
		t.Errorf("LinkedList length is %d instead of 0", l1.length)
	}

	l1.insert(1)
	l1.insert(2)
	l1.insert(3)
	l1.insert(4)
	l1.insert(5)
	l1.insert(6)
	l1.insert(7)

	if l1.length != 7 {
		t.Errorf("LinkedList length is %d instead of 7", l1.length)
	}
}

func TestDelete(t *testing.T) {
	l1 := LinkedList{nil, 0}

	l1.insert(1)
	l1.insert(2)
	l1.insert(3)
	l1.insert(7)
	l1.insert(5)
	l1.insert(6)
	l1.insert(7)
	l1.insert(7)
	l1.insert(7)

	l1.delete(5)

	if l1.length != 8 {
		t.Errorf("Error in deleting in head, length %d", l1.length)
	}

	l1.delete(7)

	if l1.length != 4 {
		t.Errorf("Error in deleting number 7 in head, length %d", l1.length)
	}

	curr := l1.head
	for curr != nil {

		if curr.data == 7 {
			t.Errorf("Error in deleting number 7, Number 7 found in the list")
		}

		curr = curr.next
	}

}

func TestRemoveDuplicates(t *testing.T) {
	l1 := LinkedList{nil, 0}

	l1.insert(1)
	l1.insert(2)
	l1.insert(3)
	l1.insert(7)
	l1.insert(5)
	l1.insert(6)
	l1.insert(7)
	l1.insert(7)
	l1.insert(7)

	l1.removeDuplicates()

	if l1.length != 6 {
		t.Errorf("Error in removing duplicates, length %d", l1.length)
	}

}

func TestNthToLast(t *testing.T) {
	l1 := LinkedList{nil, 0}

	l1.insert(1)
	l1.insert(5)
	l1.insert(8)
	l1.insert(7)
	l1.insert(5)
	l1.insert(6)
	l1.insert(-1)
	l1.insert(74)
	l1.insert(7)

	if l1.NthToLast(3) != 8 {
		t.Errorf("Error in NthToLast, value %d", l1.NthToLast(3))
	}

}

func TestDeleteMiddle(t *testing.T) {
	l1 := LinkedList{nil, 0}

	l1.insert(1)
	l1.insert(5)
	l1.insert(8)
	l1.insert(7)
	l1.insert(5)
	l1.insert(6)
	l1.insert(-1)
	l1.insert(74)
	l1.insert(7)

	var node *Node = l1.head.next.next.next

	l1.deleteMiddle(node)

	if l1.length != 8 {
		t.Errorf("Error in deleting middle, length %d", l1.length)
	}

	node = l1.head.next.next.next.next.next

	l1.deleteMiddle(node)

	if l1.length != 7 {
		t.Errorf("Error in deleting middle, length %d", l1.length)
	}
}

func TestPartition(t *testing.T) {
	l1 := &LinkedList{nil, 0}

	l1.insert(2)
	l1.insert(5)
	l1.insert(18)
	l1.insert(7)
	l1.insert(15)
	l1.insert(6)
	l1.insert(-1)
	l1.insert(74)
	l1.insert(7)

	l1 = l1.partition(10)

	// Count number of elements less than 10, check that the i-th element is greater than 10 and the i+1-th element is less than 10
	curr := l1.head
	count := 0
	for curr != nil {
		if curr.data < 10 {
			count++
		}

		if curr.data >= 10 && curr.next != nil && curr.next.data < 10 {
			t.Errorf("Error in partition, %d is greater than 10 and %d is less than 10", curr.data, curr.next.data)
		}

		curr = curr.next
	}
}

func TestSumLists(t *testing.T) {
	list1 := &LinkedList{nil, 0}
	list1.insert(3)
	list1.insert(2)
	list1.insert(1)

	list2 := &LinkedList{nil, 0}
	list2.insert(6)
	list2.insert(5)
	list2.insert(4)

	expected := &LinkedList{nil, 0}
	expected.insert(9)
	expected.insert(7)
	expected.insert(5)

	result := sumLists(list1, list2)
	if !reflect.DeepEqual(result, expected) {
		t.Errorf("sumLists(%v, %v) = %v, expected %v", list1, list2, result, expected)
	}

	result.head = sumListsRec(list1.head, list2.head, 0)
	if !reflect.DeepEqual(result, expected) {
		t.Errorf("sumLists(%v, %v) = %v, expected %v", list1, list2, result, expected)
	}
}

func TestPalindrome(t *testing.T) {
	list1 := &LinkedList{nil, 0}

	list1.insert(1)
	list1.insert(1)
	list1.insert(1)

	if !isPalindrome(list1) {
		t.Errorf("Error in isPalindrome, list is not palindrome")
	}

	listNotPalindrome := &LinkedList{nil, 0}
	listNotPalindrome.insert(1)
	listNotPalindrome.insert(2)
	listNotPalindrome.insert(3)

	if isPalindrome(listNotPalindrome) {
		t.Errorf("Error in isPalindrome, list is palindrome")
	}

	listNotPalindrome2 := &LinkedList{nil, 0}
	listNotPalindrome2.insert(1)
	listNotPalindrome2.insert(2)
	listNotPalindrome2.insert(3)
	listNotPalindrome2.insert(3)
	listNotPalindrome2.insert(3)
	listNotPalindrome2.insert(3)
	listNotPalindrome2.insert(9)
	listNotPalindrome2.insert(11)
	listNotPalindrome2.insert(13)

	if isPalindrome(listNotPalindrome2) {
		t.Errorf("Error in isPalindrome, list is palindrome")
	}
}

func TestIntersecate(t *testing.T) {
	list1 := &LinkedList{nil, 0}

	list1.insert(1)
	list1.insert(2)
	list1.insert(3)
	list1.insert(4)
	list1.insert(5)
	list1.insert(6)
	list1.insert(7)
	list1.insert(8)
	list1.insert(9)

	list2 := &LinkedList{nil, 0}
	list2.head = list1.head.next.next.next.next

	list3 := intersacate(list1, list2)

	if list3 == nil {
		t.Errorf("Error in intersacate, lists is nil")
	}

	if list3.head != list2.head {
		t.Errorf("Error in intersacate, lists are not intersacated")
	}

	list4 := &LinkedList{nil, 0}
	list3 = intersacate(list1, list4)

	if list3 != nil {
		t.Errorf("Error in intersacate, lists is not nil")
	}
}

func TestFindCycle(t *testing.T) {
	// Create a linked list with a cycle
	l1 := &LinkedList{nil, 0}
	node1 := &Node{1, nil}
	node2 := &Node{2, nil}
	node3 := &Node{3, nil}
	node4 := &Node{4, nil}
	node5 := &Node{5, nil}
	node6 := &Node{6, nil}
	node7 := &Node{7, nil}
	node8 := &Node{8, nil}
	node9 := &Node{9, nil}
	node10 := &Node{10, nil}
	node11 := &Node{11, nil}
	node12 := &Node{12, nil}
	node13 := &Node{13, nil}
	node14 := &Node{14, nil}
	node15 := &Node{15, nil}
	node16 := &Node{16, nil}
	node17 := &Node{17, nil}
	node18 := &Node{18, nil}
	node19 := &Node{19, nil}
	node20 := &Node{20, nil}
	node21 := &Node{21, nil}
	node22 := &Node{22, nil}
	node23 := &Node{23, nil}
	node24 := &Node{24, nil}
	node25 := &Node{25, nil}
	node26 := &Node{26, nil}
	node27 := &Node{27, nil}
	node28 := &Node{28, nil}
	node29 := &Node{29, nil}
	node30 := &Node{30, nil}

	l1.head = node1
	node1.next = node2
	node2.next = node3
	node3.next = node4
	node4.next = node5
	node5.next = node6
	node6.next = node7
	node7.next = node8
	node8.next = node9
	node9.next = node10
	node10.next = node11
	node11.next = node12
	node12.next = node13
	node13.next = node14
	node14.next = node15
	node15.next = node16
	node16.next = node17
	node17.next = node18
	node18.next = node19
	node19.next = node20
	node20.next = node21
	node21.next = node22
	node22.next = node23
	node23.next = node24
	node24.next = node25
	node25.next = node26
	node26.next = node27
	node27.next = node28
	node28.next = node29
	node29.next = node30
	node30.next = node10

	// Test the function
	cycleStart := findCycle(l1)
	if cycleStart != node10 {
		t.Errorf("findCycle returned %v, expected %v", cycleStart, node10)
	}

	// Test a linked list without a cycle
	l2 := &LinkedList{nil, 0}
	l2.insert(1)
	l2.insert(2)
	l2.insert(3)
	l2.insert(4)
	l2.insert(5)
	l2.insert(6)
	l2.insert(7)
	cycleStart = findCycle(l2)
	if cycleStart != nil {
		t.Errorf("findCycle returned %v, expected nil", cycleStart)
	}
}
