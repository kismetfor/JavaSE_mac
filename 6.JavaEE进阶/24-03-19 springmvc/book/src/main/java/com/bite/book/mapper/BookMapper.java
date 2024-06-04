package com.bite.book.mapper;

import com.bite.book.model.BookInfo;
import com.bite.book.model.PageRequest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
    @Select("select * from book_info limit #{offset}, #{limit}")
    List<BookInfo> getBookListByPage(@Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("select count(1) from book_info")
    Integer count();
    /**
     * 删除书籍
     */

}
