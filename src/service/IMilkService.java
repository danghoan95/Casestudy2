package service;

import model.Category;
import model.Milk;

public interface IMilkService extends IGenerateSerVice<Milk> {
    void deleteById();
    void displayMaxPrice();

    void displayMinPrice();

    void searchByName();

    void searchByPrice();

    void displayByCategory(Category category);
}
