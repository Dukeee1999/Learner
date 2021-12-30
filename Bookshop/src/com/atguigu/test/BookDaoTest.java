package com.atguigu.test;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {
    private BookDao bookDao = new BookDaoImpl();
    @Test
    public void addBook() {

        bookDao.addBook(new Book(null,"52cm","sha",new BigDecimal(12.5),60,50,null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21,"duke666","sha",new BigDecimal(12.5),60,50,null));

    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        System.out.println(bookDao.queryBooks());
    }

    @Test
    public void queryForTotalCount(){
        System.out.println(  bookDao.queryForTotalCount());
    }
    @Test
    public void queryForPageItems(){
        System.out.println(bookDao.queryForPageItems(8, Page.PAGE_SIZE));
    }
    @Test
    public void queryForPageItemsByPrice(){
        System.out.println(bookDao.queryForPageItemsByPrice(0,4,10,50));
    }
    @Test
    public void queryForTotalCountByPrice(){
        System.out.println(  bookDao.queryForPageTotalCountByPrice(10,50));
    }
}