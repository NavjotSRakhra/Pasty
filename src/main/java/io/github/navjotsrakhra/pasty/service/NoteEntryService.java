package io.github.navjotsrakhra.pasty.service;

import io.github.navjotsrakhra.pasty.model.NoteEntry;
import io.github.navjotsrakhra.pasty.model.UserAccount;
import io.github.navjotsrakhra.pasty.model.mapper.NoteEntryMapper;
import io.github.navjotsrakhra.pasty.model.request.NoteRequestDto;
import io.github.navjotsrakhra.pasty.model.response.NoteResponseDto;
import io.github.navjotsrakhra.pasty.repository.NoteEntryRepository;
import io.github.navjotsrakhra.pasty.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class NoteEntryService {
    private final NoteEntryRepository noteEntryRepository;
    private final NoteEntryMapper noteEntryMapper;
    private final UserAccountRepository userAccountRepository;
    @SuppressWarnings("FieldCanBeLocal")
    private final int URL_LENGTH = 5;
    private final int DEFAULT_NOTE_EXPIRY_LENGTH_DAYS = 7;

    public NoteEntryService(NoteEntryRepository noteEntryRepository, NoteEntryMapper noteEntryMapper, UserAccountRepository userAccountRepository) {
        this.noteEntryRepository = noteEntryRepository;
        this.noteEntryMapper = noteEntryMapper;
        this.userAccountRepository = userAccountRepository;
    }

    public Optional<NoteResponseDto> getNoteEntry(String urlIdentifier) {
        Optional<NoteEntry> response = noteEntryRepository.findNoteEntryByUrlIdentifierAndIsDeletedIsFalse(urlIdentifier);
        return response.map(noteEntryMapper::noteEntryToNoteResponseDto);
    }

    public Optional<List<NoteResponseDto>> getNotesForUser(String username) {
        Optional<UserAccount> userAccount = userAccountRepository.findByUsername(username);
        return userAccount.map(account -> noteEntryRepository.findNoteEntriesByCreatedBy(account)
                .stream()
                .map(noteEntryMapper::noteEntryToNoteResponseDto)
                .toList());
    }

    public Optional<NoteResponseDto> createNote(NoteRequestDto noteRequestDto, Optional<Principal> principal) {
        var noteEntry = noteEntryMapper.noteRequestDtoToNoteEntry(noteRequestDto);
        if (noteEntry.getUrlIdentifier() == null || noteEntry.getUrlIdentifier().isEmpty()) {
            noteEntry.setUrlIdentifier(generateRandomString(URL_LENGTH));
        }

        setCreatedBy(principal, noteEntry);
        setExpiryIfNotValid(noteEntry);
        noteEntry.setDeleted(false);

        var response = this.noteEntryRepository.save(noteEntry);
        return Optional.ofNullable(noteEntryMapper.noteEntryToNoteResponseDto(response));
    }

    private void setExpiryIfNotValid(NoteEntry noteEntry) {
        if (noteEntry.getExpiresAt() == null || noteEntry.getExpiresAt().isBefore(ZonedDateTime.now())) {
            noteEntry.setExpiresAt(
                    ZonedDateTime.now()
                            .plusDays(DEFAULT_NOTE_EXPIRY_LENGTH_DAYS)
            );
        }
    }

    private void setCreatedBy(Optional<Principal> principal, NoteEntry noteEntry) {
        if (principal.isPresent()) {
            var userAccount = userAccountRepository.findByUsername(principal.get().getName());
            userAccount.ifPresent(noteEntry::setCreatedBy);
        }
    }

    private String generateRandomString(@SuppressWarnings("SameParameterValue") int length) {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = (char) (rand.nextInt(26) + 'a');
            c = rand.nextInt(2) == 0 ? Character.toUpperCase(c) : Character.toLowerCase(c);
            sb.append(c);
        }
        return sb.toString();
    }
}
