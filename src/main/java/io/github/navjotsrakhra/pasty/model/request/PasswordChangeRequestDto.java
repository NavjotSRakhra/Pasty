package io.github.navjotsrakhra.pasty.model.request;

public class PasswordChangeRequestDto {
    private String oldPassword;
    private String newPassword;

    public PasswordChangeRequestDto() {
    }

    public PasswordChangeRequestDto(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
