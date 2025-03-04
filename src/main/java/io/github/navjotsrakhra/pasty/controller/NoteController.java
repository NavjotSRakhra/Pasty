package io.github.navjotsrakhra.pasty.controller;

import io.github.navjotsrakhra.pasty.model.request.NoteRequestDto;
import io.github.navjotsrakhra.pasty.model.response.NoteResponseDto;
import io.github.navjotsrakhra.pasty.service.NoteEntryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/note")
public class NoteController {

    private final NoteEntryService noteEntryService;

    public NoteController(NoteEntryService noteEntryService) {
        this.noteEntryService = noteEntryService;
    }

    @GetMapping("/{urlIdentifier}")
    public ResponseEntity<NoteResponseDto> getNote(@PathVariable String urlIdentifier) {
        var response = this.noteEntryService.getNoteEntry(urlIdentifier);
        return response.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<NoteResponseDto> createNote(@RequestBody NoteRequestDto noteRequestDto, Principal principal) {
        var response = this.noteEntryService.createNote(noteRequestDto, Optional.ofNullable(principal));
        return response.map(noteResponseDto -> ResponseEntity.created(
                        URI.create("/note/" + noteResponseDto.getUrlIdentifier()))
                .body(noteResponseDto)).orElseGet(() -> ResponseEntity
                .badRequest()
                .build());
    }
}
