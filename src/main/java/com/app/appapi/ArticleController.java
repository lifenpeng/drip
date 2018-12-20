package com.app.appapi;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import java.text.SimpleDateFormat;
import java.sql.Timestamp;
import java.util.Map;


@RestController
public class ArticleController{

    //调用定义接口
    @Autowired
    private ArticleRepository articleRepository;

    //get请求 获取全部文章
    @GetMapping(value = "/article")
    @CrossOrigin
    public List<Article> articleList(){
        return  articleRepository.findAll();
    }

    //post请求 添加文章
    @PostMapping(value = "/article")
    @CrossOrigin
    public HashMap ArticleAdd(@RequestBody String data){

        Date time = new Date();
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Gson gson = new Gson();
        Map<String, Object> add = new HashMap<String, Object>();
        add = gson.fromJson(data, add.getClass());

        Article article = new Article();
        article.setTitle(add.get("title").toString());
        article.setSource(add.get("source").toString());
        article.setCateid(add.get("cateid").toString());
        article.setBrief(add.get("brief").toString());
        article.setContent(add.get("content").toString());
        article.setTime(Timestamp.valueOf(simpleDate.format(time)));
        articleRepository.save(article);
        HashMap info = new HashMap();
        info.put("add",true);

        return info;
    }

    //查询文章
    @GetMapping(value = "/article/{id}")
    @CrossOrigin
    public Article getArticle(@PathVariable("id") Integer id){

        return articleRepository.findById(id).get();

    }

    //PUT请求 更新文章
    @PutMapping(value = "/article/{id}")
    @CrossOrigin
    public Article upArticle(@PathVariable("id") Integer id,
                              @RequestParam("title") String title,
                              @RequestParam("source") String source,
                              @RequestParam("cateid") String cateid,
                              @RequestParam("brief") String brief,
                              @RequestParam("content") String content){

        Date time = new Date();
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Article article = new Article();
        article.setId(id);
        article.setTitle(title);
        article.setSource(source);
        article.setCateid(cateid);
        article.setBrief(brief);
        article.setContent(content);
        article.setTime(Timestamp.valueOf(simpleDate.format(time)));

        return articleRepository.save(article);

    }

    //Delete请求 文章删除
    @DeleteMapping(value = "article/{id}")
    @CrossOrigin
    public HashMap delArticle(@PathVariable("id") Integer id){
            articleRepository.deleteById(id);
            HashMap del = new HashMap();
            del.put("del",true);
            return del;
    }
}
