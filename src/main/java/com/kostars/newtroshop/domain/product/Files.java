package com.kostars.newtroshop.domain.product;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicInsert
@Builder
public class Files {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileId;

    private String fileUrl;

    private String fileName;

    private int fileOrder;

    private boolean fileCover;

    private boolean filePublished;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

}
