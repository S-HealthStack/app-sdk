import org.gradle.api.artifacts.dsl.DependencyHandler

object Versions {
    const val KOTLIN = "1.6.10"
    const val ANDROID_BUILD = "7.0.4"
    const val LIFECYCLE_VIEWMODEL_COMPOSE = "2.3.0"

    object Hilt {
        const val DAGGER = "2.40.5"
        const val ANDROIDX = "1.0.0"
    }

    const val APPCOMPAT = "1.4.1"

    object Google {
        const val HEALTH_DATA = "1.0.0-alpha01"
        const val GMS = "4.3.10"
        const val FIREBASE_BOM = "30.1.0"
        const val PLAY_SERVICE_AUTH = "20.2.0"
    }

    object AndroidX {
        const val CORE = "1.6.0"
        const val CORE_KTX = "1.7.0"
        const val COMPAT = "1.4.1"
        const val WORK = "2.7.1"
        const val CONCURRENT = "1.1.0"
        const val CUSTOM_VIEW = "1.2.0-alpha01"
        const val CUSTOM_VIEW_CONTAINER = "1.0.0-alpha01"
        const val DATASTORE = "1.0.0"
        const val NAVIGATION_COMPOSE = "2.4.2"
    }

    const val RETROFIT = "2.9.0"
    const val OKHTTP = "4.5.0"
    const val SUPPORT_ANNOTATION = "28"

    const val DOKKA = "1.6.21"

    // TEST
    const val MOCKK = "1.12.3"
    const val MOCKITO = "4.0.0"
    const val RUNNER = "1.4.0"
    const val JACOCO = "0.8.7"
    const val COROUTINE = "1.6.2"

    object JUnit {
        const val EXT = "1.1.3"
        const val CORE = "5.8.1"
        const val TEST = "4.13.2"
        const val PLUGIN = "1.8.2.0"
        const val MANNODERMAUS = "1.3.0"
    }

    const val ESPRESSO = "3.4.0"
    const val DETEKT = "1.19.0"
    const val KTLINT = "10.2.0"

    // UI
    object Compose {
        const val UI = "1.2.0-alpha07"
        const val ACTIVITY = "1.4.0-rc01"
    }

    const val COIL = "2.0.0-rc02"
    const val MATERIAL_UI = "1.4.0"
    const val ACCOMPANIST_PAGER = "0.24.5-alpha"
    const val SIGNATURE_PAD = "0.0.18"
}

object AppDependencies {
    // App
    const val ANDROIDX_CORE = "androidx.core:core-ktx:${Versions.AndroidX.CORE_KTX}"
    const val ANDROIDX_COMPAT = "androidx.appcompat:appcompat:${Versions.AndroidX.COMPAT}"
    const val ANDROIDX_WORK = "androidx.work:work-runtime-ktx:${Versions.AndroidX.WORK}"
    const val ANDROIDX_CONCURRENT = "androidx.concurrent:concurrent-futures-ktx:${Versions.AndroidX.CONCURRENT}"
    const val ANDROIDX_DATASTORE = "androidx.datastore:datastore-preferences:${Versions.AndroidX.DATASTORE}"
    const val ANDROIDX_NAVIGATION_COMPOSE =
        "androidx.navigation:navigation-compose:${Versions.AndroidX.NAVIGATION_COMPOSE}"

    const val SUPPORT_ANNOTATION =
        "com.android.support:support-annotations:${Versions.SUPPORT_ANNOTATION}"

    const val HILT_DAGGER = "com.google.dagger:hilt-android:${Versions.Hilt.DAGGER}"
    const val HILT_DAGGER_COMPILER = "com.google.dagger:hilt-compiler:${Versions.Hilt.DAGGER}"
    const val HILT_ANDROIDX = "androidx.hilt:hilt-common:${Versions.Hilt.ANDROIDX}"
    const val HILT_ANDROIDX_WORK = "androidx.hilt:hilt-work:${Versions.Hilt.ANDROIDX}"
    const val HILT_ANDORIDX_COMPILER = "androidx.hilt:hilt-compiler:${Versions.Hilt.ANDROIDX}"

    const val GOOGLE_HEALTH_DATA =
        "com.google.android.libraries.healthdata:health-data-api:${Versions.Google.HEALTH_DATA}"

