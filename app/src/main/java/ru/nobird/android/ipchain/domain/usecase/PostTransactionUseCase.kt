package ru.nobird.android.ipchain.domain.usecase

import io.reactivex.Single
import ru.nobird.android.ipchain.data.repository.RepositoryImpl
import ru.nobird.android.ipchain.remote.model.Transaction
import ru.nobird.android.ipchain.remote.model.TransactionRegistred
import javax.inject.Inject

class PostTransactionUseCase
@Inject
constructor(
    private val repositoryImpl: RepositoryImpl
) {
    operator fun invoke(channelId: String, transaction: Transaction): Single<TransactionRegistred> =
        repositoryImpl.postTransaction(channelId, transaction)
}