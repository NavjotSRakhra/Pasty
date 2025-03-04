import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NoteEntryFormComponent } from './note-entry-form.component';

describe('NoteEntryFormComponent', () => {
  let component: NoteEntryFormComponent;
  let fixture: ComponentFixture<NoteEntryFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NoteEntryFormComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NoteEntryFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
