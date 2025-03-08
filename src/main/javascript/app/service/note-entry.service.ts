import {Injectable} from '@angular/core';
import {NoteEntryResponse} from '../interface/note-entry-response';
import {NoteEntryRequest} from '../interface/note-entry-request';

@Injectable({
    providedIn: 'root'
})
export class NoteEntryService {
    private baseUrl: string = '/api/note' as const;

    async getNote(urlIdentifier: string): Promise<NoteEntryResponse> {
        const response = await fetch(`${this.baseUrl}/${urlIdentifier}`, {
            method: 'GET'
        });
        if (response.status === 404) {
            window.location.href = '/404'
        }
        return await response.json() as NoteEntryResponse;
    }

    async saveNote(note: NoteEntryRequest): Promise<string> {
        const response = await fetch(this.baseUrl, {
            method: 'POST',
            body: JSON.stringify(note),
            headers: {
                'Content-Type': 'application/json'
            }
        })
        let url = response.headers.get('Location');
        await response.json();
        return `${url}`;
    }
}
