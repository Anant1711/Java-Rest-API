package com.example.JAVARESTAPIexample.Repository;
import java.util.*;
import com.example.JAVARESTAPIexample.model.Server;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface serverRepo extends MongoRepository<Server,String> {
    public List<Server> findByName(String name);
}
