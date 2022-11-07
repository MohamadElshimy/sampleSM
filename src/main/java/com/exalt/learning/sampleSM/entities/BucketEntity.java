package com.exalt.learning.sampleSM.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.aerospike.mapping.Document;
import org.springframework.data.annotation.Id;

@Data
@Document(collection = "BucketSM")
@AllArgsConstructor
public class BucketEntity {
    @Id
    private int id;
    private String type;
    private int size;
}
