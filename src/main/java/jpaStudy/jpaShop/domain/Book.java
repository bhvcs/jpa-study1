package jpaStudy.jpaShop.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("B")
public class Book extends Item {
    @Getter @Setter
    private String author;
    @Getter @Setter
    private String isbn;

    @Override
    public String getTitleView() {
        return "[제목:" + getName() + "저자: " + author + "]";
    }//getter로 접근하기 때문에 프록시여도 문제없이 실행됨
}
