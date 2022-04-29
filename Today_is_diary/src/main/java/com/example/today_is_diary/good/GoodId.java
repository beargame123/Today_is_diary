package com.example.today_is_diary.good;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Embeddable
public class GoodId implements Serializable {

    private static final long serialVersionUID = 474583426189517315L;
    @Column(nullable = false)
    private String postId;

    @Column(nullable = false)
    private String userId;
}
