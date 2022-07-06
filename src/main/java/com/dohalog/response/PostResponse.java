package com.dohalog.response;

import lombok.Builder;
import lombok.Getter;

/**
 *  서비스 정책에 맞는 클래스
 */
@Builder
@Getter
public class PostResponse {

    private final Long id;
    private final String title;
    private final String content;
}
