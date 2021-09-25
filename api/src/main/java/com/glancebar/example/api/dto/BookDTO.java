package com.glancebar.example.api.dto;


import java.io.Serializable;

/**
 * 出参入参必须实现Serializable接口，Kotlin不支持
 *
 * @author YISHEN CAI
 */
public class BookDTO implements Serializable {
    private String name;
    private String isbn;

    public BookDTO(String name, String isbn) {
        this.name = name;
        this.isbn = isbn;
    }

    public BookDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "name='" + name + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
