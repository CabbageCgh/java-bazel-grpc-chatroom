load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

RULES_JVM_EXTERNAL_TAG = "4.2"
RULES_JVM_EXTERNAL_SHA = "cd1a77b7b02e8e008439ca76fd34f5b07aecb8c752961f9640dea15e9e5ba1ca"

http_archive(
    name = "rules_jvm_external",
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    sha256 = RULES_JVM_EXTERNAL_SHA,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:repositories.bzl", "rules_jvm_external_deps")
rules_jvm_external_deps()

load("@rules_jvm_external//:setup.bzl", "rules_jvm_external_setup")
rules_jvm_external_setup()

load("@rules_jvm_external//:defs.bzl", "maven_install")
maven_install(
    artifacts = [
        "junit:junit:4.12",
        "io.grpc:grpc-netty-shaded:1.42.1",
        "io.grpc:grpc-protobuf:1.42.1",
        "io.grpc:grpc-stub:1.42.1",
        "io.grpc:grpc-api:1.42.1",
        "com.google.protobuf:protobuf-java:3.19.2",
        "com.google.guava:guava:31.0.1-jre",
        "org.apache.tomcat:annotations-api:6.0.53",
        "org.slf4j:slf4j-api:1.7.35",
#        "ch.qos.logback:logback-classic:1.2.10",
    ],
    repositories = [
        "https://maven.google.com",
        "https://repo1.maven.org/maven2",
    ],
)