package Interfaces;

import Enums.Books;

public interface Readable {
    void read(Books books);
    void readManyBooks(Books... books);
}
