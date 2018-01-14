package com.hdu.repository.es;

import com.hdu.domain.es.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author 范正荣
 * @Date 2017/12/27 0027 20:36.
 * 文档 接口
 */
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog,String> {
    /**
     * 分页查询博客
     * @param title
     * @param summary
     * @param pageable
     * @return
     */
    Page<EsBlog> findDistinctByTitleContainingOrSummaryContainingOrContentContaining(String title, String summary, String content, Pageable pageable);
}
