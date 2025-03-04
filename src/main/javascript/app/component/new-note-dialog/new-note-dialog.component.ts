import {Component, inject} from '@angular/core';
import {
    MAT_DIALOG_DATA,
    MatDialogActions,
    MatDialogContent,
    MatDialogRef,
    MatDialogTitle
} from '@angular/material/dialog';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {FormsModule} from '@angular/forms';
import {MatButton} from '@angular/material/button';

@Component({
    selector: 'app-new-note-dialog',
    imports: [
        MatDialogTitle,
        MatFormFieldModule,
        MatInputModule,
        FormsModule,
        MatButton
    ],
    templateUrl: './new-note-dialog.component.html',
    standalone: true,
    styleUrl: './new-note-dialog.component.scss'
})
export class NewNoteDialogComponent {
    private readonly dialogRef: MatDialogRef<NewNoteDialogComponent> = inject(MatDialogRef<NewNoteDialogComponent>)
    protected url: string = inject<string>(MAT_DIALOG_DATA);

    onNoClick(): void {
        this.dialogRef.close();
    }
}
