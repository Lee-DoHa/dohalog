package com.dohalog.controller;

import com.dohalog.domain.Post;
import com.dohalog.request.PostCreate;
import com.dohalog.request.PostEdit;
import com.dohalog.request.PostSearch;
import com.dohalog.response.PostResponse;
import com.dohalog.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public void post(@RequestBody @Valid PostCreate request){
        // Case1. 저장한 데이터 Entity -> response로 응답하기
        // Case2. 저장한 데이터의 primary_id -> response로 응답하기
        //          Client에서는 수신한 id를 글 조회 API를 통해서 데이터를 수신받음
        // Case3. 응답 필요 없음 -> 클라이언트에서 모든 POST(글) 데이터 context를 잘 관리함.
        // Bad Case: 서버에서 -> 반드시 이렇게 할겁니다! fix
        //          -> 서버에서 차라리 유연하게 대응하는게 좋다. -> 코드를 잘 짜야함.
        //          -> 한 번에 일괄적으로 잘 처리되는 케이스는 없다. -> 잘 관리하는 형태가 중요함.
        postService.write(request);
    }

    @GetMapping("/posts/{postId}")
    public PostResponse get(Long postId){
        return postService.get(postId);
    }

    @GetMapping("/posts")
    public List<PostResponse> getList(@ModelAttribute PostSearch postSearch) {
        return postService.getList(postSearch);
    }

    @PatchMapping("/posts/{postId}")
    public void edit(@PathVariable Long postId, @RequestBody @Valid PostEdit request) {
         postService.edit(postId, request);
    }

}
