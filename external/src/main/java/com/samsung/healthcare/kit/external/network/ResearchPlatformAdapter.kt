package com.samsung.healthcare.kit.external.network

import com.samsung.healthcare.kit.external.background.HealthDataSyncClient
import com.samsung.healthcare.kit.external.data.HealthData
import com.samsung.healthcare.kit.external.data.TaskResult
import com.samsung.healthcare.kit.external.data.TaskSpec
import com.samsung.healthcare.kit.external.data.User
import com.samsung.healthcare.kit.external.network.util.RetrofitFactory
import java.time.LocalDateTime

class ResearchPlatformAdapter private constructor(
    private val networkClient: ResearchPlatformNetworkClient,
    private val projectId: String,
) : HealthDataSyncClient, UserRegistrationClient, TaskClient {

    override suspend fun sync(idToken: String, healthData: HealthData) {
        networkClient.sync(idToken, projectId, healthData)
    }

    override suspend fun registerUser(idToken: String, user: User) {
        networkClient.registerUser(idToken, projectId, user)
    }

    override suspend fun getTasks(idToken: String, lastSyncTime: LocalDateTime): List<TaskSpec> =
        networkClient.getTasks(idToken, projectId, lastSyncTime)

    override suspend fun uploadResult(idToken: String, result: TaskResult) =
        networkClient.uploadTaskResult(idToken, projectId, listOf(result))

    companion object {
        private lateinit var INSTANCE: ResearchPlatformAdapter

        fun initialize(platformEndpoint: String, researchProjectId: String) {
            synchronized(this) {
                if (::INSTANCE.isInitialized.not()) {
                    INSTANCE = ResearchPlatformAdapter(
                        RetrofitFactory.create(
                            platformEndpoint,
                            ResearchPlatformNetworkClient::class.java
                        ),
                        researchProjectId
                    )
                }
            }
        }

        fun getInstance(): ResearchPlatformAdapter = INSTANCE
    }
}
