package dev.coppola.crackingcodeinterview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Chapter3 {

    public class AnimalShelter {

        private Stack<String> dogStack;
        private Stack<String> catStack;

        public AnimalShelter() {
            dogStack = new Stack<>();
            catStack = new Stack<>();
        }

        public void enqueue(String animal) {
            if (animal.equals("dog")) {
                dogStack.push(animal);
            } else if (animal.equals("cat")) {
                catStack.push(animal);
            } else {
                throw new IllegalArgumentException("Animal must be dog or cat");
            }
        }

        public String dequeueAny() {
            if (dogStack.isEmpty() && catStack.isEmpty()) {
                return "";
            } else if (dogStack.isEmpty()) {
                return catStack.pop();
            } else if (catStack.isEmpty()) {
                return dogStack.pop();
            } else {
                return dogStack.peek().compareTo(catStack.peek()) < 0 ? dogStack.pop() : catStack.pop();
            }
        }

        public String dequeueDog() {
            if (dogStack.isEmpty()) {
                return "";
            }

            return dogStack.pop();
        }

        public String dequeueCat() {
            if (catStack.isEmpty()) {
                return "";
            }

            return catStack.pop();
        }
    }

    @Test
    public void testAnimalShelter() {
        var animalShelter = new AnimalShelter();
        animalShelter.enqueue("dog");
        animalShelter.enqueue("dog");
        animalShelter.enqueue("cat");
        animalShelter.enqueue("dog");
        animalShelter.enqueue("cat");
        animalShelter.enqueue("dog");
        animalShelter.enqueue("dog");

        Assertions.assertEquals("cat", animalShelter.dequeueAny());
        Assertions.assertEquals("cat", animalShelter.dequeueAny());
        Assertions.assertEquals("dog", animalShelter.dequeueAny());

        Assertions.assertEquals("dog", animalShelter.dequeueAny());
        Assertions.assertEquals("dog", animalShelter.dequeueAny());
        Assertions.assertEquals("", animalShelter.dequeueCat());

        Assertions.assertEquals("dog", animalShelter.dequeueDog());

    }
}

