package com.app.appapi;

import org.springframework.data.jpa.repository.JpaRepository;

//获取文章
public interface LoginRepository extends JpaRepository<Login,Integer> {

}
