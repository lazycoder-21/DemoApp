package lazycoder21.droid.myapplication.domain.mapper

import lazycoder21.droid.myapplication.data.remote.dto.DataDto
import lazycoder21.droid.myapplication.data.remote.dto.SupportDto
import lazycoder21.droid.myapplication.data.remote.dto.UsersDto
import lazycoder21.droid.myapplication.domain.modal.Data
import lazycoder21.droid.myapplication.domain.modal.Support
import lazycoder21.droid.myapplication.domain.modal.Users

object UserMapper {

    fun UsersDto.mapToUsers(): Users {
        return Users(
            data = data.map { it.mapToData() },
            page = page,
            perPage = perPage,
            support = supportDto.mapToSupport(),
            total = total,
            totalPages = totalPages
        )
    }

    fun DataDto.mapToData(): Data {
        return Data(
            avatar, email, firstName, id, lastName
        )
    }

    fun SupportDto.mapToSupport(): Support {
        return Support(
            text, url
        )
    }
}