    val healthDataImplLibs = arrayListOf<String>().apply {
        add(ANDROIDX_WORK)
        add(GOOGLE_HEALTH_DATA)
    }

    val androidXImplLibs = arrayListOf<String>().apply {
        add(ANDROIDX_CORE)
        add(ANDROIDX_COMPAT)
        add(ANDROIDX_WORK)
        add(ANDROIDX_CONCURRENT)
    }

    val hiltImplLibs = arrayListOf<String>().apply {
        add(HILT_ANDROIDX)
        add(HILT_ANDROIDX_WORK)
        add(HILT_DAGGER)
    }

    val hiltKaptLibs = arrayListOf<String>().apply {
        add(HILT_DAGGER_COMPILER)
        add(HILT_ANDORIDX_COMPILER)
    }

    // Auth
    const val FIREBASE_BOM = "com.google.firebase:firebase-bom:${Versions.Google.FIREBASE_BOM}"
    const val FIREBASE_AUTH = "com.google.firebase:firebase-auth-ktx"
    const val PLAYSERVICE_AUTH = "com.google.android.gms:play-services-auth:${Versions.Google.PLAY_SERVICE_AUTH}"

    val authImplLibs = arrayListOf<String>().apply {
        add(FIREBASE_AUTH)
        add(PLAYSERVICE_AUTH)
    }

