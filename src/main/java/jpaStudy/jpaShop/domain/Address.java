package jpaStudy.jpaShop.domain;

import jakarta.persistence.Embeddable;

@Embeddable // 임베디드 타입 정의할 떄
public class Address {
    private String city;
    private String street;
    private String zipcode;

    public Address() {

    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
