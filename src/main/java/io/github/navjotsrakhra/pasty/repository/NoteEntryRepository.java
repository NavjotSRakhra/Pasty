package io.github.navjotsrakhra.pasty.repository;

import io.github.navjotsrakhra.pasty.model.NoteEntry;
import io.github.navjotsrakhra.pasty.model.UserAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteEntryRepository extends ListCrudRepository<NoteEntry, Long> {
    Optional<NoteEntry> findNoteEntryByUrlIdentifierAndIsDeletedIsFalse(String urlIdentifier);
    List<NoteEntry> findNoteEntriesByCreatedBy(final UserAccount createdBy);

    @Query(
            value = "UPDATE NoteEntry ne " +
                    "SET ne.isDeleted = true"
    )
    Optional<NoteEntry> deleteNoteEntryById(final Long id);
}
