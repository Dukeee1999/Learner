package com.atguigu.service.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.UserService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookDao bookdao = new BookDaoImpl();
    @Override
    public void addBook(Book book) {
        bookdao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookdao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookdao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookdao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookdao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<Book>();

        page.setPageSize(pageSize);
        Integer pageTotalCount = bookdao.queryForTotalCount();
        page.setPageTotalCount(pageTotalCount);
        Integer pageTotal = pageTotalCount/pageSize;
        if(pageTotal % pageSize>0){
            pageTotal++;
        }
        page.setPageTotal(pageTotal);

        page.setPageNo(pageNo);

        int begin = (page.getPageNo()-1)*pageSize;

        List<Book> items = bookdao.queryForPageItems(begin,pageSize);
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<Book>();

        page.setPageSize(pageSize);
        Integer pageTotalCount = bookdao.queryForPageTotalCountByPrice(min,max);
        page.setPageTotalCount(pageTotalCount);
        Integer pageTotal = pageTotalCount/pageSize;
        if(pageTotal % pageSize>0){
            pageTotal++;
        }
        page.setPageTotal(pageTotal);

        page.setPageNo(pageNo);

        int begin = (page.getPageNo()-1)*pageSize;

        List<Book> items = bookdao.queryForPageItemsByPrice(begin,pageSize,min,max);
        page.setItems(items);
        return page;
    }
}
