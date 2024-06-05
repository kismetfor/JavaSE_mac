package com.bite.book.mapper;

import com.bite.book.model.BookInfo;
import com.bite.book.model.PageRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

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
     *
     */
    //order by id desc
    @Select("select * from book_info where status != 0 limit #{offset}, #{limit}")
    List<BookInfo> getBookListByPage(@Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("select count(1) from book_info where status != 0")
    Integer count();

    @Select("select * from book_info where id = #{bookId}")
    BookInfo queryBookById(@Param("bookId") Integer bookId);

    Integer updateBookById(BookInfo bookInfo);
    /**
     * 批量删除书籍
     */

    Integer batchDeleteByIds(List<Integer> ids);

}
