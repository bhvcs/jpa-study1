package jpaStudy.jpaShop.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class Album extends Item {
    private String artist;
    private String etc;
    @Override
    public String getTitleView() {
        return "[제목:" + getName() + "예술가: " + artist + "]";
    }//getter로 접근하기 때문에 프록시여도 문제없이 실행됨
}
