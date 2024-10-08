package com.sist.jobgem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @Column(name = "re_idx", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "jo_idx", nullable = false)
    private Integer joIdx;

    @NotNull
    @Column(name = "co_idx", nullable = false)
    private Integer coIdx;

    @Size(max = 20)
    @NotNull
    @Column(name = "re_title", nullable = false, length = 20)
    private String reTitle;

    @NotNull
    @Lob
    @Column(name = "re_content", nullable = false)
    private String reContent;

    @NotNull
    @Column(name = "re_score", nullable = false)
    private Integer reScore;

    @NotNull
    @Column(name = "re_state", nullable = false)
    private Integer reState;

}