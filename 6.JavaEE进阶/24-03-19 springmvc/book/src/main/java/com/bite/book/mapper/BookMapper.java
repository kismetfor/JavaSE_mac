package com.bite.book.mapper;

import com.bite.book.model.BookInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {
    /**
     * 插入书籍
     * @param bookInfo
     * @return
     */
    @Insert("insert book_info (book_name, author, count, price, publish, status) VALUES " +
            "(#{bookName}, #{author}, #{count},#{price},#{publish},#{status})")
    Integer insert(BookInfo bookInfo);
    /**
     * 删除书籍
     */

}
