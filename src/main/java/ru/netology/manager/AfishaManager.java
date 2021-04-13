package ru.netology.manager;

import ru.netology.domain.MovieItem;
import ru.netology.repository.AfishaRepository;

public class AfishaManager {
    private AfishaRepository repository;
    public MovieItem[] items = new MovieItem[0];
    int defaultCount = 10;

    public AfishaManager(int defaultCount) {
        this.defaultCount = defaultCount;
    }

    public MovieItem[] getAll() {
        MovieItem[] items = repository.findAll();
        MovieItem[] result = new MovieItem[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public void add(MovieItem first) {
    }
}
