package com.tienda.crud.repositories;

import com.tienda.crud.models.ProductDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IProductDAO extends MongoRepository<ProductDTO, String> { }
