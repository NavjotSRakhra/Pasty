import { TestBed } from '@angular/core/testing';

import { NoteEntryService } from './note-entry.service';

describe('NoteEntryService', () => {
  let service: NoteEntryService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NoteEntryService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
