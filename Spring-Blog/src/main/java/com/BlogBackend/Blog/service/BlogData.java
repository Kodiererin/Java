package com.BlogBackend.Blog.service;

import com.BlogBackend.Blog.entity.Blog;

import java.util.List;

public interface BlogData {
    List<Blog> findAll();

    Blog findById(int theId);
}
