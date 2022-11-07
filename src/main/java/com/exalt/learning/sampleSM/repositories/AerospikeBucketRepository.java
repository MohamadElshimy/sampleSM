package com.exalt.learning.sampleSM.repositories;

import com.exalt.learning.sampleSM.entities.BucketEntity;
import org.springframework.data.aerospike.repository.AerospikeRepository;

public interface AerospikeBucketRepository extends AerospikeRepository<BucketEntity, Integer> {
}
