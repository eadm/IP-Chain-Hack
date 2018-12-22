package ru.nobird.android.ipchain.domain.usecase

import io.reactivex.Single
import ru.nobird.android.ipchain.data.repository.RepositoryImpl
import ru.nobird.android.ipchain.remote.model.Transaction
import javax.inject.Inject

class GetTransactionUseCase
@Inject
constructor(
    private val repositoryImpl: RepositoryImpl
) {
    operator fun invoke(trancasctionId: String, channelId: String): Single<Transaction> =
        repositoryImpl.getTransaction(trancasctionId, channelId)
}