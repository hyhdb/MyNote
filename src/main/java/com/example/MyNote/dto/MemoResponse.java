//메모 응답 상자
package com.example.MyNote.dto;

public class MemoResponse {
    private Long id; //메모 번호
    private String title; //제목
    private String content; //내용

    //생성자를 통해 데이터를 한번에 담음
    public MemoResponse(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    //결과를 보여주기 위한 Getter만 만듦
    public Long getId() {return id; }
    public String getTitle() {return title;}
    public String getContent() {return content;}
}
