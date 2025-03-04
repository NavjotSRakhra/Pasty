import {Component} from '@angular/core';
import {MatCard, MatCardContent, MatCardHeader, MatCardTitle} from '@angular/material/card';
import {MatFormField} from '@angular/material/form-field';
import {MatInput} from '@angular/material/input';
import {FormsModule} from '@angular/forms';
import {NoteEntryService} from '../../service/note-entry.service';
import {NgIf} from '@angular/common';
import {NoteEntryResponse} from '../../interface/note-entry-response';
import {ActivatedRoute} from '@angular/router';
import {CdkTextareaAutosize} from '@angular/cdk/text-field';

@Component({
    selector: 'app-note-entry',
    imports: [
        MatCard,
        MatFormField,
        MatInput,
        FormsModule,
        MatCardHeader,
        NgIf,
        CdkTextareaAutosize,
    ],
    templateUrl: './note-entry.component.html',
    standalone: true,
    styleUrl: './note-entry.component.scss'
})
export class NoteEntryComponent {

    protected note: NoteEntryResponse | undefined;
    private noteService: NoteEntryService;
    private route: ActivatedRoute;

    protected isLoaded: boolean = false;

    constructor(noteService: NoteEntryService, activatedRoute: ActivatedRoute) {
        this.route = activatedRoute;
        this.noteService = noteService;
        this.noteService.getNote(
            this.route.snapshot.params['urlIdentifier'],
        )
            .then(
                response => {
                    this.note = response;
                    this.isLoaded = true;
                }
            )
    }
}
