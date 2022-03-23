#！/bin/bash

protoc --proto_path=./ --java_out=java/ proto/chat.proto
protoc --plugin=/Users/cabbage/workspace/protoc-gen-grpc-java --grpc-java_out=java/ --proto_path=./ proto/chat.proto
