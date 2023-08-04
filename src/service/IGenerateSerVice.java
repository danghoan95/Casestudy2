package service;

public interface IGenerateSerVice <E>{
    void create();

    void update();

    void display();

    E findById();
}
