# java-bazel-grpc-chatroom

## proto grpc gen java code
```
protoc --proto_path=./ --java_out=java/ proto/chat.proto
protoc --plugin=/Users/cabbage/workspace/protoc-gen-grpc-java --grpc-java_out=java/ --proto_path=./ proto/chat.proto
```

## build
```
server: bazel build //java/com/example/chatroom:chatroom-server_deploy.jar
client: bazel build //java/com/example/chatroom:chatroom-client_deploy.jar
```

## run
```
server: java -jar bazel-bin/java/com/example/chatroom/chatroom-server_deploy.jar
client: java -jar bazel-bin/java/com/example/chatroom/chatroom-client_deploy.jar
```