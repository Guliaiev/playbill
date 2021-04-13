package ru.netology.manager;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.MovieItem;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)

public class AfishaManagerTest {
    @Mock
    private AfishaRepository repository;
    @InjectMocks
    private AfishaManager manager;
    private MovieItem first = new MovieItem(1, "first", "film.com/1", 1);
    private MovieItem second = new MovieItem(2, "second", "film.com/2", 2);
    private MovieItem third = new MovieItem(3, "third", "film.com/3", 1);
    private MovieItem four = new MovieItem(4, "first", "film.com/1", 1);
    private MovieItem five = new MovieItem(5, "second", "film.com/2", 2);
    private MovieItem six = new MovieItem(6, "third", "film.com/3", 1);
    private MovieItem seven = new MovieItem(7, "first", "film.com/1", 1);
    private MovieItem eight = new MovieItem(8, "second", "film.com/2", 2);
    private MovieItem nine = new MovieItem(9, "third", "film.com/3", 1);
    private MovieItem then = new MovieItem(10, "second", "film.com/2", 2);
    private MovieItem eleven = new MovieItem(11, "third", "film.com/3", 1);



    @Test
    void addThenMovie() {
        MovieItem[] returned = new MovieItem[]{first, second, third, four, five, six, seven, eight, nine, then};
        doReturn(returned).when(repository).findAll();
        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{then, nine, eight, seven, six, five, four, third, second, first};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    void addMoreThenMovie() {
        MovieItem[] returned = new MovieItem[]{first, second, third, four, five, six, seven, eight, nine, then, eleven};
        doReturn(returned).when(repository).findAll();
        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{eleven, then, nine, eight, seven, six, five, four, third, second};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();

    }
    @Test
    public void addMovie(){
        MovieItem[] returned = new MovieItem[]{first};
        doReturn(returned).when(repository).findAll();
        manager.add(first);
        MovieItem[]expected = new MovieItem[]{first};
        MovieItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }
    @Test
    void MoviesNoAdd() {
        MovieItem[] returned = new MovieItem[0];
        doReturn(returned).when(repository).findAll();
        MovieItem[] expected = new MovieItem[0];
        MovieItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

}