    // HTTP
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val RETROFIT_GSON = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
    const val OKHTTP = "com.squareup.okhttp3:okhttp:${Versions.OKHTTP}"
    const val OKHTTP_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP}"

    val httpClientImplLibs = arrayListOf<String>().apply {
        add(RETROFIT)
        add(RETROFIT_GSON)
        add(OKHTTP)
        add(OKHTTP_INTERCEPTOR)
    }

    // Docs
    const val DOCKKA = "org.jetbrains.dokka:kotlin-as-java-plugin:${Versions.DOKKA}"

    // Test
    const val RUNNER = "androidx.test:runner:${Versions.RUNNER}"
    const val JUNIT = "junit:junit:${Versions.JUnit.TEST}"
    const val JUNIT_EXT = "androidx.test.ext:junit:${Versions.JUnit.EXT}"
    const val JUNIT_API = "org.junit.jupiter:junit-jupiter-api:${Versions.JUnit.CORE}"
    const val JUNIT_PARAMS = "org.junit.jupiter:junit-jupiter-params:${Versions.JUnit.CORE}"
    const val JUNIT_ENGINE = "org.junit.jupiter:junit-jupiter-engine:${Versions.JUnit.CORE}"
    const val JUNIT_ENGINE_VINTAGE = "org.junit.vintage:junit-vintage-engine:${Versions.JUnit.CORE}"
    const val JUNIT_JUPITER = "org.junit.jupiter:junit-jupiter:${Versions.JUnit.CORE}"
    const val JUNIT_MANNO_CORE = "de.mannodermaus.junit5:android-test-core:${Versions.JUnit.MANNODERMAUS}"
    const val JUNIT_MANNO_RUNNER = "de.mannodermaus.junit5:android-test-runner:${Versions.JUnit.MANNODERMAUS}"
    const val COMPOSE_JUNIT = "androidx.compose.ui:ui-test-junit4:${Versions.Compose.UI}"
    const val COMPOSE_UI_TEST = "androidx.compose.ui:ui-test-manifest:${Versions.Compose.UI}"
    const val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"
    const val MOCKK = "io.mockk:mockk:${Versions.MOCKK}"
    const val MOCKK_ANDROID = "io.mockk:mockk-android:${Versions.MOCKK}"
    const val MOCKITO = "org.mockito:mockito-core:${Versions.MOCKITO}"
    const val COROUTINE_TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.COROUTINE}"
    const val COROUTINE_GUAVA = "org.jetbrains.kotlinx:kotlinx-coroutines-guava:${Versions.COROUTINE}"

    val testRuntimeLibs = arrayListOf<String>().apply {
        add(JUNIT_ENGINE)
        add(JUNIT_ENGINE_VINTAGE)
    }

    val testImplLibs = arrayListOf<String>().apply {
        add(MOCKK)
        add(MOCKITO)
        add(JUNIT)
        add(JUNIT_API)
        add(JUNIT_PARAMS)
    }

    val coroutineTestImplLibs = arrayListOf<String>().apply {
        add(COROUTINE_TEST)
        add(COROUTINE_GUAVA)
    }

    val androidUITestImplLibs = arrayListOf<String>().apply {
        add(COMPOSE_JUNIT)
        add(COMPOSE_UI_TEST)
    }

    val androidTestImplLibs = arrayListOf<String>().apply {
        add(RUNNER)
        add(JUNIT_API)
        add(JUNIT_JUPITER)
        add(JUNIT_EXT)
        add(MOCKK_ANDROID)
        add(JUNIT_PARAMS)
        add(JUNIT_MANNO_CORE)
        add(ESPRESSO)
    }

    // UI
    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL_UI}"
    const val COMPOSE_UI = "androidx.compose.ui:ui:${Versions.Compose.UI}"
    const val COMPOSE_RUNTIME = "androidx.compose.runtime:runtime-livedata:${Versions.Compose.UI}"
    const val COMPOSE_FOUNDATION = "androidx.compose.foundation:foundation:${Versions.Compose.UI}"
    const val COMPOSE_MATERIAL_ANDROID = "androidx.compose.material:material:${Versions.Compose.UI}"
    const val COMPOSE_MATERIAL_ANDROID_ICON = "androidx.compose.material:material-icons-core:${Versions.Compose.UI}"
    const val COMPOSE_MATERIAL_ANDROID_ICON_EXT =
        "androidx.compose.material:material-icons-extended:${Versions.Compose.UI}"
    const val COMPOSE_ACTIVITY = "androidx.activity:activity-compose:${Versions.Compose.ACTIVITY}"
    const val ACCOMPANIST_PAGER = "com.google.accompanist:accompanist-pager:${Versions.ACCOMPANIST_PAGER}"
    const val SIGNATURE = "se.warting.signature:signature-pad:${Versions.SIGNATURE_PAD}"
    const val COIL_SVG = "io.coil-kt:coil-svg:${Versions.COIL}"
    const val COIL_COMPOSE = "io.coil-kt:coil-compose:${Versions.COIL}"

    val composeImplLibs = arrayListOf<String>().apply {
        add(MATERIAL)
        add(COMPOSE_UI)
        add(COMPOSE_UI_TOOLING)
        add(COMPOSE_RUNTIME)
        add(COMPOSE_ACTIVITY)
        add(COMPOSE_FOUNDATION)
        add(COMPOSE_MATERIAL_ANDROID)
        add(COMPOSE_MATERIAL_ANDROID_ICON)
        add(COMPOSE_MATERIAL_ANDROID_ICON_EXT)
    }

    val coilImplLibs = arrayListOf<String>().apply {
        add(COIL_SVG)
        add(COIL_COMPOSE)
    }

    // UI Tools (Preview..)
    const val COMPOSE_UI_TOOLING = "androidx.compose.ui:ui-tooling:${Versions.Compose.UI}"
    const val COMPOSE_UI_MANIFEST = "androidx.compose.ui:ui-test-manifest:${Versions.Compose.UI}"
    const val ANDROIDX_COMTOM_VIEW = "androidx.customview:customview:${Versions.AndroidX.CUSTOM_VIEW}"
    const val ANDROIDX_CUSTOM_VIEW_CONTAINER =
        "androidx.customview:customview-poolingcontainer:${Versions.AndroidX.CUSTOM_VIEW_CONTAINER}"

    val uiDebugLibs = arrayListOf<String>().apply {
        add(COMPOSE_UI_MANIFEST)
        add(ANDROIDX_COMTOM_VIEW)
        add(ANDROIDX_CUSTOM_VIEW_CONTAINER)
    }
}

fun DependencyHandler.kapt(list: List<String>) =
    list.forEach { dependency ->
        add("kapt", dependency)
    }

fun DependencyHandler.implementation(list: List<String>) =
    list.forEach { dependency ->
        add("implementation", dependency)
    }

fun DependencyHandler.debugImplementation(list: List<String>) =
    list.forEach { dependency ->
        add("debugImplementation", dependency)
    }

fun DependencyHandler.testRuntimeOnly(list: List<String>) =
    list.forEach { dependency ->
        add("testRuntimeOnly", dependency)
    }

fun DependencyHandler.testImplementation(list: List<String>) =
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }

fun DependencyHandler.androidTestImplementation(list: List<String>) =
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
