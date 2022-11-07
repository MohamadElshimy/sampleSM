package com.exalt.learning.sampleSM.services;

import com.exalt.learning.sampleSM.SoapClient.SoapConnector;
import com.exalt.learning.sampleSM.entities.BucketEntity;
import com.exalt.learning.sampleSM.generated.*;
import com.exalt.learning.sampleSM.repositories.AerospikeBucketRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BucketService {
    @Autowired
    AerospikeBucketRepository aerospikeBucketRepository;

    @Autowired
    SoapConnector soapConnector;

    public void createBucket(BucketEntity bucket) {
        aerospikeBucketRepository.save(bucket);
        AddBucketRequest request = new AddBucketRequest();
        request.setId(bucket.getId());
        request.setSize(bucket.getSize());
        request.setType(bucket.getType());
        AddBucketResponse response =(AddBucketResponse) soapConnector.callWebService("http://localhost:8080/soapws/buckets.wsdl", request);
    }

    public List<BucketEntity> readAllBuckets() {
        List<BucketEntity> buckets = new ArrayList<BucketEntity>();
        aerospikeBucketRepository.findAll().forEach(bucketEntity -> buckets.add(bucketEntity));
        return buckets;
    }

    public Optional<BucketEntity> readBucketById(int id) {
        return aerospikeBucketRepository.findById(id);
    }

    public void updateBucket(Integer id, BucketEntity bucket) {
        aerospikeBucketRepository.save(bucket);
        UpdateBucketRequest request = new UpdateBucketRequest();
        BucketInfo bucketInfo = new BucketInfo();
        BeanUtils.copyProperties(bucket, bucketInfo);
        request.setBucketInfo(bucketInfo);
        UpdateBucketResponse response =(UpdateBucketResponse) soapConnector.callWebService("http://localhost:8080/soapws/buckets.wsdl", request);
    }

    public void deleteBucketById(int id) {
        aerospikeBucketRepository.deleteById(id);
        DeleteBucketRequest request = new DeleteBucketRequest();
        request.setId(id);
        DeleteBucketResponse response =(DeleteBucketResponse) soapConnector.callWebService("http://localhost:8080/soapws/buckets.wsdl", request);
    }

}
