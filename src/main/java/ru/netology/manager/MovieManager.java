package ru.netology.manager;

import ru.netology.domain.MovieItem;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MovieManager {
    private MovieItem[] items = new MovieItem[0];
    int defaultCount = 10;
    private  int count;

    public void setCount(int count) {
        this.count = count;
    }

    public MovieManager(int count) {
        this.count = count;
    }

    public void add(MovieItem item) {
        int length = items.length + 1;
        MovieItem[] tmp = new MovieItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public MovieItem[] getAll() {
                MovieItem[] result = new MovieItem[0];
        if (count == 0 && items.length <= defaultCount) {
            result = new MovieItem[items.length];
            for (int i = 0; i < result.length; i++) {
                int index = items.length - i - 1;
                result[i] = items[index];
            }
        }
        if (count == 0 && items.length >= defaultCount) {
            result = new MovieItem[10];
            for (int i = 0; i < result.length; i++) {
                int index = items.length - i - 1;
                result[i] =items[index];
            }
        }
        if (count != 0) {
            result = new MovieItem[count];
            for (int i = 0; i < result.length; i++) {
                int index = items.length - i - 1;
                result[i] = items[index];
            }
        }
        return result;
    }

}