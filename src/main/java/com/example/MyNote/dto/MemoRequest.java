//메모 작성 요청 상자
package com.example.MyNote.dto;

public class MemoRequest {
    private String title; //제목
    private String content; //내용

    //서버가 데이터를 담을수 있게 Getter와 Setter가 반드시 필요
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getContent() {return content;}
    public void setContent(String content) {this.content = content;}
}
