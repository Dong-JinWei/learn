package cn.tedu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import cn.tedu.pojo.Borrow;
import java.util.List;

@Mapper
public interface BorrowMapper {

    @Select("select * from db_borrow where uid = #{uid}")
    List<Borrow> getBorrowsByUid(int uid);

    @Select("select * from db_borrow where bid = #{bid}")
    List<Borrow> getBorrowsByBid(int Bid);

    @Select("select * from db_borrow where bid = #{bid} and uid = #{uid}")
    Borrow getBorrows(int uid,int bid);

}
