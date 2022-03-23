load("@rules_java//java:defs.bzl", "java_binary", "java_library")

java_binary(
    name = "chatroom-server",
    main_class = "com.example.chatroom.HelloServer",
    runtime_deps = [
        ":chatroom-lib",
    ],
)
java_binary(
    name = "chatroom-client",
    main_class = "com.example.chatroom.HelloClient",
    runtime_deps = [
        ":chatroom-lib"
    ]
)

java_library(
    name = "chatroom-lib",
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
        "//java/com/example/chatroom/grpc/proto:proto-code-lib",
    ],
)
