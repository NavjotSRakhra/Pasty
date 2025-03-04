import {Component, inject} from '@angular/core';
import {CdkTextareaAutosize} from "@angular/cdk/text-field";
import {MatCard} from "@angular/material/card";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {NoteEntryRequest} from '../../interface/note-entry-request';
import {FormsModule} from '@angular/forms';
import {MatButton} from '@angular/material/button';
import {NoteEntryService} from '../../service/note-entry.service';
import {MatDialog} from '@angular/material/dialog';
import {NewNoteDialogComponent} from '../new-note-dialog/new-note-dialog.component';

@Component({
    selector: 'app-note-entry-form',
    imports: [
        CdkTextareaAutosize,
        MatCard,
        MatFormFieldModule,
        MatInputModule,
        FormsModule,
        MatButton
    ],
    templateUrl: './note-entry-form.component.html',
    standalone: true,
    styleUrl: './note-entry-form.component.scss'
})
export class NoteEntryFormComponent {
    protected note: NoteEntryRequest;
    private noteService: NoteEntryService;
    private dialog = inject(MatDialog);

    constructor(noteService: NoteEntryService) {
        this.noteService = noteService;
        this.note = {
            'title': '',
            'content': '',
            'expiresAt': '',
            'urlIdentifier': '',
        }
    }

    createNote($event: MouseEvent) {
        this.noteService.saveNote(this.note)
            .then(
                (response: string) => {
                    console.log(response);
                    const dialogRef = this.dialog.open(NewNoteDialogComponent, {
                        data: response
                    })
                },
            )
    }
}
