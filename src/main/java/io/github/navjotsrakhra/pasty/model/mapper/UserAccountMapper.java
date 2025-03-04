package io.github.navjotsrakhra.pasty.model.mapper;

import io.github.navjotsrakhra.pasty.model.UserAccount;
import io.github.navjotsrakhra.pasty.model.request.UserAccountRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserAccountMapper {
    UserAccount toUserAccount(UserAccountRequestDto userAccount);
}
