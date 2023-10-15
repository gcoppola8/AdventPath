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
