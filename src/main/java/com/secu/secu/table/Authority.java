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
public class Authority {

  @javax.persistence.Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long Id;

  @Column(nullable = false)
  @Comment("권한 이름")
  String name;

  @ManyToOne
  @JoinColumn(name = "userId")
  private User user;
}
