//기초가 되는 메모의 "모양" 정의
package com.example.MyNote.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "memos")
public class Memo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //메모 번호

    private String title; //제목

    @Column(columnDefinition = "TEXT")
    private String content; //내용

    //기본 생성자
    public Memo() {}

    //데이터를 넣고 빼기 위한 Getter/Setter
    public Long getId() {return id;}
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public String getContent() {return content;}
    public void setContent(String content) {this.content = content;}


}
