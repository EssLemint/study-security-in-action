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
public class Otp {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long Id;

  @Column(nullable = false)
  @Comment("otp")
  String code;

  @Column(nullable = false)
  @Comment("username")
  String username;


  public Otp(String code, String username) {
    this.code = code;
    this.username = username;
  }

  public void updateOtp(String otp) {
    this.code = otp;
  }
}
