package cn.tedu.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
        private Integer bid;
        private Integer cateid;
        private String bnum;
        private String bname;
        private Integer price;
        private String author;
        private String ddesc;
        private Integer quantity;
        private Integer deleted;
        private String createtime;
        private String modifytime;
}
