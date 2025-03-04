package io.github.navjotsrakhra.pasty.model.mapper;

import io.github.navjotsrakhra.pasty.model.NoteEntry;
import io.github.navjotsrakhra.pasty.model.request.NoteRequestDto;
import io.github.navjotsrakhra.pasty.model.response.NoteResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NoteEntryMapper {
    NoteResponseDto noteEntryToNoteResponseDto(NoteEntry noteEntry);
    NoteEntry noteRequestDtoToNoteEntry(NoteRequestDto noteRequestDto);
}
