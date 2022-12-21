package com.secu.secu.table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Getter
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long Id;

  @Column(nullable = false)
  @Comment("이름")
  String name;

  @Column(nullable = false)
  @Comment("금액")
  String price;

  @Column(nullable = false)
  @Comment("통화")
  String currency;
}
