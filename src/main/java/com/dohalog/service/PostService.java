package com.dohalog.service;

import com.dohalog.domain.Post;
import com.dohalog.repository.PostRepository;
import com.dohalog.request.PostCreate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public void write(PostCreate postCreate){
        //postCreate(DTO 형식) -> Entity
        Post post = Post.builder()
                .title(postCreate.getTitle())
                .content(postCreate.getContent())
                .build();

        postRepository.save(post);
    }

    public Post get(Long id) {
        Post post = postRepository.findById(id)     // -> 원래 Optional로 감싸서 검증하고 값을 내보내야하는데, 안하는걸 추천.
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 글입니다."));
        return post;
    }
}
