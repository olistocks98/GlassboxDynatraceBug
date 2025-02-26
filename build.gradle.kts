
import com.dynatrace.tools.android.dsl.DynatraceExtension

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.dynatrace)
}


configure<DynatraceExtension> {
    configurations {
        strictMode(false)
        create("flex") {
            variantFilter("internal")

            autoStart {
                applicationId("plaxeholder")
                beaconUrl("https://placeholder.bf.dynatrace.com/mbeacon")
            }

            userOptIn(false)
            lifecycle.enabled(true)
            userActions.enabled(true)
            userActions.composeEnabled(true)
            userActions.namePrivacy(true)
            behavioralEvents.detectRageTaps(false)
            sessionReplay.enabled(false)
            locationMonitoring(false)
            crashReporting(true)
            webRequests.enabled(true)
        }
    }
}