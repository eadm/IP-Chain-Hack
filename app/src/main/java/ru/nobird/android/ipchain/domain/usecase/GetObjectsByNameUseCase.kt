package ru.nobird.android.ipchain.domain.usecase

import io.reactivex.Single
import ru.nobird.android.ipchain.data.repository.RepositoryImpl
import ru.nobird.android.ipchain.remote.model.ObjectData
import javax.inject.Inject

class GetObjectsByNameUseCase
@Inject
constructor(
    private val repositoryImpl: RepositoryImpl
) {
    operator fun invoke(name: String): Single<List<ObjectData>> =
        repositoryImpl.getObjectsByName(name)
}