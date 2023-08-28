package com.BlogBackend.Blog.service;

import com.BlogBackend.Blog.dao.BlogRepository;
import com.BlogBackend.Blog.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogData_Implementation implements BlogData{
    private BlogRepository theBlogRepository;

    BlogData_Implementation(){}
    @Autowired
    BlogData_Implementation(BlogRepository theBlogRepository){
        this.theBlogRepository = theBlogRepository;
    }


    @Override
    public List<Blog> findAll() {
        return null;
    }

    @Override
    public Blog findById(int theId) {
        Optional<Blog> result = theBlogRepository.findById(theId);
        Blog theBlog = null;
        if(!result.isEmpty()){
            theBlog = result.get();
        }
        return theBlog;
    }
}
