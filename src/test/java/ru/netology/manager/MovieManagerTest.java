package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTest {
    MovieManager movieManager = new MovieManager();

    @Test
    void MoviesNoAdd() {
        MovieItem[] expected = new MovieItem[0];
        MovieItem[] actual = movieManager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void addMovie() {
        MovieItem one = new MovieItem(1, "first", "film.com/2", 1);
        movieManager.add(one);
        movieManager.getAll();
        MovieItem[] expected = new MovieItem[]{one};
        MovieItem[] actual = movieManager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getAllLimitOverArrayTest() {
        MovieManager manager = new MovieManager();
        MovieItem first = new MovieItem(1, "first", "film.com/2", 1);
        MovieItem second = new MovieItem(2, "second", "film.com/2", 2);
        MovieItem third = new MovieItem(3, "third", "film.com/3", 1);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{third, second, first};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldGetSixthMovie() {
        MovieManager manager = new MovieManager(6);
        MovieItem first = new MovieItem(1, "first", "film.com/1", 1);
        MovieItem second = new MovieItem(2, "second", "film.com/2", 2);
        MovieItem third = new MovieItem(3, "third", "film.com/3", 1);
        MovieItem fourth = new MovieItem(4, "fourth", "film.com/4", 1);
        MovieItem fifth = new MovieItem(5, "fifth", "film.com/5", 1);
        MovieItem sixth = new MovieItem(6, "sixth", "film.com/6", 1);
        MovieItem seven = new MovieItem(7, "third", "film.com/3", 1);
        MovieItem eight = new MovieItem(8, "eight", "film.com/4", 1);
        MovieItem nine = new MovieItem(9, "nine", "film.com/5", 1);
        MovieItem then = new MovieItem(10, "then", "film.com/6", 1);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seven);
        manager.add(eight);
        manager.add(nine);
        manager.add(then);
        manager.getAll();
        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{then, nine, eight, seven, sixth, fifth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getAllLimitOver10ItemsTest() {
        MovieManager manager = new MovieManager();
        MovieItem first = new MovieItem(1, "first", "film.com/1", 1);
        MovieItem second = new MovieItem(2, "second", "film.com/2", 2);
        MovieItem third = new MovieItem(3, "third", "film.com/3", 1);
        MovieItem fourth = new MovieItem(4, "fourth", "film.com/4", 1);
        MovieItem fifth = new MovieItem(5, "fifth", "film.com/5", 1);
        MovieItem sixth = new MovieItem(6, "sixth", "film.com/6", 1);
        MovieItem seventh = new MovieItem(7, "first", "film.com/7", 1);
        MovieItem eighth = new MovieItem(8, "second", "film.com/8", 2);
        MovieItem ninth = new MovieItem(9, "third", "film.com/9", 1);
        MovieItem tenth = new MovieItem(10, "fourth", "film.com/4", 1);
        MovieItem eleventh = new MovieItem(11, "fifth", "film.com/5", 1);
        MovieItem twelfth = new MovieItem(12, "sixth", "film.com/12", 1);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelfth);
        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third};
        assertArrayEquals(expected, actual);

    }
}