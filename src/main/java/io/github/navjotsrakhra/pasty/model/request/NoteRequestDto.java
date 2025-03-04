package io.github.navjotsrakhra.pasty.model.request;

import java.time.ZonedDateTime;

public class NoteRequestDto {
    private String title;
    private String content;
    private ZonedDateTime expiresAt;
    private String urlIdentifier;

    public NoteRequestDto() {
    }

    public NoteRequestDto(String title, String content, ZonedDateTime expiresAt, String urlIdentifier) {
        this.title = title;
        this.content = content;
        this.expiresAt = expiresAt;
        this.urlIdentifier = urlIdentifier;
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
        return "NoteRequestDto{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", expiresAt=" + expiresAt +
                ", urlIdentifier='" + urlIdentifier + '\'' +
                '}';
    }
}
