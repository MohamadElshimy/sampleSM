package com.exalt.learning.sampleSM.controllers;

import com.exalt.learning.sampleSM.entities.BucketEntity;
import com.exalt.learning.sampleSM.services.BucketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BucketController {
    @Autowired
    BucketService bucketService;

    @PostMapping("/buckets")
    public void createBucket(@RequestBody BucketEntity bucket) {
        bucketService.createBucket(bucket);
    }

    @GetMapping("/buckets")
    public List<BucketEntity> readAllBuckets() {
        return bucketService.readAllBuckets();
    }

    @GetMapping("/buckets/{id}")
    public Optional<BucketEntity> readBucketById(@PathVariable("id") Integer id) {
        return bucketService.readBucketById(id);
    }

    @PutMapping("/buckets/{id}")
    public void updateBucket(@PathVariable("id") Integer id, @RequestBody BucketEntity bucket) {
        bucketService.updateBucket(id, bucket);
    }

    @DeleteMapping("/buckets/{id}")
    public void deleteBucketById(@PathVariable("id") Integer id) {
        bucketService.deleteBucketById(id);
    }

}