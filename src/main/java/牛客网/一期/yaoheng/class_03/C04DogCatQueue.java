package 牛客网.一期.yaoheng.class_03;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class C04DogCatQueue {
    public static class Pet {
        private String name;

        public Pet(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Cat extends Pet {
        public Cat() {
            super("Cat");
        }
    }

    public static class Dog extends Pet {
        public Dog() {
            super("Dog");
        }
    }

    public static class Animal {
        private Integer num;
        private Pet pet;

        public Animal(Integer num, Pet pet) {
            this.num = num;
            this.pet = pet;
        }

        public Integer getNum() {
            return num;
        }

        public Pet getPet() {
            return pet;
        }

    }

    public static class QueueDogCat {
        private Queue<Animal> catQueue = new LinkedBlockingDeque<>();
        private Queue<Animal> dogQueue = new LinkedBlockingDeque<>();
        int index = 0;

        public void pull(Pet pet) {
            if (pet.getName() == "Cat") {
                catQueue.add(new Animal(++index, new Cat()));
            } else if (pet.getName() == "Dog") {
                dogQueue.add(new Animal(++index, new Dog()));
            }
        }

        public Integer size() {
            return catQueue.size() + dogQueue.size();
        }

        public Pet pop() {
            if (catQueue.size() == 0 && dogQueue.size() == 0) {
                throw new RuntimeException("无数据");
            }
            if (catQueue.size() != 0 && dogQueue.size() != 0) {
                return catQueue.peek().getNum() < dogQueue.peek().getNum() ? catQueue.poll().getPet() : dogQueue.poll().getPet();
            }
            if (catQueue.size() != 0) {
                return catQueue.poll().getPet();
            } else {
                return dogQueue.poll().getPet();
            }
        }
    }

    public static void main(String[] args) {
        QueueDogCat q = new QueueDogCat();
        q.pull(new Dog());
        q.pull(new Cat());
        q.pull(new Dog());
        q.pull(new Cat());

        while (q.size() > 0) {
            System.out.println(q.pop().getName());
        }
    }
}
