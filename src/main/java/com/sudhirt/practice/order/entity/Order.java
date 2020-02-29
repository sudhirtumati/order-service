package com.sudhirt.practice.order.entity;

import com.sudhirt.practice.order.constant.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String customerId;
    private LocalDateTime orderCreationTime;
    private boolean paymentCompleted;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<OrderItem> items;
}
