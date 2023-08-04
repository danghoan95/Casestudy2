package IO;

import java.util.List;

public interface IOFile<E> {
    void write(List<E> e, String path);

    List<E> read(String path);
}
