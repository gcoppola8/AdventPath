package gcstack

import (
	"testing"
)

func TestStack_Push(t *testing.T) {
	s := &Stack{}
	for i := 0; i < 1024; i++ {
		if !s.Push(i) {
			t.Errorf("Push failed at index %d", i)
		}
	}

	if s.Push(1024) {
		t.Error("Push should have failed at index 1024")
	}
}

func TestStack_Pop(t *testing.T) {
	s := &Stack{}
	s.Push(1)
	s.Push(2)
	s.Push(3)

	val, ok := s.Pop()
	if !ok || val != 3 {
		t.Errorf("Pop failed, expected 3 but got %d", val)
	}

	val, ok = s.Pop()
	if !ok || val != 2 {
		t.Errorf("Pop failed, expected 2 but got %d", val)
	}

	val, ok = s.Pop()
	if !ok || val != 1 {
		t.Errorf("Pop failed, expected 1 but got %d", val)
	}

	val, ok = s.Pop()
	if ok {
		t.Errorf("Pop should have failed, but returned %d", val)
	}
}

func TestStack_Peek(t *testing.T) {
	s := &Stack{}
	if _, ok := s.Peek(); ok {
		t.Error("Peek should have failed on empty stack")
	}

	s.Push(1)
	s.Push(2)
	s.Push(3)

	if val, ok := s.Peek(); !ok || val != 3 {
		t.Error("Peek failed to return top value")
	}

	s.Pop()
	s.Pop()

	if val, ok := s.Peek(); !ok || val != 1 {
		t.Error("Peek failed to return top value after pops")
	}
}

func TestStack_IsEmpty(t *testing.T) {
	s := &Stack{}
	if !s.IsEmpty() {
		t.Error("IsEmpty should return true for an empty stack")
	}

	s.Push(1)
	if s.IsEmpty() {
		t.Error("IsEmpty should return false for a non-empty stack")
	}

	s.Pop()
	if !s.IsEmpty() {
		t.Error("IsEmpty should return true after popping all elements from the stack")
	}
}

func TestSetStack_PushPop(t *testing.T) {
	s := NewSetStack()
	// Push data to the first stack
	s.Push(0, 1)
	s.Push(0, 2)
	s.Push(0, 3)

	// Push data to the second stack
	s.Push(1, 4)
	s.Push(1, 5)

	// Push data to the third stack
	s.Push(2, 6)

	// Test that the data was pushed correctly
	val, ok := s.stack[0].Pop()
	if !ok || val != 3 {
		t.Error("Expected 3 to be at the top of the first stack")
	}

	val, ok = s.stack[1].Pop()
	if !ok || val != 5 {
		t.Error("Expected 5 to be at the top of the second stack")
	}
	val, ok = s.stack[2].Pop()
	if !ok || val != 6 {
		t.Error("Expected 6 to be at the top of the third stack")
	}

}
