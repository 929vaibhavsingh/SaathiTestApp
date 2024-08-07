
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
}
apply<MainGradlePlugin>()

android {
    namespace = "com.saathi.features"
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }
}


dependencies {
    implementation(project(":common"))
    implementation(project(":domain"))
    implementation(Dep.coreKtx)
    implementation(Dep.lifecycleRuntime)
    implementation(Dep.coil)
    implementation(Dep.splashScreen)
    implementation(DaggerHilt.hiltNavigationCompose)
    compose()
    retrofit()
    daggerHilt()
    test()
    androidTest()
}