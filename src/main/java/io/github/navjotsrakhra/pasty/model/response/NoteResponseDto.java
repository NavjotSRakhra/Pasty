package io.github.navjotsrakhra.pasty.model.response;

import java.time.ZonedDateTime;

public class NoteResponseDto {
    private String id;
    private String title;
    private String content;
    private ZonedDateTime createdAt;
    private ZonedDateTime expiresAt;
    private String urlIdentifier;

    public NoteResponseDto() {
    }

    public NoteResponseDto(String id, String title, String content, ZonedDateTime createdAt, ZonedDateTime expiresAt, String urlIdentifier) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.urlIdentifier = urlIdentifier;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(ZonedDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public String getUrlIdentifier() {
        return urlIdentifier;
    }

    public void setUrlIdentifier(String urlIdentifier) {
        this.urlIdentifier = urlIdentifier;
    }

    @Override
    public String toString() {
        return "NoteResponseDto{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                ", expiresAt=" + expiresAt +
                ", urlIdentifier='" + urlIdentifier + '\'' +
                '}';
    }
}
