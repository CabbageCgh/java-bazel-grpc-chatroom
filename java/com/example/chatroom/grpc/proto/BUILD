load("@rules_java//java:defs.bzl", "java_binary", "java_library")


java_library(
    name = "proto-code-lib",
    srcs = glob(["*.java"]),
    visibility = ["//visibility:public"],
    deps = [
        "@maven//:io_grpc_grpc_netty_shaded",
        "@maven//:io_grpc_grpc_protobuf",
        "@maven//:io_grpc_grpc_stub",
        "@maven//:io_grpc_grpc_api",
        "@maven//:com_google_protobuf_protobuf_java",
        "@maven//:com_google_guava_guava",
        "@maven//:org_apache_tomcat_annotations_api",
        "@maven//:org_slf4j_slf4j_api",
#        "@maven//:ch_qos_logback_logback_classic",
    ],
)
