import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import ru.sandbox.gcp.base.extention.androidConfig
import ru.sandbox.gcp.base.extention.kotlinJvmCompilerOptions
import ru.sandbox.gcp.base.extention.libs
import ru.sandbox.gcp.base.extention.projectJavaVersion

androidConfig {
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }

    sourceSets["main"].apply {
        manifest.srcFile("src/androidMain/AndroidManifest.xml")
        res.srcDirs("src/androidMain/res")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
kotlinJvmCompilerOptions {
    jvmTarget.set(JvmTarget.fromTarget(projectJavaVersion.toString()))
    freeCompilerArgs.add("-Xjdk-release=${projectJavaVersion}")
}
