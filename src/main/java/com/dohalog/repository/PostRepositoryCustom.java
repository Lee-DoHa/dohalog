package com.dohalog.repository;

import com.dohalog.domain.Post;
import com.dohalog.request.PostSearch;

import java.util.List;

public interface PostRepositoryCustom {

    List<Post> getList(PostSearch postSearch);

}
