package jpaStudy.jpaShop.repository.custom;

import com.querydsl.jpa.JPQLQuery;
import jpaStudy.jpaShop.domain.Order;
import jpaStudy.jpaShop.domain.OrderSearch;
import jpaStudy.jpaShop.domain.QMember;
import jpaStudy.jpaShop.domain.QOrder;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.util.StringUtils;

import java.util.List;

public class OrderRepositoryImpl extends QuerydslRepositorySupport implements CustomOrderRepository {

    public OrderRepositoryImpl() {
        super(Order.class);//생성자에서 QueryDslRepositorySupport에 엔티티 클래스 정보를 넘겨줘야 한다
    }
    @Override
    public List<Order> search(OrderSearch orderSearch) {
        QOrder order = QOrder.order;
        QMember member = QMember.member;

        JPQLQuery<Order> query = from(order);

        if (StringUtils.hasText(orderSearch.getMemberName())) {
            query.leftJoin(order.member, member)
                    .where(member.name.contains(orderSearch.getMemberName()));
        }

        if (orderSearch.getOrderStatus() != null) {
            query.where(order.status.eq(orderSearch.getOrderStatus()));
        }

        return query.fetch();//query.list() is deprecated
    }
}
