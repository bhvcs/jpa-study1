package jpaStudy.jpaShop.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("M")
public class Movie extends Item {
    private String director;
    private String actor;

    @Override
    public String getTitleView() {
        return "[제목:" + getName() + "감독: " + director + "]";
    }//getter로 접근하기 때문에 프록시여도 문제없이 실행됨
}
