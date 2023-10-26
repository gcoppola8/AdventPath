package gcstack

type SetStack struct {
	stack []Stack
}

func NewSetStack() *SetStack {
	return &SetStack{make([]Stack, 50)}
}

func (s *SetStack) Push(sn int, data int) {
	if sn > len(s.stack) {
		return
	}

	s.stack[sn].Push(data)

	return
}

func (s *SetStack) Pop(sn int) (int, bool) {
	if sn > len(s.stack) {
		return 0, false
	}

	return s.stack[sn].Pop()
}

// Print a SetStack
func (s *SetStack) Print() {
	for i := 0; i < len(s.stack); i++ {
		s.stack[i].Print()
	}
}
