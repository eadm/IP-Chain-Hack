package ru.nobird.android.ipchain.domain.usecase

import io.reactivex.Single
import ru.nobird.android.ipchain.data.repository.RepositoryImpl
import javax.inject.Inject

class GetObjectTypesUseCase
@Inject
constructor(
    private val repositoryImpl: RepositoryImpl
) {
    operator fun invoke(): Single<List<String>> =
        repositoryImpl.getObjectTypes()
}