package ru.nobird.android.ipchain.domain.usecase

import io.reactivex.Single
import ru.nobird.android.ipchain.data.repository.RepositoryImpl
import ru.nobird.android.ipchain.remote.model.ObjectDataTransactions
import javax.inject.Inject

class GetTransactionByObjectUseCase
@Inject
constructor(
    private val repositoryImpl: RepositoryImpl
) {
    operator fun invoke(objectId: String, channelId: String): Single<ObjectDataTransactions> =
        repositoryImpl.getTransactionByObject(objectId, channelId)
}