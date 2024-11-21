package jpaStudy.jpaShop.domain;

public interface TitleView {
    String getTitleView();//이를 item이 상속 받게 함으로써 item을 상속받는 클래스들이 이를 구현하도록 한다.
    //오버라이드하는 메서드의 내용을 getter 접근자로 각 필드를 노출시킬 것이므로 대상 객체가 프록시인지 원본인지 따로 판단할 필요가 없어진다.
}
