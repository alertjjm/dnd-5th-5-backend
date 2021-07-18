package com.meme.ala.domain.member.controller;

import com.meme.ala.common.dto.ResponseDto;
import com.meme.ala.core.auth.oauth.OAuthProvider;
import com.meme.ala.common.message.ResponseMessage;
import com.meme.ala.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    // TODO: path variable 로 변경

    @PostMapping("api/v1/oauth/jwt/google")
    public ResponseEntity<ResponseDto<String>> jwtGoogleCreate(@RequestBody Map<String, Object> data) {
        String jwtToken = memberService.loginOrJoin(data, OAuthProvider.GOOGLE);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ResponseDto.of(HttpStatus.OK, ResponseMessage.SUCCESS, jwtToken));
    }

    @PostMapping("api/v1/oauth/jwt/naver")
    public ResponseEntity<ResponseDto<String>> jwtNaverCreate(@RequestBody Map<String, Object> data) {
        String jwtToken = memberService.loginOrJoin(data, OAuthProvider.NAVER);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ResponseDto.of(HttpStatus.OK, ResponseMessage.SUCCESS, jwtToken));
    }
}
