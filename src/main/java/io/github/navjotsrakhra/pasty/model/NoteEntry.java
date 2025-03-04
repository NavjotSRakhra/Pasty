package io.github.navjotsrakhra.pasty.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.time.ZonedDateTime;

@Entity
public class NoteEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "note_entry_id_seq")
    @SequenceGenerator(name = "note_entry_id_seq", sequenceName = "note_entry_id_seq", allocationSize = 5)
    private Long id;

    @NotEmpty
    private String title;
    @Column(columnDefinition = "TEXT", nullable = false)
    @NotEmpty
    private String content;

    @CreationTimestamp
    private ZonedDateTime createdAt;

    @NotNull
    private ZonedDateTime expiresAt;

    @Column(unique = true, nullable = false)
    private String urlIdentifier;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserAccount createdBy;

    private boolean isDeleted;

    public NoteEntry() {
    }

    public NoteEntry(String title, String content, ZonedDateTime expiresAt, UserAccount createdBy) {
        this.title = title;
        this.content = content;
        this.expiresAt = expiresAt;
        this.createdBy = createdBy;
    }

    public NoteEntry(Long id, String title, String content, ZonedDateTime createdAt, ZonedDateTime expiresAt, String urlIdentifier, UserAccount createdBy, boolean isDeleted) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.urlIdentifier = urlIdentifier;
        this.createdBy = createdBy;
        this.isDeleted = isDeleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public UserAccount getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserAccount createdBy) {
        this.createdBy = createdBy;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return "NoteEntry{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                ", expiresAt=" + expiresAt +
                ", urlIdentifier='" + urlIdentifier + '\'' +
                ", createdBy=" + createdBy +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
