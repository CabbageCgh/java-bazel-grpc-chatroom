load("@rules_java//java:defs.bzl", "java_binary", "java_library")

java_binary(
    name = "chatroom-server",
    main_class = "com.example.chatroom.ChatRoomServer",
    runtime_deps = [
        ":chatroom-lib"
    ],
)

java_library(
    name = "chatroom-lib",
    srcs = glob(["*.java"]),
    visibility = ["//visibility:public"],
    deps = [
        "@maven//:com_google_guava_guava"
    ],
)
