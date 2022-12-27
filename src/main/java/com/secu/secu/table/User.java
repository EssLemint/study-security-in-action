package com.secu.secu.table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Table(name = "TB_USER")
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long Id;

  @Column(nullable = false)
  @Comment("사용자 이름")
  String username;

  @Column(nullable = false)
  @Comment("사용자 비밀번호")
  String password;

  @Enumerated(EnumType.STRING)
  private EncryptionAlgorithm algorithm;

  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
  private List<Authority> authorities;

  @Enumerated(EnumType.STRING)
  private Role role;

}
