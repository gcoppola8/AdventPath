package gcstack

import "fmt"

type Stack struct {
	stack  [1024]int
	length int
}

func (s *Stack) Push(data int) bool {
	if s.length < 1024 {
		s.stack[s.length] = data
		s.length++
		return true
	}

	return false
}

func (s *Stack) Pop() (int, bool) {
	if s.length == 0 {
		return 0, false
	}

	s.length--
	return s.stack[s.length], true
}

func (s *Stack) Peek() (int, bool) {
	if s.length == 0 {
		return 0, false
	}

	return s.stack[s.length-1], true
}

func (s *Stack) IsEmpty() bool {
	return s.length == 0
}

func (s *Stack) Length() int {
	return s.length
}

func (s Stack) Print() {
	for i := s.Length() - 1; i >= 0; i-- {
		fmt.Println(s.stack[i])
	}
}
