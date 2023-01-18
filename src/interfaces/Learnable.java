package interfaces;

interface Learnable {

    default String print() {
        return "something";
    }

    void learn();
}
