To run test application use `./gradlew run` or use your IDE.

Here you can see that 'nodes().info()' method throws `JsonpMappingException`.

```shell
Caused by: co.elastic.clients.util.MissingRequiredPropertyException: Missing required property 'NodeInfoXpackSecurity.http'
	at co.elastic.clients.util.ApiTypeHelper.requireNonNull(ApiTypeHelper.java:76)
	at co.elastic.clients.elasticsearch.nodes.info.NodeInfoXpackSecurity.<init>(NodeInfoXpackSecurity.java:77)
	at co.elastic.clients.elasticsearch.nodes.info.NodeInfoXpackSecurity.<init>(NodeInfoXpackSecurity.java:62)
	at co.elastic.clients.elasticsearch.nodes.info.NodeInfoXpackSecurity$Builder.build(NodeInfoXpackSecurity.java:242)
```

If you'll try to use `ApiTypeHelper.DANGEROUS_disableRequiredPropertiesCheck(true);` exception will be different:

```shell
Caused by: co.elastic.clients.json.UnexpectedJsonEventException: Unexpected JSON event 'START_ARRAY' instead of '[KEY_NAME, VALUE_STRING, VALUE_NUMBER, VALUE_TRUE, VALUE_FALSE]'
	at co.elastic.clients.json.JsonpUtils.ensureAccepts(JsonpUtils.java:117)
	at co.elastic.clients.json.JsonpDeserializer.deserialize(JsonpDeserializer.java:76)
	at co.elastic.clients.json.ObjectDeserializer$FieldObjectDeserializer.deserialize(ObjectDeserializer.java:78)
	at co.elastic.clients.json.ObjectDeserializer.deserialize(ObjectDeserializer.java:192)
	... 30 more
```
