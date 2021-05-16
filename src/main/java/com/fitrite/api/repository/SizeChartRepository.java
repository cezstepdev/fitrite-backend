package com.fitrite.api.repository;


import com.fitrite.api.models.SizeChart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeChartRepository extends MongoRepository<SizeChart, String> {
}
