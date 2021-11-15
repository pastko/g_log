package com.gteam.glog.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "comt")
public class Commnet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comt_idx")
    private int idx;

    @ManyToOne
    @JoinColumn(name = "bord_idx")
    private Board bord_idx;

    @ManyToOne
    @JoinColumn(name = "comt_rply_idx")
    private Comt_Contents comt_rply_idx;

}
