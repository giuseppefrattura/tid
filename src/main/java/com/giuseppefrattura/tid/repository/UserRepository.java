package com.giuseppefrattura.tid.repository;

import com.giuseppefrattura.tid.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<UserModel,String> {

}
