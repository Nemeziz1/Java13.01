package ru.netology;

import ru.netology.repository.ProductRepository;

public class Main {
    public static void main(String[] args) {
        ProductRepository repository = new ProductRepository();
        try {
            repository.removeById(2);
            System.out.println("Element with id: " + 2 + " not found");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        repository.throwNotFound();
    }
}
